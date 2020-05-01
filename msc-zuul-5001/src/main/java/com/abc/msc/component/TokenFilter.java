package com.abc.msc.component;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class TokenFilter extends ZuulFilter {

	@Value("${jwt.tokenHeader}")
	private String tokenHeader;
	@Value("${jwt.tokenHead}")
	private String tokenHead;
	
	@Override
	public boolean shouldFilter() {
		return true; //是否执行该filter
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext requestContext = RequestContext.getCurrentContext();
		HttpServletRequest request = requestContext.getRequest();
		
		String authHeader = request.getHeader(this.tokenHeader);
		log.info("authHeader={}",authHeader);
		if (authHeader != null && authHeader.startsWith(this.tokenHead)) {
			String authToken = authHeader.substring(this.tokenHead.length());// The part after "Bearer "
			log.info("authToken={}",authToken);
//			String username = jwtTokenUtil.getUserNameFromToken(authToken);
//			log.info("checking username:{}", username);
//			if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//				UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
//				if (jwtTokenUtil.validateToken(authToken, userDetails)) {
//					UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
//							userDetails, null, userDetails.getAuthorities());
//					authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//					log.info("authenticated user:{}", username);
//					SecurityContextHolder.getContext().setAuthentication(authentication);
//				}
//			}
		}
		
		
		return null;
	}

	@Override
	public String filterType() {
		return "pre"; // pre/route/post/error
	}

	@Override
	public int filterOrder() {
		return 0;
	}

}
