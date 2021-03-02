package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class hf extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int geP = "bulletin_scene".hashCode();
    private static final int geQ = "bulletin_content".hashCode();
    private static final int geR = "bulletin_url".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    public String field_bulletin_content;
    public String field_bulletin_scene;
    public String field_bulletin_url;
    private boolean geM = true;
    private boolean geN = true;
    private boolean geO = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (geP == hashCode) {
                    this.field_bulletin_scene = cursor.getString(i2);
                    this.geM = true;
                } else if (geQ == hashCode) {
                    this.field_bulletin_content = cursor.getString(i2);
                } else if (geR == hashCode) {
                    this.field_bulletin_url = cursor.getString(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.geM) {
            contentValues.put("bulletin_scene", this.field_bulletin_scene);
        }
        if (this.geN) {
            contentValues.put("bulletin_content", this.field_bulletin_content);
        }
        if (this.geO) {
            contentValues.put("bulletin_url", this.field_bulletin_url);
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
