package com.imooc.sell.repository;


import com.imooc.sell.dataobject.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by 廖师兄
 * 2017-06-11 17:24
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {

    /*通过买家的微信openId来查询并分页*/
    Page<OrderMaster> findByBuyerOpenid(String buyerOpenid, Pageable pageable);
}
