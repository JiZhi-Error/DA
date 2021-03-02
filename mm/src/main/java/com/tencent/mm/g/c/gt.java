package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public abstract class gt extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fLh = "roomname".hashCode();
    private static final int gbH = "newStoryList".hashCode();
    private static final int gbI = "extbuf".hashCode();
    private static final int gbJ = "nextSyncTime".hashCode();
    private static final int gbq = "userStoryFlag".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private boolean fKW = true;
    public byte[] field_extbuf;
    public String field_newStoryList;
    public long field_nextSyncTime;
    public String field_roomname;
    public int field_userStoryFlag;
    private boolean gbE = true;
    private boolean gbF = true;
    private boolean gbG = true;
    private boolean gbc = true;

    public static IAutoDBItem.MAutoDBInfo ajs() {
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[5];
        mAutoDBInfo.columns = new String[6];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "roomname";
        mAutoDBInfo.colsMap.put("roomname", "TEXT default ''  PRIMARY KEY ");
        sb.append(" roomname TEXT default ''  PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "roomname";
        mAutoDBInfo.columns[1] = "userStoryFlag";
        mAutoDBInfo.colsMap.put("userStoryFlag", "INTEGER");
        sb.append(" userStoryFlag INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "newStoryList";
        mAutoDBInfo.colsMap.put("newStoryList", "TEXT");
        sb.append(" newStoryList TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "extbuf";
        mAutoDBInfo.colsMap.put("extbuf", "BLOB");
        sb.append(" extbuf BLOB");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "nextSyncTime";
        mAutoDBInfo.colsMap.put("nextSyncTime", "LONG");
        sb.append(" nextSyncTime LONG");
        mAutoDBInfo.columns[5] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        return mAutoDBInfo;
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fLh == hashCode) {
                    this.field_roomname = cursor.getString(i2);
                    this.fKW = true;
                } else if (gbq == hashCode) {
                    this.field_userStoryFlag = cursor.getInt(i2);
                } else if (gbH == hashCode) {
                    this.field_newStoryList = cursor.getString(i2);
                } else if (gbI == hashCode) {
                    this.field_extbuf = cursor.getBlob(i2);
                } else if (gbJ == hashCode) {
                    this.field_nextSyncTime = cursor.getLong(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.field_roomname == null) {
            this.field_roomname = "";
        }
        if (this.fKW) {
            contentValues.put("roomname", this.field_roomname);
        }
        if (this.gbc) {
            contentValues.put("userStoryFlag", Integer.valueOf(this.field_userStoryFlag));
        }
        if (this.gbE) {
            contentValues.put("newStoryList", this.field_newStoryList);
        }
        if (this.gbF) {
            contentValues.put("extbuf", this.field_extbuf);
        }
        if (this.gbG) {
            contentValues.put("nextSyncTime", Long.valueOf(this.field_nextSyncTime));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
