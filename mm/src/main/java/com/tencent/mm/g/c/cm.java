package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.aym;
import com.tencent.mm.protocal.protobuf.azp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.io.IOException;
import java.lang.reflect.Field;

public abstract class cm extends IAutoDBItem {
    private static final int content_HASHCODE = "content".hashCode();
    private static final int createTime_HASHCODE = "createTime".hashCode();
    private static final int fAt = "extFlag".hashCode();
    private static final int fDe = "objectNonceId".hashCode();
    private static final int fEe = "objectType".hashCode();
    private static final int fFA = "headUrl".hashCode();
    private static final int fFB = "objectId".hashCode();
    private static final int fFC = "commentId".hashCode();
    private static final int fFD = "refContent".hashCode();
    private static final int fFE = "mediaType".hashCode();
    private static final int fFF = "notify".hashCode();
    private static final int fFG = "replayUsername".hashCode();
    private static final int fFH = "replayNickname".hashCode();
    private static final int fFI = "userVersion".hashCode();
    private static final int fFJ = "contact".hashCode();
    private static final int fFK = "replyContact".hashCode();
    private static final int fFL = "aggregatedContacts".hashCode();
    private static final int fFM = "followExpireTime".hashCode();
    private static final int fFN = "clientMsgId".hashCode();
    private static final int fFO = "followId".hashCode();
    private static final int fFP = "refVideoObjectId".hashCode();
    private static final int fFQ = "refVideoObjectNonceId".hashCode();
    public static String fFh = "FinderIdentityMsg";
    public static String fFi = "WxIdentityMsg";
    private static final int fnf = "description".hashCode();
    private static final int fni = "flag".hashCode();
    private static final int fqf = "nickname".hashCode();
    private static final int fyv = "thumbUrl".hashCode();
    private static final int id_HASHCODE = "id".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private static final int type_HASHCODE = "type".hashCode();
    private static final int username_HASHCODE = ch.COL_USERNAME.hashCode();
    private boolean __hadSetcontent = true;
    private boolean __hadSetcreateTime = true;
    private boolean __hadSetid = true;
    private boolean __hadSettype = true;
    private boolean __hadSetusername = true;
    private boolean fAo = true;
    private boolean fCU = true;
    private boolean fEa = true;
    private boolean fFj = true;
    private boolean fFk = true;
    private boolean fFl = true;
    private boolean fFm = true;
    private boolean fFn = true;
    private boolean fFo = true;
    private boolean fFp = true;
    private boolean fFq = true;
    private boolean fFr = true;
    private boolean fFs = true;
    private boolean fFt = true;
    private boolean fFu = true;
    private boolean fFv = true;
    private boolean fFw = true;
    private boolean fFx = true;
    public boolean fFy = true;
    public boolean fFz = true;
    public aym field_aggregatedContacts;
    public String field_clientMsgId;
    public long field_commentId;
    public FinderContact field_contact;
    public String field_content;
    public int field_createTime;
    public String field_description;
    public int field_extFlag;
    public int field_flag;
    public long field_followExpireTime;
    public long field_followId;
    public String field_headUrl;
    public long field_id;
    public int field_mediaType;
    public String field_nickname;
    public azp field_notify;
    public long field_objectId;
    public String field_objectNonceId;
    public long field_objectType;
    public String field_refContent;
    public long field_refVideoObjectId;
    public String field_refVideoObjectNonceId;
    public String field_replayNickname;
    public String field_replayUsername;
    public FinderContact field_replyContact;
    public String field_thumbUrl;
    public int field_type;
    public int field_userVersion;
    public String field_username;
    private boolean fnc = true;
    private boolean fng = true;
    private boolean fqb = true;
    private boolean fxJ = true;

