package com.order.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.service.OrderService;
import com.order.vo.OrderVO;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	OrderService orderService;

	@PostMapping
	public void saveOrder(@RequestBody @Valid OrderVO order) {
		orderService.save(order);
	}
	
	@GetMapping
	public List<OrderVO> getOrder(){
		return orderService.fndAll();
	}
}
