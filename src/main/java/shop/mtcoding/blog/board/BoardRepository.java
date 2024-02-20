package shop.mtcoding.blog.board;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class BoardRepository {
    private final EntityManager em;

    @Transactional
    public void insert(String title, String content, String author){
        Query query = em.createNativeQuery("insert into board_tb(title, content, author) values(?, ?, ?)");
        query.setParameter(1, title);
        query.setParameter(2, content);
        query.setParameter(3, author);

        query.executeUpdate();
    }
    @Transactional
    public void update(String title, String content ,String author, int id){
        Query query = em.createNativeQuery("update board_tb set title = ? , content =? , author = ? where id = ?",Board.class);
        query.setParameter(1,title);
        query.setParameter(2,content);
        query.setParameter(3,author);
        query.setParameter(4,id);

        query.executeUpdate();

    }

    @Transactional
    public void delete(int id){
        Query query = em.createNativeQuery("delete from board_tb where id =?",Board.class);
        query.setParameter(1,id);

        query.executeUpdate();
    }

    public Board selectOne(int id) {
        Query query = em.createNativeQuery("select * from board_tb where id = ?", Board.class);
        query.setParameter(1, id);

        Board board =null;
        try {
            board = (Board) query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
        return board;
    }


    public List<Board> findAll() {
        Query query = em.createNativeQuery("select * from board_tb",Board.class);
        // List는 비어있으면  null 이 아니라 0을 주므로 try catch를 할 필요가 없다.
        List<Board> board = null;
        try {
            board = query.getResultList();
        } catch (Exception e) {
            return null;
        }
        return (List<Board>) board;
    }

}