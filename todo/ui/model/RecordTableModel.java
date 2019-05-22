package com.xuetang9.todo.ui.model;

import java.util.Arrays;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.xuetang9.todo.model.TodoTask;

public class RecordTableModel extends AbstractTableModel {

	// 声明数据集合
	List<TodoTask> todoTasks ;
	// 声明表头集合
	List<String> columnName = Arrays.asList("任务名称","单任务长度","任务个数","休息时长","长休时长","完成日期","心得");
	public RecordTableModel (List<TodoTask> todotasks){
//		load(customers);
		this.todoTasks = todotasks;
	}
	/**
	 * 无参构造
	 */
	public RecordTableModel() {
		
	}

	@Override
	/**
	 * 得到行数
	 */
	public int getRowCount() {
//		sercice = new WuTongServiceImpl();
//		customers = sercice.find();
		// TODO Auto-generated method stub
		return todoTasks.size();
	
	}

	@Override
	/**
	 * 得到列数
	 */
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnName.size();
	}
	
	@Override
	/**
	 * 得到表头
	 */
	public String getColumnName(int column) {
		String columns;
		columns = columnName.get(column);
		return columns;
	}

	@Override
	/**
	 * 得到数据
	 */
	public Object getValueAt(int rowIndex, int columnIndex) {
		Object cellvalue = null;
		TodoTask todoTask = todoTasks.get(rowIndex);
		switch (columnIndex) {
		case 0:
			cellvalue = todoTask.getTaskName();
			break;
		case 1:
			cellvalue = todoTask.getTaskSize();
			break;
		case 2:
			cellvalue = todoTask.getTaskNum();
			break;
		case 3:
			cellvalue = todoTask.getBreakSize();
			break;
		case 4:
			cellvalue = todoTask.getLongBreakSize();
		case 5:
			cellvalue = todoTask.getDate();
			break;
		case 6:
			cellvalue = todoTask.getFeeling();
			break;
	
		}
		return cellvalue;
	}
	public void load(List<TodoTask> todoTasks) {
		this.todoTasks.clear();
		this.todoTasks.addAll(todoTasks);
//		this.customers = customers;
	}
}
