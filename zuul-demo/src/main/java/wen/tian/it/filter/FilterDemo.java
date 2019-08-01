package wen.tian.it.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpStatus;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author tianwenwen
 * @date 2019/8/1 12:31
 **/
@Component
public class FilterDemo extends ZuulFilter {
    /*过滤器类型
    * pre：请求在被路由之前执行
    * routing：在路由请求时调用
    * post：在routing和error过滤器之后调用
    * error：在处理请求时发生错误时调用
    * */
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }
    /*过滤优先级 返回int
    * 数字越大优先级越低。
    * */
    @Override
    public int filterOrder() {
        return FilterConstants.PRE_DECORATION_FILTER_ORDER -1;
    }
    /*要不要进行过滤
    **/
    @Override
    public boolean shouldFilter() {
        return true;
    }
    /*过滤的逻辑*/
    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String token = request.getParameter("access-token");
        if (StringUtils.isBlank(token)){
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(HttpStatus.SC_FORBIDDEN);
        }
        return null;
    }
}
