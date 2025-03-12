package org.example.springaop.aspect;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    // /around 엔드포인트 호출: @AopTarget 어노테이션 기반 Around Advice 동작 확인
    @Test
    public void testAopAround() {
        String url = "http://localhost:" + port + "/around";
        restTemplate.getForEntity(url, String.class);
    }

    // /before 엔드포인트 호출: Before Advice 동작 확인
    @Test
    public void testAopBefore() {
        String url = "http://localhost:" + port + "/before";
        restTemplate.getForEntity(url, String.class);
    }

    // /after 엔드포인트 호출: After Advice 동작 확인
    @Test
    public void testAopAfter() {
        String url = "http://localhost:" + port + "/after";
        restTemplate.getForEntity(url, String.class);
    }
}
