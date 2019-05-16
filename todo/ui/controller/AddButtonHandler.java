package com.xuetang9.todo.ui.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.xuetang9.todo.common.LayerZIndex;
import com.xuetang9.todo.ui.view.AddPanel;
import com.xuetang9.todo.ui.view.MainFrame;

public class AddButtonHandler extends MouseAdapter {

	MainFrame mainFrame;
	AddPanel addPanel;

	public AddButtonHandler(MainFrame mainFrame) {
		super();
		this.mainFrame = mainFrame;
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		if ( addPanel == null||!addPanel.isVisible() ) {

			addPanel = new AddPanel(MainFrame.getInstance());
			MainFrame.getInstance().getLayeredPane().add(addPanel, LayerZIndex.LAYER_MODAL);
		}
	}

}
