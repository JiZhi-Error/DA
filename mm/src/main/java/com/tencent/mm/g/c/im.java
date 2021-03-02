package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public abstract class im extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fPz = "liveId".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private static final int uxK = "luckyMoneyData".hashCode();
    private boolean fPt = true;
    public String field_liveId;
    public byte[] field_luckyMoneyData;
    private boolean uxF = true;

    public static IAutoDBItem.MAutoDBInfo ajs() {
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[2];
        mAutoDBInfo.columns = new String[3];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "liveId";
        mAutoDBInfo.colsMap.put("liveId", "TEXT PRIMARY KEY ");
        sb.append(" liveId TEXT PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "liveId";
        mAutoDBInfo.columns[1] = "luckyMoneyData";
        mAutoDBInfo.colsMap.put("luckyMoneyData", "BLOB");
        sb.append(" luckyMoneyData BLOB");
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
                if (fPz == hashCode) {
                    this.field_liveId = cursor.getString(i2);
                    this.fPt = true;
                } else if (uxK == hashCode) {
                    this.field_luckyMoneyData = cursor.getBlob(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.fPt) {
            contentValues.put("liveId", this.field_liveId);
        }
        if (this.uxF) {
            contentValues.put("luckyMoneyData", this.field_luckyMoneyData);
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
