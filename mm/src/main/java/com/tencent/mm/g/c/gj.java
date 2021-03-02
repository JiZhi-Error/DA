package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class gj extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fZV = "newerIds".hashCode();
    private static final int fZW = "bgId".hashCode();
    private static final int fZX = "bgUrl".hashCode();
    private static final int fZY = "older_bgId".hashCode();
    private static final int fZZ = "local_flag".hashCode();
    private static final int fyf = "md5".hashCode();
    private static final int gaa = "istyle".hashCode();
    private static final int gab = "iFlag".hashCode();
    private static final int gac = "icount".hashCode();
    private static final int gad = "faultS".hashCode();
    private static final int gae = "snsBgId".hashCode();
    private static final int gaf = "snsuser".hashCode();
    private static final int gag = "adsession".hashCode();
    private static final int gah = "lastFirstPageRequestErrCode".hashCode();
    private static final int gai = "lastFirstPageRequestErrType".hashCode();
    private static final int gaj = "snsYearMonthInfo".hashCode();
    private static final int gak = "albumMd5".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private static final int userName_HASHCODE = "userName".hashCode();
    private boolean __hadSetuserName = true;
    private boolean fZF = true;
    private boolean fZG = true;
    private boolean fZH = true;
    private boolean fZI = true;
    private boolean fZJ = true;
    private boolean fZK = true;
    private boolean fZL = true;
    private boolean fZM = true;
    private boolean fZN = true;
    private boolean fZO = true;
    private boolean fZP = true;
    private boolean fZQ = true;
    private boolean fZR = true;
    private boolean fZS = true;
    private boolean fZT = true;
    private boolean fZU = true;
    public byte[] field_adsession;
    public String field_albumMd5;
    public String field_bgId;
    public String field_bgUrl;
    public byte[] field_faultS;
    public int field_iFlag;
    public int field_icount;
    public int field_istyle;
    public int field_lastFirstPageRequestErrCode;
    public int field_lastFirstPageRequestErrType;
    public int field_local_flag;
    public String field_md5;
    public String field_newerIds;
    public String field_older_bgId;
    public long field_snsBgId;
    public byte[] field_snsYearMonthInfo;
    public byte[] field_snsuser;
    public String field_userName;
    private boolean fxt = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (userName_HASHCODE == hashCode) {
                    this.field_userName = cursor.getString(i2);
                    this.__hadSetuserName = true;
                } else if (fyf == hashCode) {
                    this.field_md5 = cursor.getString(i2);
                } else if (fZV == hashCode) {
                    this.field_newerIds = cursor.getString(i2);
                } else if (fZW == hashCode) {
                    this.field_bgId = cursor.getString(i2);
                } else if (fZX == hashCode) {
                    this.field_bgUrl = cursor.getString(i2);
                } else if (fZY == hashCode) {
                    this.field_older_bgId = cursor.getString(i2);
                } else if (fZZ == hashCode) {
                    this.field_local_flag = cursor.getInt(i2);
                } else if (gaa == hashCode) {
                    this.field_istyle = cursor.getInt(i2);
                } else if (gab == hashCode) {
                    this.field_iFlag = cursor.getInt(i2);
                } else if (gac == hashCode) {
                    this.field_icount = cursor.getInt(i2);
                } else if (gad == hashCode) {
                    this.field_faultS = cursor.getBlob(i2);
                } else if (gae == hashCode) {
                    this.field_snsBgId = cursor.getLong(i2);
                } else if (gaf == hashCode) {
                    this.field_snsuser = cursor.getBlob(i2);
                } else if (gag == hashCode) {
                    this.field_adsession = cursor.getBlob(i2);
                } else if (gah == hashCode) {
                    this.field_lastFirstPageRequestErrCode = cursor.getInt(i2);
                } else if (gai == hashCode) {
                    this.field_lastFirstPageRequestErrType = cursor.getInt(i2);
                } else if (gaj == hashCode) {
                    this.field_snsYearMonthInfo = cursor.getBlob(i2);
                } else if (gak == hashCode) {
                    this.field_albumMd5 = cursor.getString(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.field_userName == null) {
            this.field_userName = "";
        }
        if (this.__hadSetuserName) {
            contentValues.put("userName", this.field_userName);
        }
        if (this.fxt) {
            contentValues.put("md5", this.field_md5);
        }
        if (this.fZF) {
            contentValues.put("newerIds", this.field_newerIds);
        }
        if (this.fZG) {
            contentValues.put("bgId", this.field_bgId);
        }
        if (this.fZH) {
            contentValues.put("bgUrl", this.field_bgUrl);
        }
        if (this.fZI) {
            contentValues.put("older_bgId", this.field_older_bgId);
        }
        if (this.fZJ) {
            contentValues.put("local_flag", Integer.valueOf(this.field_local_flag));
        }
        if (this.fZK) {
            contentValues.put("istyle", Integer.valueOf(this.field_istyle));
        }
        if (this.fZL) {
            contentValues.put("iFlag", Integer.valueOf(this.field_iFlag));
        }
        if (this.fZM) {
            contentValues.put("icount", Integer.valueOf(this.field_icount));
        }
        if (this.fZN) {
            contentValues.put("faultS", this.field_faultS);
        }
        if (this.fZO) {
            contentValues.put("snsBgId", Long.valueOf(this.field_snsBgId));
        }
        if (this.fZP) {
            contentValues.put("snsuser", this.field_snsuser);
        }
        if (this.fZQ) {
            contentValues.put("adsession", this.field_adsession);
        }
        if (this.fZR) {
            contentValues.put("lastFirstPageRequestErrCode", Integer.valueOf(this.field_lastFirstPageRequestErrCode));
        }
        if (this.fZS) {
            contentValues.put("lastFirstPageRequestErrType", Integer.valueOf(this.field_lastFirstPageRequestErrType));
        }
        if (this.fZT) {
            contentValues.put("snsYearMonthInfo", this.field_snsYearMonthInfo);
        }
        if (this.fZU) {
            contentValues.put("albumMd5", this.field_albumMd5);
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
