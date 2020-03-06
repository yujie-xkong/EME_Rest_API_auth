package com.primeeme.restapi.mapper;

import com.primeeme.restapi.model.bo.AuthDashboard;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface AuthDashboardMapper {

  @Select("")
  AuthDashboard selectOneById(int id);

  @Select("")
  List<Integer> selectAllId();
}
