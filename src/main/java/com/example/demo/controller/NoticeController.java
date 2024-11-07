package com.example.demo.controller;

import com.example.demo.domain.Notice;
import com.example.demo.dto.NoticeDto;
import com.example.demo.dto.NoticeSearchCriteria;
import com.example.demo.dto.PaginatedResponse;
import com.example.demo.service.NoticeServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/notice")
public class NoticeController {
    private final NoticeServiceImpl noticeService;

    public NoticeController(NoticeServiceImpl noticeService) {
        this.noticeService = noticeService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Notice> getNoticeByID(@PathVariable("id") int id) {
        var notice = noticeService.findById(id);
        return ResponseEntity.ok(notice);
    }

    @GetMapping()
    public ResponseEntity<List<Notice>> getNotices() {
        var notices = noticeService.findAll();
        return ResponseEntity.ok(notices);
    }

    @GetMapping("/{page}/{size}")
    public ResponseEntity<PaginatedResponse<Notice>> getNoticePage(@PathVariable int page, @PathVariable int size) {
        var result = noticeService.findByPage(page, size);
        var response = new PaginatedResponse<>(
                result.getContent(),
                result.getTotalElements(),
                result.getTotalPages(),
                result.getNumber(),
                result.getSize()
        );
        return ResponseEntity.ok(response);
    }

    @PostMapping("/notices")
    public ResponseEntity<PaginatedResponse<Notice>> getNoticePage(@RequestBody NoticeSearchCriteria criteria) {
        var result = noticeService.findByPage(criteria);
        var response = new PaginatedResponse<>(
                result.getContent(),
                result.getTotalElements(),
                result.getTotalPages(),
                result.getNumber(),
                result.getSize()
        );
        return ResponseEntity.ok(response);
    }

    @PostMapping()
    public ResponseEntity<Notice> createNotice(@RequestBody NoticeDto noticeDto) {
        var result = noticeService.save(noticeDto);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Notice> updateNotice(@PathVariable int id, @RequestBody NoticeDto noticeDto) {
        var result = noticeService.update(id, noticeDto);
        return ResponseEntity.ok(result);
    }

    @PatchMapping("/{id}/{title}/{text}")
    public ResponseEntity<Notice> updateNotice(@PathVariable int id, @PathVariable String title, @PathVariable String text) {
        var result = noticeService.update(id, new NoticeDto(title, text, null));
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Notice> deleteNotice(@PathVariable("id") int id) {
        noticeService.delete(id);
        return ResponseEntity.ok(null);
    }
}
