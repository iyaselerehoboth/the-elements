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

    @Query("SELECT DISTINCT COALESCE(block, 'Others') FROM elements ORDER BY atomic_number")
    List<String> getSubBlockCategories();

    @Query("SELECT DISTINCT COALESCE(bonding_type, 'Others') FROM elements ORDER BY bonding_type")
    List<String> getSubBondingTypeCategories();

    @Query("SELECT DISTINCT COALESCE(crystal_structure, 'Others') FROM elements ORDER BY crystal_structure")
    List<String> getSubCrystalStructureCategories();

    @Query("SELECT DISTINCT COALESCE(group_block, 'Others') FROM elements ORDER BY group_block")
    List<String> getSubGroupBlockCategories();

    @Query("SELECT DISTINCT COALESCE(magnetic_ordering, 'Others') FROM elements ORDER BY magnetic_ordering")
    List<String> getSubMagneticCategories();

    @Query("SELECT DISTINCT COALESCE(period, 'Others') FROM elements ORDER BY period")
    List<String> getSubPeriodCategories();

    @Query("SELECT * FROM elements")
    LiveData<List<Elements>> getAllElements();

    @Query("SELECT * FROM elements WHERE block = :subCategory ORDER BY atomic_number")
    List<Elements> getSubElementsBlocks(String subCategory);

    @Query("SELECT * FROM elements WHERE bonding_type = :subCategory ORDER BY atomic_number")
    List<Elements> getSubElementsBondingType(String subCategory);

    @Query("SELECT * FROM elements WHERE crystal_structure = :subCategory ORDER BY atomic_number")
    List<Elements> getSubElementsCrystalStructure(String subCategory);

    @Query("SELECT * FROM elements WHERE group_block = :subCategory ORDER BY atomic_number")
    List<Elements> getSubElementsGroupBlock(String subCategory);

    @Query("SELECT * FROM elements WHERE magnetic_ordering = :subCategory ORDER BY atomic_number")
    List<Elements> getSubElementsMagnetic(String subCategory);

    @Query("SELECT * FROM elements WHERE period = :subCategory ORDER BY atomic_number")
    List<Elements> getSubElementsPeriod(String subCategory);

    @Query("SELECT * FROM elements WHERE period ISNULL ORDER BY atomic_number")
    List<Elements> getSubElementsPeriodNull();

    @Query("SELECT * FROM elements WHERE block ISNULL ORDER BY atomic_number")
    List<Elements> getSubElementsBlocksNull();

    @Query("SELECT * FROM elements WHERE bonding_type ISNULL ORDER BY atomic_number")
    List<Elements> getSubElementsBondingTypeNUll();

    @Query("SELECT * FROM elements WHERE crystal_structure ISNULL ORDER BY atomic_number")
    List<Elements> getSubElementsCrystalStructureNull();

    @Query("SELECT * FROM elements WHERE group_block ISNULL ORDER BY atomic_number")
    List<Elements> getSubElementsGroupBlockNull();

    @Query("SELECT * FROM elements WHERE magnetic_ordering ISNULL ORDER BY atomic_number")
    List<Elements> getSubElementsMagneticNull();

    @Query("SELECT * FROM elements WHERE atomic_number = :atomicNo ORDER BY atomic_number")
    Elements getElementDetails(Integer atomicNo);
}
