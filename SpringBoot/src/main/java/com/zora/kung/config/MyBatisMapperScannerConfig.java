package com.zora.kung.config;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.zora.kung.config.ConfigConstants.MYBATIS_MAPPER_SCAN_PACKAGE_PRIMARY;
import static com.zora.kung.config.ConfigConstants.MYBATIS_MAPPER_SCAN_PACKAGE_SECONDARY;


/**
 * Created by Walter on 2016/11/14.
 */
@Configuration
@AutoConfigureAfter(MyBatisConfig.class)
public class MyBatisMapperScannerConfig {

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer1() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("primarySqlSessionFactory");
        mapperScannerConfigurer.setBasePackage(MYBATIS_MAPPER_SCAN_PACKAGE_PRIMARY);
        mapperScannerConfigurer.setAnnotationClass(MyBatisRepository.class);
        return mapperScannerConfigurer;
    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer2() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("secondarySqlSessionFactory");
        mapperScannerConfigurer.setBasePackage(MYBATIS_MAPPER_SCAN_PACKAGE_SECONDARY);
        mapperScannerConfigurer.setAnnotationClass(MyBatisRepository.class);
        return mapperScannerConfigurer;
    }

}
