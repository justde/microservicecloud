package org.justd.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author: zhangjd
 * @Date: 2019/8/21 00:37
 * @Description:
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
@Builder
public class Dept implements Serializable {
    private Long deptno;    //主键
    private String dname;   //部门名称
    private String db_Source;//来自哪个数据库，因为微服务架构可以一个服务对应一个数据库，同一个信息存储到不同的数据库
}
