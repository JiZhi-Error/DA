package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class fb extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fUd = FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE.hashCode();
    private static final int fUh = "appid".hashCode();
    private static final int fUn = "wordingId".hashCode();
    private static final int fUo = "wording".hashCode();
    private static final int fUp = "pinyin".hashCode();
    private static final int fUq = "quanpin".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private static final int updateTime_HASHCODE = ch.COL_UPDATETIME.hashCode();
    private boolean __hadSetupdateTime = true;
    private boolean fUa = true;
    private boolean fUf = true;
    private boolean fUj = true;
    private boolean fUk = true;
    private boolean fUl = true;
    private boolean fUm = true;
    public String field_appid;
    public String field_language;
    public String field_pinyin;
    public String field_quanpin;
    public long field_updateTime;
    public String field_wording;
    public String field_wordingId;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fUh == hashCode) {
                    this.field_appid = cursor.getString(i2);
                } else if (fUn == hashCode) {
                    this.field_wordingId = cursor.getString(i2);
                } else if (fUd == hashCode) {
                    this.field_language = cursor.getString(i2);
                } else if (fUo == hashCode) {
                    this.field_wording = cursor.getString(i2);
                } else if (fUp == hashCode) {
                    this.field_pinyin = cursor.getString(i2);
                } else if (fUq == hashCode) {
                    this.field_quanpin = cursor.getString(i2);
                } else if (updateTime_HASHCODE == hashCode) {
                    this.field_updateTime = cursor.getLong(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.fUf) {
            contentValues.put("appid", this.field_appid);
        }
        if (this.fUj) {
            contentValues.put("wordingId", this.field_wordingId);
        }
        if (this.fUa) {
            contentValues.put(FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE, this.field_language);
        }
        if (this.fUk) {
            contentValues.put("wording", this.field_wording);
        }
        if (this.fUl) {
            contentValues.put("pinyin", this.field_pinyin);
        }
        if (this.fUm) {
            contentValues.put("quanpin", this.field_quanpin);
        }
        if (this.__hadSetupdateTime) {
            contentValues.put(ch.COL_UPDATETIME, Long.valueOf(this.field_updateTime));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
