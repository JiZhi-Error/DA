package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class hs extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int createTime_HASHCODE = "createTime".hashCode();
    private static final int fkX = "size".hashCode();
    private static final int flv = "version".hashCode();
    private static final int fss = "downloadUrl".hashCode();
    private static final int fsu = "filePath".hashCode();
    private static final int fyf = "md5".hashCode();
    private static final int ghR = "rid".hashCode();
    private static final int ghS = "mimeType".hashCode();
    private static final int ghT = "completeDownload".hashCode();
    private static final int ghU = "autoDownloadCount".hashCode();
    private static final int ghV = "fileDownloadCount".hashCode();
    private static final int ghj = "pkgId".hashCode();
    private static final int ghn = "downloadNetType".hashCode();
    private static final int key_HASHCODE = "key".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private boolean __hadSetcreateTime = true;
    private boolean __hadSetkey = true;
    public int field_autoDownloadCount;
    public boolean field_completeDownload;
    public long field_createTime;
    public int field_downloadNetType;
    public String field_downloadUrl;
    public int field_fileDownloadCount;
    public String field_filePath;
    public String field_key;
    public String field_md5;
    public String field_mimeType;
    public String field_pkgId;
    public String field_rid;
    public int field_size;
    public String field_version;
    private boolean fkV = true;
    private boolean flq = true;
    private boolean fsk = true;
    private boolean fsm = true;
    private boolean fxt = true;
    private boolean ghM = true;
    private boolean ghN = true;
    private boolean ghO = true;
    private boolean ghP = true;
    private boolean ghQ = true;
    private boolean ghe = true;
    private boolean ghi = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (key_HASHCODE == hashCode) {
                    this.field_key = cursor.getString(i2);
                    this.__hadSetkey = true;
                } else if (ghj == hashCode) {
                    this.field_pkgId = cursor.getString(i2);
                } else if (flv == hashCode) {
                    this.field_version = cursor.getString(i2);
                } else if (fsu == hashCode) {
                    this.field_filePath = cursor.getString(i2);
                } else if (ghR == hashCode) {
                    this.field_rid = cursor.getString(i2);
                } else if (ghS == hashCode) {
                    this.field_mimeType = cursor.getString(i2);
                } else if (fyf == hashCode) {
                    this.field_md5 = cursor.getString(i2);
                } else if (fss == hashCode) {
                    this.field_downloadUrl = cursor.getString(i2);
                } else if (fkX == hashCode) {
                    this.field_size = cursor.getInt(i2);
                } else if (ghn == hashCode) {
                    this.field_downloadNetType = cursor.getInt(i2);
                } else if (ghT == hashCode) {
                    this.field_completeDownload = cursor.getInt(i2) != 0;
                } else if (createTime_HASHCODE == hashCode) {
                    this.field_createTime = cursor.getLong(i2);
                } else if (ghU == hashCode) {
                    this.field_autoDownloadCount = cursor.getInt(i2);
                } else if (ghV == hashCode) {
                    this.field_fileDownloadCount = cursor.getInt(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.__hadSetkey) {
            contentValues.put("key", this.field_key);
        }
        if (this.ghe) {
            contentValues.put("pkgId", this.field_pkgId);
        }
        if (this.flq) {
            contentValues.put("version", this.field_version);
        }
        if (this.fsm) {
            contentValues.put("filePath", this.field_filePath);
        }
        if (this.ghM) {
            contentValues.put("rid", this.field_rid);
        }
        if (this.ghN) {
            contentValues.put("mimeType", this.field_mimeType);
        }
        if (this.fxt) {
            contentValues.put("md5", this.field_md5);
        }
        if (this.fsk) {
            contentValues.put("downloadUrl", this.field_downloadUrl);
        }
        if (this.fkV) {
            contentValues.put("size", Integer.valueOf(this.field_size));
        }
        if (this.ghi) {
            contentValues.put("downloadNetType", Integer.valueOf(this.field_downloadNetType));
        }
        if (this.ghO) {
            contentValues.put("completeDownload", Boolean.valueOf(this.field_completeDownload));
        }
        if (this.__hadSetcreateTime) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.ghP) {
            contentValues.put("autoDownloadCount", Integer.valueOf(this.field_autoDownloadCount));
        }
        if (this.ghQ) {
            contentValues.put("fileDownloadCount", Integer.valueOf(this.field_fileDownloadCount));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
