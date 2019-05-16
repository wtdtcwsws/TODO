package com.xuetang9.todo.common;
/**
 * 
 * @function 定义窗体面板层级常量
 * @author 吴桐
 * @date 2019年5月16日下午3:18:57
 * @place 公司
 * @version 1.0.0
 * @copyright 吴桐
 */
public interface LayerZIndex {
	/**背景层*/
	Integer LAYER_BACKGROUND = Integer.valueOf(0);
	/**内容层*/
	Integer LAYER_CONTENT = Integer.valueOf(10);
	/**菜单（HUD）层*/
	Integer LAYER_MENU = Integer.valueOf(20);
	/**弹框层*/
	Integer LAYER_MODAL = Integer.valueOf(30);
	/**高于弹框层*/
	Integer LAYER_POPUP = Integer.valueOf(40);
}
