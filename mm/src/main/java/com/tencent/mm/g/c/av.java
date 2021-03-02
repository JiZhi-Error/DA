package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.k.a.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.io.IOException;

public abstract class av extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int ftE = "lastPushSeq".hashCode();
    private static final int ftF = "lastLocalSeq".hashCode();
    private static final int ftG = "lastPushCreateTime".hashCode();
    private static final int ftH = "lastLocalCreateTime".hashCode();
    private static final int ftI = "seqBlockInfo".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private static final int username_HASHCODE = ch.COL_USERNAME.hashCode();
    private boolean __hadSetusername = true;
    public long field_lastLocalCreateTime;
    public long field_lastLocalSeq;
    public long field_lastPushCreateTime;
    public long field_lastPushSeq;
    public d field_seqBlockInfo;
    public String field_username;
    private boolean ftA = true;
    private boolean ftB = true;
    private boolean ftC = true;
    private boolean ftD = true;
    private boolean ftz = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (username_HASHCODE == hashCode) {
                    this.field_username = cursor.getString(i2);
                    this.__hadSetusername = true;
                } else if (ftE == hashCode) {
                    this.field_lastPushSeq = cursor.getLong(i2);
                } else if (ftF == hashCode) {
                    this.field_lastLocalSeq = cursor.getLong(i2);
                } else if (ftG == hashCode) {
                    this.field_lastPushCreateTime = cursor.getLong(i2);
                } else if (ftH == hashCode) {
                    this.field_lastLocalCreateTime = cursor.getLong(i2);
                } else if (ftI == hashCode) {
                    try {
                        byte[] blob = cursor.getBlob(i2);
                        if (blob != null && blob.length > 0) {
                            this.field_seqBlockInfo = (d) new d().parseFrom(blob);
                        }
                    } catch (IOException e2) {
                        Log.e("MicroMsg.SDK.BaseChatroomMsgSeq", e2.getMessage());
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
        if (this.field_username == null) {
            this.field_username = "";
        }
        if (this.__hadSetusername) {
            contentValues.put(ch.COL_USERNAME, this.field_username);
        }
        if (this.ftz) {
            contentValues.put("lastPushSeq", Long.valueOf(this.field_lastPushSeq));
        }
        if (this.ftA) {
            contentValues.put("lastLocalSeq", Long.valueOf(this.field_lastLocalSeq));
        }
        if (this.ftB) {
            contentValues.put("lastPushCreateTime", Long.valueOf(this.field_lastPushCreateTime));
        }
        if (this.ftC) {
            contentValues.put("lastLocalCreateTime", Long.valueOf(this.field_lastLocalCreateTime));
        }
        if (this.ftD && this.field_seqBlockInfo != null) {
            try {
                contentValues.put("seqBlockInfo", this.field_seqBlockInfo.toByteArray());
            } catch (IOException e2) {
                Log.e("MicroMsg.SDK.BaseChatroomMsgSeq", e2.getMessage());
            }
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
