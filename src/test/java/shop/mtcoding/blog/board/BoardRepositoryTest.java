package shop.mtcoding.blog.board;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;

@Import(BoardRepository.class)
@DataJpaTest // DB 관련 객체들이 IoC에 뜬다.
public class BoardRepositoryTest {

    @Autowired // Test DI 하는 코드
    private BoardRepository boardRepository;

    @Test
    public void insert_test(){ // 테스트 매서드는 파라미터가 없고 리턴도 없다.
        // given : 가짜데이터
        String title = "제목10";
        String content = "내용10";
        String author = "이순신";

        // when
        boardRepository.insert(title, content, author);

        // then -> 눈으로 확인 (쿼리)
    } // Rollback (자동)


    @Test
    public void selectOne_test(){
        //given
        int id = 1;
        //when
        Board board = boardRepository.selectOne(id);
        //then 객체안에 상태검사
        //System.out.println(board);
        Assertions.assertThat(board.getTitle()).isEqualTo("제목1");
        Assertions.assertThat(board.getContent()).isEqualTo("내용1");
        Assertions.assertThat(board.getAuthor()).isEqualTo("홍길동");

    }

    // 업데이트 -----------------------------------------

    @Test
    public void update_test(){
        //given
        String title = "타이틀 바꿈";
        String content = "컨텐츠도 바꿈";
        String author = "작성자도 바꿈";
        int id = 1;
        //when
        boardRepository.update(title,content,author,id);
        //then

        List<Board> boardList = boardRepository.findAll();
        Board board = boardList.get(0);
        //System.out.println(board);

        // System.out.println(boardList);

        Assertions.assertThat(board.getTitle()).isEqualTo("타이틀 바꿈");
        Assertions.assertThat(board.getContent()).isEqualTo("컨텐츠도 바꿈");
        Assertions.assertThat(board.getAuthor()).isEqualTo("작성자도 바꿈");
    }

    // 삭제 -----------------------------------------------

    @Test
    public void delete_test(){
        //given
        int id = 4;

        //when
        boardRepository.delete(id);

        //then
        List<Board> boardList = boardRepository.findAll();
        //사라진번호확인
        //Board deleteNumber = boardList.

        //전체 테이블에서 사라진 번호확인
        System.out.println(boardList);


    }

    @Test
    public void findAll_test(){
        //given

        //when
        List<Board> board = boardRepository.findAll();
        //System.out.println(board);
        //then 객체안에 상태검사

        Assertions.assertThat(board.get(0).getTitle()).isEqualTo("제목1");
        Assertions.assertThat(board.get(0).getContent()).isEqualTo("내용1");
        Assertions.assertThat(board.get(0).getAuthor()).isEqualTo("홍길동");

    }






}