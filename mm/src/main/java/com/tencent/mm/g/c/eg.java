package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class eg extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fPA = "hostRoomId".hashCode();
    private static final int fPB = "liveName".hashCode();
    private static final int fPC = "anchorUsername".hashCode();
    private static final int fPD = "isSender".hashCode();
    private static final int fPE = "timeStamp".hashCode();
    private static final int fPz = "liveId".hashCode();
    private static final int fyv = "thumbUrl".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private boolean fPt = true;
    private boolean fPu = true;
    private boolean fPv = true;
    private boolean fPw = true;
    private boolean fPx = true;
    private boolean fPy = true;
    public String field_anchorUsername;
    public String field_hostRoomId;
    public boolean field_isSender;
    public long field_liveId;
    public String field_liveName;
    public String field_thumbUrl;
    public long field_timeStamp;
    private boolean fxJ = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fPz == hashCode) {
                    this.field_liveId = cursor.getLong(i2);
                    this.fPt = true;
                } else if (fPA == hashCode) {
                    this.field_hostRoomId = cursor.getString(i2);
                } else if (fPB == hashCode) {
                    this.field_liveName = cursor.getString(i2);
                } else if (fyv == hashCode) {
                    this.field_thumbUrl = cursor.getString(i2);
                } else if (fPC == hashCode) {
                    this.field_anchorUsername = cursor.getString(i2);
                } else if (fPD == hashCode) {
                    this.field_isSender = cursor.getInt(i2) != 0;
                } else if (fPE == hashCode) {
                    this.field_timeStamp = cursor.getLong(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.fPt) {
            contentValues.put("liveId", Long.valueOf(this.field_liveId));
        }
        if (this.field_hostRoomId == null) {
            this.field_hostRoomId = "";
        }
        if (this.fPu) {
            contentValues.put("hostRoomId", this.field_hostRoomId);
        }
        if (this.field_liveName == null) {
            this.field_liveName = "";
        }
        if (this.fPv) {
            contentValues.put("liveName", this.field_liveName);
        }
        if (this.field_thumbUrl == null) {
            this.field_thumbUrl = "";
        }
        if (this.fxJ) {
            contentValues.put("thumbUrl", this.field_thumbUrl);
        }
        if (this.field_anchorUsername == null) {
            this.field_anchorUsername = "";
        }
        if (this.fPw) {
            contentValues.put("anchorUsername", this.field_anchorUsername);
        }
        if (this.fPx) {
            contentValues.put("isSender", Boolean.valueOf(this.field_isSender));
        }
        if (this.fPy) {
            contentValues.put("timeStamp", Long.valueOf(this.field_timeStamp));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
