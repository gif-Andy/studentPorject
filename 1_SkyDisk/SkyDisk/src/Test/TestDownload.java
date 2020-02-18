package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Control.ModelFactory;
import Control.MyRender_3;
import Control.MyRender_5;
import Control.ShareTableModel;
import Control.TableModel;
import Control.User;

public class TestDownload {

	@Test
	public void testMyRender_5() {
		//fail("Not yet implemented");
		
		User.setUserid("162011108");
		String uid = User.getUserid();
		boolean target = true;
		
		try {
			boolean ifDownload = ModelFactory.download("123" ,uid);
			assertEquals(ifDownload, target);
			System.out.println(ifDownload);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
