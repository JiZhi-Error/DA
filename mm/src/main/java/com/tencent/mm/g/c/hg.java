package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class hg extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int geY = "wallet_region".hashCode();
    private static final int geZ = "function_list".hashCode();
    private static final int gfa = "new_list".hashCode();
    private static final int gfb = "banner_list".hashCode();
    private static final int gfc = "type_name_list".hashCode();
    private static final int gfd = "isShowSetting".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    public String field_banner_list;
    public String field_function_list;
    public int field_isShowSetting;
    public String field_new_list;
    public String field_type_name_list;
    public int field_wallet_region;
    private boolean geS = true;
    private boolean geT = true;
    private boolean geU = true;
    private boolean geV = true;
    private boolean geW = true;
    private boolean geX = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (geY == hashCode) {
                    this.field_wallet_region = cursor.getInt(i2);
                    this.geS = true;
                } else if (geZ == hashCode) {
                    this.field_function_list = cursor.getString(i2);
                } else if (gfa == hashCode) {
                    this.field_new_list = cursor.getString(i2);
                } else if (gfb == hashCode) {
                    this.field_banner_list = cursor.getString(i2);
                } else if (gfc == hashCode) {
                    this.field_type_name_list = cursor.getString(i2);
                } else if (gfd == hashCode) {
                    this.field_isShowSetting = cursor.getInt(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.geS) {
            contentValues.put("wallet_region", Integer.valueOf(this.field_wallet_region));
        }
        if (this.geT) {
            contentValues.put("function_list", this.field_function_list);
        }
        if (this.geU) {
            contentValues.put("new_list", this.field_new_list);
        }
        if (this.geV) {
            contentValues.put("banner_list", this.field_banner_list);
        }
        if (this.geW) {
            contentValues.put("type_name_list", this.field_type_name_list);
        }
        if (this.geX) {
            contentValues.put("isShowSetting", Integer.valueOf(this.field_isShowSetting));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
