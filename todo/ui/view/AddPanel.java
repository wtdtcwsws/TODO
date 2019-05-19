package com.xuetang9.todo.ui.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.xuetang9.todo.common.AnimationLineBorder;
import com.xuetang9.todo.model.TodoTask;
import com.xuetang9.todo.service.TodoTaskService;
import com.xuetang9.todo.service.impl.TodoTaskServiceImpl;


/**
 * 
 * @function 任务添加面板
 * @author 吴桐
 * @date 2019年5月16日上午11:55:48
 * @place 公司
 * @version 1.0.0
 * @copyright 吴桐
 */
public class AddPanel extends JPanel{
	MainFrame mainFrame;
	JButton close = new JButton();
	JButton cancel  = new JButton();
	JButton confirm = new JButton();
	JLabel taskNameLabel;
	JLabel taskSizeLabel;
	JLabel taskNumLabel;
	JLabel breakSizeLabel;
	JLabel longBreakSizeLabel;
	
	JTextField taskNameField;
	JTextField taskSizeField;
	JTextField taskNumField;
	JTextField breakSizeField;
	JTextField longBreakSizeField;
	
	public AddPanel(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		init();
	}

	private void init() {
		this.setSize(800, 440);
		this.setOpaque(false);// 设置透明
		this.setLayout(null);
		configComponents();
		installComponents();
		installListeners();
		
	}
	private void configComponents() {
		configButtons();
		configLabels();
		configTextFields();
		
		
	}
	/**
	 * 配置文本标签
	 */
	private void configLabels() {
		 taskNameLabel = new JLabel("任务名称:");
		 taskNameLabel.setBounds(230+15, 70, 120, 30);
		 taskNameLabel.setFont(new Font("华文琥珀", Font.PLAIN, 25));
		 taskNameLabel.setBorder(null);
		 taskNameLabel.setForeground(new Color(102,93,76));
		 taskNameLabel.setHorizontalAlignment(JLabel.RIGHT);
		 
		 taskSizeLabel= new JLabel("任务时长:");
		 taskSizeLabel.setBounds(230+15, 110, 120, 30);
		 taskSizeLabel.setFont(new Font("华文琥珀", Font.PLAIN, 25));
		 taskSizeLabel.setBorder(null);
		 taskSizeLabel.setForeground(new Color(102,93,76));
		 taskSizeLabel.setHorizontalAlignment(JLabel.RIGHT);
		 
		 taskNumLabel= new JLabel("任务个数:");
		 taskNumLabel.setBounds(230+15, 150, 120, 30);
		 taskNumLabel.setFont(new Font("华文琥珀", Font.PLAIN, 25));
		 taskNumLabel.setBorder(null);
		 taskNumLabel.setForeground(new Color(102,93,76));
		 taskNumLabel.setHorizontalAlignment(JLabel.RIGHT);
		 
		 breakSizeLabel= new JLabel("休息时长:");
		 breakSizeLabel.setBounds(230+15, 190, 120, 30);
		 breakSizeLabel.setFont(new Font("华文琥珀", Font.PLAIN, 25));
		 breakSizeLabel.setBorder(null);
		 breakSizeLabel.setForeground(new Color(102,93,76));
		 breakSizeLabel.setHorizontalAlignment(JLabel.RIGHT);
		 
		 longBreakSizeLabel= new JLabel("长休时间:");
		 longBreakSizeLabel.setBounds(230+15, 230, 120, 30);
		 longBreakSizeLabel.setFont(new Font("华文琥珀", Font.PLAIN, 25));
		 longBreakSizeLabel.setBorder(null);
		 longBreakSizeLabel.setForeground(new Color(102,93,76));
		 longBreakSizeLabel.setHorizontalAlignment(JLabel.RIGHT);
	}
	/**
	 * 配置文本域
	 */
	private void configTextFields() {
		 taskNameField = new JTextField("任务1");
		 taskNameField.setBounds(230+120+17, 70, 180, 30);
		 taskNameField.setFont(new Font("华文琥珀", Font.PLAIN, 25));
		 taskNameField.setBorder(new AnimationLineBorder());
		 taskNameField.setOpaque(false);
		 taskNameField.setForeground(Color.WHITE);
		 taskNameField.setHorizontalAlignment(JLabel.LEFT);
		 
		 taskSizeField= new JTextField("25");
		 taskSizeField.setBounds(230+120+17, 110, 180, 30);
		 taskSizeField.setFont(new Font("华文琥珀", Font.PLAIN, 25));
		 taskSizeField.setBorder(new AnimationLineBorder());
		 taskSizeField.setOpaque(false);
		 taskSizeField.setForeground(Color.WHITE);
		 taskSizeField.setHorizontalAlignment(JLabel.LEFT);
		 
		 taskNumField= new JTextField("1");
		 taskNumField.setBounds(230+120+17, 150, 180, 30);
		 taskNumField.setFont(new Font("华文琥珀", Font.PLAIN, 25));
		 taskNumField.setBorder(new AnimationLineBorder());
		 taskNumField.setOpaque(false);
		 taskNumField.setForeground(Color.WHITE);
		 taskNumField.setHorizontalAlignment(JLabel.LEFT);
		 
		 breakSizeField= new JTextField("5");
		 breakSizeField.setBounds(230+120+17, 190, 180, 30);
		 breakSizeField.setFont(new Font("华文琥珀", Font.PLAIN, 25));
		 breakSizeField.setBorder(new AnimationLineBorder());
		 breakSizeField.setOpaque(false);
		 breakSizeField.setForeground(Color.WHITE);
		 breakSizeField.setHorizontalAlignment(JLabel.LEFT);
		 
		 longBreakSizeField= new JTextField("15");
		 longBreakSizeField.setBounds(230+120+17, 230, 180, 30);
		 longBreakSizeField.setFont(new Font("华文琥珀", Font.PLAIN, 25));
		 longBreakSizeField.setBorder(new AnimationLineBorder());
		 longBreakSizeField.setOpaque(false);
		 longBreakSizeField.setForeground(Color.WHITE);
		 longBreakSizeField.setHorizontalAlignment(JLabel.LEFT);
	}
	/**
	 * 配置按钮
	 */
	private void configButtons() {
		close.setBounds(575, 30, 30, 30);
		close.setBorder(null);
		close.setContentAreaFilled(false);
		close.setIcon(new ImageIcon("resources/images/红叉红.png"));
		close.setRolloverIcon(new ImageIcon("resources/images/红叉黑.png"));//移上的效果
		
		cancel.setBounds(310, 320, 80, 30);
		cancel.setBorder(null);
		cancel.setContentAreaFilled(false);
		cancel.setIcon(new ImageIcon("resources/images/关闭.png"));
		cancel.setRolloverIcon(new ImageIcon("resources/images/关闭2.png"));//移上的效果
		cancel.setRequestFocusEnabled(false);
		
		confirm.setBounds(450, 320, 80, 30);
		confirm.setBorder(null);
		confirm.setContentAreaFilled(false);
		confirm.setRequestFocusEnabled(false);
		confirm.setIcon(new ImageIcon("resources/images/确定3.png"));
		confirm.setRolloverIcon(new ImageIcon("resources/images/确定2.png"));//移上的效果

		
	}
	/**
	 * 组装组件
	 */
	private void installComponents() {
		add(close, 0);
		add(confirm, 0);
		add(taskNameLabel,0);
		add(taskSizeLabel,0);
		add(taskNumLabel,0);
		add(breakSizeLabel,0);
		add(longBreakSizeLabel,0);
		
		add(taskNameField,0);
		add(taskSizeField,0);
		add(taskNumField,0);
		add(breakSizeField,0);
		add(longBreakSizeField,0);
	
	}
	/**
	 * 组装监听器
	 */
	private void installListeners() {
		
		
		
		close.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				mainFrame.repaint();
			}
			
		});
		cancel.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				mainFrame.repaint();
			}
			
		});
		confirm.addActionListener(new AddButtonHandler());
		
		
	}
	
	private class AddButtonHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			TodoTask addTask = new TodoTask();
			TodoTaskService  todoTaskService = new TodoTaskServiceImpl();
			addTask.setTaskName(taskNameField.getText());
			addTask.setTaskSize(Integer.parseInt(taskSizeField.getText()));
			addTask.setTaskNum(Integer.parseInt(taskNumField.getText()));
			addTask.setBreakSize(Integer.parseInt(breakSizeField.getText()));
			addTask.setLongBreakSize(Integer.parseInt(longBreakSizeField.getText()));
			boolean success = todoTaskService.add(addTask);
			if (success) {
				new JOptionPane().showMessageDialog(AddPanel.this, "添加成功！");
				mainFrame.getInstance().getTaskPanel().addTask(addTask.getTaskName(),addTask.getId());
				setVisible(false);
				AddPanel.this.dispose();
				mainFrame.repaint();
				
			}
		}
		
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		ImageIcon icon = new ImageIcon("resources/images/login_bg.png");
		g.drawImage(icon.getImage(), 240, 30, 360, 330, null);
		//每次绘制背景后都绘制子件
		this.paintChildren(g);
	}
	/**
	 * 主界面移除该面板
	 */
	public void dispose() {
		MainFrame.getInstance().remove(this);
		System.out.println(this);
		
	}

	
	
	
}
