package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class ga extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fIF = "sex".hashCode();
    private static final int fYd = "shakeItemID".hashCode();
    private static final int fYe = "province".hashCode();
    private static final int fYf = "city".hashCode();
    private static final int fYg = "distance".hashCode();
    private static final int fYh = "imgstatus".hashCode();
    private static final int fYi = "hasHDImg".hashCode();
    private static final int fYj = "insertBatch".hashCode();
    private static final int fYk = "regionCode".hashCode();
    private static final int fYl = "snsFlag".hashCode();
    private static final int fYm = "sns_bgurl".hashCode();
    private static final int fkx = "signature".hashCode();
    private static final int fqf = "nickname".hashCode();
    private static final int fqy = "lvbuffer".hashCode();
    private static final int fyl = "reserved1".hashCode();
    private static final int fym = "reserved2".hashCode();
    private static final int fyn = "reserved3".hashCode();
    private static final int fyo = "reserved4".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private static final int type_HASHCODE = "type".hashCode();
    private static final int username_HASHCODE = ch.COL_USERNAME.hashCode();
    private boolean __hadSettype = true;
    private boolean __hadSetusername = true;
    private boolean fIB = true;
    private boolean fXT = true;
    private boolean fXU = true;
    private boolean fXV = true;
    private boolean fXW = true;
    private boolean fXX = true;
    private boolean fXY = true;
    private boolean fXZ = true;
    private boolean fYa = true;
    private boolean fYb = true;
    private boolean fYc = true;
    public String field_city;
    public String field_distance;
    public int field_hasHDImg;
    public int field_imgstatus;
    public int field_insertBatch;
    public byte[] field_lvbuffer;
    public String field_nickname;
    public String field_province;
    public String field_regionCode;
    public int field_reserved1;
    public int field_reserved2;
    public String field_reserved3;
    public String field_reserved4;
    public int field_sex;
    public int field_shakeItemID;
    public String field_signature;
    public int field_snsFlag;
    public String field_sns_bgurl;
    public int field_type;
    public String field_username;
    private boolean fkg = true;
    private boolean fqb = true;
    private boolean fqk = true;
    private boolean fxA = true;
    private boolean fxB = true;
    private boolean fxC = true;
    private boolean fxz = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fYd == hashCode) {
                    this.field_shakeItemID = cursor.getInt(i2);
                    this.fXT = true;
                } else if (username_HASHCODE == hashCode) {
                    this.field_username = cursor.getString(i2);
                } else if (fqf == hashCode) {
                    this.field_nickname = cursor.getString(i2);
                } else if (fYe == hashCode) {
                    this.field_province = cursor.getString(i2);
                } else if (fYf == hashCode) {
                    this.field_city = cursor.getString(i2);
                } else if (fkx == hashCode) {
                    this.field_signature = cursor.getString(i2);
                } else if (fYg == hashCode) {
                    this.field_distance = cursor.getString(i2);
                } else if (fIF == hashCode) {
                    this.field_sex = cursor.getInt(i2);
                } else if (fYh == hashCode) {
                    this.field_imgstatus = cursor.getInt(i2);
                } else if (fYi == hashCode) {
                    this.field_hasHDImg = cursor.getInt(i2);
                } else if (fYj == hashCode) {
                    this.field_insertBatch = cursor.getInt(i2);
                } else if (fyl == hashCode) {
                    this.field_reserved1 = cursor.getInt(i2);
                } else if (fym == hashCode) {
                    this.field_reserved2 = cursor.getInt(i2);
                } else if (fyn == hashCode) {
                    this.field_reserved3 = cursor.getString(i2);
                } else if (fyo == hashCode) {
                    this.field_reserved4 = cursor.getString(i2);
                } else if (type_HASHCODE == hashCode) {
                    this.field_type = cursor.getInt(i2);
                } else if (fqy == hashCode) {
                    this.field_lvbuffer = cursor.getBlob(i2);
                } else if (fYk == hashCode) {
                    this.field_regionCode = cursor.getString(i2);
                } else if (fYl == hashCode) {
                    this.field_snsFlag = cursor.getInt(i2);
                } else if (fYm == hashCode) {
                    this.field_sns_bgurl = cursor.getString(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.fXT) {
            contentValues.put("shakeItemID", Integer.valueOf(this.field_shakeItemID));
        }
        if (this.__hadSetusername) {
            contentValues.put(ch.COL_USERNAME, this.field_username);
        }
        if (this.fqb) {
            contentValues.put("nickname", this.field_nickname);
        }
        if (this.fXU) {
            contentValues.put("province", this.field_province);
        }
        if (this.fXV) {
            contentValues.put("city", this.field_city);
        }
        if (this.fkg) {
            contentValues.put("signature", this.field_signature);
        }
        if (this.fXW) {
            contentValues.put("distance", this.field_distance);
        }
        if (this.fIB) {
            contentValues.put("sex", Integer.valueOf(this.field_sex));
        }
        if (this.fXX) {
            contentValues.put("imgstatus", Integer.valueOf(this.field_imgstatus));
        }
        if (this.fXY) {
            contentValues.put("hasHDImg", Integer.valueOf(this.field_hasHDImg));
        }
        if (this.fXZ) {
            contentValues.put("insertBatch", Integer.valueOf(this.field_insertBatch));
        }
        if (this.fxz) {
            contentValues.put("reserved1", Integer.valueOf(this.field_reserved1));
        }
        if (this.fxA) {
            contentValues.put("reserved2", Integer.valueOf(this.field_reserved2));
        }
        if (this.fxB) {
            contentValues.put("reserved3", this.field_reserved3);
        }
        if (this.fxC) {
            contentValues.put("reserved4", this.field_reserved4);
        }
        if (this.__hadSettype) {
            contentValues.put("type", Integer.valueOf(this.field_type));
        }
        if (this.fqk) {
            contentValues.put("lvbuffer", this.field_lvbuffer);
        }
        if (this.fYa) {
            contentValues.put("regionCode", this.field_regionCode);
        }
        if (this.fYb) {
            contentValues.put("snsFlag", Integer.valueOf(this.field_snsFlag));
        }
        if (this.fYc) {
            contentValues.put("sns_bgurl", this.field_sns_bgurl);
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
