package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.plugin.gamelife.b.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.io.IOException;
import java.lang.reflect.Field;

public abstract class cz extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fBC = "tag".hashCode();
    private static final int fID = "accountType".hashCode();
    private static final int fIE = "avatarURL".hashCode();
    private static final int fIF = "sex".hashCode();
    private static final int fIG = "jumpInfo".hashCode();
    private static final int fqf = "nickname".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private static final int updateTime_HASHCODE = ch.COL_UPDATETIME.hashCode();
    private static final int username_HASHCODE = ch.COL_USERNAME.hashCode();
    private boolean __hadSetupdateTime = true;
    private boolean __hadSetusername = true;
    private boolean fBs = true;
    private boolean fIA = true;
    private boolean fIB = true;
    private boolean fIC = true;
    private boolean fIz = true;
    public int field_accountType;
    public String field_avatarURL;
    public l field_jumpInfo;
    public String field_nickname;
    public int field_sex;
    public String field_tag;
    public long field_updateTime;
    public String field_username;
    private boolean fqb = true;

    public static IAutoDBItem.MAutoDBInfo ajs() {
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[8];
        mAutoDBInfo.columns = new String[9];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = ch.COL_USERNAME;
        mAutoDBInfo.colsMap.put(ch.COL_USERNAME, "TEXT default ''  PRIMARY KEY ");
        sb.append(" username TEXT default ''  PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = ch.COL_USERNAME;
        mAutoDBInfo.columns[1] = "accountType";
        mAutoDBInfo.colsMap.put("accountType", "INTEGER default '0' ");
        sb.append(" accountType INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "nickname";
        mAutoDBInfo.colsMap.put("nickname", "TEXT default '' ");
        sb.append(" nickname TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "avatarURL";
        mAutoDBInfo.colsMap.put("avatarURL", "TEXT default '' ");
        sb.append(" avatarURL TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "sex";
        mAutoDBInfo.colsMap.put("sex", "INTEGER default '0' ");
        sb.append(" sex INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "tag";
        mAutoDBInfo.colsMap.put("tag", "TEXT default '' ");
        sb.append(" tag TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[6] = "jumpInfo";
        mAutoDBInfo.colsMap.put("jumpInfo", "BLOB");
        sb.append(" jumpInfo BLOB");
        sb.append(", ");
        mAutoDBInfo.columns[7] = ch.COL_UPDATETIME;
        mAutoDBInfo.colsMap.put(ch.COL_UPDATETIME, "LONG");
        sb.append(" updateTime LONG");
        mAutoDBInfo.columns[8] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        return mAutoDBInfo;
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (username_HASHCODE == hashCode) {
                    this.field_username = cursor.getString(i2);
                    this.__hadSetusername = true;
                } else if (fID == hashCode) {
                    this.field_accountType = cursor.getInt(i2);
                } else if (fqf == hashCode) {
                    this.field_nickname = cursor.getString(i2);
                } else if (fIE == hashCode) {
                    this.field_avatarURL = cursor.getString(i2);
                } else if (fIF == hashCode) {
                    this.field_sex = cursor.getInt(i2);
                } else if (fBC == hashCode) {
                    this.field_tag = cursor.getString(i2);
                } else if (fIG == hashCode) {
                    try {
                        byte[] blob = cursor.getBlob(i2);
                        if (blob != null && blob.length > 0) {
                            this.field_jumpInfo = (l) new l().parseFrom(blob);
                        }
                    } catch (IOException e2) {
                        Log.e("MicroMsg.SDK.BaseGameLifeContact", e2.getMessage());
                    }
                } else if (updateTime_HASHCODE == hashCode) {
                    this.field_updateTime = cursor.getLong(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.field_username == null) {
            this.field_username = "";
        }
        if (this.__hadSetusername) {
            contentValues.put(ch.COL_USERNAME, this.field_username);
        }
        if (this.fIz) {
            contentValues.put("accountType", Integer.valueOf(this.field_accountType));
        }
        if (this.field_nickname == null) {
            this.field_nickname = "";
        }
        if (this.fqb) {
            contentValues.put("nickname", this.field_nickname);
        }
        if (this.field_avatarURL == null) {
            this.field_avatarURL = "";
        }
        if (this.fIA) {
            contentValues.put("avatarURL", this.field_avatarURL);
        }
        if (this.fIB) {
            contentValues.put("sex", Integer.valueOf(this.field_sex));
        }
        if (this.field_tag == null) {
            this.field_tag = "";
        }
        if (this.fBs) {
            contentValues.put("tag", this.field_tag);
        }
        if (this.fIC && this.field_jumpInfo != null) {
            try {
                contentValues.put("jumpInfo", this.field_jumpInfo.toByteArray());
            } catch (IOException e2) {
                Log.e("MicroMsg.SDK.BaseGameLifeContact", e2.getMessage());
            }
        }
        if (this.__hadSetupdateTime) {
            contentValues.put(ch.COL_UPDATETIME, Long.valueOf(this.field_updateTime));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
