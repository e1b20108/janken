package oit.is.z0820.kaizi.janken.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Sample21Controller
 *
 * クラスの前に@Controllerをつけていると，HTTPリクエスト（GET/POSTなど）があったときに，このクラスが呼び出される
 */
@Controller
public class JankenController {

  @GetMapping("/janken")
  public String janken() {
    return "janken.html";
  }

  @PostMapping("/janken")
  public String nyusitu(@RequestParam String uname, ModelMap model) {
    String unameResult = uname;
    model.addAttribute("unameResult", unameResult);
    return "janken.html";
  }

  @GetMapping("/jankengame")
  public String jankengame(@RequestParam String hand, ModelMap model) {
    String a = "gu", b = "tyoki", c = "pa";
    String w = "win", d = "draw", l = "lose";
    model.addAttribute("zibun", hand);
    model.addAttribute("aite", a);
    if (hand.equals(a)) {
      model.addAttribute("syouhai", d);
    }
    if (hand.equals(b)) {
      model.addAttribute("syouhai", l);
    }
    if (hand.equals(c)) {
      model.addAttribute("syouhai", w);
    }
    return "janken.html";
  }

}
