package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.mm.protocal.protobuf.ecf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.io.IOException;

public abstract class ds extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fMA = "likecount".hashCode();
    private static final int fMB = "selfLikeState".hashCode();
    private static final int fMC = "sportRecord".hashCode();
    private static final int fMo = "rankID".hashCode();
    private static final int fMp = "appusername".hashCode();
    private static final int fMs = FirebaseAnalytics.b.SCORE.hashCode();
    private static final int fMz = "ranknum".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private static final int username_HASHCODE = ch.COL_USERNAME.hashCode();
    private boolean __hadSetusername = true;
    private boolean fMl = true;
    private boolean fMm = true;
    private boolean fMr = true;
    private boolean fMv = true;
    private boolean fMw = true;
    private boolean fMx = true;
    private boolean fMy = true;
    public String field_appusername;
    public int field_likecount;
    public String field_rankID;
    public int field_ranknum;
    public int field_score;
    public int field_selfLikeState;
    public ecf field_sportRecord;
    public String field_username;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fMo == hashCode) {
                    this.field_rankID = cursor.getString(i2);
                } else if (fMp == hashCode) {
                    this.field_appusername = cursor.getString(i2);
                } else if (username_HASHCODE == hashCode) {
                    this.field_username = cursor.getString(i2);
                } else if (fMz == hashCode) {
                    this.field_ranknum = cursor.getInt(i2);
                } else if (fMs == hashCode) {
                    this.field_score = cursor.getInt(i2);
                } else if (fMA == hashCode) {
                    this.field_likecount = cursor.getInt(i2);
                } else if (fMB == hashCode) {
                    this.field_selfLikeState = cursor.getInt(i2);
                } else if (fMC == hashCode) {
                    try {
                        byte[] blob = cursor.getBlob(i2);
                        if (blob != null && blob.length > 0) {
                            this.field_sportRecord = (ecf) new ecf().parseFrom(blob);
                        }
                    } catch (IOException e2) {
                        Log.e("MicroMsg.SDK.BaseHardDeviceRankInfo", e2.getMessage());
                    }
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.fMl) {
            contentValues.put("rankID", this.field_rankID);
        }
        if (this.fMm) {
            contentValues.put("appusername", this.field_appusername);
        }
        if (this.__hadSetusername) {
            contentValues.put(ch.COL_USERNAME, this.field_username);
        }
        if (this.fMv) {
            contentValues.put("ranknum", Integer.valueOf(this.field_ranknum));
        }
        if (this.fMr) {
            contentValues.put(FirebaseAnalytics.b.SCORE, Integer.valueOf(this.field_score));
        }
        if (this.fMw) {
            contentValues.put("likecount", Integer.valueOf(this.field_likecount));
        }
        if (this.fMx) {
            contentValues.put("selfLikeState", Integer.valueOf(this.field_selfLikeState));
        }
        if (this.fMy && this.field_sportRecord != null) {
            try {
                contentValues.put("sportRecord", this.field_sportRecord.toByteArray());
            } catch (IOException e2) {
                Log.e("MicroMsg.SDK.BaseHardDeviceRankInfo", e2.getMessage());
            }
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
