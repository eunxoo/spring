package hello.hellospring.domain;

import javax.persistence.*;

@Entity // 이제 JPA가 관리하는 Entity
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) // identity : db가 id 자동 생성
    private Long id; // 데이터 구분을 위해 시스템에서 저장하는 id

//    @Column(name = "username")  테이블과 이름이 다르면 이렇게 매핑해주면 됨.
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
}
