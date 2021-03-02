package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public abstract class da extends IAutoDBItem {
    public static final String[] INDEX_CREATE = {"CREATE INDEX IF NOT EXISTS GameLifeConversation_sessionId_index ON GameLifeConversation(sessionId)", "CREATE INDEX IF NOT EXISTS GameLifeConversation_talker_index ON GameLifeConversation(talker)", "CREATE INDEX IF NOT EXISTS GameLifeConversation_selfUserName_index ON GameLifeConversation(selfUserName)", "CREATE INDEX IF NOT EXISTS GameLifeConversation_updateTime_index ON GameLifeConversation(updateTime)"};
    private static final int fAZ = "sessionId".hashCode();
    private static final int fIK = "selfUserName".hashCode();
    private static final int fIL = "digestFlag".hashCode();
    private static final int fIM = "digestPrefix".hashCode();
    private static final int fnV = "unReadCount".hashCode();
    private static final int fnX = "lastMsgID".hashCode();
    private static final int fnZ = "digest".hashCode();
    private static final int foc = "editingMsg".hashCode();
    private static final int fqw = "talker".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private static final int updateTime_HASHCODE = ch.COL_UPDATETIME.hashCode();
    private boolean __hadSetupdateTime = true;
    private boolean fAL = true;
    private boolean fIH = true;
    private boolean fII = true;
    private boolean fIJ = true;
    public String field_digest;
    public long field_digestFlag;
    public String field_digestPrefix;
    public String field_editingMsg;
    public long field_lastMsgID;
    public String field_selfUserName;
    public String field_sessionId;
    public String field_talker;
    public int field_unReadCount;
    public long field_updateTime;
    private boolean fnG = true;
    private boolean fnI = true;
    private boolean fnK = true;
    private boolean fnN = true;
    private boolean fqi = true;

    public static IAutoDBItem.MAutoDBInfo ajs() {
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[10];
        mAutoDBInfo.columns = new String[11];
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
        mAutoDBInfo.columns[2] = "selfUserName";
        mAutoDBInfo.colsMap.put("selfUserName", "TEXT default '' ");
        sb.append(" selfUserName TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "unReadCount";
        mAutoDBInfo.colsMap.put("unReadCount", "INTEGER default '0' ");
        sb.append(" unReadCount INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[4] = ch.COL_UPDATETIME;
        mAutoDBInfo.colsMap.put(ch.COL_UPDATETIME, "LONG default '0' ");
        sb.append(" updateTime LONG default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "digest";
        mAutoDBInfo.colsMap.put("digest", "TEXT default '' ");
        sb.append(" digest TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[6] = "lastMsgID";
        mAutoDBInfo.colsMap.put("lastMsgID", "LONG");
        sb.append(" lastMsgID LONG");
        sb.append(", ");
        mAutoDBInfo.columns[7] = "digestFlag";
        mAutoDBInfo.colsMap.put("digestFlag", "LONG default '0' ");
        sb.append(" digestFlag LONG default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[8] = "digestPrefix";
        mAutoDBInfo.colsMap.put("digestPrefix", "TEXT default '' ");
        sb.append(" digestPrefix TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[9] = "editingMsg";
        mAutoDBInfo.colsMap.put("editingMsg", "TEXT default '' ");
        sb.append(" editingMsg TEXT default '' ");
        mAutoDBInfo.columns[10] = "rowid";
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
                } else if (fIK == hashCode) {
                    this.field_selfUserName = cursor.getString(i2);
                } else if (fnV == hashCode) {
                    this.field_unReadCount = cursor.getInt(i2);
                } else if (updateTime_HASHCODE == hashCode) {
                    this.field_updateTime = cursor.getLong(i2);
                } else if (fnZ == hashCode) {
                    this.field_digest = cursor.getString(i2);
                } else if (fnX == hashCode) {
                    this.field_lastMsgID = cursor.getLong(i2);
                } else if (fIL == hashCode) {
                    this.field_digestFlag = cursor.getLong(i2);
                } else if (fIM == hashCode) {
                    this.field_digestPrefix = cursor.getString(i2);
                } else if (foc == hashCode) {
                    this.field_editingMsg = cursor.getString(i2);
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
        if (this.field_selfUserName == null) {
            this.field_selfUserName = "";
        }
        if (this.fIH) {
            contentValues.put("selfUserName", this.field_selfUserName);
        }
        if (this.fnG) {
            contentValues.put("unReadCount", Integer.valueOf(this.field_unReadCount));
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
        if (this.fnI) {
            contentValues.put("lastMsgID", Long.valueOf(this.field_lastMsgID));
        }
        if (this.fII) {
            contentValues.put("digestFlag", Long.valueOf(this.field_digestFlag));
        }
        if (this.field_digestPrefix == null) {
            this.field_digestPrefix = "";
        }
        if (this.fIJ) {
            contentValues.put("digestPrefix", this.field_digestPrefix);
        }
        if (this.field_editingMsg == null) {
            this.field_editingMsg = "";
        }
        if (this.fnN) {
            contentValues.put("editingMsg", this.field_editingMsg);
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
