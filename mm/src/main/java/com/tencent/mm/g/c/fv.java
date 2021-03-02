package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class fv extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fLi = "createtime".hashCode();
    private static final int fXv = "uid".hashCode();
    private static final int fXw = "devicetype".hashCode();
    private static final int fyk = "name".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private boolean fKX = true;
    private boolean fXt = true;
    private boolean fXu = true;
    public long field_createtime;
    public String field_devicetype;
    public String field_name;
    public String field_uid;
    private boolean fxy = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fXv == hashCode) {
                    this.field_uid = cursor.getString(i2);
                    this.fXt = true;
                } else if (fyk == hashCode) {
                    this.field_name = cursor.getString(i2);
                } else if (fXw == hashCode) {
                    this.field_devicetype = cursor.getString(i2);
                } else if (fLi == hashCode) {
                    this.field_createtime = cursor.getLong(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.field_uid == null) {
            this.field_uid = "";
        }
        if (this.fXt) {
            contentValues.put("uid", this.field_uid);
        }
        if (this.field_name == null) {
            this.field_name = "";
        }
        if (this.fxy) {
            contentValues.put("name", this.field_name);
        }
        if (this.field_devicetype == null) {
            this.field_devicetype = "";
        }
        if (this.fXu) {
            contentValues.put("devicetype", this.field_devicetype);
        }
        if (this.fKX) {
            contentValues.put("createtime", Long.valueOf(this.field_createtime));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
