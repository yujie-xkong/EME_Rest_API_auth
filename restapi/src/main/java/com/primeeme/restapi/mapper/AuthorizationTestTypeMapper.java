package com.primeeme.restapi.mapper;

import com.primeeme.restapi.model.auth.Authorization;
import com.primeeme.restapi.model.auth.AuthorizationTestType;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface AuthorizationTestTypeMapper {

  @Select("select * from [EME].[AuthorizationTestType] where AuthorizationID = #{id};")
  Authorization selectAuthorizationTestTypeById(@Param("id") int id);

  @Options(useGeneratedKeys = true, keyProperty = "AuthorizationTestTypeID")
  @Insert("insert into [EME].[AuthorizationTestType] (AuthorizationID, TestTypeID, Active, Created, CreatedByUserAccountID) values" +
      "(#{AuthorizationID}, #{TestTypeID}, #{Active}, #{Created}, #{CreatedByUserAccountID} )")
  void addAuthTestType(AuthorizationTestType authorizationTestType);
}
