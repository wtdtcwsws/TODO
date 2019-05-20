package com.xuetang9.todo.common;

import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class RandomName // implements extends Thread
		implements ActionListener, Runnable {
// 設置一個標記
	private boolean flag = false;
	private JFrame randomFrame = new JFrame("隨機獲取名字");
// 创建一个Panel对象。
	private JPanel randomPanel = new JPanel();
	private TextField tf = new TextField(30);
	private JButton randomButton1 = new JButton("Run");
	private JButton randomButton2 = new JButton("Stop");
	private String[] name = { "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven",
			"twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen" };

	public RandomName() {
// 向JPanel容器中添加三个组件
		randomPanel.add(tf);
		randomPanel.add(randomButton1);
		randomPanel.add(randomButton2);
		randomFrame.add(randomPanel);
// 取得屏幕的宽度
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
// 取得屏幕的高度
		int height = Toolkit.getDefaultToolkit().getScreenSize().height;
// 设置组件不可改变大小
		randomFrame.setResizable(false);
// 设置关闭窗体时结束程序
		randomFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// 设置组件大小
		randomFrame.setSize(250, 120);
// 设置组件位置
		randomFrame.setLocation((width - 250) / 2, (height - 120) / 2);
// 设置组件大小和位置
// randomFrame.setBounds(30, 30, 250, 120);
// 设置组件可见
		randomFrame.setVisible(true);
		addListener();
	}

	private void addListener() {
		randomButton1.addActionListener(this);
		randomButton2.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == randomButton1) {
			synchronized (this) {
				notify();
				flag = true;
			}
		}
		if (obj == randomButton2) {
			synchronized (this) {
				flag = false;
			}
		}
	}

	public void run() {
		int length = name.length;
		while (true) {
			try {
				if (!flag) {
					synchronized (this) {
						this.wait();
					}
				}
				Random myRandomName = new Random();
				int RN = myRandomName.nextInt(length);
				tf.setText(name[RN]);
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		RandomName rn = new RandomName();
		Thread t1 = new Thread(rn);
		t1.start();
	}
}
