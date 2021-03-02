package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class bq extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fmm = "modifyTime".hashCode();
    private static final int fni = "flag".hashCode();
    private static final int fzk = "prodcutID".hashCode();
    private static final int fzl = "totalCount".hashCode();
    private static final int fzm = "continuCount".hashCode();
    private static final int fzn = "showTipsTime".hashCode();
    private static final int fzo = "setFlagTime".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    public int field_continuCount;
    public int field_flag;
    public long field_modifyTime;
    public String field_prodcutID;
    public long field_setFlagTime;
    public long field_showTipsTime;
    public int field_totalCount;
    private boolean flQ = true;
    private boolean fng = true;
    private boolean fzf = true;
    private boolean fzg = true;
    private boolean fzh = true;
    private boolean fzi = true;
    private boolean fzj = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fzk == hashCode) {
                    this.field_prodcutID = cursor.getString(i2);
                    this.fzf = true;
                } else if (fzl == hashCode) {
                    this.field_totalCount = cursor.getInt(i2);
                } else if (fzm == hashCode) {
                    this.field_continuCount = cursor.getInt(i2);
                } else if (fni == hashCode) {
                    this.field_flag = cursor.getInt(i2);
                } else if (fmm == hashCode) {
                    this.field_modifyTime = cursor.getLong(i2);
                } else if (fzn == hashCode) {
                    this.field_showTipsTime = cursor.getLong(i2);
                } else if (fzo == hashCode) {
                    this.field_setFlagTime = cursor.getLong(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.fzf) {
            contentValues.put("prodcutID", this.field_prodcutID);
        }
        if (this.fzg) {
            contentValues.put("totalCount", Integer.valueOf(this.field_totalCount));
        }
        if (this.fzh) {
            contentValues.put("continuCount", Integer.valueOf(this.field_continuCount));
        }
        if (this.fng) {
            contentValues.put("flag", Integer.valueOf(this.field_flag));
        }
        if (this.flQ) {
            contentValues.put("modifyTime", Long.valueOf(this.field_modifyTime));
        }
        if (this.fzi) {
            contentValues.put("showTipsTime", Long.valueOf(this.field_showTipsTime));
        }
        if (this.fzj) {
            contentValues.put("setFlagTime", Long.valueOf(this.field_setFlagTime));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
