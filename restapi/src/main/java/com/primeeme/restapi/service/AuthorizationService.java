package com.primeeme.restapi.service;

import com.primeeme.restapi.model.auth.Authorization;

public interface AuthorizationService  {

  Authorization selectAuthById(int id) ;
}
