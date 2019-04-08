package Main;

import java.awt.*;

public class RedToBlue {
    public static void main(String[] args) {
        Image image = new Image("F:\\Bai1\\src\\Resources\\buf_img.jpg");
        int width = image.getWidth();
        int height = image.getHeight();

        Image resultImage = new Image(width, height);

        for (int col = 0; col < width; col++){
            for (int row = 0; row < height; row++){
                Color color = image.getPixelColor(col, row);
                int red = color.getRed();
                int green = color.getGreen();
                int blue = color.getBlue();
                if ((blue += red) > 255){
                    red = blue - 255;
                    blue = 255;
                    if ((green += red) > 255){
                        green = 255;
                    }
                }
                resultImage.setPixelColor(col, row, new Color(10, green, blue));
            }
        }

        resultImage.show();
    }
}
