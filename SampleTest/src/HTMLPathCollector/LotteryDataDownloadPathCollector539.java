package HTMLPathCollector;


public class LotteryDataDownloadPathCollector539 extends AbstractLotteryDataDownloadPathCollector {

	public LotteryDataDownloadPathCollector539() {
		// TODO Auto-generated constructor stub
		super("39-year/39-%4d.htm",2007);
		createDownloadPathList();
		dataPrint();
	}

	@Override
	LotteryType type() {
		// TODO Auto-generated method stub
		return AbstractLotteryDataDownloadPathCollector.LotteryType.LotteryType_539;
	}
	
	public static void main(String[] args) {
		LotteryDataDownloadPathCollector539 downloadList = new LotteryDataDownloadPathCollector539();
		//downloadList.createDownloadPathList();
		//downloadList.dataPrint();
	}

}
