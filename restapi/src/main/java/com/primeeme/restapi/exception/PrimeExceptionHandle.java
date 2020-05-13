package com.primeeme.restapi.exception;


import javax.servlet.http.HttpServletRequest;

import com.primeeme.restapi.model.code.ErrorCode;
import com.primeeme.restapi.model.code.ResponseBean;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.binding.BindingException;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.net.ConnectException;
import java.sql.SQLException;

@RestControllerAdvice(annotations={RestController.class,Controller.class})
@Slf4j
public class PrimeExceptionHandle {

  /**
   * 请求参数类型错误异常的捕获
   *
   * @param e
   * @return
   */
  @ExceptionHandler(value = {BindException.class})
  @ResponseBody
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ResponseBean badRequest(BindException e) {
    log.error("occurs error when execute method ,message {}", e.getMessage());
    return new ResponseBean(ErrorCode.BAD_REQUEST.getCode(), ErrorCode.BAD_REQUEST.getMsg(), "");
  }

  /**
   * 404错误异常的捕获
   *
   * @param e
   * @return
   */
  @ExceptionHandler(value = {NoHandlerFoundException.class})
  @ResponseBody
  @ResponseStatus(value = HttpStatus.NOT_FOUND)
  public ResponseBean badRequestNotFound(NoHandlerFoundException e) {
    log.error("occurs error when execute method ,message {}", e.getMessage());
    return new ResponseBean(ErrorCode.NOT_FOUND.getCode(), ErrorCode.NOT_FOUND.getMsg(), "");
  }

  /**
   * mybatis未绑定异常
   *
   * @param e
   * @return
   */
  @ExceptionHandler(value={BindingException.class,SQLException.class,DataAccessException.class})
  @ResponseBody
  @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
  public ResponseBean mybatis(Exception e) {
    log.error("occurs error when execute method ,message {}", e.getMessage());
    return new ResponseBean(ErrorCode.DATABASE_ERROR.getCode(), ErrorCode.DATABASE_ERROR.getMsg(), "");
  }

  /**
   * 自定义异常的捕获
   * 自定义抛出异常。统一的在这里捕获返回JSON格式的友好提示。
   *
   * @param exception
   * @param request
   * @return
   */
  @ExceptionHandler(value = {UnicomRuntimeException.class})
  @ResponseBody
  @ResponseStatus(value = HttpStatus.OK)
  public ResponseBean sendError(UnicomRuntimeException exception, HttpServletRequest request) {
    String requestURI = request.getRequestURI();
    log.error("occurs error when execute url ={} ,message {}", requestURI, exception.getMsg());
    return new ResponseBean(exception.getCode(),exception.getMsg(), exception.getData());
  }

  /**
   * 网络连接失败！
   *
   * @param e
   * @return
   */
  @ExceptionHandler(value = {ConnectException.class})
  @ResponseBody
  @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
  public ResponseBean connect(Exception e) {
    log.error("occurs error when execute method ,message {}", e.getMessage());
    return new ResponseBean(ErrorCode.CONNECTION_ERROR.getCode(), ErrorCode.CONNECTION_ERROR.getMsg(), "");
  }

  @ExceptionHandler(value = {Exception.class})
  @ResponseBody
  @ResponseStatus(value = HttpStatus.OK)
  public ResponseBean notAllowed(Exception e) {
    log.error("occurs error when execute method ,message {}", e.getMessage());
    return new ResponseBean(ErrorCode.SYSTEM_ERROR.getCode(), ErrorCode.SYSTEM_ERROR.getMsg(), "");
  }

}