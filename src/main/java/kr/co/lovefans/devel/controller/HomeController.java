package kr.co.lovefans.devel.controller;

import com.querydsl.core.Tuple;
import kr.co.lovefans.devel.domain.CreatorInfoDto;
import kr.co.lovefans.devel.domain.QMember;
import kr.co.lovefans.devel.dto.MemberDto;
import kr.co.lovefans.devel.service.CreatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.ListIterator;

@Controller
public class HomeController {


    private final CreatorService creatorService;

    @Autowired
    public HomeController(CreatorService creatorService) {
        this.creatorService = creatorService;
    }


    @GetMapping("/")
    public String home(Model model){

        List<MemberDto> list = creatorService.findAllPlus();


        model.addAttribute("model",list);



        return "index";
    }

    @GetMapping("/login")
    public String login(){

        return "login";
    }

    @PostMapping("/login")
    public String login2(){

        return "login";
    }
}
