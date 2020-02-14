package ditherer;

import java.awt.Color;

public class ColorPalette {

	private VectorRGB[] colors;

	public ColorPalette(VectorRGB[] colors) {
		this.colors = colors;
	}

	public ColorPalette(Color[] colors) {
		this.colors = new VectorRGB[colors.length];

		for (int i = 0; i < colors.length; i++) {
			this.colors[i] = new VectorRGB(colors[i]);
		}
	}

	public VectorRGB getClosestMatch(VectorRGB color) {
		int minimum_index = 0;
		int minimum_difference = colors[0].fastDifferenceTo(color);

		for (int i = 1; i < colors.length; i++) {

			int current_difference = colors[i].fastDifferenceTo(color);

			if (current_difference < minimum_difference) {
				minimum_difference = current_difference;
				minimum_index = i;
			}
		}

		return colors[minimum_index];
	}

}
