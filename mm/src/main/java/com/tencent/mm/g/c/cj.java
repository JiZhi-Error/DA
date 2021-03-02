package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public abstract class cj extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fEA = "giftType".hashCode();
    private static final int fEB = FirebaseAnalytics.b.PRICE.hashCode();
    private static final int fEC = "giftIndex".hashCode();
    private static final int fEs = "rewardProductId".hashCode();
    private static final int fEt = "businessType".hashCode();
    private static final int fEu = "thumbnailFileUrl".hashCode();
    private static final int fEv = "previewPagUrl".hashCode();
    private static final int fEw = "animationPagUrl".hashCode();
    private static final int fEx = "thumbnailMd5".hashCode();
    private static final int fEy = "previewPagMd5".hashCode();
    private static final int fEz = "animationPagMd5".hashCode();
    private static final int fyj = "state".hashCode();
    private static final int fyk = "name".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private boolean fEh = true;
    private boolean fEi = true;
    private boolean fEj = true;
    private boolean fEk = true;
    private boolean fEl = true;
    private boolean fEm = true;
    private boolean fEn = true;
    private boolean fEo = true;
    private boolean fEp = true;
    private boolean fEq = true;
    private boolean fEr = true;
    public String field_animationPagMd5;
    public String field_animationPagUrl;
    public int field_businessType;
    public int field_giftIndex;
    public int field_giftType;
    public String field_name;
    public String field_previewPagMd5;
    public String field_previewPagUrl;
    public float field_price;
    public String field_rewardProductId;
    public int field_state;
    public String field_thumbnailFileUrl;
    public String field_thumbnailMd5;
    private boolean fxx = true;
    private boolean fxy = true;

    public static IAutoDBItem.MAutoDBInfo ajs() {
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[13];
        mAutoDBInfo.columns = new String[14];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "rewardProductId";
        mAutoDBInfo.colsMap.put("rewardProductId", "TEXT PRIMARY KEY ");
        sb.append(" rewardProductId TEXT PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "rewardProductId";
        mAutoDBInfo.columns[1] = "businessType";
        mAutoDBInfo.colsMap.put("businessType", "INTEGER default '' ");
        sb.append(" businessType INTEGER default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "thumbnailFileUrl";
        mAutoDBInfo.colsMap.put("thumbnailFileUrl", "TEXT default '' ");
        sb.append(" thumbnailFileUrl TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "previewPagUrl";
        mAutoDBInfo.colsMap.put("previewPagUrl", "TEXT default '' ");
        sb.append(" previewPagUrl TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "animationPagUrl";
        mAutoDBInfo.colsMap.put("animationPagUrl", "TEXT default '' ");
        sb.append(" animationPagUrl TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "thumbnailMd5";
        mAutoDBInfo.colsMap.put("thumbnailMd5", "TEXT default '' ");
        sb.append(" thumbnailMd5 TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[6] = "previewPagMd5";
        mAutoDBInfo.colsMap.put("previewPagMd5", "TEXT default '' ");
        sb.append(" previewPagMd5 TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[7] = "animationPagMd5";
        mAutoDBInfo.colsMap.put("animationPagMd5", "TEXT default '' ");
        sb.append(" animationPagMd5 TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[8] = "giftType";
        mAutoDBInfo.colsMap.put("giftType", "INTEGER default '' ");
        sb.append(" giftType INTEGER default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[9] = "name";
        mAutoDBInfo.colsMap.put("name", "TEXT default '' ");
        sb.append(" name TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[10] = FirebaseAnalytics.b.PRICE;
        mAutoDBInfo.colsMap.put(FirebaseAnalytics.b.PRICE, "FLOAT");
        sb.append(" price FLOAT");
        sb.append(", ");
        mAutoDBInfo.columns[11] = "state";
        mAutoDBInfo.colsMap.put("state", "INTEGER");
        sb.append(" state INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[12] = "giftIndex";
        mAutoDBInfo.colsMap.put("giftIndex", "INTEGER");
        sb.append(" giftIndex INTEGER");
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
                if (fEs == hashCode) {
                    this.field_rewardProductId = cursor.getString(i2);
                    this.fEh = true;
                } else if (fEt == hashCode) {
                    this.field_businessType = cursor.getInt(i2);
                } else if (fEu == hashCode) {
                    this.field_thumbnailFileUrl = cursor.getString(i2);
                } else if (fEv == hashCode) {
                    this.field_previewPagUrl = cursor.getString(i2);
                } else if (fEw == hashCode) {
                    this.field_animationPagUrl = cursor.getString(i2);
                } else if (fEx == hashCode) {
                    this.field_thumbnailMd5 = cursor.getString(i2);
                } else if (fEy == hashCode) {
                    this.field_previewPagMd5 = cursor.getString(i2);
                } else if (fEz == hashCode) {
                    this.field_animationPagMd5 = cursor.getString(i2);
                } else if (fEA == hashCode) {
                    this.field_giftType = cursor.getInt(i2);
                } else if (fyk == hashCode) {
                    this.field_name = cursor.getString(i2);
                } else if (fEB == hashCode) {
                    this.field_price = cursor.getFloat(i2);
                } else if (fyj == hashCode) {
                    this.field_state = cursor.getInt(i2);
                } else if (fEC == hashCode) {
                    this.field_giftIndex = cursor.getInt(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.fEh) {
            contentValues.put("rewardProductId", this.field_rewardProductId);
        }
        if (this.fEi) {
            contentValues.put("businessType", Integer.valueOf(this.field_businessType));
        }
        if (this.field_thumbnailFileUrl == null) {
            this.field_thumbnailFileUrl = "";
        }
        if (this.fEj) {
            contentValues.put("thumbnailFileUrl", this.field_thumbnailFileUrl);
        }
        if (this.field_previewPagUrl == null) {
            this.field_previewPagUrl = "";
        }
        if (this.fEk) {
            contentValues.put("previewPagUrl", this.field_previewPagUrl);
        }
        if (this.field_animationPagUrl == null) {
            this.field_animationPagUrl = "";
        }
        if (this.fEl) {
            contentValues.put("animationPagUrl", this.field_animationPagUrl);
        }
        if (this.field_thumbnailMd5 == null) {
            this.field_thumbnailMd5 = "";
        }
        if (this.fEm) {
            contentValues.put("thumbnailMd5", this.field_thumbnailMd5);
        }
        if (this.field_previewPagMd5 == null) {
            this.field_previewPagMd5 = "";
        }
        if (this.fEn) {
            contentValues.put("previewPagMd5", this.field_previewPagMd5);
        }
        if (this.field_animationPagMd5 == null) {
            this.field_animationPagMd5 = "";
        }
        if (this.fEo) {
            contentValues.put("animationPagMd5", this.field_animationPagMd5);
        }
        if (this.fEp) {
            contentValues.put("giftType", Integer.valueOf(this.field_giftType));
        }
        if (this.field_name == null) {
            this.field_name = "";
        }
        if (this.fxy) {
            contentValues.put("name", this.field_name);
        }
        if (this.fEq) {
            contentValues.put(FirebaseAnalytics.b.PRICE, Float.valueOf(this.field_price));
        }
        if (this.fxx) {
            contentValues.put("state", Integer.valueOf(this.field_state));
        }
        if (this.fEr) {
            contentValues.put("giftIndex", Integer.valueOf(this.field_giftIndex));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
