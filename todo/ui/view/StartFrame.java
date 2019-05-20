package com.xuetang9.todo.ui.view;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import com.xuetang9.todo.common.LayerZIndex;
import com.xuetang9.todo.ui.controller.CloseButtonHandler;
import com.xuetang9.todo.ui.controller.MinimizeButtonHandler;
import com.xuetang9.todo.ui.controller.StartCloseButtonHandler;
import com.xuetang9.todo.ui.controller.StartMinimizeButtonHandler;
/**
 *  
 * @function 任务开始界面
 * @author 吴桐
 * @date 2019年5月19日下午4:23:12
 * @place 公司
 * @version 1.0.0
 * @copyright 吴桐
 */
public class StartFrame extends MyFrame{
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

	public StartFrame() {
		this.setSize(200, 300);
		this.setLocationRelativeTo(null);
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
	private void configButtons() {
		closeButton = new JButton();
		closeButton.setBounds(170, 15, 20, 20);
		closeButton.setBorder(null);
		closeButton.setContentAreaFilled(false);
		closeButton.setIcon(new ImageIcon("resources/images/红叉红.png"));
		closeButton.setRolloverIcon(new ImageIcon("resources/images/红叉蓝.png"));

		minimizeButton = new JButton();
		minimizeButton.setBounds(145, 20, 20, 20);
		minimizeButton.setBorder(null);
		minimizeButton.setContentAreaFilled(false);
		minimizeButton.setIcon(new ImageIcon("resources/images/最小化.png"));
		minimizeButton.setRolloverIcon(new ImageIcon("resources/images/最小化2.png"));
	}


	private void configPanel() {
		
		myPanel = new MyPanel();
	}


	private void installComponents() {
		this.getLayeredPane().add(myPanel, LayerZIndex.LAYER_BACKGROUND);

		this.getLayeredPane().add(minimizeButton, LayerZIndex.LAYER_CONTENT);
		this.getLayeredPane().add(closeButton, LayerZIndex.LAYER_CONTENT);
		
	}
	private void installListeners() {
		closeButton.addMouseListener(new StartCloseButtonHandler(this));
		minimizeButton.addMouseListener(new StartMinimizeButtonHandler(this));
		this.addWindowListener(new WindowAdapter() {


			@Override
			public void windowClosed(WindowEvent e) {
				//任务开始界面关闭后显示主界面
				MainFrame.getInstance().setVisible(true);
			}
			
		});
	}
	
}
