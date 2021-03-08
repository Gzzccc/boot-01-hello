package com.atguigu.boot;


import ch.qos.logback.classic.db.DBHelper;
import com.atguigu.boot.bean.Pet;
import com.atguigu.boot.bean.User;
import com.atguigu.boot.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * 主程序类
 * 这是一个springboot应用
 */
//@SpringBootApplication  下面3个的合成
@SpringBootConfiguration //@Configuration代表当前是一个配置类
@EnableAutoConfiguration
@ComponentScan("com.atguigu.boot") //指定扫描哪些，Spring注解；
public class MainApplication {

    public static void main(String args[]){
        //返回IOC容器
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);
        //查看容器内容
        String[] names = run.getBeanDefinitionNames();
        for (String name: names) {
//            System.out.println(name);
        }
        //从容器中获取组件
        Pet tomcat1 = run.getBean("tom", Pet.class);
        Pet tomcat2 = run.getBean("tom", Pet.class);
        System.out.println((tomcat1 == tomcat2));

        MyConfig bean = run.getBean(MyConfig.class);
        System.out.println(bean);
        Pet tom01 = bean.tomcat();
        Pet tom02 = bean.tomcat();
        System.out.println((tom01 == tom02));
        //@Configuration(proxyBeanMethods = false)  false 没有依赖关系调用会重新创建新对象
        // 创建新对象 com.atguigu.boot.config.MyConfig@6920614
        //@Configuration(proxyBeanMethods = true)  true  有依赖关系调用直接获取当前对象
        // 代理对象 com.atguigu.boot.config.MyConfig$$EnhancerBySpringCGLIB$$6b438547@65d57e4e

        User user01 = run.getBean("user01", User.class);
        System.out.println(user01.getPet() == tom01);

        //获取组件
        String[] beanNamesForType = run.getBeanNamesForType(User.class);
        System.out.println("=======");
        for (String s : beanNamesForType) {
            System.out.println(s);
        }

        DBHelper bean1 = run.getBean(DBHelper.class);
        System.out.println(bean1);

        System.out.println(run.containsBean("user01"));

        System.out.println(run.getBeanDefinitionCount());

    }
}
