package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class hq extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fkj = "appId".hashCode();
    private static final int flc = "recordId".hashCode();
    private static final int ghz = "domin".hashCode();
    private static final int key_HASHCODE = "key".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private static final int value_HASHCODE = "value".hashCode();
    private boolean __hadSetkey = true;
    private boolean __hadSetvalue = true;
    public String field_appId;
    public String field_domin;
    public String field_key;
    public int field_recordId;
    public String field_value;
    private boolean fjS = true;
    private boolean fkY = true;
    private boolean ghy = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (flc == hashCode) {
                    this.field_recordId = cursor.getInt(i2);
                    this.fkY = true;
                } else if (fkj == hashCode) {
                    this.field_appId = cursor.getString(i2);
                } else if (ghz == hashCode) {
                    this.field_domin = cursor.getString(i2);
                } else if (key_HASHCODE == hashCode) {
                    this.field_key = cursor.getString(i2);
                } else if (value_HASHCODE == hashCode) {
                    this.field_value = cursor.getString(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.fkY) {
            contentValues.put("recordId", Integer.valueOf(this.field_recordId));
        }
        if (this.fjS) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.ghy) {
            contentValues.put("domin", this.field_domin);
        }
        if (this.__hadSetkey) {
            contentValues.put("key", this.field_key);
        }
        if (this.__hadSetvalue) {
            contentValues.put("value", this.field_value);
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
