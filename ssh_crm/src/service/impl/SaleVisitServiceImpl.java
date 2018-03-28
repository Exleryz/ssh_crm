package service.impl;

import dao.SaleVisitDao;
import domain.CstCustomerEntity;
import domain.SaleVisit;
import org.hibernate.criterion.DetachedCriteria;
import service.SaleVisitService;
import utils.PageBean;

import java.util.List;
import java.util.UUID;

public class SaleVisitServiceImpl implements SaleVisitService {

    private SaleVisitDao svd;

    @Override
    public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
        // 1. 调用dao查询总记录数
        int totalCount = svd.getTotalCount(dc);
        // 2. 创建PageBean对象
        PageBean pb = new PageBean(currentPage, totalCount, pageSize);
        // 3. 掉用dao查询分页列表数据
        List<SaleVisit> list = svd.getPageList(dc, pb.getStart(), pb.getPageSize());
        // 4. 列表数据放入pageBean中，并返回
        pb.setList(list);
        return pb;
    }


    @Override
    public void save(SaleVisit saleVisit) {
//            String id = UUID.randomUUID().toString();
//            saleVisit.setVisit_id(id);
//        System.out.println(saleVisit);

        if (saleVisit.getVisit_id().isEmpty()) {
            svd.update(saleVisit);
        } else {
            svd.save(saleVisit);    // 单独保存出错  org.springframework.orm.hibernate5.HibernateOptimisticLockingFailureException: Batch update returned unexpected row count from update [0]; actual row count: 0; expected: 1; nested exception is org.hibernate.StaleStateException: Batch update returned unexpected row count from update [0]; actual row count: 0; expected: 1
        }
    }

    @Override
    public SaleVisit getById(String visit_id) {
        return svd.getById(visit_id);
    }

    public void setSvd(SaleVisitDao svd) {
        this.svd = svd;
    }
}
