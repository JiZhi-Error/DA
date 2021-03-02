package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public abstract class cf extends IAutoDBItem {
    public static final String[] INDEX_CREATE = {"CREATE INDEX IF NOT EXISTS FinderConversation_sessionId_index ON FinderConversation(sessionId)", "CREATE INDEX IF NOT EXISTS FinderConversation_talker_index ON FinderConversation(talker)", "CREATE INDEX IF NOT EXISTS FinderConversation_username_status ON FinderConversation(status)", "CREATE INDEX IF NOT EXISTS FinderConversation_updateTime_index ON FinderConversation(updateTime)", "CREATE INDEX IF NOT EXISTS FinderConversation_type_index ON FinderConversation(type)", "CREATE INDEX IF NOT EXISTS FinderConversation_scene_index ON FinderConversation(scene)", "CREATE INDEX IF NOT EXISTS FinderConversation_readStatus_index ON FinderConversation(readStatus)"};
    private static final int content_HASHCODE = "content".hashCode();
    private static final int fAZ = "sessionId".hashCode();
    private static final int fDV = "digestType".hashCode();
    private static final int fDW = "placedFlag".hashCode();
    private static final int fDX = "actionPermission".hashCode();
    private static final int fDY = "readStatus".hashCode();
    private static final int fjQ = "scene".hashCode();
    private static final int fjl = "status".hashCode();
    private static final int fnV = "unReadCount".hashCode();
    private static final int fnX = "lastMsgID".hashCode();
    private static final int fnZ = "digest".hashCode();
    private static final int foa = "digestUser".hashCode();
    private static final int foc = "editingMsg".hashCode();
    private static final int foe = "isSend".hashCode();
    private static final int fqw = "talker".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private static final int type_HASHCODE = "type".hashCode();
    private static final int updateTime_HASHCODE = ch.COL_UPDATETIME.hashCode();
    private boolean __hadSetcontent = true;
    private boolean __hadSettype = true;
    private boolean __hadSetupdateTime = true;
    private boolean fAL = true;
    private boolean fDR = true;
    private boolean fDS = true;
    private boolean fDT = true;
    private boolean fDU = true;
    public int field_actionPermission;
    public String field_content;
    public String field_digest;
    public String field_digestType;
    public String field_digestUser;
    public String field_editingMsg;
    public int field_isSend;
    public long field_lastMsgID;
    public long field_placedFlag;
    public int field_readStatus;
    public int field_scene;
    public String field_sessionId;
    public int field_status;
    public String field_talker;
    public int field_type;
    public int field_unReadCount;
    public long field_updateTime;
    private boolean fjO = true;
    private boolean fji = true;
    private boolean fnG = true;
    private boolean fnI = true;
    private boolean fnK = true;
    private boolean fnL = true;
    private boolean fnN = true;
    private boolean fnP = true;
    private boolean fqi = true;

    public static IAutoDBItem.MAutoDBInfo ajs() {
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[17];
        mAutoDBInfo.columns = new String[18];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "sessionId";
        mAutoDBInfo.colsMap.put("sessionId", "TEXT default ''  PRIMARY KEY ");
        sb.append(" sessionId TEXT default ''  PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "sessionId";
        mAutoDBInfo.columns[1] = "talker";
        mAutoDBInfo.colsMap.put("talker", "TEXT default '' ");
        sb.append(" talker TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "unReadCount";
        mAutoDBInfo.colsMap.put("unReadCount", "INTEGER default '0' ");
        sb.append(" unReadCount INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "status";
        mAutoDBInfo.colsMap.put("status", "INTEGER default '0' ");
        sb.append(" status INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[4] = ch.COL_UPDATETIME;
        mAutoDBInfo.colsMap.put(ch.COL_UPDATETIME, "LONG default '0' ");
        sb.append(" updateTime LONG default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "digest";
        mAutoDBInfo.colsMap.put("digest", "TEXT default '' ");
        sb.append(" digest TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[6] = "digestUser";
        mAutoDBInfo.colsMap.put("digestUser", "TEXT default '' ");
        sb.append(" digestUser TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[7] = "digestType";
        mAutoDBInfo.colsMap.put("digestType", "TEXT default '' ");
        sb.append(" digestType TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[8] = "lastMsgID";
        mAutoDBInfo.colsMap.put("lastMsgID", "LONG");
        sb.append(" lastMsgID LONG");
        sb.append(", ");
        mAutoDBInfo.columns[9] = "content";
        mAutoDBInfo.colsMap.put("content", "TEXT");
        sb.append(" content TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[10] = "isSend";
        mAutoDBInfo.colsMap.put("isSend", "INTEGER");
        sb.append(" isSend INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[11] = "placedFlag";
        mAutoDBInfo.colsMap.put("placedFlag", "LONG default '0' ");
        sb.append(" placedFlag LONG default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[12] = "editingMsg";
        mAutoDBInfo.colsMap.put("editingMsg", "TEXT");
        sb.append(" editingMsg TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[13] = "type";
        mAutoDBInfo.colsMap.put("type", "INTEGER");
        sb.append(" type INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[14] = "actionPermission";
        mAutoDBInfo.colsMap.put("actionPermission", "INTEGER");
        sb.append(" actionPermission INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[15] = "scene";
        mAutoDBInfo.colsMap.put("scene", "INTEGER");
        sb.append(" scene INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[16] = "readStatus";
        mAutoDBInfo.colsMap.put("readStatus", "INTEGER");
        sb.append(" readStatus INTEGER");
        mAutoDBInfo.columns[17] = "rowid";
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
                if (fAZ == hashCode) {
                    this.field_sessionId = cursor.getString(i2);
                    this.fAL = true;
                } else if (fqw == hashCode) {
                    this.field_talker = cursor.getString(i2);
                } else if (fnV == hashCode) {
                    this.field_unReadCount = cursor.getInt(i2);
                } else if (fjl == hashCode) {
                    this.field_status = cursor.getInt(i2);
                } else if (updateTime_HASHCODE == hashCode) {
                    this.field_updateTime = cursor.getLong(i2);
                } else if (fnZ == hashCode) {
                    this.field_digest = cursor.getString(i2);
                } else if (foa == hashCode) {
                    this.field_digestUser = cursor.getString(i2);
                } else if (fDV == hashCode) {
                    this.field_digestType = cursor.getString(i2);
                } else if (fnX == hashCode) {
                    this.field_lastMsgID = cursor.getLong(i2);
                } else if (content_HASHCODE == hashCode) {
                    this.field_content = cursor.getString(i2);
                } else if (foe == hashCode) {
                    this.field_isSend = cursor.getInt(i2);
                } else if (fDW == hashCode) {
                    this.field_placedFlag = cursor.getLong(i2);
                } else if (foc == hashCode) {
                    this.field_editingMsg = cursor.getString(i2);
                } else if (type_HASHCODE == hashCode) {
                    this.field_type = cursor.getInt(i2);
                } else if (fDX == hashCode) {
                    this.field_actionPermission = cursor.getInt(i2);
                } else if (fjQ == hashCode) {
                    this.field_scene = cursor.getInt(i2);
                } else if (fDY == hashCode) {
                    this.field_readStatus = cursor.getInt(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.field_sessionId == null) {
            this.field_sessionId = "";
        }
        if (this.fAL) {
            contentValues.put("sessionId", this.field_sessionId);
        }
        if (this.field_talker == null) {
            this.field_talker = "";
        }
        if (this.fqi) {
            contentValues.put("talker", this.field_talker);
        }
        if (this.fnG) {
            contentValues.put("unReadCount", Integer.valueOf(this.field_unReadCount));
        }
        if (this.fji) {
            contentValues.put("status", Integer.valueOf(this.field_status));
        }
        if (this.__hadSetupdateTime) {
            contentValues.put(ch.COL_UPDATETIME, Long.valueOf(this.field_updateTime));
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
        if (this.field_digestType == null) {
            this.field_digestType = "";
        }
        if (this.fDR) {
            contentValues.put("digestType", this.field_digestType);
        }
        if (this.fnI) {
            contentValues.put("lastMsgID", Long.valueOf(this.field_lastMsgID));
        }
        if (this.__hadSetcontent) {
            contentValues.put("content", this.field_content);
        }
        if (this.fnP) {
            contentValues.put("isSend", Integer.valueOf(this.field_isSend));
        }
        if (this.fDS) {
            contentValues.put("placedFlag", Long.valueOf(this.field_placedFlag));
        }
        if (this.fnN) {
            contentValues.put("editingMsg", this.field_editingMsg);
        }
        if (this.__hadSettype) {
            contentValues.put("type", Integer.valueOf(this.field_type));
        }
        if (this.fDT) {
            contentValues.put("actionPermission", Integer.valueOf(this.field_actionPermission));
        }
        if (this.fjO) {
            contentValues.put("scene", Integer.valueOf(this.field_scene));
        }
        if (this.fDU) {
            contentValues.put("readStatus", Integer.valueOf(this.field_readStatus));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
