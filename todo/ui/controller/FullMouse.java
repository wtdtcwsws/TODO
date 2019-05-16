package com.xuetang9.todo.ui.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.xuetang9.todo.ui.view.MyPanel;

public class FullMouse extends MouseAdapter {

	boolean isDraging = false;
	int startX;
	int startY;

	@Override
	public void mousePressed(MouseEvent e) {
		isDraging = true;
		startX = e.getX();
		startY = e.getY();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		isDraging = false;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if (isDraging) {
			MyPanel mypanel = (MyPanel) e.getSource();
			int locationX = mypanel.getRootPane().getParent().getLocationOnScreen().x;
			int locationY = mypanel.getRootPane().getParent().getLocationOnScreen().y;
			mypanel.getRootPane().getParent().setLocation(locationX - startX + e.getX(), locationY - startY + e.getY());

		}
	}

}
