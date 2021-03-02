package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class am extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fmt = "openId".hashCode();
    private static final int fqd = "brandUsername".hashCode();
    private static final int fqe = "headImgUrl".hashCode();
    private static final int fqf = "nickname".hashCode();
    private static final int fqg = "kfType".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private static final int updateTime_HASHCODE = ch.COL_UPDATETIME.hashCode();
    private boolean __hadSetupdateTime = true;
    public String field_brandUsername;
    public String field_headImgUrl;
    public int field_kfType;
    public String field_nickname;
    public String field_openId;
    public long field_updateTime;
    private boolean flX = true;
    private boolean fpZ = true;
    private boolean fqa = true;
    private boolean fqb = true;
    private boolean fqc = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fmt == hashCode) {
                    this.field_openId = cursor.getString(i2);
                    this.flX = true;
                } else if (fqd == hashCode) {
                    this.field_brandUsername = cursor.getString(i2);
                } else if (fqe == hashCode) {
                    this.field_headImgUrl = cursor.getString(i2);
                } else if (fqf == hashCode) {
                    this.field_nickname = cursor.getString(i2);
                } else if (fqg == hashCode) {
                    this.field_kfType = cursor.getInt(i2);
                } else if (updateTime_HASHCODE == hashCode) {
                    this.field_updateTime = cursor.getLong(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.flX) {
            contentValues.put("openId", this.field_openId);
        }
        if (this.field_brandUsername == null) {
            this.field_brandUsername = "";
        }
        if (this.fpZ) {
            contentValues.put("brandUsername", this.field_brandUsername);
        }
        if (this.fqa) {
            contentValues.put("headImgUrl", this.field_headImgUrl);
        }
        if (this.fqb) {
            contentValues.put("nickname", this.field_nickname);
        }
        if (this.fqc) {
            contentValues.put("kfType", Integer.valueOf(this.field_kfType));
        }
        if (this.__hadSetupdateTime) {
            contentValues.put(ch.COL_UPDATETIME, Long.valueOf(this.field_updateTime));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
