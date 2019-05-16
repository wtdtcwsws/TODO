package com.xuetang9.todo.ui.view;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.xuetang9.todo.ui.controller.FullMouse;



/**
 * 
 * @function 背景面板
 * @author 吴桐
 * @date 2019年5月14日下午3:10:54
 * @place 公司
 * @version 1.0.0
 * @copyright 吴桐
 */
public class MyPanel extends JPanel {
	/**
	 * 背景图片路径
	 */
	private String iconPath;
	/**
	 * 绘制面板x坐标位置
	 */
	private int x;
	/**
	 * 绘制面板y坐标位置
	 */
	private int y;
	/**
	 * 绘制图片宽度
	 */
	private int w;
	/**
	 * 绘制图片高度
	 */
	private int h;
	/**
	 * 鼠标监听器（拖动窗体）
	 */
	MouseAdapter mouseAdapter;
	public MyPanel() {

		this("src/com/xuetang9/todo/resources/images/panel.jpg", 0, 0, 800, 440);

	}

	public MyPanel(String iconPath, int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.iconPath = iconPath;
		this.setBounds(x, y, w, h);
		this.setLayout(null);
		mouseAdapter = new FullMouse();
		this.addMouseListener(mouseAdapter);
		this.addMouseMotionListener(mouseAdapter);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		ImageIcon icon = new ImageIcon(iconPath);
		g.drawImage(icon.getImage(), x, y, w, h, null);
//		g.drawImage(icon.getImage(), x, y, w, h, x, y, w, h, null);


	}

	public String getIconPath() {
		return iconPath;
	}

	public void setIconPath(String iconPath) {
		this.iconPath = iconPath;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

}
