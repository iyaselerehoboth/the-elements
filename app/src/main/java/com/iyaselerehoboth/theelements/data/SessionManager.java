package com.iyaselerehoboth.theelements.data;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManager {

    private static final String KEY_FILTER_CATEGORY = "filter_category";
    private static final String KEY_FILTER_SUB_CATEGORY = "filter_sub_category";
    private static final String KEY_SELECTED_ELEMENT = "selected_element";

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

    public String GET_FILTER_SUB_CATEGORY() {
        return prefs.getString(KEY_FILTER_SUB_CATEGORY, "");
    }

    public String GET_SELECTED_ELEMENT() {
        return prefs.getString(KEY_SELECTED_ELEMENT, "");
    }

    /**
     * ============================================================================
     * KEEP ALL SESSION SETTERS BELOW THIS LINE
     * ============================================================================
     */

    public void SET_FILTER_CATEGORY(String value) {
        editor.putString(KEY_FILTER_CATEGORY, value).commit();
    }

    public void SET_FILTER_SUB_CATEGORY(String value) {
        editor.putString(KEY_FILTER_SUB_CATEGORY, value).commit();
    }

    public void SET_SELECTED_ELEMENT(String value) {
        editor.putString(KEY_SELECTED_ELEMENT, value).commit();
    }
}