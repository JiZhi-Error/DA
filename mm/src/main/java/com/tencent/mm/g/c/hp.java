package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class hp extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fJb = "expireTime".hashCode();
    private static final int ghx = "host".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private boolean fIP = true;
    public long field_expireTime;
    public String field_host;
    private boolean ghw = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (ghx == hashCode) {
                    this.field_host = cursor.getString(i2);
                } else if (fJb == hashCode) {
                    this.field_expireTime = cursor.getLong(i2);
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
        if (this.fIP) {
            contentValues.put("expireTime", Long.valueOf(this.field_expireTime));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
