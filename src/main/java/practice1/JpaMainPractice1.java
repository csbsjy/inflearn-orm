package practice1;

import hellojpa.domain.MemberSafe;
import practice1.jpabook.jpashop.domain.Member;
import practice1.jpabook.jpashop.domain.Order;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMainPractice1 {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello");
        EntityManager em = entityManagerFactory.createEntityManager(); // = Database Connection

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Order order = em.find(Order.class, 1L);
            Long memberId = order.getMemberId();

            Member member = em.find(Member.class, memberId); // 객체지향적이지 않은 로직! 데이터 중심의 포현법의 한계.

        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }


        entityManagerFactory.close();
    }
}

