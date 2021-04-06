package com.sj.board_project.validation;

import com.sj.board_project.dto.user.JoinUserDto;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class JoinValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return JoinUserDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        JoinUserDto joinUserDto = (JoinUserDto) target;

        if(!joinUserDto.getUser_pw().equals(joinUserDto.getUser_pw2())) {
            errors.rejectValue("user_pw", "notEqual", "비밀번호가 일치하지 않습니다.");
            errors.rejectValue("user_pw2", "notEqual", "비밀번호가 일치하지 않습니다.");
        }

        if(!joinUserDto.isUserIdExist()) {
            errors.rejectValue("user_id", "notDupIdCheck", "아이디 중복 체크를 해주세요.");
        }

        if(!joinUserDto.isUserNicknameExist()) {
            errors.rejectValue("user_nickname", "notDupNickCheck", "닉네임 중복 체크를 해주세요.");
        }

    }
}
