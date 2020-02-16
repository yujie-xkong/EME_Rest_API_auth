package com.primeeme.restapi.mapper;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface TestReasonMapper {

  @Select("select TestReasonID from [EME].[TestReason] where TestReasonName = #{TestReasonName} limit 1")
  int selectIdByName (String TestReasonName);
}
