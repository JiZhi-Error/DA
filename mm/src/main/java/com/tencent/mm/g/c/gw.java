package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class gw extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int gbS = "tableHash".hashCode();
    private static final int gbT = "tableSQLMD5".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    public int field_tableHash;
    public String field_tableSQLMD5;
    private boolean gbQ = true;
    private boolean gbR = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (gbS == hashCode) {
                    this.field_tableHash = cursor.getInt(i2);
                    this.gbQ = true;
                } else if (gbT == hashCode) {
                    this.field_tableSQLMD5 = cursor.getString(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.gbQ) {
            contentValues.put("tableHash", Integer.valueOf(this.field_tableHash));
        }
        if (this.gbR) {
            contentValues.put("tableSQLMD5", this.field_tableSQLMD5);
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
