package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.google.android.gms.measurement.AppMeasurement;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class gi extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fAt = "extFlag".hashCode();
    private static final int fBI = AppMeasurement.Param.TIMESTAMP.hashCode();
    private static final int fZE = "draft".hashCode();
    private static final int key_HASHCODE = "key".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private boolean __hadSetkey = true;
    private boolean fAo = true;
    private boolean fBy = true;
    private boolean fZD = true;
    public byte[] field_draft;
    public int field_extFlag;
    public String field_key;
    public long field_timestamp;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (key_HASHCODE == hashCode) {
                    this.field_key = cursor.getString(i2);
                    this.__hadSetkey = true;
                } else if (fBI == hashCode) {
                    this.field_timestamp = cursor.getLong(i2);
                } else if (fAt == hashCode) {
                    this.field_extFlag = cursor.getInt(i2);
                } else if (fZE == hashCode) {
                    this.field_draft = cursor.getBlob(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.field_key == null) {
            this.field_key = "";
        }
        if (this.__hadSetkey) {
            contentValues.put("key", this.field_key);
        }
        if (this.fBy) {
            contentValues.put(AppMeasurement.Param.TIMESTAMP, Long.valueOf(this.field_timestamp));
        }
        if (this.fAo) {
            contentValues.put("extFlag", Integer.valueOf(this.field_extFlag));
        }
        if (this.fZD) {
            contentValues.put("draft", this.field_draft);
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
