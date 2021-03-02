package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyEnum;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore;

public abstract class cc extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fCA = "errCode".hashCode();
    private static final int fCB = "startSize".hashCode();
    private static final int fCC = "startState".hashCode();
    private static final int fCD = "fromWeApp".hashCode();
    private static final int fCE = "downloadInWifi".hashCode();
    private static final int fCF = "finishTime".hashCode();
    private static final int fCG = "isSecondDownload".hashCode();
    private static final int fCH = "fromDownloadApp".hashCode();
    private static final int fCI = "reserveInWifi".hashCode();
    private static final int fCJ = TPDownloadProxyEnum.USER_SSID.hashCode();
    private static final int fCK = "uiarea".hashCode();
    private static final int fCL = "noticeId".hashCode();
    private static final int fCM = "downloadType".hashCode();
    private static final int fCN = "startScene".hashCode();
    private static final int fCO = "sectionMd5Byte".hashCode();
    private static final int fCP = "rawAppId".hashCode();
    private static final int fCQ = "notificationTitle".hashCode();
    private static final int fCn = "downloadId".hashCode();
    private static final int fCo = DownloadInfo.SECONDARYURL.hashCode();
    private static final int fCp = "fileSize".hashCode();
    private static final int fCq = DownloadInfo.FILENAME.hashCode();
    private static final int fCr = "fileType".hashCode();
    private static final int fCs = "autoInstall".hashCode();
    private static final int fCt = "showNotification".hashCode();
    private static final int fCu = "sysDownloadId".hashCode();
    private static final int fCv = "downloaderType".hashCode();
    private static final int fCw = "downloadedSize".hashCode();
    private static final int fCx = "totalSize".hashCode();
    private static final int fCy = "autoDownload".hashCode();
    private static final int fCz = "channelId".hashCode();
    private static final int fjQ = "scene".hashCode();
    private static final int fjl = "status".hashCode();
    private static final int fjx = "startTime".hashCode();
    private static final int fkj = "appId".hashCode();
    private static final int fml = AssistantStore.DownloadInfos.DownloadInfoColumns.PACKAGENAME.hashCode();
    private static final int fpP = IssueStorage.COLUMN_EXT_INFO.hashCode();
    private static final int fsr = "downloadUrlHashCode".hashCode();
    private static final int fss = "downloadUrl".hashCode();
    private static final int fsu = "filePath".hashCode();
    private static final int fyf = "md5".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private static final int updateTime_HASHCODE = ch.COL_UPDATETIME.hashCode();
    private boolean __hadSetupdateTime = true;
    private boolean fBJ = true;
    private boolean fBK = true;
    private boolean fBL = true;
    private boolean fBM = true;
    private boolean fBN = true;
    private boolean fBO = true;
    private boolean fBP = true;
    private boolean fBQ = true;
    private boolean fBR = true;
    private boolean fBS = true;
    private boolean fBT = true;
    private boolean fBU = true;
    private boolean fBV = true;
    private boolean fBW = true;
    private boolean fBX = true;
    private boolean fBY = true;
    private boolean fBZ = true;
    private boolean fCa = true;
    private boolean fCb = true;
    private boolean fCc = true;
    private boolean fCd = true;
    private boolean fCe = true;
    private boolean fCf = true;
    private boolean fCg = true;
    private boolean fCh = true;
    private boolean fCi = true;
    private boolean fCj = true;
    private boolean fCk = true;
    private boolean fCl = true;
    private boolean fCm = true;
    public String field_appId;
    public boolean field_autoDownload;
    public boolean field_autoInstall;
    public String field_channelId;
    public long field_downloadId;
    public boolean field_downloadInWifi;
    public int field_downloadType;
    public String field_downloadUrl;
    public int field_downloadUrlHashCode;
    public long field_downloadedSize;
    public int field_downloaderType;
    public int field_errCode;
    public String field_extInfo;
    public String field_fileName;
    public String field_filePath;
    public long field_fileSize;
    public int field_fileType;
    public long field_finishTime;
    public boolean field_fromDownloadApp;
    public boolean field_fromWeApp;
    public boolean field_isSecondDownload;
    public String field_md5;
    public int field_noticeId;
    public String field_notificationTitle;
    public String field_packageName;
    public String field_rawAppId;
    public boolean field_reserveInWifi;
    public int field_scene;
    public String field_secondaryUrl;
    public byte[] field_sectionMd5Byte;
    public boolean field_showNotification;
    public int field_ssid;
    public int field_startScene;
    public long field_startSize;
    public int field_startState;
    public long field_startTime;
    public int field_status;
    public long field_sysDownloadId;
    public long field_totalSize;
    public int field_uiarea;
    public long field_updateTime;
    private boolean fjO = true;
    private boolean fjS = true;
    private boolean fji = true;
    private boolean fjq = true;
    private boolean flP = true;
    private boolean fpB = true;
    private boolean fsj = true;
    private boolean fsk = true;
    private boolean fsm = true;
    private boolean fxt = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fCn == hashCode) {
                    this.field_downloadId = cursor.getLong(i2);
                    this.fBJ = true;
                } else if (fss == hashCode) {
                    this.field_downloadUrl = cursor.getString(i2);
                } else if (fCo == hashCode) {
                    this.field_secondaryUrl = cursor.getString(i2);
                } else if (fCp == hashCode) {
                    this.field_fileSize = cursor.getLong(i2);
                } else if (fCq == hashCode) {
                    this.field_fileName = cursor.getString(i2);
                } else if (fsu == hashCode) {
                    this.field_filePath = cursor.getString(i2);
                } else if (fCr == hashCode) {
                    this.field_fileType = cursor.getInt(i2);
                } else if (fjl == hashCode) {
                    this.field_status = cursor.getInt(i2);
                } else if (fyf == hashCode) {
                    this.field_md5 = cursor.getString(i2);
                } else if (fCs == hashCode) {
                    this.field_autoInstall = cursor.getInt(i2) != 0;
                } else if (fCt == hashCode) {
                    this.field_showNotification = cursor.getInt(i2) != 0;
                } else if (fCu == hashCode) {
                    this.field_sysDownloadId = cursor.getLong(i2);
                } else if (fCv == hashCode) {
                    this.field_downloaderType = cursor.getInt(i2);
                } else if (fkj == hashCode) {
                    this.field_appId = cursor.getString(i2);
                } else if (fsr == hashCode) {
                    this.field_downloadUrlHashCode = cursor.getInt(i2);
                } else if (fml == hashCode) {
                    this.field_packageName = cursor.getString(i2);
                } else if (fCw == hashCode) {
                    this.field_downloadedSize = cursor.getLong(i2);
                } else if (fCx == hashCode) {
                    this.field_totalSize = cursor.getLong(i2);
                } else if (fCy == hashCode) {
                    this.field_autoDownload = cursor.getInt(i2) != 0;
                } else if (fCz == hashCode) {
                    this.field_channelId = cursor.getString(i2);
                } else if (fjQ == hashCode) {
                    this.field_scene = cursor.getInt(i2);
                } else if (fCA == hashCode) {
                    this.field_errCode = cursor.getInt(i2);
                } else if (fjx == hashCode) {
                    this.field_startTime = cursor.getLong(i2);
                } else if (fCB == hashCode) {
                    this.field_startSize = cursor.getLong(i2);
                } else if (fCC == hashCode) {
                    this.field_startState = cursor.getInt(i2);
                } else if (fCD == hashCode) {
                    this.field_fromWeApp = cursor.getInt(i2) != 0;
                } else if (fCE == hashCode) {
                    this.field_downloadInWifi = cursor.getInt(i2) != 0;
                } else if (fpP == hashCode) {
                    this.field_extInfo = cursor.getString(i2);
                } else if (fCF == hashCode) {
                    this.field_finishTime = cursor.getLong(i2);
                } else if (fCG == hashCode) {
                    this.field_isSecondDownload = cursor.getInt(i2) != 0;
                } else if (fCH == hashCode) {
                    this.field_fromDownloadApp = cursor.getInt(i2) != 0;
                } else if (updateTime_HASHCODE == hashCode) {
                    this.field_updateTime = cursor.getLong(i2);
                } else if (fCI == hashCode) {
                    this.field_reserveInWifi = cursor.getInt(i2) != 0;
                } else if (fCJ == hashCode) {
                    this.field_ssid = cursor.getInt(i2);
                } else if (fCK == hashCode) {
                    this.field_uiarea = cursor.getInt(i2);
                } else if (fCL == hashCode) {
                    this.field_noticeId = cursor.getInt(i2);
                } else if (fCM == hashCode) {
                    this.field_downloadType = cursor.getInt(i2);
                } else if (fCN == hashCode) {
                    this.field_startScene = cursor.getInt(i2);
                } else if (fCO == hashCode) {
                    this.field_sectionMd5Byte = cursor.getBlob(i2);
                } else if (fCP == hashCode) {
                    this.field_rawAppId = cursor.getString(i2);
                } else if (fCQ == hashCode) {
                    this.field_notificationTitle = cursor.getString(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.fBJ) {
            contentValues.put("downloadId", Long.valueOf(this.field_downloadId));
        }
        if (this.field_downloadUrl == null) {
            this.field_downloadUrl = "";
        }
        if (this.fsk) {
            contentValues.put("downloadUrl", this.field_downloadUrl);
        }
        if (this.field_secondaryUrl == null) {
            this.field_secondaryUrl = "";
        }
        if (this.fBK) {
            contentValues.put(DownloadInfo.SECONDARYURL, this.field_secondaryUrl);
        }
        if (this.fBL) {
            contentValues.put("fileSize", Long.valueOf(this.field_fileSize));
        }
        if (this.field_fileName == null) {
            this.field_fileName = "";
        }
        if (this.fBM) {
            contentValues.put(DownloadInfo.FILENAME, this.field_fileName);
        }
        if (this.field_filePath == null) {
            this.field_filePath = "";
        }
        if (this.fsm) {
            contentValues.put("filePath", this.field_filePath);
        }
        if (this.fBN) {
            contentValues.put("fileType", Integer.valueOf(this.field_fileType));
        }
        if (this.fji) {
            contentValues.put("status", Integer.valueOf(this.field_status));
        }
        if (this.field_md5 == null) {
            this.field_md5 = "";
        }
        if (this.fxt) {
            contentValues.put("md5", this.field_md5);
        }
        if (this.fBO) {
            contentValues.put("autoInstall", Boolean.valueOf(this.field_autoInstall));
        }
        if (this.fBP) {
            contentValues.put("showNotification", Boolean.valueOf(this.field_showNotification));
        }
        if (this.fBQ) {
            contentValues.put("sysDownloadId", Long.valueOf(this.field_sysDownloadId));
        }
        if (this.fBR) {
            contentValues.put("downloaderType", Integer.valueOf(this.field_downloaderType));
        }
        if (this.field_appId == null) {
            this.field_appId = "";
        }
        if (this.fjS) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.fsj) {
            contentValues.put("downloadUrlHashCode", Integer.valueOf(this.field_downloadUrlHashCode));
        }
        if (this.field_packageName == null) {
            this.field_packageName = "";
        }
        if (this.flP) {
            contentValues.put(AssistantStore.DownloadInfos.DownloadInfoColumns.PACKAGENAME, this.field_packageName);
        }
        if (this.fBS) {
            contentValues.put("downloadedSize", Long.valueOf(this.field_downloadedSize));
        }
        if (this.fBT) {
            contentValues.put("totalSize", Long.valueOf(this.field_totalSize));
        }
        if (this.fBU) {
            contentValues.put("autoDownload", Boolean.valueOf(this.field_autoDownload));
        }
        if (this.field_channelId == null) {
            this.field_channelId = "";
        }
        if (this.fBV) {
            contentValues.put("channelId", this.field_channelId);
        }
        if (this.fjO) {
            contentValues.put("scene", Integer.valueOf(this.field_scene));
        }
        if (this.fBW) {
            contentValues.put("errCode", Integer.valueOf(this.field_errCode));
        }
        if (this.fjq) {
            contentValues.put("startTime", Long.valueOf(this.field_startTime));
        }
        if (this.fBX) {
            contentValues.put("startSize", Long.valueOf(this.field_startSize));
        }
        if (this.fBY) {
            contentValues.put("startState", Integer.valueOf(this.field_startState));
        }
        if (this.fBZ) {
            contentValues.put("fromWeApp", Boolean.valueOf(this.field_fromWeApp));
        }
        if (this.fCa) {
            contentValues.put("downloadInWifi", Boolean.valueOf(this.field_downloadInWifi));
        }
        if (this.field_extInfo == null) {
            this.field_extInfo = "";
        }
        if (this.fpB) {
            contentValues.put(IssueStorage.COLUMN_EXT_INFO, this.field_extInfo);
        }
        if (this.fCb) {
            contentValues.put("finishTime", Long.valueOf(this.field_finishTime));
        }
        if (this.fCc) {
            contentValues.put("isSecondDownload", Boolean.valueOf(this.field_isSecondDownload));
        }
        if (this.fCd) {
            contentValues.put("fromDownloadApp", Boolean.valueOf(this.field_fromDownloadApp));
        }
        if (this.__hadSetupdateTime) {
            contentValues.put(ch.COL_UPDATETIME, Long.valueOf(this.field_updateTime));
        }
        if (this.fCe) {
            contentValues.put("reserveInWifi", Boolean.valueOf(this.field_reserveInWifi));
        }
        if (this.fCf) {
            contentValues.put(TPDownloadProxyEnum.USER_SSID, Integer.valueOf(this.field_ssid));
        }
        if (this.fCg) {
            contentValues.put("uiarea", Integer.valueOf(this.field_uiarea));
        }
        if (this.fCh) {
            contentValues.put("noticeId", Integer.valueOf(this.field_noticeId));
        }
        if (this.fCi) {
            contentValues.put("downloadType", Integer.valueOf(this.field_downloadType));
        }
        if (this.fCj) {
            contentValues.put("startScene", Integer.valueOf(this.field_startScene));
        }
        if (this.fCk) {
            contentValues.put("sectionMd5Byte", this.field_sectionMd5Byte);
        }
        if (this.field_rawAppId == null) {
            this.field_rawAppId = "";
        }
        if (this.fCl) {
            contentValues.put("rawAppId", this.field_rawAppId);
        }
        if (this.field_notificationTitle == null) {
            this.field_notificationTitle = "";
        }
        if (this.fCm) {
            contentValues.put("notificationTitle", this.field_notificationTitle);
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
