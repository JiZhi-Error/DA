package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.app;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import java.io.IOException;
import java.lang.reflect.Field;

public abstract class ce extends IAutoDBItem {
    public static final String[] INDEX_CREATE = {"CREATE INDEX IF NOT EXISTS FinderContact_username_index ON FinderContact(username)"};
    private static final int fAt = "extFlag".hashCode();
    private static final int fDB = "avatarUrl".hashCode();
    private static final int fDC = "firstPageMD5".hashCode();
    private static final int fDD = "follow_Flag".hashCode();
    private static final int fDE = "followTime".hashCode();
    private static final int fDF = "coverImg".hashCode();
    private static final int fDG = "spamStatus".hashCode();
    private static final int fDH = "authInfo".hashCode();
    private static final int fDI = "originalFlag".hashCode();
    private static final int fDJ = "originalInfo".hashCode();
    private static final int fDK = "retryCount".hashCode();
    private static final int fDL = "originalEntranceFlag".hashCode();
    private static final int fDM = "liveCoverImg".hashCode();
    private static final int fDN = "liveStatus".hashCode();
    private static final int fDO = "liveAnchorStatusFlag".hashCode();
    private static final int fDP = "friendFollowCount".hashCode();
    private static final int fDQ = "liveSwitchFlag".hashCode();
    private static final int fkx = "signature".hashCode();
    private static final int flv = "version".hashCode();
    private static final int fpP = IssueStorage.COLUMN_EXT_INFO.hashCode();
    private static final int fqf = "nickname".hashCode();
    private static final int fuk = "pyInitial".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private static final int updateTime_HASHCODE = ch.COL_UPDATETIME.hashCode();
    private static final int username_HASHCODE = ch.COL_USERNAME.hashCode();
    private static final int uuG = "liveAlias".hashCode();
    private static final int uuH = "rewardTotalAmountInWecoin".hashCode();
    private static final int uuI = "personalMsgUpdateTime".hashCode();
    private static final int uxD = "v5username".hashCode();
    private boolean __hadSetupdateTime = true;
    private boolean __hadSetusername = true;
    private boolean fAo = true;
    private boolean fDA = true;
    private boolean fDl = true;
    private boolean fDm = true;
    private boolean fDn = true;
    private boolean fDo = true;
    private boolean fDp = true;
    private boolean fDq = true;
    private boolean fDr = true;
    private boolean fDs = true;
    private boolean fDt = true;
    private boolean fDu = true;
    private boolean fDv = true;
    private boolean fDw = true;
    private boolean fDx = true;
    private boolean fDy = true;
    private boolean fDz = true;
    public FinderAuthInfo field_authInfo;
    public String field_avatarUrl;
    public String field_coverImg;
    public int field_extFlag;
    public app field_extInfo;
    public String field_firstPageMD5;
    public int field_followTime;
    public int field_follow_Flag;
    public int field_friendFollowCount;
    public String field_liveAlias;
    public long field_liveAnchorStatusFlag;
    public String field_liveCoverImg;
    public int field_liveStatus;
    public long field_liveSwitchFlag;
    public String field_nickname;
    public int field_originalEntranceFlag;
    public int field_originalFlag;
    public bac field_originalInfo;
    public long field_personalMsgUpdateTime;
    public String field_pyInitial;
    public int field_retryCount;
    public long field_rewardTotalAmountInWecoin;
    public String field_signature;
    public int field_spamStatus;
    public long field_updateTime;
    public String field_username;
    public String field_v5username;
    public long field_version;
    private boolean fkg = true;
    private boolean flq = true;
    private boolean fpB = true;
    private boolean fqb = true;
    private boolean ftS = true;
    private boolean uuD = true;
    private boolean uuE = true;
    private boolean uuF = true;
    private boolean uug = true;

