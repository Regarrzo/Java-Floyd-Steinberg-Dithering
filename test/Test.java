import ditherer

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Main {

	public static void main(String[] args) {

		Color[] palette_colors = { new Color(255, 255, 255), new Color(155, 155, 155), new Color(0, 0, 0) };

		ColorPalette palette = new ColorPalette(palette_colors);

		Ditherer ditherer = new Ditherer(palette);

		BufferedImage img;
		try {
			img = ImageIO.read(new File("test_image.jpg"));

			ditherer.dither(img);

			File output_file = new File("out.png");
			ImageIO.write(img, "png", output_file);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
