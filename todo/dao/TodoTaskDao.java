package com.xuetang9.todo.dao;

import com.xuetang9.todo.model.TodoTask;

/**
 * 
 * @function 番茄钟任务数据层接口
 * @author 吴桐
 * @date 2019年5月13日下午4:53:25
 * @place 公司
 * @version 1.0.0
 * @copyright 吴桐
 */
public interface TodoTaskDao extends BaseDao<TodoTask> {
	
	String getPath();
}
