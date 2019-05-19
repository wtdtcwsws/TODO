package com.xuetang9.todo.common;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.border.Border;

public class LineBorder implements Border{
	private Color newColor = new Color(215, 224, 233);
	@Override
	public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
		int w = c.getWidth();
		int h = c.getHeight();
		// 绘制默认线条
		g.setColor(newColor);
		g.drawLine(0, h , w, h );
		c.repaint();
	}

	@Override
	public Insets getBorderInsets(Component c) {
		Insets insets = new Insets(0, 0, 2 , 0);
		return insets;
	}

	@Override
	public boolean isBorderOpaque() {
		// TODO Auto-generated method stub
		return true;
	}

}
