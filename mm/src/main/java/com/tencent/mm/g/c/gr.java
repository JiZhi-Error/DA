package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public abstract class gr extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fPE = "timeStamp".hashCode();
    private static final int gaX = "baseItemData".hashCode();
    private static final int gaY = "storyLocalId".hashCode();
    private static final int gaZ = "mixFlag".hashCode();
    private static final int gba = "mixRetryTime".hashCode();
    private static final int gbb = "available".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private boolean fPy;
    public int field_available;
    public byte[] field_baseItemData;
    public int field_mixFlag;
    public int field_mixRetryTime;
    public int field_storyLocalId;
    public long field_timeStamp;
    private boolean gaS;
    private boolean gaT;
    private boolean gaU;
    private boolean gaV;
    private boolean gaW;

    public static IAutoDBItem.MAutoDBInfo ajs() {
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[6];
        mAutoDBInfo.columns = new String[7];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "baseItemData";
        mAutoDBInfo.colsMap.put("baseItemData", "BLOB");
        sb.append(" baseItemData BLOB");
        sb.append(", ");
        mAutoDBInfo.columns[1] = "timeStamp";
        mAutoDBInfo.colsMap.put("timeStamp", "LONG");
        sb.append(" timeStamp LONG");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "storyLocalId";
        mAutoDBInfo.colsMap.put("storyLocalId", "INTEGER");
        sb.append(" storyLocalId INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "mixFlag";
        mAutoDBInfo.colsMap.put("mixFlag", "INTEGER");
        sb.append(" mixFlag INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "mixRetryTime";
        mAutoDBInfo.colsMap.put("mixRetryTime", "INTEGER");
        sb.append(" mixRetryTime INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "available";
        mAutoDBInfo.colsMap.put("available", "INTEGER");
        sb.append(" available INTEGER");
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
                if (gaX == hashCode) {
                    this.field_baseItemData = cursor.getBlob(i2);
                } else if (fPE == hashCode) {
                    this.field_timeStamp = cursor.getLong(i2);
                } else if (gaY == hashCode) {
                    this.field_storyLocalId = cursor.getInt(i2);
                } else if (gaZ == hashCode) {
                    this.field_mixFlag = cursor.getInt(i2);
                } else if (gba == hashCode) {
                    this.field_mixRetryTime = cursor.getInt(i2);
                } else if (gbb == hashCode) {
                    this.field_available = cursor.getInt(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.gaS) {
            contentValues.put("baseItemData", this.field_baseItemData);
        }
        if (this.fPy) {
            contentValues.put("timeStamp", Long.valueOf(this.field_timeStamp));
        }
        if (this.gaT) {
            contentValues.put("storyLocalId", Integer.valueOf(this.field_storyLocalId));
        }
        if (this.gaU) {
            contentValues.put("mixFlag", Integer.valueOf(this.field_mixFlag));
        }
        if (this.gaV) {
            contentValues.put("mixRetryTime", Integer.valueOf(this.field_mixRetryTime));
        }
        if (this.gaW) {
            contentValues.put("available", Integer.valueOf(this.field_available));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
