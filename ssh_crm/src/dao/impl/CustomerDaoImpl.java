package dao.impl;

import dao.CustomerDao;
import domain.CstCustomerEntity;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

public class CustomerDaoImpl extends BaseDaoImpl<CstCustomerEntity> implements CustomerDao {

    @Override
    public List<Object[]> getIndustryCount() {
        // 原生sql查询
        List<Object[]> list = getHibernateTemplate().execute(new HibernateCallback<List>() {
            @Override
            public List doInHibernate(Session session) throws HibernateException {
                String sql = "SELECT bd.dict_item_name, count(*) total" +
                        " FROM cst_customer c, base_dict bd" +
                        " WHERE c.cust_industry = bd.dict_id" +
                        " GROUP BY cust_industry;";
                SQLQuery sqlQuery = session.createSQLQuery(sql);

                return sqlQuery.list();
            }
        });

        return list;
    }
}
