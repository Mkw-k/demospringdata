package me.whiteship.demospringdata;

import org.hibernate.Session;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class JpaRunner implements ApplicationRunner {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<Post> posts = entityManager.createNativeQuery("Select * from Post", Post.class)
                .getResultList();

        posts.forEach(System.out::println);

    }

    /*
    @Override
    public void run(ApplicationArguments args) throws Exception {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Post> query = builder.createQuery(Post.class);
        Root<Post> root = query.from(Post.class);
        query.select(root);

        List<Post> posts = entityManager.createQuery(query).getResultList();
        posts.forEach(System.out::println);

    }
    */

    /*
    @Override
    public void run(ApplicationArguments args) throws Exception {
        TypedQuery<Post> query = entityManager.createQuery("SELECT p FROM Post AS p", Post.class);
        List<Post> posts = query.getResultList();
        posts.forEach(System.out::println);
    }
    */



    /*
    @Override
    public void run(ApplicationArguments args) throws Exception {
//        Post post = new Post();
//        post.setTitle("spring Data JPA 언제 보나...");
//
//        Comment comment = new Comment();
//        comment.setComment("빨리 보고 싶어오.");
//        post.addComment(comment);
//
//        Comment comment1 = new Comment();
//        comment1.setComment("곧 보여드릴께요.");
//        post.addComment(comment1);

        Session session = entityManager.unwrap(Session.class);
//        session.save(post);
        Post post = session.get(Post.class, 4L);
        System.out.println("==========================");
        System.out.println(post.getTitle());
//        Post post = session.get(Post.class, 1L);
//        session.delete(post);
//        session.save(post);

        post.getCommnets().forEach(c -> {
            System.out.println("-----------");
            System.out.println(c.getComment());
        });


//        Comment comment = session.get(Comment.class, 5L);
//        System.out.println("======================");
//        System.out.println(comment.getComment());
//        System.out.println(comment.getPost().getTitle());
    }
*/


/*
    @Override
    public void run(ApplicationArguments args) throws Exception {
        Account account = new Account();
        account.setUsername("keesun2");
        account.setPassword("jpa");

        Study study = new Study();
        study.setName("Spring JPA DATA");
        //study.setOwner(account);

        account.addStudy(study);

        Session session = entityManager.unwrap(Session.class);
        session.save(account);
        session.save(study);

        Account keesun = session.load(Account.class, account.getId());
        keesun.setUsername("whiteship");
        keesun.setUsername("keesun");
        keesun.setUsername("keesun2");
        System.out.println("=================");
        System.out.println(keesun.getUsername());


    }
*/

}
