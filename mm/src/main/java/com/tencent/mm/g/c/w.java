package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class w extends IAutoDBItem {
    public static final String[] INDEX_CREATE = {"CREATE INDEX IF NOT EXISTS AppBrandWxaPkgManifestRecordPkgPathIndex ON AppBrandWxaPkgManifestRecord(pkgPath)"};
    private static final int createTime_HASHCODE = "createTime".hashCode();
    private static final int fjx = "startTime".hashCode();
    private static final int fjy = "endTime".hashCode();
    private static final int fkj = "appId".hashCode();
    private static final int flp = "versionMd5".hashCode();
    private static final int flv = "version".hashCode();
    private static final int flw = "NewMd5".hashCode();
    private static final int flx = "pkgPath".hashCode();
    private static final int fly = "debugType".hashCode();
    private static final int flz = "downloadURL".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private boolean __hadSetcreateTime = true;
    public String field_NewMd5;
    public String field_appId;
    public long field_createTime;
    public int field_debugType;
    public String field_downloadURL;
    public long field_endTime;
    public String field_pkgPath;
    public long field_startTime;
    public int field_version;
    public String field_versionMd5;
    private boolean fjS = true;
    private boolean fjq = true;
    private boolean fjr = true;
    private boolean flo = true;
    private boolean flq = true;
    private boolean flr = true;
    private boolean fls = true;
    private boolean flt = true;
    private boolean flu = true;

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
                } else if (flp == hashCode) {
                    this.field_versionMd5 = cursor.getString(i2);
                } else if (flw == hashCode) {
                    this.field_NewMd5 = cursor.getString(i2);
                } else if (flx == hashCode) {
                    this.field_pkgPath = cursor.getString(i2);
                } else if (createTime_HASHCODE == hashCode) {
                    this.field_createTime = cursor.getLong(i2);
                } else if (fly == hashCode) {
                    this.field_debugType = cursor.getInt(i2);
                } else if (flz == hashCode) {
                    this.field_downloadURL = cursor.getString(i2);
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
        if (this.fjS) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.flq) {
            contentValues.put("version", Integer.valueOf(this.field_version));
        }
        if (this.flo) {
            contentValues.put("versionMd5", this.field_versionMd5);
        }
        if (this.flr) {
            contentValues.put("NewMd5", this.field_NewMd5);
        }
        if (this.fls) {
            contentValues.put("pkgPath", this.field_pkgPath);
        }
        if (this.__hadSetcreateTime) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.flt) {
            contentValues.put("debugType", Integer.valueOf(this.field_debugType));
        }
        if (this.flu) {
            contentValues.put("downloadURL", this.field_downloadURL);
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
