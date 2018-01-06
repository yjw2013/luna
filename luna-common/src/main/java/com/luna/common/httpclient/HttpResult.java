package com.luna.common.httpclient;

/**
 * 
* @Title: HttpResult.java 
* @Package com.luna.common.httpclient 
* @Description: TODO(Http请求的返回报文封装) 
* @author 于继伟  
* @date 2017年11月24日 下午4:17:35
 */
public class HttpResult {

    private Integer code;

    private String body;
    
    public HttpResult() {
        
    }
    
    public HttpResult(Integer code, String body) {
        this.code = code;
        this.body = body;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

}
