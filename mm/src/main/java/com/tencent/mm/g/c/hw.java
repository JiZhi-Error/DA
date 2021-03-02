package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class hw extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fjf = "msgId".hashCode();
    private static final int fkH = "path".hashCode();
    private static final int fkX = "size".hashCode();
    private static final int fof = "msgType".hashCode();
    private static final int giK = "msgSubType".hashCode();
    private static final int giL = "msgtime".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private static final int username_HASHCODE = ch.COL_USERNAME.hashCode();
    private boolean __hadSetusername = true;
    public long field_msgId;
    public int field_msgSubType;
    public int field_msgType;
    public long field_msgtime;
    public String field_path;
    public long field_size;
    public String field_username;
    private boolean fjb = true;
    private boolean fkD = true;
    private boolean fkV = true;
    private boolean fnQ = true;
    private boolean giI = true;
    private boolean giJ = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fjf == hashCode) {
                    this.field_msgId = cursor.getLong(i2);
                } else if (username_HASHCODE == hashCode) {
                    this.field_username = cursor.getString(i2);
                } else if (fof == hashCode) {
                    this.field_msgType = cursor.getInt(i2);
                } else if (giK == hashCode) {
                    this.field_msgSubType = cursor.getInt(i2);
                } else if (fkH == hashCode) {
                    this.field_path = cursor.getString(i2);
                } else if (fkX == hashCode) {
                    this.field_size = cursor.getLong(i2);
                } else if (giL == hashCode) {
                    this.field_msgtime = cursor.getLong(i2);
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
        if (this.__hadSetusername) {
            contentValues.put(ch.COL_USERNAME, this.field_username);
        }
        if (this.fnQ) {
            contentValues.put("msgType", Integer.valueOf(this.field_msgType));
        }
        if (this.giI) {
            contentValues.put("msgSubType", Integer.valueOf(this.field_msgSubType));
        }
        if (this.fkD) {
            contentValues.put("path", this.field_path);
        }
        if (this.fkV) {
            contentValues.put("size", Long.valueOf(this.field_size));
        }
        if (this.giJ) {
            contentValues.put("msgtime", Long.valueOf(this.field_msgtime));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
