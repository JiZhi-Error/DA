package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.io.IOException;

public abstract class fr extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fAT = "toUser".hashCode();
    private static final int fWg = "oriMsgId".hashCode();
    private static final int fWh = "dataProto".hashCode();
    private static final int fWi = "favFrom".hashCode();
    private static final int fjf = "msgId".hashCode();
    private static final int fjl = "status".hashCode();
    private static final int fne = "title".hashCode();
    private static final int fyW = "desc".hashCode();
    private static final int localId_HASHCODE = ch.COL_LOCALID.hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private static final int type_HASHCODE = "type".hashCode();
    private boolean __hadSetlocalId = true;
    private boolean __hadSettype = true;
    private boolean fAF = true;
    private boolean fWd = true;
    private boolean fWe = true;
    private boolean fWf = true;
    public anb field_dataProto;
    public String field_desc;
    public String field_favFrom;
    public int field_localId;
    public long field_msgId;
    public long field_oriMsgId;
    public int field_status;
    public String field_title;
    public String field_toUser;
    public int field_type;
    private boolean fjb = true;
    private boolean fji = true;
    private boolean fnb = true;
    private boolean fyS = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (localId_HASHCODE == hashCode) {
                    this.field_localId = cursor.getInt(i2);
                    this.__hadSetlocalId = true;
                } else if (fjf == hashCode) {
                    this.field_msgId = cursor.getLong(i2);
                } else if (fWg == hashCode) {
                    this.field_oriMsgId = cursor.getLong(i2);
                } else if (fAT == hashCode) {
                    this.field_toUser = cursor.getString(i2);
                } else if (fne == hashCode) {
                    this.field_title = cursor.getString(i2);
                } else if (fyW == hashCode) {
                    this.field_desc = cursor.getString(i2);
                } else if (fWh == hashCode) {
                    try {
                        byte[] blob = cursor.getBlob(i2);
                        if (blob != null && blob.length > 0) {
                            this.field_dataProto = (anb) new anb().parseFrom(blob);
                        }
                    } catch (IOException e2) {
                        Log.e("MicroMsg.SDK.BaseRecordMessageInfo", e2.getMessage());
                    }
                } else if (type_HASHCODE == hashCode) {
                    this.field_type = cursor.getInt(i2);
                } else if (fjl == hashCode) {
                    this.field_status = cursor.getInt(i2);
                } else if (fWi == hashCode) {
                    this.field_favFrom = cursor.getString(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.__hadSetlocalId) {
            contentValues.put(ch.COL_LOCALID, Integer.valueOf(this.field_localId));
        }
        if (this.fjb) {
            contentValues.put("msgId", Long.valueOf(this.field_msgId));
        }
        if (this.fWd) {
            contentValues.put("oriMsgId", Long.valueOf(this.field_oriMsgId));
        }
        if (this.field_toUser == null) {
            this.field_toUser = "";
        }
        if (this.fAF) {
            contentValues.put("toUser", this.field_toUser);
        }
        if (this.fnb) {
            contentValues.put("title", this.field_title);
        }
        if (this.fyS) {
            contentValues.put("desc", this.field_desc);
        }
        if (this.fWe && this.field_dataProto != null) {
            try {
                contentValues.put("dataProto", this.field_dataProto.toByteArray());
            } catch (IOException e2) {
                Log.e("MicroMsg.SDK.BaseRecordMessageInfo", e2.getMessage());
            }
        }
        if (this.__hadSettype) {
            contentValues.put("type", Integer.valueOf(this.field_type));
        }
        if (this.fji) {
            contentValues.put("status", Integer.valueOf(this.field_status));
        }
        if (this.fWf) {
            contentValues.put("favFrom", this.field_favFrom);
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
