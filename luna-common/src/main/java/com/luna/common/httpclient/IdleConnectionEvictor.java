package com.luna.common.httpclient;

import org.apache.http.conn.HttpClientConnectionManager;

/**
 * 
* @Title: IdleConnectionEvictor.java 
* @Package com.luna.common.httpclient 
* @Description: TODO(定时清理无效的Http连接) 
* @author 于继伟  
* @date 2017年11月24日 下午4:18:06
 */
public class IdleConnectionEvictor extends Thread{
	
	private final HttpClientConnectionManager connMgr;

    private volatile boolean shutdown;

    public IdleConnectionEvictor(HttpClientConnectionManager connMgr) {
        this.connMgr = connMgr;
        // 启动当前线程
//        this.start();
    }

    @Override
    public void run() {
        try {
            while (!shutdown) {
                synchronized (this) {
                    wait(5000);
                    // 关闭失效的连接
                    connMgr.closeExpiredConnections();
                }
            }
        } catch (InterruptedException ex) {
            // 结束
        }
    }

    public void shutdown() {
        shutdown = true;
        synchronized (this) {
            notifyAll();
        }
    }
	
}
