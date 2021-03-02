package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class ct extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int createTime_HASHCODE = "createTime".hashCode();
    private static final int fHf = "protocolNumber".hashCode();
    private static final int fHg = "logContent".hashCode();
    private static final int id_HASHCODE = "id".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private boolean __hadSetcreateTime = true;
    private boolean __hadSetid = true;
    private boolean fHd = true;
    private boolean fHe = true;
    public long field_createTime;
    public String field_id;
    public String field_logContent;
    public int field_protocolNumber;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (id_HASHCODE == hashCode) {
                    this.field_id = cursor.getString(i2);
                    this.__hadSetid = true;
                } else if (fHf == hashCode) {
                    this.field_protocolNumber = cursor.getInt(i2);
                } else if (fHg == hashCode) {
                    this.field_logContent = cursor.getString(i2);
                } else if (createTime_HASHCODE == hashCode) {
                    this.field_createTime = cursor.getLong(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.__hadSetid) {
            contentValues.put("id", this.field_id);
        }
        if (this.fHd) {
            contentValues.put("protocolNumber", Integer.valueOf(this.field_protocolNumber));
        }
        if (this.fHe) {
            contentValues.put("logContent", this.field_logContent);
        }
        if (this.__hadSetcreateTime) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
