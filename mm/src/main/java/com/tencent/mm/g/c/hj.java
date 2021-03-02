package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class hj extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int frB = "logo_url".hashCode();
    private static final int frH = "jump_type".hashCode();
    private static final int gfL = "pref_key".hashCode();
    private static final int gfM = "pref_title".hashCode();
    private static final int gfN = "pref_url".hashCode();
    private static final int gfO = "is_show".hashCode();
    private static final int gfP = "pref_desc".hashCode();
    private static final int gfQ = "tinyapp_username".hashCode();
    private static final int gfR = "tinyapp_path".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    public int field_is_show;
    public int field_jump_type;
    public String field_logo_url;
    public String field_pref_desc;
    public String field_pref_key;
    public String field_pref_title;
    public String field_pref_url;
    public String field_tinyapp_path;
    public String field_tinyapp_username;
    private boolean fri = true;
    private boolean fro = true;
    private boolean gfE = true;
    private boolean gfF = true;
    private boolean gfG = true;
    private boolean gfH = true;
    private boolean gfI = true;
    private boolean gfJ = true;
    private boolean gfK = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (gfL == hashCode) {
                    this.field_pref_key = cursor.getString(i2);
                    this.gfE = true;
                } else if (gfM == hashCode) {
                    this.field_pref_title = cursor.getString(i2);
                } else if (gfN == hashCode) {
                    this.field_pref_url = cursor.getString(i2);
                } else if (gfO == hashCode) {
                    this.field_is_show = cursor.getInt(i2);
                } else if (gfP == hashCode) {
                    this.field_pref_desc = cursor.getString(i2);
                } else if (frB == hashCode) {
                    this.field_logo_url = cursor.getString(i2);
                } else if (frH == hashCode) {
                    this.field_jump_type = cursor.getInt(i2);
                } else if (gfQ == hashCode) {
                    this.field_tinyapp_username = cursor.getString(i2);
                } else if (gfR == hashCode) {
                    this.field_tinyapp_path = cursor.getString(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.gfE) {
            contentValues.put("pref_key", this.field_pref_key);
        }
        if (this.gfF) {
            contentValues.put("pref_title", this.field_pref_title);
        }
        if (this.gfG) {
            contentValues.put("pref_url", this.field_pref_url);
        }
        if (this.gfH) {
            contentValues.put("is_show", Integer.valueOf(this.field_is_show));
        }
        if (this.gfI) {
            contentValues.put("pref_desc", this.field_pref_desc);
        }
        if (this.fri) {
            contentValues.put("logo_url", this.field_logo_url);
        }
        if (this.fro) {
            contentValues.put("jump_type", Integer.valueOf(this.field_jump_type));
        }
        if (this.gfJ) {
            contentValues.put("tinyapp_username", this.field_tinyapp_username);
        }
        if (this.gfK) {
            contentValues.put("tinyapp_path", this.field_tinyapp_path);
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
