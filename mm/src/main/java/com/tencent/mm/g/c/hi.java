package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class hi extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fJg = "receiveTime".hashCode();
    private static final int fWn = "receiveStatus".hashCode();
    private static final int fWo = "invalidtime".hashCode();
    private static final int fqv = "msgSvrId".hashCode();
    private static final int gfA = "hbStatus".hashCode();
    private static final int gfB = "sender".hashCode();
    private static final int gfC = "exclusiveUsername".hashCode();
    private static final int gfD = "sendId".hashCode();
    private static final int gfx = "mNativeUrl".hashCode();
    private static final int gfy = "hbType".hashCode();
    private static final int gfz = "receiveAmount".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private boolean fIU = true;
    private boolean fWk = true;
    private boolean fWl = true;
    public String field_exclusiveUsername;
    public int field_hbStatus;
    public int field_hbType;
    public int field_invalidtime;
    public String field_mNativeUrl;
    public long field_msgSvrId;
    public long field_receiveAmount;
    public int field_receiveStatus;
    public long field_receiveTime;
    public String field_sendId;
    public String field_sender;
    private boolean fqh = true;
    private boolean gfq = true;
    private boolean gfr = true;
    private boolean gfs = true;
    private boolean gft = true;
    private boolean gfu = true;
    private boolean gfv = true;
    private boolean gfw = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (gfx == hashCode) {
                    this.field_mNativeUrl = cursor.getString(i2);
                    this.gfq = true;
                } else if (gfy == hashCode) {
                    this.field_hbType = cursor.getInt(i2);
                } else if (gfz == hashCode) {
                    this.field_receiveAmount = cursor.getLong(i2);
                } else if (fJg == hashCode) {
                    this.field_receiveTime = cursor.getLong(i2);
                } else if (fWn == hashCode) {
                    this.field_receiveStatus = cursor.getInt(i2);
                } else if (gfA == hashCode) {
                    this.field_hbStatus = cursor.getInt(i2);
                } else if (gfB == hashCode) {
                    this.field_sender = cursor.getString(i2);
                } else if (gfC == hashCode) {
                    this.field_exclusiveUsername = cursor.getString(i2);
                } else if (gfD == hashCode) {
                    this.field_sendId = cursor.getString(i2);
                } else if (fWo == hashCode) {
                    this.field_invalidtime = cursor.getInt(i2);
                } else if (fqv == hashCode) {
                    this.field_msgSvrId = cursor.getLong(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.gfq) {
            contentValues.put("mNativeUrl", this.field_mNativeUrl);
        }
        if (this.gfr) {
            contentValues.put("hbType", Integer.valueOf(this.field_hbType));
        }
        if (this.gfs) {
            contentValues.put("receiveAmount", Long.valueOf(this.field_receiveAmount));
        }
        if (this.fIU) {
            contentValues.put("receiveTime", Long.valueOf(this.field_receiveTime));
        }
        if (this.fWk) {
            contentValues.put("receiveStatus", Integer.valueOf(this.field_receiveStatus));
        }
        if (this.gft) {
            contentValues.put("hbStatus", Integer.valueOf(this.field_hbStatus));
        }
        if (this.gfu) {
            contentValues.put("sender", this.field_sender);
        }
        if (this.gfv) {
            contentValues.put("exclusiveUsername", this.field_exclusiveUsername);
        }
        if (this.gfw) {
            contentValues.put("sendId", this.field_sendId);
        }
        if (this.fWl) {
            contentValues.put("invalidtime", Integer.valueOf(this.field_invalidtime));
        }
        if (this.fqh) {
            contentValues.put("msgSvrId", Long.valueOf(this.field_msgSvrId));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
