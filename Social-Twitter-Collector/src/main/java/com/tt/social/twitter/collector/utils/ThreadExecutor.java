package com.tt.social.twitter.collector.utils;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
 
public class ThreadExecutor extends java.util.concurrent.ThreadPoolExecutor {
 private static final int defaultCorePoolSize = 100;
 private static final int defaultMaximumPoolSize = 100;
 private static final long defaultKeepAliveTime = 10;
 private static final TimeUnit defaultTimeUnit = TimeUnit.MINUTES;
 private static final BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<Runnable>();
 private static ThreadExecutor instance;
 
 private ThreadExecutor() {
	// Passing the size information to the thread pool executor super class
     super(defaultCorePoolSize, defaultMaximumPoolSize, defaultKeepAliveTime, defaultTimeUnit, workQueue);
	 
 }
 
 public synchronized static ThreadExecutor getInstance() {
     if (instance == null) {
         instance = new ThreadExecutor();
     }
     return instance;
 }
}

