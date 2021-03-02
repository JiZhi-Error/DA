package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class dd extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int createTime_HASHCODE = "createTime".hashCode();
    private static final int fIZ = "mergerId".hashCode();
    private static final int fJa = "gameMsgId".hashCode();
    private static final int fJb = "expireTime".hashCode();
    private static final int fJc = "showInMsgList".hashCode();
    private static final int fJd = "label".hashCode();
    private static final int fJe = "isHidden".hashCode();
    private static final int fJf = "weight".hashCode();
    private static final int fJg = "receiveTime".hashCode();
    private static final int fJh = "showType".hashCode();
    private static final int fJi = "interactiveMergeId".hashCode();
    private static final int fJj = "hasMergedCount".hashCode();
    private static final int fJk = "redDotExpireTime".hashCode();
    private static final int fjG = "needReport".hashCode();
    private static final int fjH = "rawXML".hashCode();
    private static final int fjf = "msgId".hashCode();
    private static final int fkj = "appId".hashCode();
    private static final int fof = "msgType".hashCode();
    private static final int fqF = "isRead".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private boolean __hadSetcreateTime = true;
    private boolean fIN = true;
    private boolean fIO = true;
    private boolean fIP = true;
    private boolean fIQ = true;
    private boolean fIR = true;
    private boolean fIS = true;
    private boolean fIT = true;
    private boolean fIU = true;
    private boolean fIV = true;
    private boolean fIW = true;
    private boolean fIX = true;
    private boolean fIY = true;
    public String field_appId;
    public long field_createTime;
    public long field_expireTime;
    public String field_gameMsgId;
    public int field_hasMergedCount;
    public String field_interactiveMergeId;
    public boolean field_isHidden;
    public boolean field_isRead;
    public String field_label;
    public String field_mergerId;
    public long field_msgId;
    public int field_msgType;
    public boolean field_needReport;
    public String field_rawXML;
    public long field_receiveTime;
    public long field_redDotExpireTime;
    public boolean field_showInMsgList;
    public int field_showType;
    public String field_weight;
    private boolean fjC = true;
    private boolean fjD = true;
    private boolean fjS = true;
    private boolean fjb = true;
    private boolean fnQ = true;
    private boolean fqr = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fjf == hashCode) {
                    this.field_msgId = cursor.getLong(i2);
                    this.fjb = true;
                } else if (fIZ == hashCode) {
                    this.field_mergerId = cursor.getString(i2);
                } else if (fJa == hashCode) {
                    this.field_gameMsgId = cursor.getString(i2);
                } else if (fof == hashCode) {
                    this.field_msgType = cursor.getInt(i2);
                } else if (createTime_HASHCODE == hashCode) {
                    this.field_createTime = cursor.getLong(i2);
                } else if (fJb == hashCode) {
                    this.field_expireTime = cursor.getLong(i2);
                } else if (fkj == hashCode) {
                    this.field_appId = cursor.getString(i2);
                } else if (fJc == hashCode) {
                    this.field_showInMsgList = cursor.getInt(i2) != 0;
                } else if (fqF == hashCode) {
                    this.field_isRead = cursor.getInt(i2) != 0;
                } else if (fJd == hashCode) {
                    this.field_label = cursor.getString(i2);
                } else if (fJe == hashCode) {
                    this.field_isHidden = cursor.getInt(i2) != 0;
                } else if (fJf == hashCode) {
                    this.field_weight = cursor.getString(i2);
                } else if (fjH == hashCode) {
                    this.field_rawXML = cursor.getString(i2);
                } else if (fJg == hashCode) {
                    this.field_receiveTime = cursor.getLong(i2);
                } else if (fJh == hashCode) {
                    this.field_showType = cursor.getInt(i2);
                } else if (fJi == hashCode) {
                    this.field_interactiveMergeId = cursor.getString(i2);
                } else if (fJj == hashCode) {
                    this.field_hasMergedCount = cursor.getInt(i2);
                } else if (fJk == hashCode) {
                    this.field_redDotExpireTime = cursor.getLong(i2);
                } else if (fjG == hashCode) {
                    this.field_needReport = cursor.getInt(i2) != 0;
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.fjb) {
            contentValues.put("msgId", Long.valueOf(this.field_msgId));
        }
        if (this.fIN) {
            contentValues.put("mergerId", this.field_mergerId);
        }
        if (this.fIO) {
            contentValues.put("gameMsgId", this.field_gameMsgId);
        }
        if (this.fnQ) {
            contentValues.put("msgType", Integer.valueOf(this.field_msgType));
        }
        if (this.__hadSetcreateTime) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.fIP) {
            contentValues.put("expireTime", Long.valueOf(this.field_expireTime));
        }
        if (this.fjS) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.fIQ) {
            contentValues.put("showInMsgList", Boolean.valueOf(this.field_showInMsgList));
        }
        if (this.fqr) {
            contentValues.put("isRead", Boolean.valueOf(this.field_isRead));
        }
        if (this.field_label == null) {
            this.field_label = "";
        }
        if (this.fIR) {
            contentValues.put("label", this.field_label);
        }
        if (this.fIS) {
            contentValues.put("isHidden", Boolean.valueOf(this.field_isHidden));
        }
        if (this.field_weight == null) {
            this.field_weight = "";
        }
        if (this.fIT) {
            contentValues.put("weight", this.field_weight);
        }
        if (this.field_rawXML == null) {
            this.field_rawXML = "";
        }
        if (this.fjD) {
            contentValues.put("rawXML", this.field_rawXML);
        }
        if (this.fIU) {
            contentValues.put("receiveTime", Long.valueOf(this.field_receiveTime));
        }
        if (this.fIV) {
            contentValues.put("showType", Integer.valueOf(this.field_showType));
        }
        if (this.field_interactiveMergeId == null) {
            this.field_interactiveMergeId = "";
        }
        if (this.fIW) {
            contentValues.put("interactiveMergeId", this.field_interactiveMergeId);
        }
        if (this.fIX) {
            contentValues.put("hasMergedCount", Integer.valueOf(this.field_hasMergedCount));
        }
        if (this.fIY) {
            contentValues.put("redDotExpireTime", Long.valueOf(this.field_redDotExpireTime));
        }
        if (this.fjC) {
            contentValues.put("needReport", Boolean.valueOf(this.field_needReport));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
