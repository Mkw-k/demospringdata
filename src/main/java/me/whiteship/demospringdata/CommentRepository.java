package me.whiteship.demospringdata;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.RepositoryDefinition;

import java.util.List;

//@RepositoryDefinition(domainClass = Comment.class, idClass = Long.class)
public interface CommentRepository extends MyRepository<Comment, Long>{

    long count();
  //  Comment save(Comment comment);
  //  List<Comment> findAll();




}
