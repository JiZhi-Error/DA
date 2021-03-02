package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class ia extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fkj = "appId".hashCode();
    private static final int gjw = "permissionDemo".hashCode();
    private static final int gjx = "versiontime".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    public String field_appId;
    public boolean field_permissionDemo;
    public long field_versiontime;
    private boolean fjS = true;
    private boolean gju = true;
    private boolean gjv = true;

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
                } else if (gjw == hashCode) {
                    this.field_permissionDemo = cursor.getInt(i2) != 0;
                } else if (gjx == hashCode) {
                    this.field_versiontime = cursor.getLong(i2);
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
        if (this.gju) {
            contentValues.put("permissionDemo", Boolean.valueOf(this.field_permissionDemo));
        }
        if (this.gjv) {
            contentValues.put("versiontime", Long.valueOf(this.field_versiontime));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
