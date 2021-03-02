package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class at extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fkm = "mediaId".hashCode();
    private static final int fsr = "downloadUrlHashCode".hashCode();
    private static final int fss = "downloadUrl".hashCode();
    private static final int fst = "httpsUrl".hashCode();
    private static final int fsu = "filePath".hashCode();
    private static final int fsv = "verifyHeaders".hashCode();
    private static final int fsw = "game_package_download".hashCode();
    private static final int fsx = "allowMobileNetDownload".hashCode();
    private static final int fsy = "wifiAutoDownload".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    public Boolean field_allowMobileNetDownload;
    public String field_downloadUrl;
    public int field_downloadUrlHashCode;
    public String field_filePath;
    public Boolean field_game_package_download;
    public String field_httpsUrl;
    public String field_mediaId;
    public String field_verifyHeaders;
    public Boolean field_wifiAutoDownload;
    private boolean fjV = true;
    private boolean fsj = true;
    private boolean fsk = true;
    private boolean fsl = true;
    private boolean fsm = true;
    private boolean fsn = true;
    private boolean fso = true;
    private boolean fsp = true;
    private boolean fsq = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fkm == hashCode) {
                    this.field_mediaId = cursor.getString(i2);
                } else if (fsr == hashCode) {
                    this.field_downloadUrlHashCode = cursor.getInt(i2);
                    this.fsj = true;
                } else if (fss == hashCode) {
                    this.field_downloadUrl = cursor.getString(i2);
                } else if (fst == hashCode) {
                    this.field_httpsUrl = cursor.getString(i2);
                } else if (fsu == hashCode) {
                    this.field_filePath = cursor.getString(i2);
                } else if (fsv == hashCode) {
                    this.field_verifyHeaders = cursor.getString(i2);
                } else if (fsw == hashCode) {
                    this.field_game_package_download = Boolean.valueOf(cursor.getInt(i2) != 0);
                } else if (fsx == hashCode) {
                    this.field_allowMobileNetDownload = Boolean.valueOf(cursor.getInt(i2) != 0);
                } else if (fsy == hashCode) {
                    this.field_wifiAutoDownload = Boolean.valueOf(cursor.getInt(i2) != 0);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.fjV) {
            contentValues.put("mediaId", this.field_mediaId);
        }
        if (this.fsj) {
            contentValues.put("downloadUrlHashCode", Integer.valueOf(this.field_downloadUrlHashCode));
        }
        if (this.fsk) {
            contentValues.put("downloadUrl", this.field_downloadUrl);
        }
        if (this.fsl) {
            contentValues.put("httpsUrl", this.field_httpsUrl);
        }
        if (this.fsm) {
            contentValues.put("filePath", this.field_filePath);
        }
        if (this.fsn) {
            contentValues.put("verifyHeaders", this.field_verifyHeaders);
        }
        if (this.fso) {
            contentValues.put("game_package_download", this.field_game_package_download);
        }
        if (this.fsp) {
            contentValues.put("allowMobileNetDownload", this.field_allowMobileNetDownload);
        }
        if (this.fsq) {
            contentValues.put("wifiAutoDownload", this.field_wifiAutoDownload);
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
