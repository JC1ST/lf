package kr.co.lovefans.devel.service;

import kr.co.lovefans.devel.repository.PushMsgRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;

@Transactional
public class PushService {

    @Autowired private final PushMsgRepository pushMsgRepository;

    public PushService(PushMsgRepository pushMsgRepository) {

        this.pushMsgRepository = pushMsgRepository;
    }



}
