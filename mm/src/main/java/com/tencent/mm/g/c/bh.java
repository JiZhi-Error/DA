package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class bh extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fwq = "designerUin".hashCode();
    private static final int fwr = "productId".hashCode();
    private static final int fws = "syncTime".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    public int field_designerUin;
    public String field_productId;
    public int field_syncTime;
    private boolean fwn = true;
    private boolean fwo = true;
    private boolean fwp = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fwq == hashCode) {
                    this.field_designerUin = cursor.getInt(i2);
                } else if (fwr == hashCode) {
                    this.field_productId = cursor.getString(i2);
                } else if (fws == hashCode) {
                    this.field_syncTime = cursor.getInt(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.fwn) {
            contentValues.put("designerUin", Integer.valueOf(this.field_designerUin));
        }
        if (this.fwo) {
            contentValues.put("productId", this.field_productId);
        }
        if (this.fwp) {
            contentValues.put("syncTime", Integer.valueOf(this.field_syncTime));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
