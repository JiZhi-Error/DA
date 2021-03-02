package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class fq extends IAutoDBItem {
    public static final String[] INDEX_CREATE = {"CREATE INDEX IF NOT EXISTS record_localid_index ON RecordCDNInfo(recordLocalId)"};
    private static final int fAT = "toUser".hashCode();
    private static final int fAq = "dataId".hashCode();
    private static final int fAs = "cdnKey".hashCode();
    private static final int fCA = "errCode".hashCode();
    private static final int fCr = "fileType".hashCode();
    private static final int fVZ = "recordLocalId".hashCode();
    private static final int fWa = "isThumb".hashCode();
    private static final int fWb = "tpaeskey".hashCode();
    private static final int fWc = "tpdataurl".hashCode();
    private static final int fjl = "status".hashCode();
    private static final int fkH = "path".hashCode();
    private static final int fkm = "mediaId".hashCode();
    private static final int fko = "totalLen".hashCode();
    private static final int fkp = "offset".hashCode();
    private static final int fyF = "tpauthkey".hashCode();
    private static final int fyw = "cdnUrl".hashCode();
    private static final int localId_HASHCODE = ch.COL_LOCALID.hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private static final int type_HASHCODE = "type".hashCode();
    private boolean __hadSetlocalId = true;
    private boolean __hadSettype = true;
    private boolean fAF = true;
    private boolean fAl = true;
    private boolean fAn = true;
    private boolean fBN = true;
    private boolean fBW = true;
    private boolean fVV = true;
    private boolean fVW = true;
    private boolean fVX = true;
    private boolean fVY = true;
    public String field_cdnKey;
    public String field_cdnUrl;
    public String field_dataId;
    public int field_errCode;
    public int field_fileType;
    public boolean field_isThumb;
    public int field_localId;
    public String field_mediaId;
    public int field_offset;
    public String field_path;
    public int field_recordLocalId;
    public int field_status;
    public String field_toUser;
    public int field_totalLen;
    public String field_tpaeskey;
    public String field_tpauthkey;
    public String field_tpdataurl;
    public int field_type;
    private boolean fjV = true;
    private boolean fjX = true;
    private boolean fjY = true;
    private boolean fji = true;
    private boolean fkD = true;
    private boolean fxK = true;
    private boolean fxT = true;

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
                } else if (fVZ == hashCode) {
                    this.field_recordLocalId = cursor.getInt(i2);
                } else if (fAT == hashCode) {
                    this.field_toUser = cursor.getString(i2);
                } else if (fAq == hashCode) {
                    this.field_dataId = cursor.getString(i2);
                } else if (fkm == hashCode) {
                    this.field_mediaId = cursor.getString(i2);
                } else if (fkH == hashCode) {
                    this.field_path = cursor.getString(i2);
                } else if (fyw == hashCode) {
                    this.field_cdnUrl = cursor.getString(i2);
                } else if (fAs == hashCode) {
                    this.field_cdnKey = cursor.getString(i2);
                } else if (fko == hashCode) {
                    this.field_totalLen = cursor.getInt(i2);
                } else if (fWa == hashCode) {
                    this.field_isThumb = cursor.getInt(i2) != 0;
                } else if (fkp == hashCode) {
                    this.field_offset = cursor.getInt(i2);
                } else if (type_HASHCODE == hashCode) {
                    this.field_type = cursor.getInt(i2);
                } else if (fCr == hashCode) {
                    this.field_fileType = cursor.getInt(i2);
                } else if (fjl == hashCode) {
                    this.field_status = cursor.getInt(i2);
                } else if (fCA == hashCode) {
                    this.field_errCode = cursor.getInt(i2);
                } else if (fWb == hashCode) {
                    this.field_tpaeskey = cursor.getString(i2);
                } else if (fyF == hashCode) {
                    this.field_tpauthkey = cursor.getString(i2);
                } else if (fWc == hashCode) {
                    this.field_tpdataurl = cursor.getString(i2);
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
        if (this.fVV) {
            contentValues.put("recordLocalId", Integer.valueOf(this.field_recordLocalId));
        }
        if (this.field_toUser == null) {
            this.field_toUser = "";
        }
        if (this.fAF) {
            contentValues.put("toUser", this.field_toUser);
        }
        if (this.fAl) {
            contentValues.put("dataId", this.field_dataId);
        }
        if (this.fjV) {
            contentValues.put("mediaId", this.field_mediaId);
        }
        if (this.fkD) {
            contentValues.put("path", this.field_path);
        }
        if (this.fxK) {
            contentValues.put("cdnUrl", this.field_cdnUrl);
        }
        if (this.fAn) {
            contentValues.put("cdnKey", this.field_cdnKey);
        }
        if (this.fjX) {
            contentValues.put("totalLen", Integer.valueOf(this.field_totalLen));
        }
        if (this.fVW) {
            contentValues.put("isThumb", Boolean.valueOf(this.field_isThumb));
        }
        if (this.fjY) {
            contentValues.put("offset", Integer.valueOf(this.field_offset));
        }
        if (this.__hadSettype) {
            contentValues.put("type", Integer.valueOf(this.field_type));
        }
        if (this.fBN) {
            contentValues.put("fileType", Integer.valueOf(this.field_fileType));
        }
        if (this.fji) {
            contentValues.put("status", Integer.valueOf(this.field_status));
        }
        if (this.fBW) {
            contentValues.put("errCode", Integer.valueOf(this.field_errCode));
        }
        if (this.fVX) {
            contentValues.put("tpaeskey", this.field_tpaeskey);
        }
        if (this.fxT) {
            contentValues.put("tpauthkey", this.field_tpauthkey);
        }
        if (this.fVY) {
            contentValues.put("tpdataurl", this.field_tpdataurl);
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
