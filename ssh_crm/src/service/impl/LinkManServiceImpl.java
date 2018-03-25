package service.impl;

import dao.LinkManDao;
import domain.LinkMan;
import service.LinkManService;

public class LinkManServiceImpl implements LinkManService {

    LinkManDao lmd;

    @Override
    public void save(LinkMan linkMan) {
        lmd.save(linkMan);
    }

    public void setLmd(LinkManDao lmd) {
        this.lmd = lmd;
    }
}
