package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Control.ModelFactory;
import Control.User;

public class TestUpload {

	@Test
	public void testUserFrame() {
		//fail("Not yet implemented");
		String target = "文件上传成功";
		User.setUserid("162011108");
		String uid = User.getUserid();
		String result = ModelFactory.uploadFile("file", "result",uid);
		assertEquals(result, target);
		System.out.println(result);
	}

}
