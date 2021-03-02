package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class t extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fkR = "appVersion".hashCode();
    private static final int fkj = "appId".hashCode();
    private static final int fll = "isSeparatedPluginsUsed".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    public String field_appId;
    public int field_appVersion;
    public int field_isSeparatedPluginsUsed;
    private boolean fjS = true;
    private boolean fkN = true;
    private boolean flk = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fkj == hashCode) {
                    this.field_appId = cursor.getString(i2);
                } else if (fkR == hashCode) {
                    this.field_appVersion = cursor.getInt(i2);
                } else if (fll == hashCode) {
                    this.field_isSeparatedPluginsUsed = cursor.getInt(i2);
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
        if (this.fkN) {
            contentValues.put("appVersion", Integer.valueOf(this.field_appVersion));
        }
        if (this.flk) {
            contentValues.put("isSeparatedPluginsUsed", Integer.valueOf(this.field_isSeparatedPluginsUsed));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
