
public class TryMan {

	public static void main(String[] args) throws InterruptedException {
		//code
		int mins = 1;
		while(true) {
			Thread.sleep(60*1000);
			System.out.println(mins++ + " minutes have passed");
			
		}
	}
}
