package com.project.questapp.repos;

import com.project.questapp.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {
    List<Comment> findByUserIdAndPostId(Long userId, Long postId);
    List<Comment> findByUserId(Long userId);
    List<Comment> findByPostId(Long postId);

    @Query(value = "select * from comment where post_id in :postIds limit 5",nativeQuery = true)
    List<Comment> findUserCommentsByPostId(@Param("postIds") List<Long> postIds);

}
