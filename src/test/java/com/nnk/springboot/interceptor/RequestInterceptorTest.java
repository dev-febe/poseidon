package com.nnk.springboot.interceptor;

import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class RequestInterceptorTest {

    @Mock
    private Logger logger;

    @InjectMocks
    RequestInterceptor requestInterceptor;

    @Test
    public void testDoFilter() throws IOException, ServletException {
        HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
        HttpServletResponse httpServletResponse = mock(HttpServletResponse.class);
        FilterChain filterChain = mock(FilterChain.class);

        requestInterceptor.doFilter(httpServletRequest, httpServletResponse, filterChain);
        Mockito.verify(logger, times(1)).info("Request -> path: " + ((HttpServletRequest) httpServletRequest).getRequestURI() + ", method: " + ((HttpServletRequest) httpServletRequest).getMethod() + ", body " + ((HttpServletRequest) httpServletRequest).getQueryString());
    }
}
