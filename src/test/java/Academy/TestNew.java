package Academy;

import com.test.utility.Xls_Reader;

public class TestNew {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Xls_Reader reader=new Xls_Reader("E:\\New Selenium\\DemoFramework\\src\\main\\java\\com\\testData\\provisioningFormLogindetails.xlsx",0);
	    String accountname=reader.getCellData("logindetails", "partner name", 2);
	    System.out.println(accountname);
	    //String cellText = String.valueOf(cell.getNumericCellValue());
	}
	

}
