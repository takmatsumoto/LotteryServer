/**
 * 
 */
package HTMLPathCollector;

/**
 * @author takmatsumoto
 *
 */
public class LotteryDataDownloadPathCollectorPower38 extends
		AbstractLotteryDataDownloadPathCollector {

	/**
	 * @param relativePath
	 * @param baseYear
	 */
	public LotteryDataDownloadPathCollectorPower38() {
		super("power-38/%04d.htm", 2008);
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
		LotteryDataDownloadPathCollectorPower38 downloadList = new LotteryDataDownloadPathCollectorPower38();
		//downloadList.createDownloadPathList();
		//downloadList.dataPrint();
	}

}
