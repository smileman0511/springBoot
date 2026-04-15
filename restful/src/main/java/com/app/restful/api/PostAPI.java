package com.app.restful.api;

import com.app.restful.domain.dto.PostDTO;
import com.app.restful.domain.dto.PostInsertRequestDTO;
import com.app.restful.domain.dto.PostListRequestDTO;
import com.app.restful.domain.dto.PostUpdateRequestDTO;
import com.app.restful.domain.vo.PostVO;
import com.app.restful.service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostAPI {

    private final PostService postService;

    @Operation(summary = "게시글 작성 서비스", description = "제목, 내용을 받아서 게시글을 작성하는 서비스")
    @ApiResponse(responseCode = "200", description = "게시글 작성 성공")
    @PostMapping("/register")
    public void registerPost(@RequestBody PostInsertRequestDTO postInsertRequestDTO) {
        PostVO postVO = new PostVO();
        postVO.setPostTitle(postInsertRequestDTO.getPostTitle());
        postVO.setPostContent(postInsertRequestDTO.getPostContent());
        postVO.setMemberId(postInsertRequestDTO.getMemberId());
        postService.registerPost(postVO);
    }

    @Operation(summary = "게시글 목록 조회 서비스", description = "게시글의 목록을 조회하는 서비스")
    @ApiResponse(responseCode = "200", description = "게시글 목록 조회 성공")
    @GetMapping("")
    public List<PostListRequestDTO> getAllPosts() {
        return postService.getAllPosts();
    }

    @Operation(summary = "게시글 상세보기 조회 서비스", description = "게시글의 상세 내용을 조회하는 서비스")
    @ApiResponse(responseCode = "200", description = "게시글 상세 내용 조회 성공")
    @GetMapping("/{id}")
    public PostDTO getPostById(@PathVariable Long id) {
        return postService.getPostById(id);
    }

    @Operation(summary = "게시글 수정 서비스", description = "게시글의 제목과 내용을 수정하는 서비스")
    @ApiResponse(responseCode = "200", description = "게시글 수정 성공")
    @PutMapping("/{id}")
    public void updatePost(@PathVariable Long id, @RequestBody PostUpdateRequestDTO dto) {
        PostVO postVO = new PostVO();
        postVO.setId(id);
        postVO.setPostTitle(dto.getPostTitle());
        postVO.setPostContent(dto.getPostContent());
        postService.updatePost(postVO);
    }

    @Operation(summary = "게시글 삭제 서비스", description = "게시글 삭제하는 서비스")
    @ApiResponse(responseCode = "200", description = "게시글 삭제 성공")
    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id) {
        postService.deletePost(id);
    }

    @Operation(summary = "게시글 삭제(탈퇴시) 서비스", description = "탈퇴했을 때 게시글 삭제하는 서비스")
    @ApiResponse(responseCode = "200", description = "게시글 삭제 성공")
    @DeleteMapping("/member/{memberId}")
    public void deleteAllPosts(@PathVariable Long memberId) {
        postService.deletePostByMemberId(memberId);
    }
}