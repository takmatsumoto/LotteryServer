/**
 * 
 */
package db;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import HTMLPathCollector.*;

/**
 * @author takmatsumoto
 *
 * data example :
 * 		http://www.nfd.com.tw/lottery/49-year/49-2015.htm
 * 		http://www.nfd.com.tw/lottery/power-38/2015.htm
 * 		http://www.nfd.com.tw/lottery/4-star/2009.htm
 * 		http://www.nfd.com.tw/lottery/39-year/39-2015.htm
 * 		http://www.nfd.com.tw/lottery/40-year/40-2015.htm 2015
 */
public class LotteryDataDownloadPathCollector {
	private LotteryDataDownloadPathCollector539 pathCollector539 = new LotteryDataDownloadPathCollector539();
	private LotteryDataDownloadPathCollector40 pathCollector40 = new LotteryDataDownloadPathCollector40();
	private LotteryDataDownloadPathCollectorBigLottery pathCollectorBigLottery = new LotteryDataDownloadPathCollectorBigLottery();
	private LotteryDataDownloadPathCollectorPower38 pathCollectorPower38 = new LotteryDataDownloadPathCollectorPower38();
	
	LotteryDataDownloadPathCollector () {
		/*
		Map<Integer, String> htmlDownloadPaths = new HashMap<Integer, String>();
		htmlDownloadPaths.put(Integer(AbstractLotteryDataDownloadPathCollector.LotteryType.LotteryType_539), pathCollector539);
		htmlDownloadPaths.put(AbstractLotteryDataDownloadPathCollector.LotteryType.LotteryType_BigLottery, pathCollectorBigLottery);
		htmlDownloadPaths.put(AbstractLotteryDataDownloadPathCollector.LotteryType.LotteryType_Power38, pathCollectorPower38);
		htmlDownloadPaths.put(AbstractLotteryDataDownloadPathCollector.LotteryType.LotteryType_40, pathCollector40);
		*/
			
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	public String currentYearDownloadPath(AbstractLotteryDataDownloadPathCollector.LotteryType type) {
		switch(type) {
		case LotteryType_539 :
			return pathCollector539.currentYearDownloadPath();
		case LotteryType_BigLottery:
			return pathCollectorBigLottery.currentYearDownloadPath();
		case LotteryType_Power38:
			return pathCollectorPower38.currentYearDownloadPath();
		case LotteryType_40:
			return pathCollector40.currentYearDownloadPath();
		default:
			return "";
		}
	}
	
	public String getLastComponentOfDownloadPath(AbstractLotteryDataDownloadPathCollector.LotteryType type, int year) {
		String downloadPath = getDownloadPathWithTypeAndYear(type, year);
		String[] components = downloadPath.split("/");
		String lastComponent = components[components.length-1];
		String[] componentsOfLastComponent = lastComponent.split("\\.");
		return componentsOfLastComponent[0];
	}
	
	public String getDownloadPathWithTypeAndYear(AbstractLotteryDataDownloadPathCollector.LotteryType type, int year) {
		String downloadPath = "";
		switch (type) {
			default:
			case LotteryType_539: {
				downloadPath = pathCollector539.getDownloadPath(year);
			}
			break;
			case LotteryType_BigLottery: {
				downloadPath = pathCollectorBigLottery.getDownloadPath(year);
			}
			break;
			case LotteryType_Power38: {
				downloadPath = pathCollectorPower38.getDownloadPath(year);
			}
			break;
			case LotteryType_40: {
				downloadPath = pathCollector40.getDownloadPath(year);
			}
			break;
		}
		return downloadPath;
	}
	
	public int baseYearWithType(AbstractLotteryDataDownloadPathCollector.LotteryType type){
		switch (type) {
			default:
			case LotteryType_539: {
				return pathCollector539.baseYear;
			}
			case LotteryType_BigLottery: {
				return pathCollectorBigLottery.baseYear;
			}
			case LotteryType_Power38: {
				return pathCollectorPower38.baseYear;
			}
			case LotteryType_40: {
				return pathCollector40.baseYear;
			}
		}
	}
	
	public int currentYear(AbstractLotteryDataDownloadPathCollector.LotteryType type) {
		switch (type) {
		default:
		case LotteryType_539: {
			return pathCollector539.numberOfCurrentYear();
		}
		case LotteryType_BigLottery: {
			return pathCollectorBigLottery.numberOfCurrentYear();
		}
		case LotteryType_Power38: {
			return pathCollectorPower38.numberOfCurrentYear();
		}
		case LotteryType_40: {
			return pathCollector40.numberOfCurrentYear();
		}
	}
	}
	
	private void arrayTest () {
		for (String string : pathCollector539.htmlDownloadPaths) {
			System.out.println(string);
		}
		
		for (String string : pathCollectorBigLottery.htmlDownloadPaths) {
			System.out.println(string);
		}
		
		for (String string : pathCollectorPower38.htmlDownloadPaths) {
			System.out.println(string);
		}
		
		for (String string : pathCollector40.htmlDownloadPaths) {
			System.out.println(string);
		}
	}

}
