package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.ano;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.io.IOException;
import java.lang.reflect.Field;

public abstract class by extends IAutoDBItem {
    public static final String[] INDEX_CREATE = {"CREATE INDEX IF NOT EXISTS FavItemInfo_id_Index ON FavItemInfo(id)", "CREATE INDEX IF NOT EXISTS FavItemInfo_type_Index ON FavItemInfo(type)", "CREATE INDEX IF NOT EXISTS FavItemInfo_updateSeq_Index ON FavItemInfo(updateSeq)", "CREATE INDEX IF NOT EXISTS FavItemInfo_flag_Index ON FavItemInfo(flag)", "CREATE INDEX IF NOT EXISTS FavItemInfo_sourceId_Index ON FavItemInfo(sourceId)", "CREATE INDEX IF NOT EXISTS FavItemInfo_datatotalsize_Index ON FavItemInfo(datatotalsize)"};
    private static final int fAN = "localSeq".hashCode();
    private static final int fAO = "updateSeq".hashCode();
    private static final int fAP = "sourceId".hashCode();
    private static final int fAQ = "itemStatus".hashCode();
    private static final int fAR = "sourceCreateTime".hashCode();
    private static final int fAS = "fromUser".hashCode();
    private static final int fAT = "toUser".hashCode();
    private static final int fAU = "realChatName".hashCode();
    private static final int fAV = "favProto".hashCode();
    private static final int fAW = "ext".hashCode();
    private static final int fAX = "edittime".hashCode();
    private static final int fAY = "tagProto".hashCode();
    private static final int fAZ = "sessionId".hashCode();
    private static final int fBa = "datatotalsize".hashCode();
    private static final int fnd = "xml".hashCode();
    private static final int fni = "flag".hashCode();
    private static final int id_HASHCODE = "id".hashCode();
    private static final int localId_HASHCODE = ch.COL_LOCALID.hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private static final int sourceType_HASHCODE = "sourceType".hashCode();
    private static final int type_HASHCODE = "type".hashCode();
    private static final int updateTime_HASHCODE = ch.COL_UPDATETIME.hashCode();
    private boolean __hadSetid = true;
    private boolean __hadSetlocalId = true;
    private boolean __hadSetsourceType = true;
    private boolean __hadSettype = true;
    private boolean __hadSetupdateTime = true;
    private boolean fAA = true;
    private boolean fAB = true;
    private boolean fAC = true;
    private boolean fAD = true;
    private boolean fAE = true;
    private boolean fAF = true;
    private boolean fAG = true;
    private boolean fAH = true;
    private boolean fAI = true;
    private boolean fAJ = true;
    private boolean fAK = true;
    private boolean fAL = true;
    private boolean fAM = true;
    private boolean fAz = true;
    public long field_datatotalsize;
    public long field_edittime;
    public String field_ext;
    public anb field_favProto;
    public int field_flag;
    public String field_fromUser;
    public int field_id;
    public int field_itemStatus;
    public long field_localId;
    public int field_localSeq;
    public String field_realChatName;
    public String field_sessionId;
    public long field_sourceCreateTime;
    public String field_sourceId;
    public int field_sourceType;
    public ano field_tagProto;
    public String field_toUser;
    public int field_type;
    public int field_updateSeq;
    public long field_updateTime;
    public String field_xml;
    private boolean fna = true;
    private boolean fng = true;

