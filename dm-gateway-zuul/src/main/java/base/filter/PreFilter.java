package base.filter;

import base.util.RedisUtils;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import javax.servlet.http.HttpServletRequest;

public class PreFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
//        RequestContext ctx = RequestContext.getCurrentContext();
//        HttpServletRequest request = ctx.getRequest();
//        String token = request.getHeader("token");
//        String requestUri = request.getRequestURI().toString();
//
//        if (requestUri.split("/")[0].equals("gateway")){
//            return "pass";
//        }
//
//        if (null == token ||
//        ! RedisUtils.exist(token)){  // redisUtils没实现，该步骤为在redis中查询token在redis中是否有对应的userId
//            ctx.setSendZuulResponse(false);
//            ctx.setResponseStatusCode(401);
//            ctx.setResponseBody("401!");
//            return "Access denied";
//        }

        return null;
    }
}
