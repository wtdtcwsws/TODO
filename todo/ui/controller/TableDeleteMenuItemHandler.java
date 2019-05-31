package com.xuetang9.todo.ui.controller;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.xuetang9.todo.service.RecordService;
import com.xuetang9.todo.service.impl.RecordServiceImpl;
import com.xuetang9.todo.ui.model.RecordTableModel;
import com.xuetang9.todo.ui.view.FullRecordFrame;
/**
 * 
 * @function table 右键菜单删除功能
 * @author 吴桐
 * @date 2019年5月22日下午1:34:47
 * @place 公司
 * @version 1.0.0
 * @copyright 吴桐
 */
public class TableDeleteMenuItemHandler implements ActionListener {

	private FullRecordFrame fullRecordFrame;
	private RecordService recordService= new RecordServiceImpl();
	private Point mouseClickedPoint;
	public TableDeleteMenuItemHandler(FullRecordFrame fullRecordFrame) {
		super();
		this.fullRecordFrame = fullRecordFrame;
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// 得到选中的行的行号
		int	focusedRowIndex = fullRecordFrame.getCustomerMessageTable().getSelectedRow();
		// 通过行号，使用model的getValueAt方法找到电话号码
		Object delPhone = fullRecordFrame.getCustomerMessageTable().getModel().getValueAt(focusedRowIndex, 5);
		
		boolean success = recordService.delete(delPhone);
		
		if (success) {
			// 通知model，load并刷新
			RecordTableModel model;
			model = (RecordTableModel) FullRecordFrame.getInstance().getCustomerMessageTable().getModel();
			model.load(recordService.find());
			model.fireTableDataChanged();
			new JOptionPane().showMessageDialog(fullRecordFrame, "删除成功");
		}else {
			new JOptionPane().showMessageDialog(fullRecordFrame, "删除失败！");
		}

	}

}
