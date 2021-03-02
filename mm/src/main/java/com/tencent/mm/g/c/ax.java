package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.platformtools.LVBuffer;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class ax extends IAutoDBItem {
    public static final String[] INDEX_CREATE = {"CREATE INDEX IF NOT EXISTS deleteflag_index ON Contact(deleteFlag)"};
    private static final int fjR = "ticket".hashCode();
    private static final int fmw = "lvbuff".hashCode();
    private static final int fqf = "nickname".hashCode();
    private static final int fuh = "alias".hashCode();
    private static final int fui = "conRemark".hashCode();
    private static final int fuj = "domainList".hashCode();
    private static final int fuk = "pyInitial".hashCode();
    private static final int ful = "quanPin".hashCode();
    private static final int fum = "showHead".hashCode();
    private static final int fun = "weiboFlag".hashCode();
    private static final int fuo = "weiboNickname".hashCode();
    private static final int fup = "conRemarkPYFull".hashCode();
    private static final int fuq = "conRemarkPYShort".hashCode();
    private static final int fur = "verifyFlag".hashCode();
    private static final int fus = "encryptUsername".hashCode();
    private static final int fut = "chatroomFlag".hashCode();
    private static final int fuu = "deleteFlag".hashCode();
    private static final int fuv = "contactLabelIds".hashCode();
    private static final int fuw = "descWordingId".hashCode();
    private static final int fux = "openImAppid".hashCode();
    private static final int fuy = "sourceExtInfo".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private static final int type_HASHCODE = "type".hashCode();
    private static final int username_HASHCODE = ch.COL_USERNAME.hashCode();
    private boolean __hadSettype = false;
    private boolean __hadSetusername = false;
    public String dSf;
    private int extFlag;
    private String field_alias;
    protected int field_chatroomFlag;
    public String field_conRemark;
    public String field_conRemarkPYFull;
    public String field_conRemarkPYShort;
    public String field_contactLabelIds;
    public int field_deleteFlag;
    public String field_descWordingId;
    public String field_domainList;
    public String field_encryptUsername;
    protected byte[] field_lvbuff;
    public String field_nickname;
    public String field_openImAppid;
    private String field_pyInitial;
    private String field_quanPin;
    public int field_showHead;
    public String field_sourceExtInfo;
    public String field_ticket;
    public int field_type;
    public String field_username;
    public int field_verifyFlag;
    public int field_weiboFlag;
    public String field_weiboNickname;
    private boolean fjP = false;
    private boolean fma = false;
    private boolean fqb = false;
    protected int fromType;
    private boolean ftP = false;
    private boolean ftQ = false;
    private boolean ftR = false;
    private boolean ftS = false;
    private boolean ftT = false;
    private boolean ftU = false;
    private boolean ftV = false;
    private boolean ftW = false;
    private boolean ftX = false;
    private boolean ftY = false;
    private boolean ftZ = false;
    public int fuA;
    public String fuB;
    protected long fuC;
    protected String fuD;
    public int fuE;
    protected String fuF;
    protected String fuG;
    public int fuH;
    public int fuI;
    private String fuJ;
    private String fuK;
    public String fuL;
    public String fuM;
    public String fuN;
    public String fuO;
    public int fuP;
    public int fuQ;
    public String fuR;
    public String fuS;
    public String fuT;
    public String fuU;
    public String fuV;
    public String fuW;
    public String fuX;
    public String fuY;
    private String fuZ;
    private boolean fua = false;
    private boolean fub = false;
    private boolean fuc = false;
    private boolean fud = false;
    private boolean fue = false;
    private boolean fuf = false;
    private boolean fug = false;
    public int fuz;
    public int fva;
    public String fvb;
    public int fvc;
    public long fvd;
    public long fve;
    protected int showFlag;
    public String signature;
    private int source;
    public int uin;

    public void setUsername(String str) {
        this.field_username = str;
        this.__hadSetusername = true;
    }

    public final String getUsername() {
        return this.field_username;
    }

    public void BC(String str) {
        this.field_alias = str;
        this.ftP = true;
    }

    public String ajx() {
        return this.field_alias;
    }

    public void BD(String str) {
        this.field_conRemark = str;
        this.ftQ = true;
    }

    public final String ajy() {
        return this.field_conRemark;
    }

    public void BE(String str) {
        this.field_domainList = str;
        this.ftR = true;
    }

    public void setNickname(String str) {
        this.field_nickname = str;
        this.fqb = true;
    }

    public final String getNickname() {
        return this.field_nickname;
    }

    public void BF(String str) {
        this.field_pyInitial = str;
        this.ftS = true;
    }

    public String ajz() {
        return this.field_pyInitial;
    }

    public void BG(String str) {
        this.field_quanPin = str;
        this.ftT = true;
    }

    public String ajA() {
        return this.field_quanPin;
    }

    public void nd(int i2) {
        this.field_showHead = i2;
        this.ftU = true;
    }

    public void setType(int i2) {
        this.field_type = i2;
        this.__hadSettype = true;
    }

    public void ne(int i2) {
        this.field_weiboFlag = i2;
        this.ftV = true;
    }

    public void BH(String str) {
        this.field_weiboNickname = str;
        this.ftW = true;
    }

    public void BI(String str) {
        this.field_conRemarkPYFull = str;
        this.ftX = true;
    }

    public void BJ(String str) {
        this.field_conRemarkPYShort = str;
        this.ftY = true;
    }

    public void Z(byte[] bArr) {
        this.field_lvbuff = bArr;
        this.fma = true;
    }

    public void nf(int i2) {
        this.field_verifyFlag = i2;
        this.ftZ = true;
    }

    public void BK(String str) {
        this.field_encryptUsername = str;
        this.fua = true;
    }

    public final String ajB() {
        return this.field_encryptUsername;
    }

    public void ng(int i2) {
        this.field_chatroomFlag = i2;
        this.fub = true;
    }

    public void nh(int i2) {
        this.field_deleteFlag = i2;
        this.fuc = true;
    }

    public final int aFQ() {
        return this.field_deleteFlag;
    }

    public void BL(String str) {
        this.field_contactLabelIds = str;
        this.fud = true;
    }

    public final void BM(String str) {
        this.field_descWordingId = str;
        this.fue = true;
    }

    public final String ajC() {
        return this.field_descWordingId;
    }

    public void BN(String str) {
        this.field_openImAppid = str;
        this.fuf = true;
    }

    public final String ajD() {
        return this.field_openImAppid;
    }

    public void BO(String str) {
        this.field_sourceExtInfo = str;
        this.fug = true;
    }

    public void BP(String str) {
        this.field_ticket = str;
        this.fjP = true;
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (username_HASHCODE == hashCode) {
                    this.field_username = cursor.getString(i2);
                    this.__hadSetusername = true;
                } else if (fuh == hashCode) {
                    this.field_alias = cursor.getString(i2);
                } else if (fui == hashCode) {
                    this.field_conRemark = cursor.getString(i2);
                } else if (fuj == hashCode) {
                    this.field_domainList = cursor.getString(i2);
                } else if (fqf == hashCode) {
                    this.field_nickname = cursor.getString(i2);
                } else if (fuk == hashCode) {
                    this.field_pyInitial = cursor.getString(i2);
                } else if (ful == hashCode) {
                    this.field_quanPin = cursor.getString(i2);
                } else if (fum == hashCode) {
                    this.field_showHead = cursor.getInt(i2);
                } else if (type_HASHCODE == hashCode) {
                    this.field_type = cursor.getInt(i2);
                } else if (fun == hashCode) {
                    this.field_weiboFlag = cursor.getInt(i2);
                } else if (fuo == hashCode) {
                    this.field_weiboNickname = cursor.getString(i2);
                } else if (fup == hashCode) {
                    this.field_conRemarkPYFull = cursor.getString(i2);
                } else if (fuq == hashCode) {
                    this.field_conRemarkPYShort = cursor.getString(i2);
                } else if (fmw == hashCode) {
                    this.field_lvbuff = cursor.getBlob(i2);
                } else if (fur == hashCode) {
                    this.field_verifyFlag = cursor.getInt(i2);
                } else if (fus == hashCode) {
                    this.field_encryptUsername = cursor.getString(i2);
                } else if (fut == hashCode) {
                    this.field_chatroomFlag = cursor.getInt(i2);
                } else if (fuu == hashCode) {
                    this.field_deleteFlag = cursor.getInt(i2);
                } else if (fuv == hashCode) {
                    this.field_contactLabelIds = cursor.getString(i2);
                } else if (fuw == hashCode) {
                    this.field_descWordingId = cursor.getString(i2);
                } else if (fux == hashCode) {
                    this.field_openImAppid = cursor.getString(i2);
                } else if (fuy == hashCode) {
                    this.field_sourceExtInfo = cursor.getString(i2);
                } else if (fjR == hashCode) {
                    this.field_ticket = cursor.getString(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
            parseBuff();
        }
    }

    public void ni(int i2) {
        this.fuz = i2;
        this.fma = true;
    }

    public final int ajE() {
        return this.fuA;
    }

    public void nj(int i2) {
        this.fuA = i2;
        this.fma = true;
    }

    public void BQ(String str) {
        this.fuB = str;
        this.fma = true;
    }

    public void yx(long j2) {
        this.fuC = j2;
        this.fma = true;
    }

    public void setUin(int i2) {
        this.uin = i2;
        this.fma = true;
    }

    public void BR(String str) {
        this.fuD = str;
        this.fma = true;
    }

    public void BS(String str) {
        this.dSf = str;
        this.fma = true;
    }

    public void nk(int i2) {
        this.showFlag = i2;
        this.fma = true;
    }

    public void nl(int i2) {
        this.fuE = i2;
        this.fma = true;
    }

    public void BT(String str) {
        this.fuF = str;
        this.fma = true;
    }

    public void BU(String str) {
        this.fuG = str;
        this.fma = true;
    }

    public void nm(int i2) {
        this.fuH = i2;
        this.fma = true;
    }

    public void nn(int i2) {
        this.fuI = i2;
        this.fma = true;
    }

    public final String getSignature() {
        return this.signature;
    }

    public void BV(String str) {
        this.signature = str;
        this.fma = true;
    }

    public String getProvince() {
        return this.fuJ;
    }

    public void BW(String str) {
        this.fuJ = str;
        this.fma = true;
    }

    public String getCity() {
        return this.fuK;
    }

    public void BX(String str) {
        this.fuK = str;
        this.fma = true;
    }

    public void BY(String str) {
        this.fuL = str;
        this.fma = true;
    }

    public final int getFromType() {
        return this.fromType;
    }

    public void setFromType(int i2) {
        this.fromType = i2;
        this.fma = true;
    }

    public int getSource() {
        return this.source;
    }

    public void setSource(int i2) {
        this.source = i2;
        this.fma = true;
    }

    public void BZ(String str) {
        this.fuM = str;
        this.fma = true;
    }

    public void Ca(String str) {
        this.fuN = str;
        this.fma = true;
    }

    public void Cb(String str) {
        this.fuO = str;
        this.fma = true;
    }

    public void no(int i2) {
        this.fuP = i2;
        this.fma = true;
    }

    public void np(int i2) {
        this.fuQ = i2;
        this.fma = true;
    }

    public void Cc(String str) {
        this.fuR = str;
        this.fma = true;
    }

    public void Cd(String str) {
        this.fuS = str;
        this.fma = true;
    }

    public void Ce(String str) {
        this.fuT = str;
        this.fma = true;
    }

    public void Cf(String str) {
        this.fuU = str;
        this.fma = true;
    }

    public void Cg(String str) {
        this.fuV = str;
        this.fma = true;
    }

    public void Ch(String str) {
        this.fuW = str;
        this.fma = true;
    }

    public void Ci(String str) {
        this.fuX = str;
        this.fma = true;
    }

    public void Cj(String str) {
        this.fuY = str;
        this.fma = true;
    }

    public final void nq(int i2) {
        this.extFlag = i2;
        this.fma = true;
    }

    public final void nr(int i2) {
        this.fva = i2;
        this.fma = true;
    }

    public final void Ck(String str) {
        this.fvb = str;
        this.fma = true;
    }

    public final void ajF() {
        this.fvc = 1;
        this.fma = true;
    }

    public void yy(long j2) {
        this.fvd = j2;
        this.fma = true;
    }

    public void yz(long j2) {
        this.fve = j2;
        this.fma = true;
    }

    public final void parseBuff() {
        try {
            if (this.field_lvbuff != null && this.field_lvbuff.length != 0) {
                LVBuffer lVBuffer = new LVBuffer();
                int initParse = lVBuffer.initParse(this.field_lvbuff);
                if (initParse != 0) {
                    Log.e("MicroMsg.SDK.BaseContact", "parse LVBuffer error:".concat(String.valueOf(initParse)));
                    return;
                }
                this.fuz = lVBuffer.getInt();
                this.fuA = lVBuffer.getInt();
                this.fuB = lVBuffer.getString();
                this.fuC = lVBuffer.getLong();
                this.uin = lVBuffer.getInt();
                this.fuD = lVBuffer.getString();
                this.dSf = lVBuffer.getString();
                this.showFlag = lVBuffer.getInt();
                this.fuE = lVBuffer.getInt();
                this.fuF = lVBuffer.getString();
                this.fuG = lVBuffer.getString();
                this.fuH = lVBuffer.getInt();
                this.fuI = lVBuffer.getInt();
                this.signature = lVBuffer.getString();
                this.fuJ = lVBuffer.getString();
                this.fuK = lVBuffer.getString();
                this.fuL = lVBuffer.getString();
                this.fromType = lVBuffer.getInt();
                this.source = lVBuffer.getInt();
                this.fuM = lVBuffer.getString();
                this.field_verifyFlag = lVBuffer.getInt();
                this.fuN = lVBuffer.getString();
                if (!lVBuffer.checkGetFinish()) {
                    this.fuO = lVBuffer.getString();
                }
                if (!lVBuffer.checkGetFinish()) {
                    this.fuP = lVBuffer.getInt();
                }
                if (!lVBuffer.checkGetFinish()) {
                    this.fuQ = lVBuffer.getInt();
                }
                if (!lVBuffer.checkGetFinish()) {
                    this.fuR = lVBuffer.getString();
                }
                if (!lVBuffer.checkGetFinish()) {
                    this.fuS = lVBuffer.getString();
                }
                if (!lVBuffer.checkGetFinish()) {
                    this.fuT = lVBuffer.getString();
                }
                if (!lVBuffer.checkGetFinish()) {
                    this.fuU = lVBuffer.getString();
                }
                if (!lVBuffer.checkGetFinish()) {
                    this.fuV = lVBuffer.getString();
                }
                if (!lVBuffer.checkGetFinish()) {
                    this.fuW = lVBuffer.getString();
                }
                if (!lVBuffer.checkGetFinish()) {
                    this.fuX = lVBuffer.getString();
                }
                if (!lVBuffer.checkGetFinish()) {
                    this.fuY = lVBuffer.getString();
                }
                if (!lVBuffer.checkGetFinish()) {
                    this.extFlag = lVBuffer.getInt();
                }
                if (!lVBuffer.checkGetFinish()) {
                    this.fuZ = lVBuffer.getString();
                }
                if (!lVBuffer.checkGetFinish()) {
                    this.fva = lVBuffer.getInt();
                }
                if (!lVBuffer.checkGetFinish()) {
                    this.fvb = lVBuffer.getString();
                }
                if (!lVBuffer.checkGetFinish()) {
                    this.fvc = lVBuffer.getInt();
                }
                if (!lVBuffer.checkGetFinish()) {
                    this.fvd = lVBuffer.getLong();
                }
                if (!lVBuffer.checkGetFinish()) {
                    this.fve = lVBuffer.getLong();
                }
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.SDK.BaseContact", "get value failed");
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        try {
            if (this.fma) {
                LVBuffer lVBuffer = new LVBuffer();
                lVBuffer.initBuild();
                lVBuffer.putInt(this.fuz);
                lVBuffer.putInt(this.fuA);
                lVBuffer.putString(this.fuB);
                lVBuffer.putLong(this.fuC);
                lVBuffer.putInt(this.uin);
                lVBuffer.putString(this.fuD);
                lVBuffer.putString(this.dSf);
                lVBuffer.putInt(this.showFlag);
                lVBuffer.putInt(this.fuE);
                lVBuffer.putString(this.fuF);
                lVBuffer.putString(this.fuG);
                lVBuffer.putInt(this.fuH);
                lVBuffer.putInt(this.fuI);
                lVBuffer.putString(this.signature);
                lVBuffer.putString(this.fuJ);
                lVBuffer.putString(this.fuK);
                lVBuffer.putString(this.fuL);
                lVBuffer.putInt(this.fromType);
                lVBuffer.putInt(this.source);
                lVBuffer.putString(this.fuM);
                lVBuffer.putInt(this.field_verifyFlag);
                lVBuffer.putString(this.fuN);
                lVBuffer.putString(this.fuO);
                lVBuffer.putInt(this.fuP);
                lVBuffer.putInt(this.fuQ);
                lVBuffer.putString(this.fuR);
                lVBuffer.putString(this.fuS);
                lVBuffer.putString(this.fuT);
                lVBuffer.putString(this.fuU);
                lVBuffer.putString(this.fuV);
                lVBuffer.putString(this.fuW);
                lVBuffer.putString(this.fuX);
                lVBuffer.putString(this.fuY);
                lVBuffer.putInt(this.extFlag);
                lVBuffer.putString(this.fuZ);
                lVBuffer.putInt(this.fva);
                lVBuffer.putString(this.fvb);
                lVBuffer.putInt(this.fvc);
                lVBuffer.putLong(this.fvd);
                lVBuffer.putLong(this.fve);
                this.field_lvbuff = lVBuffer.buildFinish();
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.SDK.BaseContact", "get value failed, %s", e2.getMessage());
        }
        ContentValues contentValues = new ContentValues();
        if (this.field_username == null) {
            this.field_username = "";
        }
        if (this.__hadSetusername) {
            contentValues.put(ch.COL_USERNAME, this.field_username);
        }
        if (this.field_alias == null) {
            this.field_alias = "";
        }
        if (this.ftP) {
            contentValues.put("alias", this.field_alias);
        }
        if (this.field_conRemark == null) {
            this.field_conRemark = "";
        }
        if (this.ftQ) {
            contentValues.put("conRemark", this.field_conRemark);
        }
        if (this.field_domainList == null) {
            this.field_domainList = "";
        }
        if (this.ftR) {
            contentValues.put("domainList", this.field_domainList);
        }
        if (this.field_nickname == null) {
            this.field_nickname = "";
        }
        if (this.fqb) {
            contentValues.put("nickname", this.field_nickname);
        }
        if (this.field_pyInitial == null) {
            this.field_pyInitial = "";
        }
        if (this.ftS) {
            contentValues.put("pyInitial", this.field_pyInitial);
        }
        if (this.field_quanPin == null) {
            this.field_quanPin = "";
        }
        if (this.ftT) {
            contentValues.put("quanPin", this.field_quanPin);
        }
        if (this.ftU) {
            contentValues.put("showHead", Integer.valueOf(this.field_showHead));
        }
        if (this.__hadSettype) {
            contentValues.put("type", Integer.valueOf(this.field_type));
        }
        if (this.ftV) {
            contentValues.put("weiboFlag", Integer.valueOf(this.field_weiboFlag));
        }
        if (this.field_weiboNickname == null) {
            this.field_weiboNickname = "";
        }
        if (this.ftW) {
            contentValues.put("weiboNickname", this.field_weiboNickname);
        }
        if (this.field_conRemarkPYFull == null) {
            this.field_conRemarkPYFull = "";
        }
        if (this.ftX) {
            contentValues.put("conRemarkPYFull", this.field_conRemarkPYFull);
        }
        if (this.field_conRemarkPYShort == null) {
            this.field_conRemarkPYShort = "";
        }
        if (this.ftY) {
            contentValues.put("conRemarkPYShort", this.field_conRemarkPYShort);
        }
        if (this.fma) {
            contentValues.put("lvbuff", this.field_lvbuff);
        }
        if (this.ftZ) {
            contentValues.put("verifyFlag", Integer.valueOf(this.field_verifyFlag));
        }
        if (this.field_encryptUsername == null) {
            this.field_encryptUsername = "";
        }
        if (this.fua) {
            contentValues.put("encryptUsername", this.field_encryptUsername);
        }
        if (this.fub) {
            contentValues.put("chatroomFlag", Integer.valueOf(this.field_chatroomFlag));
        }
        if (this.fuc) {
            contentValues.put("deleteFlag", Integer.valueOf(this.field_deleteFlag));
        }
        if (this.field_contactLabelIds == null) {
            this.field_contactLabelIds = "";
        }
        if (this.fud) {
            contentValues.put("contactLabelIds", this.field_contactLabelIds);
        }
        if (this.field_descWordingId == null) {
            this.field_descWordingId = "";
        }
        if (this.fue) {
            contentValues.put("descWordingId", this.field_descWordingId);
        }
        if (this.fuf) {
            contentValues.put("openImAppid", this.field_openImAppid);
        }
        if (this.fug) {
            contentValues.put("sourceExtInfo", this.field_sourceExtInfo);
        }
        if (this.field_ticket == null) {
            this.field_ticket = "";
        }
        if (this.fjP) {
            contentValues.put("ticket", this.field_ticket);
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
