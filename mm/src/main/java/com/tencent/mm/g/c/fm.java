package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class fm extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fVg = "pkgMd5".hashCode();
    private static final int fkj = "appId".hashCode();
    private static final int flv = "version".hashCode();
    private static final int flx = "pkgPath".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private static final int type_HASHCODE = "type".hashCode();
    private boolean __hadSettype = true;
    private boolean fUX = true;
    public String field_appId;
    public String field_pkgMd5;
    public String field_pkgPath;
    public int field_type;
    public int field_version;
    private boolean fjS = true;
    private boolean flq = true;
    private boolean fls = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fkj == hashCode) {
                    this.field_appId = cursor.getString(i2);
                } else if (flv == hashCode) {
                    this.field_version = cursor.getInt(i2);
                } else if (type_HASHCODE == hashCode) {
                    this.field_type = cursor.getInt(i2);
                } else if (fVg == hashCode) {
                    this.field_pkgMd5 = cursor.getString(i2);
                } else if (flx == hashCode) {
                    this.field_pkgPath = cursor.getString(i2);
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
        if (this.flq) {
            contentValues.put("version", Integer.valueOf(this.field_version));
        }
        if (this.__hadSettype) {
            contentValues.put("type", Integer.valueOf(this.field_type));
        }
        if (this.fUX) {
            contentValues.put("pkgMd5", this.field_pkgMd5);
        }
        if (this.fls) {
            contentValues.put("pkgPath", this.field_pkgPath);
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
