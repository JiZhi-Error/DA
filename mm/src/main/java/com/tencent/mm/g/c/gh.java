package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.tmassistantsdk.storage.table.ClientInfoTable;

public abstract class gh extends IAutoDBItem {
    public static final String[] INDEX_CREATE = {"CREATE INDEX IF NOT EXISTS SnsComment_snsID_index ON SnsComment(snsID)", "CREATE INDEX IF NOT EXISTS SnsComment_parentID_index ON SnsComment(parentID)", "CREATE INDEX IF NOT EXISTS SnsComment_isRead_index ON SnsComment(isRead)", "CREATE INDEX IF NOT EXISTS SnsComment_isSend_index ON SnsComment(isSend)"};
    private static final int createTime_HASHCODE = "createTime".hashCode();
    private static final int fZA = ClientInfoTable.Columns.CLIENTID.hashCode();
    private static final int fZB = "commentflag".hashCode();
    private static final int fZC = "isSilence".hashCode();
    private static final int fZv = "snsID".hashCode();
    private static final int fZw = "parentID".hashCode();
    private static final int fZx = "curActionBuf".hashCode();
    private static final int fZy = "refActionBuf".hashCode();
    private static final int fZz = "commentSvrID".hashCode();
    private static final int foe = "isSend".hashCode();
    private static final int fqF = "isRead".hashCode();
    private static final int fqw = "talker".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private static final int type_HASHCODE = "type".hashCode();
    private boolean __hadSetcreateTime = true;
    private boolean __hadSettype = true;
    private boolean fZn = true;
    private boolean fZo = true;
    private boolean fZp = true;
    private boolean fZq = true;
    private boolean fZr = true;
    private boolean fZs = true;
    private boolean fZt = true;
    private boolean fZu = true;
    public String field_clientId;
    public long field_commentSvrID;
    public int field_commentflag;
    public int field_createTime;
    public byte[] field_curActionBuf;
    public short field_isRead;
    public boolean field_isSend;
    public int field_isSilence;
    public long field_parentID;
    public byte[] field_refActionBuf;
    public long field_snsID;
    public String field_talker;
    public int field_type;
    private boolean fnP = true;
    private boolean fqi = true;
    private boolean fqr = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fZv == hashCode) {
                    this.field_snsID = cursor.getLong(i2);
                } else if (fZw == hashCode) {
                    this.field_parentID = cursor.getLong(i2);
                } else if (fqF == hashCode) {
                    this.field_isRead = cursor.getShort(i2);
                } else if (createTime_HASHCODE == hashCode) {
                    this.field_createTime = cursor.getInt(i2);
                } else if (fqw == hashCode) {
                    this.field_talker = cursor.getString(i2);
                } else if (type_HASHCODE == hashCode) {
                    this.field_type = cursor.getInt(i2);
                } else if (foe == hashCode) {
                    this.field_isSend = cursor.getInt(i2) != 0;
                } else if (fZx == hashCode) {
                    this.field_curActionBuf = cursor.getBlob(i2);
                } else if (fZy == hashCode) {
                    this.field_refActionBuf = cursor.getBlob(i2);
                } else if (fZz == hashCode) {
                    this.field_commentSvrID = cursor.getLong(i2);
                } else if (fZA == hashCode) {
                    this.field_clientId = cursor.getString(i2);
                } else if (fZB == hashCode) {
                    this.field_commentflag = cursor.getInt(i2);
                } else if (fZC == hashCode) {
                    this.field_isSilence = cursor.getInt(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.fZn) {
            contentValues.put("snsID", Long.valueOf(this.field_snsID));
        }
        if (this.fZo) {
            contentValues.put("parentID", Long.valueOf(this.field_parentID));
        }
        if (this.fqr) {
            contentValues.put("isRead", Short.valueOf(this.field_isRead));
        }
        if (this.__hadSetcreateTime) {
            contentValues.put("createTime", Integer.valueOf(this.field_createTime));
        }
        if (this.fqi) {
            contentValues.put("talker", this.field_talker);
        }
        if (this.__hadSettype) {
            contentValues.put("type", Integer.valueOf(this.field_type));
        }
        if (this.fnP) {
            contentValues.put("isSend", Boolean.valueOf(this.field_isSend));
        }
        if (this.fZp) {
            contentValues.put("curActionBuf", this.field_curActionBuf);
        }
        if (this.fZq) {
            contentValues.put("refActionBuf", this.field_refActionBuf);
        }
        if (this.fZr) {
            contentValues.put("commentSvrID", Long.valueOf(this.field_commentSvrID));
        }
        if (this.fZs) {
            contentValues.put(ClientInfoTable.Columns.CLIENTID, this.field_clientId);
        }
        if (this.fZt) {
            contentValues.put("commentflag", Integer.valueOf(this.field_commentflag));
        }
        if (this.fZu) {
            contentValues.put("isSilence", Integer.valueOf(this.field_isSilence));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
