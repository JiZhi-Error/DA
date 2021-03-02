package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class gn extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fkX = "size".hashCode();
    private static final int fyj = "state".hashCode();
    private static final int gaA = "top".hashCode();
    private static final int gaB = "bottom".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    public long field_bottom;
    public int field_size;
    public int field_state;
    public long field_top;
    private boolean fkV = true;
    private boolean fxx = true;
    private boolean gay = true;
    private boolean gaz = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (gaA == hashCode) {
                    this.field_top = cursor.getLong(i2);
                } else if (gaB == hashCode) {
                    this.field_bottom = cursor.getLong(i2);
                    this.gaz = true;
                } else if (fkX == hashCode) {
                    this.field_size = cursor.getInt(i2);
                } else if (fyj == hashCode) {
                    this.field_state = cursor.getInt(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.gay) {
            contentValues.put("top", Long.valueOf(this.field_top));
        }
        if (this.gaz) {
            contentValues.put("bottom", Long.valueOf(this.field_bottom));
        }
        if (this.fkV) {
            contentValues.put("size", Integer.valueOf(this.field_size));
        }
        if (this.fxx) {
            contentValues.put("state", Integer.valueOf(this.field_state));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
