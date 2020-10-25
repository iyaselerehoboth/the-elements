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

    @Query("SELECT * FROM elements WHERE block = :subCategory")
    List<Elements> getSubElementsBlocks(String subCategory);

    @Query("SELECT * FROM elements WHERE bonding_type = :subCategory")
    List<Elements> getSubElementsBondingType(String subCategory);

    @Query("SELECT * FROM elements WHERE crystal_structure = :subCategory")
    List<Elements> getSubElementsCrystalStructure(String subCategory);

    @Query("SELECT * FROM elements WHERE group_block = :subCategory")
    List<Elements> getSubElementsGroupBlock(String subCategory);

    @Query("SELECT * FROM elements WHERE magnetic_ordering = :subCategory")
    List<Elements> getSubElementsMagnetic(String subCategory);

    @Query("SELECT * FROM elements WHERE period = :subCategory")
    List<Elements> getSubElementsPeriod(String subCategory);

    @Query("SELECT * FROM elements WHERE period ISNULL")
    List<Elements> getSubElementsPeriodNull();

    @Query("SELECT * FROM elements WHERE block ISNULL")
    List<Elements> getSubElementsBlocksNull();

    @Query("SELECT * FROM elements WHERE bonding_type ISNULL")
    List<Elements> getSubElementsBondingTypeNUll();

    @Query("SELECT * FROM elements WHERE crystal_structure ISNULL")
    List<Elements> getSubElementsCrystalStructureNull();

    @Query("SELECT * FROM elements WHERE group_block ISNULL")
    List<Elements> getSubElementsGroupBlockNull();

    @Query("SELECT * FROM elements WHERE magnetic_ordering ISNULL")
    List<Elements> getSubElementsMagneticNull();
}
