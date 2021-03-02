package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.plugin.gamelife.b.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import java.io.IOException;
import java.lang.reflect.Field;

public abstract class db extends IAutoDBItem {
    public static final String[] INDEX_CREATE = {"CREATE INDEX IF NOT EXISTS GameLifeSessionInfo_sessionId_index ON GameLifeSessionInfo(sessionId)", "CREATE INDEX IF NOT EXISTS GameLifeSessionInfo_talker_index ON GameLifeSessionInfo(talker)", "CREATE INDEX IF NOT EXISTS GameLifeSessionInfo_selfUsername_index ON GameLifeSessionInfo(selfUserName)"};
    private static final int fAZ = "sessionId".hashCode();
    private static final int fIK = "selfUserName".hashCode();
    private static final int fpP = IssueStorage.COLUMN_EXT_INFO.hashCode();
    private static final int fqw = "talker".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private boolean fAL = true;
    private boolean fIH = true;
    public c field_extInfo;
    public String field_selfUserName;
    public String field_sessionId;
    public String field_talker;
    private boolean fpB = true;
    private boolean fqi = true;

    public static IAutoDBItem.MAutoDBInfo ajs() {
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[4];
        mAutoDBInfo.columns = new String[5];
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
        mAutoDBInfo.columns[3] = IssueStorage.COLUMN_EXT_INFO;
        mAutoDBInfo.colsMap.put(IssueStorage.COLUMN_EXT_INFO, "BLOB");
        sb.append(" extInfo BLOB");
        mAutoDBInfo.columns[4] = "rowid";
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
                } else if (fpP == hashCode) {
                    try {
                        byte[] blob = cursor.getBlob(i2);
                        if (blob != null && blob.length > 0) {
                            this.field_extInfo = (c) new c().parseFrom(blob);
                        }
                    } catch (IOException e2) {
                        Log.e("MicroMsg.SDK.BaseGameLifeSessionInfo", e2.getMessage());
                    }
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
        if (this.fpB && this.field_extInfo != null) {
            try {
                contentValues.put(IssueStorage.COLUMN_EXT_INFO, this.field_extInfo.toByteArray());
            } catch (IOException e2) {
                Log.e("MicroMsg.SDK.BaseGameLifeSessionInfo", e2.getMessage());
            }
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
