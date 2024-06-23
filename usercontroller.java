package com.web.p8;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class usercontroller {

    @Autowired
    private userRepository userRepository;

    @Autowired
    private ticketRepository ticketRepository;

    @GetMapping("/userticket")
    public String showUserTickets(Model model) {
        // Inner join을 사용하여 User와 Ticket 데이터를 가져옴
        List<user> users = userRepository.findAll();
        List<ticket> tickets = ticketRepository.findAll();

        // Model에 데이터 추가
        model.addAttribute("users", users);
        model.addAttribute("tickets", tickets);

        return "userticket"; // HTML 템플릿 이름
    }
}
