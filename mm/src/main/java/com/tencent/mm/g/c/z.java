package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class z extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fjf = "msgId".hashCode();
    private static final int fkj = "appId".hashCode();
    private static final int flH = "source".hashCode();
    private static final int fnd = "xml".hashCode();
    private static final int fne = "title".hashCode();
    private static final int fnf = "description".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private static final int type_HASHCODE = "type".hashCode();
    private boolean __hadSettype = true;
    public String field_appId;
    public String field_description;
    public long field_msgId;
    public String field_source;
    public String field_title;
    public int field_type;
    public String field_xml;
    private boolean fjS = true;
    private boolean fjb = true;
    private boolean flC = true;
    private boolean fna = true;
    private boolean fnb = true;
    private boolean fnc = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fjf == hashCode) {
                    this.field_msgId = cursor.getLong(i2);
                    this.fjb = true;
                } else if (fnd == hashCode) {
                    this.field_xml = cursor.getString(i2);
                } else if (fkj == hashCode) {
                    this.field_appId = cursor.getString(i2);
                } else if (fne == hashCode) {
                    this.field_title = cursor.getString(i2);
                } else if (fnf == hashCode) {
                    this.field_description = cursor.getString(i2);
                } else if (flH == hashCode) {
                    this.field_source = cursor.getString(i2);
                } else if (type_HASHCODE == hashCode) {
                    this.field_type = cursor.getInt(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.fjb) {
            contentValues.put("msgId", Long.valueOf(this.field_msgId));
        }
        if (this.fna) {
            contentValues.put("xml", this.field_xml);
        }
        if (this.fjS) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.fnb) {
            contentValues.put("title", this.field_title);
        }
        if (this.fnc) {
            contentValues.put("description", this.field_description);
        }
        if (this.flC) {
            contentValues.put("source", this.field_source);
        }
        if (this.__hadSettype) {
            contentValues.put("type", Integer.valueOf(this.field_type));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
