package Model;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class LN539 extends LotteryNumber {
	public String strYear;
	public String strDate;
	public int lotteryIndex;
	public String Num1;
	public String Num2;
	public String Num3;
	public String Num4;
	public String Num5;
	public int lotteryIndexAll;
	
	public LN539(Elements elements) {
		int i = 0;
		for (Element td : elements) {
//			print(td.text());
			String str = td.text();			
			AssignElementToVar(str, i);
			i++;
			
		}
	}
	
	public LN539(String[] csvElements) {
		int i = 0;
		for (String csvElement : csvElements) {
			String str =csvElement;			
			AssignElementToVar(str, i);
			i++;
			
		}
	}
	
	private void AssignElementToVar(String str, int elementIndex) {
		switch (elementIndex) {
		case 0:
			this.strYear = str;
			break;
		case 1:
			this.strDate = str.replace(" ", "");
			break;
		case 2:
			try {
				this.lotteryIndex = Integer.parseInt(str);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
			
			break;
		case 3:
			this.Num1 = str.replace(" ", "").replaceAll("\\xA1@", "");
			break;
		case 4:
			this.Num2 = str;
			break;
		case 5:
			this.Num3 = str;
			break;
		case 6:
			this.Num4 = str;
			break;
		case 7:
			this.Num5 = str;
			break;
		case 8:
			try {
				this.lotteryIndexAll = Integer.parseInt(str);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
			break;
		}
	}
	
	public String CSVLine () {
		return this.strYear + "," + this.strDate + "," + this.lotteryIndex + "," + this.Num1 + "," + this.Num2 + "," + this.Num3 + "," + this.Num4
				+ "," + this.Num5 + "," + this.lotteryIndexAll + "\n";
	}
	
	public String description() {
		return "���� : " + lotteryIndex + " �`���� : " + lotteryIndexAll + "���X : " + Num1 + " " + Num2 + " " + Num3 + " " + Num4 + " " + Num5 + " " + "��� : " + strYear + " " + strDate;
	}
}
