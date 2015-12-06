package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import db.HTMLTableParser;

import java.io.IOException;

import Model.LN539;
import db.HTMLTableParser;

public class jdbcmysql {
	private Connection dbConnection = null;
	private Statement statement = null;
	private ResultSet resultSet = null;
	private PreparedStatement preparedStatement = null;
	
	private String dropDBSQL = null;
	
	 private String createdbSQL = "CREATE TABLE Lottery_539_5 (" +			 	
			 	"year VARCHAR(20) " +
			 	", date  VARCHAR(20) " +
			    ", yearIndex     INTEGER " +
			    ", number1   VARCHAR(20)" +
			    ", number2  VARCHAR(20)" +
			    ", number3  VARCHAR(20)" +
			    ", number4  VARCHAR(20)" +
			    ", number5  VARCHAR(20)" +
			    ", totalIndex     INTEGER" +
			    ", CONSTRAINT keyIndex PRIMARY KEY (year,yearIndex)" + 
			    ")";
	 
//	 private String insertdbSQL = "insert into Lottery_539_3(year,date,yearIndex,number1,number2,number3,number4,number5,totalIndex) " +
//		      "select ifNULL(max(id),0)?,?,?,?,?,?,?,? FROM Lottery_539_3";
	 private String insertdbSQL = "insert into Lottery_539_5(year,date,yearIndex,number1,number2,number3,number4,number5,totalIndex) " +
		      "values(?,?,?,?,?,?,?,?,?)";
	 private String selectSQL = "select * from Lottery_539_5";
		  
		  public jdbcmysql()
		  {
		    try {
		      Class.forName("com.mysql.jdbc.Driver");
		      //���Udriver
		      dbConnection = DriverManager.getConnection(
		      "jdbc:mysql://localhost/test?useUnicode=true&characterEncoding=Big5",
		      "root","pm1101tak1226");
		      //���oconnection
		 
		//jdbc:mysql://localhost/test?useUnicode=true&characterEncoding=Big5
		//localhost�O�D���W,test�Odatabase�W
		//useUnicode=true&characterEncoding=Big5�ϥΪ��s�X
		      
		    }
		    catch(ClassNotFoundException e)
		    {
		      System.out.println("DriverClassNotFound :"+e.toString());
		    }//���i��|����sqlexception
		    catch(SQLException x) {
		      System.out.println("Exception :"+x.toString());
		    }
		    
		  }
		  //�إ�table���覡
		  //�i�H�ݬ�Statement���ϥΤ覡
		  public void createTable()
		  {
		    try
		    {
		    	statement = dbConnection.createStatement();
		    	System.out.println(createdbSQL);
		    	statement.executeUpdate(createdbSQL);
		    }
		    catch(SQLException e)
		    {
		      System.out.println("CreateDB Exception :" + e.toString());
		    }
		    finally
		    {
		      Close();
		    }
		  }
		  //�s�W���
		  //�i�H�ݬ�PrepareStatement���ϥΤ覡
		  public void insertTable( String year,String date, int yearIndex, String number1,String number2, String number3, String number4, String number5, int totalIndex)
		  {
		    try
		    {
		    	preparedStatement = dbConnection.prepareStatement(insertdbSQL);
		      
		    	preparedStatement.setString(1, year);
		    	preparedStatement.setString(2, date);
		    	preparedStatement.setInt(3, yearIndex);
		    	preparedStatement.setString(4, number1);
		    	preparedStatement.setString(5, number2);
		    	preparedStatement.setString(6, number3);
		    	preparedStatement.setString(7, number4);
		    	preparedStatement.setString(8, number5);
		    	preparedStatement.setInt(9, totalIndex);
		    	preparedStatement.executeUpdate();
		    }
		    catch(SQLException e)
		    {
		      System.out.println("InsertDB Exception :" + e.toString());
		    }
		    finally
		    {
		      Close();
		    }
		  }
		  //�R��Table,
		  //��إ�table�ܹ�
		  public void dropTable()
		  {
		    try
		    {
		      statement = dbConnection.createStatement();
		      statement.executeUpdate(dropDBSQL);
		    }
		    catch(SQLException e)
		    {
		      System.out.println("DropDB Exception :" + e.toString());
		    }
		    finally
		    {
		      Close();
		    }
		  }
		  //�d�߸��
		  //�i�H�ݬݦ^�ǵ��G���Ψ��o��Ƥ覡
		  public void SelectTable()
		  {
		    try
		    {
		      statement = dbConnection.createStatement();
		      resultSet = statement.executeQuery(selectSQL);
		      System.out.println("ID\t\tName\t\tPASSWORD");
		      while(resultSet.next())
		      {		
		        System.out.println("�~�� : "+resultSet.getString("year")+"\t\t��� : "+
		        		resultSet.getString("date")+"\t\t��~���� : "+resultSet.getInt("yearIndex")+"\t\t���X : "+
		        		resultSet.getString("number1")+" "+
		        		resultSet.getString("number2")+" "+
		        		resultSet.getString("number3")+" "+
		        		resultSet.getString("number4")+" "+
		        		resultSet.getString("number5")+"\t\t �`���� :"+resultSet.getInt("totalIndex"));
		      }
		    }
		    catch(SQLException e)
		    {
		      System.out.println("DropDB Exception :" + e.toString());
		    }
		    finally
		    {
		      Close();
		    }
		  }
		  //����ϥΧ���Ʈw��,�O�o�n�����Ҧ�Object
		  //�_�h�b����Timeout��,�i��|��Connection poor�����p
		  private void Close()
		  {
		    try
		    {
		      if(resultSet!=null)
		      {
		    	  resultSet.close();
		    	  resultSet = null;
		      }
		      if(statement!=null)
		      {
		    	  statement.close();
		    	  statement = null;
		      }
		      if(preparedStatement!=null)
		      {
		    	  preparedStatement.close();
		    	  preparedStatement = null;
		      }
		    }
		    catch(SQLException e)
		    {
		      System.out.println("Close Exception :" + e.toString());
		    }
		  }
		  
		  
		 
