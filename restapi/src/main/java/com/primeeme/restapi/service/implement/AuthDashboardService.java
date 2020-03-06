package com.primeeme.restapi.service.implement;

import com.primeeme.restapi.model.bo.AuthDashboard;

import java.util.List;

public interface AuthDashboardService {

  List<Integer> selectAllId();

  AuthDashboard selectOneById(int id);
}
