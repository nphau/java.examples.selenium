/**
 * Created by nphau on 04/05/2022, 10:30
 * Copyright (c) 2021 nphau. All rights reserved.
 * Last modified 04/05/2022, 15:54
 */

package sg.nphau.java.selenium.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

    public static String getDirPath() {
        File currentDirectory = new File(new File(".").getAbsolutePath());
        String absolutePath = currentDirectory.getAbsolutePath();
        return absolutePath.substring(0, absolutePath.length() - 2);
    }

    public static String getUniqueIdentifier() {
        DateFormat dateFormat = new SimpleDateFormat("MMddyyyyHHmmss");
        Date date = new Date();
        return (dateFormat.format(date));
    }

    public static void screenshot(WebDriver driver) {

        File screenshot;
        String testName = getUniqueIdentifier() + ".png";

        try {
            System.out.println("Attempting Selenium Screenshot  ...");
            Thread.sleep(1000);
            screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String screenshotDir = getDirPath() + "/target/outputs/screenshots/";
            File dir = new File(screenshotDir);

            if (!dir.exists()) {
                dir.mkdirs();
                System.out.printf("Folder created : [%1s]%n", screenshotDir);
            }

            String textToWrite = driver.getCurrentUrl();
            Font myFont = new Font("Times", Font.PLAIN, 20);
            BufferedImage im = ImageIO.read(screenshot);
            Graphics2D g2 = im.createGraphics();

            // get text length
            AffineTransform affinetransform = new AffineTransform();
            FontRenderContext frc = new FontRenderContext(affinetransform, true, true);
            int textWidth = (int) (myFont.getStringBounds(textToWrite, frc).getWidth());
            int textHeight = (int) (myFont.getStringBounds(textToWrite, frc).getHeight());
            // set color and size of text box behind text.
            g2.setColor(Color.white);
            g2.fillRect(0, 0, textWidth, textHeight);
            // set text attributes.
            g2.setFont(myFont);
            g2.setColor(Color.black);
            g2.drawString(textToWrite, 0, 20);
            // write image file to save location
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(im, "png", baos);
            FileOutputStream fos = null;
            fos = new FileOutputStream(screenshotDir + testName);
            System.out.printf("Browser Screenshot Save Location: %1s%n", screenshotDir + testName);
            fos.write(baos.toByteArray());
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
