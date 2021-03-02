package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class h extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int createTime_HASHCODE = "createTime".hashCode();
    private static final int fjl = "status".hashCode();
    private static final int fkj = "appId".hashCode();
    private static final int fkk = "sdkVer".hashCode();
    private static final int fkl = "mediaSvrId".hashCode();
    private static final int fkm = "mediaId".hashCode();
    private static final int fkn = "clientAppDataId".hashCode();
    private static final int fko = "totalLen".hashCode();
    private static final int fkp = "offset".hashCode();
    private static final int fkq = "isUpload".hashCode();
    private static final int fkr = "lastModifyTime".hashCode();
    private static final int fks = "fileFullPath".hashCode();
    private static final int fkt = "fullXml".hashCode();
    private static final int fku = "msgInfoId".hashCode();
    private static final int fkv = "netTimes".hashCode();
    private static final int fkw = "isUseCdn".hashCode();
    private static final int fkx = "signature".hashCode();
    private static final int fky = "fakeAeskey".hashCode();
    private static final int fkz = "fakeSignature".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private static final int type_HASHCODE = "type".hashCode();
    private boolean __hadSetcreateTime = true;
    private boolean __hadSettype = true;
    public String field_appId;
    public String field_clientAppDataId;
    public long field_createTime;
    public String field_fakeAeskey;
    public String field_fakeSignature;
    public String field_fileFullPath;
    public String field_fullXml;
    public boolean field_isUpload;
    public int field_isUseCdn;
    public long field_lastModifyTime;
    public String field_mediaId;
    public String field_mediaSvrId;
    public long field_msgInfoId;
    public long field_netTimes;
    public long field_offset;
    public long field_sdkVer;
    public String field_signature;
    public long field_status;
    public long field_totalLen;
    public long field_type;
    private boolean fjS = true;
    private boolean fjT = true;
    private boolean fjU = true;
    private boolean fjV = true;
    private boolean fjW = true;
    private boolean fjX = true;
    private boolean fjY = true;
    private boolean fjZ = true;
    private boolean fji = true;
    private boolean fka = true;
    private boolean fkb = true;
    private boolean fkc = true;
    private boolean fkd = true;
    private boolean fke = true;
    private boolean fkf = true;
    private boolean fkg = true;
    private boolean fkh = true;
    private boolean fki = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fkj == hashCode) {
                    this.field_appId = cursor.getString(i2);
                } else if (fkk == hashCode) {
                    this.field_sdkVer = cursor.getLong(i2);
                } else if (fkl == hashCode) {
                    this.field_mediaSvrId = cursor.getString(i2);
                } else if (fkm == hashCode) {
                    this.field_mediaId = cursor.getString(i2);
                } else if (fkn == hashCode) {
                    this.field_clientAppDataId = cursor.getString(i2);
                } else if (type_HASHCODE == hashCode) {
                    this.field_type = cursor.getLong(i2);
                } else if (fko == hashCode) {
                    this.field_totalLen = cursor.getLong(i2);
                } else if (fkp == hashCode) {
                    this.field_offset = cursor.getLong(i2);
                } else if (fjl == hashCode) {
                    this.field_status = cursor.getLong(i2);
                } else if (fkq == hashCode) {
                    this.field_isUpload = cursor.getInt(i2) != 0;
                } else if (createTime_HASHCODE == hashCode) {
                    this.field_createTime = cursor.getLong(i2);
                } else if (fkr == hashCode) {
                    this.field_lastModifyTime = cursor.getLong(i2);
                } else if (fks == hashCode) {
                    this.field_fileFullPath = cursor.getString(i2);
                } else if (fkt == hashCode) {
                    this.field_fullXml = cursor.getString(i2);
                } else if (fku == hashCode) {
                    this.field_msgInfoId = cursor.getLong(i2);
                } else if (fkv == hashCode) {
                    this.field_netTimes = cursor.getLong(i2);
                } else if (fkw == hashCode) {
                    this.field_isUseCdn = cursor.getInt(i2);
                } else if (fkx == hashCode) {
                    this.field_signature = cursor.getString(i2);
                } else if (fky == hashCode) {
                    this.field_fakeAeskey = cursor.getString(i2);
                } else if (fkz == hashCode) {
                    this.field_fakeSignature = cursor.getString(i2);
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
        if (this.fjT) {
            contentValues.put("sdkVer", Long.valueOf(this.field_sdkVer));
        }
        if (this.fjU) {
            contentValues.put("mediaSvrId", this.field_mediaSvrId);
        }
        if (this.fjV) {
            contentValues.put("mediaId", this.field_mediaId);
        }
        if (this.fjW) {
            contentValues.put("clientAppDataId", this.field_clientAppDataId);
        }
        if (this.__hadSettype) {
            contentValues.put("type", Long.valueOf(this.field_type));
        }
        if (this.fjX) {
            contentValues.put("totalLen", Long.valueOf(this.field_totalLen));
        }
        if (this.fjY) {
            contentValues.put("offset", Long.valueOf(this.field_offset));
        }
        if (this.fji) {
            contentValues.put("status", Long.valueOf(this.field_status));
        }
        if (this.fjZ) {
            contentValues.put("isUpload", Boolean.valueOf(this.field_isUpload));
        }
        if (this.__hadSetcreateTime) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.fka) {
            contentValues.put("lastModifyTime", Long.valueOf(this.field_lastModifyTime));
        }
        if (this.fkb) {
            contentValues.put("fileFullPath", this.field_fileFullPath);
        }
        if (this.fkc) {
            contentValues.put("fullXml", this.field_fullXml);
        }
        if (this.fkd) {
            contentValues.put("msgInfoId", Long.valueOf(this.field_msgInfoId));
        }
        if (this.fke) {
            contentValues.put("netTimes", Long.valueOf(this.field_netTimes));
        }
        if (this.fkf) {
            contentValues.put("isUseCdn", Integer.valueOf(this.field_isUseCdn));
        }
        if (this.fkg) {
            contentValues.put("signature", this.field_signature);
        }
        if (this.fkh) {
            contentValues.put("fakeAeskey", this.field_fakeAeskey);
        }
        if (this.fki) {
            contentValues.put("fakeSignature", this.field_fakeSignature);
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
