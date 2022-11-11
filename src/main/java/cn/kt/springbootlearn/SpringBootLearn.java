package cn.kt.springbootlearn;

import jdk.nashorn.api.scripting.ScriptObjectMirror;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.InputStream;
import java.util.*;

@SpringBootApplication
@EnableWebMvc
public class SpringBootLearn {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringBootLearn.class);


//        RestTemplate restTemplate = applicationContext.getBean("restTemplate", RestTemplate.class);
        /*RestTemplate restTemplate = applicationContext.getBean(RestTemplate.class);


        List<String> provinceList = new ArrayList<>();
        Map<String, List<String>> areaMap = new LinkedHashMap<>();
        Map<String,List<String>> urbanMap = new LinkedHashMap<>();
        String CITY_URL = "https://file.40017.cn/zhuketong/zhuketong/data/cityList.js";
        try {
            Properties props = new Properties();
            InputStream in = null;
            try {
                in = SpringBootLearn.class.getClassLoader().getResourceAsStream("pmsconfig.properties");
                props.load(in);
            } catch (Exception e) {
//                logger.error("jdbc.properties文件未找到");
            }
//            Properties prop = PropertyUtil.loadProps("pmsconfig.properties");
            String city_url = props.getProperty("CITY_URL");
            if (!(city_url != null && !"".equals(city_url))){
                // 配置文件中没有设置 获取城市信息的地址
                city_url = CITY_URL;
            }
            String msg = restTemplate.getForObject(CITY_URL,String.class, new Object());
//            log.info("siteData。url：{}，code：{}",CITY_URL,code);
            // 显示响应结果
            ScriptEngineManager manager = new ScriptEngineManager();
            ScriptEngine engine = manager.getEngineByName("js");
            String js = "var window=new Object();"+msg;//js中缺少window对象，但又不会用到，所以new一个window
            engine.eval(js);
//            Object yeepayCityList = engine.get("yeepayCityList"); //yeepayCityData.js 使用
            Object yeepayCityList = engine.get("cityList");
            Collection<Object> values = ((ScriptObjectMirror) yeepayCityList).values();
            List cityNativeArray = new ArrayList<>(values);
//            List cityNativeArray = (List) yeepayCityList;
//            log.info("siteData。provinceSize：{}",cityNativeArray.size());
//			cityNativeArray.length
//			JSONObject jsonObject = JSONObject.fromObject(yeepayCityList);
            for (int i=0; i< cityNativeArray.size(); i++) {
                // 获取省信息
//				Object o = cityNativeArray.get(i);
                Object proLabel = ((Map) cityNativeArray.get(i)).get("label");
                provinceList.add(proLabel.toString());// 记录省名称
//				Object proValue = ((NativeObject) cityNativeArray.get(i)).get("value");
                Object proChildren = ((Map) cityNativeArray.get(i)).get("children");
                if (proChildren != null){
                    // 获取当前省下的 市信息
                    List areaNativeArr = new ArrayList(((ScriptObjectMirror) proChildren).values());
                    List<String> areaStrInOneProvince = new ArrayList<>(); // 初始省名称对应的市集合
                    areaMap.put(proLabel.toString(),areaStrInOneProvince); // 保存在指定省下
                    for (int areaI=0; areaI < areaNativeArr.size(); areaI++) {
                        Object areaLabel = ((Map) areaNativeArr.get(areaI)).get("label");
                        areaStrInOneProvince.add(areaLabel.toString());// 将市名称添加入集合
//						Object areaValue = ((NativeObject) areaNativeArr.get(areaI)).get("value");
                        Object areaChildren = ((Map) areaNativeArr.get(areaI)).get("children");
                        if (areaChildren != null){
                            // 获取当前市下的 区县信息
//                            List ubNativeArr = (List) areaChildren;
                            List ubNativeArr = new ArrayList(((ScriptObjectMirror) areaChildren).values());
                            List<String> urbanStrInOneProvince = new ArrayList<>(); // 初始市名称对应的区县集合
                            urbanMap.put(areaLabel.toString(),urbanStrInOneProvince); // 保存在指定市下
                            for (int urI=0; urI < ubNativeArr.size(); urI++) {
                                Object urLabel = ((Map) ubNativeArr.get(urI)).get("label");
                                urbanStrInOneProvince.add(urLabel.toString());// 将区县名称添加入集合
//								Object urValue = ((NativeObject) ubNativeArr.get(urI)).get("value");
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder
                //.basicAuthentication("username", "password")
                // .setConnectTimeout(Duration.ofSeconds(3))
                // .setReadTimeout(Duration.ofSeconds(5))
                // .rootUri("http://api.test.com/")
                .build();
    }
}
