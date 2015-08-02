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
public class LNPower38 extends LotteryNumber {

	public String strYear = "";
	public String strDate;
	public int lotteryIndex;
	public String Section1Num1;
	public String Section1Num2;
	public String Section1Num3;
	public String Section1Num4;
	public String Section1Num5;
	public String Section1Num6;
	public String Section2Num;
	public int lotteryIndexAll;
	/**
	 * 
	 */
	public LNPower38(Elements elements) {
		// TODO Auto-generated constructor stub
		int i = 0;
		for (Element td : elements) {
//			print(td.text());
			String str = td.text();
			switch (i) {
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
				this.Section1Num1 = str;
				break;
			case 4:
				this.Section1Num2 = str;
				break;
			case 5:
				this.Section1Num3 = str;
				break;
			case 6:
				this.Section1Num4 = str;
				break;
			case 7:
				this.Section1Num5 = str;
				break;
			case 8:
				this.Section1Num6 = str;
				break;
			case 9:
				this.Section2Num = str; // specific number
				break;
			case 10:
				this.lotteryIndexAll = Integer.parseInt(str);
				break;
			}
			i++;	
		}
	}
	
	public String CSVLine () {
		return this.strYear + "," + this.strDate + "," + this.lotteryIndex + "," + this.Section1Num1 + "," + this.Section1Num2 + "," + this.Section1Num3 + "," + this.Section1Num4
				+ "," + this.Section1Num5 + "," + this.Section1Num6 + "," + this.Section2Num + "," + this.lotteryIndexAll + "\n";
	}
	
	public String description() {
		return "期數 : " + lotteryIndex + " 總期數 : " + lotteryIndexAll + "號碼 : " + Section1Num1 + " " + Section1Num2 + " " + Section1Num3 + " " + Section1Num4 + " " + Section1Num5 + " " + Section1Num6 + " " + Section2Num + " " + "日期 : " + strYear + " " + strDate;
	}

}
