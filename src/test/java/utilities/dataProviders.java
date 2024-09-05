package utilities;

import org.testng.annotations.DataProvider;

public class dataProviders {
	
	@DataProvider(name="LoginData")
	public String [][] getAllData() throws Exception {
		String path = ".\\testData\\Opencart_LoginData.xlsx";
		ExcelUtils xl = new ExcelUtils(path);
		int totalrows= xl.getRowCount("Sheet1");
		int totalcols = xl.getCellCount("Sheet1",1);
		
		String logindata[][] = new String [totalrows][totalcols];
		for(int i=1;i<=totalrows;i++) {
			for(int j=0; j<totalcols; j++) {
				logindata[i-1][j] = xl.getCellData("Sheet1", i, j);
			}
		}
		return logindata;
		
	}
	
	/*@DataProvider(name="id")
	public String [] getUserNames() throws Exception {
		String path = System.getProperty("user.dir")+"//testPersonalData//personalSetOfDatas.xlsx";
		XLUtilities xl = new XLUtilities(path);
		int rownum= xl.getRowCount("Sheet1");
		String apidata[] = new String [rownum];
		for(int i=1; i<=rownum; i++) {
			apidata[i-1]= xl.getCellData("Sheet1", i, 0);
		}
		return apidata;
			
		
		}*/


}
