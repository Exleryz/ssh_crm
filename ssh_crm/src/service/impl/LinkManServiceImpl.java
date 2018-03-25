package service.impl;

import dao.LinkManDao;
import domain.LinkMan;
import org.hibernate.criterion.DetachedCriteria;
import service.LinkManService;
import utils.PageBean;

import java.util.List;

public class LinkManServiceImpl implements LinkManService {

    LinkManDao lmd;

    @Override
    public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
        // 1. 调用dao查询总记录数
        int totalCount = lmd.getTotalCount(dc);
        // 2. 创建PageBean对象
        PageBean pb = new PageBean(currentPage, totalCount, pageSize);
        // 3. 掉用dao查询分页列表数据
        List<LinkMan> list = lmd.getPageList(dc, pb.getStart(), pb.getPageSize());
        // 4. 列表数据放入pageBean中，并返回
        pb.setList(list);
        return pb;
    }

    @Override
    public void save(LinkMan linkMan) {
        lmd.save(linkMan);
    }

    public void setLmd(LinkManDao lmd) {
        this.lmd = lmd;
    }
}
