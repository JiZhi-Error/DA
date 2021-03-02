package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class eh extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fPL = "loan_jump_url".hashCode();
    private static final int fPM = "red_dot_index".hashCode();
    private static final int fPN = "is_show_entry".hashCode();
    private static final int fPO = "tips".hashCode();
    private static final int fPP = "is_overdue".hashCode();
    private static final int fPQ = "available_otb".hashCode();
    private static final int fne = "title".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private boolean fPF = true;
    private boolean fPG = true;
    private boolean fPH = true;
    private boolean fPI = true;
    private boolean fPJ = true;
    private boolean fPK = true;
    public String field_available_otb;
    public int field_is_overdue;
    public int field_is_show_entry;
    public String field_loan_jump_url;
    public int field_red_dot_index;
    public String field_tips;
    public String field_title;
    private boolean fnb = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fne == hashCode) {
                    this.field_title = cursor.getString(i2);
                    this.fnb = true;
                } else if (fPL == hashCode) {
                    this.field_loan_jump_url = cursor.getString(i2);
                } else if (fPM == hashCode) {
                    this.field_red_dot_index = cursor.getInt(i2);
                } else if (fPN == hashCode) {
                    this.field_is_show_entry = cursor.getInt(i2);
                } else if (fPO == hashCode) {
                    this.field_tips = cursor.getString(i2);
                } else if (fPP == hashCode) {
                    this.field_is_overdue = cursor.getInt(i2);
                } else if (fPQ == hashCode) {
                    this.field_available_otb = cursor.getString(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.fnb) {
            contentValues.put("title", this.field_title);
        }
        if (this.fPF) {
            contentValues.put("loan_jump_url", this.field_loan_jump_url);
        }
        if (this.fPG) {
            contentValues.put("red_dot_index", Integer.valueOf(this.field_red_dot_index));
        }
        if (this.fPH) {
            contentValues.put("is_show_entry", Integer.valueOf(this.field_is_show_entry));
        }
        if (this.fPI) {
            contentValues.put("tips", this.field_tips);
        }
        if (this.fPJ) {
            contentValues.put("is_overdue", Integer.valueOf(this.field_is_overdue));
        }
        if (this.fPK) {
            contentValues.put("available_otb", this.field_available_otb);
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
