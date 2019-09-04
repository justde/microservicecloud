package org.justd.springcloud.service.impl;

import org.justd.springcloud.dao.DeptDao;
import org.justd.springcloud.entities.Dept;
import org.justd.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: zhangjd
 * @Date: 2019/8/21 01:21
 * @Description:
 */
@Service
public class DeptImpl implements DeptService {

    @Autowired
    private DeptDao deptDao;
    @Override
    public boolean add(Dept dept) {
        return deptDao.addDept(dept);
    }

    @Override
    public Dept get(Long id) {
        return deptDao.findById(id);
    }

    @Override
    public List<Dept> list() {
        return deptDao.findAll();
    }
}
