package com.example.groupalram;

import android.provider.BaseColumns;

public class DataBase {
    //데이터베이스 호출 시 사용될 생성자
    public static final class CreateDB implements BaseColumns {

        public static final String GROUP_COLUMN_NAME = "NAME";
        public static final String GROUP_COLUMN_ACTIVE = "ACTIVE";
        public static final String _GRTABLENAME = "GROUP";
        public static final String _GROUPCREATE =
                "CREATE TABLE IF NOT EXISTS " + _GRTABLENAME + "("
                        + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                        + GROUP_COLUMN_NAME + " TEXT NOT NULL, "
                        + GROUP_COLUMN_ACTIVE + " INTEGER NOT NULL DEFAULT 1);";


        public static final String ALRAM_COLUMN_NAME = "NAME";
        public static final String ALRAM_COLUMN_TIME = "TIME";
        public static final String ALRAM_COLUMN_GRNUM = "GR_NUM";
        public static final String ALRAM_COLUMN_ACTIVE = "ACTIVE";
        public static final String ALRAM_COLUMN_REPEAT = "REPEAT";
        public static final String ALRAM_COLUMN_REALRAM = "REALRAM";
        public static final String ALRAM_COLUMN_BELL = "BELL";
        public static final String ALRAM_COLUMN_OPT = "OPT";
        public static final String _ALRAMTABLENAME = "ALRAM";
        public static final String _ALRAMCREATE =
                "CREATE TABLE IF NOT EXISTS " + _ALRAMTABLENAME + "("
                        + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                        + ALRAM_COLUMN_NAME + " TEXT NOT NULL, "
                        + ALRAM_COLUMN_TIME + " TEXT NOT NULL, "
                        + ALRAM_COLUMN_GRNUM + " INTEGER, "
                        + ALRAM_COLUMN_ACTIVE + " INTEGER NOT NULL DEFAULT 1 "
                        + ALRAM_COLUMN_REPEAT + " TEXT, "
                        + ALRAM_COLUMN_REALRAM + " TEXT, "
                        + ALRAM_COLUMN_BELL + " TEXT NOT NULL, "
                        + ALRAM_COLUMN_OPT + " TEXT);";

    }

}
