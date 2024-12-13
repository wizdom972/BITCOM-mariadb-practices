package emaillist;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import emaillist.dao.EmaillistDao;
import emaillist.vo.EmaillistVo;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EmaillistDaoTest {

   @Test
   @Order(1)
   public void insertTest() {
      EmaillistVo vo = new EmaillistVo();
      vo.setFirstName("둘");
      vo.setLastName("리");
      vo.setEmail("dooly@gmail.com");
      
      Boolean result = new EmaillistDao().insert(vo);
      
      assertTrue(result);
      
      
   }
   
   @Test
   @Order(2)
   public void deleteByEmailTest() {
      Boolean result = new EmaillistDao().deleteByEmail("dooly@gmail.com");

      assertTrue(result);
   }
}
