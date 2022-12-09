package kr.co.lovefans.devel.service;


import kr.co.lovefans.devel.domain.SubListDto;
import kr.co.lovefans.devel.repository.SubListRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
public class SubListService {

    @Autowired
    private final SubListRepository subListRepository;

    public SubListService(SubListRepository subListRepository) {
        this.subListRepository = subListRepository;
    }


    public Optional<SubListDto> checkBySeq(Long cSeq, Long vSeq){
        Optional<SubListDto> subListDto = subListRepository.checkBySeq(cSeq, vSeq);

        return subListDto;
    }

    public Long save(SubListDto subListDto){

        /**
         * 시간을 여기서?
         * */
        java.util.Date dt = new java.util.Date();
        java.sql.Date date = new java.sql.Date(dt.getTime());
        subListDto.setSlRegdt(date);
        subListRepository.save(subListDto);

        return subListDto.getSubListDtoId().getSlCMiSeq();
    }

    public void delete(SubListDto subListDto){

        subListRepository.delete(subListDto);
    }


    public Long count(Long seq){
        return subListRepository.countBySlCMiSeq(seq);
    }


}

