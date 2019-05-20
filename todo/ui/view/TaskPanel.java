package com.xuetang9.todo.ui.view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import com.xuetang9.todo.model.TodoTask;
import com.xuetang9.todo.service.TodoTaskService;
import com.xuetang9.todo.service.impl.TodoTaskServiceImpl;

/**
 * 
 * @function
 * @author 吴桐
 * @date 2019年5月17日上午11:20:49
 * @place 公司
 * @version 1.0.0
 * @copyright 吴桐
 */
public class TaskPanel extends JPanel {
	/**
	 * 任务标签
	 */
//	private TaskLabel taskLabel;
	/**
	 * 任务标签总数量
	 */
	private int taskCount;
	/**
	 * 鼠标按下的坐标
	 */
	private Point pressPoint;
	/**
	 * 内容面板
	 */
	private JPanel contentPane;
	/**
	 * 偏移调整量
	 */
	private int adjustY = 10;
	private static TaskPanel single;
	public TaskPanel(int width, int height) {
		single = this;
		taskCount = 0;
		this.init(width, height);
		contentPane.setPreferredSize(new Dimension(width, height * 2));

	}

	private void init(int width, int height) {
//		this.setPreferredSize(new Dimension(width, height));
		this.setBounds(100, 50, width, height);
		/* ？？？？？？？？？？？？？？设置流布局里面内容还能拖动吗？？？？？？？？？？？ */
//		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.setLayout(null);
		// 任务设置面板透明
		this.setOpaque(false);
		//载入数据
		contentPane = new JPanel();
		contentPane.setBounds(0, adjustY, width, height* 2);
		contentPane.setLayout(new FlowLayout(FlowLayout.LEFT,20,10));
		// 内容面板设置透明
		contentPane.setOpaque(false);
		contentPane.addMouseListener(new contentMotionAdapter());
		contentPane.addMouseMotionListener(new contentMotionAdapter());
		add(contentPane,0);
	
		this.loadTask();
	}
	public void addTask(String taskName,String id) {
		TaskLabel taskLabel = new TaskLabel(taskName,id);
		contentPane.add(taskLabel,-1);
		contentPane.doLayout();
		taskCount++;
	}
	
	private void loadTask() {
		
		TodoTaskService todoTaskService = new TodoTaskServiceImpl();
		List<TodoTask> todoTasks = todoTaskService.find();
		todoTasks.size();
		for (TodoTask todoTask : todoTasks) {
			addTask(todoTask.getTaskName(),todoTask.getId());
		}
//		for (int i = 0; i < taskCount; i++) {
//			
//		}
		
		
	}

	/**
	 * 
	 * @function 面板拖动监听
	 * @author 吴桐
	 * @date 2019年5月17日上午11:52:36
	 * @place 公司
	 * @version 1.0.0
	 * @copyright 吴桐
	 */
	private class contentMotionAdapter extends MouseAdapter {

		@Override
		public void mousePressed(MouseEvent e) {
			pressPoint = e.getPoint();
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			Point movingPoint = e.getPoint();
			moveContentPane(movingPoint);
		}

	}

	private void moveContentPane(Point movingPoint) {
		// Y轴移动距离
		int distenceY;
		// 移动后Y源坐标
		int movedY;
		// 边界修正后Y坐标
		int endY;
		Point contentPaneStartPoint = contentPane.getLocation();
		distenceY =  movingPoint.y-pressPoint.y;
		// 边界判断
		movedY = contentPaneStartPoint.y + distenceY;
		if (movedY < 0 && movedY > getHeight() - contentPane.getHeight()) {
			endY = movedY;
		} else {
			endY = getHeight() - contentPane.getHeight();
		}
		if (movedY > 0) {
			endY = adjustY;
		}
		contentPane.setLocation(contentPaneStartPoint.x, endY);
	}
	

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		String  iconPath = "resources/images/login_bg2.png";
		ImageIcon icon = new ImageIcon(iconPath);
		g.drawImage(icon.getImage(), 0, 0,600 , 330, 0, 43,2071 , 1400, null);
		
		
	}
	
	public JPanel getContentPane() {
		return contentPane;
	}

	public static TaskPanel getInstance() {
		return single;
	}
	
}
