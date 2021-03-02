package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public abstract class ca extends IAutoDBItem {
    public static final String[] INDEX_CREATE = {"CREATE INDEX IF NOT EXISTS FavSearchInfo_Content_Index ON FavSearchInfo(content)", "CREATE INDEX IF NOT EXISTS FavSearchInfo_TagContent_Index ON FavSearchInfo(tagContent)", "CREATE INDEX IF NOT EXISTS FavSearchInfo_SubType_Index ON FavSearchInfo(subtype)"};
    private static final int content_HASHCODE = "content".hashCode();
    private static final int fBn = "tagContent".hashCode();
    private static final int fBo = "subtype".hashCode();
    private static final int frC = "time".hashCode();
    private static final int localId_HASHCODE = ch.COL_LOCALID.hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private static final int type_HASHCODE = "type".hashCode();
    private boolean __hadSetcontent = true;
    private boolean __hadSetlocalId = true;
    private boolean __hadSettype = true;
    private boolean fBl = true;
    private boolean fBm = true;
    public String field_content;
    public long field_localId;
    public int field_subtype;
    public String field_tagContent;
    public long field_time;
    public int field_type;
    private boolean frj = true;

    public static IAutoDBItem.MAutoDBInfo ajs() {
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[6];
        mAutoDBInfo.columns = new String[7];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = ch.COL_LOCALID;
        mAutoDBInfo.colsMap.put(ch.COL_LOCALID, "LONG PRIMARY KEY ");
        sb.append(" localId LONG PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = ch.COL_LOCALID;
        mAutoDBInfo.columns[1] = "content";
        mAutoDBInfo.colsMap.put("content", "TEXT");
        sb.append(" content TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "tagContent";
        mAutoDBInfo.colsMap.put("tagContent", "TEXT");
        sb.append(" tagContent TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "time";
        mAutoDBInfo.colsMap.put("time", "LONG");
        sb.append(" time LONG");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "type";
        mAutoDBInfo.colsMap.put("type", "INTEGER");
        sb.append(" type INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "subtype";
        mAutoDBInfo.colsMap.put("subtype", "INTEGER default '0' ");
        sb.append(" subtype INTEGER default '0' ");
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
                if (localId_HASHCODE == hashCode) {
                    this.field_localId = cursor.getLong(i2);
                    this.__hadSetlocalId = true;
                } else if (content_HASHCODE == hashCode) {
                    this.field_content = cursor.getString(i2);
                } else if (fBn == hashCode) {
                    this.field_tagContent = cursor.getString(i2);
                } else if (frC == hashCode) {
                    this.field_time = cursor.getLong(i2);
                } else if (type_HASHCODE == hashCode) {
                    this.field_type = cursor.getInt(i2);
                } else if (fBo == hashCode) {
                    this.field_subtype = cursor.getInt(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.__hadSetlocalId) {
            contentValues.put(ch.COL_LOCALID, Long.valueOf(this.field_localId));
        }
        if (this.__hadSetcontent) {
            contentValues.put("content", this.field_content);
        }
        if (this.fBl) {
            contentValues.put("tagContent", this.field_tagContent);
        }
        if (this.frj) {
            contentValues.put("time", Long.valueOf(this.field_time));
        }
        if (this.__hadSettype) {
            contentValues.put("type", Integer.valueOf(this.field_type));
        }
        if (this.fBm) {
            contentValues.put("subtype", Integer.valueOf(this.field_subtype));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
