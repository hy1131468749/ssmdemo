package com.demo.controller;

import java.util.concurrent.Semaphore;

public class ExeclController extends PublicController {
	// 限制同时导出execl 的次数
	private Semaphore semaphoreExecl = new Semaphore(4);

	
}
