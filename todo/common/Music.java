package com.xuetang9.todo.common;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import sun.audio.*; 
/**
 * 
 * @function 实现循环、可暂停、可恢复播放音乐功能
 * @author 吴桐
 * @date 2019年5月21日下午2:25:13
 * @place 公司
 * @version 1.0.0
 * @copyright 吴桐
 */
public class Music {
	AudioStream as ;


	/**
	 * @构造方法
	 * @param path 音乐路径
	 */
	public Music(String path) {

		try {
			this.music(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void music(String path) throws IOException {
		// TODO 不能使用try(){}写法，否则会没有声音
		try{
			InputStream in = new FileInputStream(path);
			as = new sun.audio.AudioStream(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void Start(String path) {
		/*
		 * 如果当前已经播放，便不再播放
		 */
		AudioPlayer.player.start(as);
		try {
			if (as.available()>0) {
				
				AudioPlayer.player.start(as);
			}else {
				java.io.InputStream in = new java.io.FileInputStream(path);
				as = new sun.audio.AudioStream(in);
				AudioPlayer.player.start(as);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void Pause() {
		AudioPlayer.player.stop(as);
	}

	public void Continue() {
		AudioPlayer.player.start(as);
	}

//	public static void main(String[] args) {
//		String path = "resources/sounds/kanoon.wav";
////		String path = "resources/sounds/complete.wav";
//		Music ms = new Music(path);
//		ms.Start(path);
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		ms.Pause();
//		System.out.println("暂停");
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		System.out.println("恢复");
//		ms.Start(path);
//		try {
//			Thread.sleep(10000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		System.out.println("第二首");
//		ms.Start(path);
//	}

}