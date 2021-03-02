package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public abstract class bv extends IAutoDBItem {
    public static final String[] INDEX_CREATE = {"CREATE INDEX IF NOT EXISTS FavCdnTransferInfo_LocalId ON FavCdnInfo(favLocalId)", "CREATE INDEX IF NOT EXISTS FavCDNInfo_modifyTime_Index ON FavCdnInfo(modifyTime)"};
    private static final int fAq = "dataId".hashCode();
    private static final int fAr = "favLocalId".hashCode();
    private static final int fAs = "cdnKey".hashCode();
    private static final int fAt = "extFlag".hashCode();
    private static final int fAu = "attrFlag".hashCode();
    private static final int fjl = "status".hashCode();
    private static final int fkH = "path".hashCode();
    private static final int fkW = "dataType".hashCode();
    private static final int fko = "totalLen".hashCode();
    private static final int fkp = "offset".hashCode();
    private static final int fmm = "modifyTime".hashCode();
    private static final int fyw = "cdnUrl".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private static final int type_HASHCODE = "type".hashCode();
    private boolean __hadSettype = true;
    private boolean fAl = true;
    private boolean fAm = true;
    private boolean fAn = true;
    private boolean fAo = true;
    private boolean fAp = true;
    public long field_attrFlag;
    public String field_cdnKey;
    public String field_cdnUrl;
    public String field_dataId;
    public int field_dataType;
    public int field_extFlag;
    public long field_favLocalId;
    public long field_modifyTime;
    public int field_offset;
    public String field_path;
    public int field_status;
    public int field_totalLen;
    public int field_type;
    private boolean fjX = true;
    private boolean fjY = true;
    private boolean fji = true;
    private boolean fkD = true;
    private boolean fkU = true;
    private boolean flQ = true;
    private boolean fxK = true;

    public static IAutoDBItem.MAutoDBInfo ajs() {
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[13];
        mAutoDBInfo.columns = new String[14];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "dataId";
        mAutoDBInfo.colsMap.put("dataId", "TEXT PRIMARY KEY ");
        sb.append(" dataId TEXT PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "dataId";
        mAutoDBInfo.columns[1] = "favLocalId";
        mAutoDBInfo.colsMap.put("favLocalId", "LONG");
        sb.append(" favLocalId LONG");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "type";
        mAutoDBInfo.colsMap.put("type", "INTEGER");
        sb.append(" type INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "cdnUrl";
        mAutoDBInfo.colsMap.put("cdnUrl", "TEXT");
        sb.append(" cdnUrl TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "cdnKey";
        mAutoDBInfo.colsMap.put("cdnKey", "TEXT");
        sb.append(" cdnKey TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "totalLen";
        mAutoDBInfo.colsMap.put("totalLen", "INTEGER");
        sb.append(" totalLen INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[6] = "offset";
        mAutoDBInfo.colsMap.put("offset", "INTEGER");
        sb.append(" offset INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[7] = "status";
        mAutoDBInfo.colsMap.put("status", "INTEGER");
        sb.append(" status INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[8] = "path";
        mAutoDBInfo.colsMap.put("path", "TEXT");
        sb.append(" path TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[9] = "dataType";
        mAutoDBInfo.colsMap.put("dataType", "INTEGER");
        sb.append(" dataType INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[10] = "modifyTime";
        mAutoDBInfo.colsMap.put("modifyTime", "LONG default '0' ");
        sb.append(" modifyTime LONG default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[11] = "extFlag";
        mAutoDBInfo.colsMap.put("extFlag", "INTEGER default '0' ");
        sb.append(" extFlag INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[12] = "attrFlag";
        mAutoDBInfo.colsMap.put("attrFlag", "LONG default '0' ");
        sb.append(" attrFlag LONG default '0' ");
        mAutoDBInfo.columns[13] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        return mAutoDBInfo;
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fAq == hashCode) {
                    this.field_dataId = cursor.getString(i2);
                    this.fAl = true;
                } else if (fAr == hashCode) {
                    this.field_favLocalId = cursor.getLong(i2);
                } else if (type_HASHCODE == hashCode) {
                    this.field_type = cursor.getInt(i2);
                } else if (fyw == hashCode) {
                    this.field_cdnUrl = cursor.getString(i2);
                } else if (fAs == hashCode) {
                    this.field_cdnKey = cursor.getString(i2);
                } else if (fko == hashCode) {
                    this.field_totalLen = cursor.getInt(i2);
                } else if (fkp == hashCode) {
                    this.field_offset = cursor.getInt(i2);
                } else if (fjl == hashCode) {
                    this.field_status = cursor.getInt(i2);
                } else if (fkH == hashCode) {
                    this.field_path = cursor.getString(i2);
                } else if (fkW == hashCode) {
                    this.field_dataType = cursor.getInt(i2);
                } else if (fmm == hashCode) {
                    this.field_modifyTime = cursor.getLong(i2);
                } else if (fAt == hashCode) {
                    this.field_extFlag = cursor.getInt(i2);
                } else if (fAu == hashCode) {
                    this.field_attrFlag = cursor.getLong(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.fAl) {
            contentValues.put("dataId", this.field_dataId);
        }
        if (this.fAm) {
            contentValues.put("favLocalId", Long.valueOf(this.field_favLocalId));
        }
        if (this.__hadSettype) {
            contentValues.put("type", Integer.valueOf(this.field_type));
        }
        if (this.fxK) {
            contentValues.put("cdnUrl", this.field_cdnUrl);
        }
        if (this.fAn) {
            contentValues.put("cdnKey", this.field_cdnKey);
        }
        if (this.fjX) {
            contentValues.put("totalLen", Integer.valueOf(this.field_totalLen));
        }
        if (this.fjY) {
            contentValues.put("offset", Integer.valueOf(this.field_offset));
        }
        if (this.fji) {
            contentValues.put("status", Integer.valueOf(this.field_status));
        }
        if (this.fkD) {
            contentValues.put("path", this.field_path);
        }
        if (this.fkU) {
            contentValues.put("dataType", Integer.valueOf(this.field_dataType));
        }
        if (this.flQ) {
            contentValues.put("modifyTime", Long.valueOf(this.field_modifyTime));
        }
        if (this.fAo) {
            contentValues.put("extFlag", Integer.valueOf(this.field_extFlag));
        }
        if (this.fAp) {
            contentValues.put("attrFlag", Long.valueOf(this.field_attrFlag));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
