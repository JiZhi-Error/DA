package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class ad extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fjx = "startTime".hashCode();
    private static final int fjy = "endTime".hashCode();
    private static final int fno = "sessionName".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    public long field_endTime;
    public String field_sessionName;
    public long field_startTime;
    private boolean fjq = true;
    private boolean fjr = true;
    private boolean fnl = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fno == hashCode) {
                    this.field_sessionName = cursor.getString(i2);
                } else if (fjx == hashCode) {
                    this.field_startTime = cursor.getLong(i2);
                } else if (fjy == hashCode) {
                    this.field_endTime = cursor.getLong(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.field_sessionName == null) {
            this.field_sessionName = "";
        }
        if (this.fnl) {
            contentValues.put("sessionName", this.field_sessionName);
        }
        if (this.fjq) {
            contentValues.put("startTime", Long.valueOf(this.field_startTime));
        }
        if (this.fjr) {
            contentValues.put("endTime", Long.valueOf(this.field_endTime));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
