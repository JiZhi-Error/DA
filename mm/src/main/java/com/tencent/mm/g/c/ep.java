package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class ep extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fRj = "quotedMsgId".hashCode();
    private static final int fRk = "quotedMsgSvrId".hashCode();
    private static final int fjf = "msgId".hashCode();
    private static final int fjl = "status".hashCode();
    private static final int fqv = "msgSvrId".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private boolean fRh = true;
    private boolean fRi = true;
    public long field_msgId;
    public long field_msgSvrId;
    public long field_quotedMsgId;
    public long field_quotedMsgSvrId;
    public int field_status;
    private boolean fjb = true;
    private boolean fji = true;
    private boolean fqh = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fjf == hashCode) {
                    this.field_msgId = cursor.getLong(i2);
                } else if (fqv == hashCode) {
                    this.field_msgSvrId = cursor.getLong(i2);
                } else if (fRj == hashCode) {
                    this.field_quotedMsgId = cursor.getLong(i2);
                } else if (fRk == hashCode) {
                    this.field_quotedMsgSvrId = cursor.getLong(i2);
                } else if (fjl == hashCode) {
                    this.field_status = cursor.getInt(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.fjb) {
            contentValues.put("msgId", Long.valueOf(this.field_msgId));
        }
        if (this.fqh) {
            contentValues.put("msgSvrId", Long.valueOf(this.field_msgSvrId));
        }
        if (this.fRh) {
            contentValues.put("quotedMsgId", Long.valueOf(this.field_quotedMsgId));
        }
        if (this.fRi) {
            contentValues.put("quotedMsgSvrId", Long.valueOf(this.field_quotedMsgSvrId));
        }
        if (this.fji) {
            contentValues.put("status", Integer.valueOf(this.field_status));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
