package practice3;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class Practice3Main {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello");
        EntityManager em = entityManagerFactory.createEntityManager(); // = Database Connection

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            Team team = new Team();
            team.setName("TEAM_A");

            em.persist(team);

            Member member = new Member();
            member.setName("MEMBER_A");
            member.setTeam(team);

            em.persist(member);

            em.flush();
            em.clear();

            Member findMember = em.find(Member.class, member.getId());
            List<Member> members = findMember.getTeam().getMembers();

            for (Member member1 : members) {
                System.out.println(member1.getName());
            }


            tx.commit();


        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }


        entityManagerFactory.close();


    }
}
