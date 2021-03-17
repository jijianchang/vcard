package com.cslg.vcard.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.cslg.utils.Result;
import com.cslg.vcard.entity.Category;
import com.cslg.vcard.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jjc
 * @since 2021-03-05
 */
@RestController
@Api(tags = "院系类别")
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    @ApiOperation(value="查询院系列表", notes="查询院系列表")
    public Result<JSONArray> querycategorylist(){
        List<Category> categoryList = categoryService.list();
        Result<JSONArray> result = new Result<>();
        result.setResult(JSONArray.parseArray(JSON.toJSONString(categoryList)));
        result.setSuccess(true);
        return result;
    }

}

