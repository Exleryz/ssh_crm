package dao;

import org.hibernate.criterion.DetachedCriteria;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T> {

    // 增
    void save(T t);

    // 删 对象
    void delete(T t);

    // 删 id 能作为id的都是他的实现类
    void delete(Serializable id);

    // 改
    void update(T t);

    // 查
    T getById(Serializable id);

    // 查 符合条件的总记录数
    Integer getTotalCount(DetachedCriteria dc);

    // 查 分页列表
    List<T> getPageList(DetachedCriteria dc, Integer start, Integer pageSize);

}
