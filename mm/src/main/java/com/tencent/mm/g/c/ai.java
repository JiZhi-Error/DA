package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class ai extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fnU = "brandUserName".hashCode();
    private static final int foJ = "userId".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    public String field_brandUserName;
    public String field_userId;
    private boolean fnF = true;
    private boolean foI = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fnU == hashCode) {
                    this.field_brandUserName = cursor.getString(i2);
                    this.fnF = true;
                } else if (foJ == hashCode) {
                    this.field_userId = cursor.getString(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.fnF) {
            contentValues.put("brandUserName", this.field_brandUserName);
        }
        if (this.foI) {
            contentValues.put("userId", this.field_userId);
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
