package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

/* renamed from: com.tencent.mm.g.c.if  reason: invalid class name */
public abstract class Cif extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fPd = "appIdHash".hashCode();
    private static final int fkj = "appId".hashCode();
    private static final int gjP = "openDebug".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private boolean fOX = true;
    public String field_appId;
    public int field_appIdHash;
    public boolean field_openDebug;
    private boolean fjS = true;
    private boolean gjO = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fPd == hashCode) {
                    this.field_appIdHash = cursor.getInt(i2);
                    this.fOX = true;
                } else if (fkj == hashCode) {
                    this.field_appId = cursor.getString(i2);
                } else if (gjP == hashCode) {
                    this.field_openDebug = cursor.getInt(i2) != 0;
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.fOX) {
            contentValues.put("appIdHash", Integer.valueOf(this.field_appIdHash));
        }
        if (this.fjS) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.gjO) {
            contentValues.put("openDebug", Boolean.valueOf(this.field_openDebug));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
