package com.imooc.sell.serviceImp;

import com.imooc.sell.dataobject.ProductInfo;
import com.imooc.sell.enums.ProductStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImpTest {

    @Autowired
    private ProductServiceImp productServiceImp;

    @Test
    public void findOne() throws Exception {
        ProductInfo productInfo = productServiceImp.findOne("1");
        Assert.assertEquals("1",productInfo.getProductId());
    }

    @Test
    public void findUpAll() throws Exception{
        List<ProductInfo> productInfoList = productServiceImp.findUpAll();
        Assert.assertNotEquals(0,productInfoList.size());
    }

    @Test
    public void findAll() throws Exception{
        PageRequest request = new PageRequest(0,2);
        Page<ProductInfo> productInfoPage = productServiceImp.findAll(request);
//        System.out.println(productInfoPage.getTotalElements());
        Assert.assertNotEquals(0,productInfoPage.getTotalElements());
    }

    @Test
    public void save() throws Exception{
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("1");
        productInfo.setProductName("南昌瓦罐汤");
        productInfo.setProductPrice(new BigDecimal(6));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("神仙汤");
        productInfo.setProductIcon("http://xxxxxxx.jpg");
        productInfo.setProductStatus(ProductStatusEnum.DOWN.getCode());
        productInfo.setCategoryType(2);

        ProductInfo result = productServiceImp.save(productInfo);
        Assert.assertNotNull(result);
    }
}