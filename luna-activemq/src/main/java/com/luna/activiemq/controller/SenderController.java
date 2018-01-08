package com.luna.activiemq.controller;

import javax.jms.Destination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luna.activiemq.service.ProducerService;

/**
 * 
* 发送消息
* @author 于继伟
* @Time 2018年1月8日
*
 */
@Controller
@RequestMapping("activiemq")
public class SenderController {
	
	@Autowired
    private ProducerService producerService;
    @Autowired
    @Qualifier("queueDestination")
    private Destination destination;

    @Autowired
    @Qualifier("topicDestination")
    private Destination topicDestination ;
	
	@RequestMapping(value="send.do")
	public void send(){
		for (int i=0; i<2; i++) {
            producerService.sendMessage(destination, "你好，生产者！这是消息：" + (i+1));
        }
	}
	
}
