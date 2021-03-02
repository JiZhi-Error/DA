package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.google.android.gms.actions.SearchIntents;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class j extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fjQ = "scene".hashCode();
    private static final int fkG = "fetchType".hashCode();
    private static final int fkH = "path".hashCode();
    private static final int fkI = SearchIntents.EXTRA_QUERY.hashCode();
    private static final int fkJ = "data".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private static final int updateTime_HASHCODE = ch.COL_UPDATETIME.hashCode();
    private static final int username_HASHCODE = ch.COL_USERNAME.hashCode();
    private boolean __hadSetupdateTime = true;
    private boolean __hadSetusername = true;
    public String field_data;
    public int field_fetchType;
    public String field_path;
    public String field_query;
    public int field_scene;
    public long field_updateTime;
    public String field_username;
    private boolean fjO = true;
    private boolean fkC = true;
    private boolean fkD = true;
    private boolean fkE = true;
    private boolean fkF = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (username_HASHCODE == hashCode) {
                    this.field_username = cursor.getString(i2);
                } else if (fkG == hashCode) {
                    this.field_fetchType = cursor.getInt(i2);
                } else if (updateTime_HASHCODE == hashCode) {
                    this.field_updateTime = cursor.getLong(i2);
                } else if (fkH == hashCode) {
                    this.field_path = cursor.getString(i2);
                } else if (fkI == hashCode) {
                    this.field_query = cursor.getString(i2);
                } else if (fjQ == hashCode) {
                    this.field_scene = cursor.getInt(i2);
                } else if (fkJ == hashCode) {
                    this.field_data = cursor.getString(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.__hadSetusername) {
            contentValues.put(ch.COL_USERNAME, this.field_username);
        }
        if (this.fkC) {
            contentValues.put("fetchType", Integer.valueOf(this.field_fetchType));
        }
        if (this.__hadSetupdateTime) {
            contentValues.put(ch.COL_UPDATETIME, Long.valueOf(this.field_updateTime));
        }
        if (this.fkD) {
            contentValues.put("path", this.field_path);
        }
        if (this.fkE) {
            contentValues.put(SearchIntents.EXTRA_QUERY, this.field_query);
        }
        if (this.fjO) {
            contentValues.put("scene", Integer.valueOf(this.field_scene));
        }
        if (this.fkF) {
            contentValues.put("data", this.field_data);
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
