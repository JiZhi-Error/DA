package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class gd extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fDK = "retryCount".hashCode();
    private static final int fQg = "update_time".hashCode();
    private static final int fTY = "seq".hashCode();
    private static final int fYO = "state_flag".hashCode();
    private static final int frD = "card_id".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private boolean fDu = true;
    private boolean fPY = true;
    private boolean fTU = true;
    private boolean fYN = true;
    public String field_card_id;
    public int field_retryCount;
    public long field_seq;
    public int field_state_flag;
    public long field_update_time;
    private boolean frk = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (frD == hashCode) {
                    this.field_card_id = cursor.getString(i2);
                    this.frk = true;
                } else if (fYO == hashCode) {
                    this.field_state_flag = cursor.getInt(i2);
                } else if (fQg == hashCode) {
                    this.field_update_time = cursor.getLong(i2);
                } else if (fTY == hashCode) {
                    this.field_seq = cursor.getLong(i2);
                } else if (fDK == hashCode) {
                    this.field_retryCount = cursor.getInt(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.frk) {
            contentValues.put("card_id", this.field_card_id);
        }
        if (this.fYN) {
            contentValues.put("state_flag", Integer.valueOf(this.field_state_flag));
        }
        if (this.fPY) {
            contentValues.put("update_time", Long.valueOf(this.field_update_time));
        }
        if (this.fTU) {
            contentValues.put("seq", Long.valueOf(this.field_seq));
        }
        if (this.fDu) {
            contentValues.put("retryCount", Integer.valueOf(this.field_retryCount));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
