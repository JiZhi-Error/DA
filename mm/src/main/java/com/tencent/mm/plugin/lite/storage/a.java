package com.tencent.mm.plugin.lite.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class a extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int ghx = "host".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private static final int updateTime_HASHCODE = ch.COL_UPDATETIME.hashCode();
    private static final int yEW = "param".hashCode();
    private static final int yEX = "headerMap".hashCode();
    private static final int yEY = "paramMap".hashCode();
    private boolean __hadSetupdateTime = true;
    public String field_headerMap;
    public String field_host;
    public String field_param;
    public String field_paramMap;
    public long field_updateTime;
    private boolean ghw = true;
    private boolean yET = true;
    private boolean yEU = true;
    private boolean yEV = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (ghx == hashCode) {
                    this.field_host = cursor.getString(i2);
                    this.ghw = true;
                } else if (yEW == hashCode) {
                    this.field_param = cursor.getString(i2);
                } else if (yEX == hashCode) {
                    this.field_headerMap = cursor.getString(i2);
                } else if (yEY == hashCode) {
                    this.field_paramMap = cursor.getString(i2);
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
        if (this.ghw) {
            contentValues.put("host", this.field_host);
        }
        if (this.yET) {
            contentValues.put("param", this.field_param);
        }
        if (this.yEU) {
            contentValues.put("headerMap", this.field_headerMap);
        }
        if (this.yEV) {
            contentValues.put("paramMap", this.field_paramMap);
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
