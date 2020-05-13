package com.primeeme.restapi.service.implement;

import com.primeeme.restapi.mapper.AuthDashboardMapper;
import com.primeeme.restapi.model.bo.AuthDashboard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AuthDashboardServiceImpl implements AuthDashboardService {

  @Autowired
  AuthDashboardMapper authDashboardMapper;

  @Override
  public List<Integer> selectAllId() {
    return authDashboardMapper.selectAllId();
  }

  @Cacheable(value = "Dashboard",key="'authPatient-'+#id", unless="#result == null")
  @Override
  public AuthDashboard selectOneById(int id) {
    return authDashboardMapper.selectOneById(id);
  }

  @Scheduled(cron = "0 0 3 * * ?")
  public void cacheAll() {
    for (int id: selectAllId()) {
      selectOneById(id);
    }
  }
}
