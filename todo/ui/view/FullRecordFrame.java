package com.xuetang9.todo.ui.view;

import java.awt.BorderLayout;
import java.awt.event.InputEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;

import com.sun.glass.events.KeyEvent;
import com.xuetang9.todo.service.RecordService;
import com.xuetang9.todo.service.impl.RecordServiceImpl;
import com.xuetang9.todo.ui.model.RecordTableModel;
/**
 * 
 * @function 历史记录
 * @author 吴桐
 * @date 2019年5月22日上午8:37:44
 * @place 公司
 * @version 1.0.0
 * @copyright 吴桐
 */
public class FullRecordFrame extends JFrame{
	JPanel contentPane;
	JMenuBar menuBar = new JMenuBar();
	JMenu customerMenu = new JMenu("用户管理(C)");
	JMenuItem addcustomerMenuItem = new JMenuItem("新增用户");
	JMenuItem RecycleMenuItem = new JMenuItem("回收站");
	/**
	 * tableModel需要传参
	 */
	RecordTableModel tableModel;
	JTable recordMessageTable = new JTable();
	JScrollPane scrollPane = new JScrollPane(recordMessageTable);
	
	JPopupMenu mouseRightButtonMenu = new JPopupMenu();
	JMenuItem mouseRightButtonDeleteMenuItem = new JMenuItem("删除");
	JMenuItem mouseRightButtonChangeMenuItem = new JMenuItem("修改");
	
	RecordService recordService = new RecordServiceImpl();

	/**
	 * 1单例模式
	 */
	private static FullRecordFrame single;

	public static FullRecordFrame getInstance() {
		return single;
	}

	public FullRecordFrame() {
		single = this;
		this.init();
		this.setVisible(true);
	}

	private void init() {
		this.setDefaultCloseOperation(2);
		this.setSize(600, 500);
		this.setLocationRelativeTo(null);

		this.setTitle("查询记录");

		contentPane = (JPanel) this.getContentPane();

		configComponents();
		installComponents();
		installListeners();
	}

	private void configComponents() {
	
		configMenu();
		configTable();
	}
	

	private void configMenu() {
		customerMenu.setMnemonic(KeyEvent.VK_C);
		addcustomerMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
		RecycleMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_DOWN_MASK));
	
	}

	private void configTable() {
		tableModel = new RecordTableModel(recordService.find());

		recordMessageTable.setModel(tableModel);

	}

	private void installComponents() {
		installMenu();
//		this.setJMenuBar(menuBar);
		mouseRightButtonMenu.add(mouseRightButtonDeleteMenuItem);
		mouseRightButtonMenu.add(mouseRightButtonChangeMenuItem);
		contentPane.add(scrollPane, BorderLayout.CENTER);

	}

	private void installMenu() {
		menuBar.add(customerMenu);
		customerMenu.add(addcustomerMenuItem);
		customerMenu.add(RecycleMenuItem);

	}

	private void installListeners() {
//		recordMessageTable.addMouseListener(new CustomerMessageTablePopupMenuHandler(this));
//		mouseRightButtonDeleteMenuItem.addActionListener(new TableDeleteMenuItemHandler(this));
//		mouseRightButtonChangeMenuItem.addActionListener(new TableChangeMenuItemHandler());
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public RecordTableModel getTableModel() {
		return tableModel;
	}

	public JTable getCustomerMessageTable() {
		return recordMessageTable;
	}

	public JPopupMenu getMouseRightButtonMenu() {
		return mouseRightButtonMenu;
	}
}
