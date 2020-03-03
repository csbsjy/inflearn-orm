package practice2;

import javax.persistence.*;

//@Entity // JPA 를 사용하는 클래스구나~
public class MemberTwo {

    @Id //primary key
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "USERNAME")
    private String name;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private TeamTwo teamTwo;

    public TeamTwo getTeamTwo() {
        return teamTwo;
    }

    public void setTeamTwo(TeamTwo teamTwo) {
        this.teamTwo = teamTwo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
