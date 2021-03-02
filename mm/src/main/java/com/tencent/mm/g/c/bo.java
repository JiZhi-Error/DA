package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class bo extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int content_HASHCODE = "content".hashCode();
    private static final int fwT = "productID".hashCode();
    private static final int fze = "lan".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private boolean __hadSetcontent = true;
    public byte[] field_content;
    public String field_lan;
    public String field_productID;
    private boolean fwt = true;
    private boolean fzd = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fwT == hashCode) {
                    this.field_productID = cursor.getString(i2);
                    this.fwt = true;
                } else if (content_HASHCODE == hashCode) {
                    this.field_content = cursor.getBlob(i2);
                } else if (fze == hashCode) {
                    this.field_lan = cursor.getString(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.fwt) {
            contentValues.put("productID", this.field_productID);
        }
        if (this.__hadSetcontent) {
            contentValues.put("content", this.field_content);
        }
        if (this.field_lan == null) {
            this.field_lan = "";
        }
        if (this.fzd) {
            contentValues.put("lan", this.field_lan);
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
