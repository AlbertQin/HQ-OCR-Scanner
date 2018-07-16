

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import org.jsoup.Jsoup;  
import org.jsoup.nodes.Document;  
import org.jsoup.nodes.Element;

import ch.qos.logback.core.net.SyslogOutputStream;

import java.lang.Object;


import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class TesseractTest {
	
	
	 static int count1 = 0;
     static int count2 = 0;
     static int count3 = 0;
    public static void main(String[] args) throws HeadlessException, AWTException, IOException, URISyntaxException {
    	String result = null;
    	BufferedImage image = new Robot().createScreenCapture(new Rectangle(1200, 200, 360, 150));
    	ImageIO.write(image, "png", new File("C:\\Users\\alber\\Pictures\\HQ\\screenshot.png"));
        File imageFile = new File("C:\\Users\\alber\\Pictures\\HQ\\screenshot.png");
        ITesseract instance = new Tesseract();  // JNA Interface Mapping
        // ITesseract instance = new Tesseract1(); // JNA Direct Mapping

        try {
            result = instance.doOCR(imageFile);
            System.out.println(result);
        } catch (TesseractException e) {
            System.err.println(e.getMessage());
        }
        
        //ans1
        String choice1 = null;
    	BufferedImage image1 = new Robot().createScreenCapture(new Rectangle(1200, 350, 330, 35));
    	ImageIO.write(image1, "png", new File("C:\\Users\\alber\\Pictures\\HQ\\screenshot1.png"));
        File imageFile1 = new File("C:\\Users\\alber\\Pictures\\HQ\\screenshot1.png");
        ITesseract instance1 = new Tesseract();  // JNA Interface Mapping
        // ITesseract instance = new Tesseract1(); // JNA Direct Mapping

        try {
        	choice1 = instance1.doOCR(imageFile1);
           // System.out.println(choice1);
        } catch (TesseractException e) {
            System.err.println(e.getMessage());
        }
        
        //ans2
        String choice2 = null;
    	BufferedImage image2 = new Robot().createScreenCapture(new Rectangle(1215, 400, 330, 35));
    	ImageIO.write(image2, "png", new File("C:\\Users\\alber\\Pictures\\HQ\\screenshot2.png"));
        File imageFile2 = new File("C:\\Users\\alber\\Pictures\\HQ\\screenshot2.png");
        ITesseract instance2 = new Tesseract();  // JNA Interface Mapping
        // ITesseract instance = new Tesseract1(); // JNA Direct Mapping
        
        try {
        	choice2 = instance2.doOCR(imageFile2);
           // System.out.println(choice2);
        } catch (TesseractException e) {
            System.err.println(e.getMessage());
        }
        
        //ans3
        String choice3 = null;
    	BufferedImage image3 = new Robot().createScreenCapture(new Rectangle(1215, 475, 330, 35));
    	ImageIO.write(image3, "png", new File("C:\\Users\\alber\\Pictures\\HQ\\screenshot3.png"));
        File imageFile3 = new File("C:\\Users\\alber\\Pictures\\HQ\\screenshot3.png");
        ITesseract instance3 = new Tesseract();  // JNA Interface Mapping
        // ITesseract instance = new Tesseract1(); // JNA Direct Mapping

        try {
        	choice3 = instance3.doOCR(imageFile3);
            //System.out.println(choice3);
        } catch (TesseractException e) {
            System.err.println(e.getMessage());
        }
        
        
        result = result.replace("\n", " ");
        result = result.replace(" ", "+");
        
        
        choice1 = choice1.replace("\n", " ");
        choice2 = choice2.replace("\n", " ");
        choice3 = choice3.replace("\n", " ");
        choice1 = choice1.toLowerCase();
        choice2 = choice2.toLowerCase();
        choice3 = choice3.toLowerCase();
        choice1 = choice1.trim();
        choice2 = choice2.trim();
        choice3 = choice3.trim();
        
      //We need a real browser user agent or Google will block our request with a 403 - Forbidden
       String USER_AGENT = "Mozilla/4.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.101 Safari/537.36";

            //Fetch the page
            final Document doc = Jsoup.connect("https://google.com/search?q="+result+"&num=30").userAgent(USER_AGENT).get();

            //Traverse the results
            for (Element ans : doc.select("span")){

                String title = ans.text().toLowerCase();

                //Now do something with the results (maybe something more useful than just printing to console)

                int idx = 0;
                while ((idx = title.indexOf(choice1, idx)) != -1)
                {
                   idx++;
                   count1++;
                }
                
                idx = 0;
                while ((idx = title.indexOf(choice2, idx)) != -1)
                {
                   idx++;
                   count2++;
                }
                
               idx = 0;
                while ((idx = title.indexOf(choice3, idx)) != -1)
                {
                   idx++;
                   count3++;
                }
            }
            System.out.println(choice1 +": " + count1);
            System.out.println(choice2 +": " + count2);
            System.out.println(choice3 +": " + count3);
    }
}