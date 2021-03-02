package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class gz extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int createTime_HASHCODE = "createTime".hashCode();
    private static final int frf = "canvasId".hashCode();
    private static final int frg = "canvasXml".hashCode();
    private static final int gcj = "canvasExt".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private boolean __hadSetcreateTime = true;
    public String field_canvasExt;
    public String field_canvasId;
    public String field_canvasXml;
    public long field_createTime;
    private boolean frd = true;
    private boolean fre = true;
    private boolean gci = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (frf == hashCode) {
                    this.field_canvasId = cursor.getString(i2);
                    this.frd = true;
                } else if (frg == hashCode) {
                    this.field_canvasXml = cursor.getString(i2);
                } else if (createTime_HASHCODE == hashCode) {
                    this.field_createTime = cursor.getLong(i2);
                } else if (gcj == hashCode) {
                    this.field_canvasExt = cursor.getString(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.frd) {
            contentValues.put("canvasId", this.field_canvasId);
        }
        if (this.fre) {
            contentValues.put("canvasXml", this.field_canvasXml);
        }
        if (this.__hadSetcreateTime) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.gci) {
            contentValues.put("canvasExt", this.field_canvasExt);
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
