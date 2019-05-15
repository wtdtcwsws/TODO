package com.xuetang9.todo.ui.view;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.xuetang9.todo.ui.controller.CloseButtonHandler;
import com.xuetang9.todo.ui.controller.MinimizeButtonHandler;

/**
 * 
 * @function 无边框有背景窗口
 * @author 吴桐
 * @date 2019年5月14日下午3:00:46
 * @place 公司
 * @version 1.0.0
 * @copyright 吴桐
 */
public class MyFrame extends JFrame {
	/**
	 * 带背景panel
	 */
	private MyPanel contentPane = new MyPanel();
	private JButton closeButton = new JButton();
	private JButton minimizeButton = new JButton();

	public MyFrame() {
		this.init();
		this.setVisible(true);
	}

	private void init() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(800, 440);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setTitle("番茄管理系统");
		/**
		 * 无修饰边框
		 */
		setUndecorated(true);

		configComponents();
		installComponents();
		installListeners();

	}

	private void configComponents() {
		configButtons();

	}

	private void configButtons() {
		closeButton.setBounds(760, 25, 20, 20);
		closeButton.setBorder(null);
		closeButton.setContentAreaFilled(false);

		closeButton.setIcon(new ImageIcon("src/com/xuetang9/todo/resources/images/关闭.png"));
		
		minimizeButton.setBounds(720, 25, 20, 20);
		minimizeButton.setBorder(null);
		minimizeButton.setContentAreaFilled(false);

		minimizeButton.setIcon(new ImageIcon("src/com/xuetang9/todo/resources/images/最小化.png"));
		
	}

	public void installComponents() {
		this.getContentPane().add(minimizeButton);
		this.getContentPane().add(closeButton);
		this.getContentPane().add(contentPane);
//		contentPane.add(closeButton);
	}

	private void installListeners() {
		closeButton.addMouseListener(new CloseButtonHandler(this));
		minimizeButton.addMouseListener(new MinimizeButtonHandler(this));
//		setExtendedState(JFrame.ICONIFIED);
	}
	public MyPanel getContent() {
		
		return contentPane;
	}
}
