package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.aoh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.io.IOException;
import java.lang.reflect.Field;

public abstract class cd extends IAutoDBItem {
    public static final String[] INDEX_CREATE = {"CREATE INDEX IF NOT EXISTS Finder_Local_Comment_Id ON FinderAction(localCommentId)", "CREATE INDEX IF NOT EXISTS FinderAction_Feed_Id ON FinderAction(feedId)", "CREATE INDEX IF NOT EXISTS Finder_Feed_CreateTime ON FinderAction(actionTime)", "CREATE INDEX IF NOT EXISTS Finder_Feed_ActionType ON FinderAction(actionType)", "CREATE INDEX IF NOT EXISTS Finder_Reply_state ON FinderAction(state)"};
    private static final int fBD = "actionType".hashCode();
    private static final int fDb = "localCommentId".hashCode();
    private static final int fDc = "feedId".hashCode();
    private static final int fDd = "actionTime".hashCode();
    private static final int fDe = "objectNonceId".hashCode();
    private static final int fDf = "actionInfo".hashCode();
    private static final int fDg = "postTime".hashCode();
    private static final int fDh = "tryCount".hashCode();
    private static final int fDi = "canRemove".hashCode();
    private static final int fDj = "lastTryTime".hashCode();
    private static final int fDk = "failedFlag".hashCode();
    private static final int fjQ = "scene".hashCode();
    private static final int fyj = "state".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private boolean fBt = true;
    private boolean fCR = true;
    private boolean fCS = true;
    private boolean fCT = true;
    private boolean fCU = true;
    private boolean fCV = true;
    private boolean fCW = true;
    private boolean fCX = true;
    private boolean fCY = true;
    private boolean fCZ = true;
    private boolean fDa = true;
    public aoh field_actionInfo;
    public long field_actionTime;
    public int field_actionType;
    public int field_canRemove;
    public int field_failedFlag;
    public long field_feedId;
    public long field_lastTryTime;
    public long field_localCommentId;
    public String field_objectNonceId;
    public long field_postTime;
    public int field_scene;
    public int field_state;
    public long field_tryCount;
    private boolean fjO = true;
    private boolean fxx = true;

    public static IAutoDBItem.MAutoDBInfo ajs() {
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[13];
        mAutoDBInfo.columns = new String[14];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "localCommentId";
        mAutoDBInfo.colsMap.put("localCommentId", "LONG PRIMARY KEY ");
        sb.append(" localCommentId LONG PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "localCommentId";
        mAutoDBInfo.columns[1] = "feedId";
        mAutoDBInfo.colsMap.put("feedId", "LONG");
        sb.append(" feedId LONG");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "actionTime";
        mAutoDBInfo.colsMap.put("actionTime", "LONG");
        sb.append(" actionTime LONG");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "actionType";
        mAutoDBInfo.colsMap.put("actionType", "INTEGER");
        sb.append(" actionType INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "objectNonceId";
        mAutoDBInfo.colsMap.put("objectNonceId", "TEXT");
        sb.append(" objectNonceId TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "scene";
        mAutoDBInfo.colsMap.put("scene", "INTEGER");
        sb.append(" scene INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[6] = "state";
        mAutoDBInfo.colsMap.put("state", "INTEGER");
        sb.append(" state INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[7] = "actionInfo";
        mAutoDBInfo.colsMap.put("actionInfo", "BLOB");
        sb.append(" actionInfo BLOB");
        sb.append(", ");
        mAutoDBInfo.columns[8] = "postTime";
        mAutoDBInfo.colsMap.put("postTime", "LONG");
        sb.append(" postTime LONG");
        sb.append(", ");
        mAutoDBInfo.columns[9] = "tryCount";
        mAutoDBInfo.colsMap.put("tryCount", "LONG");
        sb.append(" tryCount LONG");
        sb.append(", ");
        mAutoDBInfo.columns[10] = "canRemove";
        mAutoDBInfo.colsMap.put("canRemove", "INTEGER");
        sb.append(" canRemove INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[11] = "lastTryTime";
        mAutoDBInfo.colsMap.put("lastTryTime", "LONG");
        sb.append(" lastTryTime LONG");
        sb.append(", ");
        mAutoDBInfo.columns[12] = "failedFlag";
        mAutoDBInfo.colsMap.put("failedFlag", "INTEGER");
        sb.append(" failedFlag INTEGER");
        mAutoDBInfo.columns[13] = "rowid";
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
                if (fDb == hashCode) {
                    this.field_localCommentId = cursor.getLong(i2);
                    this.fCR = true;
                } else if (fDc == hashCode) {
                    this.field_feedId = cursor.getLong(i2);
                } else if (fDd == hashCode) {
                    this.field_actionTime = cursor.getLong(i2);
                } else if (fBD == hashCode) {
                    this.field_actionType = cursor.getInt(i2);
                } else if (fDe == hashCode) {
                    this.field_objectNonceId = cursor.getString(i2);
                } else if (fjQ == hashCode) {
                    this.field_scene = cursor.getInt(i2);
                } else if (fyj == hashCode) {
                    this.field_state = cursor.getInt(i2);
                } else if (fDf == hashCode) {
                    try {
                        byte[] blob = cursor.getBlob(i2);
                        if (blob != null && blob.length > 0) {
                            this.field_actionInfo = (aoh) new aoh().parseFrom(blob);
                        }
                    } catch (IOException e2) {
                        Log.e("MicroMsg.SDK.BaseFinderAction", e2.getMessage());
                    }
                } else if (fDg == hashCode) {
                    this.field_postTime = cursor.getLong(i2);
                } else if (fDh == hashCode) {
                    this.field_tryCount = cursor.getLong(i2);
                } else if (fDi == hashCode) {
                    this.field_canRemove = cursor.getInt(i2);
                } else if (fDj == hashCode) {
                    this.field_lastTryTime = cursor.getLong(i2);
                } else if (fDk == hashCode) {
                    this.field_failedFlag = cursor.getInt(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.fCR) {
            contentValues.put("localCommentId", Long.valueOf(this.field_localCommentId));
        }
        if (this.fCS) {
            contentValues.put("feedId", Long.valueOf(this.field_feedId));
        }
        if (this.fCT) {
            contentValues.put("actionTime", Long.valueOf(this.field_actionTime));
        }
        if (this.fBt) {
            contentValues.put("actionType", Integer.valueOf(this.field_actionType));
        }
        if (this.fCU) {
            contentValues.put("objectNonceId", this.field_objectNonceId);
        }
        if (this.fjO) {
            contentValues.put("scene", Integer.valueOf(this.field_scene));
        }
        if (this.fxx) {
            contentValues.put("state", Integer.valueOf(this.field_state));
        }
        if (this.fCV && this.field_actionInfo != null) {
            try {
                contentValues.put("actionInfo", this.field_actionInfo.toByteArray());
            } catch (IOException e2) {
                Log.e("MicroMsg.SDK.BaseFinderAction", e2.getMessage());
            }
        }
        if (this.fCW) {
            contentValues.put("postTime", Long.valueOf(this.field_postTime));
        }
        if (this.fCX) {
            contentValues.put("tryCount", Long.valueOf(this.field_tryCount));
        }
        if (this.fCY) {
            contentValues.put("canRemove", Integer.valueOf(this.field_canRemove));
        }
        if (this.fCZ) {
            contentValues.put("lastTryTime", Long.valueOf(this.field_lastTryTime));
        }
        if (this.fDa) {
            contentValues.put("failedFlag", Integer.valueOf(this.field_failedFlag));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
