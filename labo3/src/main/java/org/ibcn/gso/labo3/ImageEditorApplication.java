package org.ibcn.gso.labo3;

import java.util.Stack;
import org.ibcn.gso.labo3.commands.Command;
import org.ibcn.gso.labo3.commands.HMirrorCommand;
import org.ibcn.gso.labo3.commands.InvertCommand;
import org.ibcn.gso.labo3.commands.ShiftRgbCommand;
import org.ibcn.gso.labo3.commands.VMirrorCommand;
import org.ibcn.gso.labo3.util.Pixel;
import org.ibcn.gso.labo3.util.Region;
import org.ibcn.gso.labo3.util.Toolbox;

/**
 *
 * @author tdupont
 */
public class ImageEditorApplication {

    private static final ImageProcessor imageProcessor = new ImageProcessor();
    private static Pixel[][] pixels;

    /**
     * Undoes all the given commands, since the last undo.
     */
    private static void undoAllCommands() {
        // TODO: Complete this method
        // COMPLETED???
        while (!imageProcessor.getHistory().isEmpty()){
          imageProcessor.getHistory().pop().undo();
        }
    }

    /**
     * Execute this when the 10_puzzle.bmp image is loaded. It will decode the
     * image. Use this to test if your Filter implementations are working
     * correctly.
     */
    private static void decodeImage() {
        int width = 800;
        int height = 450;

        for (int i = 0; i < 34; i++) {
            imageProcessor.addCommand(new HMirrorCommand(pixels, new Region(i * 10, i * 20, 100, 100)));
            imageProcessor.addCommand(new VMirrorCommand(pixels, new Region((i + 1) * 10, (i + 1) * 20, 100, 100)));

            imageProcessor.addCommand(new HMirrorCommand(pixels, new Region(height - 100 - (i * 10), (i * 20), 100, 100)));
            imageProcessor.addCommand(new VMirrorCommand(pixels, new Region(height - 100 - ((i + 1) * 10), ((i + 1) * 20), 100, 100)));
        }

        imageProcessor.addCommand(new ShiftRgbCommand(pixels, new Region(0, 0, 100, height)));
        imageProcessor.addCommand(new ShiftRgbCommand(pixels, new Region(0, 0, 100, height)));
        imageProcessor.addCommand(new ShiftRgbCommand(pixels, new Region(0, width - 100, 100, height)));
        imageProcessor.addCommand(new ShiftRgbCommand(pixels, new Region(0, width - 100, 100, height)));
        imageProcessor.addCommand(new ShiftRgbCommand(pixels, new Region(0, 0, width, 100)));
        imageProcessor.addCommand(new ShiftRgbCommand(pixels, new Region(0, 0, width, 100)));
        imageProcessor.addCommand(new ShiftRgbCommand(pixels, new Region(height - 100, 0, width, 100)));
        imageProcessor.addCommand(new ShiftRgbCommand(pixels, new Region(height - 100, 0, width, 100)));
        imageProcessor.addCommand(new ShiftRgbCommand(pixels, new Region(50, 50, width - 50, height - 50)));
        imageProcessor.addCommand(new ShiftRgbCommand(pixels, new Region(50, 50, width - 50, height - 50)));

        imageProcessor.addCommand(new HMirrorCommand(pixels, new Region(0, 0, 270, height)));
        imageProcessor.addCommand(new HMirrorCommand(pixels, new Region(0, width - 270, 270, height)));
        imageProcessor.addCommand(new HMirrorCommand(pixels, new Region(0, 135, 270 * 2, height)));

        imageProcessor.addCommand(new VMirrorCommand(pixels, new Region(0, 0, width, 225)));
        imageProcessor.addCommand(new VMirrorCommand(pixels, new Region(height - 225, 0, width, 225)));

        imageProcessor.addCommand(new HMirrorCommand(pixels, new Region(0, 200, 200, height)));
        imageProcessor.addCommand(new HMirrorCommand(pixels, new Region(0, width - 400, 200, height)));

        imageProcessor.addCommand(new InvertCommand(pixels, new Region(0, 0, 300, 170)));
        imageProcessor.addCommand(new InvertCommand(pixels, new Region(50, 400, 180, 395)));
    }

