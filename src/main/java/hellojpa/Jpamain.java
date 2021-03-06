package hellojpa;

import hellojpa.domain.MemberSafe;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Jpamain {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello");
        EntityManager em = entityManagerFactory.createEntityManager(); // = Database Connection

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            // 영속
            MemberSafe memberSafe = em.find(MemberSafe.class, 150L);

            memberSafe.setName("ZZZZ");
//            em.persist(member);  절대 불필요!
            em.detach(memberSafe);

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
