package org.ibcn.gso.labo3.util;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Utility class to make it easier to work with Pixel for the sake of this Lab session.
 *
 * @author tdupont
 */
public class Toolbox {

    private static final ColorModel COLOR_MODEL = ColorModel.getRGBdefault();

    /**
     * Creates an easy to use 2 dimensional Pixel array from an image.
     * @param path The path of the file
     * @return 
     * @throws java.io.IOException
     */
    public static Pixel[][] getPixelRaster(String path) throws IOException {
        BufferedImage image = ImageIO.read(new File(path));
        int width = image.getWidth();
        int height = image.getHeight();
        Pixel[][] pixels = new Pixel[height][width];
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                int argb = image.getRGB(col, row);
                pixels[row][col] = new Pixel(COLOR_MODEL.getRed(argb), COLOR_MODEL.getGreen(argb), COLOR_MODEL.getBlue(argb));
            }
        }
        return pixels;
    }

    /**
     * Writes an image to disk from a 2 dimensional Pixel array.
     * @param pixels The 2 dimensional Pixel array to convert
     * @param path The path to write the file to 
     * @throws java.io.IOException 
     */
    public static void writeToDisk(Pixel[][] pixels, String path) throws IOException {
        int height = pixels.length;
        int width = pixels[0].length;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
       for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                Pixel p = pixels[row][col];
                image.setRGB(col, row, new Color(p.r, p.g, p.b).getRGB());
            }
        }
        ImageIO.write(image, "bmp", new File(path));
    }
}
