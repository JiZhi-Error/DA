package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class fz extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fQQ = "historyId".hashCode();
    private static final int fjf = "msgId".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private boolean fQO = true;
    public String field_historyId;
    public long field_msgId;
    private boolean fjb = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fQQ == hashCode) {
                    this.field_historyId = cursor.getString(i2);
                } else if (fjf == hashCode) {
                    this.field_msgId = cursor.getLong(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.fQO) {
            contentValues.put("historyId", this.field_historyId);
        }
        if (this.fjb) {
            contentValues.put("msgId", Long.valueOf(this.field_msgId));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
