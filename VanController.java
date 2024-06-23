package com.web.p7; // 컨트롤러
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

    @GetMapping("/login") // 로그인
    public String login() {
    return "login";
    }

    @GetMapping("/logup") // 회원가입
    public String logup() {
      return "logup";
    }

    @GetMapping("/logup/insert") // 회원가입 세부사항
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

    @GetMapping("/popup") // 리다이렉션에 필요한 팝업
    public String popup(String msg, String url, Model mo) {
      mo.addAttribute("msg", msg);
      mo.addAttribute("url", url);
      return "popup";
    }

    @GetMapping("/login/check") // 로그인 시 데이터베이스와 대조
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

    @GetMapping("/home") // 메인화면
    public String menu(HttpSession se, Model mo) {
      mo.addAttribute("id", se.getAttribute("id"));
      return "home";
    }

    @GetMapping("/member") // 관리자페이지
    public String member(HttpSession se, Model mo) {
      mo.addAttribute("id", se.getAttribute("id"));
      mo.addAttribute("arr",mrep.findAll());
      return "member";
    }

    @GetMapping("/movieList") // 영화목록
    public String movieList() {
      return "movieList";
    }

    @GetMapping("/movie_info1") // 영화 1번
    public String movieInfo1() {
      return "movie_info1";
    }

    @GetMapping("/movie_info2") // 영화 2번
    public String movieInfo2() {
      return "movie_info2";
    }

    @GetMapping("/movie_info3") // 영화 3번
    public String movieInfo3() {
      return "movie_info3";
    }

    @GetMapping("/movie_info4") // 영화 4번
    public String movieInfo4() {
      return "movie_info4";
    }

    @GetMapping("/movie_info5") // 영화 5번
    public String movieInfo5() {
      return "movie_info5";
    }

    @GetMapping("/movie_info6") // 영화 6번
    public String movieInfo6() {
      return "movie_info6";
    }

    @GetMapping("/movie_info7") // 영화 7번
    public String movieInfo7() {
      return "movie_info7";
    }

    @GetMapping("/movie_info8") // 영화 8번
    public String movieInfo8() {
      return "movie_info8";
    }

    @GetMapping("/movie_info9") // 영화 9번
    public String movieInfo9() {
      return "movie_info9";
    }

    @GetMapping("/movie_info10") // 영화 10번
    public String movieInfo10() {
      return "movie_info10";
    }

    @GetMapping("/movie_info11") // 영화 11번
    public String movieInfo11() {
      return "movie_info11";
    }

    @GetMapping("/movie_info12") // 영화 12번
    public String movieInfo12() {
      return "movie_info12";
    }

    @GetMapping("/movie_info13") // 영화 13번
    public String movieInfo13() {
      return "movie_info13";
    }

    @GetMapping("/movie_info14") // 영화 14번
    public String movieInfo14() {
      return "movie_info14";
    }

    @GetMapping("/movie_info15") // 영화 15번
    public String movieInfo15() {
      return "movie_info15";
    }

    @GetMapping("/cinema") // 극장선택
    public String cinema() {
      return "cinema";
    }
  
    @GetMapping("/booking") // 예매
    public String booking(HttpSession se, Model mo) {
      mo.addAttribute("id", se.getAttribute("id"));
      return "booking";
    }

    @GetMapping("/seat_select") // 좌석선택
    public String seatSelect(HttpSession se, Model mo) {
      mo.addAttribute("id", se.getAttribute("id"));
      return "seat_select";
    }

    @GetMapping("/seat_insert") // 좌석선택_데이터 추가
    public String seatInsert(String id, String movieName, String theater, String date, String time, String selectedSeatsArray, RedirectAttributes re) {
      Movie mo = new Movie();
      mo.id = id; mo.movieName = movieName; mo.theater = theater;
      mo.date = date; mo.time = time; mo.seats = selectedSeatsArray;
      morep.save(mo); // 회원-영화 예매 정보 업데이트
      re.addAttribute("msg", id+"님, 예매되었습니다.");
      re.addAttribute("url", "/home");
      return "redirect:/home";
    }

    @GetMapping("/mypage") // 마이페이지
    public String myinfo(HttpSession se, Model mo) {
      String id = (String)se.getAttribute("id");
      Member me = mrep.findById(id).get();
      mo.addAttribute("me",me);
      return "mypage";
    }

    @GetMapping("/mypage/update") // 회원이 정보 변경할 시 필요함
    public String myinfoUpdate(HttpSession se, String password, String username, String email, RedirectAttributes re) {
      String id = (String)se.getAttribute("id");
      if(mrep.updateMember(id, password, username, email) == 0)
         re.addAttribute("msg", "정보 변경 실패. 고객센터로 문의하세요.");
      else
         re.addAttribute("msg", id+"님의 정보가 변경되었습니다.");
      
      re.addAttribute("url", "back");
      return "redirect:/popup";
    }

    @GetMapping("/password/reset") // 비밀번호 모를 시 비밀번호 초기화
    public String passwordReset(HttpSession se, String password, RedirectAttributes re) {
      String id = (String)se.getAttribute("id");
      String result = mrep.resetPassword(id);
      re.addAttribute("msg", id+"님의 비밀번호가"+result+"로 변경되었습니다.");

      re.addAttribute("url", "back");
      return "redirect:/popup";
    }

    @GetMapping("/logout") // 로그아웃
    public String logout(HttpSession se, Model mo) {
      mo.addAttribute("id", se.getAttribute("id"));
      se.invalidate();
      return "redirect/home";
    }
 }
