package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.google.android.gms.measurement.AppMeasurement;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class gp extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fBI = AppMeasurement.Param.TIMESTAMP.hashCode();
    private static final int fMu = "step".hashCode();
    private static final int fQC = FFmpegMetadataRetriever.METADATA_KEY_DATE.hashCode();
    private static final int id_HASHCODE = "id".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private boolean __hadSetid = true;
    private boolean fBy = true;
    private boolean fMt = true;
    private boolean fQB = true;
    public String field_date;
    public int field_id;
    public int field_step;
    public long field_timestamp;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (id_HASHCODE == hashCode) {
                    this.field_id = cursor.getInt(i2);
                    this.__hadSetid = true;
                } else if (fQC == hashCode) {
                    this.field_date = cursor.getString(i2);
                } else if (fMu == hashCode) {
                    this.field_step = cursor.getInt(i2);
                } else if (fBI == hashCode) {
                    this.field_timestamp = cursor.getLong(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.__hadSetid) {
            contentValues.put("id", Integer.valueOf(this.field_id));
        }
        if (this.fQB) {
            contentValues.put(FFmpegMetadataRetriever.METADATA_KEY_DATE, this.field_date);
        }
        if (this.fMt) {
            contentValues.put("step", Integer.valueOf(this.field_step));
        }
        if (this.fBy) {
            contentValues.put(AppMeasurement.Param.TIMESTAMP, Long.valueOf(this.field_timestamp));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
