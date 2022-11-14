package kr.co.lovefans.devel.service;


import kr.co.lovefans.devel.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SpringConfig {

    private final SubsPostCustomRepository subsPostCustomRepository;

    private final MemberRepository memberRepository;
    private final CreatorRepository creatorRepository;
    private final CreatorPostRepository creatorPostRepository;
//    private final SubListRepository subListRepository;

    private final AdminRepository adminRepository;

    @Autowired
    public SpringConfig(SubsPostCustomRepository subsPostCustomRepository, MemberRepository memberRepository, CreatorRepository creatorRepository, CreatorPostRepository creatorPostRepository, AdminRepository adminRepository) {
        this.subsPostCustomRepository = subsPostCustomRepository;
        this.memberRepository = memberRepository;
        this.creatorRepository = creatorRepository;
        this.creatorPostRepository = creatorPostRepository;
        this.adminRepository = adminRepository;
    }
//    private DataSource dataSource;


//    private EntityManager em;
//
//    @Autowired
//    public SpringConfig(EntityManager em){
//        this.em = em;
//    }

    @Bean
    public MemberService memberService(){

        return new MemberService(memberRepository);
    }
    @Bean
    public CreatorService creatorService(){

        return new CreatorService(creatorRepository, memberRepository);
    }
    @Bean
    public CreatorPostService creatorPostService(){

        return new CreatorPostService(creatorPostRepository, subsPostCustomRepository);
    }

    @Bean
    public AdminService adminService() {

        return new AdminService(adminRepository);
    }

//    @Bean
//    public SubListService subListService(){
//        return new SubListService(subListRepository);
//    }

//    @Bean
//    public MemberRepository memberRepository(){

    //return new MemoryMemberRepository();
    //return new JdbcTemplateMemberRepository(dataSource);
//        return new JpaMemberRepository(em);
//    }


//    private final MemberRepository memberRepository;
//
//    public SpringConfig(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }
//
//    @Bean
//    public MemberService memberService(){
//        return new MemberService(memberRepository);
//    }
//
//    @Bean
//    public MemberRepository memberRepository(){
//        return new MemoryMemberRepository();
//    }
}