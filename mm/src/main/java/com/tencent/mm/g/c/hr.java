package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class hr extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int ghG = "appDs".hashCode();
    private static final int ghH = "appHour".hashCode();
    private static final int ghI = "appTbe".hashCode();
    private static final int ghJ = "appTen".hashCode();
    private static final int ghK = "appIn".hashCode();
    private static final int ghL = "appInbg".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    public int field_appDs;
    public int field_appHour;
    public long field_appIn;
    public long field_appInbg;
    public long field_appTbe;
    public long field_appTen;
    private boolean ghA = true;
    private boolean ghB = true;
    private boolean ghC = true;
    private boolean ghD = true;
    private boolean ghE = true;
    private boolean ghF = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (ghG == hashCode) {
                    this.field_appDs = cursor.getInt(i2);
                } else if (ghH == hashCode) {
                    this.field_appHour = cursor.getInt(i2);
                } else if (ghI == hashCode) {
                    this.field_appTbe = cursor.getLong(i2);
                } else if (ghJ == hashCode) {
                    this.field_appTen = cursor.getLong(i2);
                } else if (ghK == hashCode) {
                    this.field_appIn = cursor.getLong(i2);
                } else if (ghL == hashCode) {
                    this.field_appInbg = cursor.getLong(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.ghA) {
            contentValues.put("appDs", Integer.valueOf(this.field_appDs));
        }
        if (this.ghB) {
            contentValues.put("appHour", Integer.valueOf(this.field_appHour));
        }
        if (this.ghC) {
            contentValues.put("appTbe", Long.valueOf(this.field_appTbe));
        }
        if (this.ghD) {
            contentValues.put("appTen", Long.valueOf(this.field_appTen));
        }
        if (this.ghE) {
            contentValues.put("appIn", Long.valueOf(this.field_appIn));
        }
        if (this.ghF) {
            contentValues.put("appInbg", Long.valueOf(this.field_appInbg));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
