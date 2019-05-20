package com.xuetang9.todo.common;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
 
public class CountDown {
 
	private JFrame jFrame;
	private JLabel jl1;
	private JLabel jl2;
	private JLabel jl3;
 
	public static void main(String[] args) {
		new CountDown().getTime();
	}
 
	private void getTime() {
		long time = 3600;
		long hour = 0;
		long minute = 0;
		long seconds = 0;
		while (time > 0) {
			hour = time / 3600;
			minute = (time - hour * 3600) / 60;
			seconds = time - hour * 3600 - minute * 60;
			jl1.setText(hour + "时");
			jl2.setText(minute + "分");
			jl3.setText(seconds + "秒");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			time--;
		}
	}
 
	public CountDown() {
		jFrame = new JFrame("倒计时");
		jFrame.setLayout(new FlowLayout(FlowLayout.LEFT));
		jl1 = new JLabel();
		
		jl2 = new JLabel();
		jl3 = new JLabel();
		init();
	}
 
	private void init() {
		JPanel jPanel = new JPanel();
		
		jPanel.add(jl1);
		jPanel.add(jl2);
		jPanel.add(jl3);
		jFrame.add(jPanel);
		jFrame.setVisible(true);
		jFrame.setLocation(300, 400);
		jFrame.setSize(300, 200);
		jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
	}
 
}

