package com.eddy.item.service;

import com.eddy.common.enums.ExceptionEnum;
import com.eddy.common.exception.EdException;
import com.eddy.item.mapper.CategoryMapper;
import com.eddy.item.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    public List<Category> queryCategoryListByPid(Long pid) {
        // 查询条件， mapper把非空属性作为查询条件
        Category t = new Category();
        t.setParentId(pid);
        List<Category> list = categoryMapper.select(t);

        // 判断结果
        if(CollectionUtils.isEmpty(list)){
            throw new EdException(ExceptionEnum.CATEGORY_NOT_FOUND);
        }
        return list;
    }
}
