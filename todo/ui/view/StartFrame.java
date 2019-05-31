package com.xuetang9.todo.ui.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.xuetang9.todo.common.LayerZIndex;
import com.xuetang9.todo.common.Music;
import com.xuetang9.todo.model.TodoTask;
import com.xuetang9.todo.service.RecordService;
import com.xuetang9.todo.service.TodoTaskService;
import com.xuetang9.todo.service.impl.RecordServiceImpl;
import com.xuetang9.todo.service.impl.TodoTaskServiceImpl;
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
public class StartFrame extends MyFrame implements ActionListener, Runnable {
	/**
	 * 一分钟秒数
	 */
	final static int MINUTELENGTH = 60;
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
	 * 开始的任务标签
	 */
	private TaskLabel startLabel;
	/**
	 * 开始的任务状态
	 */
	private JLabel statusLabel;
	/**
	 * 任务时间
	 */
	private int taskSize;
	/**
	 * 倒计时标签
	 */
	private JLabel countDownLabel;
	/**
	 * 开始按钮
	 */
	private JButton startButton;
	/**
	 * 暂停按钮
	 */
	private JButton stopButton;
	/**
	 * 运行标识
	 */
	private boolean isRunning = false;
	/**
	 * 创建任务开始进程
	 */
	Thread t1 = new Thread(this);
	/**
	 * 创建任务音效路径
	 */
	private String dingPath = "resources/sounds/ding.wav";
	private String breakPath = "resources/sounds/break.wav";
	private String completePath = "resources/sounds/complete.wav";
	/**
	 * 创建任务bgm路径
	 */
	private String bgm = "resources/sounds/Rain.wav";
	/**
	 * 创建bgm音乐对象
	 */
	Music bgmMusic = new Music(bgm);
	/**
	 * 
	 */
	private TodoTask recordTask = new TodoTask();

	public StartFrame(TaskLabel startLabel) {
		this.startLabel = startLabel;
		this.setSize(400, 300);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setDefaultCloseOperation(0);
		// 窗口置顶
//		this.setAlwaysOnTop(true);
		init();
		t1.start();
	}

