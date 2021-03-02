package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class dg extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fJV = "reqType".hashCode();
    private static final int fJW = "cache".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private boolean fJT = true;
    private boolean fJU = true;
    public byte[] field_cache;
    public String field_reqType;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fJV == hashCode) {
                    this.field_reqType = cursor.getString(i2);
                    this.fJT = true;
                } else if (fJW == hashCode) {
                    this.field_cache = cursor.getBlob(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.fJT) {
            contentValues.put("reqType", this.field_reqType);
        }
        if (this.fJU) {
            contentValues.put("cache", this.field_cache);
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
