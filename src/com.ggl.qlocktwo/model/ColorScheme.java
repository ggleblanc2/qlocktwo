package com.ggl.qlocktwo.model;

import java.awt.Color;

public class ColorScheme {

	private Color background;
	private Color off;
	private Color on;

	public ColorScheme() {
		setBlackColorScheme();
	}

	public Color getBackground() {
		return background;
	}

	public Color getOff() {
		return off;
	}

	public Color getOn() {
		return on;
	}

	public void setBlackColorScheme() {
		this.background = Color.BLACK;
		this.off = Color.DARK_GRAY;
		this.on = Color.WHITE;
	}

	public void setPinkColorScheme() {
		this.background = Color.PINK;
		this.off = Color.WHITE;
		this.on = Color.BLACK;
	}

	public void setRedColorScheme() {
		this.background = new Color(192, 0, 0);
		this.off = Color.GRAY;
		this.on = Color.WHITE;
	}

	public void setBlueColorScheme() {
		this.background = Color.BLUE;
		this.off = Color.DARK_GRAY;
		this.on = Color.WHITE;
	}

	public void setGreenColorScheme() {
		this.background = Color.GREEN;
		this.off = Color.GRAY;
		this.on = Color.BLACK;
	}

}