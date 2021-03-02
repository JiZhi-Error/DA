package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class fx extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fXK = "originMD5".hashCode();
    private static final int fXL = "resultFile".hashCode();
    private static final int fXM = "fromLang".hashCode();
    private static final int fXN = "toLang".hashCode();
    private static final int fXO = "brand".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private boolean fXF = true;
    private boolean fXG = true;
    private boolean fXH = true;
    private boolean fXI = true;
    private boolean fXJ = true;
    public String field_brand;
    public String field_fromLang;
    public String field_originMD5;
    public String field_resultFile;
    public String field_toLang;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fXK == hashCode) {
                    this.field_originMD5 = cursor.getString(i2);
                    this.fXF = true;
                } else if (fXL == hashCode) {
                    this.field_resultFile = cursor.getString(i2);
                } else if (fXM == hashCode) {
                    this.field_fromLang = cursor.getString(i2);
                } else if (fXN == hashCode) {
                    this.field_toLang = cursor.getString(i2);
                } else if (fXO == hashCode) {
                    this.field_brand = cursor.getString(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.fXF) {
            contentValues.put("originMD5", this.field_originMD5);
        }
        if (this.fXG) {
            contentValues.put("resultFile", this.field_resultFile);
        }
        if (this.fXH) {
            contentValues.put("fromLang", this.field_fromLang);
        }
        if (this.fXI) {
            contentValues.put("toLang", this.field_toLang);
        }
        if (this.fXJ) {
            contentValues.put("brand", this.field_brand);
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
