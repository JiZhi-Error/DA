package com.tencent.mm.plugin.shake.a.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class b extends IAutoDBItem {
    private static final int Dgy = "lastshaketime".hashCode();
    private static final int Dgz = "isshowed".hashCode();
    public static final String[] INDEX_CREATE = new String[0];
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private static final int username_HASHCODE = ch.COL_USERNAME.hashCode();
    private boolean Dgw;
    private boolean Dgx;
    private boolean __hadSetusername;
    public boolean field_isshowed;
    public int field_lastshaketime;
    public String field_username;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (username_HASHCODE == hashCode) {
                    this.field_username = cursor.getString(i2);
                    this.__hadSetusername = true;
                } else if (Dgy == hashCode) {
                    this.field_lastshaketime = cursor.getInt(i2);
                } else if (Dgz == hashCode) {
                    this.field_isshowed = cursor.getInt(i2) != 0;
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.field_username == null) {
            this.field_username = "";
        }
        if (this.__hadSetusername) {
            contentValues.put(ch.COL_USERNAME, this.field_username);
        }
        if (this.Dgw) {
            contentValues.put("lastshaketime", Integer.valueOf(this.field_lastshaketime));
        }
        if (this.Dgx) {
            contentValues.put("isshowed", Boolean.valueOf(this.field_isshowed));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
