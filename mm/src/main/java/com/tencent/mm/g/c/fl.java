package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class fl extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fVc = "retryTimes".hashCode();
    private static final int fVd = "retriedCount".hashCode();
    private static final int fVe = "retryInterval".hashCode();
    private static final int fVf = "networkType".hashCode();
    private static final int fVg = "pkgMd5".hashCode();
    private static final int fVh = "lastRetryTime".hashCode();
    private static final int fVi = "firstTimeTried".hashCode();
    private static final int fVj = "splitDownloadURLCgi".hashCode();
    private static final int fVk = "cmdSequence".hashCode();
    private static final int fjQ = "scene".hashCode();
    private static final int fkj = "appId".hashCode();
    private static final int flF = "packageType".hashCode();
    private static final int flG = "packageKey".hashCode();
    private static final int flJ = "reportId".hashCode();
    private static final int flv = "version".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private static final int type_HASHCODE = "type".hashCode();
    private boolean __hadSettype = true;
    private boolean fUT = true;
    private boolean fUU = true;
    private boolean fUV = true;
    private boolean fUW = true;
    private boolean fUX = true;
    private boolean fUY = true;
    private boolean fUZ = true;
    private boolean fVa = true;
    private boolean fVb = true;
    public String field_appId;
    public long field_cmdSequence;
    public boolean field_firstTimeTried;
    public long field_lastRetryTime;
    public int field_networkType;
    public String field_packageKey;
    public int field_packageType;
    public String field_pkgMd5;
    public int field_reportId;
    public int field_retriedCount;
    public long field_retryInterval;
    public int field_retryTimes;
    public int field_scene;
    public boolean field_splitDownloadURLCgi;
    public int field_type;
    public int field_version;
    private boolean fjO = true;
    private boolean fjS = true;
    private boolean flA = true;
    private boolean flB = true;
    private boolean flE = true;
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
                } else if (type_HASHCODE == hashCode) {
                    this.field_type = cursor.getInt(i2);
                } else if (fVc == hashCode) {
                    this.field_retryTimes = cursor.getInt(i2);
                } else if (fVd == hashCode) {
                    this.field_retriedCount = cursor.getInt(i2);
                } else if (fVe == hashCode) {
                    this.field_retryInterval = cursor.getLong(i2);
                } else if (fVf == hashCode) {
                    this.field_networkType = cursor.getInt(i2);
                } else if (fVg == hashCode) {
                    this.field_pkgMd5 = cursor.getString(i2);
                } else if (flG == hashCode) {
                    this.field_packageKey = cursor.getString(i2);
                } else if (flF == hashCode) {
                    this.field_packageType = cursor.getInt(i2);
                } else if (fVh == hashCode) {
                    this.field_lastRetryTime = cursor.getLong(i2);
                } else if (fVi == hashCode) {
                    this.field_firstTimeTried = cursor.getInt(i2) != 0;
                } else if (flJ == hashCode) {
                    this.field_reportId = cursor.getInt(i2);
                } else if (fVj == hashCode) {
                    this.field_splitDownloadURLCgi = cursor.getInt(i2) != 0;
                } else if (fjQ == hashCode) {
                    this.field_scene = cursor.getInt(i2);
                } else if (fVk == hashCode) {
                    this.field_cmdSequence = cursor.getLong(i2);
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
        if (this.__hadSettype) {
            contentValues.put("type", Integer.valueOf(this.field_type));
        }
        if (this.fUT) {
            contentValues.put("retryTimes", Integer.valueOf(this.field_retryTimes));
        }
        if (this.fUU) {
            contentValues.put("retriedCount", Integer.valueOf(this.field_retriedCount));
        }
        if (this.fUV) {
            contentValues.put("retryInterval", Long.valueOf(this.field_retryInterval));
        }
        if (this.fUW) {
            contentValues.put("networkType", Integer.valueOf(this.field_networkType));
        }
        if (this.fUX) {
            contentValues.put("pkgMd5", this.field_pkgMd5);
        }
        if (this.flB) {
            contentValues.put("packageKey", this.field_packageKey);
        }
        if (this.flA) {
            contentValues.put("packageType", Integer.valueOf(this.field_packageType));
        }
        if (this.fUY) {
            contentValues.put("lastRetryTime", Long.valueOf(this.field_lastRetryTime));
        }
        if (this.fUZ) {
            contentValues.put("firstTimeTried", Boolean.valueOf(this.field_firstTimeTried));
        }
        if (this.flE) {
            contentValues.put("reportId", Integer.valueOf(this.field_reportId));
        }
        if (this.fVa) {
            contentValues.put("splitDownloadURLCgi", Boolean.valueOf(this.field_splitDownloadURLCgi));
        }
        if (this.fjO) {
            contentValues.put("scene", Integer.valueOf(this.field_scene));
        }
        if (this.fVb) {
            contentValues.put("cmdSequence", Long.valueOf(this.field_cmdSequence));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
