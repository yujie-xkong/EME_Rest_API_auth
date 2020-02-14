package com.primeeme.restapi.api;

import com.primeeme.restapi.model.Contact;
import com.primeeme.restapi.model.auth.Authorization;
import com.primeeme.restapi.service.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

  @Autowired
  private AuthorizationService authorizationService;

  @GetMapping("/Authorization/v1/getAuthorization")
  public Authorization getContactById(@RequestParam("id") Integer id){
    return authorizationService.selectAuthById(id);
  }

}
