package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class x extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fkj = "appId".hashCode();
    private static final int flF = "packageType".hashCode();
    private static final int flG = "packageKey".hashCode();
    private static final int flH = "source".hashCode();
    private static final int flI = "hitCount".hashCode();
    private static final int flJ = "reportId".hashCode();
    private static final int flv = "version".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    public String field_appId;
    public int field_hitCount;
    public String field_packageKey;
    public int field_packageType;
    public int field_reportId;
    public int field_source;
    public int field_version;
    private boolean fjS = true;
    private boolean flA = true;
    private boolean flB = true;
    private boolean flC = true;
    private boolean flD = true;
    private boolean flE = true;
    private boolean flq = true;

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
                } else if (flF == hashCode) {
                    this.field_packageType = cursor.getInt(i2);
                } else if (flG == hashCode) {
                    this.field_packageKey = cursor.getString(i2);
                } else if (flH == hashCode) {
                    this.field_source = cursor.getInt(i2);
                } else if (flI == hashCode) {
                    this.field_hitCount = cursor.getInt(i2);
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
        if (this.flq) {
            contentValues.put("version", Integer.valueOf(this.field_version));
        }
        if (this.flA) {
            contentValues.put("packageType", Integer.valueOf(this.field_packageType));
        }
        if (this.flB) {
            contentValues.put("packageKey", this.field_packageKey);
        }
        if (this.flC) {
            contentValues.put("source", Integer.valueOf(this.field_source));
        }
        if (this.flD) {
            contentValues.put("hitCount", Integer.valueOf(this.field_hitCount));
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
