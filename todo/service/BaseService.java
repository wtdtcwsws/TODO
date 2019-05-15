package com.xuetang9.todo.service;

import java.util.List;



/**
 * 
 * @function 业务层超类接口
 * @author 吴桐
 * @date 2019年5月13日下午4:39:41
 * @place 公司
 * @version 1.0.0
 * @copyright 吴桐
 */
public interface BaseService<T> {
	/**
	 * 	添加
	 * @param object
	 * @return 
	 */
	boolean add(T object);
	/**
	 * 	删除
	 * @param id
	 * @return
	 */
	boolean delete(String id);
	/**
	 * 	更新（修改）
	 * @param object
	 * @return
	 */
	boolean update(T object);
	/**
	 * 	按Id查找
	 * @param id
	 * @return
	 */
	T find(String id);
	/**
	 * 读取本地文件
	 * @return 返回集合
	 */
	List<T> find();

}
