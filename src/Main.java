import javax.swing.JFrame;

public class Main {
	

	public static void main(String[] args) throws InterruptedException {
		ImageToText ob = new ImageToText();

		DBSend db = new DBSend();
		EntryGate eg=new EntryGate();
		eg.setVisible(true);
		eg.setSize(800,500);
		eg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		for(int i=1; i<=4; i++) {
			String s = ob.getText("C:\\Users\\shime\\eclipse-workspace\\ParkingSpaceAnalyser\\sample images\\" + i + ".jpeg");
			if(s == null) {
				continue;
			}
			s = s.replaceAll("[^a-zA-Z0-9_-]", "");
			System.out.println(s);
			int status = db.entry(s);
			if(status == 1) {
				System.out.println("Inserted");
			}
			String rowData[][] = db.garage();
//			System.out.println(rowData.length);
			Thread.sleep(2000);
			eg.model.addRow(rowData[i-1]);
			eg.count++;
			eg.vacantSpace--;
			eg.countLb.setText("Count->" + Integer.toString( eg.count));
			eg.vacantLb.setText("Vacant->" + Integer.toString( eg.vacantSpace));
			
		}
	}
}
