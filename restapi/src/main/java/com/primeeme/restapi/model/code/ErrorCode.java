package com.primeeme.restapi.model.code;


public enum ErrorCode {

  SYSTEM_ERROR(1,"系统异常"),
  BAD_REQUEST(2,"错误的请求参数"),
  NOT_FOUND(3,"找不到请求路径"),
  CONNECTION_ERROR(4,"网络连接请求失败！"),
  METHOD_NOT_ALLOWED(5,"不合法的请求方式"),
  BOUND_STATEMENT_NOT_FOUNT(6,"找不到方法"),
  SUCCESS_OPTION(7,"请求成功"),
  DATABASE_ERROR(8,"数据库异常"),
  NO_PERMISSION(9,"TOKEN验证失败"),
  INVALID_MOBILE(10,"无效AUTHORIZATIONID"),
  ILLEGAL_ARGUMENT(11,"参数不合法");


  private int code;
  private String msg;
  private ErrorCode(int code, String msg) {

    this.code = code;
    this.msg = msg;
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



}
