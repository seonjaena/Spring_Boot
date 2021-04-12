package com.sj.board_project.repository;

import com.sj.board_project.model.BoardType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class TopMenuRepository {

    private final EntityManager em;

    public List<BoardType> getTopMenuList() {
        return em.createQuery("SELECT b FROM BoardType b ORDER BY b.board_type_idx", BoardType.class)
                .getResultList();
    }

}
