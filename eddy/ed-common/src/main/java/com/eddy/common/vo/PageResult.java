package com.eddy.common.vo;

import lombok.Data;

import java.util.List;

@Data
public class PageResult<T> {
    private Long total; // total number
    private Integer totalPages; // total page
    private List<T> items; // Current Page

    public PageResult() {
    }

    public PageResult(Long total, List<T> items) {
        this.total = total;
        this.items = items;
    }

    public PageResult(Long total, Integer totalPages, List<T> items) {
        this.total = total;
        this.totalPages = totalPages;
        this.items = items;
    }

}
