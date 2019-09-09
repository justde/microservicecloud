package org.justd.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.justd.springcloud.entities.Dept;
import org.justd.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: zhangjd
 * @Date: 2019/8/21 01:24
 * @Description:
 */
@RestController
@Slf4j
public class DeptController {
    @Autowired
    private DeptService deptService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/dept/add", method = RequestMethod.POST)
    public boolean add(@RequestBody Dept dept) {
        return deptService.add(dept);
    }

    @RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "processHystrixGet")
    public Dept get(@PathVariable("id") Long id) {
        Dept dept = deptService.get(id);
        if (dept == null){
            throw new RuntimeException("该ID "+id +"没有对应的信息");
        }
        return dept;
    }

    public Dept processHystrixGet(@PathVariable("id") Long id){
        return new Dept().setDeptno(id)
                .setDname("该ID "+id +"没有对应的信息 from Hystrix")
                .setDb_Source("null");

    }


    @RequestMapping(value = "/dept/list", method = RequestMethod.GET)
    public List<Dept> getAll() {
        return deptService.list();
    }

    @RequestMapping(value = "/dept/discovery", method = RequestMethod.GET)
    public Object discory(){
        List<String> list = discoveryClient.getServices();
        log.info("discoveryClient.getService():{}",list);

        List<ServiceInstance> instances = discoveryClient.getInstances("microservicecloud-dept");
        instances.forEach(ele ->{
            log.info(ele.getServiceId() + "\n" +ele.getHost() +"\n" +ele.getPort() + "\n"+ ele.getUri() + "\n"+ ele.getMetadata());
        });
        return discoveryClient;
    }
}
