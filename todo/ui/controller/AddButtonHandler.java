package com.xuetang9.todo.ui.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import com.xuetang9.todo.ui.view.MainFrame;
import com.xuetang9.todo.ui.view.MyFrame;

public class AddButtonHandler extends MouseAdapter {
	
	MainFrame mainFrame;
	
	public AddButtonHandler(MainFrame mainFrame) {
		super();
		this.mainFrame = mainFrame;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
		((JButton)e.getSource()).setIcon(new ImageIcon("src/com/xuetang9/todo/resources/images/添加2.png"));
	
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
		((JButton)e.getSource()).setIcon(new ImageIcon("src/com/xuetang9/todo/resources/images/添加.png"));
	
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
			mainFrame.dispose();
	}

}
