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

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			// http://www.taiwanlottery.com.tw/Result_all.aspx 台彩樂頭開獎結果網址
			Document doc = Jsoup.connect("http://www.taiwanlottery.com.tw/Result_all.aspx").maxBodySize(20000000).get();
			
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String dateString = sdf.format(date);
			
			System.out.println(System.getenv("LOTTERY_RESULTFILE_ROOT_PATH"));
			FileOutputStream outputstream = new FileOutputStream(new File(System.getenv("LOTTERY_RESULTFILE_ROOT_PATH") + dateString +"_lotteryresult.txt")); 
			OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputstream);
			outputStreamWriter.write(doc.html());
			outputStreamWriter.flush();
			outputStreamWriter.close();
			System.out.println("done");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
