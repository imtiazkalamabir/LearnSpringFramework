package com.in28minutes.learnspringframework.section4.e1;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class NormalClass {

}

@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
class PrototypeClass {

}

@Configuration
@ComponentScan //auto scan on current package
public class BeanScopesLauncherApplication {

    public static void main(String [] args) {

        try(var context = new AnnotationConfigApplicationContext(BeanScopesLauncherApplication.class)) {

            //Spring Bean Scopes
            // Singleton - One object instance per Spring IOC Container
            System.out.println(context.getBean(NormalClass.class));
            System.out.println(context.getBean(NormalClass.class));
            System.out.println(context.getBean(NormalClass.class));

            // Prototype - Possibly many object instances per Spring IOC Container
            System.out.println(context.getBean(PrototypeClass.class));
            System.out.println(context.getBean(PrototypeClass.class));
            System.out.println(context.getBean(PrototypeClass.class));

        }
    }
}
