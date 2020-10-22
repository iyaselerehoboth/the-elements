package com.iyaselerehoboth.theelements.data.room.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.iyaselerehoboth.theelements.data.room.tables.Elements;

import java.util.List;

@Dao
public interface ElementsDAO {

    @Insert()
    void insertElements(List<Elements> elements);

    @Query("SELECT DISTINCT COALESCE(block, 'Others') FROM elements")
    List<String> getSubBlockCategories();

    @Query("SELECT DISTINCT COALESCE(bonding_type, 'Others') FROM elements")
    List<String> getSubBondingTypeCategories();

    @Query("SELECT DISTINCT COALESCE(crystal_structure, 'Others') FROM elements")
    List<String> getSubCrystalStructureCategories();

    @Query("SELECT DISTINCT COALESCE(group_block, 'Others') FROM elements")
    List<String> getSubGroupBlockCategories();

    @Query("SELECT DISTINCT COALESCE(magnetic_ordering, 'Others') FROM elements")
    List<String> getSubMagneticCategories();

    @Query("SELECT DISTINCT COALESCE(period, 'Others') FROM elements")
    List<String> getSubPeriodCategories();

    @Query("SELECT * FROM elements")
    LiveData<List<Elements>> getAllElements();
}
