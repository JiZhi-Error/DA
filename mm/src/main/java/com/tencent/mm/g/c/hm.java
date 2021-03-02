package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class hm extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int flv = "version".hashCode();
    private static final int fss = "downloadUrl".hashCode();
    private static final int fyf = "md5".hashCode();
    private static final int ghj = "pkgId".hashCode();
    private static final int ghk = "oldVersion".hashCode();
    private static final int ghl = "oldPath".hashCode();
    private static final int ghm = "pkgSize".hashCode();
    private static final int ghn = "downloadNetType".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    public int field_downloadNetType;
    public String field_downloadUrl;
    public String field_md5;
    public String field_oldPath;
    public String field_oldVersion;
    public String field_pkgId;
    public int field_pkgSize;
    public String field_version;
    private boolean flq = true;
    private boolean fsk = true;
    private boolean fxt = true;
    private boolean ghe = true;
    private boolean ghf = true;
    private boolean ghg = true;
    private boolean ghh = true;
    private boolean ghi = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (ghj == hashCode) {
                    this.field_pkgId = cursor.getString(i2);
                    this.ghe = true;
                } else if (flv == hashCode) {
                    this.field_version = cursor.getString(i2);
                } else if (ghk == hashCode) {
                    this.field_oldVersion = cursor.getString(i2);
                } else if (ghl == hashCode) {
                    this.field_oldPath = cursor.getString(i2);
                } else if (fyf == hashCode) {
                    this.field_md5 = cursor.getString(i2);
                } else if (fss == hashCode) {
                    this.field_downloadUrl = cursor.getString(i2);
                } else if (ghm == hashCode) {
                    this.field_pkgSize = cursor.getInt(i2);
                } else if (ghn == hashCode) {
                    this.field_downloadNetType = cursor.getInt(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.ghe) {
            contentValues.put("pkgId", this.field_pkgId);
        }
        if (this.flq) {
            contentValues.put("version", this.field_version);
        }
        if (this.ghf) {
            contentValues.put("oldVersion", this.field_oldVersion);
        }
        if (this.ghg) {
            contentValues.put("oldPath", this.field_oldPath);
        }
        if (this.fxt) {
            contentValues.put("md5", this.field_md5);
        }
        if (this.fsk) {
            contentValues.put("downloadUrl", this.field_downloadUrl);
        }
        if (this.ghh) {
            contentValues.put("pkgSize", Integer.valueOf(this.field_pkgSize));
        }
        if (this.ghi) {
            contentValues.put("downloadNetType", Integer.valueOf(this.field_downloadNetType));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
