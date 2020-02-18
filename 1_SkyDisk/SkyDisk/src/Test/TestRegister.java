package Test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import Control.User;

public class TestRegister {

	@Test
	public void testUserRegister() {
		String target = "注册成功";
		User u = new User("162011190", "dv666", "123123", "1G", "15975631548", "dv666@qq.com");
		System.out.println(User.getUserid());
		try {
			String result = User.uRegister(User.getUserid(), User.getUsername(), User.getUserpassword(),
					User.getPhone(), User.getEmail());
			System.out.println(result);
			assertEquals(result, target);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
