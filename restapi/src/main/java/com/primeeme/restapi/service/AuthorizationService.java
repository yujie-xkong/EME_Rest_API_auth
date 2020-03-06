package com.primeeme.restapi.service;

import com.primeeme.restapi.exception.UnicomRuntimeException;
import com.primeeme.restapi.model.auth.Authorization;
import com.primeeme.restapi.model.bo.AuthCreateRequest;

import java.sql.SQLException;

public interface AuthorizationService  {

  Authorization selectAuthById(int id) throws Exception;

  int createAuth(AuthCreateRequest authCreateRequest) throws Exception;


}
