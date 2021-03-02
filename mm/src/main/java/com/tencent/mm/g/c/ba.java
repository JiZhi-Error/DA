package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class ba extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fvt = "labelId".hashCode();
    private static final int fvu = "contactName".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    public String field_contactName;
    public String field_labelId;
    private boolean fvr;
    private boolean fvs;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fvt == hashCode) {
                    this.field_labelId = cursor.getString(i2);
                } else if (fvu == hashCode) {
                    this.field_contactName = cursor.getString(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.fvr) {
            contentValues.put("labelId", this.field_labelId);
        }
        if (this.fvs) {
            contentValues.put("contactName", this.field_contactName);
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
