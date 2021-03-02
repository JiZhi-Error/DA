package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class fu extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fMs = FirebaseAnalytics.b.SCORE.hashCode();
    private static final int fXn = "daySec".hashCode();
    private static final int fXo = "isMute".hashCode();
    private static final int fXp = "sendCount".hashCode();
    private static final int fXq = "enterCount".hashCode();
    private static final int fXr = "disRedDotCount".hashCode();
    private static final int fXs = "stayTime".hashCode();
    private static final int fje = "chatroom".hashCode();
    private static final int fnV = "unReadCount".hashCode();
    private static final int fqf = "nickname".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private boolean fMr = true;
    private boolean fXh = true;
    private boolean fXi = true;
    private boolean fXj = true;
    private boolean fXk = true;
    private boolean fXl = true;
    private boolean fXm = true;
    public String field_chatroom;
    public String field_daySec;
    public int field_disRedDotCount;
    public int field_enterCount;
    public int field_isMute;
    public String field_nickname;
    public float field_score;
    public int field_sendCount;
    public long field_stayTime;
    public int field_unReadCount;
    private boolean fja = true;
    private boolean fnG = true;
    private boolean fqb = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fje == hashCode) {
                    this.field_chatroom = cursor.getString(i2);
                } else if (fXn == hashCode) {
                    this.field_daySec = cursor.getString(i2);
                } else if (fqf == hashCode) {
                    this.field_nickname = cursor.getString(i2);
                } else if (fXo == hashCode) {
                    this.field_isMute = cursor.getInt(i2);
                } else if (fnV == hashCode) {
                    this.field_unReadCount = cursor.getInt(i2);
                } else if (fXp == hashCode) {
                    this.field_sendCount = cursor.getInt(i2);
                } else if (fXq == hashCode) {
                    this.field_enterCount = cursor.getInt(i2);
                } else if (fXr == hashCode) {
                    this.field_disRedDotCount = cursor.getInt(i2);
                } else if (fXs == hashCode) {
                    this.field_stayTime = cursor.getLong(i2);
                } else if (fMs == hashCode) {
                    this.field_score = cursor.getFloat(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.fja) {
            contentValues.put("chatroom", this.field_chatroom);
        }
        if (this.fXh) {
            contentValues.put("daySec", this.field_daySec);
        }
        if (this.fqb) {
            contentValues.put("nickname", this.field_nickname);
        }
        if (this.fXi) {
            contentValues.put("isMute", Integer.valueOf(this.field_isMute));
        }
        if (this.fnG) {
            contentValues.put("unReadCount", Integer.valueOf(this.field_unReadCount));
        }
        if (this.fXj) {
            contentValues.put("sendCount", Integer.valueOf(this.field_sendCount));
        }
        if (this.fXk) {
            contentValues.put("enterCount", Integer.valueOf(this.field_enterCount));
        }
        if (this.fXl) {
            contentValues.put("disRedDotCount", Integer.valueOf(this.field_disRedDotCount));
        }
        if (this.fXm) {
            contentValues.put("stayTime", Long.valueOf(this.field_stayTime));
        }
        if (this.fMr) {
            contentValues.put(FirebaseAnalytics.b.SCORE, Float.valueOf(this.field_score));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
