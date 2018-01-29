package imageTesting;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Final {

	public static void main(String[] args) {
		int imageFileNumber = 1;
		int [][][]skin = new int [256][256][256];
		int [][][]nonSkin = new int [256][256][256];
		

		while (true) {

			File image = new File("data/image/image ("+imageFileNumber+").jpg");
			File mask = new File("data/mask/mask ("+imageFileNumber+").png");
	        BufferedImage img = null;
	        BufferedImage msk = null;
	        
	        
	        
			try {
				img = ImageIO.read(image);
				msk = ImageIO.read(mask);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				break;
			}
	        int width = img.getWidth();
	        int height = img.getHeight();
	        int[][] pixel = new int[width][height];
	        Raster raster = img.getData();
	        for (int i = 0; i < width; i++) {
	            for (int j = 0; j < height; j++) {
	                pixel[i][j] = raster.getSample(i, j, 0);
	                
	                Color c1 = new Color(img.getRGB(i, j));
	                Color c2 = new Color(msk.getRGB(i, j));
	                if(c2.getRed() == 0 && c2.getGreen() == 0 && c2.getBlue() == 0 )
	                	nonSkin[c1.getRed()][c1.getGreen()][c1.getBlue()]++;
	                else
	                	skin[c1.getRed()][c1.getGreen()][c1.getBlue()]++;
	                //System.out.println(c2.getRed()+" "+c2.getGreen()+" "+c2.getBlue());
	            }
	        }
	        
	        
	        imageFileNumber++;

		}
		
		System.out.println(imageFileNumber);
		
		
		File testImage = new File("input/test.jpg");
		BufferedImage testImg = null;
        
        
        
        
		try {
			testImg = ImageIO.read(testImage);
			//msk = ImageIO.read(mask);
		} catch (IOException e) {
			System.out.println("no input file");
			//break;
		}
		
		
		
		

	}

}
