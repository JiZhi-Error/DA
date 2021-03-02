package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class bu extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int createTime_HASHCODE = "createTime".hashCode();
    private static final int fAi = "msgContent".hashCode();
    private static final int fAj = "svrId".hashCode();
    private static final int fAk = "chatroomName".hashCode();
    private static final int foe = "isSend".hashCode();
    private static final int fqw = "talker".hashCode();
    private static final int fzQ = "encryptTalker".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private static final int type_HASHCODE = "type".hashCode();
    private boolean __hadSetcreateTime = true;
    private boolean __hadSettype = true;
    private boolean fAf = true;
    private boolean fAg = true;
    private boolean fAh = true;
    public String field_chatroomName;
    public long field_createTime;
    public String field_encryptTalker;
    public int field_isSend;
    public String field_msgContent;
    public long field_svrId;
    public String field_talker;
    public int field_type;
    private boolean fnP = true;
    private boolean fqi = true;
    private boolean fzB = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fAi == hashCode) {
                    this.field_msgContent = cursor.getString(i2);
                } else if (foe == hashCode) {
                    this.field_isSend = cursor.getInt(i2);
                } else if (fqw == hashCode) {
                    this.field_talker = cursor.getString(i2);
                } else if (fzQ == hashCode) {
                    this.field_encryptTalker = cursor.getString(i2);
                } else if (fAj == hashCode) {
                    this.field_svrId = cursor.getLong(i2);
                } else if (type_HASHCODE == hashCode) {
                    this.field_type = cursor.getInt(i2);
                } else if (createTime_HASHCODE == hashCode) {
                    this.field_createTime = cursor.getLong(i2);
                } else if (fAk == hashCode) {
                    this.field_chatroomName = cursor.getString(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.field_msgContent == null) {
            this.field_msgContent = "";
        }
        if (this.fAf) {
            contentValues.put("msgContent", this.field_msgContent);
        }
        if (this.fnP) {
            contentValues.put("isSend", Integer.valueOf(this.field_isSend));
        }
        if (this.field_talker == null) {
            this.field_talker = "";
        }
        if (this.fqi) {
            contentValues.put("talker", this.field_talker);
        }
        if (this.field_encryptTalker == null) {
            this.field_encryptTalker = "";
        }
        if (this.fzB) {
            contentValues.put("encryptTalker", this.field_encryptTalker);
        }
        if (this.fAg) {
            contentValues.put("svrId", Long.valueOf(this.field_svrId));
        }
        if (this.__hadSettype) {
            contentValues.put("type", Integer.valueOf(this.field_type));
        }
        if (this.__hadSetcreateTime) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.field_chatroomName == null) {
            this.field_chatroomName = "";
        }
        if (this.fAh) {
            contentValues.put("chatroomName", this.field_chatroomName);
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
