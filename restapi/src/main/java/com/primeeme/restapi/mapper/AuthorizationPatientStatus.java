package com.primeeme.restapi.mapper;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface AuthorizationPatientStatus  {

  @Select("select AuthorizationPatientStatusID from [EME].[AuthorizationPatientStatus] where status = #{status}")
  int selectIdBystatus(String status);


}
