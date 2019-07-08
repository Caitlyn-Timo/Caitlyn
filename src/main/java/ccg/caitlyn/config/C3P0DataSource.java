package ccg.caitlyn.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class C3P0DataSource{

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource c3p0(){
        return new ComboPooledDataSource();
    }

   /* @Autowired
    private C3P0Properties c3P0Properties;

    @Bean
    public DataSource comboPooledDataSource() throws PropertyVetoException {
        System.out.println("c3p0Properties : "+c3P0Properties.toString());
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(c3P0Properties.getDriverName());
        dataSource.setJdbcUrl(c3P0Properties.getJdbcUrl());
        dataSource.setUser(c3P0Properties.getUserName());
        dataSource.setPassword(c3P0Properties.getPassWord());
        dataSource.setMaxPoolSize(c3P0Properties.getMaxPoolSize());
        dataSource.setMinPoolSize(c3P0Properties.getMinPoolSize());
        dataSource.setInitialPoolSize(c3P0Properties.getInitalPoolSize());
        return dataSource;
    }*/

}
