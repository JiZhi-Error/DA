package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class hh extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int gfk = "wallet_tpa_country".hashCode();
    private static final int gfl = "wallet_type".hashCode();
    private static final int gfm = "wallet_name".hashCode();
    private static final int gfn = "wallet_selected".hashCode();
    private static final int gfo = "wallet_balance".hashCode();
    private static final int gfp = "wallet_tpa_country_mask".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    public int field_wallet_balance;
    public String field_wallet_name;
    public int field_wallet_selected;
    public String field_wallet_tpa_country;
    public int field_wallet_tpa_country_mask;
    public int field_wallet_type;
    private boolean gfe = true;
    private boolean gff = true;
    private boolean gfg = true;
    private boolean gfh = true;
    private boolean gfi = true;
    private boolean gfj = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (gfk == hashCode) {
                    this.field_wallet_tpa_country = cursor.getString(i2);
                    this.gfe = true;
                } else if (gfl == hashCode) {
                    this.field_wallet_type = cursor.getInt(i2);
                } else if (gfm == hashCode) {
                    this.field_wallet_name = cursor.getString(i2);
                } else if (gfn == hashCode) {
                    this.field_wallet_selected = cursor.getInt(i2);
                } else if (gfo == hashCode) {
                    this.field_wallet_balance = cursor.getInt(i2);
                } else if (gfp == hashCode) {
                    this.field_wallet_tpa_country_mask = cursor.getInt(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.gfe) {
            contentValues.put("wallet_tpa_country", this.field_wallet_tpa_country);
        }
        if (this.gff) {
            contentValues.put("wallet_type", Integer.valueOf(this.field_wallet_type));
        }
        if (this.gfg) {
            contentValues.put("wallet_name", this.field_wallet_name);
        }
        if (this.gfh) {
            contentValues.put("wallet_selected", Integer.valueOf(this.field_wallet_selected));
        }
        if (this.gfi) {
            contentValues.put("wallet_balance", Integer.valueOf(this.field_wallet_balance));
        }
        if (this.gfj) {
            contentValues.put("wallet_tpa_country_mask", Integer.valueOf(this.field_wallet_tpa_country_mask));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
