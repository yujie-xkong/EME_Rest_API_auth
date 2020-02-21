package com.primeeme.restapi.mapper;

import com.primeeme.restapi.model.auth.Authorization;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface AuthorizationMapper {

  @Select("select * from [EME].[AUTHORIZATION] where AuthorizationID = #{id};")
  Authorization selectAuthorizationById(@Param("id") int id);

  @Options(useGeneratedKeys = true, keyProperty = "AuthorizationID")
  @Insert("insert into [EME].[AUTHORIZATION] (ProjectCompanyJobID, CreatedByUserAccountID, AuthorizationCode, Created, TestReasonID, AuthorizationComment) values" +
      "(#{ProjectCompanyJobID}, #{CreatedByUserAccountID}, #{AuthorizationCode}, #{Created}, #{TestReasonID} , #{AuthorizationComment})")
  void addAuth(Authorization authorization);
}

