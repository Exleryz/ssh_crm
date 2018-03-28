package dao;


import domain.CstCustomerEntity;

import java.util.List;

public interface CustomerDao extends BaseDao<CstCustomerEntity>{
    // 按照行业统计客户数量
    List<Object[]> getIndustryCount();

}
