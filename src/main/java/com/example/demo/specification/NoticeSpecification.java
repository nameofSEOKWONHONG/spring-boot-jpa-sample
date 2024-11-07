package com.example.demo.specification;

import com.example.demo.domain.Notice;
import org.springframework.data.jpa.domain.Specification;

import java.util.Date;

public class NoticeSpecification {
    public static Specification<Notice> hasTitle(final String title) {
        return (root, query, builder) ->
                title == null ? builder.conjunction() : builder.like(builder.lower(root.get("title")), '%' + title + '%');
    }

    public static Specification<Notice> hasText(final String text) {
        return (root, query, builder) ->
                text == null ? builder.conjunction() : builder.like(builder.lower(root.get("text")), '%' + text + '%');
    }

    public static Specification<Notice> betweenDate(final Date from, final Date to) {
        return (root, query, builder) -> {
            if(from != null && to != null) {
                return builder.between(root.get("date"), from, to);
            }

            return builder.conjunction();
        };
    }
}
