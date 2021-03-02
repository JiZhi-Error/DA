package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public abstract class em extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fQC = FFmpegMetadataRetriever.METADATA_KEY_DATE.hashCode();
    private static final int fxs = "count".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private boolean fQB = true;
    public int field_count;
    public String field_date;
    private boolean fwS = true;

    public static IAutoDBItem.MAutoDBInfo ajs() {
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[2];
        mAutoDBInfo.columns = new String[3];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = FFmpegMetadataRetriever.METADATA_KEY_DATE;
        mAutoDBInfo.colsMap.put(FFmpegMetadataRetriever.METADATA_KEY_DATE, "TEXT");
        sb.append(" date TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[1] = "count";
        mAutoDBInfo.colsMap.put("count", "INTEGER");
        sb.append(" count INTEGER");
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
                if (fQC == hashCode) {
                    this.field_date = cursor.getString(i2);
                } else if (fxs == hashCode) {
                    this.field_count = cursor.getInt(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.fQB) {
            contentValues.put(FFmpegMetadataRetriever.METADATA_KEY_DATE, this.field_date);
        }
        if (this.fwS) {
            contentValues.put("count", Integer.valueOf(this.field_count));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
