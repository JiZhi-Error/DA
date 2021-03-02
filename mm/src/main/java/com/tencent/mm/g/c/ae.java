package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class ae extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fjf = "msgId".hashCode();
    private static final int fnu = "aId".hashCode();
    private static final int fnv = "exposeTime".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    public String field_aId;
    public long field_exposeTime;
    public long field_msgId;
    private boolean fjb = true;
    private boolean fns = true;
    private boolean fnt = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fnu == hashCode) {
                    this.field_aId = cursor.getString(i2);
                    this.fns = true;
                } else if (fjf == hashCode) {
                    this.field_msgId = cursor.getLong(i2);
                } else if (fnv == hashCode) {
                    this.field_exposeTime = cursor.getLong(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.fns) {
            contentValues.put("aId", this.field_aId);
        }
        if (this.fjb) {
            contentValues.put("msgId", Long.valueOf(this.field_msgId));
        }
        if (this.fnt) {
            contentValues.put("exposeTime", Long.valueOf(this.field_exposeTime));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
