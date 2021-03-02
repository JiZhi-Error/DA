package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class cx extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int createTime_HASHCODE = "createTime".hashCode();
    private static final int fFE = "mediaType".hashCode();
    private static final int fIc = "uploadState".hashCode();
    private static final int fIp = "taskId".hashCode();
    private static final int fIq = "publishSource".hashCode();
    private static final int fIr = "localIdList".hashCode();
    private static final int fIs = "mediaList".hashCode();
    private static final int fIt = "BusinessData".hashCode();
    private static final int fIu = "publishState".hashCode();
    private static final int fIv = "compressImg".hashCode();
    private static final int fIw = "mixState".hashCode();
    private static final int fIx = "bgMixTaskId".hashCode();
    private static final int fIy = "sourceSceneId".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private boolean __hadSetcreateTime = true;
    private boolean fFn = true;
    private boolean fHU = true;
    private boolean fIf = true;
    private boolean fIg = true;
    private boolean fIh = true;
    private boolean fIi = true;
    private boolean fIj = true;
    private boolean fIk = true;
    private boolean fIl = true;
    private boolean fIm = true;
    private boolean fIn = true;
    private boolean fIo = true;
    public String field_BusinessData;
    public String field_bgMixTaskId;
    public boolean field_compressImg;
    public long field_createTime;
    public String field_localIdList;
    public String field_mediaList;
    public int field_mediaType;
    public int field_mixState;
    public int field_publishSource;
    public int field_publishState;
    public int field_sourceSceneId;
    public String field_taskId;
    public int field_uploadState;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fIp == hashCode) {
                    this.field_taskId = cursor.getString(i2);
                    this.fIf = true;
                } else if (createTime_HASHCODE == hashCode) {
                    this.field_createTime = cursor.getLong(i2);
                } else if (fIq == hashCode) {
                    this.field_publishSource = cursor.getInt(i2);
                } else if (fFE == hashCode) {
                    this.field_mediaType = cursor.getInt(i2);
                } else if (fIr == hashCode) {
                    this.field_localIdList = cursor.getString(i2);
                } else if (fIs == hashCode) {
                    this.field_mediaList = cursor.getString(i2);
                } else if (fIt == hashCode) {
                    this.field_BusinessData = cursor.getString(i2);
                } else if (fIc == hashCode) {
                    this.field_uploadState = cursor.getInt(i2);
                } else if (fIu == hashCode) {
                    this.field_publishState = cursor.getInt(i2);
                } else if (fIv == hashCode) {
                    this.field_compressImg = cursor.getInt(i2) != 0;
                } else if (fIw == hashCode) {
                    this.field_mixState = cursor.getInt(i2);
                } else if (fIx == hashCode) {
                    this.field_bgMixTaskId = cursor.getString(i2);
                } else if (fIy == hashCode) {
                    this.field_sourceSceneId = cursor.getInt(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.fIf) {
            contentValues.put("taskId", this.field_taskId);
        }
        if (this.__hadSetcreateTime) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.fIg) {
            contentValues.put("publishSource", Integer.valueOf(this.field_publishSource));
        }
        if (this.fFn) {
            contentValues.put("mediaType", Integer.valueOf(this.field_mediaType));
        }
        if (this.fIh) {
            contentValues.put("localIdList", this.field_localIdList);
        }
        if (this.fIi) {
            contentValues.put("mediaList", this.field_mediaList);
        }
        if (this.fIj) {
            contentValues.put("BusinessData", this.field_BusinessData);
        }
        if (this.fHU) {
            contentValues.put("uploadState", Integer.valueOf(this.field_uploadState));
        }
        if (this.fIk) {
            contentValues.put("publishState", Integer.valueOf(this.field_publishState));
        }
        if (this.fIl) {
            contentValues.put("compressImg", Boolean.valueOf(this.field_compressImg));
        }
        if (this.fIm) {
            contentValues.put("mixState", Integer.valueOf(this.field_mixState));
        }
        if (this.fIn) {
            contentValues.put("bgMixTaskId", this.field_bgMixTaskId);
        }
        if (this.fIo) {
            contentValues.put("sourceSceneId", Integer.valueOf(this.field_sourceSceneId));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
