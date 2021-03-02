package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class ex extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fTO = "reqkey".hashCode();
    private static final int fTP = "ack_key".hashCode();
    private static final int fTQ = "receive_time".hashCode();
    private static final int fjl = "status".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private boolean fTL = true;
    private boolean fTM = true;
    private boolean fTN = true;
    public String field_ack_key;
    public long field_receive_time;
    public String field_reqkey;
    public int field_status;
    private boolean fji = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fTO == hashCode) {
                    this.field_reqkey = cursor.getString(i2);
                    this.fTL = true;
                } else if (fTP == hashCode) {
                    this.field_ack_key = cursor.getString(i2);
                } else if (fjl == hashCode) {
                    this.field_status = cursor.getInt(i2);
                } else if (fTQ == hashCode) {
                    this.field_receive_time = cursor.getLong(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.fTL) {
            contentValues.put("reqkey", this.field_reqkey);
        }
        if (this.fTM) {
            contentValues.put("ack_key", this.field_ack_key);
        }
        if (this.fji) {
            contentValues.put("status", Integer.valueOf(this.field_status));
        }
        if (this.fTN) {
            contentValues.put("receive_time", Long.valueOf(this.field_receive_time));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
