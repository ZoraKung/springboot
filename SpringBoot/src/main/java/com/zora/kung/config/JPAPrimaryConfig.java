package com.zora.kung.config;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Map;

/**
 * Created by Walter on 2016/11/13.
 */
//@Profile({"local", "remote"})
@Configuration
//@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactoryPrimary",
        //transactionManagerRef = "transactionManagerPrimary",
        //transactionManagerRef = "transactionManager",
        basePackages =
                {
//                        "com.zora.kung.sysadmin.dao"
//                        , "com.wjxinfo.core.security.dao"
                }
) // Data JPA Repository Location
//@AutoConfigureAfter(DataSourceConfig.class)
@AutoConfigureAfter({DataSourceConfig.class})
public class JPAPrimaryConfig {
    private static Logger logger = LoggerFactory.getLogger(JPAPrimaryConfig.class);

    @Autowired
    private Environment env;

    @Autowired
    @Qualifier("primaryDataSource")
    private DataSource primaryDataSource;

//    @Autowired
//    @Qualifier("transactionManager")
//    private PlatformTransactionManager transactionManager;

    @Primary
    @Bean(name = "entityManagerPrimary")
    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
        return entityManagerFactoryPrimary(builder).getObject().createEntityManager();
    }

    @Primary
    @Bean(name = "entityManagerFactoryPrimary")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryPrimary(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(primaryDataSource)
                .properties(getVendorProperties(primaryDataSource))
                .packages("com.zora.kung.biz.model"

                ) // Entity/Domain Location
                .persistenceUnit("primaryPersistenceUnit")
                .build();
    }

    @Autowired
    private JpaProperties jpaProperties;

    private Map<String, String> getVendorProperties(DataSource dataSource) {
        Map<String, String> map = jpaProperties.getHibernateProperties(dataSource);
        String auto = env.getProperty("datasource.primary.hibernate.hbm2ddl.auto");
        String dialect = env.getProperty("datasource.primary.hibernate.dialect");
        String showSql= env.getProperty("datasource.primary.hibernate.show_sql");

        if (StringUtils.isNotBlank(dialect)) {
            map.put("hibernate.dialect", dialect);
            logger.info("datasource.primary\t\t hibernate.dialect=" + dialect);
        }
        if (StringUtils.isNotBlank(auto)) {
            map.put("hibernate.hbm2ddl.auto", auto);
            logger.info("datasource.primary\t\t hibernate.hbm2ddl.auto=" + auto);
        }
        if (StringUtils.isNotBlank(showSql)) {
            map.put("hibernate.show_sql", showSql);
            logger.info("datasource.primary\t\t hibernate.show_sql=" + showSql);
        }

        return map;
    }

}
