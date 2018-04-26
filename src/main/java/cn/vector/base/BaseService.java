package cn.vector.base;

import java.io.Serializable;
import java.util.List;

/**
 * @Author : Huang Vector ( hgw )
 * @Date : 2018-4-16 14:35
 */
public interface BaseService<T, ID extends Serializable> {
    Serializable save(T o);

    void delete(T o);

    void update(T o);

    void saveOrUpdate(T o);

    List<T> find(String hql);

    List<T> find(String hql, Object[] param);

    List<T> find(String hql, List<Object> param);

    List<T> find(String hql, Object[] param, Integer page, Integer rows);

    List<T> find(String hql, List<Object> param, Integer page, Integer rows);

    T get(Class<T> c, Serializable id);

    T get(String hql, Object[] param);

    T get(String hql, List<Object> param);

    Long count(String hql);

    Long count(String hql, Object[] param);

    Long count(String hql, List<Object> param);

    Integer executeHql(String hql);

    Integer executeHql(String hql, Object[] param);

    Integer executeHql(String hql, List<Object> param);
}
