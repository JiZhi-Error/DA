package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class hb extends IAutoDBItem {
    public static final String[] INDEX_CREATE = {"CREATE INDEX IF NOT EXISTS voiceRemindFileNameIndex ON VoiceRemindInfo(filename)"};
    private static final int fLi = "createtime".hashCode();
    private static final int fjl = "status".hashCode();
    private static final int fkp = "offset".hashCode();
    private static final int fyl = "reserved1".hashCode();
    private static final int fym = "reserved2".hashCode();
    private static final int gcS = "filename".hashCode();
    private static final int gcT = "user".hashCode();
    private static final int gcU = "msgid".hashCode();
    private static final int gcV = "filenowsize".hashCode();
    private static final int gcW = "totallen".hashCode();
    private static final int gcX = "lastmodifytime".hashCode();
    private static final int gcY = "clientid".hashCode();
    private static final int gcZ = "voicelenght".hashCode();
    private static final int gda = "msglocalid".hashCode();
    private static final int gdb = "human".hashCode();
    private static final int gdc = "voiceformat".hashCode();
    private static final int gdd = "nettimes".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private boolean fKX = true;
    public String field_clientid;
    public long field_createtime;
    public String field_filename;
    public int field_filenowsize;
    public String field_human;
    public long field_lastmodifytime;
    public long field_msgid;
    public int field_msglocalid;
    public int field_nettimes;
    public int field_offset;
    public int field_reserved1;
    public String field_reserved2;
    public int field_status;
    public int field_totallen;
    public String field_user;
    public int field_voiceformat;
    public int field_voicelenght;
    private boolean fjY = true;
    private boolean fji = true;
    private boolean fxA = true;
    private boolean fxz = true;
    private boolean gcG = true;
    private boolean gcH = true;
    private boolean gcI = true;
    private boolean gcJ = true;
    private boolean gcK = true;
    private boolean gcL = true;
    private boolean gcM = true;
    private boolean gcN = true;
    private boolean gcO = true;
    private boolean gcP = true;
    private boolean gcQ = true;
    private boolean gcR = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (gcS == hashCode) {
                    this.field_filename = cursor.getString(i2);
                } else if (gcT == hashCode) {
                    this.field_user = cursor.getString(i2);
                } else if (gcU == hashCode) {
                    this.field_msgid = cursor.getLong(i2);
                } else if (fkp == hashCode) {
                    this.field_offset = cursor.getInt(i2);
                } else if (gcV == hashCode) {
                    this.field_filenowsize = cursor.getInt(i2);
                } else if (gcW == hashCode) {
                    this.field_totallen = cursor.getInt(i2);
                } else if (fjl == hashCode) {
                    this.field_status = cursor.getInt(i2);
                } else if (fLi == hashCode) {
                    this.field_createtime = cursor.getLong(i2);
                } else if (gcX == hashCode) {
                    this.field_lastmodifytime = cursor.getLong(i2);
                } else if (gcY == hashCode) {
                    this.field_clientid = cursor.getString(i2);
                } else if (gcZ == hashCode) {
                    this.field_voicelenght = cursor.getInt(i2);
                } else if (gda == hashCode) {
                    this.field_msglocalid = cursor.getInt(i2);
                } else if (gdb == hashCode) {
                    this.field_human = cursor.getString(i2);
                } else if (gdc == hashCode) {
                    this.field_voiceformat = cursor.getInt(i2);
                } else if (gdd == hashCode) {
                    this.field_nettimes = cursor.getInt(i2);
                } else if (fyl == hashCode) {
                    this.field_reserved1 = cursor.getInt(i2);
                } else if (fym == hashCode) {
                    this.field_reserved2 = cursor.getString(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.gcG) {
            contentValues.put("filename", this.field_filename);
        }
        if (this.gcH) {
            contentValues.put("user", this.field_user);
        }
        if (this.gcI) {
            contentValues.put("msgid", Long.valueOf(this.field_msgid));
        }
        if (this.fjY) {
            contentValues.put("offset", Integer.valueOf(this.field_offset));
        }
        if (this.gcJ) {
            contentValues.put("filenowsize", Integer.valueOf(this.field_filenowsize));
        }
        if (this.gcK) {
            contentValues.put("totallen", Integer.valueOf(this.field_totallen));
        }
        if (this.fji) {
            contentValues.put("status", Integer.valueOf(this.field_status));
        }
        if (this.fKX) {
            contentValues.put("createtime", Long.valueOf(this.field_createtime));
        }
        if (this.gcL) {
            contentValues.put("lastmodifytime", Long.valueOf(this.field_lastmodifytime));
        }
        if (this.gcM) {
            contentValues.put("clientid", this.field_clientid);
        }
        if (this.gcN) {
            contentValues.put("voicelenght", Integer.valueOf(this.field_voicelenght));
        }
        if (this.gcO) {
            contentValues.put("msglocalid", Integer.valueOf(this.field_msglocalid));
        }
        if (this.gcP) {
            contentValues.put("human", this.field_human);
        }
        if (this.gcQ) {
            contentValues.put("voiceformat", Integer.valueOf(this.field_voiceformat));
        }
        if (this.gcR) {
            contentValues.put("nettimes", Integer.valueOf(this.field_nettimes));
        }
        if (this.fxz) {
            contentValues.put("reserved1", Integer.valueOf(this.field_reserved1));
        }
        if (this.fxA) {
            contentValues.put("reserved2", this.field_reserved2);
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
