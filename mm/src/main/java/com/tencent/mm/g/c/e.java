package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class e extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fjL = "mau".hashCode();
    private static final int fjM = "dau".hashCode();
    private static final int fjN = "useTime".hashCode();
    private static final int key_HASHCODE = "key".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private boolean __hadSetkey = true;
    public int field_dau;
    public int field_key;
    public int field_mau;
    public long field_useTime;
    private boolean fjI = true;
    private boolean fjJ = true;
    private boolean fjK = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (key_HASHCODE == hashCode) {
                    this.field_key = cursor.getInt(i2);
                    this.__hadSetkey = true;
                } else if (fjL == hashCode) {
                    this.field_mau = cursor.getInt(i2);
                } else if (fjM == hashCode) {
                    this.field_dau = cursor.getInt(i2);
                } else if (fjN == hashCode) {
                    this.field_useTime = cursor.getLong(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.__hadSetkey) {
            contentValues.put("key", Integer.valueOf(this.field_key));
        }
        if (this.fjI) {
            contentValues.put("mau", Integer.valueOf(this.field_mau));
        }
        if (this.fjJ) {
            contentValues.put("dau", Integer.valueOf(this.field_dau));
        }
        if (this.fjK) {
            contentValues.put("useTime", Long.valueOf(this.field_useTime));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
