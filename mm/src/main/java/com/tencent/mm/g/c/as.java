package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;

public abstract class as extends IAutoDBItem {
    public static final String[] INDEX_CREATE = {"CREATE INDEX IF NOT EXISTS CardQrCodeDataInfo_card_id_index ON CardQrCodeDataInfo(card_id)"};
    private static final int fjl = "status".hashCode();
    private static final int frD = "card_id".hashCode();
    private static final int fsh = "code_id".hashCode();
    private static final int fsi = TMQQDownloaderOpenSDKConst.UINTYPE_CODE.hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    public String field_card_id;
    public String field_code;
    public String field_code_id;
    public int field_status;
    private boolean fji = true;
    private boolean frk = true;
    private boolean fsf = true;
    private boolean fsg = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fsh == hashCode) {
                    this.field_code_id = cursor.getString(i2);
                } else if (frD == hashCode) {
                    this.field_card_id = cursor.getString(i2);
                } else if (fsi == hashCode) {
                    this.field_code = cursor.getString(i2);
                } else if (fjl == hashCode) {
                    this.field_status = cursor.getInt(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.fsf) {
            contentValues.put("code_id", this.field_code_id);
        }
        if (this.frk) {
            contentValues.put("card_id", this.field_card_id);
        }
        if (this.fsg) {
            contentValues.put(TMQQDownloaderOpenSDKConst.UINTYPE_CODE, this.field_code);
        }
        if (this.fji) {
            contentValues.put("status", Integer.valueOf(this.field_status));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
