package com.project.questapp.repos;

import com.project.questapp.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface PostRepository extends JpaRepository<Post,Long> {

    List<Post> findAllByUser_Id(Long userId);

    @Query(value="select id from posts where user_id = :userId order by created_date desc limit 5",nativeQuery = true)
    List<Long> findTopByUserId(@Param("userId") Long userId);
}