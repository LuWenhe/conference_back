package edu.conf.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;

/**
 * 新闻分页类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewsPaging {

    List<Object> records = Collections.emptyList();    // 查询数据列表
    long total;          // 总数
    long size;           // 每页显示条数, 默认是10
    long current;        // 当前页
    boolean previous;    // 是否存在上一页
    boolean hasNext;     // 是否存在下一页

}
