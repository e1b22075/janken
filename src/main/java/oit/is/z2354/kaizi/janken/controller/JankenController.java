package oit.is.z2354.kaizi.janken.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class JankenController {

  @GetMapping("/janken")
  public String sample21() {
    return "janken.html";
  }

  @PostMapping("/janken")
  public String janken(@RequestParam String janken, ModelMap model) {
    String name = janken;

    model.addAttribute("name", name);
    return "janken.html";
  }

  @GetMapping("/janken/{you}")
  public String janken2(@PathVariable String you, ModelMap model) {
    String score = you;
    model.addAttribute("score", score);
    return "janken.html";
  }

}
