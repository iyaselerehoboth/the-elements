package com.iyaselerehoboth.theelements.data;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManager {

    private static final String KEY_FILTER_CATEGORY = "filter_category";

    private static final String PREF_NAME = "TheElements Preferences";
    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    Context mCtx;
    int PRIVATE_MODE = 0;

    public SessionManager(Context mCtx) {
        this.mCtx = mCtx;
        prefs = mCtx.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = prefs.edit();
    }

    /**
     * ============================================================================
     * KEEP ALL SESSION GETTERS BELOW THIS LINE
     * ============================================================================
     */

    public String GET_FILTER_CATEGORY() {
        return prefs.getString(KEY_FILTER_CATEGORY, "");
    }

    /**
     * ============================================================================
     * KEEP ALL SESSION SETTERS BELOW THIS LINE
     * ============================================================================
     */

    public void SET_FILTER_CATEGORY(String value) {
        editor.putString(KEY_FILTER_CATEGORY, value).commit();
    }
}