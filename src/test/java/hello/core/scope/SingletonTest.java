package hello.core.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import static org.assertj.core.api.Assertions.assertThat;

public class SingletonTest {

    @Test
    void singletonBeanFind() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SingleTonBean.class);
        SingleTonBean singleTonBean1 = ac.getBean(SingleTonBean.class);
        SingleTonBean singleTonBean2 = ac.getBean(SingleTonBean.class);
        System.out.println("singleTonBean1 = " + singleTonBean1);
        System.out.println("singleTonBean2 = " + singleTonBean2);
        assertThat(singleTonBean1).isSameAs(singleTonBean2);

        ac.close();
    }

    @Scope("singleton")
    static class SingleTonBean {
        @PostConstruct
        public void init() {
            System.out.println("SingleTonBean.init");
        }

        @PreDestroy
        public void destroy() {
            System.out.println("SingleTonBean.destroy");
        }
    }
}
