package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class dj extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fKJ = "chatRoomName".hashCode();
    private static final int fKK = "BindAppData".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private boolean fKH = true;
    private boolean fKI = true;
    public byte[] field_BindAppData;
    public String field_chatRoomName;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fKJ == hashCode) {
                    this.field_chatRoomName = cursor.getString(i2);
                    this.fKH = true;
                } else if (fKK == hashCode) {
                    this.field_BindAppData = cursor.getBlob(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.field_chatRoomName == null) {
            this.field_chatRoomName = "群username";
        }
        if (this.fKH) {
            contentValues.put("chatRoomName", this.field_chatRoomName);
        }
        if (this.fKI) {
            contentValues.put("BindAppData", this.field_BindAppData);
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
