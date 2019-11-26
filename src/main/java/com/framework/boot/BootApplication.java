package com.framework.boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BootApplication {
	// 日志记录工具
	private static final Logger logger = LoggerFactory.getLogger(BootApplication.class);
	public static void main(String[] args) {
		logger.info("》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》");
		SpringApplication.run(BootApplication.class, args);
		logger.info("《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《");
	}

}
