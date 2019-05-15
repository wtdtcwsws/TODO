package com.xuetang9.todo.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.xuetang9.todo.dao.TodoTaskDao;
import com.xuetang9.todo.dao.impl.TodoTaskDaoImpl;
import com.xuetang9.todo.model.TodoTask;
import com.xuetang9.todo.service.TodoTaskService;

/**
 * 
 * @function 番茄钟任务业务实现类
 * @author 吴桐
 * @date 2019年5月15日下午4:28:35
 * @place 公司
 * @version 1.0.0
 * @copyright 吴桐
 */
public class TodoTaskServiceImpl implements TodoTaskService {
	TodoTaskDao todoTaskDao = new TodoTaskDaoImpl();
	List<TodoTask> todoTasks;

	@Override
	public boolean add(TodoTask object) {
		todoTasks = find();
		todoTasks.add(object);
		todoTaskDao.save(todoTasks);
		return true;
	}

	@Override
	public boolean delete(String id) {
		todoTasks = find();
		int delIndex = -1;
		for (TodoTask todoTask : todoTasks) {
			if (todoTask.getId().equals(id)) {
				delIndex = todoTasks.indexOf(todoTask);
				break;
			}
		}
		if (delIndex != -1) {
			todoTasks.remove(delIndex);
			return todoTaskDao.save(todoTasks);
		}
		return false;
	}

	@Override
	public boolean update(TodoTask object) {
		todoTasks = find();
		int updateIndex = -1;
		for (TodoTask todoTask : todoTasks) {
			if (todoTask.getId().equals(object.getId())) {
				updateIndex = todoTasks.indexOf(todoTask);
				break;
			}
		}
		if (updateIndex != -1) {
			todoTasks.set(updateIndex,object);
			return todoTaskDao.save(todoTasks);
		}
		return false;
		
	}

	@Override
	public TodoTask find(String id) {
		todoTasks = find();
		TodoTask findTodotask;
		for (TodoTask todoTask : todoTasks) {
			if (todoTask.getId().equals(id)) {
				findTodotask = todoTask;
				return findTodotask;
			}
		}
		return null;
	}

	@Override
	public List<TodoTask> find() {
		todoTasks = todoTaskDao.load();
		if (todoTasks != null) {
			return todoTasks;
		} else {
			return new ArrayList<TodoTask>();
		}

	}

}
