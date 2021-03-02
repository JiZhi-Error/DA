package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore;

public abstract class fc extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fUu = "sceneFlag".hashCode();
    private static final int fUv = "msgTypeFlag".hashCode();
    private static final int fUw = "msgState".hashCode();
    private static final int fjl = "status".hashCode();
    private static final int fkj = "appId".hashCode();
    private static final int fml = AssistantStore.DownloadInfos.DownloadInfoColumns.PACKAGENAME.hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private boolean fUr = true;
    private boolean fUs = true;
    private boolean fUt = true;
    public String field_appId;
    public int field_msgState;
    public int field_msgTypeFlag;
    public String field_packageName;
    public int field_sceneFlag;
    public int field_status;
    private boolean fjS = true;
    private boolean fji = true;
    private boolean flP = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fkj == hashCode) {
                    this.field_appId = cursor.getString(i2);
                    this.fjS = true;
                } else if (fml == hashCode) {
                    this.field_packageName = cursor.getString(i2);
                } else if (fjl == hashCode) {
                    this.field_status = cursor.getInt(i2);
                } else if (fUu == hashCode) {
                    this.field_sceneFlag = cursor.getInt(i2);
                } else if (fUv == hashCode) {
                    this.field_msgTypeFlag = cursor.getInt(i2);
                } else if (fUw == hashCode) {
                    this.field_msgState = cursor.getInt(i2);
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
        if (this.flP) {
            contentValues.put(AssistantStore.DownloadInfos.DownloadInfoColumns.PACKAGENAME, this.field_packageName);
        }
        if (this.fji) {
            contentValues.put("status", Integer.valueOf(this.field_status));
        }
        if (this.fUr) {
            contentValues.put("sceneFlag", Integer.valueOf(this.field_sceneFlag));
        }
        if (this.fUs) {
            contentValues.put("msgTypeFlag", Integer.valueOf(this.field_msgTypeFlag));
        }
        if (this.fUt) {
            contentValues.put("msgState", Integer.valueOf(this.field_msgState));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
