package com.example.gdtheurekaproviderywgn.dao;

import com.example.gdtheurekaproviderywgn.entity.Rjywgl;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository ("rjywglDao")
public interface RjywglDao {
    void insertRjywjl(@Param ("title") String title, @Param ("type") String type, @Param ("content") String content,
                      @Param ("scripttxt") String scripttxt, @Param ("bz") String bz,
                      @Param ("creator") String creator);

    List<Rjywgl> getData(@Param ("searchContent") String searchContent, @Param ("selectType") String selectType);
}
