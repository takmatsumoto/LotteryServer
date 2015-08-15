/**
 * 
 */
package db;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.jsoup.*;
import org.jsoup.nodes.Document;
/**
 * @author takmatsumoto
 *
 */
public class LotteryResultParser {

	/**
	 * 
	 */
	public LotteryResultParser() {
		// TODO Auto-generated constructor stub
	}
	
	private void LoadLotteryResultPage() {
		try {
			// http://www.taiwanlottery.com.tw/Result_all.aspx 台彩樂頭開獎結果網址
			Document doc = Jsoup.connect("http://www.taiwanlottery.com.tw/Result_all.aspx").maxBodySize(20000000).get();
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String dateString = sdf.format(date);
			
			String fullPath = System.getenv("LOTTERY_RESULTFILE_ROOT_PATH") + dateString +"_lotteryresult.txt";
			FileSaveEncodeWithUTF8(fullPath, doc.html());
			System.out.println("done");
		} catch (Exception e) {
			// TODO: handle exception
		} 
	}
	
	private void FileSaveEncodeWithUTF8(String fullPath, String content) {
		try {
			File file = new File(fullPath);
			if (!file.exists()) {
				FileOutputStream outputstream = new FileOutputStream(file); 
				OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputstream,"UTF-8");
				outputStreamWriter.write(content);
				outputStreamWriter.flush();
				outputStreamWriter.close();
			}
		}
		catch (Exception e) {
			
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LotteryResultParser parser = new LotteryResultParser();
		// TODO Auto-generated method stub
		parser.LoadLotteryResultPage();
	}

}
