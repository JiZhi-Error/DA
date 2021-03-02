package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class ho extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fPE = "timeStamp".hashCode();
    private static final int flH = "source".hashCode();
    private static final int flc = "recordId".hashCode();
    private static final int fne = "title".hashCode();
    private static final int ghu = "link".hashCode();
    private static final int ghv = "imgUrl".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private boolean fPy = true;
    public String field_imgUrl;
    public String field_link;
    public String field_recordId;
    public String field_source;
    public long field_timeStamp;
    public String field_title;
    private boolean fkY = true;
    private boolean flC = true;
    private boolean fnb = true;
    private boolean ghs = true;
    private boolean ght = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (flc == hashCode) {
                    this.field_recordId = cursor.getString(i2);
                    this.fkY = true;
                } else if (ghu == hashCode) {
                    this.field_link = cursor.getString(i2);
                } else if (fne == hashCode) {
                    this.field_title = cursor.getString(i2);
                } else if (flH == hashCode) {
                    this.field_source = cursor.getString(i2);
                } else if (ghv == hashCode) {
                    this.field_imgUrl = cursor.getString(i2);
                } else if (fPE == hashCode) {
                    this.field_timeStamp = cursor.getLong(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.fkY) {
            contentValues.put("recordId", this.field_recordId);
        }
        if (this.ghs) {
            contentValues.put("link", this.field_link);
        }
        if (this.fnb) {
            contentValues.put("title", this.field_title);
        }
        if (this.flC) {
            contentValues.put("source", this.field_source);
        }
        if (this.ght) {
            contentValues.put("imgUrl", this.field_imgUrl);
        }
        if (this.fPy) {
            contentValues.put("timeStamp", Long.valueOf(this.field_timeStamp));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
