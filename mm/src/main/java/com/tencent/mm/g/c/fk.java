package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class fk extends IAutoDBItem {
    public static final String[] INDEX_CREATE = {"CREATE INDEX IF NOT EXISTS PredownloadBlockCgiRequestAppIDIndex ON PredownloadBlockCgiRequest(appId)", "CREATE INDEX IF NOT EXISTS PredownloadBlockCgiRequestStartTimeIndex ON PredownloadBlockCgiRequest(startTime)", "CREATE INDEX IF NOT EXISTS PredownloadBlockCgiRequestEndTimeIndex ON PredownloadBlockCgiRequest(endTime)"};
    private static final int fUR = "sceneList".hashCode();
    private static final int fUS = "cgiList".hashCode();
    private static final int fjx = "startTime".hashCode();
    private static final int fjy = "endTime".hashCode();
    private static final int fkj = "appId".hashCode();
    private static final int flJ = "reportId".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private static final int username_HASHCODE = ch.COL_USERNAME.hashCode();
    private boolean __hadSetusername = true;
    private boolean fUP = true;
    private boolean fUQ = true;
    public String field_appId;
    public String field_cgiList;
    public long field_endTime;
    public int field_reportId;
    public String field_sceneList;
    public long field_startTime;
    public String field_username;
    private boolean fjS = true;
    private boolean fjq = true;
    private boolean fjr = true;
    private boolean flE = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (username_HASHCODE == hashCode) {
                    this.field_username = cursor.getString(i2);
                    this.__hadSetusername = true;
                } else if (fkj == hashCode) {
                    this.field_appId = cursor.getString(i2);
                } else if (fjx == hashCode) {
                    this.field_startTime = cursor.getLong(i2);
                } else if (fjy == hashCode) {
                    this.field_endTime = cursor.getLong(i2);
                } else if (fUR == hashCode) {
                    this.field_sceneList = cursor.getString(i2);
                } else if (fUS == hashCode) {
                    this.field_cgiList = cursor.getString(i2);
                } else if (flJ == hashCode) {
                    this.field_reportId = cursor.getInt(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.__hadSetusername) {
            contentValues.put(ch.COL_USERNAME, this.field_username);
        }
        if (this.fjS) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.fjq) {
            contentValues.put("startTime", Long.valueOf(this.field_startTime));
        }
        if (this.fjr) {
            contentValues.put("endTime", Long.valueOf(this.field_endTime));
        }
        if (this.fUP) {
            contentValues.put("sceneList", this.field_sceneList);
        }
        if (this.fUQ) {
            contentValues.put("cgiList", this.field_cgiList);
        }
        if (this.flE) {
            contentValues.put("reportId", Integer.valueOf(this.field_reportId));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
