package com.iyaselerehoboth.theelements.data.room.dao;

import androidx.room.Dao;
import androidx.room.Insert;

import com.iyaselerehoboth.theelements.data.room.tables.Elements;

import java.util.List;

@Dao
public interface ElementsDAO {

    @Insert()
    void insertElements(List<Elements> elements);


}
