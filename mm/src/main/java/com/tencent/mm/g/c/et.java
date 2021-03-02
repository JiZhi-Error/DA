package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public abstract class et extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fSA = "songHAlbumUrl".hashCode();
    private static final int fSB = "songAlbumLocalPath".hashCode();
    private static final int fSC = "songWifiUrl".hashCode();
    private static final int fSD = "songWapLinkUrl".hashCode();
    private static final int fSE = "songWebUrl".hashCode();
    private static final int fSF = "songMediaId".hashCode();
    private static final int fSG = "songSnsAlbumUser".hashCode();
    private static final int fSH = "songSnsShareUser".hashCode();
    private static final int fSI = "songLyric".hashCode();
    private static final int fSJ = "songBgColor".hashCode();
    private static final int fSK = "songLyricColor".hashCode();
    private static final int fSL = "songFileLength".hashCode();
    private static final int fSM = "songWifiFileLength".hashCode();
    private static final int fSN = "hideBanner".hashCode();
    private static final int fSO = "jsWebUrlDomain".hashCode();
    private static final int fSP = "isBlock".hashCode();
    private static final int fSQ = "mimetype".hashCode();
    private static final int fSR = "protocol".hashCode();
    private static final int fSS = "barBackToWebView".hashCode();
    private static final int fST = "musicbar_url".hashCode();
    private static final int fSU = "srcUsername".hashCode();
    private static final int fSV = "playbackRate".hashCode();
    private static final int fSW = "songMId".hashCode();
    private static final int fSn = "musicId".hashCode();
    private static final int fSo = "originMusicId".hashCode();
    private static final int fSp = "musicType".hashCode();
    private static final int fSq = "downloadedLength".hashCode();
    private static final int fSr = "wifiDownloadedLength".hashCode();
    private static final int fSs = "endFlag".hashCode();
    private static final int fSt = "wifiEndFlag".hashCode();
    private static final int fSu = "songId".hashCode();
    private static final int fSv = "songName".hashCode();
    private static final int fSw = "songSinger".hashCode();
    private static final int fSx = "songAlbum".hashCode();
    private static final int fSy = "songAlbumType".hashCode();
    private static final int fSz = "songAlbumUrl".hashCode();
    private static final int fjx = "startTime".hashCode();
    private static final int fkj = "appId".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private static final int updateTime_HASHCODE = ch.COL_UPDATETIME.hashCode();
    private boolean __hadSetupdateTime = true;
    private boolean fRD = true;
    private boolean fRE = true;
    private boolean fRF = true;
    private boolean fRG = true;
    private boolean fRH = true;
    private boolean fRI = true;
    private boolean fRJ = true;
    private boolean fRK = true;
    private boolean fRL = true;
    private boolean fRM = true;
    private boolean fRN = true;
    private boolean fRO = true;
    private boolean fRP = true;
    private boolean fRQ = true;
    private boolean fRR = true;
    private boolean fRS = true;
    private boolean fRT = true;
    private boolean fRU = true;
    private boolean fRV = true;
    private boolean fRW = true;
    private boolean fRX = true;
    private boolean fRY = true;
    private boolean fRZ = true;
    private boolean fSa = true;
    private boolean fSb = true;
    private boolean fSc = true;
    private boolean fSd = true;
    private boolean fSe = true;
    private boolean fSf = true;
    private boolean fSg = true;
    private boolean fSh = true;
    private boolean fSi = true;
    private boolean fSj = true;
    private boolean fSk = true;
    private boolean fSl = true;
    private boolean fSm = true;
    public String field_appId;
    public boolean field_barBackToWebView;
    public long field_downloadedLength;
    public int field_endFlag;
    public boolean field_hideBanner;
    public int field_isBlock;
    public String field_jsWebUrlDomain;
    public String field_mimetype;
    public String field_musicId;
    public int field_musicType;
    public String field_musicbar_url;
    public String field_originMusicId;
    public double field_playbackRate;
    public String field_protocol;
    public String field_songAlbum;
    public String field_songAlbumLocalPath;
    public int field_songAlbumType;
    public String field_songAlbumUrl;
    public int field_songBgColor;
    public long field_songFileLength;
    public String field_songHAlbumUrl;
    public int field_songId;
    public String field_songLyric;
    public int field_songLyricColor;
    public String field_songMId;
    public String field_songMediaId;
    public String field_songName;
    public String field_songSinger;
    public String field_songSnsAlbumUser;
    public String field_songSnsShareUser;
    public String field_songWapLinkUrl;
    public String field_songWebUrl;
    public long field_songWifiFileLength;
    public String field_songWifiUrl;
    public String field_srcUsername;
    public int field_startTime;
    public long field_updateTime;
    public long field_wifiDownloadedLength;
    public int field_wifiEndFlag;
    private boolean fjS = true;
    private boolean fjq = true;

    public static IAutoDBItem.MAutoDBInfo ajs() {
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[39];
        mAutoDBInfo.columns = new String[40];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "musicId";
        mAutoDBInfo.colsMap.put("musicId", "TEXT PRIMARY KEY ");
        sb.append(" musicId TEXT PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "musicId";
        mAutoDBInfo.columns[1] = "originMusicId";
        mAutoDBInfo.colsMap.put("originMusicId", "TEXT");
        sb.append(" originMusicId TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "musicType";
        mAutoDBInfo.colsMap.put("musicType", "INTEGER");
        sb.append(" musicType INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "downloadedLength";
        mAutoDBInfo.colsMap.put("downloadedLength", "LONG");
        sb.append(" downloadedLength LONG");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "wifiDownloadedLength";
        mAutoDBInfo.colsMap.put("wifiDownloadedLength", "LONG");
        sb.append(" wifiDownloadedLength LONG");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "endFlag";
        mAutoDBInfo.colsMap.put("endFlag", "INTEGER");
        sb.append(" endFlag INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[6] = "wifiEndFlag";
        mAutoDBInfo.colsMap.put("wifiEndFlag", "INTEGER");
        sb.append(" wifiEndFlag INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[7] = ch.COL_UPDATETIME;
        mAutoDBInfo.colsMap.put(ch.COL_UPDATETIME, "LONG");
        sb.append(" updateTime LONG");
        sb.append(", ");
        mAutoDBInfo.columns[8] = "songId";
        mAutoDBInfo.colsMap.put("songId", "INTEGER");
        sb.append(" songId INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[9] = "songName";
        mAutoDBInfo.colsMap.put("songName", "TEXT");
        sb.append(" songName TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[10] = "songSinger";
        mAutoDBInfo.colsMap.put("songSinger", "TEXT");
        sb.append(" songSinger TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[11] = "songAlbum";
        mAutoDBInfo.colsMap.put("songAlbum", "TEXT");
        sb.append(" songAlbum TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[12] = "songAlbumType";
        mAutoDBInfo.colsMap.put("songAlbumType", "INTEGER");
        sb.append(" songAlbumType INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[13] = "songAlbumUrl";
        mAutoDBInfo.colsMap.put("songAlbumUrl", "TEXT");
        sb.append(" songAlbumUrl TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[14] = "songHAlbumUrl";
        mAutoDBInfo.colsMap.put("songHAlbumUrl", "TEXT");
        sb.append(" songHAlbumUrl TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[15] = "songAlbumLocalPath";
        mAutoDBInfo.colsMap.put("songAlbumLocalPath", "TEXT");
        sb.append(" songAlbumLocalPath TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[16] = "songWifiUrl";
        mAutoDBInfo.colsMap.put("songWifiUrl", "TEXT");
        sb.append(" songWifiUrl TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[17] = "songWapLinkUrl";
        mAutoDBInfo.colsMap.put("songWapLinkUrl", "TEXT");
        sb.append(" songWapLinkUrl TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[18] = "songWebUrl";
        mAutoDBInfo.colsMap.put("songWebUrl", "TEXT");
        sb.append(" songWebUrl TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[19] = "appId";
        mAutoDBInfo.colsMap.put("appId", "TEXT");
        sb.append(" appId TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[20] = "songMediaId";
        mAutoDBInfo.colsMap.put("songMediaId", "TEXT");
        sb.append(" songMediaId TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[21] = "songSnsAlbumUser";
        mAutoDBInfo.colsMap.put("songSnsAlbumUser", "TEXT");
        sb.append(" songSnsAlbumUser TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[22] = "songSnsShareUser";
        mAutoDBInfo.colsMap.put("songSnsShareUser", "TEXT");
        sb.append(" songSnsShareUser TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[23] = "songLyric";
        mAutoDBInfo.colsMap.put("songLyric", "TEXT");
        sb.append(" songLyric TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[24] = "songBgColor";
        mAutoDBInfo.colsMap.put("songBgColor", "INTEGER");
        sb.append(" songBgColor INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[25] = "songLyricColor";
        mAutoDBInfo.colsMap.put("songLyricColor", "INTEGER");
        sb.append(" songLyricColor INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[26] = "songFileLength";
        mAutoDBInfo.colsMap.put("songFileLength", "LONG");
        sb.append(" songFileLength LONG");
        sb.append(", ");
        mAutoDBInfo.columns[27] = "songWifiFileLength";
        mAutoDBInfo.colsMap.put("songWifiFileLength", "LONG");
        sb.append(" songWifiFileLength LONG");
        sb.append(", ");
        mAutoDBInfo.columns[28] = "hideBanner";
        mAutoDBInfo.colsMap.put("hideBanner", "INTEGER");
        sb.append(" hideBanner INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[29] = "jsWebUrlDomain";
        mAutoDBInfo.colsMap.put("jsWebUrlDomain", "TEXT");
        sb.append(" jsWebUrlDomain TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[30] = "isBlock";
        mAutoDBInfo.colsMap.put("isBlock", "INTEGER");
        sb.append(" isBlock INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[31] = "startTime";
        mAutoDBInfo.colsMap.put("startTime", "INTEGER");
        sb.append(" startTime INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[32] = "mimetype";
        mAutoDBInfo.colsMap.put("mimetype", "TEXT");
        sb.append(" mimetype TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[33] = "protocol";
        mAutoDBInfo.colsMap.put("protocol", "TEXT");
        sb.append(" protocol TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[34] = "barBackToWebView";
        mAutoDBInfo.colsMap.put("barBackToWebView", "INTEGER");
        sb.append(" barBackToWebView INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[35] = "musicbar_url";
        mAutoDBInfo.colsMap.put("musicbar_url", "TEXT");
        sb.append(" musicbar_url TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[36] = "srcUsername";
        mAutoDBInfo.colsMap.put("srcUsername", "TEXT");
        sb.append(" srcUsername TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[37] = "playbackRate";
        mAutoDBInfo.colsMap.put("playbackRate", "DOUBLE");
        sb.append(" playbackRate DOUBLE");
        sb.append(", ");
        mAutoDBInfo.columns[38] = "songMId";
        mAutoDBInfo.colsMap.put("songMId", "TEXT");
        sb.append(" songMId TEXT");
        mAutoDBInfo.columns[39] = "rowid";
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
                if (fSn == hashCode) {
                    this.field_musicId = cursor.getString(i2);
                    this.fRD = true;
                } else if (fSo == hashCode) {
                    this.field_originMusicId = cursor.getString(i2);
                } else if (fSp == hashCode) {
                    this.field_musicType = cursor.getInt(i2);
                } else if (fSq == hashCode) {
                    this.field_downloadedLength = cursor.getLong(i2);
                } else if (fSr == hashCode) {
                    this.field_wifiDownloadedLength = cursor.getLong(i2);
                } else if (fSs == hashCode) {
                    this.field_endFlag = cursor.getInt(i2);
                } else if (fSt == hashCode) {
                    this.field_wifiEndFlag = cursor.getInt(i2);
                } else if (updateTime_HASHCODE == hashCode) {
                    this.field_updateTime = cursor.getLong(i2);
                } else if (fSu == hashCode) {
                    this.field_songId = cursor.getInt(i2);
                } else if (fSv == hashCode) {
                    this.field_songName = cursor.getString(i2);
                } else if (fSw == hashCode) {
                    this.field_songSinger = cursor.getString(i2);
                } else if (fSx == hashCode) {
                    this.field_songAlbum = cursor.getString(i2);
                } else if (fSy == hashCode) {
                    this.field_songAlbumType = cursor.getInt(i2);
                } else if (fSz == hashCode) {
                    this.field_songAlbumUrl = cursor.getString(i2);
                } else if (fSA == hashCode) {
                    this.field_songHAlbumUrl = cursor.getString(i2);
                } else if (fSB == hashCode) {
                    this.field_songAlbumLocalPath = cursor.getString(i2);
                } else if (fSC == hashCode) {
                    this.field_songWifiUrl = cursor.getString(i2);
                } else if (fSD == hashCode) {
                    this.field_songWapLinkUrl = cursor.getString(i2);
                } else if (fSE == hashCode) {
                    this.field_songWebUrl = cursor.getString(i2);
                } else if (fkj == hashCode) {
                    this.field_appId = cursor.getString(i2);
                } else if (fSF == hashCode) {
                    this.field_songMediaId = cursor.getString(i2);
                } else if (fSG == hashCode) {
                    this.field_songSnsAlbumUser = cursor.getString(i2);
                } else if (fSH == hashCode) {
                    this.field_songSnsShareUser = cursor.getString(i2);
                } else if (fSI == hashCode) {
                    this.field_songLyric = cursor.getString(i2);
                } else if (fSJ == hashCode) {
                    this.field_songBgColor = cursor.getInt(i2);
                } else if (fSK == hashCode) {
                    this.field_songLyricColor = cursor.getInt(i2);
                } else if (fSL == hashCode) {
                    this.field_songFileLength = cursor.getLong(i2);
                } else if (fSM == hashCode) {
                    this.field_songWifiFileLength = cursor.getLong(i2);
                } else if (fSN == hashCode) {
                    this.field_hideBanner = cursor.getInt(i2) != 0;
                } else if (fSO == hashCode) {
                    this.field_jsWebUrlDomain = cursor.getString(i2);
                } else if (fSP == hashCode) {
                    this.field_isBlock = cursor.getInt(i2);
                } else if (fjx == hashCode) {
                    this.field_startTime = cursor.getInt(i2);
                } else if (fSQ == hashCode) {
                    this.field_mimetype = cursor.getString(i2);
                } else if (fSR == hashCode) {
                    this.field_protocol = cursor.getString(i2);
                } else if (fSS == hashCode) {
                    this.field_barBackToWebView = cursor.getInt(i2) != 0;
                } else if (fST == hashCode) {
                    this.field_musicbar_url = cursor.getString(i2);
                } else if (fSU == hashCode) {
                    this.field_srcUsername = cursor.getString(i2);
                } else if (fSV == hashCode) {
                    this.field_playbackRate = cursor.getDouble(i2);
                } else if (fSW == hashCode) {
                    this.field_songMId = cursor.getString(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.fRD) {
            contentValues.put("musicId", this.field_musicId);
        }
        if (this.fRE) {
            contentValues.put("originMusicId", this.field_originMusicId);
        }
        if (this.fRF) {
            contentValues.put("musicType", Integer.valueOf(this.field_musicType));
        }
        if (this.fRG) {
            contentValues.put("downloadedLength", Long.valueOf(this.field_downloadedLength));
        }
        if (this.fRH) {
            contentValues.put("wifiDownloadedLength", Long.valueOf(this.field_wifiDownloadedLength));
        }
        if (this.fRI) {
            contentValues.put("endFlag", Integer.valueOf(this.field_endFlag));
        }
        if (this.fRJ) {
            contentValues.put("wifiEndFlag", Integer.valueOf(this.field_wifiEndFlag));
        }
        if (this.__hadSetupdateTime) {
            contentValues.put(ch.COL_UPDATETIME, Long.valueOf(this.field_updateTime));
        }
        if (this.fRK) {
            contentValues.put("songId", Integer.valueOf(this.field_songId));
        }
        if (this.fRL) {
            contentValues.put("songName", this.field_songName);
        }
        if (this.fRM) {
            contentValues.put("songSinger", this.field_songSinger);
        }
        if (this.fRN) {
            contentValues.put("songAlbum", this.field_songAlbum);
        }
        if (this.fRO) {
            contentValues.put("songAlbumType", Integer.valueOf(this.field_songAlbumType));
        }
        if (this.fRP) {
            contentValues.put("songAlbumUrl", this.field_songAlbumUrl);
        }
        if (this.fRQ) {
            contentValues.put("songHAlbumUrl", this.field_songHAlbumUrl);
        }
        if (this.fRR) {
            contentValues.put("songAlbumLocalPath", this.field_songAlbumLocalPath);
        }
        if (this.fRS) {
            contentValues.put("songWifiUrl", this.field_songWifiUrl);
        }
        if (this.fRT) {
            contentValues.put("songWapLinkUrl", this.field_songWapLinkUrl);
        }
        if (this.fRU) {
            contentValues.put("songWebUrl", this.field_songWebUrl);
        }
        if (this.fjS) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.fRV) {
            contentValues.put("songMediaId", this.field_songMediaId);
        }
        if (this.fRW) {
            contentValues.put("songSnsAlbumUser", this.field_songSnsAlbumUser);
        }
        if (this.fRX) {
            contentValues.put("songSnsShareUser", this.field_songSnsShareUser);
        }
        if (this.fRY) {
            contentValues.put("songLyric", this.field_songLyric);
        }
        if (this.fRZ) {
            contentValues.put("songBgColor", Integer.valueOf(this.field_songBgColor));
        }
        if (this.fSa) {
            contentValues.put("songLyricColor", Integer.valueOf(this.field_songLyricColor));
        }
        if (this.fSb) {
            contentValues.put("songFileLength", Long.valueOf(this.field_songFileLength));
        }
        if (this.fSc) {
            contentValues.put("songWifiFileLength", Long.valueOf(this.field_songWifiFileLength));
        }
        if (this.fSd) {
            contentValues.put("hideBanner", Boolean.valueOf(this.field_hideBanner));
        }
        if (this.fSe) {
            contentValues.put("jsWebUrlDomain", this.field_jsWebUrlDomain);
        }
        if (this.fSf) {
            contentValues.put("isBlock", Integer.valueOf(this.field_isBlock));
        }
        if (this.fjq) {
            contentValues.put("startTime", Integer.valueOf(this.field_startTime));
        }
        if (this.fSg) {
            contentValues.put("mimetype", this.field_mimetype);
        }
        if (this.fSh) {
            contentValues.put("protocol", this.field_protocol);
        }
        if (this.fSi) {
            contentValues.put("barBackToWebView", Boolean.valueOf(this.field_barBackToWebView));
        }
        if (this.fSj) {
            contentValues.put("musicbar_url", this.field_musicbar_url);
        }
        if (this.fSk) {
            contentValues.put("srcUsername", this.field_srcUsername);
        }
        if (this.fSl) {
            contentValues.put("playbackRate", Double.valueOf(this.field_playbackRate));
        }
        if (this.fSm) {
            contentValues.put("songMId", this.field_songMId);
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
