package com.tencent.mm.sdk.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.reflect.Field;
import java.util.HashMap;

@Deprecated
public abstract class MAutoDBItem extends IAutoDBItem {
    private static final String TAG = "MicroMsg.SDK.MAutoDBItem";

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        int nullAs;
        String[] columnNames = cursor.getColumnNames();
        if (columnNames == null) {
            Log.e(TAG, "convertFrom: get column names failed");
            return;
        }
        HashMap hashMap = new HashMap();
        for (int i2 = 0; i2 < columnNames.length; i2++) {
            hashMap.put(columnNames[i2], Integer.valueOf(i2));
        }
        Field[] fieldArr = getDBInfo().fields;
        for (Field field : fieldArr) {
            String colName = getColName(field);
            if (!Util.isNullOrNil(colName) && (nullAs = Util.nullAs((Integer) hashMap.get(colName), -1)) >= 0) {
                try {
                    CursorFieldHelper.setter(field.getType()).invoke(field, this, cursor, nullAs);
                } catch (Exception e2) {
                    Log.printErrStackTrace(TAG, e2, "", new Object[0]);
                }
            }
        }
        int nullAs2 = Util.nullAs((Integer) hashMap.get("rowid"), -1);
        if (nullAs2 >= 0) {
            this.systemRowid = cursor.getLong(nullAs2);
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        Field[] fieldArr = getDBInfo().fields;
        for (Field field : fieldArr) {
            try {
                CursorFieldHelper.getter(field.getType()).invoke(field, this, contentValues);
            } catch (Exception e2) {
                Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            }
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
