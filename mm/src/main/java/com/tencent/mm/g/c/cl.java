package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public abstract class cl extends IAutoDBItem {
    public static final String[] INDEX_CREATE = {"CREATE INDEX IF NOT EXISTS Finder_MediaCache_media_id ON FinderMediaCacheInfoV2(mediaId)", "CREATE INDEX IF NOT EXISTS Finder_MediaCache_state ON FinderMediaCacheInfoV2(state)", "CREATE INDEX IF NOT EXISTS Finder_MediaCache_origin_media_id ON FinderMediaCacheInfoV2(originMediaId)", "CREATE INDEX IF NOT EXISTS Finder_MediaCache_fileFormat ON FinderMediaCacheInfoV2(fileFormat)", "CREATE INDEX IF NOT EXISTS Finder_MediaCache_updateTime ON FinderMediaCacheInfoV2(updateTime)"};
    private static final int fCx = "totalSize".hashCode();
    private static final int fEV = "cacheSize".hashCode();
    private static final int fEW = "hasPlayed".hashCode();
    private static final int fEX = "reqFormat".hashCode();
    private static final int fEY = "originMediaId".hashCode();
    private static final int fEZ = "fileFormat".hashCode();
    private static final int fFa = "moovReady".hashCode();
    private static final int fFb = "videoBitrate".hashCode();
    private static final int fFc = "audioBitrate".hashCode();
    private static final int fFd = "frameRate".hashCode();
    private static final int fFe = FFmpegMetadataRetriever.METADATA_KEY_DURATION.hashCode();
    private static final int fFf = "urlToken".hashCode();
    private static final int fFg = "decodeKey".hashCode();
    private static final int fkm = "mediaId".hashCode();
    private static final int fnB = "url".hashCode();
    private static final int fyj = "state".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private static final int updateTime_HASHCODE = ch.COL_UPDATETIME.hashCode();
    private boolean __hadSetupdateTime = true;
    private boolean fBT = true;
    private boolean fEJ = true;
    private boolean fEK = true;
    private boolean fEL = true;
    private boolean fEM = true;
    private boolean fEN = true;
    private boolean fEO = true;
    private boolean fEP = true;
    private boolean fEQ = true;
    private boolean fER = true;
    private boolean fES = true;
    private boolean fET = true;
    private boolean fEU = true;
    public int field_audioBitrate;
    public long field_cacheSize;
    public String field_decodeKey;
    public int field_duration;
    public String field_fileFormat;
    public int field_frameRate;
    public boolean field_hasPlayed;
    public String field_mediaId;
    public boolean field_moovReady;
    public String field_originMediaId;
    public int field_reqFormat;
    public int field_state;
    public long field_totalSize;
    public long field_updateTime;
    public String field_url;
    public String field_urlToken;
    public int field_videoBitrate;
    private boolean fjV = true;
    private boolean fnx = true;
    private boolean fxx = true;

    public static IAutoDBItem.MAutoDBInfo ajs() {
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[17];
        mAutoDBInfo.columns = new String[18];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "mediaId";
        mAutoDBInfo.colsMap.put("mediaId", "TEXT PRIMARY KEY ");
        sb.append(" mediaId TEXT PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "mediaId";
        mAutoDBInfo.columns[1] = "url";
        mAutoDBInfo.colsMap.put("url", "TEXT");
        sb.append(" url TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "totalSize";
        mAutoDBInfo.colsMap.put("totalSize", "LONG");
        sb.append(" totalSize LONG");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "cacheSize";
        mAutoDBInfo.colsMap.put("cacheSize", "LONG");
        sb.append(" cacheSize LONG");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "state";
        mAutoDBInfo.colsMap.put("state", "INTEGER");
        sb.append(" state INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "hasPlayed";
        mAutoDBInfo.colsMap.put("hasPlayed", "INTEGER");
        sb.append(" hasPlayed INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[6] = "reqFormat";
        mAutoDBInfo.colsMap.put("reqFormat", "INTEGER default '-1' ");
        sb.append(" reqFormat INTEGER default '-1' ");
        sb.append(", ");
        mAutoDBInfo.columns[7] = "originMediaId";
        mAutoDBInfo.colsMap.put("originMediaId", "TEXT");
        sb.append(" originMediaId TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[8] = "fileFormat";
        mAutoDBInfo.colsMap.put("fileFormat", "TEXT");
        sb.append(" fileFormat TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[9] = ch.COL_UPDATETIME;
        mAutoDBInfo.colsMap.put(ch.COL_UPDATETIME, "LONG");
        sb.append(" updateTime LONG");
        sb.append(", ");
        mAutoDBInfo.columns[10] = "moovReady";
        mAutoDBInfo.colsMap.put("moovReady", "INTEGER default 'false' ");
        sb.append(" moovReady INTEGER default 'false' ");
        sb.append(", ");
        mAutoDBInfo.columns[11] = "videoBitrate";
        mAutoDBInfo.colsMap.put("videoBitrate", "INTEGER default '0' ");
        sb.append(" videoBitrate INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[12] = "audioBitrate";
        mAutoDBInfo.colsMap.put("audioBitrate", "INTEGER default '0' ");
        sb.append(" audioBitrate INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[13] = "frameRate";
        mAutoDBInfo.colsMap.put("frameRate", "INTEGER default '0' ");
        sb.append(" frameRate INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[14] = FFmpegMetadataRetriever.METADATA_KEY_DURATION;
        mAutoDBInfo.colsMap.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, "INTEGER default '0' ");
        sb.append(" duration INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[15] = "urlToken";
        mAutoDBInfo.colsMap.put("urlToken", "TEXT default '' ");
        sb.append(" urlToken TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[16] = "decodeKey";
        mAutoDBInfo.colsMap.put("decodeKey", "TEXT default '' ");
        sb.append(" decodeKey TEXT default '' ");
        mAutoDBInfo.columns[17] = "rowid";
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
                if (fkm == hashCode) {
                    this.field_mediaId = cursor.getString(i2);
                    this.fjV = true;
                } else if (fnB == hashCode) {
                    this.field_url = cursor.getString(i2);
                } else if (fCx == hashCode) {
                    this.field_totalSize = cursor.getLong(i2);
                } else if (fEV == hashCode) {
                    this.field_cacheSize = cursor.getLong(i2);
                } else if (fyj == hashCode) {
                    this.field_state = cursor.getInt(i2);
                } else if (fEW == hashCode) {
                    this.field_hasPlayed = cursor.getInt(i2) != 0;
                } else if (fEX == hashCode) {
                    this.field_reqFormat = cursor.getInt(i2);
                } else if (fEY == hashCode) {
                    this.field_originMediaId = cursor.getString(i2);
                } else if (fEZ == hashCode) {
                    this.field_fileFormat = cursor.getString(i2);
                } else if (updateTime_HASHCODE == hashCode) {
                    this.field_updateTime = cursor.getLong(i2);
                } else if (fFa == hashCode) {
                    this.field_moovReady = cursor.getInt(i2) != 0;
                } else if (fFb == hashCode) {
                    this.field_videoBitrate = cursor.getInt(i2);
                } else if (fFc == hashCode) {
                    this.field_audioBitrate = cursor.getInt(i2);
                } else if (fFd == hashCode) {
                    this.field_frameRate = cursor.getInt(i2);
                } else if (fFe == hashCode) {
                    this.field_duration = cursor.getInt(i2);
                } else if (fFf == hashCode) {
                    this.field_urlToken = cursor.getString(i2);
                } else if (fFg == hashCode) {
                    this.field_decodeKey = cursor.getString(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.fjV) {
            contentValues.put("mediaId", this.field_mediaId);
        }
        if (this.fnx) {
            contentValues.put("url", this.field_url);
        }
        if (this.fBT) {
            contentValues.put("totalSize", Long.valueOf(this.field_totalSize));
        }
        if (this.fEJ) {
            contentValues.put("cacheSize", Long.valueOf(this.field_cacheSize));
        }
        if (this.fxx) {
            contentValues.put("state", Integer.valueOf(this.field_state));
        }
        if (this.fEK) {
            contentValues.put("hasPlayed", Boolean.valueOf(this.field_hasPlayed));
        }
        if (this.fEL) {
            contentValues.put("reqFormat", Integer.valueOf(this.field_reqFormat));
        }
        if (this.fEM) {
            contentValues.put("originMediaId", this.field_originMediaId);
        }
        if (this.fEN) {
            contentValues.put("fileFormat", this.field_fileFormat);
        }
        if (this.__hadSetupdateTime) {
            contentValues.put(ch.COL_UPDATETIME, Long.valueOf(this.field_updateTime));
        }
        if (this.fEO) {
            contentValues.put("moovReady", Boolean.valueOf(this.field_moovReady));
        }
        if (this.fEP) {
            contentValues.put("videoBitrate", Integer.valueOf(this.field_videoBitrate));
        }
        if (this.fEQ) {
            contentValues.put("audioBitrate", Integer.valueOf(this.field_audioBitrate));
        }
        if (this.fER) {
            contentValues.put("frameRate", Integer.valueOf(this.field_frameRate));
        }
        if (this.fES) {
            contentValues.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, Integer.valueOf(this.field_duration));
        }
        if (this.field_urlToken == null) {
            this.field_urlToken = "";
        }
        if (this.fET) {
            contentValues.put("urlToken", this.field_urlToken);
        }
        if (this.field_decodeKey == null) {
            this.field_decodeKey = "";
        }
        if (this.fEU) {
            contentValues.put("decodeKey", this.field_decodeKey);
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }

    public void reset() {
    }
}
