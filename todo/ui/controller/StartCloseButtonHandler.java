package com.xuetang9.todo.ui.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.xuetang9.todo.ui.view.MyFrame;

public class StartCloseButtonHandler extends MouseAdapter {
	MyFrame myFrame;
	public StartCloseButtonHandler(MyFrame myFrame) {
		this.myFrame = myFrame;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		
		myFrame.dispose();

	}


}
