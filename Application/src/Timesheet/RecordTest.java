package Timesheet;

import org.junit.*;
import static org.junit.Assert.*;

public class RecordTest {
   @Test
   public void assertE() {
	   RecordBean TestR = new RecordBean();
	   TestR.setEid("1010");
	   TestR.setDate("12/02/2015");
	   assertEquals(TestR.getDate(), "12/02/2015");
	   assertFalse(TestR.getEid() == "1012");
	   TestR.getDate().matches("(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d(?:,)");
   }
}
