package db;

import org.jsoup.Jsoup;
//import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.mysql.jdbc.log.Slf4JLogger;

import HTMLPathCollector.*;
import HTMLPathCollector.AbstractLotteryDataDownloadPathCollector.LotteryType;
import db.textHtml2.DataObj;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;

//HTTP �U�����յ{����
import java.io.File;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Calendar;

import Model.LN40;
import Model.LN539;
import Model.LNBigLottery;
import Model.LNPower38;
import db.LotteryDataDownloadPathCollector;

public class HTMLTableParser implements Runnable {
	public ArrayList<LN539> listOf539 = new ArrayList<LN539>();
	public ArrayList<LNBigLottery> listOfBigLottery = new ArrayList<LNBigLottery>();
	public ArrayList<LNPower38> listOfPower38 = new ArrayList<LNPower38>();
	public ArrayList<LN40> listOfBigFu40 = new ArrayList<LN40>();
	/**
	 * path for window
	 */
//	public String csvSavePath = "C:/Users/takmatsumoto/Dropbox/";
	/**
	 * path for mac
	 */
	public String csvSavePath = "/Users/liuliwey/Documents/";
	private static LotteryDataDownloadPathCollector urlPaths = null;

	public static void main(String[] args) throws IOException {
		HTMLTableParser parser = new HTMLTableParser();
		parser.parse();
		parser.run();	
	}
	
		
	public void run() {
		
		for(;;) {
			try {
				Thread.sleep(1000*30);
				Calendar now = Calendar.getInstance();
				int hourOfNow = now.get(Calendar.HOUR_OF_DAY);
				int minuteOfNow = now.get(Calendar.MINUTE);
				System.out.println("Not yet    " + hourOfNow + ":" + minuteOfNow);
				if (hourOfNow==22 && minuteOfNow==10) {
					this.parse();
					System.out.println("downloaded!!!!");
				}
		
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
		}
	}
	
	public void parse() {	
		
		urlPaths = new LotteryDataDownloadPathCollector();
		int nowYearOf539 = urlPaths.currentYear(LotteryType.LotteryType_539);
		 for (int year=urlPaths.baseYearWithType(LotteryType.LotteryType_539);year<=nowYearOf539;year++) {
			 String relativePath = urlPaths.getLastComponentOfDownloadPath(LotteryType.LotteryType_539, year);
			 String fileName = relativePath+".csv";
			 String fullPath = csvSavePath + fileName;
			 String downloadPath = 	urlPaths.getDownloadPathWithTypeAndYear(LotteryType.LotteryType_539, year);

			 if (nowYearOf539==year) {
				 
				try {
					 jsoup539(downloadPath);
				} catch (Exception e) {
					// TODO: handle exception
				}
				 
				 csv539Export(listOf539, fullPath);
				 
			 }
			 else {
				 if (!isFileExist(fullPath)) {
					 try {
						 //System.out.println(fullPath);
						 jsoup539(downloadPath);
					} catch (Exception e) {
						// TODO: handle exception
					}
					 csv539Export(listOf539, fullPath);
				 }
			 }
			 
		 }
		 
		
		 int nowYearOfBigLottery = urlPaths.currentYear(LotteryType.LotteryType_BigLottery);
		 for (int year=urlPaths.baseYearWithType(LotteryType.LotteryType_BigLottery);year<=nowYearOfBigLottery;year++) {
			 String relativePath = urlPaths.getLastComponentOfDownloadPath(LotteryType.LotteryType_BigLottery, year);
			 String fileName = relativePath+".csv";
			 String fullPath = csvSavePath + fileName;
			 String downloadPath = 	urlPaths.getDownloadPathWithTypeAndYear(LotteryType.LotteryType_BigLottery, year);;
			 if (nowYearOfBigLottery==year) {
				 try {
					 jsoupBigLottery(downloadPath);
				 } catch (Exception e) {
					// TODO: handle exception
				 }
				 csvBigLotteryExport(listOfBigLottery, fullPath);
			 }
			 else {
				 if (!isFileExist(fullPath)) {
					 try {
						 jsoupBigLottery(downloadPath);
					 } catch (Exception e) {
						// TODO: handle exception
					 }
					 csvBigLotteryExport(listOfBigLottery, fullPath);
				 }
			 }
			 
		 }
		 
		 int nowYearOfPower38 = urlPaths.currentYear(LotteryType.LotteryType_Power38);
		 for (int year=urlPaths.baseYearWithType(LotteryType.LotteryType_Power38);year<=nowYearOfPower38;year++) {
			 String relativePath = urlPaths.getLastComponentOfDownloadPath(LotteryType.LotteryType_Power38, year);
			 String fileName = relativePath+".csv";
			 String fullPath = csvSavePath + fileName;
			 String downloadPath = 	urlPaths.getDownloadPathWithTypeAndYear(LotteryType.LotteryType_Power38, year);;
			 if (nowYearOfPower38==year) {
				 try {
					 jsoupPower38(downloadPath);
				 } catch (Exception e) {
					// TODO: handle exception
				 }
				 csvPower38Export(listOfPower38, fullPath);
			 }
			 else {	
				 if (!isFileExist(fullPath)) {
					 try {
						 jsoupPower38(downloadPath);
					 } catch (Exception e) {
						// TODO: handle exception
					 }
					 csvPower38Export(listOfPower38, fullPath);
				 }
			 }
			 
		 }
		 
		 int nowYearOfBigFu = urlPaths.currentYear(LotteryType.LotteryType_40);
		 for (int year=urlPaths.baseYearWithType(LotteryType.LotteryType_40);year<=nowYearOfBigFu;year++) {
			 String relativePath = urlPaths.getLastComponentOfDownloadPath(LotteryType.LotteryType_40, year);
			 String fileName = relativePath+".csv";
			 String fullPath = csvSavePath + fileName;
			 String downloadPath = 	urlPaths.getDownloadPathWithTypeAndYear(LotteryType.LotteryType_40, year);;
			 if (nowYearOfBigFu==year) {
				 try {
					 jsoupBigFu40(downloadPath);
				 } catch (Exception e) {
					// TODO: handle exception
				 }
				 csvBigFu40Export(listOfBigFu40, fullPath);
			 }
			 else {	
				 if (!isFileExist(fullPath)) {
					 try {
						 jsoupBigFu40(downloadPath);
					 } catch (Exception e) {
						// TODO: handle exception
					 }
					 csvBigFu40Export(listOfBigFu40, fullPath);
				 }
			 }
			 
		 }
	}

	private static void print(String msg, Object... args) {
		System.out.println(String.format(msg, args));
	}

//	public void jsoupHTML(String htmlStr) throws IOException {
//		Document doc = Jsoup.parse(htmlStr);
//		Elements tables = doc.select("table");
//
//		Elements trs = tables.get(0).select("tr");
//
//		print("\nTables Count :%d", tables.size());
//		int objCount = 0;
//		for (Element tr : trs) {
//			// print(tr.text());
//			if (objCount==0) {
//				objCount++;
//				continue; 
//			}
//			Elements tds = tr.select("td");
//			LN539 Obj = new LN539(tds);
//			listOf539.add(Obj);
//			
//		}
//		print("List Count : " + listOf539.size());
//		this.arrayDataCheck();
//	}

	public void jsoup539(String strURLPath) throws IOException {
		//listOf539.clear();
		Document doc = Jsoup.connect(strURLPath).maxBodySize(20000000).get();
		
		Elements trs = doc.select("table tbody tr");

		int objCount = 0;
		for (Element tr : trs) {
			// print(tr.text());
			if (objCount==0) {
				objCount++;
				continue; 
			}
			Elements tds = tr.select("td");
			LN539 Obj = new LN539(tds);
			listOf539.add(Obj);
		}
		System.out.println("jsoup done");
		
		arrayDataCheck();
	}
	
	public void jsoupBigLottery(String strURLPath) throws IOException {
		listOfBigLottery.clear();
		Document doc = Jsoup.connect(strURLPath).maxBodySize(20000000).get();
		
		Elements trs = doc.select("table tbody tr");

		int objCount = 0;
		for (Element tr : trs) {
			// print(tr.text());
			if (objCount==0) {
				objCount++;
				continue; 
			}
			Elements tds = tr.select("td");
			LNBigLottery Obj = new LNBigLottery(tds);
			listOfBigLottery.add(Obj);
		}
		System.out.println("jsoup done");
		
		arrayDataCheckBL();
	}
	
	public void jsoupPower38(String strURLPath) throws IOException {
		listOfPower38.clear();
		Document doc = Jsoup.connect(strURLPath).maxBodySize(20000000).get();
		
		Elements trs = doc.select("table tbody tr");

		int objCount = 0;
		for (Element tr : trs) {
			// print(tr.text());
			if (objCount==0) {
				objCount++;
				continue; 
			}
			Elements tds = tr.select("td");
			LNPower38 Obj = new LNPower38(tds);
			listOfPower38.add(Obj);
		}
		System.out.println("jsoup done");
		
		arrayDataCheckPower38();
	}
	
	public void jsoupBigFu40(String strURLPath) throws IOException {
		listOfBigFu40.clear();
		Document doc = Jsoup.connect(strURLPath).maxBodySize(20000000).get();
		
		Elements trs = doc.select("table tbody tr");

		int objCount = 0;
		for (Element tr : trs) {
			// print(tr.text());
			if (objCount==0) {
				objCount++;
				continue; 
			}
			Elements tds = tr.select("td");
			LN40 Obj = new LN40(tds);
			listOfBigFu40.add(Obj);
		}
		System.out.println("jsoup done");
		
		arrayDataCheckBF40();
	}
	
	private void arrayDataCheck () {
		for (LN539 dataObj : listOf539) {
			print(dataObj.description());
		}
	}
	
	private void arrayDataCheckBL () {
		for (LNBigLottery dataObj : listOfBigLottery) {
			print(dataObj.description());
		}
	}
	
	private void arrayDataCheckPower38 () {
		for (LNPower38 dataObj : listOfPower38) {
			print(dataObj.description());
		}
	}
	
	private void arrayDataCheckBF40 () {
		for (LN40 dataObj : listOfBigFu40) {
			print(dataObj.description());
		}
	}
	

	public String get(String strURLPath) throws IOException {
		URL url = new URL(strURLPath);
		URLConnection yc = url.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(
				yc.getInputStream()));
		String inputLine = null;
		StringBuilder body = new StringBuilder();
		while ((inputLine = in.readLine()) != null) {
			body.append(inputLine);
		}
		// body.toString();
		// System.out.println(body.toString());
		System.out.println("download completed");
		in.close();
		String htmlStr = body.toString();
		System.out.println("to string completed");
		return htmlStr;

	}
	
