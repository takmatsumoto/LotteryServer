package HTTPServer;
/*

Common Port Assignments and Corresponding RFC Numbers              

Port Common Name RFC#  Purpose
7     Echo        862   Echoes data back. Used mostly for testing.
9     Discard     863   Discards all data sent to it. Used mostly for testing.
13    Daytime     867   Gets the date and time.
17    Quotd       865   Gets the quote of the day.
19    Chargen     864   Generates characters. Used mostly for testing.
20    ftp-data    959   Transfers files. FTP stands for File Transfer Protocol.
21    ftp         959   Transfers files as well as commands.
23    telnet      854   Logs on to remote systems.
25    SMTP        821   Transfers Internet mail. Stands for Simple Mail Transfer Protocol.
37    Time        868   Determines the system time on computers.
43    whois       954   Determines a user's name on a remote system.
70    gopher     1436   Looks up documents, but has been mostly replaced by HTTP.
79    finger     1288   Determines information about users on other systems.
80    http       1945   Transfer documents. Forms the foundation of the Web.
110   pop3       1939   Accesses message stored on servers. Stands for Post Office Protocol, version 3.
443   https      n/a    Allows HTTP communications to be secure. Stands for Hypertext Transfer Protocol over Secure Sockets Layer (SSL).

*/

///A Simple Web Server (WebServer.java) 

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


/**
 * 
 * @author Liu Li Wei
 * @version 1.0
 * 
 * Lottery HTTP Server Function
 * 1.查詢樂透號碼
 * 		a.可查威力彩,大樂透,大福彩,539
 * 		b.提供查詢期數 預設是20期,可自訂
 * 
 */
