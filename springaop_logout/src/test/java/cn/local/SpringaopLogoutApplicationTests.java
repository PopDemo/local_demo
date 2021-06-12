package cn.local;

import cn.local.service.HomeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringaopLogoutApplicationTests {
	@Autowired
	HomeService homeService;

	@Test
	void contextLoads() {
		homeService.userQueryHomeInfo();
	}

}
