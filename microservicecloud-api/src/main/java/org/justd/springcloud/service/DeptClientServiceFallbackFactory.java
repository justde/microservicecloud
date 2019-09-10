package org.justd.springcloud.service;

import feign.hystrix.FallbackFactory;
import org.justd.springcloud.entities.Dept;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author: zhangjd
 * @Date: 2019/9/10 22:47
 * @Description:
 */
@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {
    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public Dept get(long id) {
                return new Dept().setDeptno(id)
                        .setDname("该ID " + id + "没有对应的信息 from Hystrix")
                        .setDb_Source("null");
            }

            @Override
            public List<Dept> list() {
                return null;
            }

            @Override
            public boolean add(Dept dept) {
                return false;
            }
        };
    }
}
