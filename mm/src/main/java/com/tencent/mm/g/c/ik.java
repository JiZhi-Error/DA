package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class ik extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fxs = "count".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private static final int usw = "topic".hashCode();
    public long field_count;
    public String field_topic;
    private boolean fwS = true;
    private boolean usv = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (usw == hashCode) {
                    this.field_topic = cursor.getString(i2);
                    this.usv = true;
                } else if (fxs == hashCode) {
                    this.field_count = cursor.getLong(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.usv) {
            contentValues.put("topic", this.field_topic);
        }
        if (this.fwS) {
            contentValues.put("count", Long.valueOf(this.field_count));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
