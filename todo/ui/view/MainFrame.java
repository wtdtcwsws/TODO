package com.xuetang9.todo.ui.view;

import javax.swing.JFrame;

/**
 * 
 * @function 程序主界面
 * @author 吴桐
 * @date 2019年5月13日下午4:33:34
 * @place 公司
 * @version 1.0.0
 * @copyright 吴桐
 */
public class MainFrame extends JFrame{
	public MainFrame() {
		this.init();
		this.setVisible(true);
	}

	private void init() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(400, 650);
		this.setLocationRelativeTo(null);
		this.setTitle("番茄管理系统");
		
		
	}
}
