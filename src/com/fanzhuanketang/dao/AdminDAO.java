package com.fanzhuanketang.dao;

import java.util.List;

import com.fanzhuanketang.po.Admin;

public interface AdminDAO {
    List<Admin> selectAll();
    Admin selectByAccount(String account);
}
