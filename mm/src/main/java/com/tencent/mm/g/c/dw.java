package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class dw extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fMS = "countryCode".hashCode();
    private static final int fMT = "callTimeCount".hashCode();
    private static final int fMU = "lastCallTime".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private boolean fMP = true;
    private boolean fMQ = true;
    private boolean fMR = true;
    public long field_callTimeCount;
    public int field_countryCode;
    public long field_lastCallTime;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fMS == hashCode) {
                    this.field_countryCode = cursor.getInt(i2);
                    this.fMP = true;
                } else if (fMT == hashCode) {
                    this.field_callTimeCount = cursor.getLong(i2);
                } else if (fMU == hashCode) {
                    this.field_lastCallTime = cursor.getLong(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.fMP) {
            contentValues.put("countryCode", Integer.valueOf(this.field_countryCode));
        }
        if (this.fMQ) {
            contentValues.put("callTimeCount", Long.valueOf(this.field_callTimeCount));
        }
        if (this.fMR) {
            contentValues.put("lastCallTime", Long.valueOf(this.field_lastCallTime));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
