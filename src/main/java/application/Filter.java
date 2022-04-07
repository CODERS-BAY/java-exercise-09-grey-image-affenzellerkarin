package application;

import java.awt.Color;

import picture.Picture;

public class Filter {
	private Picture picture;

	public Filter(Picture picture) {
		this.picture = picture;
	}

	/**
	 * The input picture should be converted to a grey scale. To achieve a grey
	 * image we need to sum up the red, green and blue value and divide it by 3.
	 * 
	 * @return converted picture
	 */
	public Picture greyScaleFilter() {


		for (int i = 1; i<picture.height(); i++) {
			for (int j=1; j<picture.width(); j++) {
				Color color = picture.get(i,j);
				int red = color.getRed();
				int blue=color.getBlue();
				int green=color.getGreen();
				int grey = (red+blue+green)/3;
				Color color1 = new Color(grey, grey, grey);
				picture.set(i,j,color1);
			}
		}
		/*
			your code here
		*/
		return picture;
	}

	/**
	 * As we have a range until 255 inclusive getting the inverted image is easy.
	 * Just subtract the color value from 255.
	 * 
	 * @return converted picture
	 */
	public Picture revertColorFilter() {
		for (int i = 1; i<picture.height(); i++) {
			for (int j=1; j<picture.width(); j++) {
				Color color = picture.get(i,j);
				Color color1 = new Color(255-color.getRed(), 255-color.getGreen(), 255-color.getBlue());
				picture.set(i,j,color1);
			}
		}
		/*
			your code here
		*/
		return picture;
	}

	//@formatter:off
	/**
	 * A sepia filter is a little more difficult to calculate.
	 * to get the
	 * 
	 * sepia red: (current red * 0.393) + (current green * 0.769) + (current blue * 0.189)
	 * sepia green: (current red * 0.349) + (current green * 0.686) + (current blue * 0.168)
	 * sepia blue: (current red * 0.292) + (current green * 0.534) + (current blue * 0.131)
	 * 
	 * the new value is then Math.min(sepia red, 255) and so on.
	 * 
	 * @return converted picture
	 */
	//@formatter:on

	public Picture sepiaFilter() {

		for (int i = 1; i<picture.height(); i++) {
			for (int j=1; j<picture.width(); j++) {
				Color color = picture.get(i,j);
				int red = color.getRed();
				int blue=color.getBlue();
				int green=color.getGreen();
				double sepiared=red*0.393+green*0.769+blue*0.189;
				double sepiagreen=red*0.349+green * 0.686 + blue * 0.168;
				double sepiablue=red * 0.292 + green * 0.534 + blue * 0.131;


				Color color1 = new Color((int)(Math.min(sepiared, 255)), (int)(Math.min(sepiagreen, 255)), (int)(Math.min(sepiablue, 255)));
				picture.set(i,j,color1);
			}
		}
		/*
			your code here
		*/
		return picture;
	}
}
