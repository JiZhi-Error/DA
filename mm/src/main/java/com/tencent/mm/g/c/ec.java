package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class ec extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fOA = "Introduce_en".hashCode();
    private static final int fOB = "starttime".hashCode();
    private static final int fOC = "endtime".hashCode();
    private static final int fOD = "ThumbUrl_cn".hashCode();
    private static final int fOE = "ThumbUrl_hk".hashCode();
    private static final int fOF = "ThumbUrl_tw".hashCode();
    private static final int fOG = "ThumbUrl_en".hashCode();
    private static final int fOH = "ImgUrl_android_cn".hashCode();
    private static final int fOI = "ImgUrl_android_hk".hashCode();
    private static final int fOJ = "ImgUrl_android_tw".hashCode();
    private static final int fOK = "ImgUrl_android_en".hashCode();
    private static final int fOL = "RedPoint".hashCode();
    private static final int fOM = "WeAppDebugMode".hashCode();
    private static final int fON = "idkey".hashCode();
    private static final int fOO = "idkeyValue".hashCode();
    private static final int fOP = "Icon".hashCode();
    private static final int fOQ = "ImgUrl_cn".hashCode();
    private static final int fOR = "ImgUrl_hk".hashCode();
    private static final int fOS = "ImgUrl_tw".hashCode();
    private static final int fOT = "ImgUrl_en".hashCode();
    private static final int fOU = "bItemFromXExpt".hashCode();
    private static final int fOf = "LabsAppId".hashCode();
    private static final int fOg = "Type".hashCode();
    private static final int fOh = "BizType".hashCode();
    private static final int fOi = "Switch".hashCode();
    private static final int fOj = "AllVer".hashCode();
    private static final int fOk = "DetailURL".hashCode();
    private static final int fOl = "WeAppUser".hashCode();
    private static final int fOm = "WeAppPath".hashCode();
    private static final int fOn = "Pos".hashCode();
    private static final int fOo = "TitleKey_android".hashCode();
    private static final int fOp = "Title_cn".hashCode();
    private static final int fOq = "Title_hk".hashCode();
    private static final int fOr = "Title_tw".hashCode();
    private static final int fOs = "Title_en".hashCode();
    private static final int fOt = "Desc_cn".hashCode();
    private static final int fOu = "Desc_hk".hashCode();
    private static final int fOv = "Desc_tw".hashCode();
    private static final int fOw = "Desc_en".hashCode();
    private static final int fOx = "Introduce_cn".hashCode();
    private static final int fOy = "Introduce_hk".hashCode();
    private static final int fOz = "Introduce_tw".hashCode();
    private static final int fjl = "status".hashCode();
    private static final int fju = "expId".hashCode();
    private static final int fjv = "sequence".hashCode();
    private static final int fjw = "prioritylevel".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private boolean fNA = true;
    private boolean fNB = true;
    private boolean fNC = true;
    private boolean fND = true;
    private boolean fNE = true;
    private boolean fNF = true;
    private boolean fNG = true;
    private boolean fNH = true;
    private boolean fNI = true;
    private boolean fNJ = true;
    private boolean fNK = true;
    private boolean fNL = true;
    private boolean fNM = true;
    private boolean fNN = true;
    private boolean fNO = true;
    private boolean fNP = true;
    private boolean fNQ = true;
    private boolean fNR = true;
    private boolean fNS = true;
    private boolean fNT = true;
    private boolean fNU = true;
    private boolean fNV = true;
    private boolean fNW = true;
    private boolean fNX = true;
    private boolean fNY = true;
    private boolean fNZ = true;
    private boolean fNp = true;
    private boolean fNq = true;
    private boolean fNr = true;
    private boolean fNs = true;
    private boolean fNt = true;
    private boolean fNu = true;
    private boolean fNv = true;
    private boolean fNw = true;
    private boolean fNx = true;
    private boolean fNy = true;
    private boolean fNz = true;
    private boolean fOa = true;
    private boolean fOb = true;
    private boolean fOc = true;
    private boolean fOd = true;
    private boolean fOe = true;
    public int field_AllVer;
    public int field_BizType;
    public String field_Desc_cn;
    public String field_Desc_en;
    public String field_Desc_hk;
    public String field_Desc_tw;
    public String field_DetailURL;
    public String field_Icon;
    public String field_ImgUrl_android_cn;
    public String field_ImgUrl_android_en;
    public String field_ImgUrl_android_hk;
    public String field_ImgUrl_android_tw;
    public String field_ImgUrl_cn;
    public String field_ImgUrl_en;
    public String field_ImgUrl_hk;
    public String field_ImgUrl_tw;
    public String field_Introduce_cn;
    public String field_Introduce_en;
    public String field_Introduce_hk;
    public String field_Introduce_tw;
    public String field_LabsAppId;
    public int field_Pos;
    public int field_RedPoint;
    public int field_Switch;
    public String field_ThumbUrl_cn;
    public String field_ThumbUrl_en;
    public String field_ThumbUrl_hk;
    public String field_ThumbUrl_tw;
    public String field_TitleKey_android;
    public String field_Title_cn;
    public String field_Title_en;
    public String field_Title_hk;
    public String field_Title_tw;
    public int field_Type;
    public int field_WeAppDebugMode;
    public String field_WeAppPath;
    public String field_WeAppUser;
    public int field_bItemFromXExpt;
    public long field_endtime;
    public String field_expId;
    public int field_idkey;
    public int field_idkeyValue;
    public int field_prioritylevel;
    public long field_sequence;
    public long field_starttime;
    public int field_status;
    private boolean fji = true;
    private boolean fjn = true;
    private boolean fjo = true;
    private boolean fjp = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fOf == hashCode) {
                    this.field_LabsAppId = cursor.getString(i2);
                    this.fNp = true;
                } else if (fju == hashCode) {
                    this.field_expId = cursor.getString(i2);
                } else if (fOg == hashCode) {
                    this.field_Type = cursor.getInt(i2);
                } else if (fOh == hashCode) {
                    this.field_BizType = cursor.getInt(i2);
                } else if (fOi == hashCode) {
                    this.field_Switch = cursor.getInt(i2);
                } else if (fOj == hashCode) {
                    this.field_AllVer = cursor.getInt(i2);
                } else if (fOk == hashCode) {
                    this.field_DetailURL = cursor.getString(i2);
                } else if (fOl == hashCode) {
                    this.field_WeAppUser = cursor.getString(i2);
                } else if (fOm == hashCode) {
                    this.field_WeAppPath = cursor.getString(i2);
                } else if (fOn == hashCode) {
                    this.field_Pos = cursor.getInt(i2);
                } else if (fOo == hashCode) {
                    this.field_TitleKey_android = cursor.getString(i2);
                } else if (fOp == hashCode) {
                    this.field_Title_cn = cursor.getString(i2);
                } else if (fOq == hashCode) {
                    this.field_Title_hk = cursor.getString(i2);
                } else if (fOr == hashCode) {
                    this.field_Title_tw = cursor.getString(i2);
                } else if (fOs == hashCode) {
                    this.field_Title_en = cursor.getString(i2);
                } else if (fOt == hashCode) {
                    this.field_Desc_cn = cursor.getString(i2);
                } else if (fOu == hashCode) {
                    this.field_Desc_hk = cursor.getString(i2);
                } else if (fOv == hashCode) {
                    this.field_Desc_tw = cursor.getString(i2);
                } else if (fOw == hashCode) {
                    this.field_Desc_en = cursor.getString(i2);
                } else if (fOx == hashCode) {
                    this.field_Introduce_cn = cursor.getString(i2);
                } else if (fOy == hashCode) {
                    this.field_Introduce_hk = cursor.getString(i2);
                } else if (fOz == hashCode) {
                    this.field_Introduce_tw = cursor.getString(i2);
                } else if (fOA == hashCode) {
                    this.field_Introduce_en = cursor.getString(i2);
                } else if (fOB == hashCode) {
                    this.field_starttime = cursor.getLong(i2);
                } else if (fOC == hashCode) {
                    this.field_endtime = cursor.getLong(i2);
                } else if (fjv == hashCode) {
                    this.field_sequence = cursor.getLong(i2);
                } else if (fjw == hashCode) {
                    this.field_prioritylevel = cursor.getInt(i2);
                } else if (fjl == hashCode) {
                    this.field_status = cursor.getInt(i2);
                } else if (fOD == hashCode) {
                    this.field_ThumbUrl_cn = cursor.getString(i2);
                } else if (fOE == hashCode) {
                    this.field_ThumbUrl_hk = cursor.getString(i2);
                } else if (fOF == hashCode) {
                    this.field_ThumbUrl_tw = cursor.getString(i2);
                } else if (fOG == hashCode) {
                    this.field_ThumbUrl_en = cursor.getString(i2);
                } else if (fOH == hashCode) {
                    this.field_ImgUrl_android_cn = cursor.getString(i2);
                } else if (fOI == hashCode) {
                    this.field_ImgUrl_android_hk = cursor.getString(i2);
                } else if (fOJ == hashCode) {
                    this.field_ImgUrl_android_tw = cursor.getString(i2);
                } else if (fOK == hashCode) {
                    this.field_ImgUrl_android_en = cursor.getString(i2);
                } else if (fOL == hashCode) {
                    this.field_RedPoint = cursor.getInt(i2);
                } else if (fOM == hashCode) {
                    this.field_WeAppDebugMode = cursor.getInt(i2);
                } else if (fON == hashCode) {
                    this.field_idkey = cursor.getInt(i2);
                } else if (fOO == hashCode) {
                    this.field_idkeyValue = cursor.getInt(i2);
                } else if (fOP == hashCode) {
                    this.field_Icon = cursor.getString(i2);
                } else if (fOQ == hashCode) {
                    this.field_ImgUrl_cn = cursor.getString(i2);
                } else if (fOR == hashCode) {
                    this.field_ImgUrl_hk = cursor.getString(i2);
                } else if (fOS == hashCode) {
                    this.field_ImgUrl_tw = cursor.getString(i2);
                } else if (fOT == hashCode) {
                    this.field_ImgUrl_en = cursor.getString(i2);
                } else if (fOU == hashCode) {
                    this.field_bItemFromXExpt = cursor.getInt(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.fNp) {
            contentValues.put("LabsAppId", this.field_LabsAppId);
        }
        if (this.field_expId == null) {
            this.field_expId = "";
        }
        if (this.fjn) {
            contentValues.put("expId", this.field_expId);
        }
        if (this.fNq) {
            contentValues.put("Type", Integer.valueOf(this.field_Type));
        }
        if (this.fNr) {
            contentValues.put("BizType", Integer.valueOf(this.field_BizType));
        }
        if (this.fNs) {
            contentValues.put("Switch", Integer.valueOf(this.field_Switch));
        }
        if (this.fNt) {
            contentValues.put("AllVer", Integer.valueOf(this.field_AllVer));
        }
        if (this.fNu) {
            contentValues.put("DetailURL", this.field_DetailURL);
        }
        if (this.fNv) {
            contentValues.put("WeAppUser", this.field_WeAppUser);
        }
        if (this.fNw) {
            contentValues.put("WeAppPath", this.field_WeAppPath);
        }
        if (this.fNx) {
            contentValues.put("Pos", Integer.valueOf(this.field_Pos));
        }
        if (this.fNy) {
            contentValues.put("TitleKey_android", this.field_TitleKey_android);
        }
        if (this.fNz) {
            contentValues.put("Title_cn", this.field_Title_cn);
        }
        if (this.fNA) {
            contentValues.put("Title_hk", this.field_Title_hk);
        }
        if (this.fNB) {
            contentValues.put("Title_tw", this.field_Title_tw);
        }
        if (this.fNC) {
            contentValues.put("Title_en", this.field_Title_en);
        }
        if (this.fND) {
            contentValues.put("Desc_cn", this.field_Desc_cn);
        }
        if (this.fNE) {
            contentValues.put("Desc_hk", this.field_Desc_hk);
        }
        if (this.fNF) {
            contentValues.put("Desc_tw", this.field_Desc_tw);
        }
        if (this.fNG) {
            contentValues.put("Desc_en", this.field_Desc_en);
        }
        if (this.fNH) {
            contentValues.put("Introduce_cn", this.field_Introduce_cn);
        }
        if (this.fNI) {
            contentValues.put("Introduce_hk", this.field_Introduce_hk);
        }
        if (this.fNJ) {
            contentValues.put("Introduce_tw", this.field_Introduce_tw);
        }
        if (this.fNK) {
            contentValues.put("Introduce_en", this.field_Introduce_en);
        }
        if (this.fNL) {
            contentValues.put("starttime", Long.valueOf(this.field_starttime));
        }
        if (this.fNM) {
            contentValues.put("endtime", Long.valueOf(this.field_endtime));
        }
        if (this.fjo) {
            contentValues.put("sequence", Long.valueOf(this.field_sequence));
        }
        if (this.fjp) {
            contentValues.put("prioritylevel", Integer.valueOf(this.field_prioritylevel));
        }
        if (this.fji) {
            contentValues.put("status", Integer.valueOf(this.field_status));
        }
        if (this.fNN) {
            contentValues.put("ThumbUrl_cn", this.field_ThumbUrl_cn);
        }
        if (this.fNO) {
            contentValues.put("ThumbUrl_hk", this.field_ThumbUrl_hk);
        }
        if (this.fNP) {
            contentValues.put("ThumbUrl_tw", this.field_ThumbUrl_tw);
        }
        if (this.fNQ) {
            contentValues.put("ThumbUrl_en", this.field_ThumbUrl_en);
        }
        if (this.fNR) {
            contentValues.put("ImgUrl_android_cn", this.field_ImgUrl_android_cn);
        }
        if (this.fNS) {
            contentValues.put("ImgUrl_android_hk", this.field_ImgUrl_android_hk);
        }
        if (this.fNT) {
            contentValues.put("ImgUrl_android_tw", this.field_ImgUrl_android_tw);
        }
        if (this.fNU) {
            contentValues.put("ImgUrl_android_en", this.field_ImgUrl_android_en);
        }
        if (this.fNV) {
            contentValues.put("RedPoint", Integer.valueOf(this.field_RedPoint));
        }
        if (this.fNW) {
            contentValues.put("WeAppDebugMode", Integer.valueOf(this.field_WeAppDebugMode));
        }
        if (this.fNX) {
            contentValues.put("idkey", Integer.valueOf(this.field_idkey));
        }
        if (this.fNY) {
            contentValues.put("idkeyValue", Integer.valueOf(this.field_idkeyValue));
        }
        if (this.fNZ) {
            contentValues.put("Icon", this.field_Icon);
        }
        if (this.fOa) {
            contentValues.put("ImgUrl_cn", this.field_ImgUrl_cn);
        }
        if (this.fOb) {
            contentValues.put("ImgUrl_hk", this.field_ImgUrl_hk);
        }
        if (this.fOc) {
            contentValues.put("ImgUrl_tw", this.field_ImgUrl_tw);
        }
        if (this.fOd) {
            contentValues.put("ImgUrl_en", this.field_ImgUrl_en);
        }
        if (this.fOe) {
            contentValues.put("bItemFromXExpt", Integer.valueOf(this.field_bItemFromXExpt));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
