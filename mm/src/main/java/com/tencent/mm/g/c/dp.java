package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.google.android.gms.measurement.AppMeasurement;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class dp extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fBI = AppMeasurement.Param.TIMESTAMP.hashCode();
    private static final int fMo = "rankID".hashCode();
    private static final int fMp = "appusername".hashCode();
    private static final int fMq = "liketips".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private static final int username_HASHCODE = ch.COL_USERNAME.hashCode();
    private boolean __hadSetusername = true;
    private boolean fBy = true;
    private boolean fMl = true;
    private boolean fMm = true;
    private boolean fMn = true;
    public String field_appusername;
    public String field_liketips;
    public String field_rankID;
    public int field_timestamp;
    public String field_username;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fMo == hashCode) {
                    this.field_rankID = cursor.getString(i2);
                } else if (fMp == hashCode) {
                    this.field_appusername = cursor.getString(i2);
                } else if (username_HASHCODE == hashCode) {
                    this.field_username = cursor.getString(i2);
                } else if (fBI == hashCode) {
                    this.field_timestamp = cursor.getInt(i2);
                } else if (fMq == hashCode) {
                    this.field_liketips = cursor.getString(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.fMl) {
            contentValues.put("rankID", this.field_rankID);
        }
        if (this.fMm) {
            contentValues.put("appusername", this.field_appusername);
        }
        if (this.__hadSetusername) {
            contentValues.put(ch.COL_USERNAME, this.field_username);
        }
        if (this.fBy) {
            contentValues.put(AppMeasurement.Param.TIMESTAMP, Integer.valueOf(this.field_timestamp));
        }
        if (this.field_liketips == null) {
            this.field_liketips = "";
        }
        if (this.fMn) {
            contentValues.put("liketips", this.field_liketips);
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