/*
 * Examining the Mini Web Server
 * 
 * Server sockets use the ServerSocket object rather than the Socket object that
 * client sockets use. There are several constructors available with the
 * ServerSocket object. The simplest constructor accepts only the port number on
 * which the program should be listening. Listening refers to the mode that a
 * server is in while it waits for clients to connect. The following lines of
 * code are used in Listing 1.3 to create a new ServerSocket object and reserve
 * port 80 as the port number on which the web server should listen for
 * connections:
 * 
 * try { 
 * // create the main server 
 * socket s = new ServerSocket(80); 
 * }
 * catch(Exception e) { 
 * System.out.println("Error: " + e ); 
 * return; 
 * }
 * 
 * The try block is necessary because any number of errors could occur when the
 * program attempts to register port 80. The most common error that would result
 * is that there is already a server listening to port 80 on this machine.
 * Warning
 * 
 * This program will not work on a machine that already has a web server, or
 * some other program, listening on port 80.
 * 
 * Once the program has port 80 registered, it can begin listening for
 * connections. The following line of code is used to wait for a connection:
 * 
 * Socket remote = s.accept();
 * 
 * The Socket object that is returned by accept is exactly the same class that
 * is used for client sockets. Once the connection is established, the
 * difference between client and server sockets fade. The primary difference
 * between client and server sockets is the way in which they connect. A client
 * sever connects to something. A server socket waits for something to connect
 * to it.
 * 
 * The accept method is a blocking call, which means the current thread will
 * wait for a connection. This can present problems for your program if there
 * are other tasks it would like to accomplish while it is waiting for
 * connections. Because of this, it is very common to see the accept method call
 * placed in a worker thread. This allows the main thread to carry on other
 * tasks, while the worker thread waits for connections to arrive.
 * 
 * Once a connection is made, the accept method will return a socket object for
 * the new socket. After this point, reading and writing is the same between
 * client and server sockets. Many client server programs would create a new
 * thread to handle this new connection.
 * 
 * Now that a connection has been made, a new thread could be created to handle
 * it. This new worker thread would process all the requests from this client in
 * the background, which allows the ServerSocket object to wait for and service
 * more connections. However, the example program in Listing 1.3 does not
 * require such programming. As soon as the socket is accepted, input and output
 * objects are created; this same process was used with the SMTP client. The
 * following lines from Listing 1.3 show the process of preparing the newly
 * accepted socket for input and output:
 * 
 * //remote is now the connected socket 
 * System.out.println("Connection, sending data."); 
 * BufferedReader in 
 * = new BufferedReader( new InputStreamReader(remote.getInputStream()) ); 
 * PrintWriter out = new PrintWriter(remote.getOutputStream());
 * 
 * Now that the program has input and output objects, it can process the HTTP
 * request. It first reads the HTTP request lines. A full-featured server would
 * parse each line and determine the exact nature of this request, however, our
 * ultra-simple web server just reads in the request lines and ignores them, as
 * shown here:
 * 
 * //read the data sent. We basically ignore it, 
 * //stop reading once a blank line is hit. This 
 * //blank line signals the end of the 
 * //client HTTP headers.
 *  String str="."; 
 * while(!str.equals("")) 
 * str = in.readLine();
 * 
 * These lines cause the server to read in lines of text from the newly
 * connected socket. Once a blank line (which indicates the end of the HTTP
 * header) is reached, the loop stops, and the server stops reading. Now that
 * the HTTP header has been retrieved, the server sends an HTTP response. The
 * following lines of code accomplish this:
 * 
 * //Send the response 
 * //Send the headers out.println("HTTP/1.0 200 OK");
 * out.println("Content-Type: text/html"); 
 * out.println("Server: Bot"); 
 * //this blank line signals the end of the headers out.println("");
 * // Send the HTML page out.println( " <H1> Welcome to the Ultra Mini-WebServer </H2> ");
 * 
 * Status code 200, as shown on line 3 of the preceding code, is used to show
 * that the page was properly transferred, and that the required HTTP headers
 * were sent. (Refer to Chapter 2 for more information about HTTP headers.)
 * Following the HTTP headers, the actual HTML page is transferred. Once the
 * page is transferred, the following lines of code from Listing 1.3 are
 * executed to clean up:
 * 
 * out.flush(); remote.close();
 * 
 * The flush method is necessary to ensure that all data is transferred, and the
 * close method is necessary to close the socket. Although Java will discard the
 * Socket object, it will not generally close the socket on most platforms.
 * Because of this, you must close the socket or else you might eventually get
 * an error indicating that there are no more file handles. This becomes very
 * important for a program that opens up many connections, including one to a
 * spider.
 */

import java.util.ArrayList;
import java.io.FileReader;
//import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;

import HTMLPathCollector.AbstractLotteryDataDownloadPathCollector.LotteryType;
import Model.LotteryNumber;
import Model.LN40;
import Model.LN539;
import Model.LNBigLottery;
import Model.LNPower38;
import db.LotteryDataDownloadPathCollector;

import java.util.ArrayList;

import javax.json.Json;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;







/**
 * command model
 *
 */
import HTTPServer.RequestParameterParser;

/**
 * @author takmatsumoto
 *
 */
public class SimpleHttpServer {
	
	/**
	 * 
	 */
//	public SimpleHttpServer(int port, String context, HttpHandler handler) {
//		
//	}
	
	public ArrayList<LN539> listOf539 = new ArrayList<LN539>();
	public ArrayList<LNBigLottery> listOfBigLottery = new ArrayList<LNBigLottery>();
	public ArrayList<LNPower38> listOfPower38 = new ArrayList<LNPower38>();
	public ArrayList<LN40> listOfBigFu40 = new ArrayList<LN40>();
	private static LotteryDataDownloadPathCollector urlPaths = null;
	
	// commands
	private final String Lottery = "type";
	private final String LotteryDateRange = "date_range";
	private final String LotteryLength = "total_length";
	
	
	public SimpleHttpServer () {
		
	}
	
