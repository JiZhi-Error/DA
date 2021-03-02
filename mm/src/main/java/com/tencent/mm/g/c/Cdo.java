package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.platformtools.LVBuffer;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyEnum;

/* renamed from: com.tencent.mm.g.c.do  reason: invalid class name */
public abstract class Cdo extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fHb = TPDownloadProxyEnum.USER_MAC.hashCode();
    private static final int fLM = "deviceID".hashCode();
    private static final int fLN = "brandName".hashCode();
    private static final int fLO = "deviceType".hashCode();
    private static final int fLP = "connProto".hashCode();
    private static final int fLQ = "connStrategy".hashCode();
    private static final int fLR = "closeStrategy".hashCode();
    private static final int fLS = "md5Str".hashCode();
    private static final int fLT = "authKey".hashCode();
    private static final int fLU = "sessionKey".hashCode();
    private static final int fLV = "sessionBuf".hashCode();
    private static final int fLW = "authBuf".hashCode();
    private static final int fnB = "url".hashCode();
    private static final int fqy = "lvbuffer".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    public String category;
    private boolean fGQ = true;
    private boolean fLB = true;
    private boolean fLC = true;
    private boolean fLD = true;
    private boolean fLE = true;
    private boolean fLF = true;
    private boolean fLG = true;
    private boolean fLH = true;
    private boolean fLI = true;
    private boolean fLJ = true;
    private boolean fLK = true;
    private boolean fLL = true;
    public int fLX;
    public int fLY;
    public long fLZ;
    private long fMa;
    public String fMb;
    public String fMc;
    public String fMd;
    private int fMe;
    public int fMf;
    public long fMg;
    public String fMh;
    public String fMi;
    private String fMj;
    public String fMk;
    public byte[] field_authBuf;
    public String field_authKey;
    public String field_brandName;
    public int field_closeStrategy;
    public String field_connProto;
    public int field_connStrategy;
    public String field_deviceID;
    public String field_deviceType;
    public byte[] field_lvbuffer;
    public long field_mac;
    public String field_md5Str;
    public byte[] field_sessionBuf;
    public byte[] field_sessionKey;
    public String field_url;
    private boolean fnx = true;
    public boolean fqk = true;
    public String iconUrl;
    public String jumpUrl;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fLM == hashCode) {
                    this.field_deviceID = cursor.getString(i2);
                    this.fLB = true;
                } else if (fLN == hashCode) {
                    this.field_brandName = cursor.getString(i2);
                } else if (fHb == hashCode) {
                    this.field_mac = cursor.getLong(i2);
                } else if (fLO == hashCode) {
                    this.field_deviceType = cursor.getString(i2);
                } else if (fLP == hashCode) {
                    this.field_connProto = cursor.getString(i2);
                } else if (fLQ == hashCode) {
                    this.field_connStrategy = cursor.getInt(i2);
                } else if (fLR == hashCode) {
                    this.field_closeStrategy = cursor.getInt(i2);
                } else if (fLS == hashCode) {
                    this.field_md5Str = cursor.getString(i2);
                } else if (fLT == hashCode) {
                    this.field_authKey = cursor.getString(i2);
                } else if (fnB == hashCode) {
                    this.field_url = cursor.getString(i2);
                } else if (fLU == hashCode) {
                    this.field_sessionKey = cursor.getBlob(i2);
                } else if (fLV == hashCode) {
                    this.field_sessionBuf = cursor.getBlob(i2);
                } else if (fLW == hashCode) {
                    this.field_authBuf = cursor.getBlob(i2);
                } else if (fqy == hashCode) {
                    this.field_lvbuffer = cursor.getBlob(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
            try {
                if (!(this.field_lvbuffer == null || this.field_lvbuffer.length == 0)) {
                    LVBuffer lVBuffer = new LVBuffer();
                    int initParse = lVBuffer.initParse(this.field_lvbuffer);
                    if (initParse != 0) {
                        Log.e("MicroMsg.SDK.BaseHardDeviceInfo", "parse LVBuffer error:".concat(String.valueOf(initParse)));
                        return;
                    }
                    if (!lVBuffer.checkGetFinish()) {
                        this.fLX = lVBuffer.getInt();
                    }
                    if (!lVBuffer.checkGetFinish()) {
                        this.fLY = lVBuffer.getInt();
                    }
                    if (!lVBuffer.checkGetFinish()) {
                        this.fLZ = lVBuffer.getLong();
                    }
                    if (!lVBuffer.checkGetFinish()) {
                        this.fMa = lVBuffer.getLong();
                    }
                    if (!lVBuffer.checkGetFinish()) {
                        this.fMb = lVBuffer.getString();
                    }
                    if (!lVBuffer.checkGetFinish()) {
                        this.iconUrl = lVBuffer.getString();
                    }
                    if (!lVBuffer.checkGetFinish()) {
                        this.jumpUrl = lVBuffer.getString();
                    }
                    if (!lVBuffer.checkGetFinish()) {
                        this.fMc = lVBuffer.getString();
                    }
                    if (!lVBuffer.checkGetFinish()) {
                        this.fMd = lVBuffer.getString();
                    }
                    if (!lVBuffer.checkGetFinish()) {
                        this.category = lVBuffer.getString();
                    }
                    if (!lVBuffer.checkGetFinish()) {
                        this.fMe = lVBuffer.getInt();
                    }
                    if (!lVBuffer.checkGetFinish()) {
                        this.fMf = lVBuffer.getInt();
                    }
                    if (!lVBuffer.checkGetFinish()) {
                        this.fMg = lVBuffer.getLong();
                    }
                    if (!lVBuffer.checkGetFinish()) {
                        this.fMh = lVBuffer.getString();
                    }
                    if (!lVBuffer.checkGetFinish()) {
                        this.fMi = lVBuffer.getString();
                    }
                    if (!lVBuffer.checkGetFinish()) {
                        this.fMj = lVBuffer.getString();
                    }
                    if (!lVBuffer.checkGetFinish()) {
                        this.fMk = lVBuffer.getString();
                    }
                }
            } catch (Exception e2) {
                Log.e("MicroMsg.SDK.BaseHardDeviceInfo", "get value failed");
            }
        }
    }

    public final void BC(String str) {
        this.fMb = str;
        this.fqk = true;
    }

    public final void setIconUrl(String str) {
        this.iconUrl = str;
        this.fqk = true;
    }

    public final void Cq(String str) {
        this.jumpUrl = str;
        this.fqk = true;
    }

    public final void Cr(String str) {
        this.fMc = str;
        this.fqk = true;
    }

    public final void Cs(String str) {
        this.fMd = str;
        this.fqk = true;
    }

    public final void Ct(String str) {
        this.category = str;
        this.fqk = true;
    }

    public final void nE(int i2) {
        this.fMe = i2;
        this.fqk = true;
    }

    public final void nF(int i2) {
        this.fMf = i2;
        this.fqk = true;
    }

    public final void yE(long j2) {
        this.fMg = j2;
        this.fqk = true;
    }

    public final void Cu(String str) {
        this.fMh = str;
        this.fqk = true;
    }

    public final void Cv(String str) {
        this.fMi = str;
        this.fqk = true;
    }

    public final void Cw(String str) {
        this.fMj = str;
        this.fqk = true;
    }

    public final void Cx(String str) {
        this.fMk = str;
        this.fqk = true;
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        try {
            if (this.fqk) {
                LVBuffer lVBuffer = new LVBuffer();
                lVBuffer.initBuild();
                lVBuffer.putInt(this.fLX);
                lVBuffer.putInt(this.fLY);
                lVBuffer.putLong(this.fLZ);
                lVBuffer.putLong(this.fMa);
                lVBuffer.putString(this.fMb);
                lVBuffer.putString(this.iconUrl);
                lVBuffer.putString(this.jumpUrl);
                lVBuffer.putString(this.fMc);
                lVBuffer.putString(this.fMd);
                lVBuffer.putString(this.category);
                lVBuffer.putInt(this.fMe);
                lVBuffer.putInt(this.fMf);
                lVBuffer.putLong(this.fMg);
                lVBuffer.putString(this.fMh);
                lVBuffer.putString(this.fMi);
                lVBuffer.putString(this.fMj);
                lVBuffer.putString(this.fMk);
                this.field_lvbuffer = lVBuffer.buildFinish();
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.SDK.BaseHardDeviceInfo", "get value failed, %s", e2.getMessage());
        }
        ContentValues contentValues = new ContentValues();
        if (this.fLB) {
            contentValues.put("deviceID", this.field_deviceID);
        }
        if (this.fLC) {
            contentValues.put("brandName", this.field_brandName);
        }
        if (this.fGQ) {
            contentValues.put(TPDownloadProxyEnum.USER_MAC, Long.valueOf(this.field_mac));
        }
        if (this.fLD) {
            contentValues.put("deviceType", this.field_deviceType);
        }
        if (this.fLE) {
            contentValues.put("connProto", this.field_connProto);
        }
        if (this.fLF) {
            contentValues.put("connStrategy", Integer.valueOf(this.field_connStrategy));
        }
        if (this.fLG) {
            contentValues.put("closeStrategy", Integer.valueOf(this.field_closeStrategy));
        }
        if (this.fLH) {
            contentValues.put("md5Str", this.field_md5Str);
        }
        if (this.fLI) {
            contentValues.put("authKey", this.field_authKey);
        }
        if (this.fnx) {
            contentValues.put("url", this.field_url);
        }
        if (this.fLJ) {
            contentValues.put("sessionKey", this.field_sessionKey);
        }
        if (this.fLK) {
            contentValues.put("sessionBuf", this.field_sessionBuf);
        }
        if (this.fLL) {
            contentValues.put("authBuf", this.field_authBuf);
        }
        if (this.fqk) {
            contentValues.put("lvbuffer", this.field_lvbuffer);
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
