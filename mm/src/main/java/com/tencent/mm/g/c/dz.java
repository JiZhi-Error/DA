package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public abstract class dz extends IAutoDBItem {
    public static final String COL_EXPIRE_AT = "expire_at";
    public static final String COL_KEY = "key";
    public static final String COL_VALUE = "value";
    public static final String[] INDEX_CREATE = new String[0];
    public static final String TABLE_NAME = "KindaCacheTable";
    private static final String TAG = "MicroMsg.SDK.BaseKindaCacheTable";
    private static final int expire_at_HASHCODE = "expire_at".hashCode();
    private static final int key_HASHCODE = "key".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private static final int value_HASHCODE = "value".hashCode();
    private boolean __hadSetexpire_at = true;
    private boolean __hadSetkey = true;
    private boolean __hadSetvalue = true;
    public long field_expire_at;
    public String field_key;
    public byte[] field_value;

    public static IAutoDBItem.MAutoDBInfo initAutoDBInfo(Class<?> cls) {
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[3];
        mAutoDBInfo.columns = new String[4];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "key";
        mAutoDBInfo.colsMap.put("key", "TEXT PRIMARY KEY ");
        sb.append(" key TEXT PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "key";
        mAutoDBInfo.columns[1] = "value";
        mAutoDBInfo.colsMap.put("value", "BLOB");
        sb.append(" value BLOB");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "expire_at";
        mAutoDBInfo.colsMap.put("expire_at", "LONG");
        sb.append(" expire_at LONG");
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
                if (key_HASHCODE == hashCode) {
                    this.field_key = cursor.getString(i2);
                    this.__hadSetkey = true;
                } else if (value_HASHCODE == hashCode) {
                    this.field_value = cursor.getBlob(i2);
                } else if (expire_at_HASHCODE == hashCode) {
                    this.field_expire_at = cursor.getLong(i2);
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
        if (this.__hadSetkey) {
            contentValues.put("key", this.field_key);
        }
        if (this.__hadSetvalue) {
            contentValues.put("value", this.field_value);
        }
        if (this.__hadSetexpire_at) {
            contentValues.put("expire_at", Long.valueOf(this.field_expire_at));
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
