package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class cu extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fmm = "modifyTime".hashCode();
    private static final int fus = "encryptUsername".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private static final int username_HASHCODE = ch.COL_USERNAME.hashCode();
    private boolean __hadSetusername = true;
    public String field_encryptUsername;
    public long field_modifyTime;
    public String field_username;
    private boolean flQ = true;
    private boolean fua = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fus == hashCode) {
                    this.field_encryptUsername = cursor.getString(i2);
                    this.fua = true;
                } else if (username_HASHCODE == hashCode) {
                    this.field_username = cursor.getString(i2);
                } else if (fmm == hashCode) {
                    this.field_modifyTime = cursor.getLong(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.field_encryptUsername == null) {
            this.field_encryptUsername = "";
        }
        if (this.fua) {
            contentValues.put("encryptUsername", this.field_encryptUsername);
        }
        if (this.field_username == null) {
            this.field_username = "";
        }
        if (this.__hadSetusername) {
            contentValues.put(ch.COL_USERNAME, this.field_username);
        }
        if (this.flQ) {
            contentValues.put("modifyTime", Long.valueOf(this.field_modifyTime));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
