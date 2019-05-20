package com.xuetang9.todo.ui.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

import com.xuetang9.todo.ui.view.MyFrame;

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
