package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public abstract class ha extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fFb = "videoBitrate".hashCode();
    private static final int fFc = "audioBitrate".hashCode();
    private static final int fFd = "frameRate".hashCode();
    private static final int fGk = "expiredTime".hashCode();
    private static final int fIp = "taskId".hashCode();
    private static final int fPE = "timeStamp".hashCode();
    private static final int fjl = "status".hashCode();
    private static final int gaX = "baseItemData".hashCode();
    private static final int gaZ = "mixFlag".hashCode();
    private static final int gba = "mixRetryTime".hashCode();
    private static final int gcA = "extraConfig".hashCode();
    private static final int gcB = "reportInfo".hashCode();
    private static final int gcC = "userData".hashCode();
    private static final int gcD = FirebaseAnalytics.b.LOCATION.hashCode();
    private static final int gcE = "blurBgPath".hashCode();
    private static final int gcF = "fromScene".hashCode();
    private static final int gcv = "targetWidth".hashCode();
    private static final int gcw = "targetHeight".hashCode();
    private static final int gcx = "audioSampleRate".hashCode();
    private static final int gcy = "audioChannelCount".hashCode();
    private static final int gcz = "videoRotate".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private boolean fEP = true;
    private boolean fEQ = true;
    private boolean fER = true;
    private boolean fGe = true;
    private boolean fIf = true;
    private boolean fPy = true;
    public int field_audioBitrate;
    public int field_audioChannelCount;
    public int field_audioSampleRate;
    public byte[] field_baseItemData;
    public String field_blurBgPath;
    public long field_expiredTime;
    public byte[] field_extraConfig;
    public int field_frameRate;
    public int field_fromScene;
    public byte[] field_location;
    public int field_mixFlag;
    public int field_mixRetryTime;
    public String field_reportInfo;
    public int field_status;
    public int field_targetHeight;
    public int field_targetWidth;
    public String field_taskId;
    public long field_timeStamp;
    public String field_userData;
    public int field_videoBitrate;
    public int field_videoRotate;
    private boolean fji = true;
    private boolean gaS = true;
    private boolean gaU = true;
    private boolean gaV = true;
    private boolean gck = true;
    private boolean gcl = true;
    private boolean gcm = true;
    private boolean gcn = true;
    private boolean gco = true;
    private boolean gcp = true;
    private boolean gcq = true;
    private boolean gcr = true;
    private boolean gcs = true;
    private boolean gct = true;
    private boolean gcu = true;

    public static IAutoDBItem.MAutoDBInfo ajs() {
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[21];
        mAutoDBInfo.columns = new String[22];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "taskId";
        mAutoDBInfo.colsMap.put("taskId", "TEXT PRIMARY KEY ");
        sb.append(" taskId TEXT PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "taskId";
        mAutoDBInfo.columns[1] = "baseItemData";
        mAutoDBInfo.colsMap.put("baseItemData", "BLOB");
        sb.append(" baseItemData BLOB");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "timeStamp";
        mAutoDBInfo.colsMap.put("timeStamp", "LONG");
        sb.append(" timeStamp LONG");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "mixRetryTime";
        mAutoDBInfo.colsMap.put("mixRetryTime", "INTEGER");
        sb.append(" mixRetryTime INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "expiredTime";
        mAutoDBInfo.colsMap.put("expiredTime", "LONG");
        sb.append(" expiredTime LONG");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "status";
        mAutoDBInfo.colsMap.put("status", "INTEGER");
        sb.append(" status INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[6] = "targetWidth";
        mAutoDBInfo.colsMap.put("targetWidth", "INTEGER");
        sb.append(" targetWidth INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[7] = "targetHeight";
        mAutoDBInfo.colsMap.put("targetHeight", "INTEGER");
        sb.append(" targetHeight INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[8] = "videoBitrate";
        mAutoDBInfo.colsMap.put("videoBitrate", "INTEGER");
        sb.append(" videoBitrate INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[9] = "audioBitrate";
        mAutoDBInfo.colsMap.put("audioBitrate", "INTEGER");
        sb.append(" audioBitrate INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[10] = "audioSampleRate";
        mAutoDBInfo.colsMap.put("audioSampleRate", "INTEGER");
        sb.append(" audioSampleRate INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[11] = "audioChannelCount";
        mAutoDBInfo.colsMap.put("audioChannelCount", "INTEGER");
        sb.append(" audioChannelCount INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[12] = "frameRate";
        mAutoDBInfo.colsMap.put("frameRate", "INTEGER");
        sb.append(" frameRate INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[13] = "videoRotate";
        mAutoDBInfo.colsMap.put("videoRotate", "INTEGER");
        sb.append(" videoRotate INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[14] = "extraConfig";
        mAutoDBInfo.colsMap.put("extraConfig", "BLOB");
        sb.append(" extraConfig BLOB");
        sb.append(", ");
        mAutoDBInfo.columns[15] = "reportInfo";
        mAutoDBInfo.colsMap.put("reportInfo", "TEXT");
        sb.append(" reportInfo TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[16] = "userData";
        mAutoDBInfo.colsMap.put("userData", "TEXT");
        sb.append(" userData TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[17] = FirebaseAnalytics.b.LOCATION;
        mAutoDBInfo.colsMap.put(FirebaseAnalytics.b.LOCATION, "BLOB");
        sb.append(" location BLOB");
        sb.append(", ");
        mAutoDBInfo.columns[18] = "mixFlag";
        mAutoDBInfo.colsMap.put("mixFlag", "INTEGER");
        sb.append(" mixFlag INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[19] = "blurBgPath";
        mAutoDBInfo.colsMap.put("blurBgPath", "TEXT");
        sb.append(" blurBgPath TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[20] = "fromScene";
        mAutoDBInfo.colsMap.put("fromScene", "INTEGER");
        sb.append(" fromScene INTEGER");
        mAutoDBInfo.columns[21] = "rowid";
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
                if (fIp == hashCode) {
                    this.field_taskId = cursor.getString(i2);
                    this.fIf = true;
                } else if (gaX == hashCode) {
                    this.field_baseItemData = cursor.getBlob(i2);
                } else if (fPE == hashCode) {
                    this.field_timeStamp = cursor.getLong(i2);
                } else if (gba == hashCode) {
                    this.field_mixRetryTime = cursor.getInt(i2);
                } else if (fGk == hashCode) {
                    this.field_expiredTime = cursor.getLong(i2);
                } else if (fjl == hashCode) {
                    this.field_status = cursor.getInt(i2);
                } else if (gcv == hashCode) {
                    this.field_targetWidth = cursor.getInt(i2);
                } else if (gcw == hashCode) {
                    this.field_targetHeight = cursor.getInt(i2);
                } else if (fFb == hashCode) {
                    this.field_videoBitrate = cursor.getInt(i2);
                } else if (fFc == hashCode) {
                    this.field_audioBitrate = cursor.getInt(i2);
                } else if (gcx == hashCode) {
                    this.field_audioSampleRate = cursor.getInt(i2);
                } else if (gcy == hashCode) {
                    this.field_audioChannelCount = cursor.getInt(i2);
                } else if (fFd == hashCode) {
                    this.field_frameRate = cursor.getInt(i2);
                } else if (gcz == hashCode) {
                    this.field_videoRotate = cursor.getInt(i2);
                } else if (gcA == hashCode) {
                    this.field_extraConfig = cursor.getBlob(i2);
                } else if (gcB == hashCode) {
                    this.field_reportInfo = cursor.getString(i2);
                } else if (gcC == hashCode) {
                    this.field_userData = cursor.getString(i2);
                } else if (gcD == hashCode) {
                    this.field_location = cursor.getBlob(i2);
                } else if (gaZ == hashCode) {
                    this.field_mixFlag = cursor.getInt(i2);
                } else if (gcE == hashCode) {
                    this.field_blurBgPath = cursor.getString(i2);
                } else if (gcF == hashCode) {
                    this.field_fromScene = cursor.getInt(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.fIf) {
            contentValues.put("taskId", this.field_taskId);
        }
        if (this.gaS) {
            contentValues.put("baseItemData", this.field_baseItemData);
        }
        if (this.fPy) {
            contentValues.put("timeStamp", Long.valueOf(this.field_timeStamp));
        }
        if (this.gaV) {
            contentValues.put("mixRetryTime", Integer.valueOf(this.field_mixRetryTime));
        }
        if (this.fGe) {
            contentValues.put("expiredTime", Long.valueOf(this.field_expiredTime));
        }
        if (this.fji) {
            contentValues.put("status", Integer.valueOf(this.field_status));
        }
        if (this.gck) {
            contentValues.put("targetWidth", Integer.valueOf(this.field_targetWidth));
        }
        if (this.gcl) {
            contentValues.put("targetHeight", Integer.valueOf(this.field_targetHeight));
        }
        if (this.fEP) {
            contentValues.put("videoBitrate", Integer.valueOf(this.field_videoBitrate));
        }
        if (this.fEQ) {
            contentValues.put("audioBitrate", Integer.valueOf(this.field_audioBitrate));
        }
        if (this.gcm) {
            contentValues.put("audioSampleRate", Integer.valueOf(this.field_audioSampleRate));
        }
        if (this.gcn) {
            contentValues.put("audioChannelCount", Integer.valueOf(this.field_audioChannelCount));
        }
        if (this.fER) {
            contentValues.put("frameRate", Integer.valueOf(this.field_frameRate));
        }
        if (this.gco) {
            contentValues.put("videoRotate", Integer.valueOf(this.field_videoRotate));
        }
        if (this.gcp) {
            contentValues.put("extraConfig", this.field_extraConfig);
        }
        if (this.gcq) {
            contentValues.put("reportInfo", this.field_reportInfo);
        }
        if (this.gcr) {
            contentValues.put("userData", this.field_userData);
        }
        if (this.gcs) {
            contentValues.put(FirebaseAnalytics.b.LOCATION, this.field_location);
        }
        if (this.gaU) {
            contentValues.put("mixFlag", Integer.valueOf(this.field_mixFlag));
        }
        if (this.gct) {
            contentValues.put("blurBgPath", this.field_blurBgPath);
        }
        if (this.gcu) {
            contentValues.put("fromScene", Integer.valueOf(this.field_fromScene));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
