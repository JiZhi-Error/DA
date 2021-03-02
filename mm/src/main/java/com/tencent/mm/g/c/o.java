package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class o extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fkJ = "data".hashCode();
    private static final int fkW = "dataType".hashCode();
    private static final int fkX = "size".hashCode();
    private static final int key_HASHCODE = "key".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private boolean __hadSetkey = true;
    public String field_data;
    public String field_dataType;
    public String field_key;
    public int field_size;
    private boolean fkF = true;
    private boolean fkU = true;
    private boolean fkV = true;

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
                } else if (fkJ == hashCode) {
                    this.field_data = cursor.getString(i2);
                } else if (fkW == hashCode) {
                    this.field_dataType = cursor.getString(i2);
                } else if (fkX == hashCode) {
                    this.field_size = cursor.getInt(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.__hadSetkey) {
            contentValues.put("key", this.field_key);
        }
        if (this.fkF) {
            contentValues.put("data", this.field_data);
        }
        if (this.fkU) {
            contentValues.put("dataType", this.field_dataType);
        }
        if (this.fkV) {
            contentValues.put("size", Integer.valueOf(this.field_size));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
