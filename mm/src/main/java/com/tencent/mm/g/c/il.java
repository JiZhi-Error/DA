package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.facebook.appevents.UserDataStore;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class il extends IAutoDBItem {
    public static final String[] INDEX_CREATE = {"CREATE INDEX IF NOT EXISTS FestivalWishLiveEncUsernameIndex ON FestivalWish2(liveEncUsername)"};
    private static final int createTime_HASHCODE = "createTime".hashCode();
    private static final int fYe = "province".hashCode();
    private static final int fYf = "city".hashCode();
    private static final int fqe = "headImgUrl".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private static final int uni = "wishId".hashCode();
    private static final int uoB = "hashUsername".hashCode();
    private static final int usF = "x".hashCode();
    private static final int usG = "y".hashCode();
    private static final int usH = "wishText".hashCode();
    private static final int usI = "nickName".hashCode();
    private static final int usJ = "liveEncUsername".hashCode();
    private static final int usK = "delFlag".hashCode();
    private static final int usL = UserDataStore.COUNTRY.hashCode();
    private static final int userName_HASHCODE = "userName".hashCode();
    private static final int uub = "likeCount".hashCode();
    private boolean __hadSetcreateTime = true;
    private boolean __hadSetuserName = true;
    private boolean fXU = true;
    private boolean fXV = true;
    public String field_city;
    public String field_country;
    public long field_createTime;
    public int field_delFlag;
    public String field_hashUsername;
    public String field_headImgUrl;
    public long field_likeCount;
    public String field_liveEncUsername;
    public String field_nickName;
    public String field_province;
    public String field_userName;
    public String field_wishId;
    public String field_wishText;
    public int field_x;
    public int field_y;
    private boolean fqa = true;
    private boolean une = true;
    private boolean unf = true;
    private boolean usA = true;
    private boolean usB = true;
    private boolean usC = true;
    private boolean usD = true;
    private boolean usE = true;
    private boolean usx = true;
    private boolean usy = true;
    private boolean usz = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (uni == hashCode) {
                    this.field_wishId = cursor.getString(i2);
                    this.une = true;
                } else if (usF == hashCode) {
                    this.field_x = cursor.getInt(i2);
                } else if (usG == hashCode) {
                    this.field_y = cursor.getInt(i2);
                } else if (usH == hashCode) {
                    this.field_wishText = cursor.getString(i2);
                } else if (usI == hashCode) {
                    this.field_nickName = cursor.getString(i2);
                } else if (fqe == hashCode) {
                    this.field_headImgUrl = cursor.getString(i2);
                } else if (createTime_HASHCODE == hashCode) {
                    this.field_createTime = cursor.getLong(i2);
                } else if (userName_HASHCODE == hashCode) {
                    this.field_userName = cursor.getString(i2);
                } else if (usJ == hashCode) {
                    this.field_liveEncUsername = cursor.getString(i2);
                } else if (usK == hashCode) {
                    this.field_delFlag = cursor.getInt(i2);
                } else if (usL == hashCode) {
                    this.field_country = cursor.getString(i2);
                } else if (fYe == hashCode) {
                    this.field_province = cursor.getString(i2);
                } else if (fYf == hashCode) {
                    this.field_city = cursor.getString(i2);
                } else if (uub == hashCode) {
                    this.field_likeCount = cursor.getLong(i2);
                } else if (uoB == hashCode) {
                    this.field_hashUsername = cursor.getString(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.une) {
            contentValues.put("wishId", this.field_wishId);
        }
        if (this.usx) {
            contentValues.put("x", Integer.valueOf(this.field_x));
        }
        if (this.usy) {
            contentValues.put("y", Integer.valueOf(this.field_y));
        }
        if (this.usz) {
            contentValues.put("wishText", this.field_wishText);
        }
        if (this.usA) {
            contentValues.put("nickName", this.field_nickName);
        }
        if (this.fqa) {
            contentValues.put("headImgUrl", this.field_headImgUrl);
        }
        if (this.__hadSetcreateTime) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.__hadSetuserName) {
            contentValues.put("userName", this.field_userName);
        }
        if (this.usB) {
            contentValues.put("liveEncUsername", this.field_liveEncUsername);
        }
        if (this.usC) {
            contentValues.put("delFlag", Integer.valueOf(this.field_delFlag));
        }
        if (this.usD) {
            contentValues.put(UserDataStore.COUNTRY, this.field_country);
        }
        if (this.fXU) {
            contentValues.put("province", this.field_province);
        }
        if (this.fXV) {
            contentValues.put("city", this.field_city);
        }
        if (this.usE) {
            contentValues.put("likeCount", Long.valueOf(this.field_likeCount));
        }
        if (this.unf) {
            contentValues.put("hashUsername", this.field_hashUsername);
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
