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

  @GetMapping("/Janken/{param1}")
  public String janken2(@PathVariable String param1, ModelMap model) {

    // ModelMap型変数のmodelにtasuResult1という名前の変数で，tasuResultの値を登録する．
    // ここで値を登録するとthymeleafが受け取り，htmlで処理することができるようになる
    model.addAttribute("name", param1);
    return "janken.html";

  }

}
