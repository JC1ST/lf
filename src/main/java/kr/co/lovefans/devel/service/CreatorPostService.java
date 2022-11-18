package kr.co.lovefans.devel.service;


import kr.co.lovefans.devel.domain.CreatorPostDto;
import kr.co.lovefans.devel.dto.PostDto;
import kr.co.lovefans.devel.repository.CreatorPostRepository;
import kr.co.lovefans.devel.repository.SubsPostCustomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Transactional
public class CreatorPostService {

    @Autowired
    private final CreatorPostRepository creatorPostRepository;
    @Autowired
    private final SubsPostCustomRepository subsPostCustomRepository;

    public CreatorPostService(CreatorPostRepository creatorPostRepository, SubsPostCustomRepository subsPostCustomRepository) {
        this.creatorPostRepository = creatorPostRepository;
        this.subsPostCustomRepository = subsPostCustomRepository;
    }

    public CreatorPostDto registerImg(Long cpMiSeq, CreatorPostDto creatorPostDto, MultipartFile file) throws IOException {
        String projectPath = System.getProperty("user.dir") + "\\src\\main\\webapp\\imgFiles";
        /*String projectPath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\files";*/

        UUID uuid = UUID.randomUUID(); // 랜덤한 ID 부여

        String fileName = uuid + "_" + file.getOriginalFilename();

        File saveFile = new File(projectPath, fileName);
        String filePath = "/imgFiles/" + fileName;

        file.transferTo(saveFile);

        java.util.Date dt = new java.util.Date();
        java.sql.Date date = new java.sql.Date(dt.getTime());

        creatorPostDto.setCpRegdt(date);
        creatorPostDto.setCpModidt(date);
        creatorPostDto.setCpImg(filePath);

        CreatorPostDto post = creatorPostRepository.save(creatorPostDto);

        return post;
    }

    public List<CreatorPostDto> findBycpMiSeq(Long cpMiSeq){
        List<CreatorPostDto> list = creatorPostRepository.findBycpMiSeq(cpMiSeq);

        return list;
    }

    public Slice<CreatorPostDto> findSliceBycpMiSeq(Long cpMiSeq,int page){

        PageRequest pageRequest = PageRequest.of(page,3,Sort.Direction.DESC,"cpRegdt");
        Slice<CreatorPostDto> post = creatorPostRepository.findSliceBycpMiSeq(cpMiSeq, pageRequest);
        return post;

    };


    public List<PostDto> findPostByCpMiSeq(Long slvmiseq){
        List<PostDto> post = subsPostCustomRepository.findBySlvmiSeq(slvmiseq);
        return post;
    }







}
