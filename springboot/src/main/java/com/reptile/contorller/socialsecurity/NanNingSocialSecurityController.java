package com.reptile.contorller.socialsecurity;

import io.swagger.annotations.ApiOperation;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.reptile.service.socialsecurity.NanNingSocialSecurityService;
/**
 * 
 * @ClassName: NanNingSocialSecurityController  
 * @Description: TODO  
 * @author: fangshuang
 * @date 2017年12月29日  
 *
 */
@Controller
@RequestMapping("NanNingSocialSecurityController")
public class NanNingSocialSecurityController {
	@Autowired
    private NanNingSocialSecurityService service;
	
	@RequestMapping(value = "getDeatilMes",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "贵阳社保",notes = "参数：身份证，密码，公积金账号")
    public Map<String,Object> getDeatilMes(HttpServletRequest request, @RequestParam("idCard") String idCard, @RequestParam("passWord")String passWord,
             @RequestParam("idCardNum")String idCardNum, @RequestParam("userName") String userName, @RequestParam("cityCode")String cityCode,
            @RequestParam("socialCard")String socialCard,@RequestParam("UUID")String UUID){

        return service.getDeatilMes(request, idCard.trim(), passWord.trim(),socialCard.trim(),idCardNum.trim(),UUID.trim());
    }
}
