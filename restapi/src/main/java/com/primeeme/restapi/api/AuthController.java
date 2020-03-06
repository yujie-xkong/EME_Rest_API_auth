package com.primeeme.restapi.api;

import com.alibaba.fastjson.JSONObject;
import com.primeeme.restapi.exception.UnicomRuntimeException;
import com.primeeme.restapi.model.code.ResponseBean;
import com.primeeme.restapi.model.bo.AuthCreateRequest;
import com.primeeme.restapi.model.code.ErrorCode;
import com.primeeme.restapi.service.AuthorizationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@Slf4j
public class AuthController {

  @Autowired
  private AuthorizationService authorizationService;

  @GetMapping("/Authorization/v1/getAuthorization")
  public ResponseEntity<ResponseBean> getContactById(@RequestParam("id") Integer id) throws Exception{

      return new ResponseEntity<ResponseBean>(ResponseBean.builder()
          .code(ErrorCode.SUCCESS_OPTION.getCode())
          .msg(ErrorCode.SUCCESS_OPTION.getMsg())
          .data(JSONObject.toJSONString(authorizationService.selectAuthById(id))).build(), HttpStatus.OK);

  }

  @PostMapping(path = "/Authorization/v1/addAuthorization", consumes = "application/json", produces = "application/json")
  public ResponseEntity<ResponseBean> authorizationCreate(@RequestBody AuthCreateRequest authCreateRequest) {
    int response = 0;
    try {
      response = authorizationService.createAuth(authCreateRequest);
    } catch (Exception e) {
      e.printStackTrace();
      return new ResponseEntity<ResponseBean>(ResponseBean.builder()
          .code(ErrorCode.BAD_REQUEST.getCode())
          .msg(ErrorCode.BAD_REQUEST.getMsg())
          .data(response + "").build(),HttpStatus.BAD_REQUEST);
    }
    return new ResponseEntity<ResponseBean>(ResponseBean.builder()
        .code(ErrorCode.SUCCESS_OPTION.getCode())
        .msg(ErrorCode.SUCCESS_OPTION.getMsg())
        .data(response + "").build(),HttpStatus.OK);
  }
}
