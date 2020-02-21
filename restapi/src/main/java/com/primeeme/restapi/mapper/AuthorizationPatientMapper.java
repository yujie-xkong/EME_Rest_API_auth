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
  void addAuthPatient(AuthorizationPatient authorizationPatient);
}
