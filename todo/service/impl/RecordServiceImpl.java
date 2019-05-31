package com.xuetang9.todo.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.xuetang9.todo.dao.RecordDao;
import com.xuetang9.todo.dao.impl.RecordDaoImpl;
import com.xuetang9.todo.model.TodoTask;
import com.xuetang9.todo.service.RecordService;
/**
 * 
 * @function 番茄业务实现类
 * @author 吴桐
 * @date 2019年5月21日下午7:43:05
 * @place 公司
 * @version 1.0.0
 * @copyright 吴桐
 */
public class RecordServiceImpl implements RecordService {
	RecordDao recordDao = new RecordDaoImpl();
	List<TodoTask> records;

	@Override
	public boolean add(TodoTask object) {
		records = find();
		records.add(object);
		recordDao.save(records);
		return true;
	}

	@Override
	public boolean delete(Object date) {
		records = find();
		
		int delIndex = -1;
		for (TodoTask todoTask : records) {
			if (todoTask.getDate().equals(date)) {
				delIndex = records.indexOf(todoTask);
				break;
			}
		}
		if (delIndex != -1) {
			records.remove(delIndex);
			return recordDao.save(records);
		}
		return false;
	}

	@Override
	public boolean update(TodoTask object) {
		records = find();
		int updateIndex = -1;
		for (TodoTask todoTask : records) {
			if (todoTask.getId().equals(object.getId())) {
				updateIndex = records.indexOf(todoTask);
				break;
			}
		}
		if (updateIndex != -1) {
			records.set(updateIndex,object);
			return recordDao.save(records);
		}
		return false;
		
	}

	@Override
	public TodoTask find(String id) {
		records = find();
		TodoTask findTodotask;
		for (TodoTask todoTask : records) {
			if (todoTask.getId().equals(id)) {
				findTodotask = todoTask;
				return findTodotask;
			}
		}
		return null;
	}

	@Override
	public List<TodoTask> find() {
		records = recordDao.load();
		if (records != null) {
			return records;
		} else {
			return new ArrayList<TodoTask>();
		}

	}

	@Override
	public boolean delete(String id) {
		records = find();
		int delIndex = -1;
		for (TodoTask todoTask : records) {
			if (todoTask.getId().equals(id)) {
				delIndex = records.indexOf(todoTask);
				break;
			}
		}
		if (delIndex != -1) {
			records.remove(delIndex);
			return recordDao.save(records);
		}
		return false;
	}


}
