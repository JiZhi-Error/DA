package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class ig extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int createTime_HASHCODE = "createTime".hashCode();
    private static final int fGE = "UserName".hashCode();
    private static final int fly = "debugType".hashCode();
    private static final int gjW = "RecordId".hashCode();
    private static final int gjX = "AppId".hashCode();
    private static final int gjY = "AppName".hashCode();
    private static final int gjZ = "IconUrl".hashCode();
    private static final int gka = "BriefIntro".hashCode();
    private static final int gkb = "isSync".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private boolean __hadSetcreateTime;
    private boolean fGw;
    public String field_AppId;
    public String field_AppName;
    public String field_BriefIntro;
    public String field_IconUrl;
    public String field_RecordId;
    public String field_UserName;
    public long field_createTime;
    public int field_debugType;
    public boolean field_isSync;
    private boolean flt;
    private boolean gjQ;
    private boolean gjR;
    private boolean gjS;
    private boolean gjT;
    private boolean gjU;
    private boolean gjV;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (gjW == hashCode) {
                    this.field_RecordId = cursor.getString(i2);
                    this.gjQ = true;
                } else if (gjX == hashCode) {
                    this.field_AppId = cursor.getString(i2);
                } else if (gjY == hashCode) {
                    this.field_AppName = cursor.getString(i2);
                } else if (fGE == hashCode) {
                    this.field_UserName = cursor.getString(i2);
                } else if (gjZ == hashCode) {
                    this.field_IconUrl = cursor.getString(i2);
                } else if (gka == hashCode) {
                    this.field_BriefIntro = cursor.getString(i2);
                } else if (gkb == hashCode) {
                    this.field_isSync = cursor.getInt(i2) != 0;
                } else if (fly == hashCode) {
                    this.field_debugType = cursor.getInt(i2);
                } else if (createTime_HASHCODE == hashCode) {
                    this.field_createTime = cursor.getLong(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.gjQ) {
            contentValues.put("RecordId", this.field_RecordId);
        }
        if (this.gjR) {
            contentValues.put("AppId", this.field_AppId);
        }
        if (this.gjS) {
            contentValues.put("AppName", this.field_AppName);
        }
        if (this.fGw) {
            contentValues.put("UserName", this.field_UserName);
        }
        if (this.gjT) {
            contentValues.put("IconUrl", this.field_IconUrl);
        }
        if (this.gjU) {
            contentValues.put("BriefIntro", this.field_BriefIntro);
        }
        if (this.gjV) {
            contentValues.put("isSync", Boolean.valueOf(this.field_isSync));
        }
        if (this.flt) {
            contentValues.put("debugType", Integer.valueOf(this.field_debugType));
        }
        if (this.__hadSetcreateTime) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
