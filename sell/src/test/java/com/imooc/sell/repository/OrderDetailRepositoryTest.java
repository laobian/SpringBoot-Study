package com.imooc.sell.repository;

import com.imooc.sell.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository repository;

    @Test
    public void saveTest(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("1234567");
        orderDetail.setOrderId("12345678");
        orderDetail.setProductId("2");
        orderDetail.setProductIcon("http://xxxx.jpg");
        orderDetail.setProductName("白粥");
        orderDetail.setProductPrice(new BigDecimal(2));
        orderDetail.setProductQuantity(40);

        OrderDetail result = repository.save(orderDetail);
        Assert.assertNotEquals(null,result);
    }

    @Test
    public void findByOrderId()throws Exception{
        List<OrderDetail> orderDetailList = repository.findByOrderId("123456");
        Assert.assertNotEquals(0,orderDetailList.size());
    }
}