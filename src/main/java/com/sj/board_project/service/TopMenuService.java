package com.sj.board_project.service;

import com.sj.board_project.model.BoardType;
import com.sj.board_project.repository.TopMenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TopMenuService {

    private final TopMenuRepository topMenuRepository;

    public List<BoardType> getTopMenuList() {
        return topMenuRepository.getTopMenuList();
    }

}
