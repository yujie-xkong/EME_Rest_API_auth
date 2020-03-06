package com.primeeme.restapi.exception;

import com.primeeme.restapi.model.code.ErrorCode;

public class UnicomRuntimeException extends RuntimeException {
  private static final long serialVersionUID = 1L;
  protected int code;

  protected String msg;

  protected String data;//打印出的日志信息

  public UnicomRuntimeException(ErrorCode enums, String data) {
    super();
    this.code = enums.getCode();
    this.msg = enums.getMsg();
    this.data = data;
  }

  public UnicomRuntimeException(ErrorCode enums) {
    super();
    this.code = enums.getCode();
    this.msg = enums.getMsg();
  }


  public int getCode() {
    return code;
  }


  public void setCode(int code) {
    this.code = code;
  }


  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  public String getData() {
    return this.data;
  }

  public void setData(String message) {
    this.data = message;
  }




  public UnicomRuntimeException() {
    super();
  }

  public UnicomRuntimeException(String message, Throwable cause) {
    super(message, cause);
  }

  public UnicomRuntimeException(String message) {
    super(message);
  }

}
