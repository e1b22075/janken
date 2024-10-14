package oit.is.z2354.kaizi.janken.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import oit.is.z2354.kaizi.janken.model.Entry;

@Controller
public class JankenController {

  @Autowired
  private Entry entry;

  @GetMapping("/janken")
  public String sample21() {
    return "janken.html";
  }

  @PostMapping("/janken")
  public String janken(Principal prin, ModelMap model) {
    String loginUser = prin.getName(); // ログインユーザ情報
    model.addAttribute("login_user", loginUser);
    this.entry.addUser(loginUser);
    model.addAttribute("entry", this.entry);
    return "janken.html";
  }

  @GetMapping("/janken/{you}")
  public String janken2(@PathVariable String you, ModelMap model) {
    String score = you;
    model.addAttribute("score", score);
    return "janken.html";
  }

}
