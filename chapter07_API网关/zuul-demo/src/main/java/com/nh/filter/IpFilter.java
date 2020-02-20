package com.nh.filter;

import com.alibaba.fastjson.JSONObject;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.nh.util.IpUtils;
import org.apache.commons.lang.StringUtils;

import java.util.Arrays;
import java.util.List;

public class IpFilter extends ZuulFilter {
    private List<String> blackIpList = Arrays.asList("127.0.0.1");
    public IpFilter(){
        super();
    }

    // pre,route,post,error
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        String ip = IpUtils.getIpAddr(ctx.getRequest());
        if(StringUtils.isNotEmpty(ip)&&
            blackIpList.contains(ip)){
            ctx.setSendZuulResponse(false);
            //拦截本地转发请求
            // ctx.set("sendForwardFilter.ran",true);
            ctx.setResponseBody(JSONObject.parseObject("非法请求").toJSONString());
            ctx.getResponse().setContentType("application/json;charset=utf-8");
            ctx.set("isSuccess",false);
            return null;
        }
        return null;
    }
}
