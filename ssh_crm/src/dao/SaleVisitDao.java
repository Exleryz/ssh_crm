package dao;

import domain.SaleVisit;

public interface SaleVisitDao extends BaseDao<SaleVisit> {
    void saveOrUpdate(SaleVisit saleVisit);
}
