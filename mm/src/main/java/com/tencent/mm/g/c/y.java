package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.platformtools.LVBuffer;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore;

public abstract class y extends IAutoDBItem {
    public static final String[] INDEX_CREATE = {"CREATE INDEX IF NOT EXISTS appInfo_status_Index ON AppInfo(status)"};
    private static final int fjl = "status".hashCode();
    private static final int fkR = "appVersion".hashCode();
    private static final int fkj = "appId".hashCode();
    private static final int fkx = "signature".hashCode();
    private static final int fmA = "appSupportContentType".hashCode();
    private static final int fmB = "svrAppSupportContentType".hashCode();
    private static final int fmg = "appName".hashCode();
    private static final int fmh = "appDiscription".hashCode();
    private static final int fmi = "appIconUrl".hashCode();
    private static final int fmj = "appStoreUrl".hashCode();
    private static final int fmk = "appWatermarkUrl".hashCode();
    private static final int fml = AssistantStore.DownloadInfos.DownloadInfoColumns.PACKAGENAME.hashCode();
    private static final int fmm = "modifyTime".hashCode();
    private static final int fmn = "appName_en".hashCode();
    private static final int fmo = "appName_tw".hashCode();
    private static final int fmp = "appName_hk".hashCode();
    private static final int fmq = "appDiscription_en".hashCode();
    private static final int fmr = "appDiscription_tw".hashCode();
    private static final int fms = "appType".hashCode();
    private static final int fmt = "openId".hashCode();
    private static final int fmu = "authFlag".hashCode();
    private static final int fmv = "appInfoFlag".hashCode();
    private static final int fmw = "lvbuff".hashCode();
    private static final int fmx = "serviceAppType".hashCode();
    private static final int fmy = "serviceAppInfoFlag".hashCode();
    private static final int fmz = "serviceShowFlag".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    public String field_appDiscription;
    public String field_appDiscription_en;
    public String field_appDiscription_tw;
    public String field_appIconUrl;
    public String field_appId;
    public int field_appInfoFlag;
    public String field_appName;
    public String field_appName_en;
    public String field_appName_hk;
    public String field_appName_tw;
    public String field_appStoreUrl;
    public long field_appSupportContentType;
    public String field_appType;
    public int field_appVersion;
    public String field_appWatermarkUrl;
    public int field_authFlag;
    public byte[] field_lvbuff;
    public long field_modifyTime;
    public String field_openId;
    public String field_packageName;
    public int field_serviceAppInfoFlag;
    public int field_serviceAppType;
    public int field_serviceShowFlag;
    public String field_signature;
    public int field_status;
    public long field_svrAppSupportContentType;
    private boolean fjS = true;
    private boolean fji = true;
    private boolean fkN = true;
    private boolean fkg = true;
    private boolean flK = true;
    private boolean flL = true;
    private boolean flM = true;
    private boolean flN = true;
    private boolean flO = true;
    private boolean flP = true;
    private boolean flQ = true;
    private boolean flR = true;
    private boolean flS = true;
    private boolean flT = true;
    private boolean flU = true;
    private boolean flV = true;
    private boolean flW = true;
    private boolean flX = true;
    private boolean flY = true;
    private boolean flZ = true;
    protected String fmC;
    private String fmD;
    public String fmE;
    public int fmF;
    public int fmG;
    public String fmH;
    public String fmI;
    public String fmJ;
    public String fmK;
    public String fmL;
    public String fmM;
    public int fmN;
    public String fmO;
    public String fmP;
    public String fmQ;
    public String fmR;
    private String fmS;
    public int fmT;
    private String fmU;
    private int fmV;
    public String fmW;
    public String fmX;
    public String fmY;
    public int fmZ;
    public boolean fma = true;
    private boolean fmb = true;
    private boolean fmc = true;
    private boolean fmd = true;
    private boolean fme = true;
    private boolean fmf = true;

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
                } else if (fmg == hashCode) {
                    this.field_appName = cursor.getString(i2);
                } else if (fmh == hashCode) {
                    this.field_appDiscription = cursor.getString(i2);
                } else if (fmi == hashCode) {
                    this.field_appIconUrl = cursor.getString(i2);
                } else if (fmj == hashCode) {
                    this.field_appStoreUrl = cursor.getString(i2);
                } else if (fkR == hashCode) {
                    this.field_appVersion = cursor.getInt(i2);
                } else if (fmk == hashCode) {
                    this.field_appWatermarkUrl = cursor.getString(i2);
                } else if (fml == hashCode) {
                    this.field_packageName = cursor.getString(i2);
                } else if (fjl == hashCode) {
                    this.field_status = cursor.getInt(i2);
                } else if (fkx == hashCode) {
                    this.field_signature = cursor.getString(i2);
                } else if (fmm == hashCode) {
                    this.field_modifyTime = cursor.getLong(i2);
                } else if (fmn == hashCode) {
                    this.field_appName_en = cursor.getString(i2);
                } else if (fmo == hashCode) {
                    this.field_appName_tw = cursor.getString(i2);
                } else if (fmp == hashCode) {
                    this.field_appName_hk = cursor.getString(i2);
                } else if (fmq == hashCode) {
                    this.field_appDiscription_en = cursor.getString(i2);
                } else if (fmr == hashCode) {
                    this.field_appDiscription_tw = cursor.getString(i2);
                } else if (fms == hashCode) {
                    this.field_appType = cursor.getString(i2);
                } else if (fmt == hashCode) {
                    this.field_openId = cursor.getString(i2);
                } else if (fmu == hashCode) {
                    this.field_authFlag = cursor.getInt(i2);
                } else if (fmv == hashCode) {
                    this.field_appInfoFlag = cursor.getInt(i2);
                } else if (fmw == hashCode) {
                    this.field_lvbuff = cursor.getBlob(i2);
                } else if (fmx == hashCode) {
                    this.field_serviceAppType = cursor.getInt(i2);
                } else if (fmy == hashCode) {
                    this.field_serviceAppInfoFlag = cursor.getInt(i2);
                } else if (fmz == hashCode) {
                    this.field_serviceShowFlag = cursor.getInt(i2);
                } else if (fmA == hashCode) {
                    this.field_appSupportContentType = cursor.getLong(i2);
                } else if (fmB == hashCode) {
                    this.field_svrAppSupportContentType = cursor.getLong(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
            try {
                if (!(this.field_lvbuff == null || this.field_lvbuff.length == 0)) {
                    LVBuffer lVBuffer = new LVBuffer();
                    int initParse = lVBuffer.initParse(this.field_lvbuff);
                    if (initParse != 0) {
                        Log.e("MicroMsg.SDK.BaseAppInfo", "parse LVBuffer error:".concat(String.valueOf(initParse)));
                        return;
                    }
                    this.fmC = lVBuffer.getString();
                    this.fmD = lVBuffer.getString();
                    this.fmE = lVBuffer.getString();
                    this.fmF = lVBuffer.getInt();
                    this.fmG = lVBuffer.getInt();
                    this.fmH = lVBuffer.getString();
                    this.fmI = lVBuffer.getString();
                    this.fmJ = lVBuffer.getString();
                    this.fmK = lVBuffer.getString();
                    if (!lVBuffer.checkGetFinish()) {
                        this.fmL = lVBuffer.getString();
                    }
                    if (!lVBuffer.checkGetFinish()) {
                        this.fmM = lVBuffer.getString();
                    }
                    if (!lVBuffer.checkGetFinish()) {
                        this.fmN = lVBuffer.getInt();
                    }
                    if (!lVBuffer.checkGetFinish()) {
                        this.fmO = lVBuffer.getString();
                    }
                    if (!lVBuffer.checkGetFinish()) {
                        this.fmP = lVBuffer.getString();
                    }
                    if (!lVBuffer.checkGetFinish()) {
                        this.fmQ = lVBuffer.getString();
                    }
                    if (!lVBuffer.checkGetFinish()) {
                        this.fmR = lVBuffer.getString();
                    }
                    if (!lVBuffer.checkGetFinish()) {
                        this.fmS = lVBuffer.getString();
                    }
                    if (!lVBuffer.checkGetFinish()) {
                        this.fmT = lVBuffer.getInt();
                    }
                    if (!lVBuffer.checkGetFinish()) {
                        this.fmU = lVBuffer.getString();
                    }
                    if (!lVBuffer.checkGetFinish()) {
                        this.fmV = lVBuffer.getInt();
                    }
                    if (!lVBuffer.checkGetFinish()) {
                        this.fmW = lVBuffer.getString();
                    }
                    if (!lVBuffer.checkGetFinish()) {
                        this.fmX = lVBuffer.getString();
                    }
                    if (!lVBuffer.checkGetFinish()) {
                        this.fmY = lVBuffer.getString();
                    }
                    if (!lVBuffer.checkGetFinish()) {
                        this.fmZ = lVBuffer.getInt();
                    }
                }
            } catch (Exception e2) {
                Log.e("MicroMsg.SDK.BaseAppInfo", "get value failed");
            }
        }
    }

    public final void Bk(String str) {
        this.fmD = str;
        this.fma = true;
    }

    public final String ajt() {
        return this.fmE;
    }

    public final void Bl(String str) {
        this.fmE = str;
        this.fma = true;
    }

    public final void Bm(String str) {
        this.fmH = str;
        this.fma = true;
    }

    public final void Bn(String str) {
        this.fmI = str;
        this.fma = true;
    }

    public final String aju() {
        return this.fmJ;
    }

    public final void Bo(String str) {
        this.fmJ = str;
        this.fma = true;
    }

    public final String ajv() {
        return this.fmK;
    }

    public final void Bp(String str) {
        this.fmK = str;
        this.fma = true;
    }

    public final void Bq(String str) {
        this.fmL = str;
        this.fma = true;
    }

    public final void Br(String str) {
        this.fmM = str;
        this.fma = true;
    }

    public final void mZ(int i2) {
        this.fmN = i2;
        this.fma = true;
    }

    public final void Bs(String str) {
        this.fmO = str;
        this.fma = true;
    }

    public final void Bt(String str) {
        this.fmP = str;
        this.fma = true;
    }

    public final void Bu(String str) {
        this.fmQ = str;
        this.fma = true;
    }

    public final void Bv(String str) {
        this.fmR = str;
        this.fma = true;
    }

    public final void Bw(String str) {
        this.fmS = str;
        this.fma = true;
    }

    public final void na(int i2) {
        this.fmT = i2;
        this.fma = true;
    }

    public final void Bx(String str) {
        this.fmU = str;
        this.fma = true;
    }

    public final void By(String str) {
        this.fmW = str;
        this.fma = true;
    }

    public final void Bz(String str) {
        this.fmX = str;
        this.fma = true;
    }

    public final void BA(String str) {
        this.fmY = str;
        this.fma = true;
    }

    public final void nb(int i2) {
        this.fmZ = i2;
        this.fma = true;
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        try {
            if (this.fma) {
                LVBuffer lVBuffer = new LVBuffer();
                lVBuffer.initBuild();
                lVBuffer.putString(this.fmC);
                lVBuffer.putString(this.fmD);
                lVBuffer.putString(this.fmE);
                lVBuffer.putInt(this.fmF);
                lVBuffer.putInt(this.fmG);
                lVBuffer.putString(this.fmH);
                lVBuffer.putString(this.fmI);
                lVBuffer.putString(this.fmJ);
                lVBuffer.putString(this.fmK);
                lVBuffer.putString(this.fmL);
                lVBuffer.putString(this.fmM);
                lVBuffer.putInt(this.fmN);
                lVBuffer.putString(this.fmO);
                lVBuffer.putString(this.fmP);
                lVBuffer.putString(this.fmQ);
                lVBuffer.putString(this.fmR);
                lVBuffer.putString(this.fmS);
                lVBuffer.putInt(this.fmT);
                lVBuffer.putString(this.fmU);
                lVBuffer.putInt(this.fmV);
                lVBuffer.putString(this.fmW);
                lVBuffer.putString(this.fmX);
                lVBuffer.putString(this.fmY);
                lVBuffer.putInt(this.fmZ);
                this.field_lvbuff = lVBuffer.buildFinish();
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.SDK.BaseAppInfo", "get value failed, %s", e2.getMessage());
        }
        ContentValues contentValues = new ContentValues();
        if (this.field_appId == null) {
            this.field_appId = "";
        }
        if (this.fjS) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.flK) {
            contentValues.put("appName", this.field_appName);
        }
        if (this.flL) {
            contentValues.put("appDiscription", this.field_appDiscription);
        }
        if (this.flM) {
            contentValues.put("appIconUrl", this.field_appIconUrl);
        }
        if (this.flN) {
            contentValues.put("appStoreUrl", this.field_appStoreUrl);
        }
        if (this.fkN) {
            contentValues.put("appVersion", Integer.valueOf(this.field_appVersion));
        }
        if (this.flO) {
            contentValues.put("appWatermarkUrl", this.field_appWatermarkUrl);
        }
        if (this.flP) {
            contentValues.put(AssistantStore.DownloadInfos.DownloadInfoColumns.PACKAGENAME, this.field_packageName);
        }
        if (this.fji) {
            contentValues.put("status", Integer.valueOf(this.field_status));
        }
        if (this.fkg) {
            contentValues.put("signature", this.field_signature);
        }
        if (this.flQ) {
            contentValues.put("modifyTime", Long.valueOf(this.field_modifyTime));
        }
        if (this.flR) {
            contentValues.put("appName_en", this.field_appName_en);
        }
        if (this.flS) {
            contentValues.put("appName_tw", this.field_appName_tw);
        }
        if (this.flT) {
            contentValues.put("appName_hk", this.field_appName_hk);
        }
        if (this.flU) {
            contentValues.put("appDiscription_en", this.field_appDiscription_en);
        }
        if (this.flV) {
            contentValues.put("appDiscription_tw", this.field_appDiscription_tw);
        }
        if (this.flW) {
            contentValues.put("appType", this.field_appType);
        }
        if (this.flX) {
            contentValues.put("openId", this.field_openId);
        }
        if (this.flY) {
            contentValues.put("authFlag", Integer.valueOf(this.field_authFlag));
        }
        if (this.flZ) {
            contentValues.put("appInfoFlag", Integer.valueOf(this.field_appInfoFlag));
        }
        if (this.fma) {
            contentValues.put("lvbuff", this.field_lvbuff);
        }
        if (this.fmb) {
            contentValues.put("serviceAppType", Integer.valueOf(this.field_serviceAppType));
        }
        if (this.fmc) {
            contentValues.put("serviceAppInfoFlag", Integer.valueOf(this.field_serviceAppInfoFlag));
        }
        if (this.fmd) {
            contentValues.put("serviceShowFlag", Integer.valueOf(this.field_serviceShowFlag));
        }
        if (this.fme) {
            contentValues.put("appSupportContentType", Long.valueOf(this.field_appSupportContentType));
        }
        if (this.fmf) {
            contentValues.put("svrAppSupportContentType", Long.valueOf(this.field_svrAppSupportContentType));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
