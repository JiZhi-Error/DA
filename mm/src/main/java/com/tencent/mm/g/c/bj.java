package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class bj extends IAutoDBItem {
    public static final String[] INDEX_CREATE = {"CREATE INDEX IF NOT EXISTS emojiGroupIndex ON EmojiInfo(catalog)"};
    private static final int content_HASHCODE = "content".hashCode();
    private static final int fkX = "size".hashCode();
    private static final int flH = "source".hashCode();
    private static final int fxh = "lastUseTime".hashCode();
    private static final int fxl = "idx".hashCode();
    private static final int fyA = "height".hashCode();
    private static final int fyB = "externUrl".hashCode();
    private static final int fyC = "externMd5".hashCode();
    private static final int fyD = "activityid".hashCode();
    private static final int fyE = "tpurl".hashCode();
    private static final int fyF = "tpauthkey".hashCode();
    private static final int fyG = "wxamMd5".hashCode();
    private static final int fyH = "attachedText".hashCode();
    private static final int fyI = "captureStatus".hashCode();
    private static final int fyJ = "attachedEmojiMD5".hashCode();
    private static final int fyK = "imitateMd5".hashCode();
    private static final int fyL = "captureUploadErrCode".hashCode();
    private static final int fyM = "captureUploadCounter".hashCode();
    private static final int fyN = "captureEnterTime".hashCode();
    private static final int fyO = "lensId".hashCode();
    private static final int fyP = "attachTextColor".hashCode();
    private static final int fyQ = "captureScene".hashCode();
    private static final int fyf = "md5".hashCode();
    private static final int fyg = "svrid".hashCode();
    private static final int fyh = "catalog".hashCode();
    private static final int fyi = "start".hashCode();
    private static final int fyj = "state".hashCode();
    private static final int fyk = "name".hashCode();
    private static final int fyl = "reserved1".hashCode();
    private static final int fym = "reserved2".hashCode();
    private static final int fyn = "reserved3".hashCode();
    private static final int fyo = "reserved4".hashCode();
    private static final int fyp = "app_id".hashCode();
    private static final int fyq = "groupId".hashCode();
    private static final int fyr = "framesInfo".hashCode();
    private static final int fys = "temp".hashCode();
    private static final int fyt = "needupload".hashCode();
    private static final int fyu = "designerID".hashCode();
    private static final int fyv = "thumbUrl".hashCode();
    private static final int fyw = "cdnUrl".hashCode();
    private static final int fyx = "encrypturl".hashCode();
    private static final int fyy = "aeskey".hashCode();
    private static final int fyz = "width".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private static final int type_HASHCODE = "type".hashCode();
    private boolean __hadSetcontent = true;
    private boolean __hadSettype = true;
    public String field_activityid;
    public String field_aeskey;
    public String field_app_id;
    public String field_attachTextColor;
    public byte[] field_attachedEmojiMD5;
    public String field_attachedText;
    public long field_captureEnterTime;
    public int field_captureScene;
    public int field_captureStatus;
    public int field_captureUploadCounter;
    public int field_captureUploadErrCode;
    public int field_catalog;
    public String field_cdnUrl;
    public String field_content;
    public String field_designerID;
    public String field_encrypturl;
    public String field_externMd5;
    public String field_externUrl;
    public String field_framesInfo;
    public String field_groupId;
    public int field_height;
    public int field_idx;
    public String field_imitateMd5;
    public long field_lastUseTime;
    public String field_lensId;
    public String field_md5;
    public String field_name;
    public int field_needupload;
    public String field_reserved1;
    public String field_reserved2;
    public int field_reserved3;
    public int field_reserved4;
    public int field_size;
    public int field_source;
    public int field_start;
    public int field_state;
    public String field_svrid;
    public int field_temp;
    public String field_thumbUrl;
    public String field_tpauthkey;
    public String field_tpurl;
    public int field_type;
    public int field_width;
    public String field_wxamMd5;
    private boolean fkV = true;
    private boolean flC = true;
    private boolean fwH = true;
    private boolean fwL = true;
    private boolean fxA = true;
    private boolean fxB = true;
    private boolean fxC = true;
    private boolean fxD = true;
    private boolean fxE = true;
    private boolean fxF = true;
    private boolean fxG = true;
    private boolean fxH = true;
    private boolean fxI = true;
    private boolean fxJ = true;
    private boolean fxK = true;
    private boolean fxL = true;
    private boolean fxM = true;
    private boolean fxN = true;
    private boolean fxO = true;
    private boolean fxP = true;
    private boolean fxQ = true;
    private boolean fxR = true;
    private boolean fxS = true;
    private boolean fxT = true;
    private boolean fxU = true;
    private boolean fxV = true;
    private boolean fxW = true;
    private boolean fxX = true;
    private boolean fxY = true;
    private boolean fxZ = true;
    private boolean fxt = true;
    private boolean fxu = true;
    private boolean fxv = true;
    private boolean fxw = true;
    private boolean fxx = true;
    private boolean fxy = true;
    private boolean fxz = true;
    private boolean fya = true;
    private boolean fyb = true;
    private boolean fyc = true;
    private boolean fyd = true;
    private boolean fye = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fyf == hashCode) {
                    this.field_md5 = cursor.getString(i2);
                    this.fxt = true;
                } else if (fyg == hashCode) {
                    this.field_svrid = cursor.getString(i2);
                } else if (fyh == hashCode) {
                    this.field_catalog = cursor.getInt(i2);
                } else if (type_HASHCODE == hashCode) {
                    this.field_type = cursor.getInt(i2);
                } else if (fkX == hashCode) {
                    this.field_size = cursor.getInt(i2);
                } else if (fyi == hashCode) {
                    this.field_start = cursor.getInt(i2);
                } else if (fyj == hashCode) {
                    this.field_state = cursor.getInt(i2);
                } else if (fyk == hashCode) {
                    this.field_name = cursor.getString(i2);
                } else if (content_HASHCODE == hashCode) {
                    this.field_content = cursor.getString(i2);
                } else if (fyl == hashCode) {
                    this.field_reserved1 = cursor.getString(i2);
                } else if (fym == hashCode) {
                    this.field_reserved2 = cursor.getString(i2);
                } else if (fyn == hashCode) {
                    this.field_reserved3 = cursor.getInt(i2);
                } else if (fyo == hashCode) {
                    this.field_reserved4 = cursor.getInt(i2);
                } else if (fyp == hashCode) {
                    this.field_app_id = cursor.getString(i2);
                } else if (fyq == hashCode) {
                    this.field_groupId = cursor.getString(i2);
                } else if (fxh == hashCode) {
                    this.field_lastUseTime = cursor.getLong(i2);
                } else if (fyr == hashCode) {
                    this.field_framesInfo = cursor.getString(i2);
                } else if (fxl == hashCode) {
                    this.field_idx = cursor.getInt(i2);
                } else if (fys == hashCode) {
                    this.field_temp = cursor.getInt(i2);
                } else if (flH == hashCode) {
                    this.field_source = cursor.getInt(i2);
                } else if (fyt == hashCode) {
                    this.field_needupload = cursor.getInt(i2);
                } else if (fyu == hashCode) {
                    this.field_designerID = cursor.getString(i2);
                } else if (fyv == hashCode) {
                    this.field_thumbUrl = cursor.getString(i2);
                } else if (fyw == hashCode) {
                    this.field_cdnUrl = cursor.getString(i2);
                } else if (fyx == hashCode) {
                    this.field_encrypturl = cursor.getString(i2);
                } else if (fyy == hashCode) {
                    this.field_aeskey = cursor.getString(i2);
                } else if (fyz == hashCode) {
                    this.field_width = cursor.getInt(i2);
                } else if (fyA == hashCode) {
                    this.field_height = cursor.getInt(i2);
                } else if (fyB == hashCode) {
                    this.field_externUrl = cursor.getString(i2);
                } else if (fyC == hashCode) {
                    this.field_externMd5 = cursor.getString(i2);
                } else if (fyD == hashCode) {
                    this.field_activityid = cursor.getString(i2);
                } else if (fyE == hashCode) {
                    this.field_tpurl = cursor.getString(i2);
                } else if (fyF == hashCode) {
                    this.field_tpauthkey = cursor.getString(i2);
                } else if (fyG == hashCode) {
                    this.field_wxamMd5 = cursor.getString(i2);
                } else if (fyH == hashCode) {
                    this.field_attachedText = cursor.getString(i2);
                } else if (fyI == hashCode) {
                    this.field_captureStatus = cursor.getInt(i2);
                } else if (fyJ == hashCode) {
                    this.field_attachedEmojiMD5 = cursor.getBlob(i2);
                } else if (fyK == hashCode) {
                    this.field_imitateMd5 = cursor.getString(i2);
                } else if (fyL == hashCode) {
                    this.field_captureUploadErrCode = cursor.getInt(i2);
                } else if (fyM == hashCode) {
                    this.field_captureUploadCounter = cursor.getInt(i2);
                } else if (fyN == hashCode) {
                    this.field_captureEnterTime = cursor.getLong(i2);
                } else if (fyO == hashCode) {
                    this.field_lensId = cursor.getString(i2);
                } else if (fyP == hashCode) {
                    this.field_attachTextColor = cursor.getString(i2);
                } else if (fyQ == hashCode) {
                    this.field_captureScene = cursor.getInt(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.fxt) {
            contentValues.put("md5", this.field_md5);
        }
        if (this.fxu) {
            contentValues.put("svrid", this.field_svrid);
        }
        if (this.fxv) {
            contentValues.put("catalog", Integer.valueOf(this.field_catalog));
        }
        if (this.__hadSettype) {
            contentValues.put("type", Integer.valueOf(this.field_type));
        }
        if (this.fkV) {
            contentValues.put("size", Integer.valueOf(this.field_size));
        }
        if (this.fxw) {
            contentValues.put("start", Integer.valueOf(this.field_start));
        }
        if (this.fxx) {
            contentValues.put("state", Integer.valueOf(this.field_state));
        }
        if (this.fxy) {
            contentValues.put("name", this.field_name);
        }
        if (this.__hadSetcontent) {
            contentValues.put("content", this.field_content);
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
        if (this.fxC) {
            contentValues.put("reserved4", Integer.valueOf(this.field_reserved4));
        }
        if (this.fxD) {
            contentValues.put("app_id", this.field_app_id);
        }
        if (this.field_groupId == null) {
            this.field_groupId = "";
        }
        if (this.fxE) {
            contentValues.put("groupId", this.field_groupId);
        }
        if (this.fwH) {
            contentValues.put("lastUseTime", Long.valueOf(this.field_lastUseTime));
        }
        if (this.field_framesInfo == null) {
            this.field_framesInfo = "";
        }
        if (this.fxF) {
            contentValues.put("framesInfo", this.field_framesInfo);
        }
        if (this.fwL) {
            contentValues.put("idx", Integer.valueOf(this.field_idx));
        }
        if (this.fxG) {
            contentValues.put("temp", Integer.valueOf(this.field_temp));
        }
        if (this.flC) {
            contentValues.put("source", Integer.valueOf(this.field_source));
        }
        if (this.fxH) {
            contentValues.put("needupload", Integer.valueOf(this.field_needupload));
        }
        if (this.fxI) {
            contentValues.put("designerID", this.field_designerID);
        }
        if (this.fxJ) {
            contentValues.put("thumbUrl", this.field_thumbUrl);
        }
        if (this.fxK) {
            contentValues.put("cdnUrl", this.field_cdnUrl);
        }
        if (this.fxL) {
            contentValues.put("encrypturl", this.field_encrypturl);
        }
        if (this.fxM) {
            contentValues.put("aeskey", this.field_aeskey);
        }
        if (this.fxN) {
            contentValues.put("width", Integer.valueOf(this.field_width));
        }
        if (this.fxO) {
            contentValues.put("height", Integer.valueOf(this.field_height));
        }
        if (this.fxP) {
            contentValues.put("externUrl", this.field_externUrl);
        }
        if (this.fxQ) {
            contentValues.put("externMd5", this.field_externMd5);
        }
        if (this.fxR) {
            contentValues.put("activityid", this.field_activityid);
        }
        if (this.fxS) {
            contentValues.put("tpurl", this.field_tpurl);
        }
        if (this.fxT) {
            contentValues.put("tpauthkey", this.field_tpauthkey);
        }
        if (this.fxU) {
            contentValues.put("wxamMd5", this.field_wxamMd5);
        }
        if (this.fxV) {
            contentValues.put("attachedText", this.field_attachedText);
        }
        if (this.fxW) {
            contentValues.put("captureStatus", Integer.valueOf(this.field_captureStatus));
        }
        if (this.fxX) {
            contentValues.put("attachedEmojiMD5", this.field_attachedEmojiMD5);
        }
        if (this.fxY) {
            contentValues.put("imitateMd5", this.field_imitateMd5);
        }
        if (this.fxZ) {
            contentValues.put("captureUploadErrCode", Integer.valueOf(this.field_captureUploadErrCode));
        }
        if (this.fya) {
            contentValues.put("captureUploadCounter", Integer.valueOf(this.field_captureUploadCounter));
        }
        if (this.fyb) {
            contentValues.put("captureEnterTime", Long.valueOf(this.field_captureEnterTime));
        }
        if (this.fyc) {
            contentValues.put("lensId", this.field_lensId);
        }
        if (this.fyd) {
            contentValues.put("attachTextColor", this.field_attachTextColor);
        }
        if (this.fye) {
            contentValues.put("captureScene", Integer.valueOf(this.field_captureScene));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }

    public void reset() {
    }
}
