package com.xuetang9.todo.dao;

import java.util.List;

/**
 * 
 * @function dao层超类接口
 * @author 吴桐
 * @date 2019年5月13日下午4:34:53
 * @place 公司
 * @version 1.0.0
 * @copyright 吴桐
 */
public interface BaseDao<T> {
	/**
	 * 把数据保存到本地文件
	 * @param list 
	 * @return 保存成功返回true，保存失败返回false
	 */
	boolean save(List<T> list);

	/**
	 * 读取本地文件
	 * 
	 * @return 读取成功返回集合，读取失败返回null
	 */
	List<T> load();

	/**
	 * 返回保存地址
	 * 
	 * @return
	 */
	String getPath();
}
