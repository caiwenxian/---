package com.lendreimbursement.demo.bean.po;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 基础po
 *
 * @Author: [caiwenxian]
 * @Date: [2018-03-30 14:39]
 * @Description: [ ]
 * @Version: [1.0.0]
 */

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class BasePO implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", nullable = false, length = 36, updatable = false, insertable = false)
    private String id;

    @Column(columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间'", insertable = false, nullable = false)
    private LocalDateTime createTime;

    @Column(columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间' ", insertable = false, nullable = false)
    private LocalDateTime modifyTime;

    public BasePO() {
    }

    public BasePO(String id, LocalDateTime createTime, LocalDateTime modifyTime) {
        this.id = id;
        this.createTime = createTime;
        this.modifyTime = modifyTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
    }
}
