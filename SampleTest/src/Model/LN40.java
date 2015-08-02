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
public class LN40 extends LotteryNumber {

	public String strYear;
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
	public LN40() {
		// TODO Auto-generated constructor stub
	}
	
	public LN40(Elements elements) {
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
				try {
					this.lotteryIndex = Integer.parseInt(str);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
				
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
				this.Num7 = str;
				break;
			case 10:
				try {
					this.lotteryIndexAll = Integer.parseInt(str);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
				break;
			}
			i++;
			
		}
	}
	
	public String CSVLine () {
		return this.strYear + "," + this.strDate + "," + this.lotteryIndex + "," + this.Num1 + "," + this.Num2 + "," + this.Num3 + "," + this.Num4
				+ "," + this.Num5 + "," + this.Num6 + "," + this.Num7 + "," + this.lotteryIndexAll + "\n";
	}
	
	public String description() {
		return "期數 : " + lotteryIndex + " 總期數 : " + lotteryIndexAll + "號碼 : " + Num1 + " " + Num2 + " " + Num3 + " " + Num4 + " " + Num5 + " " + " " + Num6 +  " " + Num7 + "日期 : " + strYear + " " + strDate;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
