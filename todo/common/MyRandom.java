package com.xuetang9.todo.common;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import com.xuetang9.todo.common.LayerZIndex;

/**
 * 
 * @function 任务修改界面
 * @author 吴桐
 * @date 2019年5月19日下午10:53:16
 * @place 公司
 * @version 1.0.0
 * @copyright 吴桐
 */
public class MyRandom extends JFrame implements ActionListener, Runnable {
	private JTextField textField;
	private JButton startButton;
	private JButton stopButton;
	private boolean isRunning = false;
	private String[] name = { "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven",
			"twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen" };


	public MyRandom() {

		Thread t1 = new Thread(this);
		init();
		this.setVisible(true);
		t1.start();
	}

	private void init() {
		this.setSize(300, 200);
		this.setLayout(null);
		this.setDefaultCloseOperation(3);
		configComponents();
		installComponents();
		installListeners();
	}

	private void configComponents() {
		textField = new JTextField();
		textField.setBounds(10, 10, 150, 30);
		startButton = new JButton("开始");
		startButton.setBounds(10, 50, 80, 30);
		stopButton = new JButton("暂停");
		stopButton.setBounds(110, 50, 80, 30);

	}

	private void installComponents() {
		this.getLayeredPane().add(textField, LayerZIndex.LAYER_CONTENT);
		this.getLayeredPane().add(startButton, LayerZIndex.LAYER_CONTENT);
		this.getLayeredPane().add(stopButton, LayerZIndex.LAYER_CONTENT);

	}

	private void installListeners() {
		startButton.addActionListener(this);
		stopButton.addActionListener(this);
	}

	@Override
	public void run() {
		Random rd = new Random();
		while (true) {
			try {
				if (!isRunning) {
					synchronized (this) {
						this.wait();
					}
				}
				Random myRandomName = new Random();
				int RN = myRandomName.nextInt(name.length);
				textField.setText(name[RN]);
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == startButton) {
			synchronized (this) {
				notify();
				isRunning = true;
			}
		}
		if (e.getSource() == stopButton) {
			synchronized (this) {
				notify();
				isRunning = false;
			}
			
		}

	}
	public static void main(String[] args) {
		new MyRandom();
	}
}
