package com.primeeme.restapi.service;

import com.primeeme.restapi.model.auth.Authorization;
import com.primeeme.restapi.model.bo.AuthCreateRequest;

public interface AuthorizationService  {

  Authorization selectAuthById(int id) ;

  int createAuth(AuthCreateRequest authCreateRequest) throws Exception;
}
