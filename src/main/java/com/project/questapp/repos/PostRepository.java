package com.project.questapp.repos;

import com.project.questapp.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Long> {

    @Query(value = "select p from posts p where p.user_id= :userId",
            nativeQuery = true)
    List<Post> findByUserId(@Param("userId") Long userId);
}
