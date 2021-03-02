package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class aa extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fkj = "appId".hashCode();
    private static final int fni = "flag".hashCode();
    private static final int fnj = "sortId".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    public String field_appId;
    public long field_flag;
    public int field_sortId;
    private boolean fjS = true;
    private boolean fng = true;
    private boolean fnh = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fni == hashCode) {
                    this.field_flag = cursor.getLong(i2);
                } else if (fkj == hashCode) {
                    this.field_appId = cursor.getString(i2);
                } else if (fnj == hashCode) {
                    this.field_sortId = cursor.getInt(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.fng) {
            contentValues.put("flag", Long.valueOf(this.field_flag));
        }
        if (this.field_appId == null) {
            this.field_appId = "";
        }
        if (this.fjS) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.fnh) {
            contentValues.put("sortId", Integer.valueOf(this.field_sortId));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
