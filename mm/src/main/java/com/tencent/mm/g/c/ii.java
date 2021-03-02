package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public abstract class ii extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int createTime_HASHCODE = "createTime".hashCode();
    private static final int fjR = "ticket".hashCode();
    private static final int fof = "msgType".hashCode();
    private static final int fqe = "headImgUrl".hashCode();
    private static final int fqf = "nickname".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private static final int uni = "wishId".hashCode();
    private static final int uoB = "hashUsername".hashCode();
    private static final int uoC = "hasWish".hashCode();
    private boolean __hadSetcreateTime;
    public long field_createTime;
    public int field_hasWish;
    public String field_hashUsername;
    public String field_headImgUrl;
    public int field_msgType;
    public String field_nickname;
    public String field_ticket;
    public String field_wishId;
    private boolean fjP;
    private boolean fnQ;
    private boolean fqa;
    private boolean fqb;
    private boolean une;
    private boolean unf;
    private boolean unh;

    public static IAutoDBItem.MAutoDBInfo ajs() {
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[8];
        mAutoDBInfo.columns = new String[9];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "wishId";
        mAutoDBInfo.colsMap.put("wishId", "TEXT PRIMARY KEY ");
        sb.append(" wishId TEXT PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "wishId";
        mAutoDBInfo.columns[1] = "msgType";
        mAutoDBInfo.colsMap.put("msgType", "INTEGER");
        sb.append(" msgType INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "ticket";
        mAutoDBInfo.colsMap.put("ticket", "TEXT");
        sb.append(" ticket TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "nickname";
        mAutoDBInfo.colsMap.put("nickname", "TEXT");
        sb.append(" nickname TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "headImgUrl";
        mAutoDBInfo.colsMap.put("headImgUrl", "TEXT");
        sb.append(" headImgUrl TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "hashUsername";
        mAutoDBInfo.colsMap.put("hashUsername", "TEXT");
        sb.append(" hashUsername TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[6] = "createTime";
        mAutoDBInfo.colsMap.put("createTime", "LONG");
        sb.append(" createTime LONG");
        sb.append(", ");
        mAutoDBInfo.columns[7] = "hasWish";
        mAutoDBInfo.colsMap.put("hasWish", "INTEGER");
        sb.append(" hasWish INTEGER");
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
                if (uni == hashCode) {
                    this.field_wishId = cursor.getString(i2);
                    this.une = true;
                } else if (fof == hashCode) {
                    this.field_msgType = cursor.getInt(i2);
                } else if (fjR == hashCode) {
                    this.field_ticket = cursor.getString(i2);
                } else if (fqf == hashCode) {
                    this.field_nickname = cursor.getString(i2);
                } else if (fqe == hashCode) {
                    this.field_headImgUrl = cursor.getString(i2);
                } else if (uoB == hashCode) {
                    this.field_hashUsername = cursor.getString(i2);
                } else if (createTime_HASHCODE == hashCode) {
                    this.field_createTime = cursor.getLong(i2);
                } else if (uoC == hashCode) {
                    this.field_hasWish = cursor.getInt(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.une) {
            contentValues.put("wishId", this.field_wishId);
        }
        if (this.fnQ) {
            contentValues.put("msgType", Integer.valueOf(this.field_msgType));
        }
        if (this.fjP) {
            contentValues.put("ticket", this.field_ticket);
        }
        if (this.fqb) {
            contentValues.put("nickname", this.field_nickname);
        }
        if (this.fqa) {
            contentValues.put("headImgUrl", this.field_headImgUrl);
        }
        if (this.unf) {
            contentValues.put("hashUsername", this.field_hashUsername);
        }
        if (this.__hadSetcreateTime) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.unh) {
            contentValues.put("hasWish", Integer.valueOf(this.field_hasWish));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
