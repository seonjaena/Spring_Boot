package com.sj.board_project.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "BOARD_TYPE")
@Getter
@Setter(AccessLevel.PRIVATE)
public class BoardType {

    @Id
    @Column(name = "BOARD_TYPE_IDX")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int board_type_idx;

    @Column(name = "BOARD_TYPE_NAME")
    private String board_type_name;

}
