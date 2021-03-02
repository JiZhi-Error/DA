package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public abstract class en extends IAutoDBItem {
    public static final String[] INDEX_CREATE = {"CREATE INDEX IF NOT EXISTS MMStoryInfo_id_Index ON MMStoryInfo(storyID)"};
    private static final int attrBuf_HASHCODE = "attrBuf".hashCode();
    private static final int content_HASHCODE = "content".hashCode();
    private static final int createTime_HASHCODE = "createTime".hashCode();
    private static final int fQI = "storyID".hashCode();
    private static final int fQJ = "commentListCount".hashCode();
    private static final int fQK = "itemStoryFlag".hashCode();
    private static final int fQL = "readCount".hashCode();
    private static final int fQM = "favoriteTime".hashCode();
    private static final int localFlag_HASHCODE = "localFlag".hashCode();
    private static final int postBuf_HASHCODE = "postBuf".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private static final int sourceType_HASHCODE = "sourceType".hashCode();
    private static final int type_HASHCODE = "type".hashCode();
    private static final int userName_HASHCODE = "userName".hashCode();
    private boolean __hadSetattrBuf = true;
    private boolean __hadSetcontent = true;
    private boolean __hadSetcreateTime = true;
    private boolean __hadSetlocalFlag = true;
    private boolean __hadSetpostBuf = true;
    private boolean __hadSetsourceType = true;
    private boolean __hadSettype = true;
    private boolean __hadSetuserName = true;
    private boolean fQD = true;
    private boolean fQE = true;
    private boolean fQF = true;
    private boolean fQG = true;
    private boolean fQH = true;
    public byte[] field_attrBuf;
    public int field_commentListCount;
    public byte[] field_content;
    public int field_createTime;
    public int field_favoriteTime;
    public int field_itemStoryFlag;
    public int field_localFlag;
    public byte[] field_postBuf;
    public int field_readCount;
    public int field_sourceType;
    public long field_storyID;
    public int field_type;
    public String field_userName;

    public static IAutoDBItem.MAutoDBInfo ajs() {
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[13];
        mAutoDBInfo.columns = new String[14];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "storyID";
        mAutoDBInfo.colsMap.put("storyID", "LONG");
        sb.append(" storyID LONG");
        sb.append(", ");
        mAutoDBInfo.columns[1] = "userName";
        mAutoDBInfo.colsMap.put("userName", "TEXT");
        sb.append(" userName TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "localFlag";
        mAutoDBInfo.colsMap.put("localFlag", "INTEGER");
        sb.append(" localFlag INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "createTime";
        mAutoDBInfo.colsMap.put("createTime", "INTEGER");
        sb.append(" createTime INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "commentListCount";
        mAutoDBInfo.colsMap.put("commentListCount", "INTEGER");
        sb.append(" commentListCount INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "content";
        mAutoDBInfo.colsMap.put("content", "BLOB");
        sb.append(" content BLOB");
        sb.append(", ");
        mAutoDBInfo.columns[6] = "attrBuf";
        mAutoDBInfo.colsMap.put("attrBuf", "BLOB");
        sb.append(" attrBuf BLOB");
        sb.append(", ");
        mAutoDBInfo.columns[7] = "postBuf";
        mAutoDBInfo.colsMap.put("postBuf", "BLOB");
        sb.append(" postBuf BLOB");
        sb.append(", ");
        mAutoDBInfo.columns[8] = "sourceType";
        mAutoDBInfo.colsMap.put("sourceType", "INTEGER");
        sb.append(" sourceType INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[9] = "type";
        mAutoDBInfo.colsMap.put("type", "INTEGER");
        sb.append(" type INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[10] = "itemStoryFlag";
        mAutoDBInfo.colsMap.put("itemStoryFlag", "INTEGER");
        sb.append(" itemStoryFlag INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[11] = "readCount";
        mAutoDBInfo.colsMap.put("readCount", "INTEGER");
        sb.append(" readCount INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[12] = "favoriteTime";
        mAutoDBInfo.colsMap.put("favoriteTime", "INTEGER");
        sb.append(" favoriteTime INTEGER");
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
                if (fQI == hashCode) {
                    this.field_storyID = cursor.getLong(i2);
                } else if (userName_HASHCODE == hashCode) {
                    this.field_userName = cursor.getString(i2);
                } else if (localFlag_HASHCODE == hashCode) {
                    this.field_localFlag = cursor.getInt(i2);
                } else if (createTime_HASHCODE == hashCode) {
                    this.field_createTime = cursor.getInt(i2);
                } else if (fQJ == hashCode) {
                    this.field_commentListCount = cursor.getInt(i2);
                } else if (content_HASHCODE == hashCode) {
                    this.field_content = cursor.getBlob(i2);
                } else if (attrBuf_HASHCODE == hashCode) {
                    this.field_attrBuf = cursor.getBlob(i2);
                } else if (postBuf_HASHCODE == hashCode) {
                    this.field_postBuf = cursor.getBlob(i2);
                } else if (sourceType_HASHCODE == hashCode) {
                    this.field_sourceType = cursor.getInt(i2);
                } else if (type_HASHCODE == hashCode) {
                    this.field_type = cursor.getInt(i2);
                } else if (fQK == hashCode) {
                    this.field_itemStoryFlag = cursor.getInt(i2);
                } else if (fQL == hashCode) {
                    this.field_readCount = cursor.getInt(i2);
                } else if (fQM == hashCode) {
                    this.field_favoriteTime = cursor.getInt(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.fQD) {
            contentValues.put("storyID", Long.valueOf(this.field_storyID));
        }
        if (this.__hadSetuserName) {
            contentValues.put("userName", this.field_userName);
        }
        if (this.__hadSetlocalFlag) {
            contentValues.put("localFlag", Integer.valueOf(this.field_localFlag));
        }
        if (this.__hadSetcreateTime) {
            contentValues.put("createTime", Integer.valueOf(this.field_createTime));
        }
        if (this.fQE) {
            contentValues.put("commentListCount", Integer.valueOf(this.field_commentListCount));
        }
        if (this.__hadSetcontent) {
            contentValues.put("content", this.field_content);
        }
        if (this.__hadSetattrBuf) {
            contentValues.put("attrBuf", this.field_attrBuf);
        }
        if (this.__hadSetpostBuf) {
            contentValues.put("postBuf", this.field_postBuf);
        }
        if (this.__hadSetsourceType) {
            contentValues.put("sourceType", Integer.valueOf(this.field_sourceType));
        }
        if (this.__hadSettype) {
            contentValues.put("type", Integer.valueOf(this.field_type));
        }
        if (this.fQF) {
            contentValues.put("itemStoryFlag", Integer.valueOf(this.field_itemStoryFlag));
        }
        if (this.fQG) {
            contentValues.put("readCount", Integer.valueOf(this.field_readCount));
        }
        if (this.fQH) {
            contentValues.put("favoriteTime", Integer.valueOf(this.field_favoriteTime));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
