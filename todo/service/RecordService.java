package com.xuetang9.todo.service;

import com.xuetang9.todo.model.TodoTask;
/**
 * 
 * @function 任务记录业务接口
 * @author 吴桐
 * @date 2019年5月21日下午7:41:39
 * @place 公司
 * @version 1.0.0
 * @copyright 吴桐
 */
public interface RecordService extends BaseService<TodoTask> {

	boolean delete(Object id);

}
