package domain;

import java.util.HashSet;
import java.util.Set;

public class CstCustomerEntity {
    private Long cust_id;

    private String cust_name;
//    private String cust_source;
//    private String cust_industry;
//    private String cust_level;
    private String cust_linkman;
    private String cust_phone;
    private String cust_mobile;

    // 引用关联的数据字典对象
    private BaseDict cust_source;
    private BaseDict cust_industry;
    private BaseDict cust_level;

    public Long getCust_id() {
        return cust_id;
    }

    public void setCust_id(Long cust_id) {
        this.cust_id = cust_id;
    }

    public String getCust_name() {
        return cust_name;
    }

    public void setCust_name(String cust_name) {
        this.cust_name = cust_name;
    }

    public BaseDict getCust_source() {
        return cust_source;
    }

    public void setCust_source(BaseDict cust_source) {
        this.cust_source = cust_source;
    }

    public BaseDict getCust_industry() {
        return cust_industry;
    }

    public void setCust_industry(BaseDict cust_industry) {
        this.cust_industry = cust_industry;
    }

    public BaseDict getCust_level() {
        return cust_level;
    }

    public void setCust_level(BaseDict cust_level) {
        this.cust_level = cust_level;
    }

    public String getCust_linkman() {
        return cust_linkman;
    }

    public void setCust_linkman(String cust_linkman) {
        this.cust_linkman = cust_linkman;
    }

    public String getCust_phone() {
        return cust_phone;
    }

    public void setCust_phone(String cust_phone) {
        this.cust_phone = cust_phone;
    }

    public String getCust_mobile() {
        return cust_mobile;
    }

    public void setCust_mobile(String cust_mobile) {
        this.cust_mobile = cust_mobile;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cust_id=" + cust_id +
                ", cust_name='" + cust_name + '\'' +
                ", cust_source='" + cust_source + '\'' +
                ", cust_industry='" + cust_industry + '\'' +
                ", cust_level='" + cust_level + '\'' +
                ", cust_linkman='" + cust_linkman + '\'' +
                ", cust_phone='" + cust_phone + '\'' +
                ", cust_mobile='" + cust_mobile + '\'' +
                '}';
    }


    private Set<LinkMan> linkMens = new HashSet<LinkMan>();

    public Set<LinkMan> getLinkMens() {
        return linkMens;
    }

    public void setLinkMens(Set<LinkMan> linkMens) {
        this.linkMens = linkMens;
    }


}
