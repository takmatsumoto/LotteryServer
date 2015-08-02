/**
 * 
 */
package HTMLPathCollector;

import java.util.ArrayList;
import java.util.Calendar;
/**
 * @author takmatsumoto
 *
 */
public abstract class AbstractLotteryDataDownloadPathCollector {
	public enum LotteryType {  
		LotteryType_539, 
		LotteryType_BigLottery, 
		LotteryType_Power38, 
		LotteryType_Star4,
		LotteryType_40
	}
	
	final private String basePath = "http://www.nfd.com.tw/lottery/";
	
	public String relativePath = "";
	public int baseYear = 0;
	public ArrayList<String> htmlDownloadPaths = new ArrayList<String>();
	/**
	 * @param relativePath TODO
	 * @param baseYear TODO
	 * 
	 */
	public AbstractLotteryDataDownloadPathCollector(String relativePath, int baseYear) {
		// TODO Auto-generated constructor stub
		this.relativePath = relativePath;
		this.baseYear = baseYear;
	}
	
	public void createDownloadPathList () {
		for (int i = baseYear; i <= numberOfCurrentYear(); i++) {
			String fullHTMLPath = basePath + String.format(relativePath, i);
			htmlDownloadPaths.add(fullHTMLPath);
		}
	}
	
	public int numberOfCurrentYear () {
		Calendar calendar = Calendar.getInstance();
		return calendar.get(Calendar.YEAR);
	}
	
	public String currentYearDownloadPath() { 
		try {
			return htmlDownloadPaths.get(htmlDownloadPaths.size()-1);
		} catch (Exception e) {	
			// TODO: handle exception
			System.out.println(e.getMessage());
			return ""; 
		}
		
	}
	
	public String getDownloadPath(int year) {
		int index = year-baseYear;
		try {
			return htmlDownloadPaths.get(index);
		} catch (Exception e) {
			// TODO: handle exception
			String errorMsg = "Power38 Path Error : " + e.getMessage() + ". return current year path";
			System.out.println(errorMsg);
			return basePath + String.format(relativePath, baseYear);
		}
	}
	
	public void dataPrint () {
		for (String string : htmlDownloadPaths) {
			System.out.println(string);
		}
	}
	
	abstract LotteryType type () ;

}
