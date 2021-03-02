package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class cw extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fFE = "mediaType".hashCode();
    private static final int fFe = FFmpegMetadataRetriever.METADATA_KEY_DURATION.hashCode();
    private static final int fHX = "compressPath".hashCode();
    private static final int fHY = "thumbPath".hashCode();
    private static final int fHZ = "isGif".hashCode();
    private static final int fIa = "mediaUrl".hashCode();
    private static final int fIb = "thumbPicUrl".hashCode();
    private static final int fIc = "uploadState".hashCode();
    private static final int fId = "hostTaskId".hashCode();
    private static final int fIe = "editFlag".hashCode();
    private static final int fkX = "size".hashCode();
    private static final int fkm = "mediaId".hashCode();
    private static final int fsu = "filePath".hashCode();
    private static final int fyA = "height".hashCode();
    private static final int fyz = "width".hashCode();
    private static final int localId_HASHCODE = ch.COL_LOCALID.hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private boolean __hadSetlocalId = true;
    private boolean fES = true;
    private boolean fFn = true;
    private boolean fHP = true;
    private boolean fHQ = true;
    private boolean fHR = true;
    private boolean fHS = true;
    private boolean fHT = true;
    private boolean fHU = true;
    private boolean fHV = true;
    private boolean fHW = true;
    public String field_compressPath;
    public int field_duration;
    public int field_editFlag;
    public String field_filePath;
    public int field_height;
    public String field_hostTaskId;
    public boolean field_isGif;
    public String field_localId;
    public String field_mediaId;
    public int field_mediaType;
    public String field_mediaUrl;
    public long field_size;
    public String field_thumbPath;
    public String field_thumbPicUrl;
    public int field_uploadState;
    public int field_width;
    private boolean fjV = true;
    private boolean fkV = true;
    private boolean fsm = true;
    private boolean fxN = true;
    private boolean fxO = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (localId_HASHCODE == hashCode) {
                    this.field_localId = cursor.getString(i2);
                    this.__hadSetlocalId = true;
                } else if (fkm == hashCode) {
                    this.field_mediaId = cursor.getString(i2);
                } else if (fFE == hashCode) {
                    this.field_mediaType = cursor.getInt(i2);
                } else if (fsu == hashCode) {
                    this.field_filePath = cursor.getString(i2);
                } else if (fHX == hashCode) {
                    this.field_compressPath = cursor.getString(i2);
                } else if (fHY == hashCode) {
                    this.field_thumbPath = cursor.getString(i2);
                } else if (fyz == hashCode) {
                    this.field_width = cursor.getInt(i2);
                } else if (fyA == hashCode) {
                    this.field_height = cursor.getInt(i2);
                } else if (fFe == hashCode) {
                    this.field_duration = cursor.getInt(i2);
                } else if (fkX == hashCode) {
                    this.field_size = cursor.getLong(i2);
                } else if (fHZ == hashCode) {
                    this.field_isGif = cursor.getInt(i2) != 0;
                } else if (fIa == hashCode) {
                    this.field_mediaUrl = cursor.getString(i2);
                } else if (fIb == hashCode) {
                    this.field_thumbPicUrl = cursor.getString(i2);
                } else if (fIc == hashCode) {
                    this.field_uploadState = cursor.getInt(i2);
                } else if (fId == hashCode) {
                    this.field_hostTaskId = cursor.getString(i2);
                } else if (fIe == hashCode) {
                    this.field_editFlag = cursor.getInt(i2);
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
            contentValues.put(ch.COL_LOCALID, this.field_localId);
        }
        if (this.fjV) {
            contentValues.put("mediaId", this.field_mediaId);
        }
        if (this.fFn) {
            contentValues.put("mediaType", Integer.valueOf(this.field_mediaType));
        }
        if (this.fsm) {
            contentValues.put("filePath", this.field_filePath);
        }
        if (this.fHP) {
            contentValues.put("compressPath", this.field_compressPath);
        }
        if (this.fHQ) {
            contentValues.put("thumbPath", this.field_thumbPath);
        }
        if (this.fxN) {
            contentValues.put("width", Integer.valueOf(this.field_width));
        }
        if (this.fxO) {
            contentValues.put("height", Integer.valueOf(this.field_height));
        }
        if (this.fES) {
            contentValues.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, Integer.valueOf(this.field_duration));
        }
        if (this.fkV) {
            contentValues.put("size", Long.valueOf(this.field_size));
        }
        if (this.fHR) {
            contentValues.put("isGif", Boolean.valueOf(this.field_isGif));
        }
        if (this.fHS) {
            contentValues.put("mediaUrl", this.field_mediaUrl);
        }
        if (this.fHT) {
            contentValues.put("thumbPicUrl", this.field_thumbPicUrl);
        }
        if (this.fHU) {
            contentValues.put("uploadState", Integer.valueOf(this.field_uploadState));
        }
        if (this.fHV) {
            contentValues.put("hostTaskId", this.field_hostTaskId);
        }
        if (this.fHW) {
            contentValues.put("editFlag", Integer.valueOf(this.field_editFlag));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
