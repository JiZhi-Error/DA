package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class dr extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fMo = "rankID".hashCode();
    private static final int fMp = "appusername".hashCode();
    private static final int fMu = "step".hashCode();
    private static final int fxg = "sort".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private static final int username_HASHCODE = ch.COL_USERNAME.hashCode();
    private boolean __hadSetusername = true;
    private boolean fMl = true;
    private boolean fMm = true;
    private boolean fMt = true;
    public String field_appusername;
    public String field_rankID;
    public int field_sort;
    public int field_step;
    public String field_username;
    private boolean fwG = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fMp == hashCode) {
                    this.field_appusername = cursor.getString(i2);
                } else if (fMo == hashCode) {
                    this.field_rankID = cursor.getString(i2);
                } else if (username_HASHCODE == hashCode) {
                    this.field_username = cursor.getString(i2);
                } else if (fMu == hashCode) {
                    this.field_step = cursor.getInt(i2);
                } else if (fxg == hashCode) {
                    this.field_sort = cursor.getInt(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.fMm) {
            contentValues.put("appusername", this.field_appusername);
        }
        if (this.fMl) {
            contentValues.put("rankID", this.field_rankID);
        }
        if (this.__hadSetusername) {
            contentValues.put(ch.COL_USERNAME, this.field_username);
        }
        if (this.fMt) {
            contentValues.put("step", Integer.valueOf(this.field_step));
        }
        if (this.fwG) {
            contentValues.put("sort", Integer.valueOf(this.field_sort));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
