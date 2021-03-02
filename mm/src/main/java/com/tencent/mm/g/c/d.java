package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class d extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fjE = "layerId".hashCode();
    private static final int fjF = "business".hashCode();
    private static final int fjG = "needReport".hashCode();
    private static final int fjH = "rawXML".hashCode();
    private static final int fju = "expId".hashCode();
    private static final int fjv = "sequence".hashCode();
    private static final int fjw = "prioritylevel".hashCode();
    private static final int fjx = "startTime".hashCode();
    private static final int fjy = "endTime".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    public String field_business;
    public long field_endTime;
    public String field_expId;
    public String field_layerId;
    public boolean field_needReport;
    public int field_prioritylevel;
    public String field_rawXML;
    public long field_sequence;
    public long field_startTime;
    private boolean fjA = true;
    private boolean fjB = true;
    private boolean fjC = true;
    private boolean fjD = true;
    private boolean fjn = true;
    private boolean fjo = true;
    private boolean fjp = true;
    private boolean fjq = true;
    private boolean fjr = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fjE == hashCode) {
                    this.field_layerId = cursor.getString(i2);
                    this.fjA = true;
                } else if (fjF == hashCode) {
                    this.field_business = cursor.getString(i2);
                } else if (fju == hashCode) {
                    this.field_expId = cursor.getString(i2);
                } else if (fjv == hashCode) {
                    this.field_sequence = cursor.getLong(i2);
                } else if (fjw == hashCode) {
                    this.field_prioritylevel = cursor.getInt(i2);
                } else if (fjx == hashCode) {
                    this.field_startTime = cursor.getLong(i2);
                } else if (fjy == hashCode) {
                    this.field_endTime = cursor.getLong(i2);
                } else if (fjG == hashCode) {
                    this.field_needReport = cursor.getInt(i2) != 0;
                } else if (fjH == hashCode) {
                    this.field_rawXML = cursor.getString(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.fjA) {
            contentValues.put("layerId", this.field_layerId);
        }
        if (this.fjB) {
            contentValues.put("business", this.field_business);
        }
        if (this.fjn) {
            contentValues.put("expId", this.field_expId);
        }
        if (this.fjo) {
            contentValues.put("sequence", Long.valueOf(this.field_sequence));
        }
        if (this.fjp) {
            contentValues.put("prioritylevel", Integer.valueOf(this.field_prioritylevel));
        }
        if (this.fjq) {
            contentValues.put("startTime", Long.valueOf(this.field_startTime));
        }
        if (this.fjr) {
            contentValues.put("endTime", Long.valueOf(this.field_endTime));
        }
        if (this.fjC) {
            contentValues.put("needReport", Boolean.valueOf(this.field_needReport));
        }
        if (this.field_rawXML == null) {
            this.field_rawXML = "";
        }
        if (this.fjD) {
            contentValues.put("rawXML", this.field_rawXML);
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
