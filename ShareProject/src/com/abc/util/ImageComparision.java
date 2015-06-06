package com.abc.util;

import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;

import javax.imageio.ImageIO;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class ImageComparision {
	
	/**
	 * @author somasish
	 * @param ImageURL1 - URL of the image from the Application
	 * @param ImageURL2 - Image url to be compared
	 * @return Percentage difference of two image
	 */
	private static double ImageCompareByRGB(String ImageURL1, String ImageURL2)
	  {
	    BufferedImage img1 = null;
	    BufferedImage img2 = null;
	    try {
	      URL url1 = new URL(ImageURL1);
	      URL url2 = new URL(ImageURL2);
	      img1 = ImageIO.read(url1);
	      img2 = ImageIO.read(url2);
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	    int width1 = img1.getWidth(null);
	    int width2 = img2.getWidth(null);
	    int height1 = img1.getHeight(null);
	    int height2 = img2.getHeight(null);
	    if ((width1 != width2) || (height1 != height2)) {
	      System.err.println("Images dimensions mismatch");
	    	      return 0;
	    }
	    long diff = 0;
	    for (int y = 0; y < height1; y++) {
	      for (int x = 0; x < width1; x++) {
	        int rgb1 = img1.getRGB(x, y);
	        int rgb2 = img2.getRGB(x, y);
	        int r1 = (rgb1 >> 16) & 0xff;
	        int g1 = (rgb1 >>  8) & 0xff;
	        int b1 = (rgb1      ) & 0xff;
	        int r2 = (rgb2 >> 16) & 0xff;
	        int g2 = (rgb2 >>  8) & 0xff;
	        int b2 = (rgb2      ) & 0xff;
	        diff += Math.abs(r1 - r2);
	        diff += Math.abs(g1 - g2);
	        diff += Math.abs(b1 - b2);
	      }
	    }
	    double n = width1 * height1 * 3;
	    double perctantage = diff / n / 255.0;
	    System.out.println("diff percent: " + (perctantage * 100.0));
	    return perctantage;
	  }
	
	/**
	 * @author somasish
	 * @param fileA - 1st Image file
	 * @param fileB	- 2nd Image file
	 * @return True/False - If Images are Equal/UnEqual
	 */
	public static boolean compareImageByBufferData(File fileA, File fileB) {        
	    try {
	        // take buffer data from botm image files //
	        BufferedImage biA = ImageIO.read(fileA);
	        DataBuffer dbA = biA.getData().getDataBuffer();
	        int sizeA = dbA.getSize();                      
	        BufferedImage biB = ImageIO.read(fileB);
	        DataBuffer dbB = biB.getData().getDataBuffer();
	        int sizeB = dbB.getSize();
	        // compare data-buffer objects //
	        if(sizeA == sizeB) {
	            for(int i=0; i<sizeA; i++) { 
	                if(dbA.getElem(i) != dbB.getElem(i)) {
	                    return false;
	                }
	            }
	            return true;
	        }
	        else {
	            return false;
	        }
	    } 
	    catch (Exception e) { 
	        System.out.println("Failed to compare image files ...");
	        return  false;
	    }
	}
}
