package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public abstract class gs extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fFe = FFmpegMetadataRetriever.METADATA_KEY_DURATION.hashCode();
    private static final int fyf = "md5".hashCode();
    private static final int gbA = "preLoadResource".hashCode();
    private static final int gbB = "userInfo".hashCode();
    private static final int gbC = "favoriteMd5".hashCode();
    private static final int gbD = "interactTime".hashCode();
    private static final int gbq = "userStoryFlag".hashCode();
    private static final int gbr = "newThumbUrl".hashCode();
    private static final int gbs = "newVideoUrl".hashCode();
    private static final int gbt = "syncId".hashCode();
    private static final int gbu = "readId".hashCode();
    private static final int gbv = "storyPostTime".hashCode();
    private static final int gbw = "storyObjOneDay".hashCode();
    private static final int gbx = "readTime".hashCode();
    private static final int gby = "preloadStoryId".hashCode();
    private static final int gbz = "preloadMediaId".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private static final int updateTime_HASHCODE = ch.COL_UPDATETIME.hashCode();
    private static final int userName_HASHCODE = "userName".hashCode();
    private boolean __hadSetupdateTime = true;
    private boolean __hadSetuserName = true;
    private boolean fES = true;
    public long field_duration;
    public String field_favoriteMd5;
    public long field_interactTime;
    public String field_md5;
    public String field_newThumbUrl;
    public String field_newVideoUrl;
    public long field_preLoadResource;
    public String field_preloadMediaId;
    public long field_preloadStoryId;
    public long field_readId;
    public long field_readTime;
    public int field_storyObjOneDay;
    public int field_storyPostTime;
    public long field_syncId;
    public long field_updateTime;
    public byte[] field_userInfo;
    public String field_userName;
    public int field_userStoryFlag;
    private boolean fxt = true;
    private boolean gbc = true;
    private boolean gbd = true;
    private boolean gbe = true;
    private boolean gbf = true;
    private boolean gbg = true;
    private boolean gbh = true;
    private boolean gbi = true;
    private boolean gbj = true;
    private boolean gbk = true;
    private boolean gbl = true;
    private boolean gbm = true;
    private boolean gbn = true;
    private boolean gbo = true;
    private boolean gbp = true;

    public static IAutoDBItem.MAutoDBInfo ajs() {
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[18];
        mAutoDBInfo.columns = new String[19];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "userName";
        mAutoDBInfo.colsMap.put("userName", "TEXT default ''  PRIMARY KEY ");
        sb.append(" userName TEXT default ''  PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "userName";
        mAutoDBInfo.columns[1] = "md5";
        mAutoDBInfo.colsMap.put("md5", "TEXT");
        sb.append(" md5 TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "userStoryFlag";
        mAutoDBInfo.colsMap.put("userStoryFlag", "INTEGER");
        sb.append(" userStoryFlag INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "newThumbUrl";
        mAutoDBInfo.colsMap.put("newThumbUrl", "TEXT");
        sb.append(" newThumbUrl TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "newVideoUrl";
        mAutoDBInfo.colsMap.put("newVideoUrl", "TEXT");
        sb.append(" newVideoUrl TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[5] = ch.COL_UPDATETIME;
        mAutoDBInfo.colsMap.put(ch.COL_UPDATETIME, "LONG");
        sb.append(" updateTime LONG");
        sb.append(", ");
        mAutoDBInfo.columns[6] = "syncId";
        mAutoDBInfo.colsMap.put("syncId", "LONG");
        sb.append(" syncId LONG");
        sb.append(", ");
        mAutoDBInfo.columns[7] = "readId";
        mAutoDBInfo.colsMap.put("readId", "LONG");
        sb.append(" readId LONG");
        sb.append(", ");
        mAutoDBInfo.columns[8] = "storyPostTime";
        mAutoDBInfo.colsMap.put("storyPostTime", "INTEGER");
        sb.append(" storyPostTime INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[9] = "storyObjOneDay";
        mAutoDBInfo.colsMap.put("storyObjOneDay", "INTEGER");
        sb.append(" storyObjOneDay INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[10] = "readTime";
        mAutoDBInfo.colsMap.put("readTime", "LONG");
        sb.append(" readTime LONG");
        sb.append(", ");
        mAutoDBInfo.columns[11] = "preloadStoryId";
        mAutoDBInfo.colsMap.put("preloadStoryId", "LONG");
        sb.append(" preloadStoryId LONG");
        sb.append(", ");
        mAutoDBInfo.columns[12] = "preloadMediaId";
        mAutoDBInfo.colsMap.put("preloadMediaId", "TEXT");
        sb.append(" preloadMediaId TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[13] = "preLoadResource";
        mAutoDBInfo.colsMap.put("preLoadResource", "LONG");
        sb.append(" preLoadResource LONG");
        sb.append(", ");
        mAutoDBInfo.columns[14] = FFmpegMetadataRetriever.METADATA_KEY_DURATION;
        mAutoDBInfo.colsMap.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, "LONG");
        sb.append(" duration LONG");
        sb.append(", ");
        mAutoDBInfo.columns[15] = "userInfo";
        mAutoDBInfo.colsMap.put("userInfo", "BLOB");
        sb.append(" userInfo BLOB");
        sb.append(", ");
        mAutoDBInfo.columns[16] = "favoriteMd5";
        mAutoDBInfo.colsMap.put("favoriteMd5", "TEXT");
        sb.append(" favoriteMd5 TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[17] = "interactTime";
        mAutoDBInfo.colsMap.put("interactTime", "LONG");
        sb.append(" interactTime LONG");
        mAutoDBInfo.columns[18] = "rowid";
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
                if (userName_HASHCODE == hashCode) {
                    this.field_userName = cursor.getString(i2);
                    this.__hadSetuserName = true;
                } else if (fyf == hashCode) {
                    this.field_md5 = cursor.getString(i2);
                } else if (gbq == hashCode) {
                    this.field_userStoryFlag = cursor.getInt(i2);
                } else if (gbr == hashCode) {
                    this.field_newThumbUrl = cursor.getString(i2);
                } else if (gbs == hashCode) {
                    this.field_newVideoUrl = cursor.getString(i2);
                } else if (updateTime_HASHCODE == hashCode) {
                    this.field_updateTime = cursor.getLong(i2);
                } else if (gbt == hashCode) {
                    this.field_syncId = cursor.getLong(i2);
                } else if (gbu == hashCode) {
                    this.field_readId = cursor.getLong(i2);
                } else if (gbv == hashCode) {
                    this.field_storyPostTime = cursor.getInt(i2);
                } else if (gbw == hashCode) {
                    this.field_storyObjOneDay = cursor.getInt(i2);
                } else if (gbx == hashCode) {
                    this.field_readTime = cursor.getLong(i2);
                } else if (gby == hashCode) {
                    this.field_preloadStoryId = cursor.getLong(i2);
                } else if (gbz == hashCode) {
                    this.field_preloadMediaId = cursor.getString(i2);
                } else if (gbA == hashCode) {
                    this.field_preLoadResource = cursor.getLong(i2);
                } else if (fFe == hashCode) {
                    this.field_duration = cursor.getLong(i2);
                } else if (gbB == hashCode) {
                    this.field_userInfo = cursor.getBlob(i2);
                } else if (gbC == hashCode) {
                    this.field_favoriteMd5 = cursor.getString(i2);
                } else if (gbD == hashCode) {
                    this.field_interactTime = cursor.getLong(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.field_userName == null) {
            this.field_userName = "";
        }
        if (this.__hadSetuserName) {
            contentValues.put("userName", this.field_userName);
        }
        if (this.fxt) {
            contentValues.put("md5", this.field_md5);
        }
        if (this.gbc) {
            contentValues.put("userStoryFlag", Integer.valueOf(this.field_userStoryFlag));
        }
        if (this.gbd) {
            contentValues.put("newThumbUrl", this.field_newThumbUrl);
        }
        if (this.gbe) {
            contentValues.put("newVideoUrl", this.field_newVideoUrl);
        }
        if (this.__hadSetupdateTime) {
            contentValues.put(ch.COL_UPDATETIME, Long.valueOf(this.field_updateTime));
        }
        if (this.gbf) {
            contentValues.put("syncId", Long.valueOf(this.field_syncId));
        }
        if (this.gbg) {
            contentValues.put("readId", Long.valueOf(this.field_readId));
        }
        if (this.gbh) {
            contentValues.put("storyPostTime", Integer.valueOf(this.field_storyPostTime));
        }
        if (this.gbi) {
            contentValues.put("storyObjOneDay", Integer.valueOf(this.field_storyObjOneDay));
        }
        if (this.gbj) {
            contentValues.put("readTime", Long.valueOf(this.field_readTime));
        }
        if (this.gbk) {
            contentValues.put("preloadStoryId", Long.valueOf(this.field_preloadStoryId));
        }
        if (this.gbl) {
            contentValues.put("preloadMediaId", this.field_preloadMediaId);
        }
        if (this.gbm) {
            contentValues.put("preLoadResource", Long.valueOf(this.field_preLoadResource));
        }
        if (this.fES) {
            contentValues.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, Long.valueOf(this.field_duration));
        }
        if (this.gbn) {
            contentValues.put("userInfo", this.field_userInfo);
        }
        if (this.gbo) {
            contentValues.put("favoriteMd5", this.field_favoriteMd5);
        }
        if (this.gbp) {
            contentValues.put("interactTime", Long.valueOf(this.field_interactTime));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
