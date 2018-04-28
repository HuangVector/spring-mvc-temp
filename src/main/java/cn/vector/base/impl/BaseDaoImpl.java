package cn.vector.base.impl;

import cn.vector.base.BaseDao;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * @Author : Huang Vector ( hgw )
 * @Date : 2018-4-16 14:03
 */
@Repository("baseDao")
public class BaseDaoImpl<T, ID extends Serializable> extends HibernateDaoSupport implements BaseDao<T, ID> {
    private Logger log = LoggerFactory.getLogger(this.getClass().getName());
    private Class<T> persistentClass;

    public BaseDaoImpl() {
        //当前对象的直接超类的 Type
        Type genericSuperclass = getClass().getGenericSuperclass();
        if (genericSuperclass instanceof ParameterizedType) {
            //参数化类型
            ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
            //返回表示此类型实际类型参数的 Type 对象的数组
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            this.persistentClass = (Class<T>) actualTypeArguments[0];
        } else {
            this.persistentClass = (Class<T>) genericSuperclass;
        }
    }

    /**
     * 获取实体对象类
     */
    public Class<T> getPersistentClass() {
        return persistentClass;
    }

    public String getTableName() {
        return getPersistentClass().getSimpleName();
    }

    public Session getCurrentSession() {
        return this.getSessionFactory().getCurrentSession();
    }

    public Serializable save(T o) {
        return this.getCurrentSession().save(o);
    }

    public void delete(T o) {


        //log.debug("运行class:{},method:{}",this.persistentClass.getName(),"delete()");
        this.getCurrentSession().delete(o);

    }

    public void update(T o) {
        log.debug("运行");
        this.getCurrentSession().update(o);

    }

    public void saveOrUpdate(T o) {
        this.getCurrentSession().saveOrUpdate(o);

    }

    @SuppressWarnings("unchecked")
    public List<T> find(String hql) {
        return this.getCurrentSession().createQuery(hql).list();
    }

    @SuppressWarnings("unchecked")
    public List<T> find(String hql, Object[] param) {
        Query q = this.getCurrentSession().createQuery(hql);
        if (param != null && param.length > 0) {
            for (int i = 0; i < param.length; i++) {
                q.setParameter(i, param[i]);
            }
        }
        return q.list();
    }

    @SuppressWarnings("unchecked")
    public List<T> find(String hql, List<Object> param) {
        Query q = this.getCurrentSession().createQuery(hql);
        if (param != null && param.size() > 0) {
            for (int i = 0; i < param.size(); i++) {
                q.setParameter(i, param.get(i));
            }
        }
        return q.list();
    }

    @SuppressWarnings("unchecked")
    public List<T> find(String hql, Object[] param, Integer page, Integer rows) {
        if (page == null || page < 1) {
            page = 1;
        }
        if (rows == null || rows < 1) {
            rows = 10;
        }

        Query q = this.getCurrentSession().createQuery(hql);

        if (param != null && param.length > 0) {
            for (int i = 0; i < param.length; i++) {
                q.setParameter(i, param[i]);
            }
        }
        return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
    }

    @SuppressWarnings("unchecked")
    public List<T> find(String hql, List<Object> param, Integer page, Integer rows) {
        if (page == null || page < 1) {
            page = 1;
        }
        if (rows == null || rows < 1) {
            rows = 10;
        }
        Query q = this.getCurrentSession().createQuery(hql);
        if (param != null && param.size() > 0) {
            for (int i = 0; i < param.size(); i++) {
                q.setParameter(i, param.get(i));
            }
        }
        return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
    }

    @SuppressWarnings("unchecked")
    public T get(Class<T> c, Serializable id) {
        return this.getCurrentSession().get(c, id);
    }

    public T get(String hql, Object[] param) {
        List<T> l = this.find(hql, param);
        if (l != null && l.size() > 0) {
            return l.get(0);
        } else {
            return null;
        }
    }

    public T get(String hql, List<Object> param) {
        List<T> l = this.find(hql, param);
        if (l != null && l.size() > 0) {
            return l.get(0);
        } else {
            return null;
        }
    }

