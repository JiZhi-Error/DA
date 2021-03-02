package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class bi extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fjl = "status".hashCode();
    private static final int fni = "flag".hashCode();
    private static final int fwT = "productID".hashCode();
    private static final int fwU = "packIconUrl".hashCode();
    private static final int fwV = "packGrayIconUrl".hashCode();
    private static final int fwW = "packCoverUrl".hashCode();
    private static final int fwX = "packName".hashCode();
    private static final int fwY = "packDesc".hashCode();
    private static final int fwZ = "packAuthInfo".hashCode();
    private static final int fxa = "packPrice".hashCode();
    private static final int fxb = "packType".hashCode();
    private static final int fxc = "packFlag".hashCode();
    private static final int fxd = "packExpire".hashCode();
    private static final int fxe = "packTimeStamp".hashCode();
    private static final int fxf = "packCopyright".hashCode();
    private static final int fxg = "sort".hashCode();
    private static final int fxh = "lastUseTime".hashCode();
    private static final int fxi = "packStatus".hashCode();
    private static final int fxj = "recommand".hashCode();
    private static final int fxk = "sync".hashCode();
    private static final int fxl = "idx".hashCode();
    private static final int fxm = "BigIconUrl".hashCode();
    private static final int fxn = "MutiLanName".hashCode();
    private static final int fxo = "recommandType".hashCode();
    private static final int fxp = "lang".hashCode();
    private static final int fxq = "recommandWord".hashCode();
    private static final int fxr = "buttonType".hashCode();
    private static final int fxs = "count".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private static final int type_HASHCODE = "type".hashCode();
    private boolean __hadSettype = true;
    public String field_BigIconUrl;
    public String field_MutiLanName;
    public int field_buttonType;
    public int field_count;
    public int field_flag;
    public int field_idx;
    public String field_lang;
    public long field_lastUseTime;
    public String field_packAuthInfo;
    public String field_packCopyright;
    public String field_packCoverUrl;
    public String field_packDesc;
    public long field_packExpire;
    public int field_packFlag;
    public String field_packGrayIconUrl;
    public String field_packIconUrl;
    public String field_packName;
    public String field_packPrice;
    public int field_packStatus;
    public long field_packTimeStamp;
    public int field_packType;
    public String field_productID;
    public int field_recommand;
    public int field_recommandType;
    public String field_recommandWord;
    public int field_sort;
    public int field_status;
    public int field_sync;
    public int field_type;
    private boolean fji = true;
    private boolean fng = true;
    private boolean fwA = true;
    private boolean fwB = true;
    private boolean fwC = true;
    private boolean fwD = true;
    private boolean fwE = true;
    private boolean fwF = true;
    private boolean fwG = true;
    private boolean fwH = true;
    private boolean fwI = true;
    private boolean fwJ = true;
    private boolean fwK = true;
    private boolean fwL = true;
    private boolean fwM = true;
    private boolean fwN = true;
    private boolean fwO = true;
    private boolean fwP = true;
    private boolean fwQ = true;
    private boolean fwR = true;
    private boolean fwS = true;
    private boolean fwt = true;
    private boolean fwu = true;
    private boolean fwv = true;
    private boolean fww = true;
    private boolean fwx = true;
    private boolean fwy = true;
    private boolean fwz = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fwT == hashCode) {
                    this.field_productID = cursor.getString(i2);
                    this.fwt = true;
                } else if (fwU == hashCode) {
                    this.field_packIconUrl = cursor.getString(i2);
                } else if (fwV == hashCode) {
                    this.field_packGrayIconUrl = cursor.getString(i2);
                } else if (fwW == hashCode) {
                    this.field_packCoverUrl = cursor.getString(i2);
                } else if (fwX == hashCode) {
                    this.field_packName = cursor.getString(i2);
                } else if (fwY == hashCode) {
                    this.field_packDesc = cursor.getString(i2);
                } else if (fwZ == hashCode) {
                    this.field_packAuthInfo = cursor.getString(i2);
                } else if (fxa == hashCode) {
                    this.field_packPrice = cursor.getString(i2);
                } else if (fxb == hashCode) {
                    this.field_packType = cursor.getInt(i2);
                } else if (fxc == hashCode) {
                    this.field_packFlag = cursor.getInt(i2);
                } else if (fxd == hashCode) {
                    this.field_packExpire = cursor.getLong(i2);
                } else if (fxe == hashCode) {
                    this.field_packTimeStamp = cursor.getLong(i2);
                } else if (fxf == hashCode) {
                    this.field_packCopyright = cursor.getString(i2);
                } else if (type_HASHCODE == hashCode) {
                    this.field_type = cursor.getInt(i2);
                } else if (fjl == hashCode) {
                    this.field_status = cursor.getInt(i2);
                } else if (fxg == hashCode) {
                    this.field_sort = cursor.getInt(i2);
                } else if (fxh == hashCode) {
                    this.field_lastUseTime = cursor.getLong(i2);
                } else if (fxi == hashCode) {
                    this.field_packStatus = cursor.getInt(i2);
                } else if (fni == hashCode) {
                    this.field_flag = cursor.getInt(i2);
                } else if (fxj == hashCode) {
                    this.field_recommand = cursor.getInt(i2);
                } else if (fxk == hashCode) {
                    this.field_sync = cursor.getInt(i2);
                } else if (fxl == hashCode) {
                    this.field_idx = cursor.getInt(i2);
                } else if (fxm == hashCode) {
                    this.field_BigIconUrl = cursor.getString(i2);
                } else if (fxn == hashCode) {
                    this.field_MutiLanName = cursor.getString(i2);
                } else if (fxo == hashCode) {
                    this.field_recommandType = cursor.getInt(i2);
                } else if (fxp == hashCode) {
                    this.field_lang = cursor.getString(i2);
                } else if (fxq == hashCode) {
                    this.field_recommandWord = cursor.getString(i2);
                } else if (fxr == hashCode) {
                    this.field_buttonType = cursor.getInt(i2);
                } else if (fxs == hashCode) {
                    this.field_count = cursor.getInt(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.fwt) {
            contentValues.put("productID", this.field_productID);
        }
        if (this.fwu) {
            contentValues.put("packIconUrl", this.field_packIconUrl);
        }
        if (this.fwv) {
            contentValues.put("packGrayIconUrl", this.field_packGrayIconUrl);
        }
        if (this.fww) {
            contentValues.put("packCoverUrl", this.field_packCoverUrl);
        }
        if (this.fwx) {
            contentValues.put("packName", this.field_packName);
        }
        if (this.fwy) {
            contentValues.put("packDesc", this.field_packDesc);
        }
        if (this.fwz) {
            contentValues.put("packAuthInfo", this.field_packAuthInfo);
        }
        if (this.fwA) {
            contentValues.put("packPrice", this.field_packPrice);
        }
        if (this.fwB) {
            contentValues.put("packType", Integer.valueOf(this.field_packType));
        }
        if (this.fwC) {
            contentValues.put("packFlag", Integer.valueOf(this.field_packFlag));
        }
        if (this.fwD) {
            contentValues.put("packExpire", Long.valueOf(this.field_packExpire));
        }
        if (this.fwE) {
            contentValues.put("packTimeStamp", Long.valueOf(this.field_packTimeStamp));
        }
        if (this.fwF) {
            contentValues.put("packCopyright", this.field_packCopyright);
        }
        if (this.__hadSettype) {
            contentValues.put("type", Integer.valueOf(this.field_type));
        }
        if (this.fji) {
            contentValues.put("status", Integer.valueOf(this.field_status));
        }
        if (this.fwG) {
            contentValues.put("sort", Integer.valueOf(this.field_sort));
        }
        if (this.fwH) {
            contentValues.put("lastUseTime", Long.valueOf(this.field_lastUseTime));
        }
        if (this.fwI) {
            contentValues.put("packStatus", Integer.valueOf(this.field_packStatus));
        }
        if (this.fng) {
            contentValues.put("flag", Integer.valueOf(this.field_flag));
        }
        if (this.fwJ) {
            contentValues.put("recommand", Integer.valueOf(this.field_recommand));
        }
        if (this.fwK) {
            contentValues.put("sync", Integer.valueOf(this.field_sync));
        }
        if (this.fwL) {
            contentValues.put("idx", Integer.valueOf(this.field_idx));
        }
        if (this.fwM) {
            contentValues.put("BigIconUrl", this.field_BigIconUrl);
        }
        if (this.fwN) {
            contentValues.put("MutiLanName", this.field_MutiLanName);
        }
        if (this.fwO) {
            contentValues.put("recommandType", Integer.valueOf(this.field_recommandType));
        }
        if (this.fwP) {
            contentValues.put("lang", this.field_lang);
        }
        if (this.fwQ) {
            contentValues.put("recommandWord", this.field_recommandWord);
        }
        if (this.fwR) {
            contentValues.put("buttonType", Integer.valueOf(this.field_buttonType));
        }
        if (this.fwS) {
            contentValues.put("count", Integer.valueOf(this.field_count));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
