package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class hv extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fUh = "appid".hashCode();
    private static final int giE = "jsExceptionCount".hashCode();
    private static final int giF = "crashCount".hashCode();
    private static final int giG = "beginTimestamp".hashCode();
    private static final int giH = "pkgVersion".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private boolean fUf = true;
    public String field_appid;
    public long field_beginTimestamp;
    public int field_crashCount;
    public int field_jsExceptionCount;
    public int field_pkgVersion;
    private boolean giA = true;
    private boolean giB = true;
    private boolean giC = true;
    private boolean giD = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fUh == hashCode) {
                    this.field_appid = cursor.getString(i2);
                    this.fUf = true;
                } else if (giE == hashCode) {
                    this.field_jsExceptionCount = cursor.getInt(i2);
                } else if (giF == hashCode) {
                    this.field_crashCount = cursor.getInt(i2);
                } else if (giG == hashCode) {
                    this.field_beginTimestamp = cursor.getLong(i2);
                } else if (giH == hashCode) {
                    this.field_pkgVersion = cursor.getInt(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.fUf) {
            contentValues.put("appid", this.field_appid);
        }
        if (this.giA) {
            contentValues.put("jsExceptionCount", Integer.valueOf(this.field_jsExceptionCount));
        }
        if (this.giB) {
            contentValues.put("crashCount", Integer.valueOf(this.field_crashCount));
        }
        if (this.giC) {
            contentValues.put("beginTimestamp", Long.valueOf(this.field_beginTimestamp));
        }
        if (this.giD) {
            contentValues.put("pkgVersion", Integer.valueOf(this.field_pkgVersion));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
