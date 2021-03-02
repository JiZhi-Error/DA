package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore;

public abstract class df extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fCO = "sectionMd5Byte".hashCode();
    private static final int fJH = "randomTime".hashCode();
    private static final int fJI = "isFirst".hashCode();
    private static final int fJJ = "nextCheckTime".hashCode();
    private static final int fJK = "isRunning".hashCode();
    private static final int fJL = "noWifi".hashCode();
    private static final int fJM = "noSdcard".hashCode();
    private static final int fJN = "noEnoughSpace".hashCode();
    private static final int fJO = "lowBattery".hashCode();
    private static final int fJP = "continueDelay".hashCode();
    private static final int fJQ = "SecondaryUrl".hashCode();
    private static final int fJR = "downloadInWidget".hashCode();
    private static final int fJS = "forceUpdateFlag".hashCode();
    private static final int fJb = "expireTime".hashCode();
    private static final int fkX = "size".hashCode();
    private static final int fkj = "appId".hashCode();
    private static final int fml = AssistantStore.DownloadInfos.DownloadInfoColumns.PACKAGENAME.hashCode();
    private static final int fss = "downloadUrl".hashCode();
    private static final int fyf = "md5".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private boolean fCk = true;
    private boolean fIP = true;
    private boolean fJA = true;
    private boolean fJB = true;
    private boolean fJC = true;
    private boolean fJD = true;
    private boolean fJE = true;
    private boolean fJF = true;
    private boolean fJG = true;
    private boolean fJv = true;
    private boolean fJw = true;
    private boolean fJx = true;
    private boolean fJy = true;
    private boolean fJz = true;
    public String field_SecondaryUrl;
    public String field_appId;
    public boolean field_continueDelay;
    public boolean field_downloadInWidget;
    public String field_downloadUrl;
    public long field_expireTime;
    public int field_forceUpdateFlag;
    public boolean field_isFirst;
    public boolean field_isRunning;
    public boolean field_lowBattery;
    public String field_md5;
    public long field_nextCheckTime;
    public boolean field_noEnoughSpace;
    public boolean field_noSdcard;
    public boolean field_noWifi;
    public String field_packageName;
    public long field_randomTime;
    public byte[] field_sectionMd5Byte;
    public long field_size;
    private boolean fjS = true;
    private boolean fkV = true;
    private boolean flP = true;
    private boolean fsk = true;
    private boolean fxt = true;

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
                } else if (fss == hashCode) {
                    this.field_downloadUrl = cursor.getString(i2);
                } else if (fkX == hashCode) {
                    this.field_size = cursor.getLong(i2);
                } else if (fyf == hashCode) {
                    this.field_md5 = cursor.getString(i2);
                } else if (fml == hashCode) {
                    this.field_packageName = cursor.getString(i2);
                } else if (fJb == hashCode) {
                    this.field_expireTime = cursor.getLong(i2);
                } else if (fJH == hashCode) {
                    this.field_randomTime = cursor.getLong(i2);
                } else if (fJI == hashCode) {
                    this.field_isFirst = cursor.getInt(i2) != 0;
                } else if (fJJ == hashCode) {
                    this.field_nextCheckTime = cursor.getLong(i2);
                } else if (fJK == hashCode) {
                    this.field_isRunning = cursor.getInt(i2) != 0;
                } else if (fJL == hashCode) {
                    this.field_noWifi = cursor.getInt(i2) != 0;
                } else if (fJM == hashCode) {
                    this.field_noSdcard = cursor.getInt(i2) != 0;
                } else if (fJN == hashCode) {
                    this.field_noEnoughSpace = cursor.getInt(i2) != 0;
                } else if (fJO == hashCode) {
                    this.field_lowBattery = cursor.getInt(i2) != 0;
                } else if (fJP == hashCode) {
                    this.field_continueDelay = cursor.getInt(i2) != 0;
                } else if (fJQ == hashCode) {
                    this.field_SecondaryUrl = cursor.getString(i2);
                } else if (fJR == hashCode) {
                    this.field_downloadInWidget = cursor.getInt(i2) != 0;
                } else if (fCO == hashCode) {
                    this.field_sectionMd5Byte = cursor.getBlob(i2);
                } else if (fJS == hashCode) {
                    this.field_forceUpdateFlag = cursor.getInt(i2);
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
        if (this.fsk) {
            contentValues.put("downloadUrl", this.field_downloadUrl);
        }
        if (this.fkV) {
            contentValues.put("size", Long.valueOf(this.field_size));
        }
        if (this.fxt) {
            contentValues.put("md5", this.field_md5);
        }
        if (this.flP) {
            contentValues.put(AssistantStore.DownloadInfos.DownloadInfoColumns.PACKAGENAME, this.field_packageName);
        }
        if (this.fIP) {
            contentValues.put("expireTime", Long.valueOf(this.field_expireTime));
        }
        if (this.fJv) {
            contentValues.put("randomTime", Long.valueOf(this.field_randomTime));
        }
        if (this.fJw) {
            contentValues.put("isFirst", Boolean.valueOf(this.field_isFirst));
        }
        if (this.fJx) {
            contentValues.put("nextCheckTime", Long.valueOf(this.field_nextCheckTime));
        }
        if (this.fJy) {
            contentValues.put("isRunning", Boolean.valueOf(this.field_isRunning));
        }
        if (this.fJz) {
            contentValues.put("noWifi", Boolean.valueOf(this.field_noWifi));
        }
        if (this.fJA) {
            contentValues.put("noSdcard", Boolean.valueOf(this.field_noSdcard));
        }
        if (this.fJB) {
            contentValues.put("noEnoughSpace", Boolean.valueOf(this.field_noEnoughSpace));
        }
        if (this.fJC) {
            contentValues.put("lowBattery", Boolean.valueOf(this.field_lowBattery));
        }
        if (this.fJD) {
            contentValues.put("continueDelay", Boolean.valueOf(this.field_continueDelay));
        }
        if (this.fJE) {
            contentValues.put("SecondaryUrl", this.field_SecondaryUrl);
        }
        if (this.fJF) {
            contentValues.put("downloadInWidget", Boolean.valueOf(this.field_downloadInWidget));
        }
        if (this.fCk) {
            contentValues.put("sectionMd5Byte", this.field_sectionMd5Byte);
        }
        if (this.fJG) {
            contentValues.put("forceUpdateFlag", Integer.valueOf(this.field_forceUpdateFlag));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
