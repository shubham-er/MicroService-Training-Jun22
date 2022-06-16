package com.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.order.vo.OrderVO;

@Repository
public interface OrderRepository extends JpaRepository<OrderVO, Integer>{

}
