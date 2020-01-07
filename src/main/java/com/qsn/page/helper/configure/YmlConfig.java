package com.qsn.page.helper.configure;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 加载yaml配置文件的方法（自定义）。
 * <p>
 * spring-boot更新到1.5.2版本后locations属性无法使用
 *
 * @author qiusn 2019-11-20
 * @PropertySource 注解只可以加载 proprties 文件,无法加载 yaml 文件。 故现在把数据放到application.yml文件中,spring-boot启动时会加载
 * @ConfigurationProperties 指定配置文件中自定义的配置名称，可以取值; (prefix = "my-yml")：指定配置名;
 */
@Getter
@Setter
@ToString
@Component
@ConfigurationProperties(prefix = "my-yml")
public class YmlConfig {

    /**
     * 网络示例取值
     */
    private String simpleProp;
    private String[] arrayProps;
    private List<Map<String, String>> listProp1 = new ArrayList<>();
    private List<String> listProp2 = new ArrayList<>();
    private Map<String, String> mapProps = new HashMap<>();

    /**
     * 自定义取值
     */
    private String myStrProp;
    List myListProp;
    Map<String, String> myMapList;
    Integer[] myArr;

}