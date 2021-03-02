package com.tencent.mm.plugin.shake.a.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class c extends IAutoDBItem {
    private static final int DgC = "deeplink".hashCode();
    private static final int DgD = "iconurl".hashCode();
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fLi = "createtime".hashCode();
    private static final int fne = "title".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private static final int username_HASHCODE = ch.COL_USERNAME.hashCode();
    private boolean DgA = true;
    private boolean DgB = true;
    private boolean __hadSetusername = true;
    private boolean fKX = true;
    public long field_createtime;
    public String field_deeplink;
    public String field_iconurl;
    public String field_title;
    public String field_username;
    private boolean fnb = true;

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
                } else if (DgC == hashCode) {
                    this.field_deeplink = cursor.getString(i2);
                } else if (fne == hashCode) {
                    this.field_title = cursor.getString(i2);
                } else if (DgD == hashCode) {
                    this.field_iconurl = cursor.getString(i2);
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
        if (this.field_username == null) {
            this.field_username = "";
        }
        if (this.__hadSetusername) {
            contentValues.put(ch.COL_USERNAME, this.field_username);
        }
        if (this.field_deeplink == null) {
            this.field_deeplink = "";
        }
        if (this.DgA) {
            contentValues.put("deeplink", this.field_deeplink);
        }
        if (this.field_title == null) {
            this.field_title = "";
        }
        if (this.fnb) {
            contentValues.put("title", this.field_title);
        }
        if (this.field_iconurl == null) {
            this.field_iconurl = "";
        }
        if (this.DgB) {
            contentValues.put("iconurl", this.field_iconurl);
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
