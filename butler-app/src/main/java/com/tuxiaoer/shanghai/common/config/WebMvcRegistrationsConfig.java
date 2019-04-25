package com.tuxiaoer.shanghai.common.config;

import com.tuxiaoer.shanghai.common.versioning.ApiRequestMappingHandlerMapping;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * @author ：YeJR
 * @version : 1.0
 * @date ：2019/4/25 15:50
 * @description：
 */
@Configuration
public class WebMvcRegistrationsConfig implements WebMvcRegistrations {

    @Override
    public RequestMappingHandlerMapping getRequestMappingHandlerMapping() {
        return new ApiRequestMappingHandlerMapping();
    }


}
