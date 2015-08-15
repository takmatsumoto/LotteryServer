/**
 * 
 */
package db;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import 	org.jsoup.*;
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
			// http://www.taiwanlottery.com.tw/Result_all.aspx 開獎結果網址
			Document doc = Jsoup.connect("http://www.taiwanlottery.com.tw/Result_all.aspx").maxBodySize(20000000).get();
			System.out.println(doc.text());
			
			FileOutputStream outputstream = new FileOutputStream(new File("C:/Users/takmatsumoto/Downloads/lotteryresult.txt")); 
			OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputstream);
			outputStreamWriter.write(doc.text());
			outputStreamWriter.flush();
			outputStreamWriter.close();
			System.out.println("done");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
