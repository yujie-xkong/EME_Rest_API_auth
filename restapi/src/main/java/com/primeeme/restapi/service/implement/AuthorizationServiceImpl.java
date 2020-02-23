package com.primeeme.restapi.service.implement;

import com.primeeme.restapi.mapper.*;
import com.primeeme.restapi.model.auth.Authorization;
import com.primeeme.restapi.model.auth.AuthorizationPatient;
import com.primeeme.restapi.model.auth.AuthorizationTestType;
import com.primeeme.restapi.model.bo.AdditionalInfo;
import com.primeeme.restapi.model.bo.AuthCreateRequest;
import com.primeeme.restapi.model.bo.JobInfo;
import com.primeeme.restapi.service.AuthorizationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class AuthorizationServiceImpl implements AuthorizationService {

  @Autowired
  AuthorizationMapper authorizationMapper;

  @Autowired
  AuthorizationPatientMapper authorizationPatientMapper;

  @Autowired
  AuthorizationTestTypeMapper authorizationTestTypeMapper;

  @Autowired
  ProjectCompanyJobMapper projectCompanyJobMapper;

  @Autowired
  TestReasonMapper testReasonMapper;

  @Autowired
  CompanyMapper companyMapper;

  @Autowired
  TestTypeMapper testTypeMapper;

  @Cacheable(cacheNames = "auth" ,key = "#root.methodName+'['+#id+']'")
  @Override
  public Authorization selectAuthById(int id) {
    log.info("" + authorizationMapper.selectAuthorizationById(id));
    return authorizationMapper.selectAuthorizationById(id);
  }

  @Override
  public int createAuth(AuthCreateRequest authCreateRequest) throws Exception {

    JobInfo jobInfo = authCreateRequest.getJobInfo();
    AdditionalInfo additionalInfo = authCreateRequest.getAdditionalInfo();

    int projectCompanyJobId = projectCompanyJobMapper.selectIdByjobNumber(jobInfo.getJobNumber());
    int testReasonId = testReasonMapper.selectIdByName(jobInfo.getTestReason());
    OffsetDateTime utc = OffsetDateTime.now(ZoneOffset.UTC);

    Authorization authorization = Authorization.builder()
        .Created(Date.from(utc.toInstant()))
        .AuthorizationCode(UUID.randomUUID().toString())
        .ProjectCompanyJobID(projectCompanyJobMapper.selectIdByjobNumber(jobInfo.getJobNumber()))
        .TestReasonID(testReasonMapper.selectIdByName(jobInfo.getTestReason()))
        .CreatedByUserAccountID(9)
        .build();

    if (additionalInfo != null) {
      authorization.setAuthorizationComment(additionalInfo.getPurchaseOrder());
    }

    //insert auth
    authorizationMapper.addAuth(authorization);
    log.info(""+authorization);


    List<String> patientIds = authCreateRequest.getEmployees().getPatientID();
    for (String id : patientIds) {
      AuthorizationPatient authorizationPatient = AuthorizationPatient.builder()
          .AuthorizationID(authorization.getAuthorizationID())
          .PatientID(Integer.valueOf(id))
          .ClinicCompanyID(companyMapper.selectIdByName(jobInfo.getFacility()))
          .Active(true)
          .Created(Date.from(utc.toInstant()))
          .PurchaseOrder(additionalInfo.getPurchaseOrder())
          .AuthorizationPatientStatusID((short) 1)
          .StatusDate(Date.from(utc.toInstant()))
          .NotesClosed(false)
          .IsLocked(false)
          .CreatedByUserAccountID(9)
          .build();
      // insert authpatient
      authorizationPatientMapper.addAuthPatient(authorizationPatient);

    }

    List<Integer> testTypeIds = testTypeMapper.selectIdByNames(authCreateRequest.getServices());
    for (Integer id : testTypeIds) {
      AuthorizationTestType authorizationTestType = AuthorizationTestType.builder()
          .AuthorizationID(authorization.getAuthorizationID())
          .TestTypeID(id)
          .Active(true)
          .Created(Date.from(utc.toInstant()))
          .CreatedByUserAccountID(9)
          .build();
      // insert authorizationTestType
      authorizationTestTypeMapper.addAuthTestType(authorizationTestType);
    }


    return 0;
  }
}
