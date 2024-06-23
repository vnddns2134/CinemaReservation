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
    
    @Autowired
    private MovieRepository morep;

    @GetMapping("/login") //로그인
    public String login() {
    return "login";
    }

    @GetMapping("/logup") //회원가입
    public String logup() {
      return "logup";
    }

    @GetMapping("/logup/insert") //회원가입 세부사항
    public String logupInsert(String id, String pw, String name, String phone, RedirectAttributes re) {
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

    @GetMapping("/popup") //리다이렉션에 필요한 팝업
    public String popup(String msg, String url, Model mo) {
      mo.addAttribute("msg", msg);
      mo.addAttribute("url", url);
      return "popup";
    }

    @GetMapping("/login/check") //로그인 시 데이터베이스와 대조
    public String loginCheck(HttpSession se, String id, Model mo, RedirectAttributes re) {
      if(mrep.existsById(id)) {
         se.setAttribute("id", id);
         return "redirect:/home";
      }
      else {
         re.addAttribute("msg", id+"는 미등록 아이디입니다. 확인 후 로그인 부탁드립니다.");
         re.addAttribute("url", "/login");
         return "redirect:/popup";
      }
    }

    @GetMapping("/home") //메인화면
    public String menu(HttpSession se, Model mo) {
      mo.addAttribute("id", se.getAttribute("id"));
      return "home";
    }

    @GetMapping("/member") //관리자페이지
    public String member(HttpSession se, Model mo) {
      mo.addAttribute("id", se.getAttribute("id"));
      mo.addAttribute("arr",mrep.findAll());
      return "member";
    }

    @GetMapping("/movieList") //영화목록
    public String movieList(HttpSession se, Model mo) {
      mo.addAttribute("id", se.getAttribute("id"));
      return "movieList";
    }

    @GetMapping("/cinema") // 극장선택
    public String cinema(HttpSession se, Model mo) {
      mo.addAttribute("id", se.getAttribute("id"));
      return "cinema";
    }
  
    @GetMapping("/booking") // 예매
    public String booking(HttpSession se, Model mo) {
      mo.addAttribute("id", se.getAttribute("id"));
      return "booking";
    }
  
    @GetMapping("/mypage") //마이페이지
    public String myinfo(HttpSession se, Model mo) {
      String id = (String)se.getAttribute("id");
      Member me = mrep.findById(id).get();
      mo.addAttribute("me",me);
      return "myinfo";
    }

    @GetMapping("/mypage/update") //회원이 정보 변경할 시 필요함
    public String myinfoUpdate(HttpSession se, String password, String username, String email, RedirectAttributes re) {
      String id = (String)se.getAttribute("id");
      if(mrep.updateMember(id, password, username, email) == 0)
         re.addAttribute("msg", "정보 변경 실패. 고객센터로 문의하세요.");
      else
         re.addAttribute("msg", id+"님의 정보가 변경되었습니다.");
      
      re.addAttribute("url", "back");
      return "redirect:/popup";
    }

    @GetMapping("/password/reset") //비밀번호 모를 시 비밀번호 초기화
    public String passwordReset(HttpSession se, String password, RedirectAttributes re) {
      String id = (String)se.getAttribute("id");
      String result = mrep.resetPassword(id);
      re.addAttribute("msg", id+"님의 비밀번호가"+result+"로 변경되었습니다.");

      re.addAttribute("url", "back");
      return "redirect:/popup";
    }

    @GetMapping("/logout") //로그아웃
    public String logout(HttpSession se, Model mo) {
      mo.addAttribute("id", se.getAttribute("id"));
      se.invalidate();
      return "redirect/menu";
    }
