package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class bs extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fzA = "exptKey".hashCode();
    private static final int fzu = "exptId".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    public int field_exptId;
    public String field_exptKey;
    private boolean fzp = true;
    private boolean fzz = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fzA == hashCode) {
                    this.field_exptKey = cursor.getString(i2);
                    this.fzz = true;
                } else if (fzu == hashCode) {
                    this.field_exptId = cursor.getInt(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.fzz) {
            contentValues.put("exptKey", this.field_exptKey);
        }
        if (this.fzp) {
            contentValues.put("exptId", Integer.valueOf(this.field_exptId));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
