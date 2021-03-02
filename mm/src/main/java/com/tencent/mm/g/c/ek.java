package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class ek extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fQt = "send_id".hashCode();
    private static final int fQu = "open_count".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private boolean fQr = true;
    private boolean fQs = true;
    public int field_open_count;
    public String field_send_id;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fQt == hashCode) {
                    this.field_send_id = cursor.getString(i2);
                    this.fQr = true;
                } else if (fQu == hashCode) {
                    this.field_open_count = cursor.getInt(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.fQr) {
            contentValues.put("send_id", this.field_send_id);
        }
        if (this.fQs) {
            contentValues.put("open_count", Integer.valueOf(this.field_open_count));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
