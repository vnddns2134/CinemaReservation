package com.web.p7; //컨트롤러
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Controller;
 import org.springframework.ui.Model;
 import org.springframework.web.bind.annotation.GetMapping;
 import org.springframework.web.servlet.mvc.support.RedirectAttributes;
 import jakarta.servlet.http.HttpSession;

 @Controller
 public class VanController {
    @Autowired
    private MemberRepository mrep;

    @GetMapping("/member/list")
    public String memberList(Model mo) {
    mo.addAttribute("arr",mrep.findAll());
    return "memberList";
    }

    @GetMapping("/login")
    public String login() {
    return "login";
    }

    @GetMapping("/member/register")
    public String memberRegister() {
      return "memberRegister";
    }

    @GetMapping("/member/insert")
    public String memberInsert(String id, String pw, String name, String phone, RedirectAttributes re) {
      if ( mrep.existsById(id)) {
         re.addAttribute("msg", id+"는 이미 사용되고 있는 아이디입니다.");
         re.addAttribute("url", "back");
      }
      else {
         Member me = new Member();
         me.id = id; me.password = password; me.username = username; me.email = email;
         mrep.save(me);

         re.addAttribute("msg", id+"님, 환영합니다.");
         re.addAttribute("url", "/login");
      }
      return "redirect:/popup";
    }

    @GetMapping("/popup")
    public String popup(String msg, String url, Model mo) {
      mo.addAttribute("msg", msg);
      mo.addAttribute("url", url);
      return "popup";
    }

    @GetMapping("/login/check")
    public String loginCheck(HttpSession se, String id, Model mo, RedirectAttributes re) {
      if(mrep.existsById(id)) {
         se.setAttribute("id", id);
         return "redirect:/menu";
      }
      else {
         re.addAttribute("msg", id+"는 미등록 아이디입니다. 확인 후 로그인 부탁드립니다.");
         re.addAttribute("url", "/login");
         return "redirect:/popup";
      }
    }

    @GetMapping("/menu")
    public String menu(HttpSession se, Model mo) {
      mo.addAttribute("id", se.getAttribute("id"));
      return "menu";
    }

    @GetMapping("/myinfo")
    public String myinfo(HttpSession se, Model mo) {
      String id = (String)se.getAttribute("id");
      Member me = mrep.findById(id).get();
      mo.addAttribute("me",me);
      return "myinfo";
    }

    @GetMapping("/myinfo/update")
    public String myinfoUpdate(HttpSession se, String password, String username, String email, RedirectAttributes re) {
      String id = (String)se.getAttribute("id");
      if(mrep.updateMember(id, password, username, email) == 0)
         re.addAttribute("msg", "정보 변경 실패. 고객센터로 문의하세요.");
      else
         re.addAttribute("msg", id+"님의 정보가 변경되었습니다.");
      
      re.addAttribute("url", "back");
      return "redirect:/popup";
    }

    @GetMapping("/cinemainfo")
    public String cinemainfo(Model mo) {
      long a = mrep.countMember();
      mo.addAttribute("mcount", fo.format(a)+"명");
      return "cinemainfo";
    }

    @GetMapping("/logout")
    public String logout(HttpSession se, Model mo) {
      mo.addAttribute("id", se.getAttribute("id"));
      se.invalidate();
      return "redirect/menu";
    }