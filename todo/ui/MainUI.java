package com.xuetang9.todo.ui;

import java.util.List;
import java.util.Scanner;

import com.xuetang9.todo.model.TodoTask;
import com.xuetang9.todo.service.TodoTaskService;
import com.xuetang9.todo.service.impl.TodoTaskServiceImpl;

/**
 * 
 * @function 控制台测试后端
 * @author 吴桐
 * @date 2019年5月15日下午5:13:57
 * @place 公司
 * @version 1.0.0
 * @copyright 吴桐
 */
public class MainUI {
	public static void main(String[] args) {
		TodoTaskService todoTaskService = new TodoTaskServiceImpl();
		List<TodoTask> TodoTasks = todoTaskService.find();
		for (TodoTask todoTask : TodoTasks) {
			System.out.println(todoTask);
		}
		Scanner input = new Scanner(System.in);
		System.out.println("输入id删除");
		String id = input.next();
		boolean success = todoTaskService.delete(id);
		if (success) {
			System.out.println("删除成功");
		}
		
//		TodoTask task = new TodoTask();
//		System.out.println("请输入任务名称：");
//		String taskName = input.next();
//		System.out.println("请输入任务大小：");
//		int taskSize = input.nextInt();
//		System.out.println("请输入任务个数：");
//		int taskNum = input.nextInt();
//		System.out.println("请输入任务休息：");
//		int breakSize = input.nextInt();
//		System.out.println("请输入任务心得：");
//		String feeling = input.next();
//		task.setTaskName(taskName);
//		task.setTaskSize(taskSize);
//		task.setTaskNum(taskNum);
//		task.setBreakSize(breakSize);
//		task.setFeeling(feeling);
//		todoTaskService.add(task);
		
		
	}
	
}
