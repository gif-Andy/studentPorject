package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Control.File;
import Control.User;

public class TestSearch {
	Object[][] datas = null;

	@Test
	public void testUserFrame() {
	
		//fail("Not yet implemented");
		User.setUserid("162011108");
		String uid = User.getUserid();
		String searchTxt = "z";
		int target = 0;
		datas = File.convery(uid, searchTxt);
	    int res = datas.length;
		System.out.println(res);
		if(res != 0){
			for(int i = 0; i<=datas.length;i++){
				System.out.println(datas[i][0]);
			}
		}
		assertEquals(res, target);
	}

}
