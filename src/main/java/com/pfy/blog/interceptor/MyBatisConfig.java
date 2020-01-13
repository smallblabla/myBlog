package com.pfy.blog.interceptor;

import org.apache.ibatis.session.AutoMappingBehavior;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ExecutorType;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class MyBatisConfig {

    @Bean
    public ConfigurationCustomizer configurationCustomizer() {
        return new ConfigurationCustomizer() {
            @Override
            public void customize(Configuration configuration) {
                // 全局映射器启用缓存
                configuration.setCacheEnabled(false);
                // 查询时，关闭关联对象即时加载以提高性能
                configuration.setLazyLoadingEnabled(false);
                // 对于未知的SQL查询，允许返回不同的结果集以达到通用的效果
                configuration.setMultipleResultSetsEnabled(true);
                // 允许使用列标签代替列名
                configuration.setUseColumnLabel(true);
                // 给予被嵌套的resultMap以字段-属性的映射支持 FULL,PARTIAL
                configuration
                        .setAutoMappingBehavior(AutoMappingBehavior.PARTIAL);
                // 对于批量更新操作缓存SQL以提高性能 BATCH,SIMPLE
                configuration.setDefaultExecutorType(ExecutorType.BATCH);
                // 允许在嵌套语句上使用行边界。如果允许，设置false。
                configuration.setSafeRowBoundsEnabled(false);
                // 设置关联对象加载的形态，此处为按需加载字段(加载字段由SQL指 定)，不会加载关联表的所有字段，以提高性能
                configuration.setAggressiveLazyLoading(false);
                // 数据库超过30秒仍未响应则超时
                configuration.setDefaultStatementTimeout(30);


                // 注册时间注解拦截器到mybatis
                configuration.addInterceptor(new DateTimeInterceptor());

            }

        };
    }

}
