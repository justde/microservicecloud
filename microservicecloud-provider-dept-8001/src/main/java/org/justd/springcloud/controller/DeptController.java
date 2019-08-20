package org.justd.springcloud.controller;

import org.hibernate.validator.constraints.EAN;
import org.justd.springcloud.entities.Dept;
import org.justd.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: zhangjd
 * @Date: 2019/8/21 01:24
 * @Description:
 */
@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;

    @RequestMapping(value = "/dept/add", method = RequestMethod.POST)
    public boolean add(@RequestBody Dept dept) {
        return deptService.add(dept);
    }

    @RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
    public Dept get(@PathVariable("id") Long id) {
        return deptService.get(id);
    }

    @RequestMapping(value = "/dept/list", method = RequestMethod.GET)
    public List<Dept> getAll() {
        return deptService.list();
    }
}
