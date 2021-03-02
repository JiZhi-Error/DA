package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public abstract class ij extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fyf = "md5".hashCode();
    private static final int localId_HASHCODE = ch.COL_LOCALID.hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private static final int uqn = "localPath".hashCode();
    private boolean __hadSetlocalId;
    public String field_localId;
    public String field_localPath;
    public String field_md5;
    private boolean fxt;
    private boolean uqk;

    public static IAutoDBItem.MAutoDBInfo ajs() {
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[3];
        mAutoDBInfo.columns = new String[4];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = ch.COL_LOCALID;
        mAutoDBInfo.colsMap.put(ch.COL_LOCALID, "TEXT PRIMARY KEY ");
        sb.append(" localId TEXT PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = ch.COL_LOCALID;
        mAutoDBInfo.columns[1] = "localPath";
        mAutoDBInfo.colsMap.put("localPath", "TEXT");
        sb.append(" localPath TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "md5";
        mAutoDBInfo.colsMap.put("md5", "TEXT");
        sb.append(" md5 TEXT");
        mAutoDBInfo.columns[3] = "rowid";
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
                    this.field_localId = cursor.getString(i2);
                    this.__hadSetlocalId = true;
                } else if (uqn == hashCode) {
                    this.field_localPath = cursor.getString(i2);
                } else if (fyf == hashCode) {
                    this.field_md5 = cursor.getString(i2);
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
            contentValues.put(ch.COL_LOCALID, this.field_localId);
        }
        if (this.uqk) {
            contentValues.put("localPath", this.field_localPath);
        }
        if (this.fxt) {
            contentValues.put("md5", this.field_md5);
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
