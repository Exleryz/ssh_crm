package dao.impl;

import dao.CustomerDao;
import domain.CstCustomerEntity;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

public class CustomerDaoImpl extends BaseDaoImpl<CstCustomerEntity> implements CustomerDao {

}
