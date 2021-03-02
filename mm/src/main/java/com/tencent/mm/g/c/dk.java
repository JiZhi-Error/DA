package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class dk extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int content_HASHCODE = "content".hashCode();
    private static final int fKQ = "creator".hashCode();
    private static final int fKR = "num".hashCode();
    private static final int fKS = "firstMsgId".hashCode();
    private static final int fKT = "active".hashCode();
    private static final int fKU = "lastActiveTime".hashCode();
    private static final int fqv = "msgSvrId".hashCode();
    private static final int key_HASHCODE = "key".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private static final int username_HASHCODE = ch.COL_USERNAME.hashCode();
    private boolean __hadSetcontent = true;
    private boolean __hadSetkey = true;
    private boolean __hadSetusername = true;
    private boolean fKL = true;
    private boolean fKM = true;
    private boolean fKN = true;
    private boolean fKO = true;
    private boolean fKP = true;
    public int field_active;
    public String field_content;
    public String field_creator;
    public long field_firstMsgId;
    public String field_key;
    public long field_lastActiveTime;
    public long field_msgSvrId;
    public int field_num;
    public String field_username;
    private boolean fqh = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (username_HASHCODE == hashCode) {
                    this.field_username = cursor.getString(i2);
                } else if (key_HASHCODE == hashCode) {
                    this.field_key = cursor.getString(i2);
                } else if (content_HASHCODE == hashCode) {
                    this.field_content = cursor.getString(i2);
                } else if (fKQ == hashCode) {
                    this.field_creator = cursor.getString(i2);
                } else if (fKR == hashCode) {
                    this.field_num = cursor.getInt(i2);
                } else if (fKS == hashCode) {
                    this.field_firstMsgId = cursor.getLong(i2);
                } else if (fqv == hashCode) {
                    this.field_msgSvrId = cursor.getLong(i2);
                } else if (fKT == hashCode) {
                    this.field_active = cursor.getInt(i2);
                } else if (fKU == hashCode) {
                    this.field_lastActiveTime = cursor.getLong(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.__hadSetusername) {
            contentValues.put(ch.COL_USERNAME, this.field_username);
        }
        if (this.__hadSetkey) {
            contentValues.put("key", this.field_key);
        }
        if (this.__hadSetcontent) {
            contentValues.put("content", this.field_content);
        }
        if (this.fKL) {
            contentValues.put("creator", this.field_creator);
        }
        if (this.fKM) {
            contentValues.put("num", Integer.valueOf(this.field_num));
        }
        if (this.fKN) {
            contentValues.put("firstMsgId", Long.valueOf(this.field_firstMsgId));
        }
        if (this.fqh) {
            contentValues.put("msgSvrId", Long.valueOf(this.field_msgSvrId));
        }
        if (this.fKO) {
            contentValues.put("active", Integer.valueOf(this.field_active));
        }
        if (this.fKP) {
            contentValues.put("lastActiveTime", Long.valueOf(this.field_lastActiveTime));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
