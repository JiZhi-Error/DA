package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class bg extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fkJ = "data".hashCode();
    private static final int fkj = "appId".hashCode();
    private static final int fwl = "cacheKey".hashCode();
    private static final int fwm = "interval".hashCode();
    private static final int id_HASHCODE = "id".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private static final int updateTime_HASHCODE = ch.COL_UPDATETIME.hashCode();
    private boolean __hadSetid = true;
    private boolean __hadSetupdateTime = true;
    public String field_appId;
    public String field_cacheKey;
    public String field_data;
    public String field_id;
    public int field_interval;
    public long field_updateTime;
    private boolean fjS = true;
    private boolean fkF = true;
    private boolean fwj = true;
    private boolean fwk = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (id_HASHCODE == hashCode) {
                    this.field_id = cursor.getString(i2);
                } else if (fwl == hashCode) {
                    this.field_cacheKey = cursor.getString(i2);
                } else if (fkj == hashCode) {
                    this.field_appId = cursor.getString(i2);
                } else if (fkJ == hashCode) {
                    this.field_data = cursor.getString(i2);
                } else if (fwm == hashCode) {
                    this.field_interval = cursor.getInt(i2);
                } else if (updateTime_HASHCODE == hashCode) {
                    this.field_updateTime = cursor.getLong(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.__hadSetid) {
            contentValues.put("id", this.field_id);
        }
        if (this.fwj) {
            contentValues.put("cacheKey", this.field_cacheKey);
        }
        if (this.fjS) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.fkF) {
            contentValues.put("data", this.field_data);
        }
        if (this.fwk) {
            contentValues.put("interval", Integer.valueOf(this.field_interval));
        }
        if (this.__hadSetupdateTime) {
            contentValues.put(ch.COL_UPDATETIME, Long.valueOf(this.field_updateTime));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
