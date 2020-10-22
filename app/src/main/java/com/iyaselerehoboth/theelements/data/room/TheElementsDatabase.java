package com.iyaselerehoboth.theelements.data.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.iyaselerehoboth.theelements.data.room.dao.ElementsDAO;
import com.iyaselerehoboth.theelements.data.room.tables.Elements;

@Database(entities = {Elements.class}, version = 1, exportSchema = false)
public abstract class TheElementsDatabase extends RoomDatabase {
    private static TheElementsDatabase INSTANCE;

    public static TheElementsDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context,
                    TheElementsDatabase.class, "the_elements.db")
                    .createFromAsset("database/periodic_elements.db")
                    .allowMainThreadQueries()
                    .build();
        }

        return INSTANCE;
    }

    public abstract ElementsDAO getElementsDao();

    public static void destroyInstance() {
        INSTANCE = null;
    }
}
