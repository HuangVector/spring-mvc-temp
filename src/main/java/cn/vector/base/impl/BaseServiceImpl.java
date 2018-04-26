package cn.vector.base.impl;

import cn.vector.base.BaseDao;
import cn.vector.base.BaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * @Author : Huang Vector ( hgw )
 * @Date : 2018-4-16 14:35
 */
//@Service("baseService")
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public abstract class BaseServiceImpl<T, ID extends Serializable> implements BaseService<T, ID> {
    private Logger log = LoggerFactory.getLogger(this.getClass().getName());


    public abstract BaseDao<T, ID> getDao();

    @Override
    @SuppressWarnings("unchecked")
    @Transactional(rollbackFor = Exception.class)
    public ID save(T o) {
        log.debug("插入（保存）实体对象，并返回id");
        return (ID)this.getDao().save(o);
    }

    @SuppressWarnings("unchecked")
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(T o) {
        this.getDao().delete(o);
    }

    @SuppressWarnings("unchecked")
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(T o) {
        this.getDao().update(o);
    }

    @SuppressWarnings("unchecked")
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveOrUpdate(T o) {
        this.getDao().saveOrUpdate(o);
    }

    @SuppressWarnings("unchecked")
    @Override
    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public List<T> find(String hql) {
        return this.getDao().find(hql);
    }

    @Override
    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public List<T> find(String hql, Object[] param) {
        return this.getDao().find(hql, param);
    }

    @Override
    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public List<T> find(String hql, List<Object> param) {
        return this.getDao().find(hql, param);
    }

    @Override
    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public List<T> find(String hql, Object[] param, Integer page, Integer rows) {
        return this.getDao().find(hql, param, page, rows);
    }

    @Override
    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public List<T> find(String hql, List<Object> param, Integer page, Integer rows) {
        return null;
    }

    @Override
    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public T get(Class<T> c, Serializable id) {
        return (T) this.getDao().get(c, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public T get(String hql, Object[] param) {
        return (T) this.getDao().get(hql, param);
    }

    @Override
    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public T get(String hql, List<Object> param) {
        return (T) this.getDao().get(hql, param);
    }

    @Override
    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public Long count(String hql) {
        return this.getDao().count(hql);
    }

    @Override
    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public Long count(String hql, Object[] param) {
        return this.getDao().count(hql, param);
    }

    @Override
    @SuppressWarnings("unchecked")
    @Transactional(rollbackFor = Exception.class, readOnly = true)
    public Long count(String hql, List<Object> param) {
        return this.getDao().count(hql, param);
    }

    @Override
    @SuppressWarnings("unchecked")
    @Transactional(rollbackFor = Exception.class)
    public Integer executeHql(String hql) {
        return this.getDao().executeHql(hql);
    }

    @Override
    @SuppressWarnings("unchecked")
    @Transactional(rollbackFor = Exception.class)
    public Integer executeHql(String hql, Object[] param) {
        return this.getDao().executeHql(hql, param);
    }

    @Override
    @SuppressWarnings("unchecked")
    @Transactional(rollbackFor = Exception.class)
    public Integer executeHql(String hql, List<Object> param) {
        return this.getDao().executeHql(hql, param);
    }
}
