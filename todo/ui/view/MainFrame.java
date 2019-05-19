package com.xuetang9.todo.ui.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;

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

	private JButton addButton;
	private JScrollPane scrollPane;
	private MyPanel panel ;
	private MyPanel myContentPane;
	private JPanel contentPane;
	private TaskPanel taskPanel;
	private JPanel underTaskPanel;
	public MainFrame() {
		single = this;
		init();
	}

	@Override
	public void init() {

		contentPane = (JPanel) this.getContentPane();

		configComponents();

		installComponents();

		installListeners();
	}

	private void configComponents() {
		configButtons();
		configSrcollPane();
		configPanel();

	}

	private void configPanel() {
//		label.setBounds(10, 10, 100, 50);
		panel = new MyPanel();
		panel.setPreferredSize(new Dimension(600, 380));
		panel.setIconPath("resources/images/scrollpanel1.jpg");
		panel.setW(600);
		panel.setH(380);

		panel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		myPanel = new MyPanel();
		
		/**/
		underTaskPanel=new JPanel();
		underTaskPanel.setBounds(0, 0, 800, 440);
		underTaskPanel.setOpaque(false);
		underTaskPanel.setLayout(null);
		
		
		taskPanel = new TaskPanel(600, 330);
		taskPanel.setLocation(100, 50);
		
		/**/
	}

	private void configSrcollPane() {
		scrollPane = new JScrollPane();
		scrollPane.setBounds(100, 50, 600, 330);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBackground(Color.blue);

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
	}

	private void installComponents() {
		/**
		 * 为保证层级管理，安装顺序也要注意
		 */
		this.getLayeredPane().add(myPanel, LayerZIndex.LAYER_BACKGROUND);

		this.getLayeredPane().add(minimizeButton, LayerZIndex.LAYER_CONTENT);
		this.getLayeredPane().add(closeButton,LayerZIndex.LAYER_CONTENT);
		this.getLayeredPane().add(addButton, LayerZIndex.LAYER_CONTENT);
//		this.getLayeredPane().add(scrollPane,LayerZIndex.LAYER_CONTENT);
		this.getLayeredPane().add(underTaskPanel,LayerZIndex.LAYER_CONTENT);
//		this.getLayeredPane().add(taskPanel,LayerZIndex.LAYER_MENU);
		underTaskPanel.add(taskPanel,0);
		scrollPane.setViewportView(panel);

	}

	private void installListeners() {
		addButton.addMouseListener(new AddButtonHandler(this));
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
