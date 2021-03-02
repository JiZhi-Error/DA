package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class ff extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fDK = "retryCount".hashCode();
    private static final int fUA = "cardUserId".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private boolean fDu = true;
    private boolean fUz = true;
    public String field_cardUserId;
    public int field_retryCount;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fUA == hashCode) {
                    this.field_cardUserId = cursor.getString(i2);
                    this.fUz = true;
                } else if (fDK == hashCode) {
                    this.field_retryCount = cursor.getInt(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.fUz) {
            contentValues.put("cardUserId", this.field_cardUserId);
        }
        if (this.fDu) {
            contentValues.put("retryCount", Integer.valueOf(this.field_retryCount));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
