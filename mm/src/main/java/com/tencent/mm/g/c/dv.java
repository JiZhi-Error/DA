package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class dv extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int content_HASHCODE = "content".hashCode();
    private static final int fAj = "svrId".hashCode();
    private static final int fMN = "pushTime".hashCode();
    private static final int fMO = "descUrl".hashCode();
    private static final int fne = "title".hashCode();
    private static final int fof = "msgType".hashCode();
    private static final int fqF = "isRead".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private boolean __hadSetcontent = true;
    private boolean fAg = true;
    private boolean fML = true;
    private boolean fMM = true;
    public String field_content;
    public String field_descUrl;
    public short field_isRead;
    public int field_msgType;
    public long field_pushTime;
    public long field_svrId;
    public String field_title;
    private boolean fnQ = true;
    private boolean fnb = true;
    private boolean fqr = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fAj == hashCode) {
                    this.field_svrId = cursor.getLong(i2);
                    this.fAg = true;
                } else if (fqF == hashCode) {
                    this.field_isRead = cursor.getShort(i2);
                } else if (fne == hashCode) {
                    this.field_title = cursor.getString(i2);
                } else if (content_HASHCODE == hashCode) {
                    this.field_content = cursor.getString(i2);
                } else if (fMN == hashCode) {
                    this.field_pushTime = cursor.getLong(i2);
                } else if (fof == hashCode) {
                    this.field_msgType = cursor.getInt(i2);
                } else if (fMO == hashCode) {
                    this.field_descUrl = cursor.getString(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.fAg) {
            contentValues.put("svrId", Long.valueOf(this.field_svrId));
        }
        if (this.fqr) {
            contentValues.put("isRead", Short.valueOf(this.field_isRead));
        }
        if (this.fnb) {
            contentValues.put("title", this.field_title);
        }
        if (this.__hadSetcontent) {
            contentValues.put("content", this.field_content);
        }
        if (this.fML) {
            contentValues.put("pushTime", Long.valueOf(this.field_pushTime));
        }
        if (this.fnQ) {
            contentValues.put("msgType", Integer.valueOf(this.field_msgType));
        }
        if (this.fMM) {
            contentValues.put("descUrl", this.field_descUrl);
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
