package cn.vector.base;

import org.hibernate.Session;

import java.io.Serializable;
import java.util.List;

/**
 * @Author : Huang Vector ( hgw )
 * @Date : 2018-4-16 13:57
 * 实现使用Hibernate对数据CRUD操作的范性
 * 设计数据库实体后继承该范性就可以实现CRUD操作
 */
public interface BaseDao<T, ID extends Serializable> {
    Class<T> getPersistentClass();

    String getTableName();

    Session getCurrentSession();

    /**
     * 保存一个对象
     *
     * @param o
     * @return
     */
    Serializable save(T o);

    /**
     * 删除一个对象
     *
     * @param o
     */
     void delete(T o);

    /**
     * 更新一个对象
     *
     * @param o
     */
     void update(T o);

    /**
     * 保存或更新对象
     *
     * @param o
     */
     void saveOrUpdate(T o);

    /**
     * 查询
     *
     * @param hql
     * @return
     */
     List<T> find(String hql);

    /**
     * 查询集合
     *
     * @param hql
     * @param param
     * @return
     */
     List<T> find(String hql, Object[] param);

    /**
     * 查询集合
     *
     * @param hql
     * @param param
     * @return
     */
     List<T> find(String hql, List<Object> param);

    /**
     * 查询集合(带分页)
     *
     * @param hql
     * @param param
     * @param page  查询第几页
     * @param rows  每页显示几条记录
     * @return
     */
     List<T> find(String hql, Object[] param, Integer page, Integer rows);

    /**
     * 查询集合(带分页)
     *
     * @param hql
     * @param param
     * @param page
     * @param rows
     * @return
     */
     List<T> find(String hql, List<Object> param, Integer page, Integer rows);

    /**
     * 获得一个对象
     *
     * @param c  对象类型
     * @param id
     * @return Object
     */
     T get(Class<T> c, Serializable id);

    /**
     * 获得一个对象
     *
     * @param hql
     * @param param
     * @return Object
     */
     T get(String hql, Object[] param);

    /**
     * 获得一个对象
     *
     * @param hql
     * @param param
     * @return
     */
     T get(String hql, List<Object> param);

    /**
     * select count(*) from 类
     *
     * @param hql
     * @return
     */
     Long count(String hql);

    /**
     * select count(*) from 类
     *
     * @param hql
     * @param param
     * @return
     */
     Long count(String hql, Object[] param);

    /**
     * select count(*) from 类
     *
     * @param hql
     * @param param
     * @return
     */
     Long count(String hql, List<Object> param);

    /**
     * 执行HQL语句
     *
     * @param hql
     * @return 响应数目
     */
     Integer executeHql(String hql);

    /**
     * 执行HQL语句
     *
     * @param hql
     * @param param
     * @return 响应数目
     */
     Integer executeHql(String hql, Object[] param);

    /**
     * 执行HQL语句
     *
     * @param hql
     * @param param
     * @return
     */
     Integer executeHql(String hql, List<Object> param);
      List<T> findAll();
}
