package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public abstract class gq extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int gaM = "storyId".hashCode();
    private static final int gaN = "readCommentId".hashCode();
    private static final int gaO = "syncCommentId".hashCode();
    private static final int gaP = "readCommentTime".hashCode();
    private static final int gaQ = "syncCommentTime".hashCode();
    private static final int gaR = "commentFlag".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    public int field_commentFlag;
    public int field_readCommentId;
    public int field_readCommentTime;
    public long field_storyId;
    public int field_syncCommentId;
    public int field_syncCommentTime;
    private boolean gaG = true;
    private boolean gaH = true;
    private boolean gaI = true;
    private boolean gaJ = true;
    private boolean gaK = true;
    private boolean gaL = true;

    public static IAutoDBItem.MAutoDBInfo ajs() {
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[6];
        mAutoDBInfo.columns = new String[7];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "storyId";
        mAutoDBInfo.colsMap.put("storyId", "LONG PRIMARY KEY ");
        sb.append(" storyId LONG PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "storyId";
        mAutoDBInfo.columns[1] = "readCommentId";
        mAutoDBInfo.colsMap.put("readCommentId", "INTEGER");
        sb.append(" readCommentId INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "syncCommentId";
        mAutoDBInfo.colsMap.put("syncCommentId", "INTEGER");
        sb.append(" syncCommentId INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "readCommentTime";
        mAutoDBInfo.colsMap.put("readCommentTime", "INTEGER");
        sb.append(" readCommentTime INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "syncCommentTime";
        mAutoDBInfo.colsMap.put("syncCommentTime", "INTEGER");
        sb.append(" syncCommentTime INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "commentFlag";
        mAutoDBInfo.colsMap.put("commentFlag", "INTEGER");
        sb.append(" commentFlag INTEGER");
        mAutoDBInfo.columns[6] = "rowid";
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
                if (gaM == hashCode) {
                    this.field_storyId = cursor.getLong(i2);
                    this.gaG = true;
                } else if (gaN == hashCode) {
                    this.field_readCommentId = cursor.getInt(i2);
                } else if (gaO == hashCode) {
                    this.field_syncCommentId = cursor.getInt(i2);
                } else if (gaP == hashCode) {
                    this.field_readCommentTime = cursor.getInt(i2);
                } else if (gaQ == hashCode) {
                    this.field_syncCommentTime = cursor.getInt(i2);
                } else if (gaR == hashCode) {
                    this.field_commentFlag = cursor.getInt(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.gaG) {
            contentValues.put("storyId", Long.valueOf(this.field_storyId));
        }
        if (this.gaH) {
            contentValues.put("readCommentId", Integer.valueOf(this.field_readCommentId));
        }
        if (this.gaI) {
            contentValues.put("syncCommentId", Integer.valueOf(this.field_syncCommentId));
        }
        if (this.gaJ) {
            contentValues.put("readCommentTime", Integer.valueOf(this.field_readCommentTime));
        }
        if (this.gaK) {
            contentValues.put("syncCommentTime", Integer.valueOf(this.field_syncCommentTime));
        }
        if (this.gaL) {
            contentValues.put("commentFlag", Integer.valueOf(this.field_commentFlag));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
