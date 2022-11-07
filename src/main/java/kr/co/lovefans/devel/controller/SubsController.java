package kr.co.lovefans.devel.controller;

import kr.co.lovefans.devel.domain.CreatorInfoDto;
import kr.co.lovefans.devel.domain.CreatorPostDto;
import kr.co.lovefans.devel.domain.Member;
import kr.co.lovefans.devel.dto.PostDto;
import kr.co.lovefans.devel.service.CreatorPostService;
import kr.co.lovefans.devel.service.CreatorService;
import kr.co.lovefans.devel.service.MemberService;
import kr.co.lovefans.devel.service.SubscrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@RequestMapping(value="/subs")
@Controller
public class SubsController {

    private final CreatorService service;
    private final CreatorPostService creatorPostService;
    private final MemberService memberService;
    private final SubscrService subscrService;

    @Autowired
    public SubsController(CreatorService service, CreatorPostService creatorPostService, MemberService memberService, SubscrService subscrService) {
        this.service = service;
        this.creatorPostService = creatorPostService;
        this.memberService = memberService;
        this.subscrService = subscrService;
    }

    // HOME - 구독자 메인 페이지
    @GetMapping("/main")
    public String main(HttpSession session, Model model) {
        String go = "views/subscr/subscr_main";

        Optional<Member> memberInfo = memberService.findOne((Long) session.getAttribute("session"));

        List<CreatorInfoDto> creatorList = subscrService.findAll();
        List<PostDto> postList = creatorPostService.findPostByCpMiSeq((Long) session.getAttribute("session"));

        model.addAttribute("creatorList", creatorList);
        model.addAttribute("postList", postList);

//        사이드 메뉴 관련
        model.addAttribute("mainMenu", true);

        if (memberInfo.isEmpty()) return "redirect:/login";

        model.addAttribute("model", memberInfo.get());

        if(memberInfo.get().getMiKind().equals("V")) {
            go =  "views/subscr/subscr_main";
        }
        else if(memberInfo.get().getMiKind().equals("C")) {
            go = "redirect:/creator/creator_mypage";
        }
        else {
            return "redirect:/login";
        }
//
       return go;
   }

    // 구독자 마이 페이지
    @GetMapping("/mypage")
    public String mypage(HttpSession session, Model model) {
        String go = "views/subscr/subscr_mypage";

        Optional<Member> memberInfo = memberService.findOne((Long) session.getAttribute("session"));
        if (memberInfo.isEmpty()) return "redirect:/login";

        model.addAttribute("model", memberInfo.get());

        if(memberInfo.get().getMiKind().equals("V")) {
            go =  "views/subscr/subscr_mypage";
        }
        else if(memberInfo.get().getMiKind().equals("C")) {
            go = "redirect:/creator/creator_mypage";
        }
        else {
            return "redirect:/login";
        }

        return go;
    }

    // 알림 - 구독자 알림 페이지
    @GetMapping("/alarm")
    public String alarm(HttpSession session, Model model) {
        String go = "views/subscr/subscr_alarm";

        Optional<Member> memberInfo = memberService.findOne((Long) session.getAttribute("session"));
        if (memberInfo.isEmpty()) return "redirect:/login";

        model.addAttribute("model", memberInfo.get());
        model.addAttribute("alarmMenu", true);

        if(memberInfo.get().getMiKind().equals("V")) {
            go =  "views/subscr/subscr_alarm";
        }
        else if(memberInfo.get().getMiKind().equals("C")) {
            go = "redirect:/creator/creator_mypage";
        }
        else {
            return "redirect:/login";
        }

        return go;
    }

    // 메시지 - 구독자 메시지 목록 보기 페이지
    @GetMapping("/message/list")
    public String list(HttpSession session, Model model) {
        String go = "views/subscr/message/subscr_message_list";

        List<CreatorInfoDto> creatorList = subscrService.findAll();
        model.addAttribute("creatorList", creatorList);

        Optional<Member> memberInfo = memberService.findOne((Long) session.getAttribute("session"));
        if (memberInfo.isEmpty()) return "redirect:/login";

        model.addAttribute("model", memberInfo.get());
        model.addAttribute("msgMenu", true);

        if(memberInfo.get().getMiKind().equals("V")) {
            go =  "views/subscr/message/subscr_message_list";
        }
        else if(memberInfo.get().getMiKind().equals("C")) {
            go = "redirect:/creator/creator_mypage";
        }
        else {
            return "redirect:/login";
        }

        return go;
    }

    // 구독자가 메시지를 보낼 크리에이터 선택 페이지
    @GetMapping("/message/select")
    public String select(HttpSession session, Model model) {
        String go = "views/subscr/message/subscr_message_select";

        List<CreatorInfoDto> creatorList = subscrService.findAll();
        model.addAttribute("creatorList", creatorList);

        Optional<Member> memberInfo = memberService.findOne((Long) session.getAttribute("session"));
        if (memberInfo.isEmpty()) return "redirect:/login";

        model.addAttribute("model", memberInfo.get());
        model.addAttribute("msgMenu", true);

        if(memberInfo.get().getMiKind().equals("V")) {
            go =  "views/subscr/message/subscr_message_select";
        }
        else if(memberInfo.get().getMiKind().equals("C")) {
            go = "redirect:/creator/creator_mypage";
        }
        else {
            return "redirect:/login";
        }

        return go;
    }

