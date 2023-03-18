package com.project.questapp.services;

import com.project.questapp.repos.CommentRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    private CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository){

        this.commentRepository=commentRepository;
    }
}