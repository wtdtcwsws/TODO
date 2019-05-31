package com.xuetang9.todo.ui.controller;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.xuetang9.todo.ui.view.FullRecordFrame;
/**
 *  
 * @function table 右键事件
 * @author 吴桐
 * @date 2019年5月22日下午1:17:37
 * @place 公司
 * @version 1.0.0
 * @copyright 吴桐
 */
public class RecordMessageTablePopupMenuHandler extends MouseAdapter {

	private FullRecordFrame fullRecordFrame;
	private Point mouseClickedPoint;
	public RecordMessageTablePopupMenuHandler(FullRecordFrame fullRecordFrame) {
		super();
		this.fullRecordFrame = fullRecordFrame;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getButton()!=MouseEvent.BUTTON3) {
			return;
		}else {
			// 显示右键菜单
			
			fullRecordFrame.getMouseRightButtonMenu().show
			(fullRecordFrame.getCustomerMessageTable(), e.getX(), e.getY());
			mouseClickedPoint = new Point(e.getX(), e.getY());
			// 通过鼠标右键点击位置获取Table的行数
			int focusedRowIndex = fullRecordFrame.getCustomerMessageTable().rowAtPoint(mouseClickedPoint);
			// 选中该位置的整行
			fullRecordFrame.getCustomerMessageTable().setRowSelectionInterval(focusedRowIndex, focusedRowIndex);
		}
	}

}
