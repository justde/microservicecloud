package org.justd.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.justd.springcloud.entities.Dept;

import java.util.List;

/**
 * @author: zhangjd
 * @Date: 2019/8/21 01:09
 * @Description:
 */
@Mapper
public interface DeptDao {
    public boolean addDept(Dept dept);

    public Dept findById(Long id);

    public List<Dept> findAll();

}
