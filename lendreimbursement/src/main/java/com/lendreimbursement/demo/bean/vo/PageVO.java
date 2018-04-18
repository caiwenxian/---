package com.lendreimbursement.demo.bean.vo;

import java.util.List;

/**
 *
 * @Author: [caiwenxian]
 * @Date: [2018-04-02 11:37]
 * @Description: [ ]
 * @Version: [1.0.0]
 */
public class PageVO<T> {

    List<T> content;

    long totalSize;

    public PageVO(List content, long totalSize) {
        this.content = content;
        this.totalSize = totalSize;
    }

    @Override
    public String toString() {
        return "PageVO{" +
                "content=" + content +
                ", totalSize=" + totalSize +
                '}';
    }

    public List getContent() {
        return content;
    }

    public void setContent(List content) {
        this.content = content;
    }

    public long getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(long totalSize) {
        this.totalSize = totalSize;
    }
}
