package com.tencent.mm.plugin.textstatus.h;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public abstract class a extends IAutoDBItem {
    private static final int GbD = "StatusID".hashCode();
    private static final int GbE = "TopicId".hashCode();
    private static final int GbF = "SourceID".hashCode();
    private static final int GbG = "TopicInfo".hashCode();
    private static final int GbH = "ClusterShowInfo".hashCode();
    private static final int GbI = "IconID".hashCode();
    private static final int GbJ = "MediaType".hashCode();
    private static final int GbK = "MediaUrl".hashCode();
    private static final int GbL = "MediaAESKey".hashCode();
    private static final int GbM = "MediaThumbUrl".hashCode();
    private static final int GbN = "MediaThumbAESKey".hashCode();
    private static final int GbO = "PoiID".hashCode();
    private static final int GbP = "PoiName".hashCode();
    private static final int GbQ = "Longitude".hashCode();
    private static final int GbR = "Latitude".hashCode();
    private static final int GbS = "Visibility".hashCode();
    private static final int GbT = "ExpireTime".hashCode();
    private static final int GbU = "LikeCount".hashCode();
    private static final int GbV = "backgroundId".hashCode();
    private static final int GbW = "option".hashCode();
    private static final int GbX = "mediaWidth".hashCode();
    private static final int GbY = "mediaHeight".hashCode();
    public static final String[] INDEX_CREATE = {"CREATE INDEX IF NOT EXISTS TextStatus_USERNAME_index ON TextStatus(UserName)"};
    private static final int fGA = "CreateTime".hashCode();
    private static final int fGC = "Description".hashCode();
    private static final int fGE = "UserName".hashCode();
    private static final int fyj = "state".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private boolean GbA = true;
    private boolean GbB = true;
    private boolean GbC = true;
    private boolean Gbh = true;
    private boolean Gbi = true;
    private boolean Gbj = true;
    private boolean Gbk = true;
    private boolean Gbl = true;
    private boolean Gbm = true;
    private boolean Gbn = true;
    private boolean Gbo = true;
    private boolean Gbp = true;
    private boolean Gbq = true;
    private boolean Gbr = true;
    private boolean Gbs = true;
    private boolean Gbt = true;
    private boolean Gbu = true;
    private boolean Gbv = true;
    private boolean Gbw = true;
    private boolean Gbx = true;
    private boolean Gby = true;
    private boolean Gbz = true;
    private boolean fGs = true;
    private boolean fGu = true;
    private boolean fGw = true;
    public byte[] field_ClusterShowInfo;
    public int field_CreateTime;
    public String field_Description;
    public int field_ExpireTime;
    public String field_IconID;
    public double field_Latitude;
    public int field_LikeCount;
    public double field_Longitude;
    public String field_MediaAESKey;
    public String field_MediaThumbAESKey;
    public String field_MediaThumbUrl;
    public int field_MediaType;
    public String field_MediaUrl;
    public String field_PoiID;
    public String field_PoiName;
    public String field_SourceID;
    public String field_StatusID;
    public String field_TopicId;
    public byte[] field_TopicInfo;
    public String field_UserName;
    public int field_Visibility;
    public String field_backgroundId;
    public int field_mediaHeight;
    public int field_mediaWidth;
    public Long field_option;
    public int field_state;
    private boolean fxx = true;

    public static IAutoDBItem.MAutoDBInfo ajs() {
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[26];
        mAutoDBInfo.columns = new String[27];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "UserName";
        mAutoDBInfo.colsMap.put("UserName", "TEXT");
        sb.append(" UserName TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[1] = "StatusID";
        mAutoDBInfo.colsMap.put("StatusID", "TEXT");
        sb.append(" StatusID TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "TopicId";
        mAutoDBInfo.colsMap.put("TopicId", "TEXT");
        sb.append(" TopicId TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "SourceID";
        mAutoDBInfo.colsMap.put("SourceID", "TEXT");
        sb.append(" SourceID TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "TopicInfo";
        mAutoDBInfo.colsMap.put("TopicInfo", "BLOB");
        sb.append(" TopicInfo BLOB");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "ClusterShowInfo";
        mAutoDBInfo.colsMap.put("ClusterShowInfo", "BLOB");
        sb.append(" ClusterShowInfo BLOB");
        sb.append(", ");
        mAutoDBInfo.columns[6] = "IconID";
        mAutoDBInfo.colsMap.put("IconID", "TEXT");
        sb.append(" IconID TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[7] = "Description";
        mAutoDBInfo.colsMap.put("Description", "TEXT");
        sb.append(" Description TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[8] = "MediaType";
        mAutoDBInfo.colsMap.put("MediaType", "INTEGER");
        sb.append(" MediaType INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[9] = "MediaUrl";
        mAutoDBInfo.colsMap.put("MediaUrl", "TEXT");
        sb.append(" MediaUrl TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[10] = "MediaAESKey";
        mAutoDBInfo.colsMap.put("MediaAESKey", "TEXT");
        sb.append(" MediaAESKey TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[11] = "MediaThumbUrl";
        mAutoDBInfo.colsMap.put("MediaThumbUrl", "TEXT");
        sb.append(" MediaThumbUrl TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[12] = "MediaThumbAESKey";
        mAutoDBInfo.colsMap.put("MediaThumbAESKey", "TEXT");
        sb.append(" MediaThumbAESKey TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[13] = "PoiID";
        mAutoDBInfo.colsMap.put("PoiID", "TEXT");
        sb.append(" PoiID TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[14] = "PoiName";
        mAutoDBInfo.colsMap.put("PoiName", "TEXT");
        sb.append(" PoiName TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[15] = "Longitude";
        mAutoDBInfo.colsMap.put("Longitude", "DOUBLE");
        sb.append(" Longitude DOUBLE");
        sb.append(", ");
        mAutoDBInfo.columns[16] = "Latitude";
        mAutoDBInfo.colsMap.put("Latitude", "DOUBLE");
        sb.append(" Latitude DOUBLE");
        sb.append(", ");
        mAutoDBInfo.columns[17] = "Visibility";
        mAutoDBInfo.colsMap.put("Visibility", "INTEGER");
        sb.append(" Visibility INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[18] = "CreateTime";
        mAutoDBInfo.colsMap.put("CreateTime", "INTEGER");
        sb.append(" CreateTime INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[19] = "ExpireTime";
        mAutoDBInfo.colsMap.put("ExpireTime", "INTEGER");
        sb.append(" ExpireTime INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[20] = "LikeCount";
        mAutoDBInfo.colsMap.put("LikeCount", "INTEGER");
        sb.append(" LikeCount INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[21] = "state";
        mAutoDBInfo.colsMap.put("state", "INTEGER");
        sb.append(" state INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[22] = "backgroundId";
        mAutoDBInfo.colsMap.put("backgroundId", "TEXT");
        sb.append(" backgroundId TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[23] = "option";
        mAutoDBInfo.colsMap.put("option", "LONG");
        sb.append(" option LONG");
        sb.append(", ");
        mAutoDBInfo.columns[24] = "mediaWidth";
        mAutoDBInfo.colsMap.put("mediaWidth", "INTEGER");
        sb.append(" mediaWidth INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[25] = "mediaHeight";
        mAutoDBInfo.colsMap.put("mediaHeight", "INTEGER");
        sb.append(" mediaHeight INTEGER");
        mAutoDBInfo.columns[26] = "rowid";
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
                if (fGE == hashCode) {
                    this.field_UserName = cursor.getString(i2);
                } else if (GbD == hashCode) {
                    this.field_StatusID = cursor.getString(i2);
                } else if (GbE == hashCode) {
                    this.field_TopicId = cursor.getString(i2);
                } else if (GbF == hashCode) {
                    this.field_SourceID = cursor.getString(i2);
                } else if (GbG == hashCode) {
                    this.field_TopicInfo = cursor.getBlob(i2);
                } else if (GbH == hashCode) {
                    this.field_ClusterShowInfo = cursor.getBlob(i2);
                } else if (GbI == hashCode) {
                    this.field_IconID = cursor.getString(i2);
                } else if (fGC == hashCode) {
                    this.field_Description = cursor.getString(i2);
                } else if (GbJ == hashCode) {
                    this.field_MediaType = cursor.getInt(i2);
                } else if (GbK == hashCode) {
                    this.field_MediaUrl = cursor.getString(i2);
                } else if (GbL == hashCode) {
                    this.field_MediaAESKey = cursor.getString(i2);
                } else if (GbM == hashCode) {
                    this.field_MediaThumbUrl = cursor.getString(i2);
                } else if (GbN == hashCode) {
                    this.field_MediaThumbAESKey = cursor.getString(i2);
                } else if (GbO == hashCode) {
                    this.field_PoiID = cursor.getString(i2);
                } else if (GbP == hashCode) {
                    this.field_PoiName = cursor.getString(i2);
                } else if (GbQ == hashCode) {
                    this.field_Longitude = cursor.getDouble(i2);
                } else if (GbR == hashCode) {
                    this.field_Latitude = cursor.getDouble(i2);
                } else if (GbS == hashCode) {
                    this.field_Visibility = cursor.getInt(i2);
                } else if (fGA == hashCode) {
                    this.field_CreateTime = cursor.getInt(i2);
                } else if (GbT == hashCode) {
                    this.field_ExpireTime = cursor.getInt(i2);
                } else if (GbU == hashCode) {
                    this.field_LikeCount = cursor.getInt(i2);
                } else if (fyj == hashCode) {
                    this.field_state = cursor.getInt(i2);
                } else if (GbV == hashCode) {
                    this.field_backgroundId = cursor.getString(i2);
                } else if (GbW == hashCode) {
                    this.field_option = Long.valueOf(cursor.getLong(i2));
                } else if (GbX == hashCode) {
                    this.field_mediaWidth = cursor.getInt(i2);
                } else if (GbY == hashCode) {
                    this.field_mediaHeight = cursor.getInt(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.fGw) {
            contentValues.put("UserName", this.field_UserName);
        }
        if (this.Gbh) {
            contentValues.put("StatusID", this.field_StatusID);
        }
        if (this.Gbi) {
            contentValues.put("TopicId", this.field_TopicId);
        }
        if (this.Gbj) {
            contentValues.put("SourceID", this.field_SourceID);
        }
        if (this.Gbk) {
            contentValues.put("TopicInfo", this.field_TopicInfo);
        }
        if (this.Gbl) {
            contentValues.put("ClusterShowInfo", this.field_ClusterShowInfo);
        }
        if (this.Gbm) {
            contentValues.put("IconID", this.field_IconID);
        }
        if (this.fGu) {
            contentValues.put("Description", this.field_Description);
        }
        if (this.Gbn) {
            contentValues.put("MediaType", Integer.valueOf(this.field_MediaType));
        }
        if (this.Gbo) {
            contentValues.put("MediaUrl", this.field_MediaUrl);
        }
        if (this.Gbp) {
            contentValues.put("MediaAESKey", this.field_MediaAESKey);
        }
        if (this.Gbq) {
            contentValues.put("MediaThumbUrl", this.field_MediaThumbUrl);
        }
        if (this.Gbr) {
            contentValues.put("MediaThumbAESKey", this.field_MediaThumbAESKey);
        }
        if (this.Gbs) {
            contentValues.put("PoiID", this.field_PoiID);
        }
        if (this.Gbt) {
            contentValues.put("PoiName", this.field_PoiName);
        }
        if (this.Gbu) {
            contentValues.put("Longitude", Double.valueOf(this.field_Longitude));
        }
        if (this.Gbv) {
            contentValues.put("Latitude", Double.valueOf(this.field_Latitude));
        }
        if (this.Gbw) {
            contentValues.put("Visibility", Integer.valueOf(this.field_Visibility));
        }
        if (this.fGs) {
            contentValues.put("CreateTime", Integer.valueOf(this.field_CreateTime));
        }
        if (this.Gbx) {
            contentValues.put("ExpireTime", Integer.valueOf(this.field_ExpireTime));
        }
        if (this.Gby) {
            contentValues.put("LikeCount", Integer.valueOf(this.field_LikeCount));
        }
        if (this.fxx) {
            contentValues.put("state", Integer.valueOf(this.field_state));
        }
        if (this.Gbz) {
            contentValues.put("backgroundId", this.field_backgroundId);
        }
        if (this.GbA) {
            contentValues.put("option", this.field_option);
        }
        if (this.GbB) {
            contentValues.put("mediaWidth", Integer.valueOf(this.field_mediaWidth));
        }
        if (this.GbC) {
            contentValues.put("mediaHeight", Integer.valueOf(this.field_mediaHeight));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
