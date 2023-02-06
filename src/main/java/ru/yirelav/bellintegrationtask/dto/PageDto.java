package ru.yirelav.bellintegrationtask.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;


@Data
@Builder
public class PageDto<T> {

    private List<T> content;
    private Integer totalElements;
    private Integer page;
    private Integer size;
    private Integer totalPages;

    public static <T> PageDto<T> fromPage(Page<T> page) {
        return new PageDto<>(
                page.getContent(),
                page.getSize(),
                page.getNumber(),
                page.getNumberOfElements(),
                page.getTotalPages()
        );
    }
}
