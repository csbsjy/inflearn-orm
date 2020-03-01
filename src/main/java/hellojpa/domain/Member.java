package hellojpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.LinkedList;

@Entity // JPA 를 사용하는 클래스구나~
public class Member {

    @Id //primary key
    private Long id;

    private String name;

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

    public Member() {
    }

    public Member(Long id, String name) {
        this.id = id;
        this.name = name;
    }

}
