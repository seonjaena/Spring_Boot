package com.sj.board_project.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JoinUserDto {

    @Size(min = 2, max = 5, message = "이름은 2 ~ 5글자 사이입니다.")
    @Pattern(regexp = "[가-힣]*", message = "이름은 한글만 입력 가능합니다.")
    private String user_name;

    @Email(message = "이메일 형식을 지켜주세요.")
    @NotBlank(message = "이메일을 입력하세요.")
    private String user_email;

    @Size(min = 6, max = 15, message = "아이디는 6 ~ 15글자 사이입니다.")
    @Pattern(regexp = "[a-zA-Z0-9가-힣]*", message = "아이디는 영문 대소문자, 숫자, 한글만 입력 가능합니다.")
    private String user_id;

    @Size(min = 8, max = 20, message = "비밀번호는 8 ~ 20글자 사이입니다.")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&])[A-Za-z\\d$@$!%*#?&]{8,20}$", message = "비밀번호는 숫자, 문자, 특수문자 각각 1개 이상을 포함해야 합니다.")
    private String user_pw;

    @Size(min = 8, max = 20, message = "비밀번호는 8 ~ 20글자 사이입니다.")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&])[A-Za-z\\d$@$!%*#?&]{8,20}$", message = "비밀번호는 숫자, 문자, 특수문자 각각 1개 이상을 포함해야 합니다.")
    private String user_pw2;

    @Size(min = 2, max = 15, message = "닉네임은 2 ~ 15글자 사이입니다.")
    @Pattern(regexp = "[a-zA-Z0-9가-힣]*", message = "닉네임은 영문 대소문자, 숫자, 한글만 입력 가능합니다.")
    private String user_nickname;

    @NotBlank(message = "우편번호를 입력하세요.")
    private String zip_code;

    @NotBlank(message = "주소를 입력하세요.")
    private String main_addr;
    private String reference_addr;

    @NotBlank(message = "세부 주소를 입력하세요.")
    private String detail_addr;

    private boolean userIdExist;
    private boolean userNicknameExist;

}
