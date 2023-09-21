package com.wggglggg.mybatisplus02curdmapper;

import com.wggglggg.mybatisplus02curdmapper.mapper.UserMapper;
import com.wggglggg.mybatisplus02curdmapper.model.po.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static net.sf.jsqlparser.util.validation.metadata.NamedObject.user;

@SpringBootTest
class MybatisPlus02CurdMapperApplicationTests {

	@Autowired
	private UserMapper userMapper;
	@Test
	void testSelectById() {
		User user = (User) userMapper.selectById(1);
		System.out.println("user = " + user);

	}

	@Test
	public void testSelect(){
		List<User> userList = userMapper.selectList(null);
		userList.forEach(user -> {
			System.out.println("user = " + user);

		});
	}

	@Test
	public void testInsert(){
		User user = new User();
		user.setName("红雁");
		user.setAge(27);
		user.setEmail("hongyan@123.com");

		int rows = userMapper.insert(user);
	}


	@Test
	public void testDelete(){
		int rows = userMapper.deleteById(-748515327);

		System.out.println("rows = " + rows);
	}

	@Test
	public void testUpdate(){
		User user = new User();
		user.setId(6);
		user.setAge(25);

		int rows = userMapper.updateById(user);
		System.out.println("rows = " + rows);
	}

	@Test
	public void testUpdate_More(){
		User user = new User();
		user.setAge(25);
		// 修改条件为null, 默认改所有的用户
		int rows = userMapper.update(user, null);
		System.out.println("rows = " + rows);
	}

}
