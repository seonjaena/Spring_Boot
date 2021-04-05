package com.sj.board_project.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter(AccessLevel.PRIVATE)
public class User {

    @Column(name = "USER_IDX")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_idx;

    @Column(name = "USER_NAME")
    private String user_name;

    @Column(name = "USER_EMAIL")
    private String user_email;

    @Column(name = "USER_ID")
    private String user_id;

    @Column(name = "USER_PW")
    private String user_pw;

    @Column(name = "USER_NICKNAME")
    private String user_nickname;

    @Column(name = "IS_DELETE")
    private int is_delete;

    @Column(name = "ZIP_CODE")
    private String zip_code;

    @Column(name = "MAIN_ADDR")
    private String main_addr;

    @Column(name = "REFERENCE_ADDR")
    private String reference_addr;

    @Column(name = "DETAIL_ADDR")
    private String detail_addr;

}
