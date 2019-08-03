
public class Main {
	public static void main(String[] args) {
		ImageToText ob = new ImageToText();
		String s = ob.getText("C:\\Users\\shime\\eclipse-workspace\\ParkingSpaceAnalyser\\sample images\\" + "4.jpeg");
		s = s.replaceAll("[^a-zA-Z0-9_-]", "");
		System.out.println(s);
	}
}
