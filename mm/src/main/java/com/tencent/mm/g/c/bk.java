package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class bk extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fxp = "lang".hashCode();
    private static final int fyV = "md5_lang".hashCode();
    private static final int fyW = "desc".hashCode();
    private static final int fyX = "click_flag".hashCode();
    private static final int fyY = "download_flag".hashCode();
    private static final int fyf = "md5".hashCode();
    private static final int fyq = "groupId".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    public int field_click_flag;
    public String field_desc;
    public int field_download_flag;
    public String field_groupId;
    public String field_lang;
    public String field_md5;
    public String field_md5_lang;
    private boolean fwP = true;
    private boolean fxE = true;
    private boolean fxt = true;
    private boolean fyR = true;
    private boolean fyS = true;
    private boolean fyT = true;
    private boolean fyU = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fyV == hashCode) {
                    this.field_md5_lang = cursor.getString(i2);
                    this.fyR = true;
                } else if (fyf == hashCode) {
                    this.field_md5 = cursor.getString(i2);
                } else if (fxp == hashCode) {
                    this.field_lang = cursor.getString(i2);
                } else if (fyW == hashCode) {
                    this.field_desc = cursor.getString(i2);
                } else if (fyq == hashCode) {
                    this.field_groupId = cursor.getString(i2);
                } else if (fyX == hashCode) {
                    this.field_click_flag = cursor.getInt(i2);
                } else if (fyY == hashCode) {
                    this.field_download_flag = cursor.getInt(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.fyR) {
            contentValues.put("md5_lang", this.field_md5_lang);
        }
        if (this.fxt) {
            contentValues.put("md5", this.field_md5);
        }
        if (this.fwP) {
            contentValues.put("lang", this.field_lang);
        }
        if (this.fyS) {
            contentValues.put("desc", this.field_desc);
        }
        if (this.field_groupId == null) {
            this.field_groupId = "";
        }
        if (this.fxE) {
            contentValues.put("groupId", this.field_groupId);
        }
        if (this.fyT) {
            contentValues.put("click_flag", Integer.valueOf(this.field_click_flag));
        }
        if (this.fyU) {
            contentValues.put("download_flag", Integer.valueOf(this.field_download_flag));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
