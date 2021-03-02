package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class aw extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int createTime_HASHCODE = "createTime".hashCode();
    private static final int fkX = "size".hashCode();
    private static final int fmm = "modifyTime".hashCode();
    private static final int ftM = "deleteTime".hashCode();
    private static final int ftN = "saveTime".hashCode();
    private static final int ftO = "flags".hashCode();
    private static final int id_HASHCODE = "id".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private boolean __hadSetcreateTime = true;
    private boolean __hadSetid = true;
    public long field_createTime;
    public long field_deleteTime;
    public long field_flags;
    public String field_id;
    public long field_modifyTime;
    public long field_saveTime;
    public long field_size;
    private boolean fkV = true;
    private boolean flQ = true;
    private boolean ftJ = true;
    private boolean ftK = true;
    private boolean ftL = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (createTime_HASHCODE == hashCode) {
                    this.field_createTime = cursor.getLong(i2);
                } else if (fmm == hashCode) {
                    this.field_modifyTime = cursor.getLong(i2);
                } else if (ftM == hashCode) {
                    this.field_deleteTime = cursor.getLong(i2);
                } else if (id_HASHCODE == hashCode) {
                    this.field_id = cursor.getString(i2);
                } else if (ftN == hashCode) {
                    this.field_saveTime = cursor.getLong(i2);
                } else if (fkX == hashCode) {
                    this.field_size = cursor.getLong(i2);
                } else if (ftO == hashCode) {
                    this.field_flags = cursor.getLong(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.__hadSetcreateTime) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.flQ) {
            contentValues.put("modifyTime", Long.valueOf(this.field_modifyTime));
        }
        if (this.ftJ) {
            contentValues.put("deleteTime", Long.valueOf(this.field_deleteTime));
        }
        if (this.field_id == null) {
            this.field_id = "";
        }
        if (this.__hadSetid) {
            contentValues.put("id", this.field_id);
        }
        if (this.ftK) {
            contentValues.put("saveTime", Long.valueOf(this.field_saveTime));
        }
        if (this.fkV) {
            contentValues.put("size", Long.valueOf(this.field_size));
        }
        if (this.ftL) {
            contentValues.put("flags", Long.valueOf(this.field_flags));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
