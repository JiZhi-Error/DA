package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class fj extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fUN = "hit".hashCode();
    private static final int fUO = "hitTimeMS".hashCode();
    private static final int fkj = "appId".hashCode();
    private static final int flv = "version".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private boolean fUL = true;
    private boolean fUM = true;
    public String field_appId;
    public int field_hit;
    public long field_hitTimeMS;
    public int field_version;
    private boolean fjS = true;
    private boolean flq = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fkj == hashCode) {
                    this.field_appId = cursor.getString(i2);
                } else if (flv == hashCode) {
                    this.field_version = cursor.getInt(i2);
                } else if (fUN == hashCode) {
                    this.field_hit = cursor.getInt(i2);
                } else if (fUO == hashCode) {
                    this.field_hitTimeMS = cursor.getLong(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.fjS) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.flq) {
            contentValues.put("version", Integer.valueOf(this.field_version));
        }
        if (this.fUL) {
            contentValues.put("hit", Integer.valueOf(this.field_hit));
        }
        if (this.fUM) {
            contentValues.put("hitTimeMS", Long.valueOf(this.field_hitTimeMS));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
