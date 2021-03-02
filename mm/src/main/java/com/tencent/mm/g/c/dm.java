package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class dm extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fLu = "stickToollist".hashCode();
    private static final int fLv = "recentUseToolList".hashCode();
    private static final int fLw = "queryState".hashCode();
    private static final int fsZ = "chatroomname".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private boolean fLr = true;
    private boolean fLs = true;
    private boolean fLt = true;
    public String field_chatroomname;
    public int field_queryState;
    public String field_recentUseToolList;
    public String field_stickToollist;
    private boolean fsz = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fsZ == hashCode) {
                    this.field_chatroomname = cursor.getString(i2);
                    this.fsz = true;
                } else if (fLu == hashCode) {
                    this.field_stickToollist = cursor.getString(i2);
                } else if (fLv == hashCode) {
                    this.field_recentUseToolList = cursor.getString(i2);
                } else if (fLw == hashCode) {
                    this.field_queryState = cursor.getInt(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.fsz) {
            contentValues.put("chatroomname", this.field_chatroomname);
        }
        if (this.fLr) {
            contentValues.put("stickToollist", this.field_stickToollist);
        }
        if (this.fLs) {
            contentValues.put("recentUseToolList", this.field_recentUseToolList);
        }
        if (this.fLt) {
            contentValues.put("queryState", Integer.valueOf(this.field_queryState));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
