package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class hn extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fJb = "expireTime".hashCode();
    private static final int fJf = "weight".hashCode();
    private static final int fPE = "timeStamp".hashCode();
    private static final int fkX = "size".hashCode();
    private static final int fkj = "appId".hashCode();
    private static final int ghq = "appIdKey".hashCode();
    private static final int ghr = "localFile".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private static final int value_HASHCODE = "value".hashCode();
    private boolean __hadSetvalue = true;
    private boolean fIP = true;
    private boolean fIT = true;
    private boolean fPy = true;
    public String field_appId;
    public String field_appIdKey;
    public long field_expireTime;
    public String field_localFile;
    public long field_size;
    public long field_timeStamp;
    public String field_value;
    public String field_weight;
    private boolean fjS = true;
    private boolean fkV = true;
    private boolean gho = true;
    private boolean ghp = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fkj == hashCode) {
                    this.field_appId = cursor.getString(i2);
                } else if (ghq == hashCode) {
                    this.field_appIdKey = cursor.getString(i2);
                    this.gho = true;
                } else if (value_HASHCODE == hashCode) {
                    this.field_value = cursor.getString(i2);
                } else if (fJf == hashCode) {
                    this.field_weight = cursor.getString(i2);
                } else if (fJb == hashCode) {
                    this.field_expireTime = cursor.getLong(i2);
                } else if (fPE == hashCode) {
                    this.field_timeStamp = cursor.getLong(i2);
                } else if (fkX == hashCode) {
                    this.field_size = cursor.getLong(i2);
                } else if (ghr == hashCode) {
                    this.field_localFile = cursor.getString(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.fjS) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.gho) {
            contentValues.put("appIdKey", this.field_appIdKey);
        }
        if (this.__hadSetvalue) {
            contentValues.put("value", this.field_value);
        }
        if (this.fIT) {
            contentValues.put("weight", this.field_weight);
        }
        if (this.fIP) {
            contentValues.put("expireTime", Long.valueOf(this.field_expireTime));
        }
        if (this.fPy) {
            contentValues.put("timeStamp", Long.valueOf(this.field_timeStamp));
        }
        if (this.fkV) {
            contentValues.put("size", Long.valueOf(this.field_size));
        }
        if (this.ghp) {
            contentValues.put("localFile", this.field_localFile);
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
