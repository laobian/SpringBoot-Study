package com.imooc.sell.repository;

import com.imooc.sell.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository repository;

    /*添加商品信息*/
    @Test
    public void saveTest(){
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("2");
        productInfo.setProductName("蛋炒饭");
        productInfo.setProductPrice(new BigDecimal(10.0));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("家的味道");
        productInfo.setProductIcon("http://xxxxx.jpg");
        productInfo.setCategoryType(2);
        repository.save(productInfo);
        Assert.assertNotNull(productInfo);
    }

    @Test
    public void findByProductStatus() throws Exception{
        List<ProductInfo>productInfoList = repository.findByProductStatus(0);   //查询所有上架商品
        Assert.assertNotEquals(0,productInfoList.size());
    }
}