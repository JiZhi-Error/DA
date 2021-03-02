package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public abstract class hu extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int frC = "time".hashCode();
    private static final int giz = "weSeeUri".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    public long field_time;
    public String field_weSeeUri;
    private boolean frj = true;
    private boolean giy = true;

    public static IAutoDBItem.MAutoDBInfo ajs() {
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[2];
        mAutoDBInfo.columns = new String[3];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "weSeeUri";
        mAutoDBInfo.colsMap.put("weSeeUri", "TEXT");
        sb.append(" weSeeUri TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[1] = "time";
        mAutoDBInfo.colsMap.put("time", "LONG");
        sb.append(" time LONG");
        mAutoDBInfo.columns[2] = "rowid";
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
                if (giz == hashCode) {
                    this.field_weSeeUri = cursor.getString(i2);
                } else if (frC == hashCode) {
                    this.field_time = cursor.getLong(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.giy) {
            contentValues.put("weSeeUri", this.field_weSeeUri);
        }
        if (this.frj) {
            contentValues.put("time", Long.valueOf(this.field_time));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
