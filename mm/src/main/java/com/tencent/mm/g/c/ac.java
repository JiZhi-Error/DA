package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class ac extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fno = "sessionName".hashCode();
    private static final int fnr = "msgListDataId".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    public String field_msgListDataId;
    public String field_sessionName;
    private boolean fnl = true;
    private boolean fnq = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fnr == hashCode) {
                    this.field_msgListDataId = cursor.getString(i2);
                    this.fnq = true;
                } else if (fno == hashCode) {
                    this.field_sessionName = cursor.getString(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.fnq) {
            contentValues.put("msgListDataId", this.field_msgListDataId);
        }
        if (this.field_sessionName == null) {
            this.field_sessionName = "";
        }
        if (this.fnl) {
            contentValues.put("sessionName", this.field_sessionName);
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
