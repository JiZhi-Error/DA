package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class du extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fMH = "wechatUsername".hashCode();
    private static final int fMI = "systemAddressBookUsername".hashCode();
    private static final int fMJ = "contactId".hashCode();
    private static final int fMK = "sortKey".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private boolean fMD = true;
    private boolean fME = true;
    private boolean fMF = true;
    private boolean fMG = true;
    public String field_contactId;
    public String field_sortKey;
    public String field_systemAddressBookUsername;
    public String field_wechatUsername;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fMH == hashCode) {
                    this.field_wechatUsername = cursor.getString(i2);
                } else if (fMI == hashCode) {
                    this.field_systemAddressBookUsername = cursor.getString(i2);
                } else if (fMJ == hashCode) {
                    this.field_contactId = cursor.getString(i2);
                } else if (fMK == hashCode) {
                    this.field_sortKey = cursor.getString(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.fMD) {
            contentValues.put("wechatUsername", this.field_wechatUsername);
        }
        if (this.fME) {
            contentValues.put("systemAddressBookUsername", this.field_systemAddressBookUsername);
        }
        if (this.fMF) {
            contentValues.put("contactId", this.field_contactId);
        }
        if (this.fMG) {
            contentValues.put("sortKey", this.field_sortKey);
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
