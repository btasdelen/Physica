package model;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;


/**
 * @author furkan
 *
 */

public class Settings {
	
	private Font font;
	private int fontSize;
	private Color fontColor;
	private ImageIcon background;
	private int audioVolume;
	
	public Settings()
	{

		fontSize = 24;
		font = new Font( "Times New Roman", Font.PLAIN, fontSize);
		fontColor = new Color( 0, 0, 0);
		background = null;
		audioVolume = 20;
	}
	
	public Font getFont() {
		return font;
	}
	public void setFont(Font font) {
		this.font = font;
	}
	public int getFontSize() {
		return fontSize;
	}
	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
	}
	public Color getFontColor() {
		return fontColor;
	}
	public void setFontColor(Color fontColor) {
		this.fontColor = fontColor;
	}
	public ImageIcon getBackground() {
		return background;
	}
	public void setBackground(ImageIcon background) {
		this.background = background;
	}
	public int getAudioVolume() {
		return audioVolume;
	}
	public void setAudioVolume(int audioVolume) {
		this.audioVolume = audioVolume;
	}
	
}