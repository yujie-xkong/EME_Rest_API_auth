package com.primeeme.restapi.model.code;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // 生成 getter/setter/equals/canEqual/hashCode/toString
@NoArgsConstructor  // 为类提供一个无参的构造方法
@AllArgsConstructor // 为类提供一个全参的构造方法
@Builder
public class ResponseBean {
  @JsonProperty("code")
  int code;
  @JsonProperty("msg")
  String msg;
  @JsonProperty("data")
  String data;
}
