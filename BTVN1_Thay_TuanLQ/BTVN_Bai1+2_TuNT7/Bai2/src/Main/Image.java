package Main;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Image {
    private String imageUrl;
    private BufferedImage bufferedImage;
    private int width, height;

    public Image(String imageUrl){
        this.imageUrl = imageUrl;

        try{
            bufferedImage = ImageIO.read(new File(imageUrl));
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public Image (int width, int height){
        this.width = width;
        this.height = height;
        bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    }

    public int getWidth() {
        width = bufferedImage.getWidth();
        return width;
    }

    public int getHeight() {
        height = bufferedImage.getHeight();
        return height;
    }

    public Color getPixelColor(int col, int row){
        Color pixelColor = new Color(bufferedImage.getRGB(col, row));
        return pixelColor;
    }

    public void setPixelColor(int col, int row, Color pixelColor){
        bufferedImage.setRGB(col, row, pixelColor.getRGB());
    }

    public void show(){
        try{
            File saveAs = new File("F:\\Bai1\\src\\Resources\\demo " + new Random().nextInt(100) + ".jpg");
            ImageIO.write(bufferedImage,"jpg", saveAs);

            Desktop.getDesktop().open(saveAs);
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
