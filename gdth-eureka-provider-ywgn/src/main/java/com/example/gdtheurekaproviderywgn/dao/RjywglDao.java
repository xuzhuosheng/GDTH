package com.example.gdtheurekaproviderywgn.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository ("rjywglDao")
public interface RjywglDao {
    void insertRjywjl(@Param ("title") String title, @Param ("type") String type, @Param ("content") String content,
                      @Param ("scripttxt") String scripttxt, @Param ("bz") String bz,
                      @Param ("creator") String creator);
}
