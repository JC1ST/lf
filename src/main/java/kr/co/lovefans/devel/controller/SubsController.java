package kr.co.lovefans.devel.controller;

import kr.co.lovefans.devel.domain.*;
import kr.co.lovefans.devel.dto.MemberDto;
import kr.co.lovefans.devel.dto.PostDto;
import kr.co.lovefans.devel.dto.SubCreDto;
import kr.co.lovefans.devel.dto.SubsSubsListDto;
import kr.co.lovefans.devel.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@RequestMapping(value="/subs")
@Controller
public class SubsController {

    private final SubListService subListService;
    private final CreatorService service;
    private final CreatorPostService creatorPostService;
    private final MemberService memberService;
    private final SubscrService subscrService;

    @Autowired
    public SubsController(SubListService subListService, CreatorService service, CreatorPostService creatorPostService, MemberService memberService, SubscrService subscrService) {
        this.subListService = subListService;
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

        List<MemberDto> List = subscrService.findAll((Long) session.getAttribute("session"));
        List<PostDto> postList = creatorPostService.findPostByCpMiSeq((Long) session.getAttribute("session"));
        List<SubCreDto> creList = subscrService.findCre((Long) session.getAttribute("session"));

        model.addAttribute("creatorList", List);
        model.addAttribute("postList", postList);
        model.addAttribute("creList", creList);

        // 사이드 메뉴 관련
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

        return go;
    }

