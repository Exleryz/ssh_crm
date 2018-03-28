package domain;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SaleVisit {
    private String visit_id;
    private String visit_interviewee;
    private String visit_addr;
    private String visit_detail;
    private Date visit_time;
    private Date visit_nexttime;
    // 表达所属客户对象
    private CstCustomerEntity customer;
    // 表达所属用户对象
    private User user;

    public String getVisit_id() {
        return visit_id;
    }

    public void setVisit_id(String visit_id) {
        this.visit_id = visit_id;
    }

    public String getVisit_interviewee() {
        return visit_interviewee;
    }

    public void setVisit_interviewee(String visit_interviewee) {
        this.visit_interviewee = visit_interviewee;
    }

    public String getVisit_addr() {
        return visit_addr;
    }

    public void setVisit_addr(String visit_addr) {
        this.visit_addr = visit_addr;
    }

    public String getVisit_detail() {
        return visit_detail;
    }

    public void setVisit_detail(String visit_detail) {
        this.visit_detail = visit_detail;
    }

    public Date getVisit_time() {
        return visit_time;
    }

    public String getVisit_time_s() {
        return transferDate(visit_time, "yyyy年MM月dd日");
    }

    public void setVisit_time(Date visit_time) {
        this.visit_time = visit_time;
    }

    public Date getVisit_nexttime() {
        return visit_nexttime;
    }

    public String getVisit_nexttime_s() {
        return transferDate(visit_nexttime, "yyyy年MM月dd日");
    }

    public void setVisit_nexttime(Date visit_nexttime) {
        this.visit_nexttime = visit_nexttime;
    }


    public static String transferDate(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }


    public CstCustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CstCustomerEntity customer) {
        this.customer = customer;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "SaleVisit{" +
                "visit_id='" + visit_id + '\'' +
                ", visit_interviewee='" + visit_interviewee + '\'' +
                ", visit_addr='" + visit_addr + '\'' +
                ", visit_detail='" + visit_detail + '\'' +
                ", visit_time=" + visit_time +
                ", visit_nexttime=" + visit_nexttime +
                ", customer=" + customer +
                ", user=" + user +
                '}';
    }
}
