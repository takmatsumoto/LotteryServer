/**
 * 
 */
package HTMLPathCollector;

/**
 * @author takmatsumoto
 *
 */
public class LotteryDataDownloadPathCollectorBigLottery extends
		AbstractLotteryDataDownloadPathCollector {

	/**
	 * 
	 */
	public LotteryDataDownloadPathCollectorBigLottery() {
		// TODO Auto-generated constructor stub
		super("49-year/49-%04d.htm",2004);
		createDownloadPathList();
		dataPrint();
	}

	/* (non-Javadoc)
	 * @see Model.AbstractLotteryDataDownloadPathColooector#type()
	 */
	@Override
	LotteryType type() {	
		// TODO Auto-generated method stub
		return AbstractLotteryDataDownloadPathCollector.LotteryType.LotteryType_BigLottery;
	}
	
	public static void main(String[] args) {
		LotteryDataDownloadPathCollectorBigLottery downloadList = new LotteryDataDownloadPathCollectorBigLottery();
		//downloadList.createDownloadPathList();
		//downloadList.dataPrint();
	}

}
