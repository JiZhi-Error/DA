package com.tencent.mm.plugin.textstatus.h;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public abstract class c extends IAutoDBItem {
    private static final int Gcg = "HashUserName".hashCode();
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fGE = "UserName".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private boolean Gca = true;
    private boolean fGw = true;
    public String field_HashUserName;
    public String field_UserName;

    public static IAutoDBItem.MAutoDBInfo ajs() {
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[2];
        mAutoDBInfo.columns = new String[3];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "UserName";
        mAutoDBInfo.colsMap.put("UserName", "TEXT PRIMARY KEY ");
        sb.append(" UserName TEXT PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "UserName";
        mAutoDBInfo.columns[1] = "HashUserName";
        mAutoDBInfo.colsMap.put("HashUserName", "TEXT");
        sb.append(" HashUserName TEXT");
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
                if (fGE == hashCode) {
                    this.field_UserName = cursor.getString(i2);
                    this.fGw = true;
                } else if (Gcg == hashCode) {
                    this.field_HashUserName = cursor.getString(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.fGw) {
            contentValues.put("UserName", this.field_UserName);
        }
        if (this.Gca) {
            contentValues.put("HashUserName", this.field_HashUserName);
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