    public static IAutoDBItem.MAutoDBInfo ajs() {
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[21];
        mAutoDBInfo.columns = new String[22];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = ch.COL_LOCALID;
        mAutoDBInfo.colsMap.put(ch.COL_LOCALID, "LONG PRIMARY KEY ");
        sb.append(" localId LONG PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = ch.COL_LOCALID;
        mAutoDBInfo.columns[1] = "id";
        mAutoDBInfo.colsMap.put("id", "INTEGER");
        sb.append(" id INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "type";
        mAutoDBInfo.colsMap.put("type", "INTEGER");
        sb.append(" type INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "localSeq";
        mAutoDBInfo.colsMap.put("localSeq", "INTEGER");
        sb.append(" localSeq INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "updateSeq";
        mAutoDBInfo.colsMap.put("updateSeq", "INTEGER");
        sb.append(" updateSeq INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "flag";
        mAutoDBInfo.colsMap.put("flag", "INTEGER");
        sb.append(" flag INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[6] = "sourceId";
        mAutoDBInfo.colsMap.put("sourceId", "TEXT");
        sb.append(" sourceId TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[7] = "itemStatus";
        mAutoDBInfo.colsMap.put("itemStatus", "INTEGER");
        sb.append(" itemStatus INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[8] = "sourceType";
        mAutoDBInfo.colsMap.put("sourceType", "INTEGER");
        sb.append(" sourceType INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[9] = "sourceCreateTime";
        mAutoDBInfo.colsMap.put("sourceCreateTime", "LONG");
        sb.append(" sourceCreateTime LONG");
        sb.append(", ");
        mAutoDBInfo.columns[10] = ch.COL_UPDATETIME;
        mAutoDBInfo.colsMap.put(ch.COL_UPDATETIME, "LONG");
        sb.append(" updateTime LONG");
        sb.append(", ");
        mAutoDBInfo.columns[11] = "fromUser";
        mAutoDBInfo.colsMap.put("fromUser", "TEXT");
        sb.append(" fromUser TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[12] = "toUser";
        mAutoDBInfo.colsMap.put("toUser", "TEXT");
        sb.append(" toUser TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[13] = "realChatName";
        mAutoDBInfo.colsMap.put("realChatName", "TEXT");
        sb.append(" realChatName TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[14] = "favProto";
        mAutoDBInfo.colsMap.put("favProto", "BLOB");
        sb.append(" favProto BLOB");
        sb.append(", ");
        mAutoDBInfo.columns[15] = "xml";
        mAutoDBInfo.colsMap.put("xml", "TEXT");
        sb.append(" xml TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[16] = "ext";
        mAutoDBInfo.colsMap.put("ext", "TEXT");
        sb.append(" ext TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[17] = "edittime";
        mAutoDBInfo.colsMap.put("edittime", "LONG");
        sb.append(" edittime LONG");
        sb.append(", ");
        mAutoDBInfo.columns[18] = "tagProto";
        mAutoDBInfo.colsMap.put("tagProto", "BLOB");
        sb.append(" tagProto BLOB");
        sb.append(", ");
        mAutoDBInfo.columns[19] = "sessionId";
        mAutoDBInfo.colsMap.put("sessionId", "TEXT");
        sb.append(" sessionId TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[20] = "datatotalsize";
        mAutoDBInfo.colsMap.put("datatotalsize", "LONG");
        sb.append(" datatotalsize LONG");
        mAutoDBInfo.columns[21] = "rowid";
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
                if (localId_HASHCODE == hashCode) {
                    this.field_localId = cursor.getLong(i2);
                    this.__hadSetlocalId = true;
                } else if (id_HASHCODE == hashCode) {
                    this.field_id = cursor.getInt(i2);
                } else if (type_HASHCODE == hashCode) {
                    this.field_type = cursor.getInt(i2);
                } else if (fAN == hashCode) {
                    this.field_localSeq = cursor.getInt(i2);
                } else if (fAO == hashCode) {
                    this.field_updateSeq = cursor.getInt(i2);
                } else if (fni == hashCode) {
                    this.field_flag = cursor.getInt(i2);
                } else if (fAP == hashCode) {
                    this.field_sourceId = cursor.getString(i2);
                } else if (fAQ == hashCode) {
                    this.field_itemStatus = cursor.getInt(i2);
                } else if (sourceType_HASHCODE == hashCode) {
                    this.field_sourceType = cursor.getInt(i2);
                } else if (fAR == hashCode) {
                    this.field_sourceCreateTime = cursor.getLong(i2);
                } else if (updateTime_HASHCODE == hashCode) {
                    this.field_updateTime = cursor.getLong(i2);
                } else if (fAS == hashCode) {
                    this.field_fromUser = cursor.getString(i2);
                } else if (fAT == hashCode) {
                    this.field_toUser = cursor.getString(i2);
                } else if (fAU == hashCode) {
                    this.field_realChatName = cursor.getString(i2);
                } else if (fAV == hashCode) {
                    try {
                        byte[] blob = cursor.getBlob(i2);
                        if (blob != null && blob.length > 0) {
                            this.field_favProto = (anb) new anb().parseFrom(blob);
                        }
                    } catch (IOException e2) {
                        Log.e("MicroMsg.SDK.BaseFavItemInfo", e2.getMessage());
                    }
                } else if (fnd == hashCode) {
                    this.field_xml = cursor.getString(i2);
                } else if (fAW == hashCode) {
                    this.field_ext = cursor.getString(i2);
                } else if (fAX == hashCode) {
                    this.field_edittime = cursor.getLong(i2);
                } else if (fAY == hashCode) {
                    try {
                        byte[] blob2 = cursor.getBlob(i2);
                        if (blob2 != null && blob2.length > 0) {
                            this.field_tagProto = (ano) new ano().parseFrom(blob2);
                        }
                    } catch (IOException e3) {
                        Log.e("MicroMsg.SDK.BaseFavItemInfo", e3.getMessage());
                    }
                } else if (fAZ == hashCode) {
                    this.field_sessionId = cursor.getString(i2);
                } else if (fBa == hashCode) {
                    this.field_datatotalsize = cursor.getLong(i2);
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
            contentValues.put(ch.COL_LOCALID, Long.valueOf(this.field_localId));
        }
        if (this.__hadSetid) {
            contentValues.put("id", Integer.valueOf(this.field_id));
        }
        if (this.__hadSettype) {
            contentValues.put("type", Integer.valueOf(this.field_type));
        }
        if (this.fAz) {
            contentValues.put("localSeq", Integer.valueOf(this.field_localSeq));
        }
        if (this.fAA) {
            contentValues.put("updateSeq", Integer.valueOf(this.field_updateSeq));
        }
        if (this.fng) {
            contentValues.put("flag", Integer.valueOf(this.field_flag));
        }
        if (this.fAB) {
            contentValues.put("sourceId", this.field_sourceId);
        }
        if (this.fAC) {
            contentValues.put("itemStatus", Integer.valueOf(this.field_itemStatus));
        }
        if (this.__hadSetsourceType) {
            contentValues.put("sourceType", Integer.valueOf(this.field_sourceType));
        }
        if (this.fAD) {
            contentValues.put("sourceCreateTime", Long.valueOf(this.field_sourceCreateTime));
        }
        if (this.__hadSetupdateTime) {
            contentValues.put(ch.COL_UPDATETIME, Long.valueOf(this.field_updateTime));
        }
        if (this.fAE) {
            contentValues.put("fromUser", this.field_fromUser);
        }
        if (this.fAF) {
            contentValues.put("toUser", this.field_toUser);
        }
        if (this.fAG) {
            contentValues.put("realChatName", this.field_realChatName);
        }
        if (this.fAH && this.field_favProto != null) {
            try {
                contentValues.put("favProto", this.field_favProto.toByteArray());
            } catch (IOException e2) {
                Log.e("MicroMsg.SDK.BaseFavItemInfo", e2.getMessage());
            }
        }
        if (this.fna) {
            contentValues.put("xml", this.field_xml);
        }
        if (this.fAI) {
            contentValues.put("ext", this.field_ext);
        }
        if (this.fAJ) {
            contentValues.put("edittime", Long.valueOf(this.field_edittime));
        }
        if (this.fAK && this.field_tagProto != null) {
            try {
                contentValues.put("tagProto", this.field_tagProto.toByteArray());
            } catch (IOException e3) {
                Log.e("MicroMsg.SDK.BaseFavItemInfo", e3.getMessage());
            }
        }
        if (this.fAL) {
            contentValues.put("sessionId", this.field_sessionId);
        }
        if (this.fAM) {
            contentValues.put("datatotalsize", Long.valueOf(this.field_datatotalsize));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
