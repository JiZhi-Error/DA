package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class bf extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fwh = "bakLogId".hashCode();
    private static final int fwi = "valueStr".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    public int field_bakLogId;
    public String field_valueStr;
    private boolean fwf;
    private boolean fwg;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fwh == hashCode) {
                    this.field_bakLogId = cursor.getInt(i2);
                } else if (fwi == hashCode) {
                    this.field_valueStr = cursor.getString(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.fwf) {
            contentValues.put("bakLogId", Integer.valueOf(this.field_bakLogId));
        }
        if (this.fwg) {
            contentValues.put("valueStr", this.field_valueStr);
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
