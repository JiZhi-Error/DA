package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class dq extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fMp = "appusername".hashCode();
    private static final int fMs = FirebaseAnalytics.b.SCORE.hashCode();
    private static final int fne = "title".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private boolean fMm;
    private boolean fMr;
    public String field_appusername;
    public int field_score;
    public String field_title;
    private boolean fnb;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fMp == hashCode) {
                    this.field_appusername = cursor.getString(i2);
                } else if (fne == hashCode) {
                    this.field_title = cursor.getString(i2);
                } else if (fMs == hashCode) {
                    this.field_score = cursor.getInt(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.fMm) {
            contentValues.put("appusername", this.field_appusername);
        }
        if (this.fnb) {
            contentValues.put("title", this.field_title);
        }
        if (this.fMr) {
            contentValues.put(FirebaseAnalytics.b.SCORE, Integer.valueOf(this.field_score));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
