/**
 * 管理樂透資料的物件
 * 1.初始化
 * 		a.先從DB仔入所有開講資訊
 * 		b.觸發網路資料更新
 */
package HTMLParser;

import java.io.File;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.FileWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Calendar;

/**
 * @author takmatsumoto
 *
 */
public class TaiwanLottery {
	private String downloadPath = "http://210.71.254.160/result_all.htm";
	/**
	 * 
	 */
	public TaiwanLottery() {
		// TODO Auto-generated constructor stub
	}
	
	public void download() {
		try {
			StringBuilder content = new StringBuilder();
			URLConnection connection = new URL(downloadPath).openConnection();
			InputStream response = connection.getInputStream();
			InputStreamReader inputStream = new InputStreamReader(response);
			BufferedReader buffer = new BufferedReader(inputStream);
			String line;
			while ((line = buffer.readLine()) != null)
		      {
		        content.append(line + "\n");
		      }
			buffer.close();
			System.out.println(content.toString());
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	/**
	 * @param args
	 * http://210.71.254.160/result_all.htm
	 * M:\lotteyNumberData\everyday_result
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TaiwanLottery lottery = new TaiwanLottery();
		lottery.download();
	}

}
