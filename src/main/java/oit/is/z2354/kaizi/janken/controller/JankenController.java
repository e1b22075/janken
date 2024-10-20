package oit.is.z2354.kaizi.janken.controller;

import java.security.Principal;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import oit.is.z2354.kaizi.janken.model.Entry;
import oit.is.z2354.kaizi.janken.model.User;
import oit.is.z2354.kaizi.janken.model.UserMapper;
import oit.is.z2354.kaizi.janken.model.Match;
import oit.is.z2354.kaizi.janken.model.MatchMapper;

@Controller
public class JankenController {

  @Autowired
  private Entry room;

  @Autowired
  private UserMapper userMapper;

  @Autowired
  private MatchMapper matchMapper;

  @GetMapping("/janken")
  public String janken(Principal prin, ModelMap model) {
    ArrayList<User> user = userMapper.selectAllByUserName();
    model.addAttribute("user", user);

    ArrayList<Match> match = matchMapper.selectAllByResult();
    model.addAttribute("match", match);

    String loginUser = prin.getName(); // ログインユーザ情報
    model.addAttribute("login_user", loginUser);
    this.room.addUser(loginUser);
    model.addAttribute("room", this.room);

    return "janken.html";
  }

  @GetMapping("/janken/{you}")
  public String janken2(@PathVariable String you, ModelMap model) {
    String score = you;
    model.addAttribute("score", score);
    return "janken.html";
  }

}
