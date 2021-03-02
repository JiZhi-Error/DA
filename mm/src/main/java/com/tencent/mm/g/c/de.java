package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore;
import java.lang.reflect.Field;

public abstract class de extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int createTime_HASHCODE = "createTime".hashCode();
    private static final int fJq = "intervalSeconds".hashCode();
    private static final int fJr = "expiredSeconds".hashCode();
    private static final int fJs = "checkCgiTime".hashCode();
    private static final int fJt = "finishDownloadTime".hashCode();
    private static final int fJu = "downloadItemList".hashCode();
    private static final int fkj = "appId".hashCode();
    private static final int fml = AssistantStore.DownloadInfos.DownloadInfoColumns.PACKAGENAME.hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private boolean __hadSetcreateTime = true;
    private boolean fJl = true;
    private boolean fJm = true;
    private boolean fJn = true;
    private boolean fJo = true;
    private boolean fJp = true;
    public String field_appId;
    public long field_checkCgiTime;
    public long field_createTime;
    public byte[] field_downloadItemList;
    public int field_expiredSeconds;
    public long field_finishDownloadTime;
    public int field_intervalSeconds;
    public String field_packageName;
    private boolean fjS = true;
    private boolean flP = true;

    public static IAutoDBItem.MAutoDBInfo ajs() {
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[8];
        mAutoDBInfo.columns = new String[9];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = AssistantStore.DownloadInfos.DownloadInfoColumns.PACKAGENAME;
        mAutoDBInfo.colsMap.put(AssistantStore.DownloadInfos.DownloadInfoColumns.PACKAGENAME, "TEXT PRIMARY KEY ");
        sb.append(" packageName TEXT PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = AssistantStore.DownloadInfos.DownloadInfoColumns.PACKAGENAME;
        mAutoDBInfo.columns[1] = "appId";
        mAutoDBInfo.colsMap.put("appId", "TEXT");
        sb.append(" appId TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "intervalSeconds";
        mAutoDBInfo.colsMap.put("intervalSeconds", "INTEGER");
        sb.append(" intervalSeconds INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "expiredSeconds";
        mAutoDBInfo.colsMap.put("expiredSeconds", "INTEGER");
        sb.append(" expiredSeconds INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "createTime";
        mAutoDBInfo.colsMap.put("createTime", "LONG");
        sb.append(" createTime LONG");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "checkCgiTime";
        mAutoDBInfo.colsMap.put("checkCgiTime", "LONG");
        sb.append(" checkCgiTime LONG");
        sb.append(", ");
        mAutoDBInfo.columns[6] = "finishDownloadTime";
        mAutoDBInfo.colsMap.put("finishDownloadTime", "LONG");
        sb.append(" finishDownloadTime LONG");
        sb.append(", ");
        mAutoDBInfo.columns[7] = "downloadItemList";
        mAutoDBInfo.colsMap.put("downloadItemList", "BLOB");
        sb.append(" downloadItemList BLOB");
        mAutoDBInfo.columns[8] = "rowid";
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
                if (fml == hashCode) {
                    this.field_packageName = cursor.getString(i2);
                    this.flP = true;
                } else if (fkj == hashCode) {
                    this.field_appId = cursor.getString(i2);
                } else if (fJq == hashCode) {
                    this.field_intervalSeconds = cursor.getInt(i2);
                } else if (fJr == hashCode) {
                    this.field_expiredSeconds = cursor.getInt(i2);
                } else if (createTime_HASHCODE == hashCode) {
                    this.field_createTime = cursor.getLong(i2);
                } else if (fJs == hashCode) {
                    this.field_checkCgiTime = cursor.getLong(i2);
                } else if (fJt == hashCode) {
                    this.field_finishDownloadTime = cursor.getLong(i2);
                } else if (fJu == hashCode) {
                    this.field_downloadItemList = cursor.getBlob(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.flP) {
            contentValues.put(AssistantStore.DownloadInfos.DownloadInfoColumns.PACKAGENAME, this.field_packageName);
        }
        if (this.fjS) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.fJl) {
            contentValues.put("intervalSeconds", Integer.valueOf(this.field_intervalSeconds));
        }
        if (this.fJm) {
            contentValues.put("expiredSeconds", Integer.valueOf(this.field_expiredSeconds));
        }
        if (this.__hadSetcreateTime) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.fJn) {
            contentValues.put("checkCgiTime", Long.valueOf(this.field_checkCgiTime));
        }
        if (this.fJo) {
            contentValues.put("finishDownloadTime", Long.valueOf(this.field_finishDownloadTime));
        }
        if (this.fJp) {
            contentValues.put("downloadItemList", this.field_downloadItemList);
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