    public Long count(String hql) {
        return (Long) this.getCurrentSession().createQuery(hql).uniqueResult();
    }

    public Long count(String hql, Object[] param) {
        Query q = this.getCurrentSession().createQuery(hql);
        if (param != null && param.length > 0) {
            for (int i = 0; i < param.length; i++) {
                q.setParameter(i, param[i]);
            }
        }
        return (Long) q.uniqueResult();
    }

    public Long count(String hql, List<Object> param) {
        Query q = this.getCurrentSession().createQuery(hql);
        if (param != null && param.size() > 0) {
            for (int i = 0; i < param.size(); i++) {
                q.setParameter(i, param.get(i));
            }
        }
        return (Long) q.uniqueResult();
    }

    public Integer executeHql(String hql) {
        return this.getCurrentSession().createQuery(hql).executeUpdate();
    }

    public Integer executeHql(String hql, Object[] param) {
        Query q = this.getCurrentSession().createQuery(hql);
        if (param != null && param.length > 0) {
            for (int i = 0; i < param.length; i++) {
                q.setParameter(i, param[i]);
            }
        }
        return q.executeUpdate();
    }

    public Integer executeHql(String hql, List<Object> param) {
        Query q = this.getCurrentSession().createQuery(hql);
        if (param != null && param.size() > 0) {
            for (int i = 0; i < param.size(); i++) {
                q.setParameter(i, param.get(i));
            }
        }
        return q.executeUpdate();
    }


//    /**
//     * 通过id获取实体对象
//     */
//    @SuppressWarnings("cast")
//    public T get(ID id) {
//        log.debug("通过id获取实体对象:id=" + id);
//        try {
//            return this.getHibernateTemplate().get(this.getPersistentClass(), id);
//        } catch (IllegalArgumentException e) {
//            return null;
//        }
//    }

//    /**
//     * 列出数据库中所有实体对象
//     */
//    public List<T> findAll() {
//        log.debug("列出数据库中所有实体对象");
//        List<T> list = this.getHibernateTemplate().loadAll(this.getPersistentClass());
//        org.hibernate.Hibernate.initialize(list);
//        return list;
//    }

//    /**
//     * 通过表中字段查询
//     *
//     * @param propertyName 字段名
//     * @param value        字段值
//     * @return
//     */
//    @SuppressWarnings({"unchecked", "rawtypes"})
//    public List<T> findByPropertyFuzzy(String propertyName, Object value) {
//        log.debug("通过表中字段: " + propertyName + ",值: " + value + "来查询");
//        Session session = this.getSessionFactory().openSession();
//        try {
//            String queryString = "from " + getTableName() + " as model where model." + propertyName + "= ?";
//            Query queryObject = session.createQuery(queryString);
//            queryObject.setParameter(0, value);
//            log.debug(queryString);
//            return queryObject.list();
//        } catch (RuntimeException re) {
//            log.error("按字段查询失败", re);
//            re.printStackTrace();
//            throw re;
//        } finally {
//            session.close();
//        }
//    }

//    @SuppressWarnings({"unchecked", "rawtypes"})
//    public List<T> findByPropertyFuzzy(String propertyName, Object value, int firstResult, int size) {
//        log.debug("用字段: " + propertyName + ",值: " + value + "查询");
//        Session session = this.getSessionFactory().openSession();
//        try {
//            String queryString = "from " + getTableName() + " as model ";
//            if (value != null) {
//                queryString += " where model." + propertyName + " = ?";
//            }
//            Query queryObject = session.createQuery(queryString);
//            queryObject.setFirstResult(firstResult);
//            queryObject.setMaxResults(size);
//            if (value != null) {
//                queryObject.setParameter(0, value);
//            }
//            log.debug(queryString);
//            return queryObject.list();
//        } catch (RuntimeException re) {
//            log.error("按字段查询失败", re);
//            System.err.println(re);
//            throw re;
//        } finally {
//            session.close();
//        }
//    }

//    private DetachedCriteria criteria;
//
//    private void sortIt(String sort) {
//        if (null != sort) {
//            if (!"".equals(sort.trim())) {
//                if ("-".equals(sort.substring(0, 1))) {
//                    this.criteria.addOrder(Order.desc(sort.substring(1)));
//                } else {
//                    this.criteria.addOrder(Order.asc(sort));
//                }
//            }
//        }
//    }
//
//    private void argsIt(Map<String, Object> args) {
//        if (null != args && !args.isEmpty()) {
//            String field;
//            Object value;
//            for (String s : args.keySet()) {
//                field = s;
//                value = args.get(field);
//                if (value instanceof String) {
//                    if (!("null".equals(((String) value).trim().toLowerCase()) || "".equals(((String) value).trim())
//                            || "*".equals(((String) value).trim()) || "%".equals(((String) value).trim())
//                            || "?".equals(((String) value).trim())))
//                        this.criteria.add(Restrictions.like(field, "%" + value + "%"));
//                } else if (value instanceof Criterion)
//                    this.criteria.add((Criterion) value);
//                else
//                    this.criteria.add(Restrictions.eq(field, value));
//            }
//        }
//    }
//
//    @SuppressWarnings("unchecked")
//    @Override
//    public List<T> findRows(Map<String, Object> args, String sort) {
//        this.criteria = DetachedCriteria.forClass(this.getPersistentClass());
//        sortIt(sort);
//        argsIt(args);
//        return (List<T>) getHibernateTemplate().findByCriteria(this.criteria);
//    }
//
//    @SuppressWarnings("unchecked")
//    @Override
//    public List<T> findRows(Map<String, Object> args, String sort, Integer start, Integer pagesize) {
//        this.criteria = DetachedCriteria.forClass(this.getPersistentClass());
//        sortIt(sort);
//        argsIt(args);
//        if (null != start || null != pagesize) {
//            if (null != pagesize && pagesize.intValue() > 0) {
//                if (null == start || start.intValue() < 0)
//                    start = 0;
//                return (List<T>) getHibernateTemplate().findByCriteria(this.criteria, start, pagesize);
//            } else {
//                return (List<T>) getHibernateTemplate().findByCriteria(this.criteria);
//            }
//        } else {
//            return (List<T>) getHibernateTemplate().findByCriteria(this.criteria);
//        }
//    }
//
//    /**
//     * 根据参数获取记录数
//     */
//    @Override
//    public int findRowsCount(Map<String, Object> args) {
//        this.criteria = DetachedCriteria.forClass(this.getPersistentClass());
//        argsIt(args);
//        this.criteria.setProjection(Projections.rowCount());
//        return (Integer) getHibernateTemplate().findByCriteria(this.criteria).get(0);
//
//    }
//
//    /**
//     * 通过直接执行HQL语句来完成数据操作
//     */
//    @SuppressWarnings({"unchecked", "rawtypes"})
//    public void executeHQL(final String hql, final boolean isHql) {
//        Object o = this.getHibernateTemplate().execute((HibernateCallback) (Session session) -> {
//            Query query = isHql ? session.createQuery(hql) : session.createNativeQuery(hql);
//            query.executeUpdate();
//            return null;
//        });
//    }
//
//    @SuppressWarnings({"unchecked", "rawtypes"})
//    @Override
//    public void executeHQL(final String hql, final boolean isHql, final Map<String, Object> args) {
//        Object o = this.getHibernateTemplate().execute((HibernateCallback) (Session session) -> {
//            Query query = isHql ? session.createQuery(hql) : session.createNativeQuery(hql);
//            String arg;
//            Object value;
//            for (String s : args.keySet()) {
//                arg = s;
//                value = args.get(arg);
//                if (value instanceof String)
//                    query.setParameter(arg, value);
//                if (value instanceof Boolean)
//                    query.setParameter(arg, value);
//                if (value instanceof Integer)
//                    query.setParameter(arg, value);
//                if (value instanceof Long)
//                    query.setParameter(arg, value);
//                if (value instanceof Date)
//                    query.setParameter(arg, value);
//            }
//            query.executeUpdate();
//            return null;
//        });
//    }


}
