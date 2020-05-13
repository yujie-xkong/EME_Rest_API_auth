package com.example.eme_oauth_frontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("eme")
public class WebController {

  @GetMapping("dashboard")
  public String dash () {
    return "dashboard";
  }

  @GetMapping("new-authorization")
  public String newAuthorization () {
    return "new_authorization";
  }
}
