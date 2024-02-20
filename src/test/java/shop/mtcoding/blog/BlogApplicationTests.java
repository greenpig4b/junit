package shop.mtcoding.blog;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BlogApplicationTests {
	//테스트하는 이유: 모듈화(책임나누기위해서)
	//테스트는 격리되어있어야한다.(가짜데이터 넣어봐야함)
	//테스트는 모든 경우의 수를 테스트 해봐야한다.(모든 경우의 수를 잡을수는 없다.)
	//나머지 터지는 경우의 수는 서버돌리면서 잡는다.
	//통합테스트 필요 1) 유기적으로 터지는 에러를 잡을 수 있다.
	@Test
	void contextLoads() {
	}

}
