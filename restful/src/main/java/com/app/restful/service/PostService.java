package com.app.restful.service;


import com.app.restful.domain.dto.PostDTO;

import java.util.List;

public interface PostService {

    // 게시글 전체 조회
    public List<PostDTO> getAllPosts();

}
