package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class bm extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fyW = "desc".hashCode();
    private static final int fza = "groupID".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    public String field_desc;
    public String field_groupID;
    private boolean fyS = true;
    private boolean fyZ = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fza == hashCode) {
                    this.field_groupID = cursor.getString(i2);
                } else if (fyW == hashCode) {
                    this.field_desc = cursor.getString(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.fyZ) {
            contentValues.put("groupID", this.field_groupID);
        }
        if (this.fyS) {
            contentValues.put("desc", this.field_desc);
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