	protected void start() {
		initConfigtion();
		
		ServerSocket s;
	    System.out.println("Webserver starting up on port 3456");
	    System.out.println("(press ctrl-c to exit)");
	    try {
	      // create the main server socket\	\
	      s = new ServerSocket(3456);
	    } catch (Exception e) {
	      System.out.println("Error: " + e);
	      return;
	    }

	    System.out.println("Waiting for connection");
	    for (;;) {
	    	try {
	    		// wait for a connection
		        Socket remote = s.accept();
		        // remote is now the connected socket
		        System.out.println("Connection, sending data.");
		        BufferedReader in = new BufferedReader(new InputStreamReader(
		            remote.getInputStream()));
		        
		        
		        PrintWriter out = new PrintWriter(remote.getOutputStream());

		        // read the data sent. We basically ignore it,
		        // stop reading once a blank line is hit. This
		        // blank line signals the end of the client HTTP
		        // headers.	
		        String line = ".";
		        String contentString = "";
		        while ((line = in.readLine()) != null) {
		    		//System.out.println(line);
		    		String lineElements[] = line.split(" ");
		    		if (lineElements.length>2) {
		    			if (lineElements[0].compareTo("GET")==0)  {
		    				if (lineElements[1].contains("command:")) {
		    					String[] roots = lineElements[1].substring(1).split(":");
		    					if (roots.length == 2) {
		    						String commandParam = roots[1];
		    						if (commandParam.length() > 0) {
		    			    			RequestParameterParser parser = new RequestParameterParser(commandParam);
		    			    			//System.out.println("抓到的指令 : \n" + parser.Description());
		    			    			String lotteryType = parser.commands.get(this.Lottery);
		    			    			String strLength = parser.commands.get(this.LotteryLength);
		    			    			String jsonString = requestResponseByJSON(lotteryType, Integer.parseInt(strLength));
		    			    			contentString += jsonString;	
		    			    			
		    			    		}	    				
		    					}
			    				
		    				}
		    			}
		    		}
		    		
		    		if (line.isEmpty()) {
		    			break;
		    		}
		       
		        }
		        // Send the response
		        // Send the headers
		        out.println("HTTP/1.0 200 OK");
		        out.println("Content-Type: text/html");
		        out.println("Server: Bot");
		        // this blank line signals the end of the headers
		        out.println("");
		        // Send the HTML page
		        out.println(contentString);
		        out.flush();
		        remote.close();
		      }
		      catch (Exception e) {
		        System.out.println("Error: " + e);	
		      }
	    }
	}
	
	void initConfigtion() {
		loadLotteryNumberData(LotteryType.LotteryType_539);
    	loadLotteryNumberData(LotteryType.LotteryType_BigLottery);
    	loadLotteryNumberData(LotteryType.LotteryType_Power38);
    	loadLotteryNumberData(LotteryType.LotteryType_40);		
	}
	
