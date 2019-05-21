package com.xuetang9.todo.ui.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.xuetang9.todo.common.AnimationLineBorder;
import com.xuetang9.todo.common.LayerZIndex;
import com.xuetang9.todo.model.TodoTask;
import com.xuetang9.todo.service.TodoTaskService;
import com.xuetang9.todo.service.impl.TodoTaskServiceImpl;

/**
 * 
 * @function 任务修改界面
 * @author 吴桐
 * @date 2019年5月19日下午10:53:16
 * @place 公司
 * @version 1.0.0
 * @copyright 吴桐
 */
public class ChangeTaskFrame extends JFrame {
	private TodoTaskService todoTaskService = new TodoTaskServiceImpl();
	/**
	 * 传入任务标签
	 */
	private TaskLabel taskLabel;
	private JLabel taskNameLabel;
	private JLabel taskSizeLabel;
	private JLabel taskNumLabel;
	private JLabel breakSizeLabel;
	private JLabel longBreakSizeLabel;
	private JLabel selectMusicLabel;

	private JTextField taskNameField;
	private JTextField taskSizeField;
	private JTextField taskNumField;
	private JTextField breakSizeField;
	private JTextField longBreakSizeField;

	private String[] musics = { "雨声", "小溪1", "小溪2", "钢琴1", "钢琴2", "钢琴3", "高亢1", "高亢2" };
	private JComboBox<String> comBox;
	/**
	 * 确定按钮
	 */
	private JButton confirm;

	public ChangeTaskFrame(TaskLabel taskLabel) {

		this.taskLabel = taskLabel;
		init();
		this.setVisible(true);
	}

