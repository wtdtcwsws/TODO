package com.xuetang9.todo.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

/**
 * 
 * @function dao层抽象类
 * @author 吴桐
 * @date 2019年5月15日下午2:16:13
 * @place 公司
 * @version 1.0.0
 * @copyright 吴桐
 */
public abstract class AbstractBaseDao<T> implements BaseDao<T> {

	@Override
	public boolean save(List<T> list) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(getPath()))){
			oos.writeObject(list);
			return true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public List<T> load() {
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(getPath()))) {
			
			return (List<T>)ois.readObject();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		
		
	}

}
