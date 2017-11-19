/**
 * 
 */
package Model;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * @author takmatsumoto
 *
 */
public class LNBigLottery extends LotteryNumber {

	public String strYear = "";
	public String strDate;
	public int lotteryIndex;
	public String Num1;
	public String Num2;
	public String Num3;
	public String Num4;
	public String Num5;
	public String Num6;
	public String Num7;
	public int lotteryIndexAll;
	/**
	 * 
	 */
	public LNBigLottery(Elements elements) {
		// TODO Auto-generated constructor stub
		int i = 0;
		for (Element td : elements) {
//			print(td.text());
			String str = td.text();
			AssignElementToVar(str, i);
			i++;
			
		}
	}
	
	public LNBigLottery(String[] elements) {
		// TODO Auto-generated constructor stub
		int i = 0;
		for (String element : elements) {
//			print(td.text());
			String str = element;
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
			this.lotteryIndex = Integer.parseInt(str);
			break;
		case 3:
			this.Num1 = str;
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
			this.Num6 = str;
			break;
		case 9:
			this.Num7 = str; // specific number
			break;
		case 10:
			this.lotteryIndexAll = Integer.parseInt(str);
			break;
		}
	}
	
	public String CSVLine () {
		return this.strYear + "," + this.strDate + "," + this.lotteryIndex + "," + this.Num1 + "," + this.Num2 + "," + this.Num3 + "," + this.Num4
				+ "," + this.Num5 + "," + this.Num6 + "," + this.Num7 + "," + this.lotteryIndexAll + "\n";
	}
	
	public String description() {
		return "���� : " + lotteryIndex + " �`���� : " + lotteryIndexAll + "���X : " + Num1 + " " + Num2 + " " + Num3 + " " + Num4 + " " + Num5 + " " + Num6 + " " + Num7 + " " + "��� : " + strYear + " " + strDate;
	}

}
