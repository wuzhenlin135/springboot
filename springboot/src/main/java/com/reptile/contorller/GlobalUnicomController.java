package com.reptile.contorller;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.reptile.service.GlobalUnicomService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Map;


//全国联通
@Controller
@RequestMapping("GlobalUnicomController")
public class GlobalUnicomController {

    @Autowired
    private GlobalUnicomService mobileService;

    /**
     * 中国联通 获取登陆验证码
     *
     * @param request
     * @param response
     * @param
     * @return
     * @throws FailingHttpStatusCodeException
     * @throws MalformedURLException
     * @throws IOException
     * @throws InterruptedException 
     */
    @ApiOperation(value = "0.1获取登陆验证码",notes = "参数：手机号")
    @ResponseBody
    @RequestMapping(value = "UnicomGetCode",method = RequestMethod.POST)
    public Map<String, Object> UnicomGetCode(HttpServletRequest request,
			HttpServletResponse response, @RequestParam("Useriphone") String Useriphone){
        return mobileService.getCode(request, response, Useriphone);
    }
    /**
     * 联通登录接口
     * 
     * @param request
     * @param
     * @param
     * @return
     * @throws FailingHttpStatusCodeException
     * @throws MalformedURLException
     * @throws IOException
     */
    @ApiOperation(value = "0.2登陆",notes = "参数：手机号，服务密码，验证码")
    @ResponseBody
    @RequestMapping(value = "UnicomLogin",method = RequestMethod.POST)
    public Map<String, Object> UnicomLogin(HttpServletRequest request,
    		@RequestParam("Useriphone") String Useriphone,
    		@RequestParam("password") String password,
    		@RequestParam("UserCode") String UserCode){
        System.out.println("已经被访问了");
        
        return mobileService.unicomLogin(request,Useriphone, password,UserCode);
    }
   /** 
    * 获取详单验证码
    * @param request
    * @return
    * @throws FailingHttpStatusCodeException
    * @throws MalformedURLException
    * @throws IOException
    * @throws InterruptedException
    */
    @ApiOperation(value = "0.3获取验证码",notes = "")
    @ResponseBody
    @RequestMapping(value = "getCodeTwo",method = RequestMethod.POST)
    public Map<String, Object> GetCodeTwo(HttpServletRequest request){
        return mobileService.getCodeTwo(request);
        
    }

    /**
     * 获取详单
     * @param request
     * @param Useriphone
     * @param UserPassword
     * @param code
     * @return
     * @throws IOException
     */
    @ApiOperation(value = "0.4获取详单",notes = "参数：手机号，服务密码，验证码")
    @ResponseBody
    @RequestMapping(value = "getDetials",method = RequestMethod.POST)
    public Map<String,Object> getDetial(HttpServletRequest request,@RequestParam("Useriphone")String Useriphone,
    		@RequestParam("UserPassword")String UserPassword,
    		@RequestParam("code")String code,
    		@RequestParam("longitude")String longitude,
    		@RequestParam("latitude")String latitude,
    		@RequestParam("UUID")String UUID) {
				
    	return mobileService.getDetial(request, Useriphone, UserPassword,code,longitude,latitude,UUID);
    }
}
