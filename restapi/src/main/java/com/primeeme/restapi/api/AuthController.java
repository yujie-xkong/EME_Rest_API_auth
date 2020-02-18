package com.primeeme.restapi.api;

import com.primeeme.restapi.model.Contact;
import com.primeeme.restapi.model.auth.Authorization;
import com.primeeme.restapi.model.bo.AuthCreateRequest;
import com.primeeme.restapi.service.AuthorizationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class AuthController {

  @Autowired
  private AuthorizationService authorizationService;

  @GetMapping("/Authorization/v1/getAuthorization")
  public Authorization getContactById(@RequestParam("id") Integer id){
    return authorizationService.selectAuthById(id);
  }

  @PostMapping(path = "/fcapi/data", consumes = "application/json", produces = "application/json")
  public String authorizationCreate(@RequestBody AuthCreateRequest authCreateRequest) {
    log.info("received mzEncryptRequest data {}", authCreateRequest.toString());



    return "1";
  }
}
