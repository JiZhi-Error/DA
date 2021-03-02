package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public abstract class fy extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int createTime_HASHCODE = "createTime".hashCode();
    private static final int fJb = "expireTime".hashCode();
    private static final int fXR = "originId".hashCode();
    private static final int fXS = "indexData".hashCode();
    private static final int fkJ = "data".hashCode();
    private static final int id_HASHCODE = "id".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private static final int type_HASHCODE = "type".hashCode();
    private static final int updateTime_HASHCODE = ch.COL_UPDATETIME.hashCode();
    private boolean __hadSetcreateTime = true;
    private boolean __hadSetid = true;
    private boolean __hadSettype = true;
    private boolean __hadSetupdateTime = true;
    private boolean fIP = true;
    private boolean fXP = true;
    private boolean fXQ = true;
    public long field_createTime;
    public byte[] field_data;
    public long field_expireTime;
    public String field_id;
    public String field_indexData;
    public String field_originId;
    public int field_type;
    public long field_updateTime;
    private boolean fkF = true;

    public static IAutoDBItem.MAutoDBInfo ajs() {
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[8];
        mAutoDBInfo.columns = new String[9];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "id";
        mAutoDBInfo.colsMap.put("id", "TEXT PRIMARY KEY ");
        sb.append(" id TEXT PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "id";
        mAutoDBInfo.columns[1] = "originId";
        mAutoDBInfo.colsMap.put("originId", "TEXT default '' ");
        sb.append(" originId TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "createTime";
        mAutoDBInfo.colsMap.put("createTime", "LONG default '0' ");
        sb.append(" createTime LONG default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[3] = ch.COL_UPDATETIME;
        mAutoDBInfo.colsMap.put(ch.COL_UPDATETIME, "LONG default '0' ");
        sb.append(" updateTime LONG default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "expireTime";
        mAutoDBInfo.colsMap.put("expireTime", "LONG default '0' ");
        sb.append(" expireTime LONG default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "type";
        mAutoDBInfo.colsMap.put("type", "INTEGER default '0' ");
        sb.append(" type INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[6] = "data";
        mAutoDBInfo.colsMap.put("data", "BLOB");
        sb.append(" data BLOB");
        sb.append(", ");
        mAutoDBInfo.columns[7] = "indexData";
        mAutoDBInfo.colsMap.put("indexData", "TEXT default '' ");
        sb.append(" indexData TEXT default '' ");
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
                if (id_HASHCODE == hashCode) {
                    this.field_id = cursor.getString(i2);
                    this.__hadSetid = true;
                } else if (fXR == hashCode) {
                    this.field_originId = cursor.getString(i2);
                } else if (createTime_HASHCODE == hashCode) {
                    this.field_createTime = cursor.getLong(i2);
                } else if (updateTime_HASHCODE == hashCode) {
                    this.field_updateTime = cursor.getLong(i2);
                } else if (fJb == hashCode) {
                    this.field_expireTime = cursor.getLong(i2);
                } else if (type_HASHCODE == hashCode) {
                    this.field_type = cursor.getInt(i2);
                } else if (fkJ == hashCode) {
                    this.field_data = cursor.getBlob(i2);
                } else if (fXS == hashCode) {
                    this.field_indexData = cursor.getString(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.__hadSetid) {
            contentValues.put("id", this.field_id);
        }
        if (this.field_originId == null) {
            this.field_originId = "";
        }
        if (this.fXP) {
            contentValues.put("originId", this.field_originId);
        }
        if (this.__hadSetcreateTime) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.__hadSetupdateTime) {
            contentValues.put(ch.COL_UPDATETIME, Long.valueOf(this.field_updateTime));
        }
        if (this.fIP) {
            contentValues.put("expireTime", Long.valueOf(this.field_expireTime));
        }
        if (this.__hadSettype) {
            contentValues.put("type", Integer.valueOf(this.field_type));
        }
        if (this.fkF) {
            contentValues.put("data", this.field_data);
        }
        if (this.field_indexData == null) {
            this.field_indexData = "";
        }
        if (this.fXQ) {
            contentValues.put("indexData", this.field_indexData);
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
