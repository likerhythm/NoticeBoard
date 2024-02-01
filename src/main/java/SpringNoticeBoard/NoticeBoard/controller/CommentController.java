package SpringNoticeBoard.NoticeBoard.controller;

import SpringNoticeBoard.NoticeBoard.service.CommentService;
import SpringNoticeBoard.NoticeBoard.domain.comment.dto.CommentDeleteDto;
import SpringNoticeBoard.NoticeBoard.domain.comment.dto.CommentSaveDto;
import SpringNoticeBoard.NoticeBoard.domain.comment.dto.CommentUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    //댓글 등록
    @PostMapping("/save")
    public String save(@ModelAttribute CommentSaveDto dto) {
        commentService.save(dto);
        return "redirect:/post/" + dto.getPostId();
    }

    //댓글 삭제
    @PostMapping("/delete")
    public String delete(@ModelAttribute CommentDeleteDto dto) {
        commentService.delete(dto.getId());
        return "redirect:/post/" + dto.getPostId();
    }

    //댓글 수정
    @PostMapping("/update")
    public String update(@ModelAttribute CommentUpdateDto dto) {
        commentService.update(dto.getText(), dto.getId());
        return "redirect:/post/" + dto.getPostId();
    }
}
