package com.xuetang9.todo.ui.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import com.xuetang9.todo.common.LayerZIndex;
import com.xuetang9.todo.ui.controller.AddButtonHandler;
import com.xuetang9.todo.ui.controller.CloseButtonHandler;
import com.xuetang9.todo.ui.controller.MinimizeButtonHandler;

/**
 * 
 * @function 程序主界面
 * @author 吴桐
 * @date 2019年5月13日下午4:33:34
 * @place 公司
 * @version 1.0.0
 * @copyright 吴桐
 */
public class MainFrame extends MyFrame {
	/**
	 * 单例
	 */
	private static MainFrame single;
	/**
	 * 背景面板
	 */
	private MyPanel myPanel;
	/**
	 * 右上红叉
	 */
	private JButton closeButton;
	/**
	 * 最小化
	 */
	private JButton minimizeButton;
	/**
	 * 添加按钮
	 */
	private JButton addButton;
	/**
	 * 记录按钮
	 */
	private JButton recordButton;
	/**
	 * 滑动面板
	 */
	private TaskPanel taskPanel;
	/**
	 * 滑动背景面板
	 */
	private JPanel underTaskPanel;

	public MainFrame() {
		single = this;
		init();
	}

	@Override
	public void init() {

		configComponents();

		installComponents();

		installListeners();
	}

	private void configComponents() {
		configButtons();
		configPanel();

	}

	private void configPanel() {
		myPanel = new MyPanel();
		underTaskPanel = new JPanel();
		underTaskPanel.setBounds(0, 0, 800, 440);
		underTaskPanel.setOpaque(false);
		underTaskPanel.setLayout(null);

		taskPanel = new TaskPanel(600, 330);
		taskPanel.setLocation(100, 50);
		

	}

	private void configButtons() {
		closeButton = new JButton();
		closeButton.setBounds(760, 25, 20, 20);
		closeButton.setBorder(null);
		closeButton.setContentAreaFilled(false);
		closeButton.setIcon(new ImageIcon("resources/images/红叉红.png"));
		closeButton.setRolloverIcon(new ImageIcon("resources/images/红叉蓝.png"));

		minimizeButton = new JButton();
		minimizeButton.setBounds(720, 25, 20, 20);
		minimizeButton.setBorder(null);
		minimizeButton.setContentAreaFilled(false);
		minimizeButton.setIcon(new ImageIcon("resources/images/最小化.png"));
		minimizeButton.setRolloverIcon(new ImageIcon("resources/images/最小化2.png"));

		addButton = new JButton();
		addButton.setBounds(700, 345, 40, 40);
		addButton.setBorder(null);
		addButton.setContentAreaFilled(false);
		addButton.setIcon(new ImageIcon("resources/images/添加圆.png"));
		addButton.setRolloverIcon(new ImageIcon("resources/images/添加圆2.png"));
		
		recordButton = new JButton();
		recordButton.setBounds(700, 280, 40, 40);
		recordButton.setBorder(null);
		recordButton.setContentAreaFilled(false);
		recordButton.setIcon(new ImageIcon("resources/images/记录按钮2.png"));
		recordButton.setRolloverIcon(new ImageIcon("resources/images/记录按钮1.png"));
	}

	private void installComponents() {
		/**
		 * 为保证层级管理，安装顺序也要注意
		 */
		/**
		 * 使用layered层级管理，不用再考虑安装顺序
		 */
		this.getLayeredPane().add(myPanel, LayerZIndex.LAYER_BACKGROUND);

		this.getLayeredPane().add(minimizeButton, LayerZIndex.LAYER_CONTENT);
		this.getLayeredPane().add(closeButton, LayerZIndex.LAYER_CONTENT);
		this.getLayeredPane().add(addButton, LayerZIndex.LAYER_CONTENT);
		this.getLayeredPane().add(recordButton, LayerZIndex.LAYER_CONTENT);
		underTaskPanel.add(taskPanel, 0);
		this.getLayeredPane().add(underTaskPanel, LayerZIndex.LAYER_CONTENT);

	}

	private void installListeners() {
		addButton.addMouseListener(new AddButtonHandler(this));
		recordButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new FullRecordFrame();
				
			}
		});
		
		closeButton.addMouseListener(new CloseButtonHandler(this));
		minimizeButton.addMouseListener(new MinimizeButtonHandler(this));
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		ImageIcon iconImg = new ImageIcon("resources/images/番茄.png");

		g.setFont(new Font("华文彩云", Font.BOLD, 30));
		g.setColor(new Color(255, 255, 255));
		g.drawString("TODO", 45, 35);
		g.drawImage(iconImg.getImage(), 10, 10, 40, 40, 0, 0, 30, 30, null);
	
	}

	public static MainFrame getInstance() {
		return single;
	}

	public TaskPanel getTaskPanel() {
		return taskPanel;
	}

}
