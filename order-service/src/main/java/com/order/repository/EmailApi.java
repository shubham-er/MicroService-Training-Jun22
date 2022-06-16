package com.order.repository;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(url = "http://EMAIL/email", name="emailApi")
public interface EmailApi {

	@RequestMapping(method = RequestMethod.GET)
    String sendMail();
}
