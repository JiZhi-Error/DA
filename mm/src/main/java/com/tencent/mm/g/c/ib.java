package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class ib extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fkj = "appId".hashCode();
    private static final int gjz = "permissionProtoBlob".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    public String field_appId;
    public byte[] field_permissionProtoBlob;
    private boolean fjS = true;
    private boolean gjy = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fkj == hashCode) {
                    this.field_appId = cursor.getString(i2);
                    this.fjS = true;
                } else if (gjz == hashCode) {
                    this.field_permissionProtoBlob = cursor.getBlob(i2);
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
        if (this.gjy) {
            contentValues.put("permissionProtoBlob", this.field_permissionProtoBlob);
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
