package com.xuetang9.todo.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Date;

/**
 * 
 * @function 任务数据类
 * @author 吴桐
 * @date 2019年5月13日下午4:37:42
 * @place 公司
 * @version 1.0.0
 * @copyright 吴桐
 */
public class TodoTask implements Serializable {
	/**
	 * 番茄钟名称
	 */
	private String taskName;
	/**
	 * 番茄钟大小，默认25分钟
	 */
	private int taskSize = 25;
	/**
	 * 番茄钟个数，默认1个
	 */
	private int taskNum = 1;
	/**
	 * 休息时间 默认5分钟
	 */
	private int breakSize = 5;
	/**
	 * 长休息时间 默认15分钟
	 */
	private int longBreakSize = 15;
	/**
	 * 番茄钟任务编号,使用MD5加密，根据毫秒数生成唯一ID
	 */
	private String id;
	/**
	 * 番茄钟创建时间
	 */
	private Date date;
	/**
	 * 	番茄钟时间id
	 */
	private Long dateId;
	/**
	 * 心得体会
	 */
	private String Feeling;
	/**
	 * 打断原因
	 */
	private String Interrupt;
	/**
	 * 无参构造
	 */
	public TodoTask() {
		date = new Date();
		dateId =  System.currentTimeMillis();
		try {
			id = getMD5Str(dateId.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	

	@Override
	public String toString() {
		return "TodoTask [taskName=" + taskName + ", taskSize=" + taskSize + ", taskNum=" + taskNum + ", breakSize="
				+ breakSize + ", longBreakSize=" + longBreakSize + ", id=" + id + ", date=" + date + ", dateId="
				+ dateId + ", Feeling=" + Feeling + ", Interrupt=" + Interrupt + "]";
	}



	public static void main(String[] args) {

		System.out.println(new TodoTask());
	
		System.out.println(new TodoTask());
	}
	
	
	
	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public int getTaskSize() {
		return taskSize;
	}

	public void setTaskSize(int taskSize) {
		this.taskSize = taskSize;
	}

	public int getTaskNum() {
		return taskNum;
	}

	public void setTaskNum(int taskNum) {
		this.taskNum = taskNum;
	}

	public int getBreakSize() {
		return breakSize;
	}

	public void setBreakSize(int breakSize) {
		this.breakSize = breakSize;
	}

	public int getLongBreakSize() {
		return longBreakSize;
	}

	public void setLongBreakSize(int longBreakSize) {
		this.longBreakSize = longBreakSize;
	}

	public String getFeeling() {
		return Feeling;
	}

	public void setFeeling(String feeling) {
		Feeling = feeling;
	}

	public String getInterrupt() {
		return Interrupt;
	}

	public void setInterrupt(String interrupt) {
		Interrupt = interrupt;
	}

	public String getId() {
		return id;
	}

	public Date getDate() {
		return date;
	}

	/**
	 * 对字符串md5加密
	 *
	 * @param str
	 * @return
	 * @throws Exception
	 */
	private String getMD5Str(String str) throws Exception {
		try {
			// 生成一个MD5加密计算摘要
			MessageDigest md = MessageDigest.getInstance("MD5");
			// 计算md5函数
			md.update(str.getBytes());
			// digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
			// BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
			return new BigInteger(1, md.digest()).toString(16);
		} catch (Exception e) {
			throw new Exception("MD5加密出现错误，" + e.toString());
		}
	}

}
