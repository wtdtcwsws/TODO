package com.xuetang9.todo.common;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.border.Border;

/**
 * 
 * @function
 * @author 吴桐
 * @date 2019年5月12日下午9:51:40
 * @place 公司
 * @version 1.0.0
 * @copyright 吴桐
 */
public class AnimationLineBorder implements Border {

	/**
	 * 线条的厚度
	 */
	private int thickness;
	/**
	 * 线条默认颜色
	 */
	private Color defaultColor;
	/**
	 * 线条高亮的颜色
	 */
	private Color highlightColor;

	/**
	 * 线条动画是否开始
	 */
	private boolean isStart;

	/**
	 * 记录动画线条起始的x坐标
	 */
	private int startX;

	private int grow = 1;

//	private float r = 100;
//	private float g = 200;
//	private float b = 150;
	private int r = 255;
	private int g = 0;
	private int b = 0;

	private Color activeColor;

	public AnimationLineBorder() {
		this(1, new Color(215, 224, 233), new Color(94, 192, 110));
	}

	public AnimationLineBorder(int thickness, Color defaultColor, Color highlightColor) {
		super();
		this.thickness = thickness;
		this.defaultColor = defaultColor;
		this.highlightColor = highlightColor;
	}

	@Override
	public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
		// 得到组件的宽度和高度
		int w = c.getWidth();
		int h = c.getHeight();
		// 绘制默认线条
		g.setColor(defaultColor);
		g.drawLine(0, h - thickness, w, h - thickness);
		if (!isStart) {
			isStart = c.hasFocus();
		}
		if (isStart) {
			if (c.hasFocus()) {
				drawExtension(g, w, h);
			} else {
//				drawShrink(g, w, h);
				g.setColor(highlightColor);
				g.drawLine(0, h - thickness, w, h - thickness);
			}
			c.repaint();
		}

		// 绘制高亮线条
		if (!isStart && c.hasFocus()) {
			drawHighlightLine(g, w, h);
		}
	}

	@Override
	public Insets getBorderInsets(Component c) {
		Insets insets = new Insets(0, 0, 2 * thickness, 0);
		return insets;
	}

	@Override
	public boolean isBorderOpaque() {
		return true;
	}

	public void animate() {
		isStart = true;
	}

	private void drawHighlightLine(Graphics g, int w, int h) {
		// 绘制高亮线条
		g.setColor(highlightColor);
		g.drawLine(0, h - 2 * thickness, w,  h - 2 * thickness);

	}

	/**
	 * 绘制扩展线条动画
	 * 
	 * @param g
	 * @param w
	 * @param h
	 */
	private void drawExtension(Graphics g, int w, int h) {
		try {
			Thread.sleep(30);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		startX = w / 2;
		// 绘制高亮线条
		g.setColor(activeColor = new Color(r, this.g, b));
		g.drawLine(startX - grow, h - 2 * thickness, startX + grow, h - 2 * thickness);
		grow++;
		if ( b == 0 && r == 255) {
			this.g+=5;
		}
		if (this.g == 255 && b == 0) {
			r-=5;
		}
		if (r == 0 && this.g == 255) {
			b+=5;
		}
		if (b == 255 && r == 0) {
			this.g-=5;
		}
		if (this.g == 0 && b == 255) {
			r+=5;
		}if (r==255&&this.g==0) {
			b-=5;
		}
//		System.out.println(r + " " + this.g + " " + b);
		if (startX - grow <= 0) {
			grow = 0;
			isStart = false;
		}
	}

	/**
	 * 绘制收缩线条动画
	 * 
	 * @param g
	 * @param w
	 * @param h
	 */
	private void drawShrink(Graphics g, int w, int h) {
		try {
			Thread.sleep(0);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// 绘制高亮线条
		g.setColor(activeColor);
		g.drawLine(0 + grow, h - 2 * thickness, w - grow, h - 2 * thickness);
//		g.drawLine(0 , h - 2 * thickness, w , h - 2 * thickness);
		grow++;
		if ( b == 0 && r == 255) {
			this.g+=5;
		}
		if (this.g == 255 && b == 0) {
			r-=5;
		}
		if (r == 0 && this.g == 255) {
			b+=5;
		}
		if (b == 255 && r == 0) {
			this.g-=5;
		}
		if (this.g == 0 && b == 255) {
			r+=5;
		}if (r==255&&this.g==0) {
			b-=5;
		}
		if (grow >= w / 2) {
			grow = 0;
			isStart = false;
		}
	}
}
