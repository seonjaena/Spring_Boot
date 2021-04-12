package com.sj.board_project.service;

import com.sj.board_project.dto.user.JoinUserDto;
import com.sj.board_project.dto.user.SessionDto;
import com.sj.board_project.model.User;
import com.sj.board_project.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;

    public SessionDto login(String id, String pw) {

        User user = userRepository.login(id, pw);
        SessionDto sessionDto = new SessionDto();

        if(user != null) {
            sessionDto.setUser_idx(user.getUser_idx());
            sessionDto.setUser_name(user.getUser_name());
            sessionDto.setUser_nickname(user.getUser_nickname());
            sessionDto.setUser_id(user.getUser_id());
        }else {
            sessionDto = null;
        }
        return sessionDto;

    }

    @Transactional
    public void join(JoinUserDto joinUserDto) {
        User user = User.createJoinUser(joinUserDto.getUser_name(), joinUserDto.getUser_email(),
                joinUserDto.getUser_id(), joinUserDto.getUser_pw(), joinUserDto.getUser_nickname(),
                joinUserDto.getZip_code(), joinUserDto.getMain_addr(), joinUserDto.getReference_addr(), joinUserDto.getDetail_addr());
        userRepository.join(user);
    }

    public String checkUserIdExist(String user_id) {
        String user = userRepository.checkUserIdExist(user_id);
        if(user.equals("true")) {
            return "true";
        }else {
            return "false";
        }
    }

    public String checkUserNickNameExist(String user_nickname) {
        String user = userRepository.checkUserNickNameExist(user_nickname);
        if(user.equals("true")) {
            return "true";
        }else {
            return "false";
        }
    }

    @Transactional
    @Scheduled(cron = "0 0 1 * * ?")
    public void deleteUserId() {
        userRepository.deleteUserId();
    }

}
