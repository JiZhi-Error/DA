package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.lang.reflect.Field;

public abstract class fg extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fCq = DownloadInfo.FILENAME.hashCode();
    private static final int fSn = "musicId".hashCode();
    private static final int fUG = "musicUrl".hashCode();
    private static final int fUH = "indexBitData".hashCode();
    private static final int fUI = "fileCacheComplete".hashCode();
    private static final int fUJ = "pieceFileMIMEType".hashCode();
    private static final int fUK = "removeDirtyBit".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private boolean fBM = true;
    private boolean fRD = true;
    private boolean fUB = true;
    private boolean fUC = true;
    private boolean fUD = true;
    private boolean fUE = true;
    private boolean fUF = true;
    public int field_fileCacheComplete;
    public String field_fileName;
    public byte[] field_indexBitData;
    public String field_musicId;
    public String field_musicUrl;
    public String field_pieceFileMIMEType;
    public int field_removeDirtyBit;

    public static IAutoDBItem.MAutoDBInfo ajs() {
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[7];
        mAutoDBInfo.columns = new String[8];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "musicId";
        mAutoDBInfo.colsMap.put("musicId", "TEXT PRIMARY KEY ");
        sb.append(" musicId TEXT PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "musicId";
        mAutoDBInfo.columns[1] = "musicUrl";
        mAutoDBInfo.colsMap.put("musicUrl", "TEXT");
        sb.append(" musicUrl TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[2] = DownloadInfo.FILENAME;
        mAutoDBInfo.colsMap.put(DownloadInfo.FILENAME, "TEXT");
        sb.append(" fileName TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "indexBitData";
        mAutoDBInfo.colsMap.put("indexBitData", "BLOB");
        sb.append(" indexBitData BLOB");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "fileCacheComplete";
        mAutoDBInfo.colsMap.put("fileCacheComplete", "INTEGER");
        sb.append(" fileCacheComplete INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "pieceFileMIMEType";
        mAutoDBInfo.colsMap.put("pieceFileMIMEType", "TEXT");
        sb.append(" pieceFileMIMEType TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[6] = "removeDirtyBit";
        mAutoDBInfo.colsMap.put("removeDirtyBit", "INTEGER");
        sb.append(" removeDirtyBit INTEGER");
        mAutoDBInfo.columns[7] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        return mAutoDBInfo;
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fSn == hashCode) {
                    this.field_musicId = cursor.getString(i2);
                    this.fRD = true;
                } else if (fUG == hashCode) {
                    this.field_musicUrl = cursor.getString(i2);
                } else if (fCq == hashCode) {
                    this.field_fileName = cursor.getString(i2);
                } else if (fUH == hashCode) {
                    this.field_indexBitData = cursor.getBlob(i2);
                } else if (fUI == hashCode) {
                    this.field_fileCacheComplete = cursor.getInt(i2);
                } else if (fUJ == hashCode) {
                    this.field_pieceFileMIMEType = cursor.getString(i2);
                } else if (fUK == hashCode) {
                    this.field_removeDirtyBit = cursor.getInt(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.fRD) {
            contentValues.put("musicId", this.field_musicId);
        }
        if (this.fUB) {
            contentValues.put("musicUrl", this.field_musicUrl);
        }
        if (this.fBM) {
            contentValues.put(DownloadInfo.FILENAME, this.field_fileName);
        }
        if (this.fUC) {
            contentValues.put("indexBitData", this.field_indexBitData);
        }
        if (this.fUD) {
            contentValues.put("fileCacheComplete", Integer.valueOf(this.field_fileCacheComplete));
        }
        if (this.fUE) {
            contentValues.put("pieceFileMIMEType", this.field_pieceFileMIMEType);
        }
        if (this.fUF) {
            contentValues.put("removeDirtyBit", Integer.valueOf(this.field_removeDirtyBit));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
