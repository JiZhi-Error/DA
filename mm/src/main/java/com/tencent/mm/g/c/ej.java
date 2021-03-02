package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class ej extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fQf = "packet_id".hashCode();
    private static final int fQm = MessengerShareContentUtility.MEDIA_TYPE.hashCode();
    private static final int fQn = "media_url".hashCode();
    private static final int fQo = "media_md5".hashCode();
    private static final int fQp = "media_fuzzy_thumbnail_url".hashCode();
    private static final int fQq = "media_fuzzy_thumbnail_md5".hashCode();
    private static final int fyA = "height".hashCode();
    private static final int fyz = "width".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private boolean fPX = true;
    private boolean fQh = true;
    private boolean fQi = true;
    private boolean fQj = true;
    private boolean fQk = true;
    private boolean fQl = true;
    public int field_height;
    public String field_media_fuzzy_thumbnail_md5;
    public String field_media_fuzzy_thumbnail_url;
    public String field_media_md5;
    public int field_media_type;
    public String field_media_url;
    public String field_packet_id;
    public int field_width;
    private boolean fxN = true;
    private boolean fxO = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fQm == hashCode) {
                    this.field_media_type = cursor.getInt(i2);
                } else if (fQn == hashCode) {
                    this.field_media_url = cursor.getString(i2);
                } else if (fQo == hashCode) {
                    this.field_media_md5 = cursor.getString(i2);
                } else if (fyA == hashCode) {
                    this.field_height = cursor.getInt(i2);
                } else if (fyz == hashCode) {
                    this.field_width = cursor.getInt(i2);
                } else if (fQf == hashCode) {
                    this.field_packet_id = cursor.getString(i2);
                } else if (fQp == hashCode) {
                    this.field_media_fuzzy_thumbnail_url = cursor.getString(i2);
                } else if (fQq == hashCode) {
                    this.field_media_fuzzy_thumbnail_md5 = cursor.getString(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.fQh) {
            contentValues.put(MessengerShareContentUtility.MEDIA_TYPE, Integer.valueOf(this.field_media_type));
        }
        if (this.fQi) {
            contentValues.put("media_url", this.field_media_url);
        }
        if (this.fQj) {
            contentValues.put("media_md5", this.field_media_md5);
        }
        if (this.fxO) {
            contentValues.put("height", Integer.valueOf(this.field_height));
        }
        if (this.fxN) {
            contentValues.put("width", Integer.valueOf(this.field_width));
        }
        if (this.fPX) {
            contentValues.put("packet_id", this.field_packet_id);
        }
        if (this.fQk) {
            contentValues.put("media_fuzzy_thumbnail_url", this.field_media_fuzzy_thumbnail_url);
        }
        if (this.fQl) {
            contentValues.put("media_fuzzy_thumbnail_md5", this.field_media_fuzzy_thumbnail_md5);
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