	private void init() {
		this.setSize(360, 330);
		this.setLocationRelativeTo(MainFrame.getInstance());
		this.setLayout(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(2);
		this.setTitle("修改任务");
//		this.getLayeredPane().setBackground(new Color(1, 89, 79));
		this.getContentPane().setBackground(new Color(64, 179, 236));
		configComponents();
		installComponents();
		installListeners();
	}

	private void configComponents() {
		configLabels();
		configTextFields();
		configButtons();
		configComboBox();
	}

	private void configComboBox() {
		comBox = new JComboBox<String>(musics);
		comBox.setBounds(130, 240, 100, 40);
		comBox.setFont(new Font("华文琥珀", Font.PLAIN, 25));

	}

	private void configButtons() {
		confirm = new JButton();
		confirm.setBounds(230, 240, 80, 30);
		confirm.setBorder(null);
		confirm.setContentAreaFilled(false);
		confirm.setRequestFocusEnabled(false);
		confirm.setIcon(new ImageIcon("resources/images/确定2.png"));
		confirm.setRolloverIcon(new ImageIcon("resources/images/确定3.png"));// 移上的效果
	}

	private void configLabels() {
		taskNameLabel = new JLabel("任务名称:");
		taskNameLabel.setBounds(230 + 15 - 240, 70 - 30, 120, 30);
		taskNameLabel.setFont(new Font("华文琥珀", Font.PLAIN, 25));
		taskNameLabel.setBorder(null);
		taskNameLabel.setForeground(new Color(102+50, 93, 76));
		taskNameLabel.setHorizontalAlignment(JLabel.RIGHT);

		taskSizeLabel = new JLabel("任务时长:");
		taskSizeLabel.setBounds(230 + 15 - 240, 110 - 30, 120, 30);
		taskSizeLabel.setFont(new Font("华文琥珀", Font.PLAIN, 25));
		taskSizeLabel.setBorder(null);
		taskSizeLabel.setForeground(new Color(102, 93+50, 76));
		taskSizeLabel.setHorizontalAlignment(JLabel.RIGHT);

		taskNumLabel = new JLabel("任务个数:");
		taskNumLabel.setBounds(230 + 15 - 240, 150 - 30, 120, 30);
		taskNumLabel.setFont(new Font("华文琥珀", Font.PLAIN, 25));
		taskNumLabel.setBorder(null);
		taskNumLabel.setForeground(new Color(102, 93, 76+50));
		taskNumLabel.setHorizontalAlignment(JLabel.RIGHT);

		breakSizeLabel = new JLabel("休息时长:");
		breakSizeLabel.setBounds(230 + 15 - 240, 190 - 30, 120, 30);
		breakSizeLabel.setFont(new Font("华文琥珀", Font.PLAIN, 25));
		breakSizeLabel.setBorder(null);
		breakSizeLabel.setForeground(new Color(102, 93+50, 76+50));
		breakSizeLabel.setHorizontalAlignment(JLabel.RIGHT);

		longBreakSizeLabel = new JLabel("长休时间:");
		longBreakSizeLabel.setBounds(230 + 15 - 240, 230 - 30, 120, 30);
		longBreakSizeLabel.setFont(new Font("华文琥珀", Font.PLAIN, 25));
		longBreakSizeLabel.setBorder(null);
		longBreakSizeLabel.setForeground(new Color(102+50, 93+50, 76));
		longBreakSizeLabel.setHorizontalAlignment(JLabel.RIGHT);

		selectMusicLabel = new JLabel("背景音乐:");
		selectMusicLabel.setBounds(230 + 15 - 240, 230 - 30 + 40, 120, 30);
		selectMusicLabel.setFont(new Font("华文琥珀", Font.PLAIN, 25));
		selectMusicLabel.setBorder(null);
		selectMusicLabel.setForeground(new Color(102+50, 93, 76+50));
		selectMusicLabel.setHorizontalAlignment(JLabel.RIGHT);

	}

	private void configTextFields() {
		taskNameField = new JTextField("任务1");
		taskNameField.setBounds(230 + 120 + 17 - 240, 70 - 30, 180, 30);
		taskNameField.setFont(new Font("华文琥珀", Font.PLAIN, 25));
		taskNameField.setBorder(new AnimationLineBorder());
		taskNameField.setOpaque(false);
		taskNameField.setForeground(Color.WHITE);
		taskNameField.setHorizontalAlignment(JLabel.LEFT);

		taskSizeField = new JTextField("25");
		taskSizeField.setBounds(230 + 120 + 17 - 240, 110 - 30, 180, 30);
		taskSizeField.setFont(new Font("华文琥珀", Font.PLAIN, 25));
		taskSizeField.setBorder(new AnimationLineBorder());
		taskSizeField.setOpaque(false);
		taskSizeField.setForeground(Color.WHITE);
		taskSizeField.setHorizontalAlignment(JLabel.LEFT);

		taskNumField = new JTextField("1");
		taskNumField.setBounds(230 + 120 + 17 - 240, 150 - 30, 180, 30);
		taskNumField.setFont(new Font("华文琥珀", Font.PLAIN, 25));
		taskNumField.setBorder(new AnimationLineBorder());
		taskNumField.setOpaque(false);
		taskNumField.setForeground(Color.WHITE);
		taskNumField.setHorizontalAlignment(JLabel.LEFT);

		breakSizeField = new JTextField("5");
		breakSizeField.setBounds(230 + 120 + 17 - 240, 190 - 30, 180, 30);
		breakSizeField.setFont(new Font("华文琥珀", Font.PLAIN, 25));
		breakSizeField.setBorder(new AnimationLineBorder());
		breakSizeField.setOpaque(false);
		breakSizeField.setForeground(Color.WHITE);
		breakSizeField.setHorizontalAlignment(JLabel.LEFT);

		longBreakSizeField = new JTextField("15");
		longBreakSizeField.setBounds(230 + 120 + 17 - 240, 230 - 30, 180, 30);
		longBreakSizeField.setFont(new Font("华文琥珀", Font.PLAIN, 25));
		longBreakSizeField.setBorder(new AnimationLineBorder());
		longBreakSizeField.setOpaque(false);
		longBreakSizeField.setForeground(Color.WHITE);
		longBreakSizeField.setHorizontalAlignment(JLabel.LEFT);

	}

	private void installComponents() {
		this.getLayeredPane().add(taskNameLabel, LayerZIndex.LAYER_CONTENT);
		this.getLayeredPane().add(taskSizeLabel, LayerZIndex.LAYER_CONTENT);
		this.getLayeredPane().add(taskNumLabel, LayerZIndex.LAYER_CONTENT);
		this.getLayeredPane().add(breakSizeLabel, LayerZIndex.LAYER_CONTENT);
		this.getLayeredPane().add(longBreakSizeLabel, LayerZIndex.LAYER_CONTENT);
		this.getLayeredPane().add(selectMusicLabel, LayerZIndex.LAYER_CONTENT);

		add(taskNameField, 0);
		add(taskSizeField, 0);
		add(taskNumField, 0);
		add(breakSizeField, 0);
		add(longBreakSizeField, 0);

		this.getLayeredPane().add(confirm, LayerZIndex.LAYER_MENU);
		this.getLayeredPane().add(comBox, LayerZIndex.LAYER_MENU);

	}

	private void installListeners() {
		// 打开修改窗口后
		addWindowListener(new WindowAdapter() {
			TodoTask changeTask = todoTaskService.find(taskLabel.getId());

			@Override
			public void windowOpened(WindowEvent e) {
				taskNameField.setText(changeTask.getTaskName());
				taskSizeField.setText(changeTask.getTaskSize() + "");
				taskNumField.setText(changeTask.getTaskNum() + "");
				breakSizeField.setText(changeTask.getBreakSize() + "");
				longBreakSizeField.setText(changeTask.getLongBreakSize() + "");

			}

		});
		confirm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				TodoTaskService todoTaskService = new TodoTaskServiceImpl();

				TodoTask changeTask = todoTaskService.find(taskLabel.getId());

				changeTask.setTaskName(taskNameField.getText());
				changeTask.setTaskSize(Integer.parseInt(taskSizeField.getText()));
				changeTask.setTaskNum(Integer.parseInt(taskNumField.getText()));
				changeTask.setBreakSize(Integer.parseInt(breakSizeField.getText()));
				changeTask.setLongBreakSize(Integer.parseInt(longBreakSizeField.getText()));
				// 更新修改
				boolean success = todoTaskService.update(changeTask);
				if (success) {
					new JOptionPane().showMessageDialog(ChangeTaskFrame.this, "修改成功！");
					ChangeTaskFrame.this.dispose();
//					TaskPanel.getInstance().loadTask();
					// 任务标签名称更新
					taskLabel.update(changeTask.getTaskName());

				} else {
					new JOptionPane().showMessageDialog(ChangeTaskFrame.this, "修改失败！");
					ChangeTaskFrame.this.dispose();
				}

			}
		});
	}

	@Override
	public void paintComponents(Graphics g) {
//		paintAll(g);
		ImageIcon icon = new ImageIcon("resources/images/scrollpanel0.jpg");
		g.drawImage(icon.getImage(), 0, 0, 360, 330, null);
		super.paintComponents(g);
	}

//	@Override
//	public void paint(Graphics g) {
//		// TODO Auto-generated method stub
//		super.paint(g);
//		ImageIcon icon = new ImageIcon("resources/images/scrollpanel0.jpg");
//		g.drawImage(icon.getImage(), 0, 0, 360, 330, null);
//	}


}
