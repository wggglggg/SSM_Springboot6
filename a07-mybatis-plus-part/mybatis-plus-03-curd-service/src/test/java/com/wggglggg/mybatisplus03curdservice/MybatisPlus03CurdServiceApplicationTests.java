package com.wggglggg.mybatisplus03curdservice;

import com.wggglggg.mybatisplus03curdservice.model.po.User;
import com.wggglggg.mybatisplus03curdservice.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class MybatisPlus03CurdServiceApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    void testSave() {
        User user = new User();
        user.setName("蔡灿得");
        user.setAge(45);
        user.setEmail("ccd@133.com");

        boolean b = userService.save(user);
        System.out.println("b = " + b);
    }

    @Test
    public void testInsertMore(){
        User cmz = new User();
        cmz.setName("陈明真");
        cmz.setAge(45);
        cmz.setEmail("cmz@133.com");

        User zhm = new User();
        zhm.setName("周慧敏");
        zhm.setAge(50);
        zhm.setEmail("zhm@133.com");

        List<User> userList = Arrays.asList(cmz, zhm);

        userService.saveBatch(userList);
    }

    @Test
    public void testUpdate(){
        User cmz = new User();
        cmz.setId(8);
        cmz.setAge(43);

        boolean b = userService.updateById(cmz);
    }

    @Test
    public void testUpdateOrSave(){
//        User sshhll = new User();
//        sshhll.setName("苏慧伦");
//        sshhll.setAge(40);
//        sshhll.setEmail("sshhll@133.com");

        User sshhll = new User();
        sshhll.setId(10);
        sshhll.setEmail("shl@333.com");


        boolean b = userService.saveOrUpdate(sshhll);
    }

    @Test
    public void testRemove(){
        User sshhll = new User();
        sshhll.setId(10);

        boolean b = userService.removeById(sshhll);
    }

    @Test
    public void testGetOrList(){
        User user = userService.getById(9);
        System.out.println("user = " + user);

        List<User> userList = userService.list(null);
        userList.forEach(u -> {
            System.out.println("user = " + u);
        });
    }
}


