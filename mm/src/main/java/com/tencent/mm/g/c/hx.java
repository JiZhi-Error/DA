package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class hx extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fkj = "appId".hashCode();
    private static final int giQ = "commLibVersionId".hashCode();
    private static final int giR = "appVersionId".hashCode();
    private static final int giS = "pageURL".hashCode();
    private static final int giT = "cacheFilePath".hashCode();
    private static final int gip = "accessTime".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private static final int updateTime_HASHCODE = ch.COL_UPDATETIME.hashCode();
    private boolean __hadSetupdateTime = true;
    public long field_accessTime;
    public String field_appId;
    public String field_appVersionId;
    public String field_cacheFilePath;
    public String field_commLibVersionId;
    public String field_pageURL;
    public long field_updateTime;
    private boolean fjS = true;
    private boolean giM = true;
    private boolean giN = true;
    private boolean giO = true;
    private boolean giP = true;
    private boolean gib = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fkj == hashCode) {
                    this.field_appId = cursor.getString(i2);
                } else if (giQ == hashCode) {
                    this.field_commLibVersionId = cursor.getString(i2);
                } else if (giR == hashCode) {
                    this.field_appVersionId = cursor.getString(i2);
                } else if (giS == hashCode) {
                    this.field_pageURL = cursor.getString(i2);
                } else if (updateTime_HASHCODE == hashCode) {
                    this.field_updateTime = cursor.getLong(i2);
                } else if (gip == hashCode) {
                    this.field_accessTime = cursor.getLong(i2);
                } else if (giT == hashCode) {
                    this.field_cacheFilePath = cursor.getString(i2);
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
        if (this.giM) {
            contentValues.put("commLibVersionId", this.field_commLibVersionId);
        }
        if (this.giN) {
            contentValues.put("appVersionId", this.field_appVersionId);
        }
        if (this.giO) {
            contentValues.put("pageURL", this.field_pageURL);
        }
        if (this.__hadSetupdateTime) {
            contentValues.put(ch.COL_UPDATETIME, Long.valueOf(this.field_updateTime));
        }
        if (this.gib) {
            contentValues.put("accessTime", Long.valueOf(this.field_accessTime));
        }
        if (this.giP) {
            contentValues.put("cacheFilePath", this.field_cacheFilePath);
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
