package com.zking.ssm.service;

import com.zking.ssm.model.Order;
import org.springframework.stereotype.Repository;

public interface IOrderService {

    Order selectByPrimaryKey(Integer orderId);
}