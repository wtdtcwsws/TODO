package com.xuetang9.todo.ui.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
/**
 *  
 * @function 任务开始界面
 * @author 吴桐
 * @date 2019年5月19日下午4:23:12
 * @place 公司
 * @version 1.0.0
 * @copyright 吴桐
 */
public class StartFrame extends MyFrame{
	/**
	 * 背景面板
	 */
	private MyPanel myPanel;
	/**
	 * 右上红叉
	 */
	private JButton closeButton;
	/**
	 * 最小化
	 */
	private JButton minimizeButton;

	public StartFrame() {
		init();
	}
	
	
	@Override
	public void init() {
		configComponents();

		installComponents();

		installListeners();
		
	}
	private void configComponents() {
		
		
	}
	private void installComponents() {
		// TODO Auto-generated method stub
		
	}
	private void installListeners() {
		// TODO Auto-generated method stub
		
	}
	
}
