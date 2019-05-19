package com.xuetang9.todo.ui.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 * 
 * @function 任务标签
 * @author 吴桐
 * @date 2019年5月17日上午11:22:55
 * @place 公司
 * @version 1.0.0
 * @copyright 吴桐
 */
public class TaskLabel extends JLabel {
	int random = (int) (Math.random() * 100) % 3 + 1;
	ImageIcon icon = new ImageIcon("resources/images/taskLabel" + random + ".png");
	
	private int r = 1;
	private int g = 89;
	private int b = 79;
	/**
	 * 任务信息 --姓名
	 */
	private String taskName;
	/**
	 * 任务信息 --id 不显示，用于识别
	 */
	private String id;
	private JButton startButton;
	public TaskLabel() {
		this.setPreferredSize(new Dimension(500, 50));
		this.setBackground(new Color(r, g, b));
//		this.setOpaque(true);
		this.setBorder(null);
	}

	public TaskLabel(String taskName,String id) {
		this();
		this.id = id;
		this.taskName = taskName;
		this.setForeground(Color.WHITE);
		this.setText(taskName);
		this.setFont(new Font("行楷", Font.PLAIN, 40));
		this.setLayout(null);
		init();
	}

	private void init() {
		configs();
		insatlls();
		insatllListeners();
		
	}

	private void configs() {
		startButton = new JButton("开始");
		startButton.setBounds(400, 10, 80, 30);
		startButton.setBorder(null);
		startButton.setBackground(new Color(r, g, b,255));
		startButton.setFocusable(false);
		startButton.setFont(new Font("华文琥珀",Font.PLAIN,20));
		
	}

	private void insatlls() {
		this.add(startButton);
		
	}

	private void insatllListeners() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 颜色渐变
	 */
	private void chengeColor() {
		// 颜色变化幅度 --（只能选被255整除的数、或添加判断）
		int step = 1;
		if (b == 0 && r == 255) {
			this.g += step;
		}
		if (this.g == 255 && b == 0) {
			r -= step;
		}
		if (r == 0 && this.g == 255) {
			b += step;
		}
		if (b == 255 && r == 0) {
			this.g -= step;
		}
		if (this.g == 0 && b == 255) {
			r += step;
		}
		if (r == 255 && this.g == 0) {
			b -= step;
		}
	}

	
	@Override
	protected void paintComponent(Graphics g) {

		chengeColor();
		g.setColor(new Color(r, this.g, b));
		
//		String iconPath = "resources/images/taskLabel"+random+".png";
//		ImageIcon icon = new ImageIcon(iconPath);
		g.drawImage(icon.getImage(), 0, 0, 500, 50, null);
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.paintComponent(g);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		
		
//		repaint();
		
	}

}
