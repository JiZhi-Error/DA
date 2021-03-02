package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;

public abstract class ge extends IAutoDBItem {
    public static final String[] INDEX_CREATE = {"CREATE INDEX IF NOT EXISTS file_name_hash_index ON SightDraftInfo(fileNameHash)"};
    private static final int createTime_HASHCODE = "createTime".hashCode();
    private static final int fCq = DownloadInfo.FILENAME.hashCode();
    private static final int fYU = "fileNameHash".hashCode();
    private static final int fYV = "fileMd5".hashCode();
    private static final int fYW = "fileLength".hashCode();
    private static final int fYX = "fileStatus".hashCode();
    private static final int fYY = "fileDuration".hashCode();
    private static final int localId_HASHCODE = ch.COL_LOCALID.hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private boolean __hadSetcreateTime = true;
    private boolean __hadSetlocalId = true;
    private boolean fBM = true;
    private boolean fYP = true;
    private boolean fYQ = true;
    private boolean fYR = true;
    private boolean fYS = true;
    private boolean fYT = true;
    public long field_createTime;
    public int field_fileDuration;
    public long field_fileLength;
    public String field_fileMd5;
    public String field_fileName;
    public int field_fileNameHash;
    public int field_fileStatus;
    public int field_localId;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (localId_HASHCODE == hashCode) {
                    this.field_localId = cursor.getInt(i2);
                    this.__hadSetlocalId = true;
                } else if (fCq == hashCode) {
                    this.field_fileName = cursor.getString(i2);
                } else if (fYU == hashCode) {
                    this.field_fileNameHash = cursor.getInt(i2);
                } else if (fYV == hashCode) {
                    this.field_fileMd5 = cursor.getString(i2);
                } else if (fYW == hashCode) {
                    this.field_fileLength = cursor.getLong(i2);
                } else if (fYX == hashCode) {
                    this.field_fileStatus = cursor.getInt(i2);
                } else if (fYY == hashCode) {
                    this.field_fileDuration = cursor.getInt(i2);
                } else if (createTime_HASHCODE == hashCode) {
                    this.field_createTime = cursor.getLong(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.__hadSetlocalId) {
            contentValues.put(ch.COL_LOCALID, Integer.valueOf(this.field_localId));
        }
        if (this.fBM) {
            contentValues.put(DownloadInfo.FILENAME, this.field_fileName);
        }
        if (this.fYP) {
            contentValues.put("fileNameHash", Integer.valueOf(this.field_fileNameHash));
        }
        if (this.field_fileMd5 == null) {
            this.field_fileMd5 = "";
        }
        if (this.fYQ) {
            contentValues.put("fileMd5", this.field_fileMd5);
        }
        if (this.fYR) {
            contentValues.put("fileLength", Long.valueOf(this.field_fileLength));
        }
        if (this.fYS) {
            contentValues.put("fileStatus", Integer.valueOf(this.field_fileStatus));
        }
        if (this.fYT) {
            contentValues.put("fileDuration", Integer.valueOf(this.field_fileDuration));
        }
        if (this.__hadSetcreateTime) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
