package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class hk extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int geY = "wallet_region".hashCode();
    private static final int gfT = "wallet_grey_item_buf".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    public byte[] field_wallet_grey_item_buf;
    public int field_wallet_region;
    private boolean geS = true;
    private boolean gfS = true;

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
                } else if (gfT == hashCode) {
                    this.field_wallet_grey_item_buf = cursor.getBlob(i2);
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
        if (this.gfS) {
            contentValues.put("wallet_grey_item_buf", this.field_wallet_grey_item_buf);
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
