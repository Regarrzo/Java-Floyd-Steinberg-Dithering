# Java-Floyd-Steinberg-Dithering
Java implementation of the Floyd-Steinberg Dithering Algorithm. Allows dithering images with custom color palettes. There are no dependencies.

### Usage:
You need two things: An instance of the ColorPalette class and a ditherer instance.
Colorpalettes are created by either passing a list of Color objects from java.awt.Color or by passing a list of VectorRGB objects.

The color palette instance is then passed to the constructor of a Ditherer object. Now you can pass a BufferedImage from 
java.awt.image.BufferedImage to the .dither method in the Ditherer class.
