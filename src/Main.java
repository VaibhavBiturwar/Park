import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		ImageToText ob = new ImageToText();
//		String s = ob.getText("C:\\Users\\shime\\eclipse-workspace\\ParkingSpaceAnalyser\\sample images\\" + "2.jpeg");
//		s = s.replaceAll("[^a-zA-Z0-9_-]", "");
//		System.out.println(s);
		DBSend db = new DBSend();
		EntryGate eg=new EntryGate();
		eg.setVisible(true);
		eg.setSize(800,500);
		eg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		for(int i=0; i<=4; i++) {
			String s = ob.getText("C:\\Users\\shime\\eclipse-workspace\\ParkingSpaceAnalyser\\sample images\\" + i + ".jpeg");
			if(s == null) {
				continue;
			}
			s = s.replaceAll("[^a-zA-Z0-9_-]", "");
			System.out.println(s);
//			int status = db.entry(s);
//			System.out.println(status);
			Thread.sleep(500);
			
		}
	}
}
