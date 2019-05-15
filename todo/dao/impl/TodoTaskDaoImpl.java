package com.xuetang9.todo.dao.impl;

import com.xuetang9.todo.dao.AbstractBaseDao;
import com.xuetang9.todo.dao.TodoTaskDao;
import com.xuetang9.todo.model.TodoTask;
/**
 * 
 * @function 番茄任务Dao实现类
 * @author 吴桐
 * @date 2019年5月15日下午3:13:10
 * @place 公司
 * @version 1.0.0
 * @copyright 吴桐
 */
public class TodoTaskDaoImpl extends AbstractBaseDao<TodoTask> implements TodoTaskDao {

	@Override
	public String getPath() {
		
		return "src/com/xuetang9/todo/data/todotask.data";
		
	}

}
