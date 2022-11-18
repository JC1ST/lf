package kr.co.lovefans.devel.controller;

import kr.co.lovefans.devel.domain.CreatorInfoDto;
import kr.co.lovefans.devel.domain.CreatorPostDto;
import kr.co.lovefans.devel.domain.Member;
import kr.co.lovefans.devel.dto.PostDto;
import kr.co.lovefans.devel.service.CreatorPostService;
import kr.co.lovefans.devel.service.CreatorService;
import kr.co.lovefans.devel.service.MemberService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.List;
import java.util.Optional;

@Controller
public class CreatorController {

    private final CreatorService creatorService;
    private final MemberService memberService;
    private final CreatorPostService creatorPostService;

    @Autowired
    public CreatorController(CreatorService creatorService, MemberService memberService, CreatorPostService creatorPostService) {
        this.creatorService = creatorService;
        this.memberService = memberService;
        this.creatorPostService = creatorPostService;
    }
    /*creator new 완벽히 구현 x*/
    @GetMapping("creators/new")
    public String creator_new() {

        return "views/creator/regist_creator_step1";
    }

    @PostMapping("creators/new")
    public String creator_new(CreatorInfoDto creatorInfo, HttpServletRequest request) {

        HttpSession infoSession = request.getSession();
        infoSession.setAttribute("infoSession", creatorInfo);

        return "redirect:/creators/new2";
    }

    @GetMapping("creators/new2")
    public String creator_new2() {

        return "views/creator/regist_creator_step2";
    }

    @PostMapping("creators/new2")
    public String creators_new2(CreatorInfoDto creatorInfo, HttpSession session, HttpSession infoSession) {
        CreatorInfoDto creatorInfo_Step1 = ((CreatorInfoDto) infoSession.getAttribute("infoSession"));
        creatorInfo_Step1.setCiMiSeq((Long) session.getAttribute("session"));

        creatorInfo_Step1.setCiBank(creatorInfo.getCiBank());
        creatorInfo_Step1.setCiState('0');
        creatorInfo_Step1.setCiPriceKind('1');

        creatorService.join(creatorInfo_Step1);

        return "redirect:/creators/creator_main?key=" + creatorInfo_Step1.getCiMiSeq();
    }


    /*creator main page*/
    @GetMapping("creators/creator_main")
    public String creator_main(HttpSession session, HttpServletRequest request, Model model) {
        Optional<CreatorInfoDto> creatorInfo = creatorService.findOne((Long) session.getAttribute("session"));
        Optional<Member> memberInfo = memberService.findOne((Long) session.getAttribute("session"));
        List<CreatorPostDto> postList =  creatorPostService.findBycpMiSeq((Long) session.getAttribute("session"));

        session.setAttribute("creator", creatorService.findOne((Long) session.getAttribute("session")).get());
        session.setAttribute("member", memberService.findOne((Long) session.getAttribute("session")).get());

        model.addAttribute("creator", creatorInfo.get());
        model.addAttribute("member", memberInfo.get());
        model.addAttribute("postList", postList);

        if(postList.size() < 5) {
            model.addAttribute("count", postList.size());
        } else {
            model.addAttribute("count", 5);
        }

        return "views/creator/creator_main";
    }

    /*creator mypage*/
    @GetMapping("creators/creator_mypage")
    public String creator_mypage(HttpSession session, Model model) {

        Optional<CreatorInfoDto> creatorInfo = creatorService.findOne((Long) session.getAttribute("session"));
        Optional<Member> memberInfo = memberService.findOne((Long) session.getAttribute("session"));

        if(creatorInfo.isEmpty()) return "redirect:/login"; // creatorInfo는 1번 하나밖에 없음

        model.addAttribute("creator", creatorInfo.get());
        model.addAttribute("member", memberInfo.get());

        return "views/creator/creator_mypage";
    }

    @PostMapping("/creators/update") /*크리에이터 페이지 중지에 사용, 사이드바 변경 필요*/
    public String infoModify(Member memberInfo, CreatorInfoDto creatorInfo, HttpSession session, Model model) {
        Long key = (Long) session.getAttribute("session");
        Member member = memberService.findOne(key).get();
        CreatorInfoDto creator = creatorService.findOne(key).get();

        if(memberInfo != null) {
            if (memberInfo.getMiId() != null) {
                member.setMiNick(memberInfo.getMiId());
            } else if (memberInfo.getMiNick() != null) {
                member.setMiNick(memberInfo.getMiNick());
            } else if (memberInfo.getMiKind() != null) {
                member.setMiKind((memberInfo.getMiKind()));
            }
            creatorService.modify(member);
        }

        if(creatorInfo != null) {
            if(creatorInfo.getCiState() != ' ') {
                creator.setCiState(creatorInfo.getCiState());
            }
            creatorService.modify(creator);
        }

        return "redirect:/members/mypage";
    }

    /*creator alarm*/
    @GetMapping("creators/creator_alarm")
    public String creator_alarm(@RequestParam("key") Long key) {

        return "views/creator/creator_alarm";
    }

    /*creator post*/
    @GetMapping("creators/post/creator_post_new")
    public String creator_post_new(@RequestParam("key") Long key) {

        return "views/creator/post/creator_post_new";
    }