    // 크리에이터와의 메시지 내용 보기 및 메시지 보내기 페이지
    @GetMapping("/message/view")
    public String view(HttpSession session, Model model) {
        String go = "views/subscr/message/subscr_message_view";

        List<CreatorInfoDto> creatorList = subscrService.findAll();
        model.addAttribute("creatorList", creatorList);

        Optional<Member> memberInfo = memberService.findOne((Long) session.getAttribute("session"));
        if (memberInfo.isEmpty()) return "redirect:/login";

        model.addAttribute("model", memberInfo.get());
        model.addAttribute("msgMenu", true);

        if(memberInfo.get().getMiKind().equals("V")) {
            go =  "views/subscr/message/subscr_message_view";
        }
        else if(memberInfo.get().getMiKind().equals("C")) {
            go = "redirect:/creator/creator_mypage";
        }
        else {
            return "redirect:/login";
        }

        return go;
    }

    // 구독채널 - 구독중인 크리에이터 목록 보기 페이지
    @GetMapping("/channel")
    public String channel(HttpSession session, Model model) {
        String go = "views/subscr/subscr_channel";

        Optional<Member> memberInfo = memberService.findOne((Long) session.getAttribute("session"));
        if (memberInfo.isEmpty()) return "redirect:/login";

        model.addAttribute("model", memberInfo.get());
        model.addAttribute("channelMenu", true);

        if(memberInfo.get().getMiKind().equals("V")) {
            go =  "views/subscr/subscr_channel";
        }
        else if(memberInfo.get().getMiKind().equals("C")) {
            go = "redirect:/creator/creator_mypage";
        }
        else {
            return "redirect:/login";
        }

        return go;
    }

    // 결재 - 구독자가 등록한 결재 카드 보기
    @GetMapping("/payment")
    public String payment(HttpSession session, Model model) {
        String go = "views/subscr/payment/subscr_payment";

        Optional<Member> memberInfo = memberService.findOne((Long) session.getAttribute("session"));
        if (memberInfo.isEmpty()) return "redirect:/login";

        model.addAttribute("model", memberInfo.get());
        model.addAttribute("payMenu", true);

        if(memberInfo.get().getMiKind().equals("V")) {
            go =  "views/subscr/payment/subscr_payment";
        }
        else if(memberInfo.get().getMiKind().equals("C")) {
            go = "redirect:/creator/creator_mypage";
        }
        else {
            return "redirect:/login";
        }

        return go;
    }

    // 구독자가 결재한 내역을 간단히 보여주는 페이지
    @GetMapping("/payment/detail")
    public String detail(HttpSession session, Model model) {
        String go = "views/subscr/payment/subscr_payment_detail";

        Optional<Member> memberInfo = memberService.findOne((Long) session.getAttribute("session"));
        if (memberInfo.isEmpty()) return "redirect:/login";

        model.addAttribute("model", memberInfo.get());
        model.addAttribute("payMenu", true);

        if(memberInfo.get().getMiKind().equals("V")) {
            go =  "views/subscr/payment/subscr_payment_detail";
        }
        else if(memberInfo.get().getMiKind().equals("C")) {
            go = "redirect:/creator/creator_mypage";
        }
        else {
            return "redirect:/login";
        }

        return go;
    }

    // 고객센터 - 구독자가 문의사항을 남김
    @GetMapping("/callcenter")
    public String callcenter(HttpSession session, Model model) {
        String go = "views/subscr/subscr_call_center";

        Optional<Member> memberInfo = memberService.findOne((Long) session.getAttribute("session"));
        if (memberInfo.isEmpty()) return "redirect:/login";

        model.addAttribute("model", memberInfo.get());
        model.addAttribute("callMenu", true);

        if(memberInfo.get().getMiKind().equals("V")) {
            go =  "views/subscr/subscr_call_center";
        }
        else if(memberInfo.get().getMiKind().equals("C")) {
            go = "redirect:/creator/creator_mypage";
        }
        else {
            return "redirect:/login";
        }

        return go;
    }

    // 크리에이터 페이지(구독자 및 크리에이터 본인 전용)
    @GetMapping("/creatorpage")
    public String creatorpage(HttpSession session, Model model) {
        String go = "views/subscr/creator/creator_page";

        Optional<Member> memberInfo = memberService.findOne((Long) session.getAttribute("session"));
        if (memberInfo.isEmpty()) return "redirect:/login";

        model.addAttribute("model", memberInfo.get());

        if (memberInfo.get().getMiKind().equals("V")) {
            go = "views/subscr/creator/creator_page";
        }
        else if (memberInfo.get().getMiKind().equals("C")) {
            go = "redirect:/creator/creator_mypage";
        }
        else {
            return "redirect:/login";
        }

        return go;
    }



