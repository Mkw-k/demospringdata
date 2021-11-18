package me.whiteship.demospringdata;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.List;

@NoRepositoryBean
//public interface MyRepository<T, Id extends Serializable> extends Repository<T, Id> {
public interface MyRepository<T, Id extends Serializable> {

    <E extends T>E save(E entity);

    List<T> findAll();

}
