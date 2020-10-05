package com.app.test.log4j;


import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class MyLogger {

	//mainLogger is a logger object that we got from LogManager. All loggers are 
        //using this method only. We can consider LogManager as a factory to create
        //Logger objects
	static Logger mainLogger = LogManager.getLogger(Logger.class.getName());

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BasicConfigurator.configure();
		mainLogger.info("This is a logger");	

	}
}