    // 크리에이터 페이지 구독하기(등급선택)
    @GetMapping("/mem/be")
    public String be(HttpSession session, Model model) {
        String go = "views/subscr/member/mem_be";

        Optional<Member> memberInfo = memberService.findOne((Long) session.getAttribute("session"));
        if (memberInfo.isEmpty()) return "redirect:/login";

        model.addAttribute("model", memberInfo.get());

        if (memberInfo.get().getMiKind().equals("V")) {
            go = "views/subscr/member/mem_be";
        }
        else if (memberInfo.get().getMiKind().equals("C")) {
            go = "redirect:/creator/creator_mypage";
        }
        else {
            return "redirect:/login";
        }

        return go;
    }

    // 구독에 대한 결재하기
    @GetMapping("/mem/pay")
    public String pay(HttpSession session, Model model) {
        String go = "views/subscr/member/mem_pay";

        Optional<Member> memberInfo = memberService.findOne((Long) session.getAttribute("session"));
        if (memberInfo.isEmpty()) return "redirect:/login";

        model.addAttribute("model", memberInfo.get());

        if (memberInfo.get().getMiKind().equals("V")) {
            go = "views/subscr/member/mem_pay";
        }
        else if (memberInfo.get().getMiKind().equals("C")) {
            go = "redirect:/creator/creator_mypage";
        }
        else {
            return "redirect:/login";
        }

        return go;
    }

//    // 크리에이터 신청 step 1
//    @GetMapping("/regist/creator/step1")
//    public String reg1(HttpSession session, Model model) {
//        String go = "views/subscr/regist/regist_creator_step1";
//
//        Optional<Member> memberInfo = memberService.findOne((Long) session.getAttribute("session"));
//        if (memberInfo.isEmpty()) return "redirect:/login";
//
//        model.addAttribute("model", memberInfo.get());
//
//        if (memberInfo.get().getMiKind().equals("V")) {
//            go = "views/subscr/regist/regist_creator_step1";
//        }
//        else if (memberInfo.get().getMiKind().equals("C")) {
//            go = "redirect:/creator/creator_mypage";
//        }
//        else {
//            return "redirect:/login";
//        }
//
//        return go;
//    }
//
//    // 크리에이터 신청 step 2
//    @GetMapping("/regist/creator/step2")
//    public String reg2(HttpSession session, Model model) {
//        String go = "views/subscr/regist/regist_creator_step2";
//
//        Optional<Member> memberInfo = memberService.findOne((Long) session.getAttribute("session"));
//        if (memberInfo.isEmpty()) return "redirect:/login";
//
//        model.addAttribute("model", memberInfo.get());
//
//        if (memberInfo.get().getMiKind().equals("V")) {
//            go = "views/subscr/regist/regist_creator_step2";
//        }
//        else if (memberInfo.get().getMiKind().equals("C")) {
//            go = "redirect:/creator/creator_mypage";
//        }
//        else {
//            return "redirect:/login";
//        }
//
//        return go;
//    }




    // 비구독자 및 비회원이 보는 크리에이터 페이지 첫 화면
    // 비회원(비로그인)일 경우
    @GetMapping("/creatorpage/mode0")
    public String mode0(@RequestParam("key") Long cpMiSeq, Model model) {

        CreatorInfoDto creator = service.findOne(cpMiSeq).get();

        model.addAttribute("creator",creator);

        return "creator_page_mode0";
    }

    // 비구독자, 비회원이 보는 크리에이터 포스트 보기 화면
    // 비회원(비로그인)일 경우
    @GetMapping("/creatorpage/mode0/post")
    public String post(@RequestParam("key") Long cpMiSeq, Model model,Integer page) {

        page = 0;
        CreatorInfoDto creator = service.findOne(cpMiSeq).get();
        Slice<CreatorPostDto> post = creatorPostService.findSliceBycpMiSeq(cpMiSeq,page);
        List<CreatorPostDto> list = creatorPostService.findBycpMiSeq(cpMiSeq);

        model.addAttribute("model",post);
        model.addAttribute("creator",creator);

        for(CreatorPostDto a : post){
            System.out.println(a.getCpContent());
        }

        return "creator_page_mode0_post";
    }

    @PostMapping("/creatorpage/mode0/post/more")
    @ResponseBody
    public Slice<CreatorPostDto> postMore(@RequestParam("cpMiSeq") Long cpMiSeq,@RequestParam("page") Integer page) {

        System.out.println("cpMiSeq = " + cpMiSeq + ", page = " + page);
        Slice<CreatorPostDto> post = creatorPostService.findSliceBycpMiSeq(cpMiSeq,page);
        for(CreatorPostDto a : post){
            System.out.println(a.getCpContent());
        }

        return post;
    }
}




