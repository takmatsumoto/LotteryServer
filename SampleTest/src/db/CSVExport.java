package db;

import java.util.ArrayList;

import Model.LotteryNumber;

public class CSVExport {
	protected String prifexHeader = "";
	private String basePath = "C:/Users/takmatsumoto/Dropbox/";
	
	public static void main(String[] args) { 
		
	}
	
	public CSVExport(ArrayList<LotteryNumber> numberlist, String path) {
		if (path!=null) {
			this.basePath = path;
		}
	}
}
