package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class cn extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fFV = "ds".hashCode();
    private static final int fFW = "hour".hashCode();
    private static final int fFX = "actionMs".hashCode();
    private static final int fFY = "isGoToFinderUI".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private boolean fFR = true;
    private boolean fFS = true;
    private boolean fFT = true;
    private boolean fFU = true;
    public long field_actionMs;
    public int field_ds;
    public int field_hour;
    public int field_isGoToFinderUI;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fFV == hashCode) {
                    this.field_ds = cursor.getInt(i2);
                } else if (fFW == hashCode) {
                    this.field_hour = cursor.getInt(i2);
                } else if (fFX == hashCode) {
                    this.field_actionMs = cursor.getLong(i2);
                } else if (fFY == hashCode) {
                    this.field_isGoToFinderUI = cursor.getInt(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.fFR) {
            contentValues.put("ds", Integer.valueOf(this.field_ds));
        }
        if (this.fFS) {
            contentValues.put("hour", Integer.valueOf(this.field_hour));
        }
        if (this.fFT) {
            contentValues.put("actionMs", Long.valueOf(this.field_actionMs));
        }
        if (this.fFU) {
            contentValues.put("isGoToFinderUI", Integer.valueOf(this.field_isGoToFinderUI));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
