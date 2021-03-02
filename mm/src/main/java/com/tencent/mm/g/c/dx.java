package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class dx extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fFe = FFmpegMetadataRetriever.METADATA_KEY_DURATION.hashCode();
    private static final int fMZ = "phonenumber".hashCode();
    private static final int fNa = "calltime".hashCode();
    private static final int fNb = "addressId".hashCode();
    private static final int fNc = "phoneType".hashCode();
    private static final int fjl = "status".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private boolean fES = true;
    private boolean fMV = true;
    private boolean fMW = true;
    private boolean fMX = true;
    private boolean fMY = true;
    public long field_addressId;
    public long field_calltime;
    public long field_duration;
    public int field_phoneType;
    public String field_phonenumber;
    public int field_status;
    private boolean fji = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fMZ == hashCode) {
                    this.field_phonenumber = cursor.getString(i2);
                } else if (fNa == hashCode) {
                    this.field_calltime = cursor.getLong(i2);
                } else if (fFe == hashCode) {
                    this.field_duration = cursor.getLong(i2);
                } else if (fjl == hashCode) {
                    this.field_status = cursor.getInt(i2);
                } else if (fNb == hashCode) {
                    this.field_addressId = cursor.getLong(i2);
                } else if (fNc == hashCode) {
                    this.field_phoneType = cursor.getInt(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.fMV) {
            contentValues.put("phonenumber", this.field_phonenumber);
        }
        if (this.fMW) {
            contentValues.put("calltime", Long.valueOf(this.field_calltime));
        }
        if (this.fES) {
            contentValues.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, Long.valueOf(this.field_duration));
        }
        if (this.fji) {
            contentValues.put("status", Integer.valueOf(this.field_status));
        }
        if (this.fMX) {
            contentValues.put("addressId", Long.valueOf(this.field_addressId));
        }
        if (this.fMY) {
            contentValues.put("phoneType", Integer.valueOf(this.field_phoneType));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
