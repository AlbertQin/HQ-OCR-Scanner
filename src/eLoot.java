
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
import java.util.Random;
import java.util.Scanner;
import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
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

public class eLoot {

	public static void main(String[] args)
			throws HeadlessException, AWTException, IOException, URISyntaxException, InterruptedException {
		while (true) {
			Random rand = new Random();
			int  n = rand.nextInt(50000) + 1;
			Thread.sleep(2700000+n);
			String result = null;
			BufferedImage image = new Robot().createScreenCapture(new Rectangle(500, 300, 600, 300));
			ImageIO.write(image, "png", new File("C:\\Users\\alber\\Pictures\\eLoot\\screenshot.png"));
			File imageFile = new File("C:\\Users\\alber\\Pictures\\eLoot\\screenshot.png");
			ITesseract instance = new Tesseract(); // JNA Interface Mapping
			// ITesseract instance = new Tesseract1(); // JNA Direct Mapping

			try {
				result = instance.doOCR(imageFile);
				System.out.println(result);
			} catch (TesseractException e) {
				System.err.println(e.getMessage());
			}

			if (result.contains("Continue") || result.contains("Watching")) {
				click(800, 440);
			}
		}

	}

	public static void click(int x, int y) throws AWTException {
		Robot bot = new Robot();
		bot.mouseMove(x, y);
		bot.mousePress(InputEvent.BUTTON1_MASK);
		bot.mouseRelease(InputEvent.BUTTON1_MASK);
	}
}