    public static IAutoDBItem.MAutoDBInfo ajs() {
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[28];
        mAutoDBInfo.columns = new String[29];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = ch.COL_USERNAME;
        mAutoDBInfo.colsMap.put(ch.COL_USERNAME, "TEXT default ''  PRIMARY KEY ");
        sb.append(" username TEXT default ''  PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = ch.COL_USERNAME;
        mAutoDBInfo.columns[1] = "nickname";
        mAutoDBInfo.colsMap.put("nickname", "TEXT default '' ");
        sb.append(" nickname TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "avatarUrl";
        mAutoDBInfo.colsMap.put("avatarUrl", "TEXT default '' ");
        sb.append(" avatarUrl TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "version";
        mAutoDBInfo.colsMap.put("version", "LONG");
        sb.append(" version LONG");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "firstPageMD5";
        mAutoDBInfo.colsMap.put("firstPageMD5", "TEXT default '' ");
        sb.append(" firstPageMD5 TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "signature";
        mAutoDBInfo.colsMap.put("signature", "TEXT default '' ");
        sb.append(" signature TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[6] = "follow_Flag";
        mAutoDBInfo.colsMap.put("follow_Flag", "INTEGER default '0' ");
        sb.append(" follow_Flag INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[7] = "pyInitial";
        mAutoDBInfo.colsMap.put("pyInitial", "TEXT default '' ");
        sb.append(" pyInitial TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[8] = "followTime";
        mAutoDBInfo.colsMap.put("followTime", "INTEGER default '0' ");
        sb.append(" followTime INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[9] = "coverImg";
        mAutoDBInfo.colsMap.put("coverImg", "TEXT default '' ");
        sb.append(" coverImg TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[10] = "spamStatus";
        mAutoDBInfo.colsMap.put("spamStatus", "INTEGER");
        sb.append(" spamStatus INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[11] = "authInfo";
        mAutoDBInfo.colsMap.put("authInfo", "BLOB");
        sb.append(" authInfo BLOB");
        sb.append(", ");
        mAutoDBInfo.columns[12] = IssueStorage.COLUMN_EXT_INFO;
        mAutoDBInfo.colsMap.put(IssueStorage.COLUMN_EXT_INFO, "BLOB");
        sb.append(" extInfo BLOB");
        sb.append(", ");
        mAutoDBInfo.columns[13] = "originalFlag";
        mAutoDBInfo.colsMap.put("originalFlag", "INTEGER default '0' ");
        sb.append(" originalFlag INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[14] = "originalInfo";
        mAutoDBInfo.colsMap.put("originalInfo", "BLOB");
        sb.append(" originalInfo BLOB");
        sb.append(", ");
        mAutoDBInfo.columns[15] = "extFlag";
        mAutoDBInfo.colsMap.put("extFlag", "INTEGER");
        sb.append(" extFlag INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[16] = ch.COL_UPDATETIME;
        mAutoDBInfo.colsMap.put(ch.COL_UPDATETIME, "LONG");
        sb.append(" updateTime LONG");
        sb.append(", ");
        mAutoDBInfo.columns[17] = "retryCount";
        mAutoDBInfo.colsMap.put("retryCount", "INTEGER");
        sb.append(" retryCount INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[18] = "originalEntranceFlag";
        mAutoDBInfo.colsMap.put("originalEntranceFlag", "INTEGER default '0' ");
        sb.append(" originalEntranceFlag INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[19] = "liveCoverImg";
        mAutoDBInfo.colsMap.put("liveCoverImg", "TEXT default '' ");
        sb.append(" liveCoverImg TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[20] = "liveStatus";
        mAutoDBInfo.colsMap.put("liveStatus", "INTEGER default '0' ");
        sb.append(" liveStatus INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[21] = "liveAnchorStatusFlag";
        mAutoDBInfo.colsMap.put("liveAnchorStatusFlag", "LONG default '0' ");
        sb.append(" liveAnchorStatusFlag LONG default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[22] = "friendFollowCount";
        mAutoDBInfo.colsMap.put("friendFollowCount", "INTEGER default '0' ");
        sb.append(" friendFollowCount INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[23] = "liveSwitchFlag";
        mAutoDBInfo.colsMap.put("liveSwitchFlag", "LONG default '0' ");
        sb.append(" liveSwitchFlag LONG default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[24] = "liveAlias";
        mAutoDBInfo.colsMap.put("liveAlias", "TEXT default '' ");
        sb.append(" liveAlias TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[25] = "rewardTotalAmountInWecoin";
        mAutoDBInfo.colsMap.put("rewardTotalAmountInWecoin", "LONG default '0' ");
        sb.append(" rewardTotalAmountInWecoin LONG default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[26] = "personalMsgUpdateTime";
        mAutoDBInfo.colsMap.put("personalMsgUpdateTime", "LONG");
        sb.append(" personalMsgUpdateTime LONG");
        sb.append(", ");
        mAutoDBInfo.columns[27] = "v5username";
        mAutoDBInfo.colsMap.put("v5username", "TEXT default '' ");
        sb.append(" v5username TEXT default '' ");
        mAutoDBInfo.columns[28] = "rowid";
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
                } else if (fqf == hashCode) {
                    this.field_nickname = cursor.getString(i2);
                } else if (fDB == hashCode) {
                    this.field_avatarUrl = cursor.getString(i2);
                } else if (flv == hashCode) {
                    this.field_version = cursor.getLong(i2);
                } else if (fDC == hashCode) {
                    this.field_firstPageMD5 = cursor.getString(i2);
                } else if (fkx == hashCode) {
                    this.field_signature = cursor.getString(i2);
                } else if (fDD == hashCode) {
                    this.field_follow_Flag = cursor.getInt(i2);
                } else if (fuk == hashCode) {
                    this.field_pyInitial = cursor.getString(i2);
                } else if (fDE == hashCode) {
                    this.field_followTime = cursor.getInt(i2);
                } else if (fDF == hashCode) {
                    this.field_coverImg = cursor.getString(i2);
                } else if (fDG == hashCode) {
                    this.field_spamStatus = cursor.getInt(i2);
                } else if (fDH == hashCode) {
                    try {
                        byte[] blob = cursor.getBlob(i2);
                        if (blob != null && blob.length > 0) {
                            this.field_authInfo = (FinderAuthInfo) new FinderAuthInfo().parseFrom(blob);
                        }
                    } catch (IOException e2) {
                        Log.e("MicroMsg.SDK.BaseFinderContact", e2.getMessage());
                    }
                } else if (fpP == hashCode) {
                    try {
                        byte[] blob2 = cursor.getBlob(i2);
                        if (blob2 != null && blob2.length > 0) {
                            this.field_extInfo = (app) new app().parseFrom(blob2);
                        }
                    } catch (IOException e3) {
                        Log.e("MicroMsg.SDK.BaseFinderContact", e3.getMessage());
                    }
                } else if (fDI == hashCode) {
                    this.field_originalFlag = cursor.getInt(i2);
                } else if (fDJ == hashCode) {
                    try {
                        byte[] blob3 = cursor.getBlob(i2);
                        if (blob3 != null && blob3.length > 0) {
                            this.field_originalInfo = (bac) new bac().parseFrom(blob3);
                        }
                    } catch (IOException e4) {
                        Log.e("MicroMsg.SDK.BaseFinderContact", e4.getMessage());
                    }
                } else if (fAt == hashCode) {
                    this.field_extFlag = cursor.getInt(i2);
                } else if (updateTime_HASHCODE == hashCode) {
                    this.field_updateTime = cursor.getLong(i2);
                } else if (fDK == hashCode) {
                    this.field_retryCount = cursor.getInt(i2);
                } else if (fDL == hashCode) {
                    this.field_originalEntranceFlag = cursor.getInt(i2);
                } else if (fDM == hashCode) {
                    this.field_liveCoverImg = cursor.getString(i2);
                } else if (fDN == hashCode) {
                    this.field_liveStatus = cursor.getInt(i2);
                } else if (fDO == hashCode) {
                    this.field_liveAnchorStatusFlag = cursor.getLong(i2);
                } else if (fDP == hashCode) {
                    this.field_friendFollowCount = cursor.getInt(i2);
                } else if (fDQ == hashCode) {
                    this.field_liveSwitchFlag = cursor.getLong(i2);
                } else if (uuG == hashCode) {
                    this.field_liveAlias = cursor.getString(i2);
                } else if (uuH == hashCode) {
                    this.field_rewardTotalAmountInWecoin = cursor.getLong(i2);
                } else if (uuI == hashCode) {
                    this.field_personalMsgUpdateTime = cursor.getLong(i2);
                } else if (uxD == hashCode) {
                    this.field_v5username = cursor.getString(i2);
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
        if (this.field_nickname == null) {
            this.field_nickname = "";
        }
        if (this.fqb) {
            contentValues.put("nickname", this.field_nickname);
        }
        if (this.field_avatarUrl == null) {
            this.field_avatarUrl = "";
        }
        if (this.fDl) {
            contentValues.put("avatarUrl", this.field_avatarUrl);
        }
        if (this.flq) {
            contentValues.put("version", Long.valueOf(this.field_version));
        }
        if (this.field_firstPageMD5 == null) {
            this.field_firstPageMD5 = "";
        }
        if (this.fDm) {
            contentValues.put("firstPageMD5", this.field_firstPageMD5);
        }
        if (this.field_signature == null) {
            this.field_signature = "";
        }
        if (this.fkg) {
            contentValues.put("signature", this.field_signature);
        }
        if (this.fDn) {
            contentValues.put("follow_Flag", Integer.valueOf(this.field_follow_Flag));
        }
        if (this.field_pyInitial == null) {
            this.field_pyInitial = "";
        }
        if (this.ftS) {
            contentValues.put("pyInitial", this.field_pyInitial);
        }
        if (this.fDo) {
            contentValues.put("followTime", Integer.valueOf(this.field_followTime));
        }
        if (this.field_coverImg == null) {
            this.field_coverImg = "";
        }
        if (this.fDp) {
            contentValues.put("coverImg", this.field_coverImg);
        }
        if (this.fDq) {
            contentValues.put("spamStatus", Integer.valueOf(this.field_spamStatus));
        }
        if (this.fDr && this.field_authInfo != null) {
            try {
                contentValues.put("authInfo", this.field_authInfo.toByteArray());
            } catch (IOException e2) {
                Log.e("MicroMsg.SDK.BaseFinderContact", e2.getMessage());
            }
        }
        if (this.fpB && this.field_extInfo != null) {
            try {
                contentValues.put(IssueStorage.COLUMN_EXT_INFO, this.field_extInfo.toByteArray());
            } catch (IOException e3) {
                Log.e("MicroMsg.SDK.BaseFinderContact", e3.getMessage());
            }
        }
        if (this.fDs) {
            contentValues.put("originalFlag", Integer.valueOf(this.field_originalFlag));
        }
        if (this.fDt && this.field_originalInfo != null) {
            try {
                contentValues.put("originalInfo", this.field_originalInfo.toByteArray());
            } catch (IOException e4) {
                Log.e("MicroMsg.SDK.BaseFinderContact", e4.getMessage());
            }
        }
        if (this.fAo) {
            contentValues.put("extFlag", Integer.valueOf(this.field_extFlag));
        }
        if (this.__hadSetupdateTime) {
            contentValues.put(ch.COL_UPDATETIME, Long.valueOf(this.field_updateTime));
        }
        if (this.fDu) {
            contentValues.put("retryCount", Integer.valueOf(this.field_retryCount));
        }
        if (this.fDv) {
            contentValues.put("originalEntranceFlag", Integer.valueOf(this.field_originalEntranceFlag));
        }
        if (this.field_liveCoverImg == null) {
            this.field_liveCoverImg = "";
        }
        if (this.fDw) {
            contentValues.put("liveCoverImg", this.field_liveCoverImg);
        }
        if (this.fDx) {
            contentValues.put("liveStatus", Integer.valueOf(this.field_liveStatus));
        }
        if (this.fDy) {
            contentValues.put("liveAnchorStatusFlag", Long.valueOf(this.field_liveAnchorStatusFlag));
        }
        if (this.fDz) {
            contentValues.put("friendFollowCount", Integer.valueOf(this.field_friendFollowCount));
        }
        if (this.fDA) {
            contentValues.put("liveSwitchFlag", Long.valueOf(this.field_liveSwitchFlag));
        }
        if (this.field_liveAlias == null) {
            this.field_liveAlias = "";
        }
        if (this.uug) {
            contentValues.put("liveAlias", this.field_liveAlias);
        }
        if (this.uuD) {
            contentValues.put("rewardTotalAmountInWecoin", Long.valueOf(this.field_rewardTotalAmountInWecoin));
        }
        if (this.uuE) {
            contentValues.put("personalMsgUpdateTime", Long.valueOf(this.field_personalMsgUpdateTime));
        }
        if (this.field_v5username == null) {
            this.field_v5username = "";
        }
        if (this.uuF) {
            contentValues.put("v5username", this.field_v5username);
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
