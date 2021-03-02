package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;

public abstract class ft extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fCp = "fileSize".hashCode();
    private static final int fJb = "expireTime".hashCode();
    private static final int fTG = DownloadInfo.PRIORITY.hashCode();
    private static final int fVc = "retryTimes".hashCode();
    private static final int fVf = "networkType".hashCode();
    private static final int fWL = "urlKey_hashcode".hashCode();
    private static final int fWM = "urlKey".hashCode();
    private static final int fWN = "fileVersion".hashCode();
    private static final int fWO = "maxRetryTimes".hashCode();
    private static final int fWP = "contentLength".hashCode();
    private static final int fWQ = DownloadInfo.CONTENTTYPE.hashCode();
    private static final int fWR = "groupId1".hashCode();
    private static final int fWS = "groupId2".hashCode();
    private static final int fWT = "fileUpdated".hashCode();
    private static final int fWU = "deleted".hashCode();
    private static final int fWV = "resType".hashCode();
    private static final int fWW = "sampleId".hashCode();
    private static final int fWX = "eccSignature".hashCode();
    private static final int fWY = "originalMd5".hashCode();
    private static final int fWZ = "fileCompress".hashCode();
    private static final int fXa = "fileEncrypt".hashCode();
    private static final int fXb = "encryptKey".hashCode();
    private static final int fXc = "keyVersion".hashCode();
    private static final int fXd = "EID".hashCode();
    private static final int fXe = "needRetry".hashCode();
    private static final int fXf = "wvCacheType".hashCode();
    private static final int fXg = "packageId".hashCode();
    private static final int fjl = "status".hashCode();
    private static final int fkj = "appId".hashCode();
    private static final int flJ = "reportId".hashCode();
    private static final int fnB = "url".hashCode();
    private static final int fsu = "filePath".hashCode();
    private static final int fyf = "md5".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private static final int subType_HASHCODE = "subType".hashCode();
    private boolean __hadSetsubType = true;
    private boolean fBL = true;
    private boolean fIP = true;
    private boolean fTy = true;
    private boolean fUT = true;
    private boolean fUW = true;
    private boolean fWA = true;
    private boolean fWB = true;
    private boolean fWC = true;
    private boolean fWD = true;
    private boolean fWE = true;
    private boolean fWF = true;
    private boolean fWG = true;
    private boolean fWH = true;
    private boolean fWI = true;
    private boolean fWJ = true;
    private boolean fWK = true;
    private boolean fWp = true;
    private boolean fWq = true;
    private boolean fWr = true;
    private boolean fWs = true;
    private boolean fWt = true;
    private boolean fWu = true;
    private boolean fWv = true;
    private boolean fWw = true;
    private boolean fWx = true;
    private boolean fWy = true;
    private boolean fWz = true;
    public int field_EID;
    public String field_appId;
    public long field_contentLength;
    public String field_contentType;
    public boolean field_deleted;
    public byte[] field_eccSignature;
    public String field_encryptKey;
    public long field_expireTime;
    public boolean field_fileCompress;
    public boolean field_fileEncrypt;
    public String field_filePath;
    public long field_fileSize;
    public boolean field_fileUpdated;
    public String field_fileVersion;
    public String field_groupId1;
    public String field_groupId2;
    public int field_keyVersion;
    public int field_maxRetryTimes;
    public String field_md5;
    public boolean field_needRetry;
    public int field_networkType;
    public String field_originalMd5;
    public String field_packageId;
    public int field_priority;
    public long field_reportId;
    public int field_resType;
    public int field_retryTimes;
    public String field_sampleId;
    public int field_status;
    public int field_subType;
    public String field_url;
    public String field_urlKey;
    public int field_urlKey_hashcode;
    public int field_wvCacheType;
    private boolean fjS = true;
    private boolean fji = true;
    private boolean flE = true;
    private boolean fnx = true;
    private boolean fsm = true;
    private boolean fxt = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fWL == hashCode) {
                    this.field_urlKey_hashcode = cursor.getInt(i2);
                    this.fWp = true;
                } else if (fWM == hashCode) {
                    this.field_urlKey = cursor.getString(i2);
                } else if (fnB == hashCode) {
                    this.field_url = cursor.getString(i2);
                } else if (fWN == hashCode) {
                    this.field_fileVersion = cursor.getString(i2);
                } else if (fVf == hashCode) {
                    this.field_networkType = cursor.getInt(i2);
                } else if (fWO == hashCode) {
                    this.field_maxRetryTimes = cursor.getInt(i2);
                } else if (fVc == hashCode) {
                    this.field_retryTimes = cursor.getInt(i2);
                } else if (fsu == hashCode) {
                    this.field_filePath = cursor.getString(i2);
                } else if (fjl == hashCode) {
                    this.field_status = cursor.getInt(i2);
                } else if (fWP == hashCode) {
                    this.field_contentLength = cursor.getLong(i2);
                } else if (fWQ == hashCode) {
                    this.field_contentType = cursor.getString(i2);
                } else if (fJb == hashCode) {
                    this.field_expireTime = cursor.getLong(i2);
                } else if (fyf == hashCode) {
                    this.field_md5 = cursor.getString(i2);
                } else if (fWR == hashCode) {
                    this.field_groupId1 = cursor.getString(i2);
                } else if (fWS == hashCode) {
                    this.field_groupId2 = cursor.getString(i2);
                } else if (fTG == hashCode) {
                    this.field_priority = cursor.getInt(i2);
                } else if (fWT == hashCode) {
                    this.field_fileUpdated = cursor.getInt(i2) != 0;
                } else if (fWU == hashCode) {
                    this.field_deleted = cursor.getInt(i2) != 0;
                } else if (fWV == hashCode) {
                    this.field_resType = cursor.getInt(i2);
                } else if (subType_HASHCODE == hashCode) {
                    this.field_subType = cursor.getInt(i2);
                } else if (flJ == hashCode) {
                    this.field_reportId = cursor.getLong(i2);
                } else if (fWW == hashCode) {
                    this.field_sampleId = cursor.getString(i2);
                } else if (fWX == hashCode) {
                    this.field_eccSignature = cursor.getBlob(i2);
                } else if (fWY == hashCode) {
                    this.field_originalMd5 = cursor.getString(i2);
                } else if (fWZ == hashCode) {
                    this.field_fileCompress = cursor.getInt(i2) != 0;
                } else if (fXa == hashCode) {
                    this.field_fileEncrypt = cursor.getInt(i2) != 0;
                } else if (fXb == hashCode) {
                    this.field_encryptKey = cursor.getString(i2);
                } else if (fXc == hashCode) {
                    this.field_keyVersion = cursor.getInt(i2);
                } else if (fXd == hashCode) {
                    this.field_EID = cursor.getInt(i2);
                } else if (fCp == hashCode) {
                    this.field_fileSize = cursor.getLong(i2);
                } else if (fXe == hashCode) {
                    this.field_needRetry = cursor.getInt(i2) != 0;
                } else if (fkj == hashCode) {
                    this.field_appId = cursor.getString(i2);
                } else if (fXf == hashCode) {
                    this.field_wvCacheType = cursor.getInt(i2);
                } else if (fXg == hashCode) {
                    this.field_packageId = cursor.getString(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.fWp) {
            contentValues.put("urlKey_hashcode", Integer.valueOf(this.field_urlKey_hashcode));
        }
        if (this.fWq) {
            contentValues.put("urlKey", this.field_urlKey);
        }
        if (this.fnx) {
            contentValues.put("url", this.field_url);
        }
        if (this.fWr) {
            contentValues.put("fileVersion", this.field_fileVersion);
        }
        if (this.fUW) {
            contentValues.put("networkType", Integer.valueOf(this.field_networkType));
        }
        if (this.fWs) {
            contentValues.put("maxRetryTimes", Integer.valueOf(this.field_maxRetryTimes));
        }
        if (this.fUT) {
            contentValues.put("retryTimes", Integer.valueOf(this.field_retryTimes));
        }
        if (this.fsm) {
            contentValues.put("filePath", this.field_filePath);
        }
        if (this.fji) {
            contentValues.put("status", Integer.valueOf(this.field_status));
        }
        if (this.fWt) {
            contentValues.put("contentLength", Long.valueOf(this.field_contentLength));
        }
        if (this.fWu) {
            contentValues.put(DownloadInfo.CONTENTTYPE, this.field_contentType);
        }
        if (this.fIP) {
            contentValues.put("expireTime", Long.valueOf(this.field_expireTime));
        }
        if (this.fxt) {
            contentValues.put("md5", this.field_md5);
        }
        if (this.fWv) {
            contentValues.put("groupId1", this.field_groupId1);
        }
        if (this.fWw) {
            contentValues.put("groupId2", this.field_groupId2);
        }
        if (this.fTy) {
            contentValues.put(DownloadInfo.PRIORITY, Integer.valueOf(this.field_priority));
        }
        if (this.fWx) {
            contentValues.put("fileUpdated", Boolean.valueOf(this.field_fileUpdated));
        }
        if (this.fWy) {
            contentValues.put("deleted", Boolean.valueOf(this.field_deleted));
        }
        if (this.fWz) {
            contentValues.put("resType", Integer.valueOf(this.field_resType));
        }
        if (this.__hadSetsubType) {
            contentValues.put("subType", Integer.valueOf(this.field_subType));
        }
        if (this.flE) {
            contentValues.put("reportId", Long.valueOf(this.field_reportId));
        }
        if (this.fWA) {
            contentValues.put("sampleId", this.field_sampleId);
        }
        if (this.fWB) {
            contentValues.put("eccSignature", this.field_eccSignature);
        }
        if (this.fWC) {
            contentValues.put("originalMd5", this.field_originalMd5);
        }
        if (this.fWD) {
            contentValues.put("fileCompress", Boolean.valueOf(this.field_fileCompress));
        }
        if (this.fWE) {
            contentValues.put("fileEncrypt", Boolean.valueOf(this.field_fileEncrypt));
        }
        if (this.fWF) {
            contentValues.put("encryptKey", this.field_encryptKey);
        }
        if (this.fWG) {
            contentValues.put("keyVersion", Integer.valueOf(this.field_keyVersion));
        }
        if (this.fWH) {
            contentValues.put("EID", Integer.valueOf(this.field_EID));
        }
        if (this.fBL) {
            contentValues.put("fileSize", Long.valueOf(this.field_fileSize));
        }
        if (this.fWI) {
            contentValues.put("needRetry", Boolean.valueOf(this.field_needRetry));
        }
        if (this.fjS) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.fWJ) {
            contentValues.put("wvCacheType", Integer.valueOf(this.field_wvCacheType));
        }
        if (this.fWK) {
            contentValues.put("packageId", this.field_packageId);
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
