package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class ie extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int content_HASHCODE = "content".hashCode();
    private static final int fUw = "msgState".hashCode();
    private static final int gjK = "shareKeyHash".hashCode();
    private static final int gjL = "btnState".hashCode();
    private static final int gjM = "contentColor".hashCode();
    private static final int gjN = "updatePeroid".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private boolean __hadSetcontent = true;
    private boolean fUt = true;
    public int field_btnState;
    public String field_content;
    public String field_contentColor;
    public int field_msgState;
    public int field_shareKeyHash;
    public int field_updatePeroid;
    private boolean gjG = true;
    private boolean gjH = true;
    private boolean gjI = true;
    private boolean gjJ = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (gjK == hashCode) {
                    this.field_shareKeyHash = cursor.getInt(i2);
                    this.gjG = true;
                } else if (gjL == hashCode) {
                    this.field_btnState = cursor.getInt(i2);
                } else if (fUw == hashCode) {
                    this.field_msgState = cursor.getInt(i2);
                } else if (content_HASHCODE == hashCode) {
                    this.field_content = cursor.getString(i2);
                } else if (gjM == hashCode) {
                    this.field_contentColor = cursor.getString(i2);
                } else if (gjN == hashCode) {
                    this.field_updatePeroid = cursor.getInt(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.gjG) {
            contentValues.put("shareKeyHash", Integer.valueOf(this.field_shareKeyHash));
        }
        if (this.gjH) {
            contentValues.put("btnState", Integer.valueOf(this.field_btnState));
        }
        if (this.fUt) {
            contentValues.put("msgState", Integer.valueOf(this.field_msgState));
        }
        if (this.__hadSetcontent) {
            contentValues.put("content", this.field_content);
        }
        if (this.gjI) {
            contentValues.put("contentColor", this.field_contentColor);
        }
        if (this.gjJ) {
            contentValues.put("updatePeroid", Integer.valueOf(this.field_updatePeroid));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