		  public static void main(String[] args)
		  {
//			  try {
//				  HTMLTableParser parser = new HTMLTableParser();
//			  		parser.jsoupHTML(parser.get());
//			  }
//			  catch(IOException e)
//			  {
//			      System.out.println("Close Exception :" + e.toString());
//			  }
			  
//			  String[] downloadPaths = {"http://www.nfd.com.tw/lottery/39-year/39-2007.htm","http://www.nfd.com.tw/lottery/39-year/39-2008.htm",
//				  "http://www.nfd.com.tw/lottery/39-year/39-2009.htm",
//				  "http://www.nfd.com.tw/lottery/39-year/39-2010.htm",
//				  "http://www.nfd.com.tw/lottery/39-year/39-2011.htm",
//				  "http://www.nfd.com.tw/lottery/39-year/39-2012.htm",
//				  "http://www.nfd.com.tw/lottery/39-year/39-2013.htm",
//				  "http://www.nfd.com.tw/lottery/39-year/39-2014.htm",
//				  "http://www.nfd.com.tw/lottery/39-year/39-2015.htm"};
			  //���ݬݬO�_���`
			  jdbcmysql test = new jdbcmysql();
//			  test.dropTable();
//			  test.createTable();
			  test.SelectTable();
		    
//		    HTMLTableParser htmlParser = new HTMLTableParser();
//		    try {
//		    	for (int i=0;i<downloadPaths.length;i++) {
//		    		htmlParser.jsoup539(downloadPaths[i]);
//		    	}
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		    ArrayList<LN539> listOf539 = htmlParser.listOf539;
//		    System.out.println("539 Count : " + listOf539.size());
//		    for (LN539 ln539 : listOf539) {
//				test.insertTable(ln539.strYear, ln539.strDate, ln539.lotteryIndex, ln539.Num1, ln539.Num2, ln539.Num3, ln539.Num4, ln539.Num5, ln539.lotteryIndexAll);
//			}
//		    System.out.println("����");
		    
		  }
}
