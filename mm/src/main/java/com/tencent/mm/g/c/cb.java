package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.google.android.gms.measurement.AppMeasurement;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class cb extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fBA = "titlePY".hashCode();
    private static final int fBB = "titleShortPY".hashCode();
    private static final int fBC = "tag".hashCode();
    private static final int fBD = "actionType".hashCode();
    private static final int fBE = "helpUrl".hashCode();
    private static final int fBF = "updateUrl".hashCode();
    private static final int fBG = "androidUrl".hashCode();
    private static final int fBH = "iconPath".hashCode();
    private static final int fBI = AppMeasurement.Param.TIMESTAMP.hashCode();
    private static final int fBz = "featureId".hashCode();
    private static final int fnB = "url".hashCode();
    private static final int fne = "title".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private boolean fBp = true;
    private boolean fBq = true;
    private boolean fBr = true;
    private boolean fBs = true;
    private boolean fBt = true;
    private boolean fBu = true;
    private boolean fBv = true;
    private boolean fBw = true;
    private boolean fBx = true;
    private boolean fBy = true;
    public int field_actionType;
    public String field_androidUrl;
    public int field_featureId;
    public String field_helpUrl;
    public String field_iconPath;
    public String field_tag;
    public long field_timestamp;
    public String field_title;
    public String field_titlePY;
    public String field_titleShortPY;
    public String field_updateUrl;
    public String field_url;
    private boolean fnb = true;
    private boolean fnx = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fBz == hashCode) {
                    this.field_featureId = cursor.getInt(i2);
                    this.fBp = true;
                } else if (fne == hashCode) {
                    this.field_title = cursor.getString(i2);
                } else if (fBA == hashCode) {
                    this.field_titlePY = cursor.getString(i2);
                } else if (fBB == hashCode) {
                    this.field_titleShortPY = cursor.getString(i2);
                } else if (fBC == hashCode) {
                    this.field_tag = cursor.getString(i2);
                } else if (fBD == hashCode) {
                    this.field_actionType = cursor.getInt(i2);
                } else if (fnB == hashCode) {
                    this.field_url = cursor.getString(i2);
                } else if (fBE == hashCode) {
                    this.field_helpUrl = cursor.getString(i2);
                } else if (fBF == hashCode) {
                    this.field_updateUrl = cursor.getString(i2);
                } else if (fBG == hashCode) {
                    this.field_androidUrl = cursor.getString(i2);
                } else if (fBH == hashCode) {
                    this.field_iconPath = cursor.getString(i2);
                } else if (fBI == hashCode) {
                    this.field_timestamp = cursor.getLong(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.fBp) {
            contentValues.put("featureId", Integer.valueOf(this.field_featureId));
        }
        if (this.fnb) {
            contentValues.put("title", this.field_title);
        }
        if (this.fBq) {
            contentValues.put("titlePY", this.field_titlePY);
        }
        if (this.fBr) {
            contentValues.put("titleShortPY", this.field_titleShortPY);
        }
        if (this.fBs) {
            contentValues.put("tag", this.field_tag);
        }
        if (this.fBt) {
            contentValues.put("actionType", Integer.valueOf(this.field_actionType));
        }
        if (this.fnx) {
            contentValues.put("url", this.field_url);
        }
        if (this.fBu) {
            contentValues.put("helpUrl", this.field_helpUrl);
        }
        if (this.fBv) {
            contentValues.put("updateUrl", this.field_updateUrl);
        }
        if (this.fBw) {
            contentValues.put("androidUrl", this.field_androidUrl);
        }
        if (this.fBx) {
            contentValues.put("iconPath", this.field_iconPath);
        }
        if (this.fBy) {
            contentValues.put(AppMeasurement.Param.TIMESTAMP, Long.valueOf(this.field_timestamp));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
