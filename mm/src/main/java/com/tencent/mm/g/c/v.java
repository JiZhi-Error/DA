package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class v extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fkQ = "versionType".hashCode();
    private static final int fkj = "appId".hashCode();
    private static final int flp = "versionMd5".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    public String field_appId;
    public String field_versionMd5;
    public int field_versionType;
    private boolean fjS = true;
    private boolean fkM = true;
    private boolean flo = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fkj == hashCode) {
                    this.field_appId = cursor.getString(i2);
                } else if (fkQ == hashCode) {
                    this.field_versionType = cursor.getInt(i2);
                } else if (flp == hashCode) {
                    this.field_versionMd5 = cursor.getString(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.fjS) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.fkM) {
            contentValues.put("versionType", Integer.valueOf(this.field_versionType));
        }
        if (this.flo) {
            contentValues.put("versionMd5", this.field_versionMd5);
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
