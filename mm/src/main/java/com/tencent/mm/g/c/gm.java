package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class gm extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fxs = "count".hashCode();
    private static final int gav = "tagId".hashCode();
    private static final int gaw = "tagName".hashCode();
    private static final int gax = "memberList".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    public int field_count;
    public String field_memberList;
    public long field_tagId;
    public String field_tagName;
    private boolean fwS = true;
    private boolean gas = true;
    private boolean gat = true;
    private boolean gau = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (gav == hashCode) {
                    this.field_tagId = cursor.getLong(i2);
                } else if (gaw == hashCode) {
                    this.field_tagName = cursor.getString(i2);
                } else if (fxs == hashCode) {
                    this.field_count = cursor.getInt(i2);
                } else if (gax == hashCode) {
                    this.field_memberList = cursor.getString(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.gas) {
            contentValues.put("tagId", Long.valueOf(this.field_tagId));
        }
        if (this.field_tagName == null) {
            this.field_tagName = "";
        }
        if (this.gat) {
            contentValues.put("tagName", this.field_tagName);
        }
        if (this.fwS) {
            contentValues.put("count", Integer.valueOf(this.field_count));
        }
        if (this.field_memberList == null) {
            this.field_memberList = "";
        }
        if (this.gau) {
            contentValues.put("memberList", this.field_memberList);
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
