package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class gc extends IAutoDBItem {
    public static final String[] INDEX_CREATE = {"CREATE INDEX IF NOT EXISTS ShareCardInfo_card_tp_id_index ON ShareCardInfo(card_tp_id)"};
    private static final int fAO = "updateSeq".hashCode();
    private static final int fYA = "from_username".hashCode();
    private static final int fYB = "consumer".hashCode();
    private static final int fYC = "share_time".hashCode();
    private static final int fYD = "local_updateTime".hashCode();
    private static final int fYE = "begin_time".hashCode();
    private static final int fYF = "end_time".hashCode();
    private static final int fYG = "block_mask".hashCode();
    private static final int fYH = "dataInfoData".hashCode();
    private static final int fYI = "cardTpInfoData".hashCode();
    private static final int fYJ = "shareInfoData".hashCode();
    private static final int fYK = "shopInfoData".hashCode();
    private static final int fYL = "categoryType".hashCode();
    private static final int fYM = "itemIndex".hashCode();
    private static final int fjl = "status".hashCode();
    private static final int frD = "card_id".hashCode();
    private static final int frE = "card_tp_id".hashCode();
    private static final int fyp = "app_id".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private static final int updateTime_HASHCODE = ch.COL_UPDATETIME.hashCode();
    private boolean __hadSetupdateTime = true;
    private boolean fAA = true;
    private boolean fYn = true;
    private boolean fYo = true;
    private boolean fYp = true;
    private boolean fYq = true;
    private boolean fYr = true;
    private boolean fYs = true;
    private boolean fYt = true;
    private boolean fYu = true;
    private boolean fYv = true;
    private boolean fYw = true;
    private boolean fYx = true;
    private boolean fYy = true;
    private boolean fYz = true;
    public String field_app_id;
    public long field_begin_time;
    public long field_block_mask;
    public byte[] field_cardTpInfoData;
    public String field_card_id;
    public String field_card_tp_id;
    public int field_categoryType;
    public String field_consumer;
    public byte[] field_dataInfoData;
    public long field_end_time;
    public String field_from_username;
    public int field_itemIndex;
    public long field_local_updateTime;
    public byte[] field_shareInfoData;
    public long field_share_time;
    public byte[] field_shopInfoData;
    public int field_status;
    public long field_updateSeq;
    public long field_updateTime;
    private boolean fji = true;
    private boolean frk = true;
    private boolean frl = true;
    private boolean fxD = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (frD == hashCode) {
                    this.field_card_id = cursor.getString(i2);
                    this.frk = true;
                } else if (frE == hashCode) {
                    this.field_card_tp_id = cursor.getString(i2);
                } else if (fYA == hashCode) {
                    this.field_from_username = cursor.getString(i2);
                } else if (fYB == hashCode) {
                    this.field_consumer = cursor.getString(i2);
                } else if (fyp == hashCode) {
                    this.field_app_id = cursor.getString(i2);
                } else if (fjl == hashCode) {
                    this.field_status = cursor.getInt(i2);
                } else if (fYC == hashCode) {
                    this.field_share_time = cursor.getLong(i2);
                } else if (fYD == hashCode) {
                    this.field_local_updateTime = cursor.getLong(i2);
                } else if (updateTime_HASHCODE == hashCode) {
                    this.field_updateTime = cursor.getLong(i2);
                } else if (fYE == hashCode) {
                    this.field_begin_time = cursor.getLong(i2);
                } else if (fYF == hashCode) {
                    this.field_end_time = cursor.getLong(i2);
                } else if (fAO == hashCode) {
                    this.field_updateSeq = cursor.getLong(i2);
                } else if (fYG == hashCode) {
                    this.field_block_mask = cursor.getLong(i2);
                } else if (fYH == hashCode) {
                    this.field_dataInfoData = cursor.getBlob(i2);
                } else if (fYI == hashCode) {
                    this.field_cardTpInfoData = cursor.getBlob(i2);
                } else if (fYJ == hashCode) {
                    this.field_shareInfoData = cursor.getBlob(i2);
                } else if (fYK == hashCode) {
                    this.field_shopInfoData = cursor.getBlob(i2);
                } else if (fYL == hashCode) {
                    this.field_categoryType = cursor.getInt(i2);
                } else if (fYM == hashCode) {
                    this.field_itemIndex = cursor.getInt(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.frk) {
            contentValues.put("card_id", this.field_card_id);
        }
        if (this.frl) {
            contentValues.put("card_tp_id", this.field_card_tp_id);
        }
        if (this.fYn) {
            contentValues.put("from_username", this.field_from_username);
        }
        if (this.fYo) {
            contentValues.put("consumer", this.field_consumer);
        }
        if (this.fxD) {
            contentValues.put("app_id", this.field_app_id);
        }
        if (this.fji) {
            contentValues.put("status", Integer.valueOf(this.field_status));
        }
        if (this.fYp) {
            contentValues.put("share_time", Long.valueOf(this.field_share_time));
        }
        if (this.fYq) {
            contentValues.put("local_updateTime", Long.valueOf(this.field_local_updateTime));
        }
        if (this.__hadSetupdateTime) {
            contentValues.put(ch.COL_UPDATETIME, Long.valueOf(this.field_updateTime));
        }
        if (this.fYr) {
            contentValues.put("begin_time", Long.valueOf(this.field_begin_time));
        }
        if (this.fYs) {
            contentValues.put("end_time", Long.valueOf(this.field_end_time));
        }
        if (this.fAA) {
            contentValues.put("updateSeq", Long.valueOf(this.field_updateSeq));
        }
        if (this.fYt) {
            contentValues.put("block_mask", Long.valueOf(this.field_block_mask));
        }
        if (this.fYu) {
            contentValues.put("dataInfoData", this.field_dataInfoData);
        }
        if (this.fYv) {
            contentValues.put("cardTpInfoData", this.field_cardTpInfoData);
        }
        if (this.fYw) {
            contentValues.put("shareInfoData", this.field_shareInfoData);
        }
        if (this.fYx) {
            contentValues.put("shopInfoData", this.field_shopInfoData);
        }
        if (this.fYy) {
            contentValues.put("categoryType", Integer.valueOf(this.field_categoryType));
        }
        if (this.fYz) {
            contentValues.put("itemIndex", Integer.valueOf(this.field_itemIndex));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
