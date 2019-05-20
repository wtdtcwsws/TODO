package com.xuetang9.todo.common;

import java.io.*;
import java.util.Scanner;

import sun.audio.*; //一般用这个头文件会报错

public class Music {
	AudioStream as = null;
	AudioData ad=null;
	ContinuousAudioDataStream cads = null;
	static Scanner input = new Scanner(System.in);
	
	
	public Music (String path) {
		
		
		try {
			this.music(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void music(String path) throws IOException {
		try {
			java.io.InputStream in = new java.io.FileInputStream(path);
			as = new sun.audio.AudioStream(in);
			ad = as.getData();
		} catch (IOException e) {e.printStackTrace();}
		//设置循环播放
		 cads = new ContinuousAudioDataStream(ad);
		//循环播放开始哦
		AudioPlayer.player.start(cads);
		//循环播放停止
		AudioPlayer.player.stop(cads);

	}

	public void Start() {
		AudioPlayer.player.start(cads);
	}

	public void Pause() {
		AudioPlayer.player.stop(cads);
	}

	public void Continue() {
		AudioPlayer.player.start(cads);
	}

	public static void main(String[] args) {
		String path = "resources/sounds/ding.wav";
		Music ms = new Music(path);
		ms.Start();
		System.out.println("按任意键继续");
		input.nextLine();
		new Music(path).Start();
		new Music(path).Start();
		
	}

}