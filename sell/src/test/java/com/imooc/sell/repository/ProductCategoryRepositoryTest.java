package com.imooc.sell.repository;

import com.imooc.sell.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.criteria.CriteriaBuilder;
import javax.transaction.Transactional;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest{

    @Autowired
    private  ProductCategoryRepository repository;

    @Test
    public void findAllTest(){
        List<ProductCategory> productCategories =  repository.findAll();
        for(ProductCategory productCategory : productCategories){
            System.out.println(productCategory.toString());
        }
    }
    /*修改，增加*/
    @Test
    @Transactional      /*测试数据不会保存到数据库*/
    public void saveTest(){
        ProductCategory productCategory = new ProductCategory("月销冠军",6);
        ProductCategory result = repository.save(productCategory);
        Assert.assertNotNull(result);
//      Assert.assertNotEquals(null,result);
    }

    @Test
    public void findByCategoryTypeInTest(){
        List<Integer> list = Arrays.asList(1,2,3,4,5,6);
        List<ProductCategory> result = repository.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0,result.size());
    }


}