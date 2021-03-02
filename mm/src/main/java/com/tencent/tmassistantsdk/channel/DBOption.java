package com.tencent.tmassistantsdk.channel;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;

public class DBOption {
    protected static final String CREATE_TABLE_SQL = "CREATE TABLE if not exists channeldata( itemId INTEGER PRIMARY KEY AUTOINCREMENT, itemData BLOB);";
    protected static final int DATEBASE_VERSION = 1;
    protected static final String DB_NAME = ".SystemConfig.db";
    protected static final String QUERY_ALL_SQL = "select * from channeldata";
    protected static final String TABLE_NAME = "channeldata";
    protected String DB_PATH;

    public DBOption() {
        AppMethodBeat.i(101853);
        this.DB_PATH = "";
        this.DB_PATH = b.aKJ() + "/assistant/";
        new o(this.DB_PATH).mkdirs();
        this.DB_PATH += DB_NAME;
        AppMethodBeat.o(101853);
    }

    public long insert(TMAssistantSDKChannelDataItem tMAssistantSDKChannelDataItem) {
        SQLiteDatabase writableDatabase;
        AppMethodBeat.i(101854);
        if (tMAssistantSDKChannelDataItem == null) {
            AppMethodBeat.o(101854);
            return -1;
        }
        byte[] buffer = tMAssistantSDKChannelDataItem.getBuffer();
        if (buffer == null || (writableDatabase = getWritableDatabase()) == null) {
            AppMethodBeat.o(101854);
            return -1;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("itemData", buffer);
        long insert = writableDatabase.insert(TABLE_NAME, "", contentValues);
        closeDB(writableDatabase);
        AppMethodBeat.o(101854);
        return insert;
    }

    public boolean delete(long j2) {
        AppMethodBeat.i(101855);
        SQLiteDatabase writableDatabase = getWritableDatabase();
        if (writableDatabase != null) {
            writableDatabase.delete(TABLE_NAME, "itemId=?", new String[]{String.valueOf(j2)});
            closeDB(writableDatabase);
            AppMethodBeat.o(101855);
            return true;
        }
        AppMethodBeat.o(101855);
        return false;
    }

    public ArrayList<TMAssistantSDKChannelDataItem> queryAll() {
        ArrayList<TMAssistantSDKChannelDataItem> arrayList = null;
        AppMethodBeat.i(101856);
        SQLiteDatabase readableDatabase = getReadableDatabase();
        if (readableDatabase != null) {
            Cursor rawQuery = readableDatabase.rawQuery(QUERY_ALL_SQL, null);
            if (rawQuery != null && rawQuery.moveToFirst()) {
                int columnIndex = rawQuery.getColumnIndex("itemId");
                int columnIndex2 = rawQuery.getColumnIndex("itemData");
                arrayList = new ArrayList<>();
                do {
                    int i2 = rawQuery.getInt(columnIndex);
                    TMAssistantSDKChannelDataItem dataItemFromByte = TMAssistantSDKChannelDataItem.getDataItemFromByte(rawQuery.getBlob(columnIndex2));
                    if (dataItemFromByte != null) {
                        dataItemFromByte.mDBIdentity = i2;
                        arrayList.add(dataItemFromByte);
                    }
                } while (rawQuery.moveToNext());
                closeDB(readableDatabase);
            }
            rawQuery.close();
            closeDB(readableDatabase);
            AppMethodBeat.o(101856);
        } else {
            AppMethodBeat.o(101856);
        }
        return arrayList;
    }

    private SQLiteDatabase getWritableDatabase() {
        SQLiteDatabase sQLiteDatabase = null;
        AppMethodBeat.i(101857);
        int i2 = 0;
        while (true) {
            if (i2 >= 20) {
                break;
            }
            try {
                sQLiteDatabase = SQLiteDatabase.openOrCreateDatabase(s.k(this.DB_PATH, true), (SQLiteDatabase.CursorFactory) null);
            } catch (SQLiteException e2) {
            }
            if (sQLiteDatabase != null) {
                checkAndCreateTable(sQLiteDatabase);
                break;
            }
            SystemClock.sleep(50);
            i2++;
        }
        AppMethodBeat.o(101857);
        return sQLiteDatabase;
    }

    private synchronized SQLiteDatabase getReadableDatabase() {
        SQLiteDatabase sQLiteDatabase = null;
        synchronized (this) {
            AppMethodBeat.i(101858);
            if (!new o(this.DB_PATH).exists()) {
                AppMethodBeat.o(101858);
            } else {
                for (int i2 = 0; i2 < 20; i2++) {
                    try {
                        sQLiteDatabase = SQLiteDatabase.openDatabase(s.k(this.DB_PATH, true), null, 1);
                    } catch (SQLiteException e2) {
                    }
                    if (sQLiteDatabase != null) {
                        break;
                    }
                    SystemClock.sleep(50);
                }
                AppMethodBeat.o(101858);
            }
        }
        return sQLiteDatabase;
    }

    private void closeDB(SQLiteDatabase sQLiteDatabase) {
        AppMethodBeat.i(101859);
        if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
            try {
                sQLiteDatabase.close();
                AppMethodBeat.o(101859);
                return;
            } catch (Exception e2) {
            }
        }
        AppMethodBeat.o(101859);
    }

    private void checkAndCreateTable(SQLiteDatabase sQLiteDatabase) {
        AppMethodBeat.i(101860);
        int version = sQLiteDatabase.getVersion();
        if (version != 1) {
            sQLiteDatabase.beginTransaction();
            if (version == 0) {
                try {
                    sQLiteDatabase.execSQL(CREATE_TABLE_SQL);
                } catch (Throwable th) {
                    sQLiteDatabase.endTransaction();
                    AppMethodBeat.o(101860);
                    throw th;
                }
            }
            sQLiteDatabase.setVersion(1);
            sQLiteDatabase.setTransactionSuccessful();
            sQLiteDatabase.endTransaction();
            AppMethodBeat.o(101860);
            return;
        }
        AppMethodBeat.o(101860);
    }
}
