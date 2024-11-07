package com.example.demo.service;

import com.example.demo.domain.Notice;
import com.example.demo.dto.NoticeDto;
import com.example.demo.dto.NoticeSearchCriteria;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface NoticeService {
    public Page<Notice> findByPage(int pageNo, int pageSize);
    public Page<Notice> findByPage(NoticeSearchCriteria criteria);
    public List<Notice> findAll();
    public Notice save(NoticeDto notice);
    public Notice findById(Integer id);
    public Notice update(Integer id, NoticeDto noticeDto);
    public void delete(Integer id);
}
