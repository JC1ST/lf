package kr.co.lovefans.devel.service;


import kr.co.lovefans.devel.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SpringConfig {

    private final CreateSubLevelRepository createSubLevelRepository;
    private final SubsPostCustomRepository subsPostCustomRepository;
    private final SubsCustomRepository subsCustomRepository;
    private final SubscrRepository subscrRepository;

    private final MemberRepository memberRepository;
    private final CreatorRepository creatorRepository;
    private final CreatorPostRepository creatorPostRepository;
    private final SubListRepository subListRepository;

    @Autowired
    public SpringConfig(CreateSubLevelRepository createSubLevelRepository, SubsPostCustomRepository subsPostCustomRepository, SubsCustomRepository subsCustomRepository, SubscrRepository subscrRepository, MemberRepository memberRepository, CreatorRepository creatorRepository, CreatorPostRepository creatorPostRepository, SubListRepository subListRepository) {
        this.createSubLevelRepository = createSubLevelRepository;
        this.subsPostCustomRepository = subsPostCustomRepository;
        this.subsCustomRepository = subsCustomRepository;
        this.subscrRepository = subscrRepository;
        this.memberRepository = memberRepository;
        this.creatorRepository = creatorRepository;
        this.creatorPostRepository = creatorPostRepository;
        this.subListRepository = subListRepository;
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

        return new CreatorService(createSubLevelRepository, creatorRepository, memberRepository);
    }
    @Bean
    public CreatorPostService creatorPostService(){

        return new CreatorPostService(creatorPostRepository, subsPostCustomRepository);
    }

    @Bean
    public SubListService subListService(){
        return new SubListService(subListRepository);
    }

    @Bean
    public SubscrService subscrService(){
        return new SubscrService(subscrRepository,subsCustomRepository);
    }

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
