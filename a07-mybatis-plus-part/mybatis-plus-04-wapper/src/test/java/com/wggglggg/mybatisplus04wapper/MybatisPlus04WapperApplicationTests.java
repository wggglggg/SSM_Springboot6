package com.wggglggg.mybatisplus04wapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wggglggg.mybatisplus04wapper.mapper.UserMapper;
import com.wggglggg.mybatisplus04wapper.model.po.User;
import com.wggglggg.mybatisplus04wapper.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static net.sf.jsqlparser.util.validation.metadata.NamedObject.user;

@SpringBootTest
class MybatisPlus04WapperApplicationTests {

    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;
    
    @Test
    void testSaveOrUpdate() {
        //查询用户名包含a like，年龄在20到30之间，并且邮箱不为null的用户信息
        LambdaUpdateWrapper<User> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        lambdaUpdateWrapper.like(User::getName, "周")
                .between(User::getAge, 40, 50)
                .isNotNull(User::getEmail)
                .set(User::getEmail, "ssss@333.com");

        LambdaUpdateWrapper<User> lambdaUpdateWrapper1 = new LambdaUpdateWrapper<>();
        lambdaUpdateWrapper1.like(User::getName, "Tom")
                        .between(User::getId, 3,3)
                                .set(User::getAge, 33);

        userService.update(null, lambdaUpdateWrapper1);
    }
    
    @Test
    public void test(){

        //将年龄大于20并且用户名中包含有a或邮箱为null的用户信息修改
        //UPDATE t_user SET age=?, email=? WHERE name LIKE ? AND age > ? OR email IS NULL)

        //QueryWrapper修改 【条件】
        //1.准备要修改的实体类数据
        //2.不能改为null

        //UpdateWrapper修改 【条件，修改】
        //1.直接携带修改数据 set("列名","值")
        //2.指定任意修改值 set("列明",null)

        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.ge(User::getAge, 27);

        List<User> userList = userService.list(lambdaQueryWrapper);

        userList.forEach(user1 -> {
            System.out.println("user1 = " + user1);
        });
    }

    @Test
    public void testDelete(){

        boolean b = userService.removeById(8);

        List<User> userList = userService.list();

        userList.forEach(u->{
            System.out.println("user = " + u);
        });
    }

    @Test
    public void testSelect(){
//        LambdaUpdateWrapper<User> lambdaUpdateWrapper = new LambdaUpdateWrapper();
//        lambdaUpdateWrapper.set(User::getDeleted, 0);
//
//        boolean b = userService.update(lambdaUpdateWrapper);

//        UpdateWrapper<User> userUpdateWrapper = new UpdateWrapper<>();
//        userUpdateWrapper.eq("deleted", 1).set("deleted", 0);
//
//        userMapper.update(null, userUpdateWrapper);
//        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
//        lambdaQueryWrapper.like(User::getDeleted, 1);
//
//        List<User> userList = userService.list(lambdaQueryWrapper);
//        userList.forEach(user1 -> {
//            System.out.println("user1 = " + user1);
//        });
        User user1 = new User();
        user1.setId(9);
        userMapper.updateDelete(user1);

        List<User> users = userMapper.selectAllDeletedIs1();
        users.forEach(user2 -> {
            System.out.println("user2 = " + user2);
        });
    }

    @Test
    public void testPage(){
        Page<User> page = new Page<>(3, 3);

        userService.page(page);

        List<User> list = page.getRecords();
        list.forEach(user1 -> {
            System.out.println("user1 = " + user1);
        });

        System.out.println("当前面 = " + page.getCurrent());
        System.out.println("每页显示行数 = " + page.getSize());
        System.out.println("总行数 = " + page.getTotal());     // 排除掉被逻辑删除的结果
        System.out.println(" 总页码数= " +page.getPages());
        System.out.println(" 是否上一页 = " + page.hasPrevious());
        System.out.println("是否有下一页 = " + page.hasNext());


    }

    @Test
    public void testSelectAll(){
        IPage page = new Page(3, 3);
        userMapper.selectAllIncludeDeleted(page);
        List userList = page.getRecords();
        userList.forEach(user ->{
            System.out.println("user = " + user);
        });


        System.out.println("当前页 = " +page.getCurrent());
        System.out.println("总页数 = " + page.getPages());
        System.out.println("记录总条数 = " + page.getTotal());

    }

    @Test
    public void testUpdate(){
        // 开了OptimisticInterceptor乐观锁, 同时修改某一个值时，根据数据表version不同，会允许第一次修改
        LambdaQueryWrapper<User> lambdaQueryWrapper =  new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getId, 1);

        User user1 = userService.getById(1);
        User user2 = userService.getById(1);


        user1.setAge(33);
        user2.setAge(35);

        userService.update(user1, lambdaQueryWrapper);
        userService.update(user2, lambdaQueryWrapper);


    }

}
