package service;

import domain.SaleVisit;
import org.hibernate.criterion.DetachedCriteria;
import utils.PageBean;

public interface SaleVisitService {

    // 分页业务方法
    PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);


    void save(SaleVisit saleVisit);

    SaleVisit getById(String visit_id);
}
