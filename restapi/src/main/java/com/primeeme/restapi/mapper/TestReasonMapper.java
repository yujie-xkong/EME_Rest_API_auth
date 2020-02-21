package com.primeeme.restapi.mapper;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface TestReasonMapper {

  @Select("select TOP(1) TestReasonID from [EME].[TestReason] where TestReasonName = #{TestReasonName} ")
  int selectIdByName (String TestReasonName);
}
