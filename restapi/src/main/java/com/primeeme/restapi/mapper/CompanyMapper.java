package com.primeeme.restapi.mapper;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface CompanyMapper {

  @Select("select companyId from [EME].[Company] where CompanyName = #{companyName}")
  int selectIdByName(String companyName);
}
