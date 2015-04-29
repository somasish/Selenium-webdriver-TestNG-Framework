package TestClasses;

import com.abc.util.PropertyFileRead;

public class TestClass {
	
	static PropertyFileRead PropertyFileRead = new PropertyFileRead();
	static String SelectQuery = PropertyFileRead.FileRead("DBDetails.properties","DatabasePassword");
	public static void main(String[] args) {
		
System.out.println(SelectQuery);
	}

}
