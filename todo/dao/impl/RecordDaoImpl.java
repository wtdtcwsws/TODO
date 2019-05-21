package com.xuetang9.todo.dao.impl;

import com.xuetang9.todo.dao.AbstractBaseDao;
import com.xuetang9.todo.dao.RecordDao;
import com.xuetang9.todo.model.TodoTask;
/**
 * 
 * @function 番茄任务记录Dao实现类
 * @author 吴桐
 * @date 2019年5月21日下午7:38:54
 * @place 公司
 * @version 1.0.0
 * @copyright 吴桐
 */
public class RecordDaoImpl extends AbstractBaseDao<TodoTask> implements RecordDao{
	
	@Override
	public String getPath() {
		return "src/com/xuetang9/todo/data/record.data";
	}

}
