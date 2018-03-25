package service;

import domain.LinkMan;
import org.hibernate.criterion.DetachedCriteria;
import utils.PageBean;

public interface LinkManService {

    // 分页业务方法
    PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);

    void save(LinkMan linkMan);
}
