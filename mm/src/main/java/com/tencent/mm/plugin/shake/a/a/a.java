package com.tencent.mm.plugin.shake.a.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class a extends IAutoDBItem {
    private static final int Dgu = "thumburl".hashCode();
    private static final int Dgv = "reservedBuf".hashCode();
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fBC = "tag".hashCode();
    private static final int fBo = "subtype".hashCode();
    private static final int fLi = "createtime".hashCode();
    private static final int fjl = "status".hashCode();
    private static final int fne = "title".hashCode();
    private static final int fyW = "desc".hashCode();
    private static final int fyg = "svrid".hashCode();
    private static final int fyl = "reserved1".hashCode();
    private static final int fym = "reserved2".hashCode();
    private static final int fyn = "reserved3".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private static final int type_HASHCODE = "type".hashCode();
    private boolean Dgs = true;
    private boolean Dgt = true;
    private boolean __hadSettype = true;
    private boolean fBm = true;
    private boolean fBs = true;
    private boolean fKX = true;
    public long field_createtime;
    public String field_desc;
    public String field_reserved1;
    public String field_reserved2;
    public int field_reserved3;
    public byte[] field_reservedBuf;
    public int field_status;
    public int field_subtype;
    public long field_svrid;
    public String field_tag;
    public String field_thumburl;
    public String field_title;
    public int field_type;
    private boolean fji = true;
    private boolean fnb = true;
    private boolean fxA = true;
    private boolean fxB = true;
    private boolean fxu = true;
    private boolean fxz = true;
    private boolean fyS = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fyg == hashCode) {
                    this.field_svrid = cursor.getLong(i2);
                    this.fxu = true;
                } else if (type_HASHCODE == hashCode) {
                    this.field_type = cursor.getInt(i2);
                } else if (fBo == hashCode) {
                    this.field_subtype = cursor.getInt(i2);
                } else if (fLi == hashCode) {
                    this.field_createtime = cursor.getLong(i2);
                } else if (fBC == hashCode) {
                    this.field_tag = cursor.getString(i2);
                } else if (fjl == hashCode) {
                    this.field_status = cursor.getInt(i2);
                } else if (fne == hashCode) {
                    this.field_title = cursor.getString(i2);
                } else if (fyW == hashCode) {
                    this.field_desc = cursor.getString(i2);
                } else if (Dgu == hashCode) {
                    this.field_thumburl = cursor.getString(i2);
                } else if (fyl == hashCode) {
                    this.field_reserved1 = cursor.getString(i2);
                } else if (fym == hashCode) {
                    this.field_reserved2 = cursor.getString(i2);
                } else if (fyn == hashCode) {
                    this.field_reserved3 = cursor.getInt(i2);
                } else if (Dgv == hashCode) {
                    this.field_reservedBuf = cursor.getBlob(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.fxu) {
            contentValues.put("svrid", Long.valueOf(this.field_svrid));
        }
        if (this.__hadSettype) {
            contentValues.put("type", Integer.valueOf(this.field_type));
        }
        if (this.fBm) {
            contentValues.put("subtype", Integer.valueOf(this.field_subtype));
        }
        if (this.fKX) {
            contentValues.put("createtime", Long.valueOf(this.field_createtime));
        }
        if (this.fBs) {
            contentValues.put("tag", this.field_tag);
        }
        if (this.fji) {
            contentValues.put("status", Integer.valueOf(this.field_status));
        }
        if (this.fnb) {
            contentValues.put("title", this.field_title);
        }
        if (this.fyS) {
            contentValues.put("desc", this.field_desc);
        }
        if (this.Dgs) {
            contentValues.put("thumburl", this.field_thumburl);
        }
        if (this.fxz) {
            contentValues.put("reserved1", this.field_reserved1);
        }
        if (this.fxA) {
            contentValues.put("reserved2", this.field_reserved2);
        }
        if (this.fxB) {
            contentValues.put("reserved3", Integer.valueOf(this.field_reserved3));
        }
        if (this.Dgt) {
            contentValues.put("reservedBuf", this.field_reservedBuf);
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
