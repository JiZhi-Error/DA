package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class az extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int createTime_HASHCODE = "createTime".hashCode();
    private static final int fvm = "labelID".hashCode();
    private static final int fvn = "labelName".hashCode();
    private static final int fvo = "labelPYFull".hashCode();
    private static final int fvp = "labelPYShort".hashCode();
    private static final int fvq = "isTemporary".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private boolean __hadSetcreateTime = true;
    public long field_createTime;
    public boolean field_isTemporary;
    public int field_labelID;
    public String field_labelName;
    public String field_labelPYFull;
    public String field_labelPYShort;
    private boolean fvh = true;
    private boolean fvi = true;
    private boolean fvj = true;
    private boolean fvk = true;
    private boolean fvl = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fvm == hashCode) {
                    this.field_labelID = cursor.getInt(i2);
                    this.fvh = true;
                } else if (fvn == hashCode) {
                    this.field_labelName = cursor.getString(i2);
                } else if (fvo == hashCode) {
                    this.field_labelPYFull = cursor.getString(i2);
                } else if (fvp == hashCode) {
                    this.field_labelPYShort = cursor.getString(i2);
                } else if (createTime_HASHCODE == hashCode) {
                    this.field_createTime = cursor.getLong(i2);
                } else if (fvq == hashCode) {
                    this.field_isTemporary = cursor.getInt(i2) != 0;
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.fvh) {
            contentValues.put("labelID", Integer.valueOf(this.field_labelID));
        }
        if (this.fvi) {
            contentValues.put("labelName", this.field_labelName);
        }
        if (this.fvj) {
            contentValues.put("labelPYFull", this.field_labelPYFull);
        }
        if (this.fvk) {
            contentValues.put("labelPYShort", this.field_labelPYShort);
        }
        if (this.__hadSetcreateTime) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.fvl) {
            contentValues.put("isTemporary", Boolean.valueOf(this.field_isTemporary));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
