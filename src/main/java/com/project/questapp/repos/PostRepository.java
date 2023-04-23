package com.project.questapp.repos;

import com.project.questapp.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface PostRepository extends JpaRepository<Post,Long> {

    List<Post> findAllByUser_Id(Long userId);
}
