package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class el extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fBo = "subtype".hashCode();
    private static final int fQA = "minilogoMd5".hashCode();
    private static final int fQy = "bubbleMd5".hashCode();
    private static final int fQz = "coverMd5".hashCode();
    private static final int flv = "version".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private static final int uAb = "detailMd5".hashCode();
    private boolean fBm = true;
    private boolean fQv = true;
    private boolean fQw = true;
    private boolean fQx = true;
    public String field_bubbleMd5;
    public String field_coverMd5;
    public String field_detailMd5;
    public String field_minilogoMd5;
    public int field_subtype;
    public int field_version;
    private boolean flq = true;
    private boolean uzY = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fBo == hashCode) {
                    this.field_subtype = cursor.getInt(i2);
                    this.fBm = true;
                } else if (fQy == hashCode) {
                    this.field_bubbleMd5 = cursor.getString(i2);
                } else if (fQz == hashCode) {
                    this.field_coverMd5 = cursor.getString(i2);
                } else if (fQA == hashCode) {
                    this.field_minilogoMd5 = cursor.getString(i2);
                } else if (uAb == hashCode) {
                    this.field_detailMd5 = cursor.getString(i2);
                } else if (flv == hashCode) {
                    this.field_version = cursor.getInt(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.fBm) {
            contentValues.put("subtype", Integer.valueOf(this.field_subtype));
        }
        if (this.fQv) {
            contentValues.put("bubbleMd5", this.field_bubbleMd5);
        }
        if (this.fQw) {
            contentValues.put("coverMd5", this.field_coverMd5);
        }
        if (this.fQx) {
            contentValues.put("minilogoMd5", this.field_minilogoMd5);
        }
        if (this.uzY) {
            contentValues.put("detailMd5", this.field_detailMd5);
        }
        if (this.flq) {
            contentValues.put("version", Integer.valueOf(this.field_version));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