    public static IAutoDBItem.MAutoDBInfo ajs() {
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[29];
        mAutoDBInfo.columns = new String[30];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "headUrl";
        mAutoDBInfo.colsMap.put("headUrl", "TEXT");
        sb.append(" headUrl TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[1] = "nickname";
        mAutoDBInfo.colsMap.put("nickname", "TEXT");
        sb.append(" nickname TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "type";
        mAutoDBInfo.colsMap.put("type", "INTEGER");
        sb.append(" type INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "content";
        mAutoDBInfo.colsMap.put("content", "TEXT");
        sb.append(" content TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "createTime";
        mAutoDBInfo.colsMap.put("createTime", "INTEGER");
        sb.append(" createTime INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "thumbUrl";
        mAutoDBInfo.colsMap.put("thumbUrl", "TEXT");
        sb.append(" thumbUrl TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[6] = "id";
        mAutoDBInfo.colsMap.put("id", "LONG");
        sb.append(" id LONG");
        sb.append(", ");
        mAutoDBInfo.columns[7] = "objectId";
        mAutoDBInfo.colsMap.put("objectId", "LONG");
        sb.append(" objectId LONG");
        sb.append(", ");
        mAutoDBInfo.columns[8] = "commentId";
        mAutoDBInfo.colsMap.put("commentId", "LONG");
        sb.append(" commentId LONG");
        sb.append(", ");
        mAutoDBInfo.columns[9] = "flag";
        mAutoDBInfo.colsMap.put("flag", "INTEGER");
        sb.append(" flag INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[10] = "refContent";
        mAutoDBInfo.colsMap.put("refContent", "TEXT");
        sb.append(" refContent TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[11] = "extFlag";
        mAutoDBInfo.colsMap.put("extFlag", "INTEGER");
        sb.append(" extFlag INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[12] = "mediaType";
        mAutoDBInfo.colsMap.put("mediaType", "INTEGER");
        sb.append(" mediaType INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[13] = "description";
        mAutoDBInfo.colsMap.put("description", "TEXT");
        sb.append(" description TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[14] = "notify";
        mAutoDBInfo.colsMap.put("notify", "BLOB");
        sb.append(" notify BLOB");
        sb.append(", ");
        mAutoDBInfo.columns[15] = "replayUsername";
        mAutoDBInfo.colsMap.put("replayUsername", "TEXT");
        sb.append(" replayUsername TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[16] = "replayNickname";
        mAutoDBInfo.colsMap.put("replayNickname", "TEXT");
        sb.append(" replayNickname TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[17] = "objectNonceId";
        mAutoDBInfo.colsMap.put("objectNonceId", "TEXT");
        sb.append(" objectNonceId TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[18] = "userVersion";
        mAutoDBInfo.colsMap.put("userVersion", "INTEGER");
        sb.append(" userVersion INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[19] = ch.COL_USERNAME;
        mAutoDBInfo.colsMap.put(ch.COL_USERNAME, "TEXT");
        sb.append(" username TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[20] = "contact";
        mAutoDBInfo.colsMap.put("contact", "BLOB");
        sb.append(" contact BLOB");
        sb.append(", ");
        mAutoDBInfo.columns[21] = "replyContact";
        mAutoDBInfo.colsMap.put("replyContact", "BLOB");
        sb.append(" replyContact BLOB");
        sb.append(", ");
        mAutoDBInfo.columns[22] = "aggregatedContacts";
        mAutoDBInfo.colsMap.put("aggregatedContacts", "BLOB");
        sb.append(" aggregatedContacts BLOB");
        sb.append(", ");
        mAutoDBInfo.columns[23] = "followExpireTime";
        mAutoDBInfo.colsMap.put("followExpireTime", "LONG");
        sb.append(" followExpireTime LONG");
        sb.append(", ");
        mAutoDBInfo.columns[24] = "clientMsgId";
        mAutoDBInfo.colsMap.put("clientMsgId", "TEXT");
        sb.append(" clientMsgId TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[25] = "followId";
        mAutoDBInfo.colsMap.put("followId", "LONG");
        sb.append(" followId LONG");
        sb.append(", ");
        mAutoDBInfo.columns[26] = "objectType";
        mAutoDBInfo.colsMap.put("objectType", "LONG");
        sb.append(" objectType LONG");
        sb.append(", ");
        mAutoDBInfo.columns[27] = "refVideoObjectId";
        mAutoDBInfo.colsMap.put("refVideoObjectId", "LONG");
        sb.append(" refVideoObjectId LONG");
        sb.append(", ");
        mAutoDBInfo.columns[28] = "refVideoObjectNonceId";
        mAutoDBInfo.colsMap.put("refVideoObjectNonceId", "TEXT");
        sb.append(" refVideoObjectNonceId TEXT");
        mAutoDBInfo.columns[29] = "rowid";
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
                if (fFA == hashCode) {
                    this.field_headUrl = cursor.getString(i2);
                } else if (fqf == hashCode) {
                    this.field_nickname = cursor.getString(i2);
                } else if (type_HASHCODE == hashCode) {
                    this.field_type = cursor.getInt(i2);
                } else if (content_HASHCODE == hashCode) {
                    this.field_content = cursor.getString(i2);
                } else if (createTime_HASHCODE == hashCode) {
                    this.field_createTime = cursor.getInt(i2);
                } else if (fyv == hashCode) {
                    this.field_thumbUrl = cursor.getString(i2);
                } else if (id_HASHCODE == hashCode) {
                    this.field_id = cursor.getLong(i2);
                } else if (fFB == hashCode) {
                    this.field_objectId = cursor.getLong(i2);
                } else if (fFC == hashCode) {
                    this.field_commentId = cursor.getLong(i2);
                } else if (fni == hashCode) {
                    this.field_flag = cursor.getInt(i2);
                } else if (fFD == hashCode) {
                    this.field_refContent = cursor.getString(i2);
                } else if (fAt == hashCode) {
                    this.field_extFlag = cursor.getInt(i2);
                } else if (fFE == hashCode) {
                    this.field_mediaType = cursor.getInt(i2);
                } else if (fnf == hashCode) {
                    this.field_description = cursor.getString(i2);
                } else if (fFF == hashCode) {
                    try {
                        byte[] blob = cursor.getBlob(i2);
                        if (blob != null && blob.length > 0) {
                            this.field_notify = (azp) new azp().parseFrom(blob);
                        }
                    } catch (IOException e2) {
                        Log.e("MicroMsg.SDK.BaseFinderFinderMention", e2.getMessage());
                    }
                } else if (fFG == hashCode) {
                    this.field_replayUsername = cursor.getString(i2);
                } else if (fFH == hashCode) {
                    this.field_replayNickname = cursor.getString(i2);
                } else if (fDe == hashCode) {
                    this.field_objectNonceId = cursor.getString(i2);
                } else if (fFI == hashCode) {
                    this.field_userVersion = cursor.getInt(i2);
                } else if (username_HASHCODE == hashCode) {
                    this.field_username = cursor.getString(i2);
                } else if (fFJ == hashCode) {
                    try {
                        byte[] blob2 = cursor.getBlob(i2);
                        if (blob2 != null && blob2.length > 0) {
                            this.field_contact = (FinderContact) new FinderContact().parseFrom(blob2);
                        }
                    } catch (IOException e3) {
                        Log.e("MicroMsg.SDK.BaseFinderFinderMention", e3.getMessage());
                    }
                } else if (fFK == hashCode) {
                    try {
                        byte[] blob3 = cursor.getBlob(i2);
                        if (blob3 != null && blob3.length > 0) {
                            this.field_replyContact = (FinderContact) new FinderContact().parseFrom(blob3);
                        }
                    } catch (IOException e4) {
                        Log.e("MicroMsg.SDK.BaseFinderFinderMention", e4.getMessage());
                    }
                } else if (fFL == hashCode) {
                    try {
                        byte[] blob4 = cursor.getBlob(i2);
                        if (blob4 != null && blob4.length > 0) {
                            this.field_aggregatedContacts = (aym) new aym().parseFrom(blob4);
                        }
                    } catch (IOException e5) {
                        Log.e("MicroMsg.SDK.BaseFinderFinderMention", e5.getMessage());
                    }
                } else if (fFM == hashCode) {
                    this.field_followExpireTime = cursor.getLong(i2);
                } else if (fFN == hashCode) {
                    this.field_clientMsgId = cursor.getString(i2);
                } else if (fFO == hashCode) {
                    this.field_followId = cursor.getLong(i2);
                } else if (fEe == hashCode) {
                    this.field_objectType = cursor.getLong(i2);
                } else if (fFP == hashCode) {
                    this.field_refVideoObjectId = cursor.getLong(i2);
                } else if (fFQ == hashCode) {
                    this.field_refVideoObjectNonceId = cursor.getString(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.fFj) {
            contentValues.put("headUrl", this.field_headUrl);
        }
        if (this.fqb) {
            contentValues.put("nickname", this.field_nickname);
        }
        if (this.__hadSettype) {
            contentValues.put("type", Integer.valueOf(this.field_type));
        }
        if (this.__hadSetcontent) {
            contentValues.put("content", this.field_content);
        }
        if (this.__hadSetcreateTime) {
            contentValues.put("createTime", Integer.valueOf(this.field_createTime));
        }
        if (this.fxJ) {
            contentValues.put("thumbUrl", this.field_thumbUrl);
        }
        if (this.__hadSetid) {
            contentValues.put("id", Long.valueOf(this.field_id));
        }
        if (this.fFk) {
            contentValues.put("objectId", Long.valueOf(this.field_objectId));
        }
        if (this.fFl) {
            contentValues.put("commentId", Long.valueOf(this.field_commentId));
        }
        if (this.fng) {
            contentValues.put("flag", Integer.valueOf(this.field_flag));
        }
        if (this.fFm) {
            contentValues.put("refContent", this.field_refContent);
        }
        if (this.fAo) {
            contentValues.put("extFlag", Integer.valueOf(this.field_extFlag));
        }
        if (this.fFn) {
            contentValues.put("mediaType", Integer.valueOf(this.field_mediaType));
        }
        if (this.fnc) {
            contentValues.put("description", this.field_description);
        }
        if (this.fFo && this.field_notify != null) {
            try {
                contentValues.put("notify", this.field_notify.toByteArray());
            } catch (IOException e2) {
                Log.e("MicroMsg.SDK.BaseFinderFinderMention", e2.getMessage());
            }
        }
        if (this.fFp) {
            contentValues.put("replayUsername", this.field_replayUsername);
        }
        if (this.fFq) {
            contentValues.put("replayNickname", this.field_replayNickname);
        }
        if (this.fCU) {
            contentValues.put("objectNonceId", this.field_objectNonceId);
        }
        if (this.fFr) {
            contentValues.put("userVersion", Integer.valueOf(this.field_userVersion));
        }
        if (this.__hadSetusername) {
            contentValues.put(ch.COL_USERNAME, this.field_username);
        }
        if (this.fFs && this.field_contact != null) {
            try {
                contentValues.put("contact", this.field_contact.toByteArray());
            } catch (IOException e3) {
                Log.e("MicroMsg.SDK.BaseFinderFinderMention", e3.getMessage());
            }
        }
        if (this.fFt && this.field_replyContact != null) {
            try {
                contentValues.put("replyContact", this.field_replyContact.toByteArray());
            } catch (IOException e4) {
                Log.e("MicroMsg.SDK.BaseFinderFinderMention", e4.getMessage());
            }
        }
        if (this.fFu && this.field_aggregatedContacts != null) {
            try {
                contentValues.put("aggregatedContacts", this.field_aggregatedContacts.toByteArray());
            } catch (IOException e5) {
                Log.e("MicroMsg.SDK.BaseFinderFinderMention", e5.getMessage());
            }
        }
        if (this.fFv) {
            contentValues.put("followExpireTime", Long.valueOf(this.field_followExpireTime));
        }
        if (this.fFw) {
            contentValues.put("clientMsgId", this.field_clientMsgId);
        }
        if (this.fFx) {
            contentValues.put("followId", Long.valueOf(this.field_followId));
        }
        if (this.fEa) {
            contentValues.put("objectType", Long.valueOf(this.field_objectType));
        }
        if (this.fFy) {
            contentValues.put("refVideoObjectId", Long.valueOf(this.field_refVideoObjectId));
        }
        if (this.fFz) {
            contentValues.put("refVideoObjectNonceId", this.field_refVideoObjectNonceId);
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
