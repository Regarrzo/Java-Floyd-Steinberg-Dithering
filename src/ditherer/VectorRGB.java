package ditherer;

import java.awt.Color;

public class VectorRGB {
	public int r;
	public int g;
	public int b;

	public VectorRGB(int r, int g, int b) {
		this.r = r;
		this.b = b;
		this.g = g;
	}

	public VectorRGB(Color color) {
		this.r = color.getRed();
		this.b = color.getBlue();
		this.g = color.getGreen();
	}

	public VectorRGB(int rgb) {
		Color color = new Color(rgb);
		this.r = color.getRed();
		this.b = color.getBlue();
		this.g = color.getGreen();
	}

	public int toRGB() {
		return new Color(r, g, b).getRGB();
	}

	public Color toColor() {
		return new Color(r, g, b);
	}

	public VectorRGB subtract(VectorRGB other) {
		return new VectorRGB(this.r - other.r, this.g - other.g, this.b - other.b);
	}

	public VectorRGB add(VectorRGB other) {
		return new VectorRGB(this.r + other.r, this.g + other.g, this.b + other.b);
	}

	public int fastDifferenceTo(VectorRGB other) {
		VectorRGB difference = this.subtract(other);
		return Math.abs(difference.r) + Math.abs(difference.g) + Math.abs(difference.b);
	}

	public VectorRGB scalarMultiply(float scalar) {
		return new VectorRGB((int) (this.r * scalar), (int) (this.g * scalar), (int) (this.b * scalar));
	}

	public VectorRGB clip(int minimum, int maximum) {
		VectorRGB clipped = new VectorRGB(r, g, b);
		if (clipped.r > maximum) {
			clipped.r = maximum;
		} else if (clipped.r < minimum) {
			clipped.r = minimum;
		}

		if (clipped.g > maximum) {
			clipped.g = maximum;
		} else if (clipped.g < minimum) {
			clipped.g = minimum;
		}

		if (clipped.b > maximum) {
			clipped.b = maximum;
		} else if (clipped.b < minimum) {
			clipped.b = minimum;
		}

		return clipped;

	}
}
