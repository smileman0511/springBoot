package com.app.rest.api;

import com.app.rest.domain.dto.ApiResponseDTO;
import com.app.rest.domain.dto.PostCreateRequestDTO;
import com.app.rest.domain.dto.PostDTO;
import com.app.rest.domain.dto.PostUpdateRequestDTO;
import com.app.rest.service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostAPI {
    private final PostService postService;

    // 모든 게시글 조회
    @Operation(summary = "게시판 목록", description = "게시판 목록 조회 서비스")
    @ApiResponse(responseCode = "200", description = "게시판 목록 조회 성공")
    @ApiResponse(responseCode = "404", description = "게시판 목록 조회 실패")
    @Parameter(
            name = "order",
            description = "게시글의 정렬을 처리하는 파라미터",
            schema = @Schema(type = "string"),
            required = true,
            in = ParameterIn.QUERY
    )
    @GetMapping("")
    public ResponseEntity<ApiResponseDTO> getAllPosts(
            @RequestParam(value = "order", defaultValue = "DESC") String order
    ) {
        List<PostDTO> postList = postService.getAllPosts(order);
//        .status: 상태코드 -> mdn 상태코드
//        .body: 응답 데이터 -> ApiResponseDTO
        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponseDTO.of("게시글 목록 조회 성공"), postList);
    }


    // 게시글 상세 조회
    @Operation(summary = "게시판 상세", description = "게시판 상세 조회 서비스")
    @ApiResponse(responseCode = "200", description = "게시판 상세 조회 성공")
    @Parameter(
            name = "id",
            description = "게시글 번호",
            required = true,
            in = ParameterIn.PATH,
            example = "1",
            schema = @Schema(type = "number")
    )
    @GetMapping("/{id}")
    public PostDTO getPost(Long id) {
        return postService.getPost(id);
    }


    // 게시글 작성
    @Operation(summary = "게시글 작성", description = "게시글 작성 서비스")
    @ApiResponse(responseCode = "200", description = "게시글 작성 성공")
    @PostMapping("/create")
    public void createPost(@RequestBody PostCreateRequestDTO postCreateRequestDTO) {
        postService.createPost(postCreateRequestDTO, 1212L);
    }


    // 게시글 수정
    @Operation(summary = "게시글 수정", description = "게시글 수정 서비스")
    @ApiResponse(responseCode = "200", description = "수정 성공")
    @Parameter(
            name = "id",
            description = "게시글 번호",
            required = true,
            in = ParameterIn.PATH,
            example = "1",
            schema = @Schema(type = "number")
    )
    @PutMapping("/{id}")
    public void updatePost(@RequestBody PostUpdateRequestDTO postUpdateRequestDTO, @PathVariable Long id) {
        postService.updatePost(postUpdateRequestDTO, id);
    }


    // 게시글 삭제
    @Operation(summary = "게시글 삭제", description = "게시글 삭제 서비스")
    @ApiResponse(responseCode = "200", description = "게시글 삭제 성공")
    @Parameter(
            name = "id",
            description = "게시글 번호",
            required = true,
            in = ParameterIn.PATH,
            example = "1",
            schema = @Schema(type = "number")
    )
    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id) {
        postService.deletePost(id);
    }

}
