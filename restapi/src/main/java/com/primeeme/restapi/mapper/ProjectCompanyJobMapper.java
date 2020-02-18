package com.primeeme.restapi.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ProjectCompanyJobMapper {

  @Select("select ProjectCompanyJobID from [EME].[ProjectCompanyJob where jobNumber = #{jobNumber} limit 1")
  int selectIdByjobNumber(@Param("jobNumber") String jobNumber);
}
