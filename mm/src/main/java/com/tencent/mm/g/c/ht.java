package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.system.MimeTypeUtil;

public abstract class ht extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int createTime_HASHCODE = "createTime".hashCode();
    private static final int fJJ = "nextCheckTime".hashCode();
    private static final int fkj = "appId".hashCode();
    private static final int flv = "version".hashCode();
    private static final int flx = "pkgPath".hashCode();
    private static final int fss = "downloadUrl".hashCode();
    private static final int fyf = "md5".hashCode();
    private static final int ghU = "autoDownloadCount".hashCode();
    private static final int ghj = "pkgId".hashCode();
    private static final int ghm = "pkgSize".hashCode();
    private static final int ghn = "downloadNetType".hashCode();
    private static final int gik = "disableWvCache".hashCode();
    private static final int gil = "clearPkgTime".hashCode();
    private static final int gim = "checkIntervalTime".hashCode();
    private static final int gin = "packMethod".hashCode();
    private static final int gio = "domain".hashCode();
    private static final int gip = "accessTime".hashCode();
    private static final int giq = "charset".hashCode();
    private static final int gir = "bigPackageReady".hashCode();
    private static final int gis = "preloadFilesReady".hashCode();
    private static final int git = "preloadFilesAtomic".hashCode();
    private static final int giu = "disable".hashCode();
    private static final int giv = "totalDownloadCount".hashCode();
    private static final int giw = "packageDownloadCount".hashCode();
    private static final int gix = "downloadTriggerType".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private boolean __hadSetcreateTime = true;
    private boolean fJx = true;
    public long field_accessTime;
    public String field_appId;
    public int field_autoDownloadCount;
    public boolean field_bigPackageReady;
    public String field_charset;
    public long field_checkIntervalTime;
    public long field_clearPkgTime;
    public long field_createTime;
    public boolean field_disable;
    public boolean field_disableWvCache;
    public String field_domain;
    public int field_downloadNetType;
    public int field_downloadTriggerType;
    public String field_downloadUrl;
    public String field_md5;
    public long field_nextCheckTime;
    public int field_packMethod;
    public int field_packageDownloadCount;
    public String field_pkgId;
    public String field_pkgPath;
    public int field_pkgSize;
    public boolean field_preloadFilesAtomic;
    public boolean field_preloadFilesReady;
    public int field_totalDownloadCount;
    public String field_version;
    private boolean fjS = true;
    private boolean flq = true;
    private boolean fls = true;
    private boolean fsk = true;
    private boolean fxt = true;
    private boolean ghP = true;
    private boolean ghW = true;
    private boolean ghX = true;
    private boolean ghY = true;
    private boolean ghZ = true;
    private boolean ghe = true;
    private boolean ghh = true;
    private boolean ghi = true;
    private boolean gia = true;
    private boolean gib = true;
    private boolean gic = true;
    private boolean gid = true;
    private boolean gie = true;
    private boolean gif = true;
    private boolean gig = true;
    private boolean gih = true;
    private boolean gii = true;
    private boolean gij = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (ghj == hashCode) {
                    this.field_pkgId = cursor.getString(i2);
                    this.ghe = true;
                } else if (fkj == hashCode) {
                    this.field_appId = cursor.getString(i2);
                } else if (flv == hashCode) {
                    this.field_version = cursor.getString(i2);
                } else if (flx == hashCode) {
                    this.field_pkgPath = cursor.getString(i2);
                } else if (gik == hashCode) {
                    this.field_disableWvCache = cursor.getInt(i2) != 0;
                } else if (gil == hashCode) {
                    this.field_clearPkgTime = cursor.getLong(i2);
                } else if (gim == hashCode) {
                    this.field_checkIntervalTime = cursor.getLong(i2);
                } else if (gin == hashCode) {
                    this.field_packMethod = cursor.getInt(i2);
                } else if (gio == hashCode) {
                    this.field_domain = cursor.getString(i2);
                } else if (fyf == hashCode) {
                    this.field_md5 = cursor.getString(i2);
                } else if (fss == hashCode) {
                    this.field_downloadUrl = cursor.getString(i2);
                } else if (ghm == hashCode) {
                    this.field_pkgSize = cursor.getInt(i2);
                } else if (ghn == hashCode) {
                    this.field_downloadNetType = cursor.getInt(i2);
                } else if (fJJ == hashCode) {
                    this.field_nextCheckTime = cursor.getLong(i2);
                } else if (createTime_HASHCODE == hashCode) {
                    this.field_createTime = cursor.getLong(i2);
                } else if (gip == hashCode) {
                    this.field_accessTime = cursor.getLong(i2);
                } else if (giq == hashCode) {
                    this.field_charset = cursor.getString(i2);
                } else if (gir == hashCode) {
                    this.field_bigPackageReady = cursor.getInt(i2) != 0;
                } else if (gis == hashCode) {
                    this.field_preloadFilesReady = cursor.getInt(i2) != 0;
                } else if (git == hashCode) {
                    this.field_preloadFilesAtomic = cursor.getInt(i2) != 0;
                } else if (ghU == hashCode) {
                    this.field_autoDownloadCount = cursor.getInt(i2);
                } else if (giu == hashCode) {
                    this.field_disable = cursor.getInt(i2) != 0;
                } else if (giv == hashCode) {
                    this.field_totalDownloadCount = cursor.getInt(i2);
                } else if (giw == hashCode) {
                    this.field_packageDownloadCount = cursor.getInt(i2);
                } else if (gix == hashCode) {
                    this.field_downloadTriggerType = cursor.getInt(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.ghe) {
            contentValues.put("pkgId", this.field_pkgId);
        }
        if (this.fjS) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.flq) {
            contentValues.put("version", this.field_version);
        }
        if (this.fls) {
            contentValues.put("pkgPath", this.field_pkgPath);
        }
        if (this.ghW) {
            contentValues.put("disableWvCache", Boolean.valueOf(this.field_disableWvCache));
        }
        if (this.ghX) {
            contentValues.put("clearPkgTime", Long.valueOf(this.field_clearPkgTime));
        }
        if (this.ghY) {
            contentValues.put("checkIntervalTime", Long.valueOf(this.field_checkIntervalTime));
        }
        if (this.ghZ) {
            contentValues.put("packMethod", Integer.valueOf(this.field_packMethod));
        }
        if (this.gia) {
            contentValues.put("domain", this.field_domain);
        }
        if (this.fxt) {
            contentValues.put("md5", this.field_md5);
        }
        if (this.fsk) {
            contentValues.put("downloadUrl", this.field_downloadUrl);
        }
        if (this.ghh) {
            contentValues.put("pkgSize", Integer.valueOf(this.field_pkgSize));
        }
        if (this.ghi) {
            contentValues.put("downloadNetType", Integer.valueOf(this.field_downloadNetType));
        }
        if (this.fJx) {
            contentValues.put("nextCheckTime", Long.valueOf(this.field_nextCheckTime));
        }
        if (this.__hadSetcreateTime) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.gib) {
            contentValues.put("accessTime", Long.valueOf(this.field_accessTime));
        }
        if (this.field_charset == null) {
            this.field_charset = MimeTypeUtil.ContentType.DEFAULT_CHARSET;
        }
        if (this.gic) {
            contentValues.put("charset", this.field_charset);
        }
        if (this.gid) {
            contentValues.put("bigPackageReady", Boolean.valueOf(this.field_bigPackageReady));
        }
        if (this.gie) {
            contentValues.put("preloadFilesReady", Boolean.valueOf(this.field_preloadFilesReady));
        }
        if (this.gif) {
            contentValues.put("preloadFilesAtomic", Boolean.valueOf(this.field_preloadFilesAtomic));
        }
        if (this.ghP) {
            contentValues.put("autoDownloadCount", Integer.valueOf(this.field_autoDownloadCount));
        }
        if (this.gig) {
            contentValues.put("disable", Boolean.valueOf(this.field_disable));
        }
        if (this.gih) {
            contentValues.put("totalDownloadCount", Integer.valueOf(this.field_totalDownloadCount));
        }
        if (this.gii) {
            contentValues.put("packageDownloadCount", Integer.valueOf(this.field_packageDownloadCount));
        }
        if (this.gij) {
            contentValues.put("downloadTriggerType", Integer.valueOf(this.field_downloadTriggerType));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
