package com.xuetang9.todo.dao;

import com.xuetang9.todo.model.TodoTask;

/**
 * 
 * @function 任务记录数据接口
 * @author 吴桐
 * @date 2019年5月21日下午7:35:57
 * @place 公司
 * @version 1.0.0
 * @copyright 吴桐
 */
public interface RecordDao extends BaseDao<TodoTask> {
	String getPath();
}
