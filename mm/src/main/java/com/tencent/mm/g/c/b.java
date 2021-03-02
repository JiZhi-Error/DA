package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class b extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fjd = "insertmsg".hashCode();
    private static final int fjj = "billNo".hashCode();
    private static final int fjk = "localMsgId".hashCode();
    private static final int fjl = "status".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private boolean fiZ = true;
    public String field_billNo;
    public boolean field_insertmsg;
    public long field_localMsgId;
    public int field_status;
    private boolean fjg = true;
    private boolean fjh = true;
    private boolean fji = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fjj == hashCode) {
                    this.field_billNo = cursor.getString(i2);
                    this.fjg = true;
                } else if (fjd == hashCode) {
                    this.field_insertmsg = cursor.getInt(i2) != 0;
                } else if (fjk == hashCode) {
                    this.field_localMsgId = cursor.getLong(i2);
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
        if (this.fjg) {
            contentValues.put("billNo", this.field_billNo);
        }
        if (this.fiZ) {
            contentValues.put("insertmsg", Boolean.valueOf(this.field_insertmsg));
        }
        if (this.fjh) {
            contentValues.put("localMsgId", Long.valueOf(this.field_localMsgId));
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
