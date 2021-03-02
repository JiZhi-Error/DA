package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class ic extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int gjD = "pluginAppID".hashCode();
    private static final int gjE = "pluginAppVersion".hashCode();
    private static final int gjF = "pluginStringVersion".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    public String field_pluginAppID;
    public int field_pluginAppVersion;
    public String field_pluginStringVersion;
    private boolean gjA = true;
    private boolean gjB = true;
    private boolean gjC = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (gjD == hashCode) {
                    this.field_pluginAppID = cursor.getString(i2);
                } else if (gjE == hashCode) {
                    this.field_pluginAppVersion = cursor.getInt(i2);
                } else if (gjF == hashCode) {
                    this.field_pluginStringVersion = cursor.getString(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.gjA) {
            contentValues.put("pluginAppID", this.field_pluginAppID);
        }
        if (this.gjB) {
            contentValues.put("pluginAppVersion", Integer.valueOf(this.field_pluginAppVersion));
        }
        if (this.gjC) {
            contentValues.put("pluginStringVersion", this.field_pluginStringVersion);
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
