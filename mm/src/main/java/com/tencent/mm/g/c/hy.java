package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class hy extends IAutoDBItem {
    public static final String[] INDEX_CREATE = {"CREATE INDEX IF NOT EXISTS WxaAttrVersionServerNotifyRecordAppVersionIndex ON WxaAttrVersionServerNotifyRecord(appVersion)"};
    private static final int fkR = "appVersion".hashCode();
    private static final int flJ = "reportId".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private static final int username_HASHCODE = ch.COL_USERNAME.hashCode();
    private boolean __hadSetusername = true;
    public int field_appVersion;
    public int field_reportId;
    public String field_username;
    private boolean fkN = true;
    private boolean flE = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (username_HASHCODE == hashCode) {
                    this.field_username = cursor.getString(i2);
                    this.__hadSetusername = true;
                } else if (fkR == hashCode) {
                    this.field_appVersion = cursor.getInt(i2);
                } else if (flJ == hashCode) {
                    this.field_reportId = cursor.getInt(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.__hadSetusername) {
            contentValues.put(ch.COL_USERNAME, this.field_username);
        }
        if (this.fkN) {
            contentValues.put("appVersion", Integer.valueOf(this.field_appVersion));
        }
        if (this.flE) {
            contentValues.put("reportId", Integer.valueOf(this.field_reportId));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
