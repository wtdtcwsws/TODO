package com.xuetang9.todo.ui.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import com.xuetang9.todo.ui.controller.AddButtonHandler;


/**
 * 
 * @function 程序主界面
 * @author 吴桐
 * @date 2019年5月13日下午4:33:34
 * @place 公司
 * @version 1.0.0
 * @copyright 吴桐
 */
public class MainFrame extends MyFrame{
	private static MainFrame single;
	private JButton addButton = new JButton();
	private JScrollPane scrollPane = new JScrollPane();
	private MyPanel panel = new MyPanel();
	private MyPanel myContentPane;
	private JPanel contentPane;
	public MainFrame() {
		single = this;
		init();
	}
	
	private void init() {
		myContentPane = this.getContent();
		
		contentPane = (JPanel)this.getContentPane();
		
		configComponents();
	
		installComponentsNew();
		
		installListeners();
		
	}
	
	private void configComponents() {
		configButtons();
		configSrcollPane();
		configPanel();
		
	}

	private void configPanel() {
//		label.setBounds(10, 10, 100, 50);
		panel.setPreferredSize(new Dimension(600,380));
		panel.setIconPath("src/com/xuetang9/todo/resources/images/scrollpanel1.jpg");
		panel.setW(600);
		panel.setH(380);
		
		
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
	}

	private void configSrcollPane() {
		scrollPane.setBounds(100, 50, 600, 380);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBackground(Color.blue);
		
		
	}
	private void configButtons() {
		addButton.setBounds(700, 70, 30, 30);
		addButton.setBorder(null);
		addButton.setContentAreaFilled(false);
		addButton.setBackground(new Color(0, 0, 0, 0));
		addButton.setIcon(new ImageIcon("src/com/xuetang9/todo/resources/images/添加.png"));
		
	}
	private void installComponentsNew() {
		contentPane.add(addButton);
		contentPane.add(scrollPane);
		installComponents();
		scrollPane.setViewportView(panel);
		
		
		
	}
	/**
	 * 为保证层级管理，安装顺序也要注意
	 */
	@Override
	public void installComponents() {

		super.installComponents();
	}

	private void installListeners() {
		addButton.addMouseListener(new AddButtonHandler(this));
	}
	
	
	
	
	
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		ImageIcon iconImg = new ImageIcon("src/com/xuetang9/todo/resources/images/番茄.png");
		
		g.setFont(new Font("华文彩云", Font.BOLD, 30));
		g.setColor(new Color(255,255,255));
		g.drawString("TODO", 45, 35);
		g.drawImage(iconImg.getImage(), 10, 10, 40, 40, 0, 0, 30, 30, null);
	}
	public static MainFrame getInstance() {
		return single;
	}
}
