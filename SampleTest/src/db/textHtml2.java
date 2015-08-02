package db;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.util.ArrayList;

public class textHtml2 {

	static ArrayList<DataObj> list = new ArrayList<DataObj>();

	public static void main(String[] arg) {
		String URL = "http://www.nfd.com.tw/lottery/39-year/39-2014.htm";
		try {
			Document doc = Jsoup.connect(URL).maxBodySize(20000000).get();
			// System.out.println(doc.toString());
			Elements elements = doc.select("table");
			// for (int i=0; i < elements.size(); i++) {
			// System.out.println(i+": "+elements.get(i).text());
			// }
			if (elements != null) {
				Elements els = elements.get(0).select("td");
				int tag = 9; // +9�O�]���n�h��Table��title���E�����
				for (int i = 0; i < els.size() - tag; i++) {
					// System.out.println(i+": "+els.get(i).text());
					DataObj Obj;
					if (i % tag == 0) {
						Obj = new DataObj();
					} else {
						Obj = list.get(i / tag);
					}
					String str = els.get(i + tag).text();
					switch (i % tag) {
					case 0:
						Obj.Year = str;
						list.add(Obj);
						break;
					case 1:
						Obj.Date = str.replace(" ", "");
						break;
					case 2:
						Obj.Count = Integer.parseInt(str);
						break;
					case 3:
						Obj.Num1 = Integer.parseInt(str);
						break;
					case 4:
						Obj.Num2 = Integer.parseInt(str);
						break;
					case 5:
						Obj.Num3 = Integer.parseInt(str);
						break;
					case 6:
						Obj.Num4 = Integer.parseInt(str);
						break;
					case 7:
						Obj.Num5 = Integer.parseInt(str);
						break;
					case 8:
						Obj.CountAll = Integer.parseInt(str);
						break;
					}
					if (i % tag == 8)
						ShowHash(Obj); // (��ܵ��G)����
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// print
	private static void ShowHash(DataObj obj) {
		System.out.println("�~��: " + obj.Year + ", ���: " + obj.Date + ", ����: "
				+ obj.Count + ", �y��1: " + obj.Num1 + ", �y��2: " + obj.Num2
				+ ", �y��3: " + obj.Num3 + ", �y��4: " + obj.Num4 + ", �y��5: "
				+ obj.Num5 + ", �`����: " + obj.CountAll);
	}

	// DataClass
	public static class DataObj {
		String Year;
		String Date;
		int Count;
		int Num1;
		int Num2;
		int Num3;
		int Num4;
		int Num5;
		int CountAll;
	}
}