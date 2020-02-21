package com.primeeme.restapi.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface TestTypeMapper {

  @Select(
      {"<script>" +
      "select TestTypeID from [EME].[TestType] where TestTypeName in " +
      "<foreach collection='testTypeNames' item='tn' open='(' separator=',' close=')'>",
      "#{tn}",
      "</foreach>",
      "</script>"
      }
  )
  List<Integer> selectIdByNames(@Param("testTypeNames") List<String> testTypeNames);
}
