package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class bt extends IAutoDBItem {
    public static final String[] INDEX_CREATE = {"CREATE INDEX IF NOT EXISTS fmconversation_isnew_Index ON fmessage_conversation(isNew)"};
    private static final int fAa = "contentFromUsername".hashCode();
    private static final int fAb = "contentNickname".hashCode();
    private static final int fAc = "contentPhoneNumMD5".hashCode();
    private static final int fAd = "contentFullPhoneNumMD5".hashCode();
    private static final int fAe = "contentVerifyContent".hashCode();
    private static final int fqw = "talker".hashCode();
    private static final int fyj = "state".hashCode();
    private static final int fzQ = "encryptTalker".hashCode();
    private static final int fzR = "displayName".hashCode();
    private static final int fzS = "lastModifiedTime".hashCode();
    private static final int fzT = "isNew".hashCode();
    private static final int fzU = "addScene".hashCode();
    private static final int fzV = "fmsgSysRowId".hashCode();
    private static final int fzW = "fmsgIsSend".hashCode();
    private static final int fzX = "fmsgType".hashCode();
    private static final int fzY = "fmsgContent".hashCode();
    private static final int fzZ = "recvFmsgType".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    public int field_addScene;
    public String field_contentFromUsername;
    public String field_contentFullPhoneNumMD5;
    public String field_contentNickname;
    public String field_contentPhoneNumMD5;
    public String field_contentVerifyContent;
    public String field_displayName;
    public String field_encryptTalker;
    public String field_fmsgContent;
    public int field_fmsgIsSend;
    public long field_fmsgSysRowId;
    public int field_fmsgType;
    public int field_isNew;
    public long field_lastModifiedTime;
    public int field_recvFmsgType;
    public int field_state;
    public String field_talker;
    private boolean fqi = true;
    private boolean fxx = true;
    private boolean fzB = true;
    private boolean fzC = true;
    private boolean fzD = true;
    private boolean fzE = true;
    private boolean fzF = true;
    private boolean fzG = true;
    private boolean fzH = true;
    private boolean fzI = true;
    private boolean fzJ = true;
    private boolean fzK = true;
    private boolean fzL = true;
    private boolean fzM = true;
    private boolean fzN = true;
    private boolean fzO = true;
    private boolean fzP = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fqw == hashCode) {
                    this.field_talker = cursor.getString(i2);
                    this.fqi = true;
                } else if (fzQ == hashCode) {
                    this.field_encryptTalker = cursor.getString(i2);
                } else if (fzR == hashCode) {
                    this.field_displayName = cursor.getString(i2);
                } else if (fyj == hashCode) {
                    this.field_state = cursor.getInt(i2);
                } else if (fzS == hashCode) {
                    this.field_lastModifiedTime = cursor.getLong(i2);
                } else if (fzT == hashCode) {
                    this.field_isNew = cursor.getInt(i2);
                } else if (fzU == hashCode) {
                    this.field_addScene = cursor.getInt(i2);
                } else if (fzV == hashCode) {
                    this.field_fmsgSysRowId = cursor.getLong(i2);
                } else if (fzW == hashCode) {
                    this.field_fmsgIsSend = cursor.getInt(i2);
                } else if (fzX == hashCode) {
                    this.field_fmsgType = cursor.getInt(i2);
                } else if (fzY == hashCode) {
                    this.field_fmsgContent = cursor.getString(i2);
                } else if (fzZ == hashCode) {
                    this.field_recvFmsgType = cursor.getInt(i2);
                } else if (fAa == hashCode) {
                    this.field_contentFromUsername = cursor.getString(i2);
                } else if (fAb == hashCode) {
                    this.field_contentNickname = cursor.getString(i2);
                } else if (fAc == hashCode) {
                    this.field_contentPhoneNumMD5 = cursor.getString(i2);
                } else if (fAd == hashCode) {
                    this.field_contentFullPhoneNumMD5 = cursor.getString(i2);
                } else if (fAe == hashCode) {
                    this.field_contentVerifyContent = cursor.getString(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.field_talker == null) {
            this.field_talker = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        }
        if (this.fqi) {
            contentValues.put("talker", this.field_talker);
        }
        if (this.field_encryptTalker == null) {
            this.field_encryptTalker = "";
        }
        if (this.fzB) {
            contentValues.put("encryptTalker", this.field_encryptTalker);
        }
        if (this.field_displayName == null) {
            this.field_displayName = "";
        }
        if (this.fzC) {
            contentValues.put("displayName", this.field_displayName);
        }
        if (this.fxx) {
            contentValues.put("state", Integer.valueOf(this.field_state));
        }
        if (this.fzD) {
            contentValues.put("lastModifiedTime", Long.valueOf(this.field_lastModifiedTime));
        }
        if (this.fzE) {
            contentValues.put("isNew", Integer.valueOf(this.field_isNew));
        }
        if (this.fzF) {
            contentValues.put("addScene", Integer.valueOf(this.field_addScene));
        }
        if (this.fzG) {
            contentValues.put("fmsgSysRowId", Long.valueOf(this.field_fmsgSysRowId));
        }
        if (this.fzH) {
            contentValues.put("fmsgIsSend", Integer.valueOf(this.field_fmsgIsSend));
        }
        if (this.fzI) {
            contentValues.put("fmsgType", Integer.valueOf(this.field_fmsgType));
        }
        if (this.field_fmsgContent == null) {
            this.field_fmsgContent = "";
        }
        if (this.fzJ) {
            contentValues.put("fmsgContent", this.field_fmsgContent);
        }
        if (this.fzK) {
            contentValues.put("recvFmsgType", Integer.valueOf(this.field_recvFmsgType));
        }
        if (this.field_contentFromUsername == null) {
            this.field_contentFromUsername = "";
        }
        if (this.fzL) {
            contentValues.put("contentFromUsername", this.field_contentFromUsername);
        }
        if (this.field_contentNickname == null) {
            this.field_contentNickname = "";
        }
        if (this.fzM) {
            contentValues.put("contentNickname", this.field_contentNickname);
        }
        if (this.field_contentPhoneNumMD5 == null) {
            this.field_contentPhoneNumMD5 = "";
        }
        if (this.fzN) {
            contentValues.put("contentPhoneNumMD5", this.field_contentPhoneNumMD5);
        }
        if (this.field_contentFullPhoneNumMD5 == null) {
            this.field_contentFullPhoneNumMD5 = "";
        }
        if (this.fzO) {
            contentValues.put("contentFullPhoneNumMD5", this.field_contentFullPhoneNumMD5);
        }
        if (this.field_contentVerifyContent == null) {
            this.field_contentVerifyContent = "";
        }
        if (this.fzP) {
            contentValues.put("contentVerifyContent", this.field_contentVerifyContent);
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
