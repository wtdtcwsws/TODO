package com.xuetang9.todo.ui.view;

import javax.swing.JFrame;


/**
 * 
 * @function 无边框有背景窗口
 * @author 吴桐
 * @date 2019年5月14日下午3:00:46
 * @place 公司
 * @version 1.0.0
 * @copyright 吴桐
 */
public  abstract class MyFrame extends JFrame {
	

	public MyFrame() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(800, 440);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		/**
		 * 无修饰边框
		 */
		this.setUndecorated(true);
		this.init();
		this.setVisible(true);
		
	}

	public abstract void init();


}
