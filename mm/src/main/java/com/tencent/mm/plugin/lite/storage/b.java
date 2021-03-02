package com.tencent.mm.plugin.lite.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class b extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fPo = "pkgType".hashCode();
    private static final int fkj = "appId".hashCode();
    private static final int flv = "version".hashCode();
    private static final int flx = "pkgPath".hashCode();
    private static final int fnB = "url".hashCode();
    private static final int fxh = "lastUseTime".hashCode();
    private static final int fyf = "md5".hashCode();
    private static final int fyq = "groupId".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private static final int updateTime_HASHCODE = ch.COL_UPDATETIME.hashCode();
    private static final int yFb = "signatureKey".hashCode();
    private static final int yFc = "patchId".hashCode();
    private boolean __hadSetupdateTime = true;
    private boolean fPj = true;
    public String field_appId;
    public String field_groupId;
    public long field_lastUseTime;
    public String field_md5;
    public String field_patchId;
    public String field_pkgPath;
    public String field_pkgType;
    public String field_signatureKey;
    public long field_updateTime;
    public String field_url;
    public String field_version;
    private boolean fjS = true;
    private boolean flq = true;
    private boolean fls = true;
    private boolean fnx = true;
    private boolean fwH = true;
    private boolean fxE = true;
    private boolean fxt = true;
    private boolean yEZ = true;
    private boolean yFa = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fkj == hashCode) {
                    this.field_appId = cursor.getString(i2);
                    this.fjS = true;
                } else if (fyq == hashCode) {
                    this.field_groupId = cursor.getString(i2);
                } else if (yFb == hashCode) {
                    this.field_signatureKey = cursor.getString(i2);
                } else if (flx == hashCode) {
                    this.field_pkgPath = cursor.getString(i2);
                } else if (fPo == hashCode) {
                    this.field_pkgType = cursor.getString(i2);
                } else if (yFc == hashCode) {
                    this.field_patchId = cursor.getString(i2);
                } else if (updateTime_HASHCODE == hashCode) {
                    this.field_updateTime = cursor.getLong(i2);
                } else if (flv == hashCode) {
                    this.field_version = cursor.getString(i2);
                } else if (fnB == hashCode) {
                    this.field_url = cursor.getString(i2);
                } else if (fyf == hashCode) {
                    this.field_md5 = cursor.getString(i2);
                } else if (fxh == hashCode) {
                    this.field_lastUseTime = cursor.getLong(i2);
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
        if (this.fxE) {
            contentValues.put("groupId", this.field_groupId);
        }
        if (this.yEZ) {
            contentValues.put("signatureKey", this.field_signatureKey);
        }
        if (this.fls) {
            contentValues.put("pkgPath", this.field_pkgPath);
        }
        if (this.fPj) {
            contentValues.put("pkgType", this.field_pkgType);
        }
        if (this.yFa) {
            contentValues.put("patchId", this.field_patchId);
        }
        if (this.__hadSetupdateTime) {
            contentValues.put(ch.COL_UPDATETIME, Long.valueOf(this.field_updateTime));
        }
        if (this.flq) {
            contentValues.put("version", this.field_version);
        }
        if (this.fnx) {
            contentValues.put("url", this.field_url);
        }
        if (this.fxt) {
            contentValues.put("md5", this.field_md5);
        }
        if (this.fwH) {
            contentValues.put("lastUseTime", Long.valueOf(this.field_lastUseTime));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
