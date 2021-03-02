package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class gl extends IAutoDBItem {
    public static final String[] INDEX_CREATE = {"CREATE INDEX IF NOT EXISTS snsreport_kv_logtime ON SnsReportKv(logtime)"};
    private static final int fkp = "offset".hashCode();
    private static final int gao = "logtime".hashCode();
    private static final int gaq = "logsize".hashCode();
    private static final int gar = "errorcount".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private static final int value_HASHCODE = "value".hashCode();
    private boolean __hadSetvalue = true;
    public int field_errorcount;
    public int field_logsize;
    public long field_logtime;
    public int field_offset;
    public byte[] field_value;
    private boolean fjY = true;
    private boolean gal = true;
    private boolean gam = true;
    private boolean gan = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (gao == hashCode) {
                    this.field_logtime = cursor.getLong(i2);
                } else if (fkp == hashCode) {
                    this.field_offset = cursor.getInt(i2);
                } else if (gaq == hashCode) {
                    this.field_logsize = cursor.getInt(i2);
                } else if (gar == hashCode) {
                    this.field_errorcount = cursor.getInt(i2);
                } else if (value_HASHCODE == hashCode) {
                    this.field_value = cursor.getBlob(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.gal) {
            contentValues.put("logtime", Long.valueOf(this.field_logtime));
        }
        if (this.fjY) {
            contentValues.put("offset", Integer.valueOf(this.field_offset));
        }
        if (this.gam) {
            contentValues.put("logsize", Integer.valueOf(this.field_logsize));
        }
        if (this.gan) {
            contentValues.put("errorcount", Integer.valueOf(this.field_errorcount));
        }
        if (this.__hadSetvalue) {
            contentValues.put("value", this.field_value);
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
