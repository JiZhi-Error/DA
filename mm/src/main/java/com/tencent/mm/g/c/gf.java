package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;

public abstract class gf extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fCq = DownloadInfo.FILENAME.hashCode();
    private static final int fZg = "cnValue".hashCode();
    private static final int fZh = "qqValue".hashCode();
    private static final int fZi = "twValue".hashCode();
    private static final int fZj = "enValue".hashCode();
    private static final int fZk = "thValue".hashCode();
    private static final int fZl = "eggIndex".hashCode();
    private static final int fZm = "position".hashCode();
    private static final int fni = "flag".hashCode();
    private static final int key_HASHCODE = "key".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private boolean __hadSetkey = true;
    private boolean fBM = true;
    private boolean fYZ = true;
    private boolean fZa = true;
    private boolean fZb = true;
    private boolean fZc = true;
    private boolean fZd = true;
    private boolean fZe = true;
    private boolean fZf = true;
    public String field_cnValue;
    public int field_eggIndex;
    public String field_enValue;
    public String field_fileName;
    public int field_flag;
    public String field_key;
    public int field_position;
    public String field_qqValue;
    public String field_thValue;
    public String field_twValue;
    private boolean fng = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (key_HASHCODE == hashCode) {
                    this.field_key = cursor.getString(i2);
                    this.__hadSetkey = true;
                } else if (fZg == hashCode) {
                    this.field_cnValue = cursor.getString(i2);
                } else if (fZh == hashCode) {
                    this.field_qqValue = cursor.getString(i2);
                } else if (fZi == hashCode) {
                    this.field_twValue = cursor.getString(i2);
                } else if (fZj == hashCode) {
                    this.field_enValue = cursor.getString(i2);
                } else if (fZk == hashCode) {
                    this.field_thValue = cursor.getString(i2);
                } else if (fCq == hashCode) {
                    this.field_fileName = cursor.getString(i2);
                } else if (fZl == hashCode) {
                    this.field_eggIndex = cursor.getInt(i2);
                } else if (fZm == hashCode) {
                    this.field_position = cursor.getInt(i2);
                } else if (fni == hashCode) {
                    this.field_flag = cursor.getInt(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.__hadSetkey) {
            contentValues.put("key", this.field_key);
        }
        if (this.fYZ) {
            contentValues.put("cnValue", this.field_cnValue);
        }
        if (this.fZa) {
            contentValues.put("qqValue", this.field_qqValue);
        }
        if (this.fZb) {
            contentValues.put("twValue", this.field_twValue);
        }
        if (this.fZc) {
            contentValues.put("enValue", this.field_enValue);
        }
        if (this.fZd) {
            contentValues.put("thValue", this.field_thValue);
        }
        if (this.fBM) {
            contentValues.put(DownloadInfo.FILENAME, this.field_fileName);
        }
        if (this.fZe) {
            contentValues.put("eggIndex", Integer.valueOf(this.field_eggIndex));
        }
        if (this.fZf) {
            contentValues.put("position", Integer.valueOf(this.field_position));
        }
        if (this.fng) {
            contentValues.put("flag", Integer.valueOf(this.field_flag));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
