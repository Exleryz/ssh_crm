package dao.impl;

import dao.UserDao;
import domain.User;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {
    @Override
    public User getByUserCode(final String usercode) {
        // HQL
        /*return getHibernateTemplate().execute(new HibernateCallback<User>() {
            @Override
            public User doInHibernate(Session session) throws HibernateException {
                String hql = "from User where user_code = ?";
                Query query = session.createQuery(hql);
                query.setParameter(0, usercode);
                return (User) query.uniqueResult();
            }
        });*/
        //Criteria
        DetachedCriteria dc = DetachedCriteria.forClass(User.class);
        System.out.println("usercode:" + usercode);
        dc.add(Restrictions.eq("user_code", usercode));
        List<User> list = (List<User>) getHibernateTemplate().findByCriteria(dc);
        if (list != null && list.size() > 0) {
            System.out.println("0");
            return list.get(0);
        } else {
            System.out.println("null");
            return null;
        }
    }

}
