//package com.ksc.kdts.taskmonitor.config;
//
//import com.fasterxml.jackson.annotation.JsonInclude;
//import com.fasterxml.jackson.databind.DeserializationFeature;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.module.SimpleModule;
//import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
//import com.ksc.kdts.taskmonitor.interception.AdminTokenInterceptor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.converter.HttpMessageConverter;
//import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
//
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @author Richard
// * @since 2019-07-27
// */
//@Configuration
//public class WebConfigurer extends WebMvcConfigurationSupport {
//
//    @Autowired
//    private AdminTokenInterceptor adminTokenInterceptor;
//
//    /**
//     * 定义JSON格式转换器
//     */
//    @Bean
//    public MappingJackson2HttpMessageConverter jackson2HttpMessageConverter() {
//        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
//        ObjectMapper mapper = new ObjectMapper();
//        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
//        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
//        converter.setObjectMapper(mapper);
//
//        // 将long类型的数据转为String类型
//        SimpleModule simpleModule = new SimpleModule();
//        simpleModule.addSerializer(Long.class, ToStringSerializer.instance);
//        simpleModule.addSerializer(Long.TYPE, ToStringSerializer.instance);
//        simpleModule.addSerializer(long.class, ToStringSerializer.instance);
//        mapper.registerModule(simpleModule);
//
//        return converter;
//    }
//
//    /**
//     * 添加转换器
//     */
//    @Override
//    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        // 将我们定义的时间格式转换器添加到转换器列表中,
//        // 这样jackson格式化时候但凡遇到Date类型就会转换成我们定义的格式
//        converters.add(jackson2HttpMessageConverter());
//    }
//
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//
//        List<String> excludePaths = new ArrayList<>();
//        // 2.admin拦截器
//        InterceptorRegistration adminInterceptor = registry.addInterceptor(adminTokenInterceptor);
//        adminInterceptor.addPathPatterns("/admin/**");
//        excludePaths = new ArrayList<>();
////        excludePaths.add("/admin/**");
//        excludePaths.add("/admin/sysAccount/**");
//        excludePaths.add("/admin/store/**");
//        excludePaths.add("/admin/equipment/**");
//        excludePaths.add("/admin/image/**");//文件上传
//        excludePaths.add("/dev-cg/admin/other/**");//车辆，人脸推送
//        excludePaths.add("/admin/schedule/**");//所有定时器
//        adminInterceptor.excludePathPatterns(excludePaths);
//
//        super.addInterceptors(registry);
//    }
//
//
//}
