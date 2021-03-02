package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class fd extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fUy = "msgContentXml".hashCode();
    private static final int fjf = "msgId".hashCode();
    private static final int fqF = "isRead".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private boolean fUx = true;
    public String field_isRead;
    public String field_msgContentXml;
    public String field_msgId;
    private boolean fjb = true;
    private boolean fqr = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fjf == hashCode) {
                    this.field_msgId = cursor.getString(i2);
                    this.fjb = true;
                } else if (fUy == hashCode) {
                    this.field_msgContentXml = cursor.getString(i2);
                } else if (fqF == hashCode) {
                    this.field_isRead = cursor.getString(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.fjb) {
            contentValues.put("msgId", this.field_msgId);
        }
        if (this.fUx) {
            contentValues.put("msgContentXml", this.field_msgContentXml);
        }
        if (this.fqr) {
            contentValues.put("isRead", this.field_isRead);
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
