package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public abstract class gk extends IAutoDBItem {
    public static final String COL_ATTRBUF = "attrBuf";
    public static final String COL_CONTENT = "content";
    public static final String COL_CREATETIME = "createTime";
    public static final String COL_HEAD = "head";
    public static final String COL_LIKEFLAG = "likeFlag";
    public static final String COL_LOCALFLAG = "localFlag";
    public static final String COL_LOCALPRIVATE = "localPrivate";
    public static final String COL_POSTBUF = "postBuf";
    public static final String COL_PRAVITED = "pravited";
    public static final String COL_SNSID = "snsId";
    public static final String COL_SOURCETYPE = "sourceType";
    public static final String COL_STRINGSEQ = "stringSeq";
    public static final String COL_SUBTYPE = "subType";
    public static final String COL_TYPE = "type";
    public static final String COL_USERNAME = "userName";
    public static final String[] INDEX_CREATE = new String[0];
    public static final String TABLE_NAME = "SnsInfo";
    private static final String TAG = "MicroMsg.SDK.BaseSnsInfo";
    private static final int attrBuf_HASHCODE = "attrBuf".hashCode();
    private static final int content_HASHCODE = "content".hashCode();
    private static final int createTime_HASHCODE = "createTime".hashCode();
    private static final int head_HASHCODE = "head".hashCode();
    private static final int likeFlag_HASHCODE = "likeFlag".hashCode();
    private static final int localFlag_HASHCODE = "localFlag".hashCode();
    private static final int localPrivate_HASHCODE = "localPrivate".hashCode();
    private static final int postBuf_HASHCODE = "postBuf".hashCode();
    private static final int pravited_HASHCODE = "pravited".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private static final int snsId_HASHCODE = "snsId".hashCode();
    private static final int sourceType_HASHCODE = "sourceType".hashCode();
    private static final int stringSeq_HASHCODE = "stringSeq".hashCode();
    private static final int subType_HASHCODE = "subType".hashCode();
    private static final int type_HASHCODE = "type".hashCode();
    private static final int userName_HASHCODE = "userName".hashCode();
    private boolean __hadSetattrBuf = true;
    private boolean __hadSetcontent = true;
    private boolean __hadSetcreateTime = true;
    private boolean __hadSethead = true;
    private boolean __hadSetlikeFlag = true;
    private boolean __hadSetlocalFlag = true;
    private boolean __hadSetlocalPrivate = true;
    private boolean __hadSetpostBuf = true;
    private boolean __hadSetpravited = true;
    private boolean __hadSetsnsId = true;
    private boolean __hadSetsourceType = true;
    private boolean __hadSetstringSeq = true;
    private boolean __hadSetsubType = true;
    private boolean __hadSettype = true;
    private boolean __hadSetuserName = true;
    public byte[] field_attrBuf;
    public byte[] field_content;
    public int field_createTime;
    public int field_head;
    public int field_likeFlag;
    public int field_localFlag;
    public int field_localPrivate;
    public byte[] field_postBuf;
    public int field_pravited;
    public long field_snsId;
    public int field_sourceType;
    public String field_stringSeq;
    public int field_subType;
    public int field_type;
    public String field_userName;

    public static IAutoDBItem.MAutoDBInfo initAutoDBInfo(Class<?> cls) {
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[15];
        mAutoDBInfo.columns = new String[16];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "snsId";
        mAutoDBInfo.colsMap.put("snsId", "LONG");
        sb.append(" snsId LONG");
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
        mAutoDBInfo.columns[4] = "head";
        mAutoDBInfo.colsMap.put("head", "INTEGER");
        sb.append(" head INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "localPrivate";
        mAutoDBInfo.colsMap.put("localPrivate", "INTEGER");
        sb.append(" localPrivate INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[6] = "type";
        mAutoDBInfo.colsMap.put("type", "INTEGER");
        sb.append(" type INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[7] = "sourceType";
        mAutoDBInfo.colsMap.put("sourceType", "INTEGER");
        sb.append(" sourceType INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[8] = "likeFlag";
        mAutoDBInfo.colsMap.put("likeFlag", "INTEGER");
        sb.append(" likeFlag INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[9] = "pravited";
        mAutoDBInfo.colsMap.put("pravited", "INTEGER");
        sb.append(" pravited INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[10] = "stringSeq";
        mAutoDBInfo.colsMap.put("stringSeq", "TEXT");
        sb.append(" stringSeq TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[11] = "content";
        mAutoDBInfo.colsMap.put("content", "BLOB");
        sb.append(" content BLOB");
        sb.append(", ");
        mAutoDBInfo.columns[12] = "attrBuf";
        mAutoDBInfo.colsMap.put("attrBuf", "BLOB");
        sb.append(" attrBuf BLOB");
        sb.append(", ");
        mAutoDBInfo.columns[13] = "postBuf";
        mAutoDBInfo.colsMap.put("postBuf", "BLOB");
        sb.append(" postBuf BLOB");
        sb.append(", ");
        mAutoDBInfo.columns[14] = "subType";
        mAutoDBInfo.colsMap.put("subType", "INTEGER");
        sb.append(" subType INTEGER");
        mAutoDBInfo.columns[15] = "rowid";
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
                if (snsId_HASHCODE == hashCode) {
                    this.field_snsId = cursor.getLong(i2);
                } else if (userName_HASHCODE == hashCode) {
                    this.field_userName = cursor.getString(i2);
                } else if (localFlag_HASHCODE == hashCode) {
                    this.field_localFlag = cursor.getInt(i2);
                } else if (createTime_HASHCODE == hashCode) {
                    this.field_createTime = cursor.getInt(i2);
                } else if (head_HASHCODE == hashCode) {
                    this.field_head = cursor.getInt(i2);
                } else if (localPrivate_HASHCODE == hashCode) {
                    this.field_localPrivate = cursor.getInt(i2);
                } else if (type_HASHCODE == hashCode) {
                    this.field_type = cursor.getInt(i2);
                } else if (sourceType_HASHCODE == hashCode) {
                    this.field_sourceType = cursor.getInt(i2);
                } else if (likeFlag_HASHCODE == hashCode) {
                    this.field_likeFlag = cursor.getInt(i2);
                } else if (pravited_HASHCODE == hashCode) {
                    this.field_pravited = cursor.getInt(i2);
                } else if (stringSeq_HASHCODE == hashCode) {
                    this.field_stringSeq = cursor.getString(i2);
                } else if (content_HASHCODE == hashCode) {
                    this.field_content = cursor.getBlob(i2);
                } else if (attrBuf_HASHCODE == hashCode) {
                    this.field_attrBuf = cursor.getBlob(i2);
                } else if (postBuf_HASHCODE == hashCode) {
                    this.field_postBuf = cursor.getBlob(i2);
                } else if (subType_HASHCODE == hashCode) {
                    this.field_subType = cursor.getInt(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        buildBuff();
        ContentValues contentValues = new ContentValues();
        if (this.__hadSetsnsId) {
            contentValues.put("snsId", Long.valueOf(this.field_snsId));
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
        if (this.__hadSethead) {
            contentValues.put("head", Integer.valueOf(this.field_head));
        }
        if (this.__hadSetlocalPrivate) {
            contentValues.put("localPrivate", Integer.valueOf(this.field_localPrivate));
        }
        if (this.__hadSettype) {
            contentValues.put("type", Integer.valueOf(this.field_type));
        }
        if (this.__hadSetsourceType) {
            contentValues.put("sourceType", Integer.valueOf(this.field_sourceType));
        }
        if (this.__hadSetlikeFlag) {
            contentValues.put("likeFlag", Integer.valueOf(this.field_likeFlag));
        }
        if (this.__hadSetpravited) {
            contentValues.put("pravited", Integer.valueOf(this.field_pravited));
        }
        if (this.__hadSetstringSeq) {
            contentValues.put("stringSeq", this.field_stringSeq);
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
        if (this.__hadSetsubType) {
            contentValues.put("subType", Integer.valueOf(this.field_subType));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }

    public void reset() {
    }

    private final void parseBuff() {
    }

    private final void buildBuff() {
    }
}
