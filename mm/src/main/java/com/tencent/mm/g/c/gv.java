package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class gv extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fui = "conRemark".hashCode();
    private static final int fus = "encryptUsername".hashCode();
    private static final int gbN = "contactLabels".hashCode();
    private static final int gbO = "conDescription".hashCode();
    private static final int gbP = "conPhone".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    public String field_conDescription;
    public String field_conPhone;
    public String field_conRemark;
    public String field_contactLabels;
    public String field_encryptUsername;
    private boolean ftQ = true;
    private boolean fua = true;
    private boolean gbK = true;
    private boolean gbL = true;
    private boolean gbM = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fus == hashCode) {
                    this.field_encryptUsername = cursor.getString(i2);
                    this.fua = true;
                } else if (fui == hashCode) {
                    this.field_conRemark = cursor.getString(i2);
                } else if (gbN == hashCode) {
                    this.field_contactLabels = cursor.getString(i2);
                } else if (gbO == hashCode) {
                    this.field_conDescription = cursor.getString(i2);
                } else if (gbP == hashCode) {
                    this.field_conPhone = cursor.getString(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.field_encryptUsername == null) {
            this.field_encryptUsername = "";
        }
        if (this.fua) {
            contentValues.put("encryptUsername", this.field_encryptUsername);
        }
        if (this.field_conRemark == null) {
            this.field_conRemark = "";
        }
        if (this.ftQ) {
            contentValues.put("conRemark", this.field_conRemark);
        }
        if (this.field_contactLabels == null) {
            this.field_contactLabels = "";
        }
        if (this.gbK) {
            contentValues.put("contactLabels", this.field_contactLabels);
        }
        if (this.field_conDescription == null) {
            this.field_conDescription = "";
        }
        if (this.gbL) {
            contentValues.put("conDescription", this.field_conDescription);
        }
        if (this.field_conPhone == null) {
            this.field_conPhone = "";
        }
        if (this.gbM) {
            contentValues.put("conPhone", this.field_conPhone);
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
