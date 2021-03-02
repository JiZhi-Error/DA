package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class fp extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fVU = "decryptKey".hashCode();
    private static final int fVg = "pkgMd5".hashCode();
    private static final int fkR = "appVersion".hashCode();
    private static final int fkj = "appId".hashCode();
    private static final int flJ = "reportId".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private boolean fUX = true;
    private boolean fVT = true;
    public String field_appId;
    public int field_appVersion;
    public String field_decryptKey;
    public String field_pkgMd5;
    public int field_reportId;
    private boolean fjS = true;
    private boolean fkN = true;
    private boolean flE = true;

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
                } else if (fVU == hashCode) {
                    this.field_decryptKey = cursor.getString(i2);
                } else if (fVg == hashCode) {
                    this.field_pkgMd5 = cursor.getString(i2);
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
        if (this.fjS) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.fkN) {
            contentValues.put("appVersion", Integer.valueOf(this.field_appVersion));
        }
        if (this.fVT) {
            contentValues.put("decryptKey", this.field_decryptKey);
        }
        if (this.fUX) {
            contentValues.put("pkgMd5", this.field_pkgMd5);
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