	void loadLotteryNumberData(LotteryType type) {
		BufferedReader br = null;
        String line = "";
        urlPaths = new LotteryDataDownloadPathCollector();
        try {
        	int nowYear = urlPaths.currentYear(type);
        	for (int year=urlPaths.baseYearWithType(type);year<=nowYear;year++) {
        		String relativePath = urlPaths.getLastComponentOfDownloadPath(type, year);
   			 	String csvSavePath = System.getenv("LOTTERY_PATH");
   			 	String fileName = relativePath+".csv";
   			 	String fullPath = csvSavePath + fileName;
   			 	br = new BufferedReader(new FileReader(fullPath));
   			 	while ((line = br.readLine()) != null) {
   			 		// use comma as separator
   			 		addLotteryData(line, type);
   			 	}
   			 	br.close();
        	}
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	void addLotteryData(String line, LotteryType type) {
		String cvsSplitBy = ",";
		String[] elements = line.split(cvsSplitBy);
		if (type == LotteryType.LotteryType_539) {
		 	LN539 lotteryNumber = new LN539(elements);
		 	listOf539.add(lotteryNumber);
		}
		else if (type == LotteryType.LotteryType_BigLottery) {
			LNBigLottery lotteryNumber = new LNBigLottery(elements);
		 	listOfBigLottery.add(lotteryNumber);
		}
		else if (type == LotteryType.LotteryType_Power38) {
			LNPower38 lotteryNumber = new LNPower38(elements);
		 	listOfPower38.add(lotteryNumber);
		}
		else if (type == LotteryType.LotteryType_40) {
			LN40 lotteryNumber = new LN40(elements);
		 	listOfBigFu40.add(lotteryNumber);
		}		
		else {
			
		}
	}
	
	String requestResponse(String type, int length) {
		String result = "";
		if (type.compareToIgnoreCase("539") == 0) {
			for (int i = listOf539.size()-1; i > listOf539.size() - length  ; i--) {
				LN539 lotteryNumber = listOf539.get(i);
				result += lotteryNumber.CSVLine();
			}
		}
		else if (type.compareToIgnoreCase("BigLottery") == 0) {
			for (int i = listOfBigLottery.size()-1; i > listOfBigLottery.size() - length  ; i--) {
				LNBigLottery lotteryNumber = listOfBigLottery.get(i);
				result += lotteryNumber.CSVLine();
			}
		}
		else if (type.compareToIgnoreCase("Power38") == 0) {
			for (int i = listOfPower38.size()-1; i > listOfPower38.size() - length  ; i--) {
				LNPower38 lotteryNumber = listOfPower38.get(i);
				result += lotteryNumber.CSVLine();
			}
		}
		else if (type.compareToIgnoreCase("BigFu") == 0) {
			for (int i = listOfBigFu40.size()-1; i > listOfBigFu40.size() - length  ; i--) {
				LN40 lotteryNumber = listOfBigFu40.get(i);
				result += lotteryNumber.CSVLine();
			}
		}
		
		return result;
	}
	
	String requestResponseByJSON(String type, int length) {
		JSONObject json = new JSONObject();
		JSONArray jArray = new JSONArray();
		try {
			if (type.compareToIgnoreCase("539") == 0) {
				
					for (int i = listOf539.size()-1; i > listOf539.size() - length  ; i--) {
						LN539 lotteryNumber = listOf539.get(i);
						JSONObject numberJson = new JSONObject();
						numberJson.put("year", lotteryNumber.strYear);
						numberJson.put("ball1", lotteryNumber.Num1);
						numberJson.put("ball2", lotteryNumber.Num2);
						numberJson.put("ball3", lotteryNumber.Num3);
						numberJson.put("ball4", lotteryNumber.Num4);
						numberJson.put("ball5", lotteryNumber.Num5);
						numberJson.put("date", lotteryNumber.strDate);
						numberJson.put("totalIndex", lotteryNumber.lotteryIndexAll);
						numberJson.put("currIndex", lotteryNumber.lotteryIndex);
						jArray.put(numberJson);
						//System.out.println(numberJson.toString());
					}
				
			}
			else if (type.compareToIgnoreCase("BigLottery") == 0) {
				for (int i = listOfBigLottery.size()-1; i > listOfBigLottery.size() - length  ; i--) {
					LNBigLottery lotteryNumber = listOfBigLottery.get(i);
//					result += lotteryNumber.CSVLine();
				}
			}
			else if (type.compareToIgnoreCase("Power38") == 0) {
				for (int i = listOfPower38.size()-1; i > listOfPower38.size() - length  ; i--) {
					LNPower38 lotteryNumber = listOfPower38.get(i);
//					result += lotteryNumber.CSVLine();
				}
			}
			else if (type.compareToIgnoreCase("BigFu") == 0) {
				for (int i = listOfBigFu40.size()-1; i > listOfBigFu40.size() - length  ; i--) {
					LN40 lotteryNumber = listOfBigFu40.get(i);
//					result += lotteryNumber.CSVLine();
				}
			}
			
			jArray.toString();
			json.put("form", jArray);
		}
		catch (JSONException ex) {
		    ex.printStackTrace();
		}
		finally {
			return json.toString();
		}
		
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleHttpServer ws = new SimpleHttpServer();
	    ws.start();
	}

}
