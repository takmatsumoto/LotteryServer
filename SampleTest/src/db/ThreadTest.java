package db;

public class ThreadTest extends java.lang.Thread {

	public long waittime;
	public String data;
	public ThreadTest(long time, String value) {
		// TODO Auto-generated constructor stub
		this.waittime = time;
		this.data = value;
	}
	
	public void run() {
		try {
			while(true) {
				Thread.sleep(waittime);
				System.out.println(this.data);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static void main(String args[]) { 
		 (new ThreadTest(3 * 1000, "Thread-1")).start();
		 (new ThreadTest(1 * 1000, "Thread-2")).start();
	}

}
