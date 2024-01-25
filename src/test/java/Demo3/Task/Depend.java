package Demo3.Task;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Depend {
	@Test
 void startcar() {
	System.out.println("car started");
	Assert.fail();
}
	@Test(dependsOnMethods = {"startcar"})
 void drivecar() {
	 System.out.println("car driving");
	
}
	@Test(dependsOnMethods = {"drivecar"})
 void stopcar() {
	System.out.println("car stopped");
	}

	@Test(dependsOnMethods = {"drivecar","startcar"},alwaysRun = true)
 void parkcar() {
		System.out.println("car parked");
	}
}
