package com.cslg.vcard.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cslg.utils.Result;
import com.cslg.vcard.entity.Ecard;
import com.cslg.vcard.mapper.EcardMapper;
import com.cslg.vcard.model.EcardModel;
import com.cslg.vcard.service.EcardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jjc
 * @since 2021-03-05
 */
@Slf4j
@Api(tags = "名片")
@RestController
@RequestMapping("/ecard")
public class EcardController {
    @Autowired
    private EcardService ecardService;

    @Autowired
    private EcardMapper ecardMapper;

    @GetMapping("/findall/{cid}/{page}/{size}")
    @ApiOperation(value="分页查询", notes="分页查询")
    public Result<?> queryPageList(@PathVariable("cid") String cid,@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        Page<Ecard> ecardPage = ecardMapper.selectPage(new Page<>(page, size), new QueryWrapper<Ecard>().lambda().eq(Ecard::getCid, cid));
        return Result.ok(ecardPage);
    }

    @GetMapping("/queryDetail/{eid}")
    @ApiOperation(value="查看名片详情", notes="查看名片详情")
    public Result<JSONArray> queryDetail(@PathVariable("eid") String eid){
        List<EcardModel> ecardModelList = ecardMapper.queryEcardList(eid);
        JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(ecardModelList));
        Result<JSONArray> result = new Result<>();
        result.setSuccess(true);
        result.setResult(jsonArray);
        return result;
    }

    @PostMapping("/queryFuzzy/{page}/{size}")
    @ApiOperation(value="模糊查询", notes="模糊查询")
    public Result<?> queryFuzzy(@PathVariable("page") Integer page, @PathVariable("size") Integer size,@RequestBody Ecard ecard){
        QueryWrapper<Ecard> queryWrapper = new QueryWrapper<>();
        QueryWrapper<Ecard> wrapper = queryWrapper.like("ename", ecard.getEname()).like("eage", ecard.getEage()).like("ecollege", ecard.getEcollege()).like("eprofessional_title", ecard.getEprofessionalTitle());
        Page<Ecard> ecardPage = ecardMapper.selectPage(new Page<>(page, size),wrapper);

        return Result.ok(ecardPage);
    }

    @GetMapping("/queryMycard/{uid}")
    @ApiOperation(value="我的名片", notes="我的名片")
    public Result<JSONObject> queryMycard(@PathVariable("uid") String uid)
    {
        Ecard ecard = ecardService.getOne(new QueryWrapper<Ecard>().eq("uid", uid));
        Result<JSONObject> result = new Result<>();
        result.setSuccess(true);
        result.setResult(JSONObject.parseObject(JSON.toJSONString(ecard)));
        return result;
    }
    @PutMapping("/updateMycard")
    @ApiOperation(value="修改我的名片", notes="修改我的名片")
    public Result<?> updateMycard(@RequestBody Ecard ecard)
    {
       ecardService.update(ecard,new QueryWrapper<Ecard>().eq("audit","1").eq("uid",ecard.getUid()));
       return Result.ok("修改成功");
    }


}

