package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class af extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fnA = "appMsgReportContextId".hashCode();
    private static final int fnB = "url".hashCode();
    private static final int fnC = "reportTime".hashCode();
    private static final int fnD = "aScene".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    public int field_aScene;
    public long field_appMsgReportContextId;
    public long field_reportTime;
    public String field_url;
    private boolean fnw = true;
    private boolean fnx = true;
    private boolean fny = true;
    private boolean fnz = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fnA == hashCode) {
                    this.field_appMsgReportContextId = cursor.getLong(i2);
                    this.fnw = true;
                } else if (fnB == hashCode) {
                    this.field_url = cursor.getString(i2);
                } else if (fnC == hashCode) {
                    this.field_reportTime = cursor.getLong(i2);
                } else if (fnD == hashCode) {
                    this.field_aScene = cursor.getInt(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.fnw) {
            contentValues.put("appMsgReportContextId", Long.valueOf(this.field_appMsgReportContextId));
        }
        if (this.fnx) {
            contentValues.put("url", this.field_url);
        }
        if (this.fny) {
            contentValues.put("reportTime", Long.valueOf(this.field_reportTime));
        }
        if (this.fnz) {
            contentValues.put("aScene", Integer.valueOf(this.field_aScene));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
