package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class go extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fyq = "groupId".hashCode();
    private static final int gaE = "groupTime".hashCode();
    private static final int gaF = "groupStrcut".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    public long field_groupId;
    public byte[] field_groupStrcut;
    public int field_groupTime;
    private boolean fxE = true;
    private boolean gaC = true;
    private boolean gaD = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fyq == hashCode) {
                    this.field_groupId = cursor.getLong(i2);
                    this.fxE = true;
                } else if (gaE == hashCode) {
                    this.field_groupTime = cursor.getInt(i2);
                } else if (gaF == hashCode) {
                    this.field_groupStrcut = cursor.getBlob(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.fxE) {
            contentValues.put("groupId", Long.valueOf(this.field_groupId));
        }
        if (this.gaC) {
            contentValues.put("groupTime", Integer.valueOf(this.field_groupTime));
        }
        if (this.gaD) {
            contentValues.put("groupStrcut", this.field_groupStrcut);
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
