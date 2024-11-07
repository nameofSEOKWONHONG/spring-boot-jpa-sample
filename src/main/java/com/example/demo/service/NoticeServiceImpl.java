package com.example.demo.service;

import com.example.demo.domain.Notice;
import com.example.demo.dto.NoticeDto;
import com.example.demo.dto.NoticeSearchCriteria;
import com.example.demo.repository.NoticeRepository;
import com.example.demo.specification.NoticeSpecification;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class NoticeServiceImpl implements NoticeService {
    @PersistenceContext
    private EntityManager entityManager;

    private final NoticeRepository noticeRepository;

    public NoticeServiceImpl(NoticeRepository noticeRepository) {
        this.noticeRepository = noticeRepository;
    }

    @Override
    public Page<Notice> findByPage(int pageNo, int pageSize) {
        var pageable =PageRequest.of(pageNo, pageSize);
        return noticeRepository.findAll(pageable);
    }

    @Override
    public Page<Notice> findByPage(NoticeSearchCriteria criteria) {
        var spec = Specification.where(NoticeSpecification.hasText(criteria.getText()))
                .and(NoticeSpecification.hasTitle(criteria.getTitle()))
                .and(NoticeSpecification.betweenDate(criteria.getDateFrom(), criteria.getDateTo()));

        var pageable = PageRequest.of(criteria.getPage(), criteria.getSize());

        return noticeRepository.findAll(spec, pageable);
    }

    private long getTotalCount(List<Predicate> predicates) {
        CriteriaBuilder qb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> cq = qb.createQuery(Long.class);
        cq.select(qb.count(cq.from(Notice.class)));
        if(predicates.size() > 0) {
            cq.where(predicates.toArray(new Predicate[predicates.size()]));
        }
        return entityManager.createQuery(cq).getSingleResult();
    }

    @Override
    public List<Notice> findAll() {
        return noticeRepository.findAll();
    }

    @Override
    public Notice save(NoticeDto noticeDto) {
        var notice = new Notice();
        notice.setTitle(noticeDto.getTitle());
        notice.setText(noticeDto.getText());
        notice.setDate(noticeDto.getDate().get());
        notice.setCreateBy("system");
        notice.setActive(true);
        notice.setLanguage("ko-KR");
        var now = new Date();
        notice.setCreateOn(now);
        return noticeRepository.save(notice);
    }

    @Override
    public Optional<Notice> findById(Integer id) {
        return noticeRepository.findById(id);
    }

    @Override
    public Notice update(Integer id, NoticeDto noticeDto) {
        var exists = noticeRepository.findById(id);
        if(!exists.isEmpty()) {
            if(!noticeDto.getTitle().isEmpty()) {
                exists.get().setTitle(noticeDto.getTitle());
            }

            if(!noticeDto.getText().isEmpty()) {
                exists.get().setText(noticeDto.getText());
            }

            if (noticeDto.getDate() != null){
                exists.get().setDate(noticeDto.getDate().get());
            }

            noticeRepository.save(exists.get());
        }

        return exists.get();
    }

    @Override
    public void delete(Integer id) {
        noticeRepository.deleteById(id);
    }
}
