package me.whiteship.demospringdata;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/*
맵핑하지 않는 경우 테이블 이름과 같은 테이블을 찾음
**User라는 이름을 가진 엔티티를 만들수 없는 DB도 있으므로 조심하도록 하자!
 */

//@Entity(name = "myAccount")
@Entity
//@Entity(name = "users")
public class Account {

    @Id @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    private String password;

    @OneToMany(mappedBy = "owner")
    private Set<Study> studies = new HashSet<>();

    public Set<Study> getStudies() {
        return studies;
    }

    public void setStudies(Set<Study> studies) {
        this.studies = studies;
    }


    //만약에 컬럼이 이미 만들어진 상태라면 컬럼 설정 적용을 변경할수 없고 타입을 변경하여 데이터를 넣으려면
    //타입 에러가 발생한다.

    //@Temporal(TemporalType.TIMESTAMP)
    @Temporal(TemporalType.TIME)
    private Date created = new Date();

    private String yse;

    //컬럼으로 맵핑하지 않는 에노테이션
    @Transient
    private String no;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name = "home_street"))
    })
    private Address homeAddress;


    //겟터 셋터는 없어도 컬럼으로 맵핑이 된다
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void addStudy(Study study) {
        this.getStudies().add(study);
        study.setOwner(this);
    }
    public void removeStudy(Study study) {
        this.getStudies().remove(study);
        study.setOwner(null);
    }


}
