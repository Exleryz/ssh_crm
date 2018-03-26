package service;

import domain.LinkMan;
import org.hibernate.criterion.DetachedCriteria;
import utils.PageBean;

public interface LinkManService {

    // 分页业务方法
    PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);

    void save(LinkMan linkMan);

    // 根据id获得LinkMan对象
    LinkMan getById(Long lkm_id);
}
