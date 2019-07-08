package ccg.caitlyn.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value = {"classpath:/c3p0dbsources.properties"})
@ConfigurationProperties(prefix="jdbc")
public class C3P0Properties {
    private String driverName;
    private String jdbcUrl;
    private String userName;
    private String passWord;
    private int maxPoolSize;
    private int minPoolSize;
    private int initalPoolSize;

    public String getDriverName() {
        return driverName;
    }

    public String getJdbcUrl() {
        return jdbcUrl;
    }

    public void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public int getMaxPoolSize() {
        return maxPoolSize;
    }

    public void setMaxPoolSize(int maxPoolSize) {
        this.maxPoolSize = maxPoolSize;
    }

    public int getMinPoolSize() {
        return minPoolSize;
    }

    public void setMinPoolSize(int minPoolSize) {
        this.minPoolSize = minPoolSize;
    }

    public int getInitalPoolSize() {
        return initalPoolSize;
    }

    public void setInitalPoolSize(int initalPoolSize) {
        this.initalPoolSize = initalPoolSize;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    @Override
    public String toString() {
        return "C3P0Properties{" +
                "driverName='" + driverName + '\'' +
                ", jdbcUrl='" + jdbcUrl + '\'' +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", maxPoolSize=" + maxPoolSize +
                ", minPoolSize=" + minPoolSize +
                ", initalPoolSize=" + initalPoolSize +
                '}';
    }
}