    @GetMapping("creators/post/creator_post_make_img")
    public String creator_post_make_img(@RequestParam("key") Long key) {

        return "views/creator/post/creator_post_make_img";
    }

    @PostMapping("creators/post/creator_post_make_img") // 이미지 한개씩만 업로드 가능(여러개 구현 X)
    public String creator_post_regist_img(@RequestParam("key") Long key, CreatorPostDto creatorPostDto, MultipartFile file) throws Exception {
        creatorPostDto.setCpMiSeq(key);
        creatorPostDto.setCpState('Y');
        creatorPostDto.setCpKind('I');

        creatorPostService.registerImg(key, creatorPostDto, file);

        return "redirect:/creators/creator_main";
    }

    @GetMapping("creators/post/creator_post_make_mov")
    public String creator_post_make_mov(@RequestParam("key") Long key) {

        return "views/creator/post/creator_post_make_mov";
    }

    @GetMapping("creators/post/creator_post_make_link")
    public String creator_post_make_link(@RequestParam("key") Long key) {

        return "views/creator/post/creator_post_make_link";
    }

    @GetMapping("creators/post/creator_post_temp")
    public String creator_post_temp(@RequestParam("key") Long key) {

        return "views/creator/post/creator_post_temp";
    }

    @GetMapping("creators/post/creator_post_scheduled")
    public String creator_post_scheduled(@RequestParam("key") Long key) {

        return "views/creator/post/creator_post_scheduled";
    }

    @GetMapping("creators/post/creator_post_ing")
    public String creator_post_ing(@RequestParam("key") Long key) {

        return "views/creator/post/creator_post_ing";
    }

    @GetMapping("creators/post/creator_post_board")
    public String creator_post_board(@RequestParam("key") Long key) {

        return "views/creator/post/creator_post_board";
    }


    /*creator income*/
    @GetMapping("creators/income/creator_income_total")
    public String creator_income_total(@RequestParam("key") Long key) {

        return "views/creator/income/creator_income_total";
    }

    @GetMapping("creators/income/creator_income_request")
    public String creator_income_request(@RequestParam("key") Long key) {

        return "views/creator/income/creator_income_request";
    }

    @GetMapping("creators/income/creator_income_refund")
    public String creator_income_refund(@RequestParam("key") Long key) {

        return "views/creator/income/creator_income_refund";
    }

    @GetMapping("creators/income/creator_income_withdraw")
    public String creator_income_withdraw(@RequestParam("key") Long key) {

        return "views/creator/income/creator_income_withdraw";
    }


    /*creator message*/
    @GetMapping("creators/message/creator_message_c_list")
    public String creator_message_c_list(@RequestParam("key") Long key) {

        return "views/creator/message/creator_message_c_list";
    }

    @GetMapping("creators/message/creator_message_c_select")
    public String creator_message_c_select(@RequestParam("key") Long key) {

        return "views/creator/message/creator_message_c_select";
    }

    @GetMapping("creators/message/creator_message_c_view")
    public String creator_message_c_view(@RequestParam("key") Long key) {

        return "views/creator/message/creator_message_c_view";
    }

    @GetMapping("creators/message/creator_message_s_list")
    public String creator_message_s_list(@RequestParam("key") Long key) {

        return "views/creator/message/creator_message_s_list";
    }

    @GetMapping("creators/message/creator_message_s_select")
    public String creator_message_s_select(@RequestParam("key") Long key) {

        return "views/creator/message/creator_message_s_select";
    }

    @GetMapping("creators/message/creator_message_s_view")
    public String creator_message_s_view(@RequestParam("key") Long key) {

        return "views/creator/message/creator_message_s_view";
    }


    /*creator page*/
    @GetMapping("creators/page/creator_page")
    public String creator_page(@RequestParam("key") Long key) {

        return "views/creator/page/creator_page";
    }

    @GetMapping("creators/page/creator_page_detail")
    public String creator_page_detail(@RequestParam("key") Long key, Model model, HttpSession session) {
        List<CreatorPostDto> postList =  creatorPostService.findBycpMiSeq((Long) session.getAttribute("session"));

        model.addAttribute("postList", postList);

        if(postList.size() < 5) {
            model.addAttribute("count", postList.size());
        } else {
            model.addAttribute("count", 5);
        }

        return "views/creator/page/creator_page_detail";
    }

    @GetMapping("creators/page/creator_page_modify_common")
    public String creator_page_modify_common(@RequestParam("key") Long key) {

        return "views/creator/page/creator_page_modify_common";
    }

    @GetMapping("creators/page/creator_page_modify_tier")
    public String creator_page_modify_tier(@RequestParam("key") Long key) {

        return "views/creator/page/creator_page_modify_tier";
    }


    /*creator subscr*/
    @GetMapping("creators/subscr/creator_subscr_mng")
    public String creator_subscr_mng(@RequestParam("key") Long key) {

        return "views/creator/subscr/creator_subscr_mng";
    }

    @GetMapping("creators/subscr/creator_subscr_block")
    public String creator_subscr_block(@RequestParam("key") Long key) {

        return "views/creator/subscr/creator_subscr_block";
    }

}
