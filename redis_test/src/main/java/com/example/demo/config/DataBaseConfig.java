package com.example.demo.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by Fan.yang on 2018/5/24 19:50.
 */

@Configuration
@Slf4j
public class DataBaseConfig {

    private final String driverClass = "com.mysql.jdbc.Driver";
    @Value("#{systemProperties['database.url']}")
    private String url;
    @Value("#{systemProperties['database.username']}")
    private String username;
    @Value("#{systemProperties['database.password']}")
    private String password;
    /**
     * 初始化时建立物理连接的个数。初始化发生在显示调用init方法，或者第一次getConnection时
     */
    @Value("#{systemProperties['database.initialSize'] ?: '10'}")
    private String initialSize;
    /**
     * 最大连接池数量
     */
    @Value("#{systemProperties['database.maxActive'] ?: '100'}")
    private String maxActive;
    /**
     * 最小连接池数量
     */
    @Value("#{systemProperties['database.minIdle'] ?: '20'}")
    private String minIdle;
    /**
     * 获取连接时最大等待时间，单位毫秒。配置了maxWait之后，缺省启用公平锁，并发效率会有所下降，如果需要可以通过配置useUnfairLock属性为true使用非公平锁。
     */
    @Value("#{systemProperties['database.maxWait'] ?: '3000'}")
    private String maxWait;

    //配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒
    private Long timeBetweenEvictionRunsMillis = 60000L;
    //配置一个连接在池中最小生存的时间，单位是毫秒
    private Long minEvictableIdleTimeMillis = 300000L;

    private String validationQuery = "SELECT 'x' ";

    private boolean testOnReturn = false;


    @Bean(name = "drdsJdbcTemplate")
    public JdbcTemplate drdsJdbcTemplate(DataSource dataSource) {
        JdbcTemplate drdsJdbcTemplate = new JdbcTemplate(dataSource);
        log.debug("drdsJdbcTemplate初始化完成");
        return drdsJdbcTemplate;
    }

    @Bean(name = "dataSource")
    DataSource initDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        dataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        dataSource.setTestOnReturn(testOnReturn);
        dataSource.setUrl(this.url);
        dataSource.setUsername(this.username);
        dataSource.setPassword(this.password);
        dataSource.setDriverClassName(this.driverClass);
        // for test
        /*dataSource.setUsername("qa1ccms");
        dataSource.setPassword("qa1ccms");
        dataSource.setUrl("jdbc:mysql://dbi01.sho.shuyun.com/dev_benefit?useUnicode=true&characterEncoding=utf8&autoReconnect=true&allowMultiQueries=true&noAccessToProcedureBodies=true&rewriteBatchedStatements=true");
        */

        dataSource.setInitialSize(Integer.parseInt(initialSize));
        dataSource.setMaxActive(Integer.parseInt(maxActive));
        dataSource.setMinIdle(Integer.parseInt(minIdle));
        dataSource.setMaxWait(Integer.parseInt(maxWait));

        dataSource.setValidationQuery(validationQuery);
        dataSource.setTestOnBorrow(false);
        dataSource.setTestWhileIdle(true);

        return dataSource;
    }

    @Bean(name = "sqlSessionFactory")
    SqlSessionFactory initSqlSessionFactoryBean() {
        try {
            log.info("初始化mysql开始。。");
            SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
            sqlSessionFactoryBean.setDataSource(this.initDataSource());
            ResourcePatternResolver patternResolver = new PathMatchingResourcePatternResolver();
            sqlSessionFactoryBean.setConfigLocation(patternResolver.getResource("classpath:mybatis-config.xml"));

            sqlSessionFactoryBean.setMapperLocations(patternResolver.getResources("classpath:sqlmap/**/*.xml"));
            PageHelper pageHelper = new PageHelper();
            Properties properties = new Properties();
            properties.setProperty("dialect", "mysql");
            properties.setProperty("reasonable", "true");
            pageHelper.setProperties(properties);
            sqlSessionFactoryBean.setPlugins(new Interceptor[]{pageHelper});
            SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBean.getObject();
            log.info("初始化mysql结束。sqlSessionFactory:{}", sqlSessionFactory);
            return sqlSessionFactory;
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return null;
    }

    @Bean(name = "transactionManager")
    public PlatformTransactionManager transactionManager(@Qualifier("dataSource") DataSource myqlDataSource) {
        return new DataSourceTransactionManager(myqlDataSource);
//        return new DataSourceTransactionManager(myqlDataSource) {
//            @Override
//            protected void prepareTransactionalConnection(Connection con, TransactionDefinition definition) throws SQLException {
//                try (Statement stmt = con.createStatement()) {
//                    int i = stmt.executeUpdate("SET drds_transaction_policy = 'FLEXIBLE'");//开启drds柔性事物
//                    log.info("开启柔性事物：{}", i > 0 ? true : false);
//                }
//            }
//        };
    }

}
