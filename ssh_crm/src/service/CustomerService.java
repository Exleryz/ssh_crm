package service;

import domain.CstCustomerEntity;
import org.hibernate.criterion.DetachedCriteria;
import utils.PageBean;

import java.util.List;

public interface CustomerService {
    // 分页业务方法
    PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);

    // 保存客户
    void save(CstCustomerEntity customer);

    CstCustomerEntity getById(Long cust_id);

    // 获得客户统计记录
    List<Object[]> getIndustryCount();
}
