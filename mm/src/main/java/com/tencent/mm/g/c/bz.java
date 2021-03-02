package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class bz extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fBg = "imgDirPath".hashCode();
    private static final int fBh = "imgPaths".hashCode();
    private static final int fBi = "favTime".hashCode();
    private static final int fBj = "failNum".hashCode();
    private static final int fBk = "isReport".hashCode();
    private static final int fjl = "status".hashCode();
    private static final int fkH = "path".hashCode();
    private static final int fkX = "size".hashCode();
    private static final int fnB = "url".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private static final int updateTime_HASHCODE = ch.COL_UPDATETIME.hashCode();
    private boolean __hadSetupdateTime = true;
    private boolean fBb = true;
    private boolean fBc = true;
    private boolean fBd = true;
    private boolean fBe = true;
    private boolean fBf = true;
    public int field_failNum;
    public long field_favTime;
    public String field_imgDirPath;
    public String field_imgPaths;
    public int field_isReport;
    public String field_path;
    public long field_size;
    public int field_status;
    public long field_updateTime;
    public String field_url;
    private boolean fji = true;
    private boolean fkD = true;
    private boolean fkV = true;
    private boolean fnx = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fnB == hashCode) {
                    this.field_url = cursor.getString(i2);
                } else if (fkX == hashCode) {
                    this.field_size = cursor.getLong(i2);
                } else if (fkH == hashCode) {
                    this.field_path = cursor.getString(i2);
                } else if (fBg == hashCode) {
                    this.field_imgDirPath = cursor.getString(i2);
                } else if (fBh == hashCode) {
                    this.field_imgPaths = cursor.getString(i2);
                } else if (fBi == hashCode) {
                    this.field_favTime = cursor.getLong(i2);
                } else if (updateTime_HASHCODE == hashCode) {
                    this.field_updateTime = cursor.getLong(i2);
                } else if (fjl == hashCode) {
                    this.field_status = cursor.getInt(i2);
                } else if (fBj == hashCode) {
                    this.field_failNum = cursor.getInt(i2);
                } else if (fBk == hashCode) {
                    this.field_isReport = cursor.getInt(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.fnx) {
            contentValues.put("url", this.field_url);
        }
        if (this.fkV) {
            contentValues.put("size", Long.valueOf(this.field_size));
        }
        if (this.fkD) {
            contentValues.put("path", this.field_path);
        }
        if (this.fBb) {
            contentValues.put("imgDirPath", this.field_imgDirPath);
        }
        if (this.fBc) {
            contentValues.put("imgPaths", this.field_imgPaths);
        }
        if (this.fBd) {
            contentValues.put("favTime", Long.valueOf(this.field_favTime));
        }
        if (this.__hadSetupdateTime) {
            contentValues.put(ch.COL_UPDATETIME, Long.valueOf(this.field_updateTime));
        }
        if (this.fji) {
            contentValues.put("status", Integer.valueOf(this.field_status));
        }
        if (this.fBe) {
            contentValues.put("failNum", Integer.valueOf(this.field_failNum));
        }
        if (this.fBf) {
            contentValues.put("isReport", Integer.valueOf(this.field_isReport));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
