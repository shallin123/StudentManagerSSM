package com.shallin.page;

import org.springframework.stereotype.Component;

/**
 * 分页类封装
 * @author shallin
 *
 */
@Component
public class Page {
    private int page;

    private int rows ;

    private  int offset;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int row) {
        this.rows = row;
    }

    public int getOffset() {
        this.offset = (page -1)*rows;
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = (page-1)*rows;
    }

}
