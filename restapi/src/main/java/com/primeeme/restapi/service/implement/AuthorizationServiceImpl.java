package com.primeeme.restapi.service.implement;

import com.primeeme.restapi.mapper.AuthorizationMapper;
import com.primeeme.restapi.model.auth.Authorization;
import com.primeeme.restapi.service.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationServiceImpl implements AuthorizationService {

  @Autowired
  AuthorizationMapper authorizationMapper;

  @Override
  public Authorization selectAuthById(int id) {
    return authorizationMapper.selectAuthorizationById(id);
  }
}
