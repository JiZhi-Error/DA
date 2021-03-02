package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class dh extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int content_HASHCODE = "content".hashCode();
    private static final int createTime_HASHCODE = "createTime".hashCode();
    private static final int fKc = "originSvrId".hashCode();
    private static final int fKd = "newMsgId".hashCode();
    private static final int fKe = "fromUserName".hashCode();
    private static final int fKf = "toUserName".hashCode();
    private static final int fKg = "msgSource".hashCode();
    private static final int fni = "flag".hashCode();
    private static final int fra = "msgSeq".hashCode();
    private static final int fyl = "reserved1".hashCode();
    private static final int fym = "reserved2".hashCode();
    private static final int fyn = "reserved3".hashCode();
    private static final int fyo = "reserved4".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private boolean __hadSetcontent = true;
    private boolean __hadSetcreateTime = true;
    private boolean fJX = true;
    private boolean fJY = true;
    private boolean fJZ = true;
    private boolean fKa = true;
    private boolean fKb = true;
    public String field_content;
    public long field_createTime;
    public int field_flag;
    public String field_fromUserName;
    public int field_msgSeq;
    public String field_msgSource;
    public long field_newMsgId;
    public long field_originSvrId;
    public int field_reserved1;
    public long field_reserved2;
    public String field_reserved3;
    public String field_reserved4;
    public String field_toUserName;
    private boolean fng = true;
    private boolean fqS = true;
    private boolean fxA = true;
    private boolean fxB = true;
    private boolean fxC = true;
    private boolean fxz = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fKc == hashCode) {
                    this.field_originSvrId = cursor.getLong(i2);
                    this.fJX = true;
                } else if (fKd == hashCode) {
                    this.field_newMsgId = cursor.getLong(i2);
                } else if (fKe == hashCode) {
                    this.field_fromUserName = cursor.getString(i2);
                } else if (fKf == hashCode) {
                    this.field_toUserName = cursor.getString(i2);
                } else if (createTime_HASHCODE == hashCode) {
                    this.field_createTime = cursor.getLong(i2);
                } else if (content_HASHCODE == hashCode) {
                    this.field_content = cursor.getString(i2);
                } else if (fKg == hashCode) {
                    this.field_msgSource = cursor.getString(i2);
                } else if (fra == hashCode) {
                    this.field_msgSeq = cursor.getInt(i2);
                } else if (fni == hashCode) {
                    this.field_flag = cursor.getInt(i2);
                } else if (fyl == hashCode) {
                    this.field_reserved1 = cursor.getInt(i2);
                } else if (fym == hashCode) {
                    this.field_reserved2 = cursor.getLong(i2);
                } else if (fyn == hashCode) {
                    this.field_reserved3 = cursor.getString(i2);
                } else if (fyo == hashCode) {
                    this.field_reserved4 = cursor.getString(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.fJX) {
            contentValues.put("originSvrId", Long.valueOf(this.field_originSvrId));
        }
        if (this.fJY) {
            contentValues.put("newMsgId", Long.valueOf(this.field_newMsgId));
        }
        if (this.field_fromUserName == null) {
            this.field_fromUserName = "";
        }
        if (this.fJZ) {
            contentValues.put("fromUserName", this.field_fromUserName);
        }
        if (this.field_toUserName == null) {
            this.field_toUserName = "";
        }
        if (this.fKa) {
            contentValues.put("toUserName", this.field_toUserName);
        }
        if (this.__hadSetcreateTime) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.field_content == null) {
            this.field_content = "";
        }
        if (this.__hadSetcontent) {
            contentValues.put("content", this.field_content);
        }
        if (this.field_msgSource == null) {
            this.field_msgSource = "";
        }
        if (this.fKb) {
            contentValues.put("msgSource", this.field_msgSource);
        }
        if (this.fqS) {
            contentValues.put("msgSeq", Integer.valueOf(this.field_msgSeq));
        }
        if (this.fng) {
            contentValues.put("flag", Integer.valueOf(this.field_flag));
        }
        if (this.fxz) {
            contentValues.put("reserved1", Integer.valueOf(this.field_reserved1));
        }
        if (this.fxA) {
            contentValues.put("reserved2", Long.valueOf(this.field_reserved2));
        }
        if (this.field_reserved3 == null) {
            this.field_reserved3 = "";
        }
        if (this.fxB) {
            contentValues.put("reserved3", this.field_reserved3);
        }
        if (this.field_reserved4 == null) {
            this.field_reserved4 = "";
        }
        if (this.fxC) {
            contentValues.put("reserved4", this.field_reserved4);
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
