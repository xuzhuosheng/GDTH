package com.example.gdtheurekaproviderutil.service.impl;

import com.example.gdtheurekaproviderutil.dao.WxUserDao;
import com.example.gdtheurekaproviderutil.service.WxUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository("wxUserService")
public class WxUserServiceImpl implements WxUserService {


    @Autowired
    WxUserDao wxUserDao;

}
