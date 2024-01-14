package assignment;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Square extends Button {

	private static final Image imgX = new Image(Square.class.getResource("/images/X.jpg").toString());
	private static final Image imgO = new Image(Square.class.getResource("/images/O.jpg").toString());

	private static final Image imgBLANK = new Image(Square.class.getResource("/images/cardback.jpg").toString());
	public static final Image imgGREEN = new Image(Square.class.getResource("/images/green.png").toString());
	public static final Image imgYELLOW = new Image(Square.class.getResource("/images/yellow.png").toString());
	public static final Image imgGRAY = new Image(Square.class.getResource("/images/gray.png").toString());

	public static final char X = 'X';
	public static final char O = 'O';
	public static final char BLANK = ' ';
	public static final char GREEN = 'G';
	public static final char YELLOW = 'Y';
	public static final char GRAY = 'A'; 
	
	private char value;
	
	public Square() {
		super();
		value = BLANK;
		setGraphic(new ImageView(imgBLANK));
	}

	public void playSquare(char val) {
		value = val;
		switch (value) {
		case X:
			setGraphic(new ImageView(imgX));
			break;
		case O:
			setGraphic(new ImageView(imgO));
			break;
		}
	}

	public char getValue() {
		return value;
	}
	
	public void clear() {
	    value = BLANK; // Reset the value to BLANK
	    setGraphic(new ImageView(imgBLANK)); // Set the graphic to the blank image
	}
	
	public void setGreen() {
		value = GREEN; // Set the value of the image to green 
		setGraphic(new ImageView(imgGREEN));
	}
	
	public void setYellow() {
		value = YELLOW; // Set the value of the image to yellow 
		setGraphic(new ImageView(imgYELLOW));
	}
	
	public void setGray() {
		value = GRAY; // Set the value of the image to gray 
		setGraphic(new ImageView(imgGRAY));
	}
	
	

}