    /**
     * Simple test and control for the InvertFilter
     *
     * @throws Exception
     */
    private static void testInvertCommand() throws Exception {
        // Load 00_start.bmp file
        pixels = Toolbox.getPixelRaster("00_start.bmp");
        // Apply InvertCommand
        imageProcessor.addCommand(new InvertCommand(pixels, new Region(0, 0, pixels[0].length, pixels.length)));
        // Write 01_invert.bmp
        Toolbox.writeToDisk(pixels, "01_invert.bmp");
        // Revert to original
        undoAllCommands();
        // Write 01_invert_control.bmp
        Toolbox.writeToDisk(pixels, "01_invert_control.bmp");
    }

    /**
     * Simple test and control for the ShitRgbFilter
     *
     * @throws Exception
     */
    private static void testShiftRgbCommand() throws Exception {
        // Load 00_start.bmp file
        pixels = Toolbox.getPixelRaster("00_start.bmp");
        // Apply ShiftRgbCommand
        imageProcessor.addCommand(new ShiftRgbCommand(pixels, new Region(0, 0, pixels[0].length, pixels.length)));
        // Write 02_shiftRgb.bmp
        Toolbox.writeToDisk(pixels, "02_shiftRgb.bmp");
        // Revert to original
        undoAllCommands();
        // Write 02_shiftRgb_control.bmp
        Toolbox.writeToDisk(pixels, "02_shiftRgb_control.bmp");
    }

    /**
     * Simple test and control for the HMirrorFilter
     *
     * @throws Exception
     */
    private static void testHMirrorCommand() throws Exception {
        // Load 00_start.bmp file
        pixels = Toolbox.getPixelRaster("00_start.bmp");
        // Apply HMirrorCommand
        imageProcessor.addCommand(new HMirrorCommand(pixels, new Region(0, 0, pixels[0].length, pixels.length)));
        // Write 03_horizontal.bmp
        Toolbox.writeToDisk(pixels, "03_horizontal.bmp");
        // Revert to original
        undoAllCommands();
        // Write 03_horizontal_control.bmp
        Toolbox.writeToDisk(pixels, "03_horizontal_control.bmp");
    }

    /**
     * Simple test and control for the VMirrorFilter
     *
     * @throws Exception
     */
    private static void testVMirrorCommand() throws Exception {
        // Load 00_start.bmp file
        pixels = Toolbox.getPixelRaster("00_start.bmp");
        // Apply VMirrorCommand
        imageProcessor.addCommand(new VMirrorCommand(pixels, new Region(0, 0, pixels[0].length, pixels.length)));
        // Write 04_vertical.bmp
        Toolbox.writeToDisk(pixels, "04_vertical.bmp");
        // Revert to original
        undoAllCommands();
        // Write 04_vertical_control.bmp
        Toolbox.writeToDisk(pixels, "04_vertical_control.bmp");
    }

    /**
     * Complex test with an encoded puzzle to test the correct working of all
     * Filters.
     *
     * @throws Exception
     */
    private static void testPuzzle() throws Exception {
        // Load puzzle.bmp
        pixels = Toolbox.getPixelRaster("10_puzzle.bmp");
        // Apply all filters to solve puzzle
        decodeImage();
        // Write 11_solution.bmp
        Toolbox.writeToDisk(pixels, "11_solution.bmp");
        // Revert to original
        undoAllCommands();
        // Write 11_solution_control.bmp
        Toolbox.writeToDisk(pixels, "11_solution_control.bmp");
    }

    public static void main(String[] args) {
        try {
            /*
             * * Invert **
             */
            //testInvertCommand();

            /*
             * * Shift Rgb **
             */
            //testShiftRgbCommand();

            /**
             * * Horizontal Mirror **
             */
            //testHMirrorCommand();

            /**
             * * Vertical Mirror**
             */
            //testVMirrorCommand();

            /**
             * * Solve Puzzle **
             */
            testPuzzle();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
