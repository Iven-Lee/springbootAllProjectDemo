package com.iven.springboot.web;

import com.alibaba.dubbo.config.annotation.Reference;
import com.iven.springboot.model.SqlName;
import com.iven.springboot.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class StudentController {



    /*
        1.@Autowired
        SpringBoot项目中常用。简单来说就是引入由Spring容器管理的bean。
        2.@Resource
        作用相当于@Autowired，只不过@Autowired是byType自动注入，而@Resource默认byName自动注入。
        3.@Reference
        @Reference是dubbo的注解，也是注入，他一般注入的是分布式的远程服务的对象，需要dubbo配置使用。
        简单来说他们的区别：
        @Reference注入的是分布式中的远程服务对象，@Resource和@Autowired注入的是本地spring容器中的对象。
    */
    @Reference(interfaceClass = StudentService.class,version = "1.0.0",check = false)
    private StudentService service;

    //注册学生
    @RequestMapping(path = "/addStudent")
    public ModelAndView addStudent(SqlName sqlName){
        ModelAndView mv = new ModelAndView();
        String tips = "注册失败";
        //调用service处理student
        int nums = service.addStudent(sqlName);
        if( nums > 0 ){
            //注册成功
            tips = "学生【" + sqlName.getUserName() + "】注册成功";
            System.out.println(tips);
        }
        //添加数据
        mv.addObject("tips" , tips);
        //指定结果页面
        mv.setViewName("studentDetail");
        return mv;
    }


    //处理查询，响应ajax
    @RequestMapping(path = "/queryStudent")
    @ResponseBody
    public List<SqlName> queryStudent(){
        //参数检查， 简单的数据处理
        List<SqlName> students = service.findStudents();
        return students;
    }

}

