package com.sj.board_project.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter(AccessLevel.PRIVATE)
public class Board {

    @Id
    @Column(name = "BOARD_IDX")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int board_idx;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BOARD_TYPE_IDX")
    private BoardType boardType;

    @Column(name = "BOARD_WRITER")
    private String board_writer;

    @Column(name = "BOARD_TITLE")
    private String board_title;

    @Column(name = "BOARD_TEXT")
    private String board_text;

    @Column(name = "BOARD_DATE")
    private LocalDateTime board_date;

    @Column(name = "BOARD_VIEWS")
    private int board_views;

    @Column(name = "BOARD_RECOMMENDATION")
    private int board_recommendation;

    @Column(name = "IS_DELETE")
    private int is_delete;

    @Column(name = "IS_MODIFIED")
    private int is_modified;

    @Column(name = "IS_HOT")
    private int is_hot;

}
