package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;

public abstract class al extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fjl = "status".hashCode();
    private static final int fkj = "appId".hashCode();
    private static final int foC = "bitFlag".hashCode();
    private static final int fpL = "brandList".hashCode();
    private static final int fpM = "brandListVersion".hashCode();
    private static final int fpN = "brandListContent".hashCode();
    private static final int fpO = "brandFlag".hashCode();
    private static final int fpP = IssueStorage.COLUMN_EXT_INFO.hashCode();
    private static final int fpQ = "brandInfo".hashCode();
    private static final int fpR = "brandIconURL".hashCode();
    private static final int fpS = "hadAlert".hashCode();
    private static final int fpT = "acceptType".hashCode();
    private static final int fpU = "enterpriseFather".hashCode();
    private static final int fpV = "kfWorkerId".hashCode();
    private static final int fpW = "specialType".hashCode();
    private static final int fpX = "attrSyncVersion".hashCode();
    private static final int fpY = "incrementUpdateTime".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private static final int type_HASHCODE = "type".hashCode();
    private static final int updateTime_HASHCODE = ch.COL_UPDATETIME.hashCode();
    private static final int username_HASHCODE = ch.COL_USERNAME.hashCode();
    private boolean __hadSettype = true;
    private boolean __hadSetupdateTime = true;
    private boolean __hadSetusername = true;
    public int field_acceptType;
    public String field_appId;
    public String field_attrSyncVersion;
    public int field_bitFlag;
    public int field_brandFlag;
    public String field_brandIconURL;
    public String field_brandInfo;
    public String field_brandList;
    public String field_brandListContent;
    public String field_brandListVersion;
    public String field_enterpriseFather;
    public String field_extInfo;
    public int field_hadAlert;
    public long field_incrementUpdateTime;
    public String field_kfWorkerId;
    public int field_specialType;
    public int field_status;
    public int field_type;
    public long field_updateTime;
    public String field_username;
    private boolean fjS = true;
    private boolean fji = true;
    private boolean fop = true;
    private boolean fpA = true;
    private boolean fpB = true;
    private boolean fpC = true;
    private boolean fpD = true;
    private boolean fpE = true;
    private boolean fpF = true;
    private boolean fpG = true;
    private boolean fpH = true;
    private boolean fpI = true;
    private boolean fpJ = true;
    private boolean fpK = true;
    private boolean fpx = true;
    private boolean fpy = true;
    private boolean fpz = true;

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
                } else if (fkj == hashCode) {
                    this.field_appId = cursor.getString(i2);
                } else if (fpL == hashCode) {
                    this.field_brandList = cursor.getString(i2);
                } else if (fpM == hashCode) {
                    this.field_brandListVersion = cursor.getString(i2);
                } else if (fpN == hashCode) {
                    this.field_brandListContent = cursor.getString(i2);
                } else if (fpO == hashCode) {
                    this.field_brandFlag = cursor.getInt(i2);
                } else if (fpP == hashCode) {
                    this.field_extInfo = cursor.getString(i2);
                } else if (fpQ == hashCode) {
                    this.field_brandInfo = cursor.getString(i2);
                } else if (fpR == hashCode) {
                    this.field_brandIconURL = cursor.getString(i2);
                } else if (updateTime_HASHCODE == hashCode) {
                    this.field_updateTime = cursor.getLong(i2);
                } else if (fpS == hashCode) {
                    this.field_hadAlert = cursor.getInt(i2);
                } else if (fpT == hashCode) {
                    this.field_acceptType = cursor.getInt(i2);
                } else if (type_HASHCODE == hashCode) {
                    this.field_type = cursor.getInt(i2);
                } else if (fjl == hashCode) {
                    this.field_status = cursor.getInt(i2);
                } else if (fpU == hashCode) {
                    this.field_enterpriseFather = cursor.getString(i2);
                } else if (fpV == hashCode) {
                    this.field_kfWorkerId = cursor.getString(i2);
                } else if (fpW == hashCode) {
                    this.field_specialType = cursor.getInt(i2);
                } else if (fpX == hashCode) {
                    this.field_attrSyncVersion = cursor.getString(i2);
                } else if (fpY == hashCode) {
                    this.field_incrementUpdateTime = cursor.getLong(i2);
                } else if (foC == hashCode) {
                    this.field_bitFlag = cursor.getInt(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.__hadSetusername) {
            contentValues.put(ch.COL_USERNAME, this.field_username);
        }
        if (this.fjS) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.field_brandList == null) {
            this.field_brandList = "";
        }
        if (this.fpx) {
            contentValues.put("brandList", this.field_brandList);
        }
        if (this.fpy) {
            contentValues.put("brandListVersion", this.field_brandListVersion);
        }
        if (this.fpz) {
            contentValues.put("brandListContent", this.field_brandListContent);
        }
        if (this.fpA) {
            contentValues.put("brandFlag", Integer.valueOf(this.field_brandFlag));
        }
        if (this.fpB) {
            contentValues.put(IssueStorage.COLUMN_EXT_INFO, this.field_extInfo);
        }
        if (this.fpC) {
            contentValues.put("brandInfo", this.field_brandInfo);
        }
        if (this.fpD) {
            contentValues.put("brandIconURL", this.field_brandIconURL);
        }
        if (this.__hadSetupdateTime) {
            contentValues.put(ch.COL_UPDATETIME, Long.valueOf(this.field_updateTime));
        }
        if (this.fpE) {
            contentValues.put("hadAlert", Integer.valueOf(this.field_hadAlert));
        }
        if (this.fpF) {
            contentValues.put("acceptType", Integer.valueOf(this.field_acceptType));
        }
        if (this.__hadSettype) {
            contentValues.put("type", Integer.valueOf(this.field_type));
        }
        if (this.fji) {
            contentValues.put("status", Integer.valueOf(this.field_status));
        }
        if (this.fpG) {
            contentValues.put("enterpriseFather", this.field_enterpriseFather);
        }
        if (this.fpH) {
            contentValues.put("kfWorkerId", this.field_kfWorkerId);
        }
        if (this.fpI) {
            contentValues.put("specialType", Integer.valueOf(this.field_specialType));
        }
        if (this.fpJ) {
            contentValues.put("attrSyncVersion", this.field_attrSyncVersion);
        }
        if (this.fpK) {
            contentValues.put("incrementUpdateTime", Long.valueOf(this.field_incrementUpdateTime));
        }
        if (this.fop) {
            contentValues.put("bitFlag", Integer.valueOf(this.field_bitFlag));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
