package SpringNoticeBoard.NoticeBoard.controller;

import SpringNoticeBoard.NoticeBoard.domain.comment.Comment;
import SpringNoticeBoard.NoticeBoard.domain.comment.CommentRepository;
import SpringNoticeBoard.NoticeBoard.service.CommentService;
import SpringNoticeBoard.NoticeBoard.domain.comment.dto.CommentDeleteDto;
import SpringNoticeBoard.NoticeBoard.domain.comment.dto.CommentSaveDto;
import SpringNoticeBoard.NoticeBoard.domain.comment.dto.CommentUpdateDto;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;
    private final CommentRepository commentRepository;

    //댓글 등록
    @PostMapping("/save")
    public String save(@Validated @ModelAttribute CommentSaveDto dto,
                       BindingResult bindingResult,
                       HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            log.error("error={}", bindingResult);
            return "redirect:/post/" + dto.getPostId();
        }
        String loginUserName = (String) request.getAttribute("loginUserName");
        commentService.save(dto, loginUserName);
        return "redirect:/post/" + dto.getPostId();
    }

    //댓글 삭제
    @PostMapping("/remove")
    public String remove(@ModelAttribute CommentDeleteDto dto) {
        commentService.remove(dto.getId());
        return "redirect:/post/" + dto.getPostId();
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable Long id, Model model) {
        Comment comment = commentRepository.findById(id);
        model.addAttribute("comment", comment);
        return "updateCommentForm";
    }

    //댓글 수정
    @PostMapping("/update")
    public String update(@ModelAttribute CommentUpdateDto dto) {
        commentService.update(dto.getText(), dto.getId());
        return "redirect:/post/" + dto.getPostId();
    }
}
