package kr.co.lovefans.devel.controller;

import kr.co.lovefans.devel.domain.MemberInfoDto;
import kr.co.lovefans.devel.dto.MemberDto;
import kr.co.lovefans.devel.service.AdminService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/admin")
@Controller
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }


    // 관리자 로그인
    @GetMapping("/login")
    public String login() {

        return "admin/login";
    }

    // 관리자 로그아웃
    @GetMapping("/logout")
    public String logout() {

        return "redirect:/admin/login";
    }

    // 전체 회원 리스트
    @GetMapping("/mem_all_list")
    public String list(Model model, @PageableDefault(page = 0, size = 5, sort = "mi_seq", direction = Sort.Direction.ASC) Pageable pageable) {

        Page<MemberInfoDto> pageList = adminService.findPage(pageable);

//        // 페이지 번호
//        int pageNumber = pageList.getPageable().getPageNumber();
//        // 페이지 사이즈
//        int pageSize = pageList.getPageable().getPageSize();
//        // 전체 페이지 갯수
//        int totalPages = pageList.getTotalPages();
//        // 시작 페이지 번호
//        int startPage = (int) (Math.floor(pageNumber / pageSize) * pageSize + 1);
//        // 임시 마지막 페이지
//        int tempEndPage = startPage + pageSize - 1;
//        // 마지막 페이지
//        int endPage = (tempEndPage > totalPages ? totalPages : tempEndPage);
//
        model.addAttribute("pageList", pageList);
//        model.addAttribute("pageNumber", pageNumber);
//        model.addAttribute("pageSize", pageSize);
//        model.addAttribute("totalPages", totalPages);
//        model.addAttribute("startPage", startPage);
//        model.addAttribute("tempEndPage", tempEndPage);
//        model.addAttribute("endPage", endPage);



        int nowPage = pageList.getPageable().getPageNumber() + 1;
        int startPage2 = Math.max(nowPage - 4, 1);
        int endPage2 = Math.min(nowPage + 5, pageList.getTotalPages());

        model.addAttribute("nowPage", nowPage);
        model.addAttribute("startPage2", startPage2);
        model.addAttribute("endPage2", endPage2);



//        사이드 메뉴 관련
        model.addAttribute("memAllList", true);

        return "admin/member/mem_all_list";
    }

    // 전체 회원 리스트 상세보기
    @GetMapping("/mem_all_view")
    public String view(Model model) {

        model.addAttribute("memAllView", true);

        return "admin/member/mem_all_view";
    }

    // 크리에이터 리스트
    @GetMapping("/mem_c_list")
    public String clist(Model model) {

        model.addAttribute("memCList", true);

        return "admin/member/mem_c_list";
    }

    // 크리에이터 리스트 상세보기
    @GetMapping("/mem_c_view")
    public String cview(Model model) {

        model.addAttribute("memCView", true);

        return "admin/member/mem_c_view";
    }

    // 구독자 리스트
    @GetMapping("/mem_s_list")
    public String slist(Model model) {

        model.addAttribute("memSList", true);

        return "admin/member/mem_s_list";
    }

    // 구독자 리스트 상세보기
    @GetMapping("/mem_s_view")
    public String sview(Model model) {

        model.addAttribute("memSView", true);

        return "admin/member/mem_all_view";
    }

    // 포스트 리스트
    @GetMapping("/post_list")
    public String plist(Model model) {

        model.addAttribute("postList", true);

        return "admin/post/post_list";
    }

    // 포스트 리스트 상세보기
    @GetMapping("/post_view")
    public String pview(Model model) {

        model.addAttribute("postView", true);

        return "admin/post/post_view";
    }

    // 결제 리스트
    @GetMapping("/pay_list")
    public String paylist(Model model) {

        model.addAttribute("payList", true);

        return "admin/pay/payment_list";
    }

    // 결제 리스트 상세보기
    @GetMapping("/pay_view")
    public String payview(Model model) {

        model.addAttribute("payView", true);

        return "admin/pay/payment_view";
    }

    // 매출 통계
    @GetMapping("/pay_statistics")
    public String paystatistics(Model model) {

        model.addAttribute("payStatistics", true);

        return "admin/pay/statistics";
    }

    // 입출금 리스트
    @GetMapping("/deposit_list")
    public String dlist(Model model) {

        model.addAttribute("depositList", true);

        return "admin/deposit/deposit_list";
    }

    // 입출금 리스트 상세보기
    @GetMapping("/deposit_view")
    public String dview(Model model) {

        model.addAttribute("depositView", true);

        return "admin/deposit/deposit_view";
    }

    // 1:1 게시판
    @GetMapping("/one_board_list")
    public String blist(Model model) {

        model.addAttribute("oneBoardList", true);

        return "admin/board/one_board_list";
    }

    // 1:1 게시판 상세보기
    @GetMapping("/one_board_view")
    public String bview(Model model) {

        model.addAttribute("oneBoardView", true);

        return "admin/board/one_board_view";
    }
}
