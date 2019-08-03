import java.io.File;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class ImageToText {
	
	String getText(String location) {
System.setProperty("jna.library.path", "<the directory of the folder without a trailing slash>");
    	
    	Tesseract tesseract = new Tesseract(); 
        try { 
  
            tesseract.setDatapath("C:\\Users\\shime\\eclipse-workspace\\ParkingSpaceAnalyser" + "\\tessdata"); 
  
            // the path of your tess data folder 
            // inside the extracted file 
            String text 
                = tesseract.doOCR(new File(location)); 
  
            // path of your image file 
            //System.out.print(text); 
            return text;
        } 
        catch (TesseractException e) { 
            e.printStackTrace(); 
        }
        	return null;
	}
	
	
	public static void main(String[] args) {
//		ImageToText ob = new ImageToText();
//		String location = "C:\\Users\\shime\\eclipse-workspace\\ParkingSpaceAnalyser\\sample images\\" + "1.jpeg";
//		System.out.println(ob.getText(location));
	}
}
