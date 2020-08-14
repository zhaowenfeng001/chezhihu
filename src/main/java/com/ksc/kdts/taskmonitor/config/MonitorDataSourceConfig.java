package com.ksc.kdts.taskmonitor.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.ksc.kdts.dashboard.mapper.monitor", sqlSessionTemplateRef = "monitorSqlSessionTemplate")
public class MonitorDataSourceConfig {
    @Bean("monitorDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.monitor")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean("monitorSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("monitorDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/monitor/*.xml"));
        return bean.getObject();
    }

    @Bean("monitorTransactionManager")
    public DataSourceTransactionManager transactionManager(@Qualifier("monitorDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean("monitorSqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("monitorSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
