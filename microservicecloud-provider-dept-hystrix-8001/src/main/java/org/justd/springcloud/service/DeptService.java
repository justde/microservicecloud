package org.justd.springcloud.service;

import org.justd.springcloud.entities.Dept;

import java.util.List;

/**
 * @author: zhangjd
 * @Date: 2019/8/21 01:20
 * @Description:
 */
public interface DeptService {
    public boolean add(Dept dept);
    public Dept    get(Long id);
    public List<Dept> list();

}
