package edu.nf.gc.service.config;

import edu.nf.gc.dao.config.DaoConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @author Fu
 * @date 2019/11/20
 */
@ComponentScan(basePackages = "edu.nf.gc.service")
/**
 * @EnableTransactionManagement等同于
 * 配置文件<tx:annotation-driven/>
 */
@EnableTransactionManagement
@Import(DaoConfig.class)
public class AppConfig {
    /**
     * 配置事务管理器，并注入数据源
     * @return
     */
    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }
}
