package service.impl;

import dao.CustomerDao;
import domain.CstCustomerEntity;
import org.hibernate.criterion.DetachedCriteria;
import service.CustomerService;
import utils.PageBean;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {

    private CustomerDao cd;

    @Override
    public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
        // 1. 调用dao查询总记录数
        int totalCount = cd.getTotalCount(dc);
        // 2. 创建PageBean对象
        PageBean pb = new PageBean(currentPage, totalCount, pageSize);
        // 3. 掉用dao查询分页列表数据
        List<CstCustomerEntity> list = cd.getPageList(dc, pb.getStart(), pb.getPageSize());
        // 4. 列表数据放入pageBean中，并返回
        pb.setList(list);
        return pb;
    }


    public void setCd(CustomerDao cd) {
        this.cd = cd;
    }
}
