package org.zerock.spring1.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import javax.sql.DataSource;
/**
 * root-context.xml 을 대신하는 설정 파일
 *
 * @Congfiguration - 해당 클래스를 설정 클래스라고 알려주는 어노테이션
 * @ComponentScan(basePackages = {패키지경로}) - 빈 객체로 생성할 패키지 탐색 경로
 * @MapperScan(basePackages = {패키지경로}) - 해당 패키지 경로의 Mapper를 연결해준다
 * */

@Configuration
@ComponentScan(basePackages = {"org.zerock.spring1.service"})
@MapperScan(basePackages = {"org.zerock.spring1.mapper"}) //mapper로 간주
@EnableAspectJAutoProxy
public class RootConfig {
    @Bean
    public HikariConfig hikariConfig(){
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("org.mariadb.jdbc.Driver");
        config.setJdbcUrl("jdbc:mariadb://localhost/webdb");
        config.setUsername("webuser");
        config.setPassword("webuser");
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        return config;
    }

    @Bean DataSource dataSource(){ //내가 만든 코드가 아니라면 설정파일에서 bean을 이용한다.
        return new HikariDataSource(hikariConfig());
    }

    @Configuration
    public class MyBatisConfig {
        @Bean
        public SqlSessionFactory sqlSessionFactory() throws Exception {
            SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
            factoryBean.setDataSource(dataSource());
            return factoryBean.getObject();
        }
    }

    {
        System.out.println("------------------");
        System.out.println("------------------");
        System.out.println("------------------");
    }
}