	public boolean csv539Export (ArrayList<LN539> listOf539, String exportFullPath) {
		try {
			System.out.println("csv539Export : " + exportFullPath);
			//FileWriter writer = new FileWriter(exportFullPath,true);
			FileOutputStream outputstream = new FileOutputStream(new File(exportFullPath)); 
			OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputstream,"UTF-8");
			String outputcontent = new String();
			
			for (LN539 lotteryNum : listOf539) {
				outputcontent += lotteryNum.CSVLine();
			}
			outputStreamWriter.write(outputcontent);
			outputStreamWriter.flush();
			outputStreamWriter.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("539CSV Export Error : " + e.getMessage());
			return false;
		}
	}
	
	public boolean csvBigLotteryExport (ArrayList<LNBigLottery> listOfBigLottery, String exportFullPath) {
		try {
			System.out.println("csvBigLotteryExport");
			FileWriter writer = new FileWriter(exportFullPath);
			for (LNBigLottery lotteryNum : listOfBigLottery) {
				writer.append(lotteryNum.CSVLine());
			}
			writer.flush();
		    writer.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean csvPower38Export (ArrayList<LNPower38> listOfPower38s, String exportFullPath) {
		try {
			System.out.println("csvPower38Export");
			FileWriter writer = new FileWriter(exportFullPath);
			for (LNPower38 lotteryNum : listOfPower38s) {
				writer.append(lotteryNum.CSVLine());
			}
			writer.flush();
		    writer.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean csvBigFu40Export (ArrayList<LN40> list, String exportFullPath) {
		try {
			System.out.println("csvBigFu40Export");
			FileWriter writer = new FileWriter(exportFullPath);
			for (LN40 lotteryNum : list) {
				writer.append(lotteryNum.CSVLine());
			}
			writer.flush();
		    writer.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean isFileExist(String fullPath) {
		File f = new File(fullPath);
		return f.exists();
	}
}
