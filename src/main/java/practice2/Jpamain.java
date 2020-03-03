package practice2;

import hellojpa.domain.MemberSafe;
import practice1.jpabook.jpashop.domain.Member;

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

            TeamTwo teamTwo = new TeamTwo();
            teamTwo.setName("teamA");
            em.persist(teamTwo);   // team의 ID가 할당됨

            MemberTwo memberTwo = new MemberTwo();
            memberTwo.setName("memberB");
            memberTwo.setTeamTwo(teamTwo);
            em.persist(memberTwo);

            MemberTwo memberTwo1 = em.find(MemberTwo.class, memberTwo.getId());
            System.out.println(memberTwo1.getTeamTwo().getName());
            tx.commit();


        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }


        entityManagerFactory.close();
    }
}
