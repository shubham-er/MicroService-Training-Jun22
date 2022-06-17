package com.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.order.repository.EmailApi;
import com.order.repository.OrderRepository;
import com.order.vo.OrderVO;

@Service
public class OrderService {
	
	@Autowired
	OrderRepository orderRepo;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	EmailApi emailApi;
	
	@Autowired
	JmsTemplate jmsTemplate;
	
	private static final String MESSAGE_QUEUE = "order_queue";
	
	public void save(OrderVO order) {
		//ResponseEntity<String> response = restTemplate.getForEntity("http://EMAIL/email", String.class);
		String response = emailApi.sendMail();
		System.out.println(response);
		orderRepo.save(order);
	}

	public List<OrderVO> fndAll(){
		//ResponseEntity<String> response = restTemplate.getForEntity("http://EMAIL/email", String.class);
		

		List<OrderVO> orders =  orderRepo.findAll();
		
		jmsTemplate.convertAndSend(MESSAGE_QUEUE, orders);
		//System.out.println(response.getBody());
		return orders;
	}
}
