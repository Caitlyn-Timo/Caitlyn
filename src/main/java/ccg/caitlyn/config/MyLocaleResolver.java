package ccg.caitlyn.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@Configuration
public class MyLocaleResolver implements LocaleResolver {

    /*
     spring boot从locale中获取当前浏览器语言，重置locale对象
     使之在点击切换语言按钮时使用自定义的Locale对象。
     */
    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        String loc=httpServletRequest.getParameter("la");
        Locale locale=Locale.getDefault();
        if (!StringUtils.isEmpty(loc)){
            String [] locales=loc.split("_");
            locale=new Locale(locales[0],locales[1]);
        }
        return  locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
