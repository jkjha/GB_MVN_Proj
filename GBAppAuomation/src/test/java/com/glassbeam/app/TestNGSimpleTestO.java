import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class TestNGSimpleTestO{
	@Test
	public void testAdd(){
		String str = "TestNG is working fine";
		assertEquals("TestNG is wor11king fine",str);
	}
}
