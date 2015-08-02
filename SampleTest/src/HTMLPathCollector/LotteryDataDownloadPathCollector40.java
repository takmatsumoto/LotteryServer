/**
 * 
 */
package HTMLPathCollector;

/**
 * @author takmatsumoto
 *
 */
public class LotteryDataDownloadPathCollector40 extends
		AbstractLotteryDataDownloadPathCollector {

	/**
	 * @param relativePath
	 * @param baseYear
	 */
	public LotteryDataDownloadPathCollector40() {
		super("40-year/40-%04d.htm",2015);
		// TODO Auto-generated constructor stub
		createDownloadPathList();
		dataPrint();
	}

	/* (non-Javadoc)
	 * @see Model.AbstractLotteryDataDownloadPathColector#type()
	 */
	@Override
	LotteryType type() {
		// TODO Auto-generated method stub
		return AbstractLotteryDataDownloadPathCollector.LotteryType.LotteryType_40;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LotteryDataDownloadPathCollector40 downloadList = new LotteryDataDownloadPathCollector40();
	}

}