    // 구독자 마이 페이지
    @GetMapping("/mypage")
    public String mypage(HttpSession session, Model model, @RequestParam("key") Long key) {
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
    public String alarm(HttpSession session, Model model, @RequestParam("key") Long key) {
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
    public String list(HttpSession session, Model model, @RequestParam("key") Long key) {
        String go = "views/subscr/message/subscr_message_list";

        Optional<Member> memberInfo = memberService.findOne((Long) session.getAttribute("session"));

        List<SubCreDto> creList = subscrService.findCre((Long) session.getAttribute("session"));
        model.addAttribute("creList", creList);

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
    public String select(HttpSession session, Model model, @RequestParam("key") Long key) {
        String go = "views/subscr/message/subscr_message_select";

        Optional<Member> memberInfo = memberService.findOne((Long) session.getAttribute("session"));

        List<SubCreDto> creList = subscrService.findCre((Long) session.getAttribute("session"));
        model.addAttribute("creList", creList);

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
    public String view(HttpSession session, Model model, @RequestParam("key") Long key) {
        String go = "views/subscr/message/subscr_message_view";

        Optional<Member> memberInfo = memberService.findOne((Long) session.getAttribute("session"));

        List<SubCreDto> creList = subscrService.findCre((Long) session.getAttribute("session"));
        model.addAttribute("creList", creList);

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
    // 구독채널 - 구독중인 크리에이터 목록 보기 페이지
    @GetMapping("/channel")
    public String channel(HttpSession session, Model model) {
        String go = "views/subscr/subscr_channel";

        Optional<Member> memberInfo = memberService.findOne((Long) session.getAttribute("session"));
        if (memberInfo.isEmpty()) return "redirect:/login";

        model.addAttribute("model", memberInfo.get());
        model.addAttribute("channelMenu", true);

        if(memberInfo.get().getMiKind().equals("V")) {
            List<SubsSubsListDto> list = subscrService.findBySlVmiSeq((Long) session.getAttribute("session"));
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Calendar calendar = Calendar.getInstance();
            boolean checkDate = true;
            String endSubs = "";
            LocalDate now = LocalDate.now();

            for(SubsSubsListDto a : list){

                calendar.setTime(a.getSlRegdt());
                calendar.add(Calendar.MONTH, 1 );
                a.setSlRegdt(calendar.getTime());
                endSubs = simpleDateFormat.format(a.getSlRegdt());
                checkDate = a.getSlRegdt().before(java.sql.Date.valueOf(now));
            }

            model.addAttribute("endSubs",endSubs);
            model.addAttribute("checkDate",checkDate);
            model.addAttribute("list",list);
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

    //구독취소
    @DeleteMapping("/cancel/{cSeq}")
    public String cancelSubs(@PathVariable(value = "cSeq") Long cSeq,HttpSession session){

        Optional<SubListDto> subListDto = subListService.checkBySeq(cSeq, (Long) session.getAttribute("session"));
        subListService.delete(subListDto.get());

        return "redirect:/subs/channel";
    }

    // 결재 - 구독자가 등록한 결재 카드 보기
    @GetMapping("/payment")
    public String payment(HttpSession session, Model model, @RequestParam("key") Long key) {
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
    public String detail(HttpSession session, Model model, @RequestParam("key") Long key) {
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
    public String callcenter(HttpSession session, Model model, @RequestParam("key") Long key) {
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
    public String creatorpage(HttpSession session, Model model, @RequestParam("key") Long cpMiSeq) {
        String go = "views/subscr/creator/creator_page";

        Optional<Member> memberInfo = memberService.findOne((Long) session.getAttribute("session"));
        CreatorInfoDto creator = service.findOne(cpMiSeq).get();
        List<CreatorPostDto> crePost = service.findAllPost(cpMiSeq);

        if (memberInfo.isEmpty()) return "redirect:/login";

        model.addAttribute("model", memberInfo.get());

        model.addAttribute("creator",creator);
        model.addAttribute("crePost", crePost);

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
    public String be(HttpSession session, Model model, @RequestParam("key") Long cSeq) {
        String go = "views/subscr/member/mem_be";



        Optional<Member> memberInfo = memberService.findOne((Long) session.getAttribute("session"));
        if (memberInfo.isEmpty()) return "redirect:/login";

        model.addAttribute("model", memberInfo.get());

        if (memberInfo.get().getMiKind().equals("V")) {

            CreatorInfoDto creator = service.findOne(cSeq).get();
            model.addAttribute("creator", creator);
            List<CreatorSubLevelDto> levels = service.findByCslMiSeq(cSeq);
            model.addAttribute("levels",levels);




            subListService.checkBySeq(cSeq, (Long) session.getAttribute("session")).ifPresent(a->{
                Optional<SubListDto> subListDto = Optional.ofNullable(a);
                Long cslSeq = (subListDto.get().getSubListDtoId().getSlCslSeq());
                model.addAttribute("cslSeq",cslSeq);

                service.findByCslSeq(cslSeq).ifPresent(b->{
                    Optional<CreatorSubLevelDto> mySubLevel = Optional.ofNullable(b);
                    model.addAttribute("levels",levels);
                    levels.remove(mySubLevel.get());
                });
            });



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
    public String pay(HttpSession session, Model model,@RequestParam("key") Long cSeq,@RequestParam("key2") Long cslSeq) {
        String go = "views/subscr/member/mem_pay";

        Optional<Member> memberInfo = memberService.findOne((Long) session.getAttribute("session"));
        if (memberInfo.isEmpty()) return "redirect:/login";

        model.addAttribute("model", memberInfo.get());

        if (memberInfo.get().getMiKind().equals("V")) {
            model.addAttribute("cSeq",cSeq);
            model.addAttribute("cslSeq",cslSeq);
            go = "views/subscr/member/mem_pay";
        }
        else if (memberInfo.get().getMiKind().equals("C")) {
            go = "redirect:/creator/creator_mypage";
        }
        else {
            return "redirect:/login";
        }

//        System.out.println("cslSeqcslSeqcslSeqcslSeqcslSeqcslSeqcslSeqcslSeq"+cslSeq);
        return go;
    }

    // 비구독자 및 비회원이 보는 크리에이터 페이지 첫 화면
    // 비회원(비로그인)일 경우
    @GetMapping("/creatorpage/mode0")
    public String mode0(@RequestParam("key") Long cpMiSeq, Model model, HttpSession session) {

        Optional<SubListDto> subListDto = subListService.checkBySeq(cpMiSeq, (Long) session.getAttribute("session"));
        CreatorInfoDto creator = service.findOne(cpMiSeq).get();
        model.addAttribute("creator", creator);


        if (!subListDto.isEmpty()) {


        Optional<SubListDto> subListDto = subListService.checkBySeq(cpMiSeq, (Long) session.getAttribute("session"));
        CreatorInfoDto creator = service.findOne(cpMiSeq).get();
        List<CreatorPostDto> post = service.findAllPost(cpMiSeq);

        model.addAttribute("creator", creator);
        model.addAttribute("post", post);

        if (!subListDto.isEmpty()) {
            return "redirect:/subs/creatorpage/mode0/post?key=" + creator.getCiMiSeq();

        } else {
            List<CreatorSubLevelDto> levels = service.findByCslMiSeq(cpMiSeq);
            model.addAttribute("levels", levels);
            return "views/subscr/creator/creator_page_mode0";
        }
    }


            return "redirect:/subs/creatorpage/mode0/post?key=" + creator.getCiMiSeq();

        } else {
            List<CreatorSubLevelDto> levels = service.findByCslMiSeq(cpMiSeq);
            model.addAttribute("levels", levels);
            System.out.println("****************levels****************"+levels);
            return "views/subscr/creator/creator_page_mode0";
        }
    }
    // 비구독자, 비회원이 보는 크리에이터 포스트 보기 화면
    // 비회원(비로그인)일 경우
    @GetMapping("/creatorpage/mode0/post")
    public String post(@RequestParam("key") Long cpMiSeq, Model model,Integer page, HttpSession session) {



        AtomicInteger checkSubs = new AtomicInteger();
        checkSubs.set(0);



        AtomicInteger checkSubs = new AtomicInteger();
        page = 0;
        CreatorInfoDto creator = service.findOne(cpMiSeq).get();
        Slice<CreatorPostDto> post = creatorPostService.findSliceBycpMiSeq(cpMiSeq,page);


        for (CreatorPostDto x : post) {
            System.out.println("getCpOpenCslSeq " + x.getCpOpenCslSeq());
            Optional<String> cpOpenCslSeq = Optional.ofNullable(x.getCpOpenCslSeq());
            cpOpenCslSeq.ifPresent(a->{
                System.out.println("test test test test test " + a.contains("1"));
                String[] needForRead = a.split(",");
                model.addAttribute("subName",service.findByCslSeq(Long.valueOf(needForRead[0])).get().getCslNm());
            });



        }

        List<CreatorSubLevelDto> subLevelList = service.findByCslMiSeq(cpMiSeq);
        if(!subLevelList.isEmpty()){
            model.addAttribute("subLevelList",subLevelList);
        }

        subListService.checkBySeq(cpMiSeq, (Long) session.getAttribute("session")).ifPresent(a->{
            Optional<SubListDto> subListDto = Optional.ofNullable(a);
            Long cslSeq = (subListDto.get().getSubListDtoId().getSlCslSeq());
            model.addAttribute("cslSeq",cslSeq);
            checkSubs.set(1);

            service.findByCslSeq(cslSeq).ifPresent(b->{
                Optional<CreatorSubLevelDto> mySubLevel = Optional.ofNullable(b);
                model.addAttribute("mySubLevel",mySubLevel);
                subLevelList.remove(mySubLevel.get());
            });
        });

        model.addAttribute("checkSubs",checkSubs);
        model.addAttribute("model",post);
        model.addAttribute("creator",creator);


        subListService.checkBySeq(cpMiSeq, (Long) session.getAttribute("session")).ifPresent(a->{
            Optional<SubListDto> subListDto = Optional.ofNullable(a);
            System.out.println("subListDto subListDto subListDto subListDto subListDto subListDto" + subListDto.get());
            checkSubs.set(1);

            service.findByCslSeq(subListDto.get().getSubListDtoId().getSlCslSeq()).ifPresent(b->{
                Optional<CreatorSubLevelDto> mySubLevel = Optional.ofNullable(b);
                model.addAttribute("mySubLevel",mySubLevel);
                System.out.println("mysublevel      " + mySubLevel.get().getCslNm());

                List<CreatorSubLevelDto> subLevelList = service.findByCslMiSeq(cpMiSeq);
                if(!subLevelList.isEmpty()){
                    model.addAttribute("subLevelList",subLevelList);
                }
            });
        });

        model.addAttribute("checkSubs",checkSubs);
        model.addAttribute("model",post);
        model.addAttribute("creator",creator);

        return "views/subscr/creator/creator_page_mode0_post";
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
