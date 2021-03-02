package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class ak extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fpg = "qyUin".hashCode();
    private static final int fph = "userUin".hashCode();
    private static final int fpi = "userFlag".hashCode();
    private static final int fpj = "wwExposeTimes".hashCode();
    private static final int fpk = "wwMaxExposeTimes".hashCode();
    private static final int fpl = "wwCorpId".hashCode();
    private static final int fpm = "wwUserVid".hashCode();
    private static final int fpn = "userType".hashCode();
    private static final int fpo = "chatOpen".hashCode();
    private static final int fpp = "wwUnreadCnt".hashCode();
    private static final int fpq = "show_confirm".hashCode();
    private static final int fpr = "use_preset_banner_tips".hashCode();
    private static final int fpt = "hide_create_chat".hashCode();
    private static final int fpu = "hide_mod_chat_member".hashCode();
    private static final int fpv = "hide_colleage_invite".hashCode();
    private static final int fpw = "raw_attrs".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private static final int userName_HASHCODE = "userName".hashCode();
    private boolean __hadSetuserName = true;
    public boolean field_chatOpen;
    public boolean field_hide_colleage_invite;
    public boolean field_hide_create_chat;
    public boolean field_hide_mod_chat_member;
    public int field_qyUin;
    public byte[] field_raw_attrs;
    public boolean field_show_confirm;
    public boolean field_use_preset_banner_tips;
    public int field_userFlag;
    public String field_userName;
    public int field_userType;
    public int field_userUin;
    public long field_wwCorpId;
    public int field_wwExposeTimes;
    public int field_wwMaxExposeTimes;
    public int field_wwUnreadCnt;
    public long field_wwUserVid;
    private boolean foQ = true;
    private boolean foR = true;
    private boolean foS = true;
    private boolean foT = true;
    private boolean foU = true;
    private boolean foV = true;
    private boolean foW = true;
    private boolean foX = true;
    private boolean foY = true;
    private boolean foZ = true;
    private boolean fpa = true;
    private boolean fpb = true;
    private boolean fpc = true;
    private boolean fpd = true;
    private boolean fpe = true;
    private boolean fpf = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (userName_HASHCODE == hashCode) {
                    this.field_userName = cursor.getString(i2);
                    this.__hadSetuserName = true;
                } else if (fpg == hashCode) {
                    this.field_qyUin = cursor.getInt(i2);
                } else if (fph == hashCode) {
                    this.field_userUin = cursor.getInt(i2);
                } else if (fpi == hashCode) {
                    this.field_userFlag = cursor.getInt(i2);
                } else if (fpj == hashCode) {
                    this.field_wwExposeTimes = cursor.getInt(i2);
                } else if (fpk == hashCode) {
                    this.field_wwMaxExposeTimes = cursor.getInt(i2);
                } else if (fpl == hashCode) {
                    this.field_wwCorpId = cursor.getLong(i2);
                } else if (fpm == hashCode) {
                    this.field_wwUserVid = cursor.getLong(i2);
                } else if (fpn == hashCode) {
                    this.field_userType = cursor.getInt(i2);
                } else if (fpo == hashCode) {
                    this.field_chatOpen = cursor.getInt(i2) != 0;
                } else if (fpp == hashCode) {
                    this.field_wwUnreadCnt = cursor.getInt(i2);
                } else if (fpq == hashCode) {
                    this.field_show_confirm = cursor.getInt(i2) != 0;
                } else if (fpr == hashCode) {
                    this.field_use_preset_banner_tips = cursor.getInt(i2) != 0;
                } else if (fpt == hashCode) {
                    this.field_hide_create_chat = cursor.getInt(i2) != 0;
                } else if (fpu == hashCode) {
                    this.field_hide_mod_chat_member = cursor.getInt(i2) != 0;
                } else if (fpv == hashCode) {
                    this.field_hide_colleage_invite = cursor.getInt(i2) != 0;
                } else if (fpw == hashCode) {
                    this.field_raw_attrs = cursor.getBlob(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.__hadSetuserName) {
            contentValues.put("userName", this.field_userName);
        }
        if (this.foQ) {
            contentValues.put("qyUin", Integer.valueOf(this.field_qyUin));
        }
        if (this.foR) {
            contentValues.put("userUin", Integer.valueOf(this.field_userUin));
        }
        if (this.foS) {
            contentValues.put("userFlag", Integer.valueOf(this.field_userFlag));
        }
        if (this.foT) {
            contentValues.put("wwExposeTimes", Integer.valueOf(this.field_wwExposeTimes));
        }
        if (this.foU) {
            contentValues.put("wwMaxExposeTimes", Integer.valueOf(this.field_wwMaxExposeTimes));
        }
        if (this.foV) {
            contentValues.put("wwCorpId", Long.valueOf(this.field_wwCorpId));
        }
        if (this.foW) {
            contentValues.put("wwUserVid", Long.valueOf(this.field_wwUserVid));
        }
        if (this.foX) {
            contentValues.put("userType", Integer.valueOf(this.field_userType));
        }
        if (this.foY) {
            contentValues.put("chatOpen", Boolean.valueOf(this.field_chatOpen));
        }
        if (this.foZ) {
            contentValues.put("wwUnreadCnt", Integer.valueOf(this.field_wwUnreadCnt));
        }
        if (this.fpa) {
            contentValues.put("show_confirm", Boolean.valueOf(this.field_show_confirm));
        }
        if (this.fpb) {
            contentValues.put("use_preset_banner_tips", Boolean.valueOf(this.field_use_preset_banner_tips));
        }
        if (this.fpc) {
            contentValues.put("hide_create_chat", Boolean.valueOf(this.field_hide_create_chat));
        }
        if (this.fpd) {
            contentValues.put("hide_mod_chat_member", Boolean.valueOf(this.field_hide_mod_chat_member));
        }
        if (this.fpe) {
            contentValues.put("hide_colleage_invite", Boolean.valueOf(this.field_hide_colleage_invite));
        }
        if (this.fpf) {
            contentValues.put("raw_attrs", this.field_raw_attrs);
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
