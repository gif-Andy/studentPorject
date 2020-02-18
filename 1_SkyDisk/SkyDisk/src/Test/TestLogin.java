package Test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import Control.ModelFactory;
import Control.User;

public class TestLogin {

	@Test
	public void testLogin() {
		String name = "162011108";
		String password = "123123";
		User u = null;
		User target = null;
		try {
			u = ModelFactory.uLogin(name, password);
			System.out.println(u);
			assertEquals(u, target);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	}

	

}
