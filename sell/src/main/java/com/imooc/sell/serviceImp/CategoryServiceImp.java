package com.imooc.sell.serviceImp;

import com.imooc.sell.dataobject.ProductCategory;
import com.imooc.sell.repository.ProductCategoryRepository;
import com.imooc.sell.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service    //一般用于修饰serviceImp层的组件
public class CategoryServiceImp implements CategoryService {

    @Autowired  //自动导入依赖的bean
    private ProductCategoryRepository repository;

    @Override
    public ProductCategory findOne(Integer categoryId) {
        List<ProductCategory> result = repository.findAll();
        for (ProductCategory productCategory : result){
            if (productCategory.getCategoryId() == categoryId){
                return productCategory;
            }
        }
        return null;
    }

    @Override
    public List<ProductCategory> findAll() {
        return repository.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return repository.findByCategoryTypeIn(categoryTypeList);
    }

    @Override
    public ProductCategory save(ProductCategory productCategoryId) {
        return repository.save(productCategoryId);
    }
}
