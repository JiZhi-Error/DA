package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class ar extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int frD = "card_id".hashCode();
    private static final int frZ = "lower_bound".hashCode();
    private static final int fsa = "need_insert_show_timestamp".hashCode();
    private static final int fsb = "show_timestamp_encrypt_key".hashCode();
    private static final int fsc = "expire_time_interval".hashCode();
    private static final int fsd = "show_expire_interval".hashCode();
    private static final int fse = "fetch_time".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    public String field_card_id;
    public int field_expire_time_interval;
    public long field_fetch_time;
    public int field_lower_bound;
    public boolean field_need_insert_show_timestamp;
    public int field_show_expire_interval;
    public String field_show_timestamp_encrypt_key;
    private boolean frT = true;
    private boolean frU = true;
    private boolean frV = true;
    private boolean frW = true;
    private boolean frX = true;
    private boolean frY = true;
    private boolean frk = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (frD == hashCode) {
                    this.field_card_id = cursor.getString(i2);
                    this.frk = true;
                } else if (frZ == hashCode) {
                    this.field_lower_bound = cursor.getInt(i2);
                } else if (fsa == hashCode) {
                    this.field_need_insert_show_timestamp = cursor.getInt(i2) != 0;
                } else if (fsb == hashCode) {
                    this.field_show_timestamp_encrypt_key = cursor.getString(i2);
                } else if (fsc == hashCode) {
                    this.field_expire_time_interval = cursor.getInt(i2);
                } else if (fsd == hashCode) {
                    this.field_show_expire_interval = cursor.getInt(i2);
                } else if (fse == hashCode) {
                    this.field_fetch_time = cursor.getLong(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.frk) {
            contentValues.put("card_id", this.field_card_id);
        }
        if (this.frT) {
            contentValues.put("lower_bound", Integer.valueOf(this.field_lower_bound));
        }
        if (this.frU) {
            contentValues.put("need_insert_show_timestamp", Boolean.valueOf(this.field_need_insert_show_timestamp));
        }
        if (this.frV) {
            contentValues.put("show_timestamp_encrypt_key", this.field_show_timestamp_encrypt_key);
        }
        if (this.frW) {
            contentValues.put("expire_time_interval", Integer.valueOf(this.field_expire_time_interval));
        }
        if (this.frX) {
            contentValues.put("show_expire_interval", Integer.valueOf(this.field_show_expire_interval));
        }
        if (this.frY) {
            contentValues.put("fetch_time", Long.valueOf(this.field_fetch_time));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