	@Override
	public void init() {
		configComponents();

		installComponents();

		installListeners();

	}
	/**
	 * 配置组件
	 */
	private void configComponents() {
		configButtons();
		configPanel();
		configLabel();

	}
	/**
	 * 配置标签
	 */
	private void configLabel() {
		countDownLabel = new JLabel();
		countDownLabel.setBounds(120, 80, 200, 80);
		countDownLabel.setFont(new Font("华文琥珀", Font.PLAIN, 35));
		countDownLabel.setForeground(new Color(140, 50, 70));
		countDownLabel.setText("开始任务");

		statusLabel = new JLabel();
		statusLabel.setBounds(90, 180, 240, 20);
		statusLabel.setFont(new Font("华文琥珀", Font.PLAIN, 20));
		statusLabel.setForeground(new Color(0, 100, 200));

	}
	/**
	 * 配置按钮
	 */
	private void configButtons() {
		closeButton = new JButton();
		closeButton.setBounds(370, 15, 20, 20);
		closeButton.setBorder(null);
		closeButton.setContentAreaFilled(false);
		closeButton.setIcon(new ImageIcon("resources/images/红叉红.png"));
		closeButton.setRolloverIcon(new ImageIcon("resources/images/红叉蓝.png"));

		minimizeButton = new JButton();
		minimizeButton.setBounds(345, 20, 20, 20);
		minimizeButton.setBorder(null);
		minimizeButton.setContentAreaFilled(false);
		minimizeButton.setIcon(new ImageIcon("resources/images/最小化.png"));
		minimizeButton.setRolloverIcon(new ImageIcon("resources/images/最小化2.png"));

		startButton = new JButton("开始");
		startButton.setBounds(85, 225, 80, 30);
		stopButton = new JButton("暂停");
		stopButton.setBounds(240, 225, 80, 30);
	}
	/**
	 * 配置面板
	 */
	private void configPanel() {

		myPanel = new MyPanel();
	}
	/**
	 * 安装组件
	 */
	private void installComponents() {
		this.getLayeredPane().add(myPanel, LayerZIndex.LAYER_BACKGROUND);

		this.getLayeredPane().add(minimizeButton, LayerZIndex.LAYER_CONTENT);
		this.getLayeredPane().add(closeButton, LayerZIndex.LAYER_CONTENT);
		this.getLayeredPane().add(countDownLabel, LayerZIndex.LAYER_CONTENT);
		this.getLayeredPane().add(statusLabel, LayerZIndex.LAYER_CONTENT);

		this.getLayeredPane().add(startButton, LayerZIndex.LAYER_CONTENT);
		this.getLayeredPane().add(stopButton, LayerZIndex.LAYER_CONTENT);

	}
	/**
	 * 安装监听
	 */
	private void installListeners() {
		closeButton.addMouseListener(new StartCloseButtonHandler(this));
		minimizeButton.addMouseListener(new StartMinimizeButtonHandler(this));
		closeButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 不安全，待优化
				t1.stop();
				bgmMusic.Pause();

			}
		});
		this.addWindowListener(new WindowAdapter() {


			@Override
			public void windowClosed(WindowEvent e) {
				// 任务开始界面关闭后显示主界面
				MainFrame.getInstance().setVisible(true);
			}

		});
		startButton.addActionListener(this);
		stopButton.addActionListener(this);
	}
	/**
	 * 线程运行
	 */
	@Override
	public void run() {

		// 从本地文件得到任务数据
		TodoTaskService todoTaskService = new TodoTaskServiceImpl();
		TodoTask startTask = todoTaskService.find(startLabel.getId());
		taskSize = startTask.getTaskSize();
		int taskNum = startTask.getTaskNum();
		int breakSize = startTask.getBreakSize();
		int longBreakSize = startTask.getLongBreakSize();
		// 任务记录接收数据
		recordTask.setTaskName(startTask.getTaskName());
		recordTask.setTaskSize(longBreakSize);
		recordTask.setTaskNum(taskNum);
		recordTask.setBreakSize(breakSize);
		// 休息的秒数
		int breakSecond = breakSize * MINUTELENGTH;
		// 长休的秒数
		int longBreakSecond = longBreakSize * MINUTELENGTH;
		// 任务秒数
		int taskSecond = taskSize * MINUTELENGTH;
		// 记录当前轮次
		int rounds = 1;

		while (taskNum > 0) {
			String status = String.format("正在进行第%s轮，还剩%s轮%n", rounds, taskNum - 1);
			statusLabel.setText(status);
			// 计时中
			while (taskSecond >= 0 && taskNum > 0) {
				try {
					if (!isRunning) {
						synchronized (this) {
							this.wait();
						}
					}
					// 任务开始，播放背景音
					bgmMusic.Start(bgm);

					int mint = taskSecond / 60;
					int sec = taskSecond % 60;

					String timeformat = String.format("计时中%s:%s", mint, sec);

					countDownLabel.setText(timeformat);
					countDownLabel.setForeground(new Color(230,170,0));
					// 每一秒刷新
					Thread.sleep(1000);
					taskSecond--;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			// 单任务完成音效
			try {
				Music ding = new Music(dingPath);
				// bgm暂停
				bgmMusic.Pause();
				ding.Start(dingPath);
				// 暂停2秒
				Thread.sleep(2000);
				ding.Pause();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			breakSecond = breakSize * MINUTELENGTH;
			longBreakSecond = longBreakSize * MINUTELENGTH;
			// 休息中，包括长休时间
			while (breakSecond >= 0 && taskNum > 0 && longBreakSecond >= 0) {
				switch (rounds % 3) {
				case 0:
					try {
						if (!isRunning) {
							synchronized (this) {
								this.wait();
							}
						}
						int mint = longBreakSecond / 60;
						int sec = longBreakSecond % 60;

						String timeformat = String.format("休息中%s:%s", mint, sec);
						countDownLabel.setForeground(new Color(230,230,50));
						countDownLabel.setText(timeformat);
						Thread.sleep(1000);
						longBreakSecond--;
						if (longBreakSecond == 0) {
							continue;
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					break;

				default:
					try {
						if (!isRunning) {
							synchronized (this) {
								this.wait();
							}
						}
						int mint = breakSecond / 60;
						int sec = breakSecond % 60;

						String timeformat = String.format("休息中%s:%s", mint, sec);
						countDownLabel.setText(timeformat);
						Thread.sleep(1000);
						breakSecond--;
						if (breakSecond == 0) {
							continue;
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					break;
				}

			}
			// 轮次加1
			rounds++;
			// 重置任务时间
			taskSecond = taskSize * MINUTELENGTH;
			// 任务数减1
			taskNum--;
			// 如果任务数=0更换完成音效
			if (taskNum == 0) {
				breakPath = completePath;
				// TODO 保存到本地
//				completeRecord();
			}
		}
		try {
			Music breakDing = new Music(breakPath);
			breakDing.Start(breakPath);
			Thread.sleep(1000);
			breakDing.Pause();
			if (taskNum == 0) {
				countDownLabel.setText("任务完成！");
				countDownLabel.setForeground(new Color(0,230,50));
				// 取消-2，是-0，否-1，红叉-default
				int choice = new JOptionPane().showOptionDialog(this, "是否书写心得", "任务完成",
						JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
						new ImageIcon("resources/images/心得.png"), null, null);
				switch (choice) {
				case 0:

					RecordFrame recordFrame = new RecordFrame(recordTask);
					while (recordFrame.isShowing()) {
						//TODO big难题
						Thread.sleep(1000);
					}
					completeRecord();

					break;
				case 1:
					break;
				case 2:
					break;

				default:
					break;
				}
			}
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}

	}

	/**
	 * 保存记录
	 */
	public void completeRecord() {
		RecordService recordService = new RecordServiceImpl();
		boolean success = recordService.add(recordTask);
		if (success) {
			new JOptionPane().showMessageDialog(StartFrame.this, "记录成功！");
			StartFrame.this.dispose();

		} else {
			new JOptionPane().showMessageDialog(StartFrame.this, "记录失败！");
		}
	}

	/**
	 * 计时开关
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == startButton) {
			synchronized (this) {
				notify();
				isRunning = true;
			}
		}
		if (e.getSource() == stopButton) {
			synchronized (this) {
				notify();
				isRunning = false;
				bgmMusic.Pause();
			}

		}

	}

	/**
	 * 得到单例
	 * 
	 * @return
	 */
//	public static StartFrame getInstance() {
//		return single;
//	}

	/**
	 * 得到当前bgm路径
	 * 
	 * @return
	 */
	public String getBreakPath() {
		return breakPath;
	}

	/**
	 * 设置当前bgm路径
	 * 
	 * @param breakPath
	 */
	public void setBreakPath(String breakPath) {
		this.breakPath = breakPath;
	}

}
