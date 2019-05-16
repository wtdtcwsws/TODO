package com.xuetang9.todo.ui.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;

import com.xuetang9.todo.ui.view.MyFrame;
/**
 * 
 * @function 最小化按钮事件
 * @author 吴桐
 * @date 2019年5月14日下午4:42:37
 * @place 公司
 * @version 1.0.0
 * @copyright 吴桐
 */
public class MinimizeButtonHandler extends MouseAdapter {

MyFrame myFrame;
	
	public MinimizeButtonHandler(MyFrame myFrame) {
		super();
		this.myFrame = myFrame;
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		
			myFrame.setExtendedState(JFrame.ICONIFIED);
	}

}
