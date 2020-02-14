package ditherer;

import java.awt.image.BufferedImage;

public class Ditherer {

	private ColorPalette palette;

	public Ditherer(ColorPalette palette) {
		this.setPalette(palette);
	}

	public ColorPalette getPalette() {
		return palette;
	}

	public void setPalette(ColorPalette palette) {
		this.palette = palette;
	}

	public void dither(BufferedImage img) {
		for (int y = 0; y < img.getHeight(); y++) {
			for (int x = 0; x < img.getWidth(); x++) {

				VectorRGB current_color = new VectorRGB(img.getRGB(x, y));
				VectorRGB closest_match = palette.getClosestMatch(current_color);
				VectorRGB error = current_color.subtract(closest_match);

				img.setRGB(x, y, closest_match.toRGB());

				if (!(x == img.getWidth() - 1)) {
					img.setRGB(x + 1, y,
							((new VectorRGB(img.getRGB(x + 1, y)).add(error.scalarMultiply((float) 7 / 16)))
									.clip(0, 255).toRGB()));

					if (!(y == img.getHeight() - 1)) {
						img.setRGB(x + 1, y + 1,
								((new VectorRGB(img.getRGB(x + 1, y + 1)).add(error.scalarMultiply((float) 1 / 16)))
										.clip(0, 255).toRGB()));
					}
				}

				if (!(y == img.getHeight() - 1))

				{

					img.setRGB(x, y + 1,
							((new VectorRGB(img.getRGB(x, y + 1)).add(error.scalarMultiply((float) 3 / 16)))
									.clip(0, 255).toRGB()));

					if (!(x == 0)) {
						img.setRGB(x - 1, y + 1, ((new VectorRGB(img.getRGB(x - 1, y + 1))
								.add(error.scalarMultiply(5 / 16)).clip(0, 255).toRGB())));

					}
				}

			}

		}

	}

}
