package com.sj.board_project.service;

import com.sj.board_project.dto.user.SessionDto;
import com.sj.board_project.model.User;
import com.sj.board_project.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
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
}
