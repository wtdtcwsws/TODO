package com.xuetang9.todo.ui.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.ScrollPaneLayout;

import com.xuetang9.todo.model.TodoTask;

public class RecordFrame extends JFrame {
	/**
	 * 滚动面板
	 */
	private JScrollPane scrollPane;
	/**
	 * 文本域
	 */
	private JTextArea textArea;
	/**
	 * 需要记录的任务
	 */
	private TodoTask recordTask;

	public RecordFrame(TodoTask recordTask) {
		this.recordTask = recordTask;
		this.init();
		this.setVisible(true);
	}

	public RecordFrame() {
		this.recordTask = new TodoTask();
		this.init();
		this.setVisible(true);
	}

	/**
	 * 初始化
	 */
	private void init() {
		// 设置窗口的基础信息
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		// 设置窗口大小
		this.setSize(600, 500);
		// 设置窗口位置
		this.setLocationRelativeTo(null);
		// 窗体不可变
		this.setResizable(false);
		// 设置窗口图标
		this.setIconImage(new ImageIcon("resources/images/心得icon.png").getImage());
		// 设置窗口标题
		this.setTitle("心得记录");
		// 窗口置顶
//		this.setAlwaysOnTop(true);
		// 配置组件
		configComponents();
		// 组装组件
		installComponents();
		// 组装事件监听组件
		installListeners();

	}

	/**
	 * 配置组件
	 */
	private void configComponents() {

		configTextArea();
		configScrollPane();

	}

	/**
	 * 滚动面板配置
	 */
	private void configScrollPane() {
		scrollPane = new JScrollPane(textArea, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setLayout(new ScrollPaneLayout());
	}

	/**
	 * 设置文本域
	 */
	private void configTextArea() {
		// 设置文本自动换行
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setFont(new Font("宋体", Font.PLAIN, 20));
	}

	/**
	 * 组装组件
	 */
	private void installComponents() {

		this.getContentPane().add(scrollPane, BorderLayout.CENTER);
	}

	/**
	 * 组装事件监听组件
	 */
	private void installListeners() {
		this.addWindowListener(new ExistActionHandler());
	}
	

	/**
	 * 程序入口
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		new RecordFrame();
	}

	/**
	 * 
	 * @function 退出监听确认
	 * @author 吴桐
	 * @date 2019年5月21日下午9:44:18
	 * @place 公司
	 * @version 1.0.0
	 * @copyright 吴桐
	 */
	private class ExistActionHandler extends WindowAdapter {


		@Override
		public void windowClosing(WindowEvent e) {
			// 弹出确认对话框
			JOptionPane optionPane = new JOptionPane();
			int choice = optionPane.showConfirmDialog(null, "记录并退出？");
			if (choice == 0) {
				// 确认
				String feeling = textArea.getText();

				recordTask.setFeeling(feeling);

				RecordFrame.this.dispose();
			}
			if (choice == 1) {
				// 否--不记录
				String feeling ="无";

				recordTask.setFeeling(feeling);
				RecordFrame.this.dispose();
			}
			if (choice == 2) {
				// 取消
			}

		}

	}

}
