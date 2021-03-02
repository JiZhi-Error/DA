package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public abstract class cp extends IAutoDBItem {
    public static final String[] INDEX_CREATE = {"CREATE INDEX IF NOT EXISTS FinderSessionInfo_sessionId_index ON FinderSessionInfo(sessionId)", "CREATE INDEX IF NOT EXISTS FinderSessionInfo_talker_index ON FinderSessionInfo(talker)", "CREATE INDEX IF NOT EXISTS FinderSessionInfo_type_index ON FinderSessionInfo(type)"};
    private static final int fAZ = "sessionId".hashCode();
    private static final int fDX = "actionPermission".hashCode();
    private static final int fGo = "selfUsername".hashCode();
    private static final int fGp = "rejectMsg".hashCode();
    private static final int fGq = "disableSendMsg".hashCode();
    private static final int fqw = "talker".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private static final int type_HASHCODE = "type".hashCode();
    private static final int updateTime_HASHCODE = ch.COL_UPDATETIME.hashCode();
    private boolean __hadSettype = true;
    private boolean __hadSetupdateTime = true;
    private boolean fAL = true;
    private boolean fDT = true;
    private boolean fGl = true;
    private boolean fGm = true;
    private boolean fGn = true;
    public int field_actionPermission;
    public int field_disableSendMsg;
    public int field_rejectMsg;
    public String field_selfUsername;
    public String field_sessionId;
    public String field_talker;
    public int field_type;
    public long field_updateTime;
    private boolean fqi = true;

    public static IAutoDBItem.MAutoDBInfo ajs() {
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[8];
        mAutoDBInfo.columns = new String[9];
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
        mAutoDBInfo.columns[2] = ch.COL_UPDATETIME;
        mAutoDBInfo.colsMap.put(ch.COL_UPDATETIME, "LONG default '0' ");
        sb.append(" updateTime LONG default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "selfUsername";
        mAutoDBInfo.colsMap.put("selfUsername", "TEXT default '' ");
        sb.append(" selfUsername TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "type";
        mAutoDBInfo.colsMap.put("type", "INTEGER");
        sb.append(" type INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "actionPermission";
        mAutoDBInfo.colsMap.put("actionPermission", "INTEGER");
        sb.append(" actionPermission INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[6] = "rejectMsg";
        mAutoDBInfo.colsMap.put("rejectMsg", "INTEGER");
        sb.append(" rejectMsg INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[7] = "disableSendMsg";
        mAutoDBInfo.colsMap.put("disableSendMsg", "INTEGER");
        sb.append(" disableSendMsg INTEGER");
        mAutoDBInfo.columns[8] = "rowid";
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
                } else if (updateTime_HASHCODE == hashCode) {
                    this.field_updateTime = cursor.getLong(i2);
                } else if (fGo == hashCode) {
                    this.field_selfUsername = cursor.getString(i2);
                } else if (type_HASHCODE == hashCode) {
                    this.field_type = cursor.getInt(i2);
                } else if (fDX == hashCode) {
                    this.field_actionPermission = cursor.getInt(i2);
                } else if (fGp == hashCode) {
                    this.field_rejectMsg = cursor.getInt(i2);
                } else if (fGq == hashCode) {
                    this.field_disableSendMsg = cursor.getInt(i2);
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
        if (this.__hadSetupdateTime) {
            contentValues.put(ch.COL_UPDATETIME, Long.valueOf(this.field_updateTime));
        }
        if (this.field_selfUsername == null) {
            this.field_selfUsername = "";
        }
        if (this.fGl) {
            contentValues.put("selfUsername", this.field_selfUsername);
        }
        if (this.__hadSettype) {
            contentValues.put("type", Integer.valueOf(this.field_type));
        }
        if (this.fDT) {
            contentValues.put("actionPermission", Integer.valueOf(this.field_actionPermission));
        }
        if (this.fGm) {
            contentValues.put("rejectMsg", Integer.valueOf(this.field_rejectMsg));
        }
        if (this.fGn) {
            contentValues.put("disableSendMsg", Integer.valueOf(this.field_disableSendMsg));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
