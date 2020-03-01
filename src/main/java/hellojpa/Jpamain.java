package hellojpa;

import hellojpa.domain.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class Jpamain {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello");
        EntityManager em = entityManagerFactory.createEntityManager(); // = Database Connection

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            // 영속
            Member member = em.find(Member.class, 150L);

            member.setName("ZZZZ");
//            em.persist(member);  절대 불필요!
            em.detach(member);

            System.out.println("---------------------");

            tx.commit(); // update query


        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }


        entityManagerFactory.close();
    }
}
