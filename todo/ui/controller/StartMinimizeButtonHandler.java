package com.xuetang9.todo.ui.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

import com.xuetang9.todo.ui.view.MyFrame;
/**
 * 
 * @function 最小化窗口按钮事件
 * @author 吴桐
 * @date 2019年5月20日下午3:12:53
 * @place 公司
 * @version 1.0.0
 * @copyright 吴桐
 */
public class StartMinimizeButtonHandler extends MouseAdapter {
	MyFrame myFrame;
	public StartMinimizeButtonHandler(MyFrame myFrame) {
		this.myFrame = myFrame;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		myFrame.setExtendedState(JFrame.ICONIFIED);

	}


}
