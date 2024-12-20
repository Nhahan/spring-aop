package org.example.springaop;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringAopApplicationTests {

    @Autowired
    private AopTest aopTest;

    @Test
    void testMethodExecution() {
        aopTest.test();
    }

}
