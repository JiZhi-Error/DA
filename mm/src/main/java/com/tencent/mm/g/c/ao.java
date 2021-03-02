package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import java.lang.reflect.Field;

public abstract class ao extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int content_HASHCODE = "content".hashCode();
    private static final int createTime_HASHCODE = "createTime".hashCode();
    private static final int fjf = "msgId".hashCode();
    private static final int fjl = "status".hashCode();
    private static final int fnT = "bizChatId".hashCode();
    private static final int fni = "flag".hashCode();
    private static final int foe = "isSend".hashCode();
    private static final int fpP = IssueStorage.COLUMN_EXT_INFO.hashCode();
    private static final int fqG = "bizClientMsgId".hashCode();
    private static final int fqV = "isShowTimer".hashCode();
    private static final int fqW = "reserved".hashCode();
    private static final int fqX = "transContent".hashCode();
    private static final int fqY = "transBrandWording".hashCode();
    private static final int fqZ = "bizChatUserId".hashCode();
    private static final int fqv = "msgSvrId".hashCode();
    private static final int fqw = "talker".hashCode();
    private static final int fqx = "imgPath".hashCode();
    private static final int fqy = "lvbuffer".hashCode();
    private static final int fqz = "talkerId".hashCode();
    private static final int fra = "msgSeq".hashCode();
    private static final int frb = "fromUsername".hashCode();
    private static final int frc = "toUsername".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private static final int type_HASHCODE = "type".hashCode();
    private boolean __hadSetcontent;
    private boolean __hadSetcreateTime;
    private boolean __hadSettype;
    public long field_bizChatId;
    public String field_bizChatUserId;
    public String field_bizClientMsgId;
    public String field_content;
    public long field_createTime;
    public byte[] field_extInfo;
    public int field_flag;
    public String field_fromUsername;
    public String field_imgPath;
    public int field_isSend;
    public int field_isShowTimer;
    public byte[] field_lvbuffer;
    public long field_msgId;
    public long field_msgSeq;
    public long field_msgSvrId;
    public String field_reserved;
    public int field_status;
    public String field_talker;
    public int field_talkerId;
    public String field_toUsername;
    public String field_transBrandWording;
    public String field_transContent;
    public int field_type;
    private boolean fjb;
    private boolean fji;
    private boolean fnE;
    private boolean fnP;
    private boolean fng;
    private boolean fpB;
    private boolean fqN;
    private boolean fqO;
    private boolean fqP;
    private boolean fqQ;
    private boolean fqR;
    private boolean fqS;
    private boolean fqT;
    private boolean fqU;
    private boolean fqh;
    private boolean fqi;
    private boolean fqj;
    private boolean fqk;
    private boolean fql;
    private boolean fqs;

    public static IAutoDBItem.MAutoDBInfo ajs() {
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[23];
        mAutoDBInfo.columns = new String[24];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "msgId";
        mAutoDBInfo.colsMap.put("msgId", "LONG PRIMARY KEY ");
        sb.append(" msgId LONG PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "msgId";
        mAutoDBInfo.columns[1] = "msgSvrId";
        mAutoDBInfo.colsMap.put("msgSvrId", "LONG");
        sb.append(" msgSvrId LONG");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "type";
        mAutoDBInfo.colsMap.put("type", "INTEGER");
        sb.append(" type INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "status";
        mAutoDBInfo.colsMap.put("status", "INTEGER");
        sb.append(" status INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "isSend";
        mAutoDBInfo.colsMap.put("isSend", "INTEGER");
        sb.append(" isSend INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "isShowTimer";
        mAutoDBInfo.colsMap.put("isShowTimer", "INTEGER");
        sb.append(" isShowTimer INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[6] = "createTime";
        mAutoDBInfo.colsMap.put("createTime", "LONG");
        sb.append(" createTime LONG");
        sb.append(", ");
        mAutoDBInfo.columns[7] = "talker";
        mAutoDBInfo.colsMap.put("talker", "TEXT");
        sb.append(" talker TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[8] = "content";
        mAutoDBInfo.colsMap.put("content", "TEXT default '' ");
        sb.append(" content TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[9] = "imgPath";
        mAutoDBInfo.colsMap.put("imgPath", "TEXT");
        sb.append(" imgPath TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[10] = "reserved";
        mAutoDBInfo.colsMap.put("reserved", "TEXT");
        sb.append(" reserved TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[11] = "lvbuffer";
        mAutoDBInfo.colsMap.put("lvbuffer", "BLOB");
        sb.append(" lvbuffer BLOB");
        sb.append(", ");
        mAutoDBInfo.columns[12] = "talkerId";
        mAutoDBInfo.colsMap.put("talkerId", "INTEGER");
        sb.append(" talkerId INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[13] = "transContent";
        mAutoDBInfo.colsMap.put("transContent", "TEXT default '' ");
        sb.append(" transContent TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[14] = "transBrandWording";
        mAutoDBInfo.colsMap.put("transBrandWording", "TEXT default '' ");
        sb.append(" transBrandWording TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[15] = "bizClientMsgId";
        mAutoDBInfo.colsMap.put("bizClientMsgId", "TEXT default '' ");
        sb.append(" bizClientMsgId TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[16] = "bizChatId";
        mAutoDBInfo.colsMap.put("bizChatId", "LONG default '-1' ");
        sb.append(" bizChatId LONG default '-1' ");
        sb.append(", ");
        mAutoDBInfo.columns[17] = "bizChatUserId";
        mAutoDBInfo.colsMap.put("bizChatUserId", "TEXT default '' ");
        sb.append(" bizChatUserId TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[18] = "msgSeq";
        mAutoDBInfo.colsMap.put("msgSeq", "LONG");
        sb.append(" msgSeq LONG");
        sb.append(", ");
        mAutoDBInfo.columns[19] = "flag";
        mAutoDBInfo.colsMap.put("flag", "INTEGER default '0' ");
        sb.append(" flag INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[20] = "fromUsername";
        mAutoDBInfo.colsMap.put("fromUsername", "TEXT");
        sb.append(" fromUsername TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[21] = "toUsername";
        mAutoDBInfo.colsMap.put("toUsername", "TEXT");
        sb.append(" toUsername TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[22] = IssueStorage.COLUMN_EXT_INFO;
        mAutoDBInfo.colsMap.put(IssueStorage.COLUMN_EXT_INFO, "BLOB");
        sb.append(" extInfo BLOB");
        mAutoDBInfo.columns[23] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        return mAutoDBInfo;
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fjf == hashCode) {
                    this.field_msgId = cursor.getLong(i2);
                    this.fjb = true;
                } else if (fqv == hashCode) {
                    this.field_msgSvrId = cursor.getLong(i2);
                } else if (type_HASHCODE == hashCode) {
                    this.field_type = cursor.getInt(i2);
                } else if (fjl == hashCode) {
                    this.field_status = cursor.getInt(i2);
                } else if (foe == hashCode) {
                    this.field_isSend = cursor.getInt(i2);
                } else if (fqV == hashCode) {
                    this.field_isShowTimer = cursor.getInt(i2);
                } else if (createTime_HASHCODE == hashCode) {
                    this.field_createTime = cursor.getLong(i2);
                } else if (fqw == hashCode) {
                    this.field_talker = cursor.getString(i2);
                } else if (content_HASHCODE == hashCode) {
                    this.field_content = cursor.getString(i2);
                } else if (fqx == hashCode) {
                    this.field_imgPath = cursor.getString(i2);
                } else if (fqW == hashCode) {
                    this.field_reserved = cursor.getString(i2);
                } else if (fqy == hashCode) {
                    this.field_lvbuffer = cursor.getBlob(i2);
                } else if (fqz == hashCode) {
                    this.field_talkerId = cursor.getInt(i2);
                } else if (fqX == hashCode) {
                    this.field_transContent = cursor.getString(i2);
                } else if (fqY == hashCode) {
                    this.field_transBrandWording = cursor.getString(i2);
                } else if (fqG == hashCode) {
                    this.field_bizClientMsgId = cursor.getString(i2);
                } else if (fnT == hashCode) {
                    this.field_bizChatId = cursor.getLong(i2);
                } else if (fqZ == hashCode) {
                    this.field_bizChatUserId = cursor.getString(i2);
                } else if (fra == hashCode) {
                    this.field_msgSeq = cursor.getLong(i2);
                } else if (fni == hashCode) {
                    this.field_flag = cursor.getInt(i2);
                } else if (frb == hashCode) {
                    this.field_fromUsername = cursor.getString(i2);
                } else if (frc == hashCode) {
                    this.field_toUsername = cursor.getString(i2);
                } else if (fpP == hashCode) {
                    this.field_extInfo = cursor.getBlob(i2);
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
        if (this.__hadSettype) {
            contentValues.put("type", Integer.valueOf(this.field_type));
        }
        if (this.fji) {
            contentValues.put("status", Integer.valueOf(this.field_status));
        }
        if (this.fnP) {
            contentValues.put("isSend", Integer.valueOf(this.field_isSend));
        }
        if (this.fqN) {
            contentValues.put("isShowTimer", Integer.valueOf(this.field_isShowTimer));
        }
        if (this.__hadSetcreateTime) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.fqi) {
            contentValues.put("talker", this.field_talker);
        }
        if (this.field_content == null) {
            this.field_content = "";
        }
        if (this.__hadSetcontent) {
            contentValues.put("content", this.field_content);
        }
        if (this.fqj) {
            contentValues.put("imgPath", this.field_imgPath);
        }
        if (this.fqO) {
            contentValues.put("reserved", this.field_reserved);
        }
        if (this.fqk) {
            contentValues.put("lvbuffer", this.field_lvbuffer);
        }
        if (this.fql) {
            contentValues.put("talkerId", Integer.valueOf(this.field_talkerId));
        }
        if (this.field_transContent == null) {
            this.field_transContent = "";
        }
        if (this.fqP) {
            contentValues.put("transContent", this.field_transContent);
        }
        if (this.field_transBrandWording == null) {
            this.field_transBrandWording = "";
        }
        if (this.fqQ) {
            contentValues.put("transBrandWording", this.field_transBrandWording);
        }
        if (this.field_bizClientMsgId == null) {
            this.field_bizClientMsgId = "";
        }
        if (this.fqs) {
            contentValues.put("bizClientMsgId", this.field_bizClientMsgId);
        }
        if (this.fnE) {
            contentValues.put("bizChatId", Long.valueOf(this.field_bizChatId));
        }
        if (this.field_bizChatUserId == null) {
            this.field_bizChatUserId = "";
        }
        if (this.fqR) {
            contentValues.put("bizChatUserId", this.field_bizChatUserId);
        }
        if (this.fqS) {
            contentValues.put("msgSeq", Long.valueOf(this.field_msgSeq));
        }
        if (this.fng) {
            contentValues.put("flag", Integer.valueOf(this.field_flag));
        }
        if (this.fqT) {
            contentValues.put("fromUsername", this.field_fromUsername);
        }
        if (this.fqU) {
            contentValues.put("toUsername", this.field_toUsername);
        }
        if (this.fpB) {
            contentValues.put(IssueStorage.COLUMN_EXT_INFO, this.field_extInfo);
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
