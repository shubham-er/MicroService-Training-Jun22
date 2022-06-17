package com.email.receiver;

import java.util.List;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.email.model.OrderVO;

@Component
public class MessageReceiver {
	private static final String MESSAGE_QUEUE = "order_queue";

	@JmsListener(destination = MESSAGE_QUEUE)
	public void receiveMessage(List<OrderVO> order) {
		System.out.println("Received " + order.get(0));
//		throwexception(product);
	}

}
