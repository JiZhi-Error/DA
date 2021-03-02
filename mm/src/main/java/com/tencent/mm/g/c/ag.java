package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class ag extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int content_HASHCODE = "content".hashCode();
    private static final int fjl = "status".hashCode();
    private static final int fnT = "bizChatId".hashCode();
    private static final int fnU = "brandUserName".hashCode();
    private static final int fnV = "unReadCount".hashCode();
    private static final int fnW = "newUnReadCount".hashCode();
    private static final int fnX = "lastMsgID".hashCode();
    private static final int fnY = "lastMsgTime".hashCode();
    private static final int fnZ = "digest".hashCode();
    private static final int fni = "flag".hashCode();
    private static final int foa = "digestUser".hashCode();
    private static final int fob = "atCount".hashCode();
    private static final int foc = "editingMsg".hashCode();
    private static final int fod = "chatType".hashCode();
    private static final int foe = "isSend".hashCode();
    private static final int fof = "msgType".hashCode();
    private static final int fog = "msgCount".hashCode();
    private static final int foh = "atAll".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private boolean __hadSetcontent = true;
    public int field_atAll;
    public int field_atCount;
    public long field_bizChatId;
    public String field_brandUserName;
    public int field_chatType;
    public String field_content;
    public String field_digest;
    public String field_digestUser;
    public String field_editingMsg;
    public long field_flag;
    public int field_isSend;
    public long field_lastMsgID;
    public long field_lastMsgTime;
    public int field_msgCount;
    public String field_msgType;
    public int field_newUnReadCount;
    public int field_status;
    public int field_unReadCount;
    private boolean fji = true;
    private boolean fnE = true;
    private boolean fnF = true;
    private boolean fnG = true;
    private boolean fnH = true;
    private boolean fnI = true;
    private boolean fnJ = true;
    private boolean fnK = true;
    private boolean fnL = true;
    private boolean fnM = true;
    private boolean fnN = true;
    private boolean fnO = true;
    private boolean fnP = true;
    private boolean fnQ = true;
    private boolean fnR = true;
    private boolean fnS = true;
    private boolean fng = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fnT == hashCode) {
                    this.field_bizChatId = cursor.getLong(i2);
                    this.fnE = true;
                } else if (fnU == hashCode) {
                    this.field_brandUserName = cursor.getString(i2);
                } else if (fnV == hashCode) {
                    this.field_unReadCount = cursor.getInt(i2);
                } else if (fnW == hashCode) {
                    this.field_newUnReadCount = cursor.getInt(i2);
                } else if (fnX == hashCode) {
                    this.field_lastMsgID = cursor.getLong(i2);
                } else if (fnY == hashCode) {
                    this.field_lastMsgTime = cursor.getLong(i2);
                } else if (content_HASHCODE == hashCode) {
                    this.field_content = cursor.getString(i2);
                } else if (fnZ == hashCode) {
                    this.field_digest = cursor.getString(i2);
                } else if (foa == hashCode) {
                    this.field_digestUser = cursor.getString(i2);
                } else if (fob == hashCode) {
                    this.field_atCount = cursor.getInt(i2);
                } else if (foc == hashCode) {
                    this.field_editingMsg = cursor.getString(i2);
                } else if (fod == hashCode) {
                    this.field_chatType = cursor.getInt(i2);
                } else if (fjl == hashCode) {
                    this.field_status = cursor.getInt(i2);
                } else if (foe == hashCode) {
                    this.field_isSend = cursor.getInt(i2);
                } else if (fof == hashCode) {
                    this.field_msgType = cursor.getString(i2);
                } else if (fog == hashCode) {
                    this.field_msgCount = cursor.getInt(i2);
                } else if (fni == hashCode) {
                    this.field_flag = cursor.getLong(i2);
                } else if (foh == hashCode) {
                    this.field_atAll = cursor.getInt(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.fnE) {
            contentValues.put("bizChatId", Long.valueOf(this.field_bizChatId));
        }
        if (this.fnF) {
            contentValues.put("brandUserName", this.field_brandUserName);
        }
        if (this.fnG) {
            contentValues.put("unReadCount", Integer.valueOf(this.field_unReadCount));
        }
        if (this.fnH) {
            contentValues.put("newUnReadCount", Integer.valueOf(this.field_newUnReadCount));
        }
        if (this.fnI) {
            contentValues.put("lastMsgID", Long.valueOf(this.field_lastMsgID));
        }
        if (this.fnJ) {
            contentValues.put("lastMsgTime", Long.valueOf(this.field_lastMsgTime));
        }
        if (this.__hadSetcontent) {
            contentValues.put("content", this.field_content);
        }
        if (this.field_digest == null) {
            this.field_digest = "";
        }
        if (this.fnK) {
            contentValues.put("digest", this.field_digest);
        }
        if (this.field_digestUser == null) {
            this.field_digestUser = "";
        }
        if (this.fnL) {
            contentValues.put("digestUser", this.field_digestUser);
        }
        if (this.fnM) {
            contentValues.put("atCount", Integer.valueOf(this.field_atCount));
        }
        if (this.fnN) {
            contentValues.put("editingMsg", this.field_editingMsg);
        }
        if (this.fnO) {
            contentValues.put("chatType", Integer.valueOf(this.field_chatType));
        }
        if (this.fji) {
            contentValues.put("status", Integer.valueOf(this.field_status));
        }
        if (this.fnP) {
            contentValues.put("isSend", Integer.valueOf(this.field_isSend));
        }
        if (this.field_msgType == null) {
            this.field_msgType = "";
        }
        if (this.fnQ) {
            contentValues.put("msgType", this.field_msgType);
        }
        if (this.fnR) {
            contentValues.put("msgCount", Integer.valueOf(this.field_msgCount));
        }
        if (this.fng) {
            contentValues.put("flag", Long.valueOf(this.field_flag));
        }
        if (this.fnS) {
            contentValues.put("atAll", Integer.valueOf(this.field_atAll));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
