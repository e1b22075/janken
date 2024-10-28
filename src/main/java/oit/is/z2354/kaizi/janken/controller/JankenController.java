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
import oit.is.z2354.kaizi.janken.model.MatchInfoMapper;
import oit.is.z2354.kaizi.janken.model.MatchInfo;

@Controller
public class JankenController {

  @Autowired
  private Entry room;

  @Autowired
  private UserMapper userMapper;

  @Autowired
  private MatchMapper matchMapper;

  @Autowired
  private MatchInfoMapper matchinfoMapper;

  @GetMapping("/janken")
  public String janken(Principal prin, ModelMap model) {
    ArrayList<User> user = userMapper.selectAllByUserName();
    model.addAttribute("user", user);

    ArrayList<Match> match = matchMapper.selectAllByResult();
    model.addAttribute("match", match);

    ArrayList<MatchInfo> matchinfo = matchinfoMapper.selectAllByActive();

    String loginUser = prin.getName(); // ログインユーザ情報
    model.addAttribute("login_user", loginUser);
    this.room.addUser(loginUser);
    model.addAttribute("room", this.room);
    model.addAttribute("matchinfo", matchinfo);
    return "janken.html";
  }

  @GetMapping("/fight")
  public String janken2(@RequestParam Integer id, @RequestParam String you, Principal prin, ModelMap model) {
    int id1;
    MatchInfo match = new MatchInfo();
    match.setUser1Hand(you);
    match.setUser2(id);
    match.setIsActive(true);
    String loginUser = prin.getName(); // ログインユーザ情報
    model.addAttribute("login_user", loginUser);
    String user1 = loginUser;

    id1 = userMapper.selectname(user1);

    match.setUser1(id1);

    matchinfoMapper.insertChamber(match);
    String score = you;
    model.addAttribute("score", score);
    return "wait.html";
  }

  @GetMapping("/match")
  public String match(@RequestParam Integer id, Principal prin, ModelMap model) {

    User user = userMapper.selectAll(id);
    model.addAttribute("user", user);

    String loginUser = prin.getName(); // ログインユーザ情報
    model.addAttribute("login_user", loginUser);

    return "match.html";

  }

}
