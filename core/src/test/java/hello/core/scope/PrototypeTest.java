package hello.core.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

public class PrototypeTest {

   @Test
   void prototypeBean() {
       AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(
               PrototypeBean.class);

       PrototypeBean prototypeBean1 = ac.getBean(PrototypeBean.class);
       PrototypeBean prototypeBean2 = ac.getBean(PrototypeBean.class);

       Assertions.assertNotEquals(prototypeBean1, prototypeBean2);
       ac.close();
   }

   @Scope("prototype")
   static class PrototypeBean {
       @PostConstruct
       public void init(){
           System.out.println("SingletonBean.init");
       }

       @PreDestroy
       public void destroy() {
           System.out.println("SingletonBean.destroy");
       }
   }
}
