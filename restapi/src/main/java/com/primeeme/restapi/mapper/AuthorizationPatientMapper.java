package com.primeeme.restapi.mapper;

import com.primeeme.restapi.model.auth.AuthorizationPatient;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface AuthorizationPatientMapper {

  @Update("update [EME].[AuthorizationPatient] set ")
  void update();

  @Options(useGeneratedKeys = true, keyProperty = "AuthorizationPatientID")
  @Insert("insert into [EME].[AuthorizationPatient] (AuthorizationID, PatientID, ClinicCompanyID, Active, Created, PurchaseOrder, AuthorizationPatientStatusID, StatusDate, NotesClosed, IsLocked) values" +
      "(#{AuthorizationID}, #{PatientID}, #{ClinicCompanyID}, #{Active}, #{Created}, #{PurchaseOrder}, #{AuthorizationPatientStatusID}, #{StatusDate}, #{NotesClosed}, #{IsLocked})")
  int addAuthPatient(AuthorizationPatient authorizationPatient);

  @Update("update [EME].[AuthorizationPatient] set AuthorizationPatientStatusID = #{AuthorizationPatientStatusID}, StatusDate = now() where AuthorizationPatientID = #{AuthorizationPatientID}")
  int AuthorizationPatientStatus(int AuthorizationPatientStatusID, int AuthorizationPatientID );
}


/* select t1.AuthorizationPatientID, t4.firstname, t4.lastname, t4.dob, t3.jobnumber, t7.testReason, t5.companyname, t6.status, t1.StatusDate
    from AuthorizationPatient as t1, Authorization as t2, projectcomanpy as t2,  patient as t3, contact as t4, company as t5, AuthorizationPatientStatus as t6, TestReason as t7 where
    t1.AuthorizationPatientID = t2.AuthorizationID and t2.ProjectCompanyJobID = t3.ProjectCompanyJobID  and t1.PatientID = t3.PatientID and
    t3.contactID = t4.contactID and t1.ClinicCompanyID = t5.company.companyID and t1.AuthorizationPatientStatusID = t6.AuthorizationPatientStatusID and t2.TestReasonID = t7.TestReasonID
    */