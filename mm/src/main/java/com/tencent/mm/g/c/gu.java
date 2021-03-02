package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public abstract class gu extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fCx = "totalSize".hashCode();
    private static final int fEV = "cacheSize".hashCode();
    private static final int fnB = "url".hashCode();
    private static final int fsu = "filePath".hashCode();
    private static final int gaM = "storyId".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private boolean fBT = true;
    private boolean fEJ = true;
    public int field_cacheSize;
    public String field_filePath;
    public long field_storyId;
    public int field_totalSize;
    public String field_url;
    private boolean fnx = true;
    private boolean fsm = true;
    private boolean gaG = true;

    public static IAutoDBItem.MAutoDBInfo ajs() {
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[5];
        mAutoDBInfo.columns = new String[6];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "storyId";
        mAutoDBInfo.colsMap.put("storyId", "LONG PRIMARY KEY ");
        sb.append(" storyId LONG PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "storyId";
        mAutoDBInfo.columns[1] = "url";
        mAutoDBInfo.colsMap.put("url", "TEXT");
        sb.append(" url TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "filePath";
        mAutoDBInfo.colsMap.put("filePath", "TEXT");
        sb.append(" filePath TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "totalSize";
        mAutoDBInfo.colsMap.put("totalSize", "INTEGER");
        sb.append(" totalSize INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "cacheSize";
        mAutoDBInfo.colsMap.put("cacheSize", "INTEGER");
        sb.append(" cacheSize INTEGER");
        mAutoDBInfo.columns[5] = "rowid";
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
                } else if (fnB == hashCode) {
                    this.field_url = cursor.getString(i2);
                } else if (fsu == hashCode) {
                    this.field_filePath = cursor.getString(i2);
                } else if (fCx == hashCode) {
                    this.field_totalSize = cursor.getInt(i2);
                } else if (fEV == hashCode) {
                    this.field_cacheSize = cursor.getInt(i2);
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
        if (this.fnx) {
            contentValues.put("url", this.field_url);
        }
        if (this.fsm) {
            contentValues.put("filePath", this.field_filePath);
        }
        if (this.fBT) {
            contentValues.put("totalSize", Integer.valueOf(this.field_totalSize));
        }
        if (this.fEJ) {
            contentValues.put("cacheSize", Integer.valueOf(this.field_cacheSize));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
