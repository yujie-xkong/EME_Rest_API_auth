package com.primeeme.restapi.mapper;

import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface AuthorizationPatientMapper {

  @Update("update [EME].[AuthorizationPatient] set ")
  void update();
}
