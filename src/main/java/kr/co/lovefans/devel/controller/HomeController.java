package kr.co.lovefans.devel.controller;

import com.querydsl.core.Tuple;
import kr.co.lovefans.devel.domain.CreatorInfoDto;
import kr.co.lovefans.devel.domain.QMember;
import kr.co.lovefans.devel.dto.MemberDto;
import kr.co.lovefans.devel.repository.SearchResultRepository;
import kr.co.lovefans.devel.service.CreatorService;
import kr.co.lovefans.devel.service.MemberService;
import kr.co.lovefans.devel.service.SubListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

@Controller
public class HomeController {


    private final CreatorService creatorService;
    private final MemberService memberService;
    private final SubListService subListService;


    public HomeController(SubListService subListService , CreatorService creatorService, MemberService memberService) {
        this.creatorService = creatorService;
        this.memberService = memberService;
        this.subListService = subListService;
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

    @GetMapping("/search")
    public String search(@RequestParam(value = "keyword")String keyword, @RequestParam(defaultValue = "0", value = "page") int page , Model model){
        Page<CreatorInfoDto> result = memberService.searchResult(keyword, page);
        int totalPage = result.getTotalPages();
        ArrayList<Long> subsCount = new ArrayList<>();
        for (CreatorInfoDto x : result) {
            subsCount.add(subListService.count(x.getCiMiSeq()));
        }
//        for(Long x : subsCount){
//            System.out.println("subsCount  = = = " + x.longValue());
//        }
        model.addAttribute("result",result);
        model.addAttribute("totalPage",totalPage);
        model.addAttribute("subsCount",subsCount);
        model.addAttribute("keyword",keyword);

        return "views/search_result";
    }



}
