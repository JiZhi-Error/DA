package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class fs extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fWm = "locaMsgId".hashCode();
    private static final int fWn = "receiveStatus".hashCode();
    private static final int fWo = "invalidtime".hashCode();
    private static final int foe = "isSend".hashCode();
    private static final int fqw = "talker".hashCode();
    private static final int fwc = "transferId".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private boolean fWj = true;
    private boolean fWk = true;
    private boolean fWl = true;
    public long field_invalidtime;
    public boolean field_isSend;
    public long field_locaMsgId;
    public int field_receiveStatus;
    public String field_talker;
    public String field_transferId;
    private boolean fnP = true;
    private boolean fqi = true;
    private boolean fwb = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fwc == hashCode) {
                    this.field_transferId = cursor.getString(i2);
                    this.fwb = true;
                } else if (fWm == hashCode) {
                    this.field_locaMsgId = cursor.getLong(i2);
                } else if (fWn == hashCode) {
                    this.field_receiveStatus = cursor.getInt(i2);
                } else if (foe == hashCode) {
                    this.field_isSend = cursor.getInt(i2) != 0;
                } else if (fqw == hashCode) {
                    this.field_talker = cursor.getString(i2);
                } else if (fWo == hashCode) {
                    this.field_invalidtime = cursor.getLong(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.fwb) {
            contentValues.put("transferId", this.field_transferId);
        }
        if (this.fWj) {
            contentValues.put("locaMsgId", Long.valueOf(this.field_locaMsgId));
        }
        if (this.fWk) {
            contentValues.put("receiveStatus", Integer.valueOf(this.field_receiveStatus));
        }
        if (this.fnP) {
            contentValues.put("isSend", Boolean.valueOf(this.field_isSend));
        }
        if (this.fqi) {
            contentValues.put("talker", this.field_talker);
        }
        if (this.fWl) {
            contentValues.put("invalidtime", Long.valueOf(this.field_invalidtime));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
