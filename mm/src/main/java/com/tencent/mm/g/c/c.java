package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class c extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fjt = "abtestkey".hashCode();
    private static final int fju = "expId".hashCode();
    private static final int fjv = "sequence".hashCode();
    private static final int fjw = "prioritylevel".hashCode();
    private static final int fjx = "startTime".hashCode();
    private static final int fjy = "endTime".hashCode();
    private static final int fjz = "noReport".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private static final int value_HASHCODE = "value".hashCode();
    private boolean __hadSetvalue = true;
    public String field_abtestkey;
    public long field_endTime;
    public String field_expId;
    public boolean field_noReport;
    public int field_prioritylevel;
    public long field_sequence;
    public long field_startTime;
    public String field_value;
    private boolean fjm = true;
    private boolean fjn = true;
    private boolean fjo = true;
    private boolean fjp = true;
    private boolean fjq = true;
    private boolean fjr = true;
    private boolean fjs = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fjt == hashCode) {
                    this.field_abtestkey = cursor.getString(i2);
                    this.fjm = true;
                } else if (value_HASHCODE == hashCode) {
                    this.field_value = cursor.getString(i2);
                } else if (fju == hashCode) {
                    this.field_expId = cursor.getString(i2);
                } else if (fjv == hashCode) {
                    this.field_sequence = cursor.getLong(i2);
                } else if (fjw == hashCode) {
                    this.field_prioritylevel = cursor.getInt(i2);
                } else if (fjx == hashCode) {
                    this.field_startTime = cursor.getLong(i2);
                } else if (fjy == hashCode) {
                    this.field_endTime = cursor.getLong(i2);
                } else if (fjz == hashCode) {
                    this.field_noReport = cursor.getInt(i2) != 0;
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.fjm) {
            contentValues.put("abtestkey", this.field_abtestkey);
        }
        if (this.__hadSetvalue) {
            contentValues.put("value", this.field_value);
        }
        if (this.fjn) {
            contentValues.put("expId", this.field_expId);
        }
        if (this.fjo) {
            contentValues.put("sequence", Long.valueOf(this.field_sequence));
        }
        if (this.fjp) {
            contentValues.put("prioritylevel", Integer.valueOf(this.field_prioritylevel));
        }
        if (this.fjq) {
            contentValues.put("startTime", Long.valueOf(this.field_startTime));
        }
        if (this.fjr) {
            contentValues.put("endTime", Long.valueOf(this.field_endTime));
        }
        if (this.fjs) {
            contentValues.put("noReport", Boolean.valueOf(this.field_noReport));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
