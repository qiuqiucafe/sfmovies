package com.connie.sfmovies.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.connie.sfmovies.dto.Sfmovie;
import com.connie.sfmovies.dto.SfmovieExample;
import com.connie.sfmovies.page.PageCondition;

public interface SfmovieMapper {
    int countByExample(SfmovieExample example);

    int deleteByExample(SfmovieExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Sfmovie record);

    int insertSelective(Sfmovie record);

    List<Sfmovie> selectByExample(SfmovieExample example);

    Sfmovie selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Sfmovie record, @Param("example") SfmovieExample example);

    int updateByExample(@Param("record") Sfmovie record, @Param("example") SfmovieExample example);

    int updateByPrimaryKeySelective(Sfmovie record);

    int updateByPrimaryKey(Sfmovie record);
    
    List<Sfmovie> queryByPage(@Param("Sfmovie") Sfmovie sfmovie,@Param("page") PageCondition page);
}