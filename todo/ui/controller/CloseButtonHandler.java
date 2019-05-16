package com.xuetang9.todo.ui.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



import com.xuetang9.todo.ui.view.MyFrame;

/**
 * 
 * @function 右上角关闭按钮事件
 * @author 吴桐
 * @date 2019年5月14日下午3:43:18
 * @place 公司
 * @version 1.0.0
 * @copyright 吴桐
 */
public class CloseButtonHandler extends MouseAdapter{
	
	MyFrame myFrame;
	
	public CloseButtonHandler(MyFrame myFrame) {
		super();
		this.myFrame = myFrame;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
			myFrame.dispose();
	}
}
