package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.FinderFeedReportObject;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aqg;
import com.tencent.mm.protocal.protobuf.bal;
import com.tencent.mm.protocal.protobuf.cjh;
import com.tencent.mm.protocal.protobuf.cjm;
import com.tencent.mm.protocal.protobuf.cjt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.io.IOException;
import java.lang.reflect.Field;

public abstract class ch extends IAutoDBItem {
    public static final String COL_CLIPLIST = "clipList";
    public static final String COL_CREATETIME = "createTime";
    public static final String COL_CUSTOMDATA = "customData";
    public static final String COL_FINDEROBJECT = "finderObject";
    public static final String COL_HALFMEDIAEXTLIST = "halfMediaExtList";
    public static final String COL_ID = "id";
    public static final String COL_LOCALFLAG = "localFlag";
    public static final String COL_LOCALID = "localId";
    public static final String COL_LONGVIDEOMEDIAEXTLIST = "longVideoMediaExtList";
    public static final String COL_MEDIAEXTLIST = "mediaExtList";
    public static final String COL_POSTEXTRADATA = "postExtraData";
    public static final String COL_POSTINFO = "postinfo";
    public static final String COL_REPORTOBJECT = "reportObject";
    public static final String COL_SOURCEFLAG = "sourceFlag";
    public static final String COL_UPDATETIME = "updateTime";
    public static final String COL_USERNAME = "username";
    public static final String[] INDEX_CREATE = {"CREATE INDEX IF NOT EXISTS FinderFeedItem_local_index ON FinderFeedItem(localId)", "CREATE INDEX IF NOT EXISTS FinderFeedItem_Id ON FinderFeedItem(id)", "CREATE INDEX IF NOT EXISTS FinderFeedItem_create_time ON FinderFeedItem(createTime)", "CREATE INDEX IF NOT EXISTS FinderFeedItem__Local_Flag ON FinderFeedItem(localFlag)"};
    public static final String TABLE_NAME = "FinderFeedItem";
    private static final String TAG = "MicroMsg.SDK.BaseFinderFeedItem";
    private static final int clipList_HASHCODE = COL_CLIPLIST.hashCode();
    private static final int createTime_HASHCODE = "createTime".hashCode();
    private static final int customData_HASHCODE = COL_CUSTOMDATA.hashCode();
    private static final int finderObject_HASHCODE = COL_FINDEROBJECT.hashCode();
    private static final int halfMediaExtList_HASHCODE = COL_HALFMEDIAEXTLIST.hashCode();
    private static final int id_HASHCODE = "id".hashCode();
    private static final int localFlag_HASHCODE = "localFlag".hashCode();
    private static final int localId_HASHCODE = COL_LOCALID.hashCode();
    private static final int longVideoMediaExtList_HASHCODE = COL_LONGVIDEOMEDIAEXTLIST.hashCode();
    private static final int mediaExtList_HASHCODE = COL_MEDIAEXTLIST.hashCode();
    private static final int postExtraData_HASHCODE = COL_POSTEXTRADATA.hashCode();
    private static final int postinfo_HASHCODE = COL_POSTINFO.hashCode();
    private static final int reportObject_HASHCODE = COL_REPORTOBJECT.hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private static final int sourceFlag_HASHCODE = COL_SOURCEFLAG.hashCode();
    private static final int updateTime_HASHCODE = COL_UPDATETIME.hashCode();
    private static final int username_HASHCODE = COL_USERNAME.hashCode();
    private boolean __hadSetclipList = true;
    private boolean __hadSetcreateTime = true;
    private boolean __hadSetcustomData = true;
    private boolean __hadSetfinderObject = true;
    private boolean __hadSethalfMediaExtList = true;
    private boolean __hadSetid = true;
    private boolean __hadSetlocalFlag = true;
    private boolean __hadSetlocalId = true;
    private boolean __hadSetlongVideoMediaExtList = true;
    private boolean __hadSetmediaExtList = true;
    private boolean __hadSetpostExtraData = true;
    private boolean __hadSetpostinfo = true;
    private boolean __hadSetreportObject = true;
    private boolean __hadSetsourceFlag = true;
    private boolean __hadSetupdateTime = true;
    private boolean __hadSetusername = true;
    public cjh field_clipList;
    public long field_createTime;
    public aqg field_customData;
    public FinderObject field_finderObject;
    public cjt field_halfMediaExtList;
    public long field_id;
    public int field_localFlag;
    public long field_localId;
    public cjt field_longVideoMediaExtList;
    public cjt field_mediaExtList;
    public bal field_postExtraData;
    public cjm field_postinfo;
    public FinderFeedReportObject field_reportObject;
    public int field_sourceFlag;
    public long field_updateTime;
    public String field_username;

    public static IAutoDBItem.MAutoDBInfo initAutoDBInfo(Class<?> cls) {
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[16];
        mAutoDBInfo.columns = new String[17];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = COL_LOCALID;
        mAutoDBInfo.colsMap.put(COL_LOCALID, "LONG PRIMARY KEY ");
        sb.append(" localId LONG PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = COL_LOCALID;
        mAutoDBInfo.columns[1] = "id";
        mAutoDBInfo.colsMap.put("id", "LONG");
        sb.append(" id LONG");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "createTime";
        mAutoDBInfo.colsMap.put("createTime", "LONG");
        sb.append(" createTime LONG");
        sb.append(", ");
        mAutoDBInfo.columns[3] = COL_USERNAME;
        mAutoDBInfo.colsMap.put(COL_USERNAME, "TEXT");
        sb.append(" username TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[4] = COL_SOURCEFLAG;
        mAutoDBInfo.colsMap.put(COL_SOURCEFLAG, "INTEGER");
        sb.append(" sourceFlag INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[5] = COL_UPDATETIME;
        mAutoDBInfo.colsMap.put(COL_UPDATETIME, "LONG");
        sb.append(" updateTime LONG");
        sb.append(", ");
        mAutoDBInfo.columns[6] = COL_FINDEROBJECT;
        mAutoDBInfo.colsMap.put(COL_FINDEROBJECT, "BLOB");
        sb.append(" finderObject BLOB");
        sb.append(", ");
        mAutoDBInfo.columns[7] = "localFlag";
        mAutoDBInfo.colsMap.put("localFlag", "INTEGER");
        sb.append(" localFlag INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[8] = COL_POSTINFO;
        mAutoDBInfo.colsMap.put(COL_POSTINFO, "BLOB");
        sb.append(" postinfo BLOB");
        sb.append(", ");
        mAutoDBInfo.columns[9] = COL_MEDIAEXTLIST;
        mAutoDBInfo.colsMap.put(COL_MEDIAEXTLIST, "BLOB");
        sb.append(" mediaExtList BLOB");
        sb.append(", ");
        mAutoDBInfo.columns[10] = COL_REPORTOBJECT;
        mAutoDBInfo.colsMap.put(COL_REPORTOBJECT, "BLOB");
        sb.append(" reportObject BLOB");
        sb.append(", ");
        mAutoDBInfo.columns[11] = COL_POSTEXTRADATA;
        mAutoDBInfo.colsMap.put(COL_POSTEXTRADATA, "BLOB");
        sb.append(" postExtraData BLOB");
        sb.append(", ");
        mAutoDBInfo.columns[12] = COL_CUSTOMDATA;
        mAutoDBInfo.colsMap.put(COL_CUSTOMDATA, "BLOB");
        sb.append(" customData BLOB");
        sb.append(", ");
        mAutoDBInfo.columns[13] = COL_LONGVIDEOMEDIAEXTLIST;
        mAutoDBInfo.colsMap.put(COL_LONGVIDEOMEDIAEXTLIST, "BLOB");
        sb.append(" longVideoMediaExtList BLOB");
        sb.append(", ");
        mAutoDBInfo.columns[14] = COL_HALFMEDIAEXTLIST;
        mAutoDBInfo.colsMap.put(COL_HALFMEDIAEXTLIST, "BLOB");
        sb.append(" halfMediaExtList BLOB");
        sb.append(", ");
        mAutoDBInfo.columns[15] = COL_CLIPLIST;
        mAutoDBInfo.colsMap.put(COL_CLIPLIST, "BLOB");
        sb.append(" clipList BLOB");
        mAutoDBInfo.columns[16] = "rowid";
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
                    this.field_id = cursor.getLong(i2);
                } else if (createTime_HASHCODE == hashCode) {
                    this.field_createTime = cursor.getLong(i2);
                } else if (username_HASHCODE == hashCode) {
                    this.field_username = cursor.getString(i2);
                } else if (sourceFlag_HASHCODE == hashCode) {
                    this.field_sourceFlag = cursor.getInt(i2);
                } else if (updateTime_HASHCODE == hashCode) {
                    this.field_updateTime = cursor.getLong(i2);
                } else if (finderObject_HASHCODE == hashCode) {
                    try {
                        byte[] blob = cursor.getBlob(i2);
                        if (blob != null && blob.length > 0) {
                            this.field_finderObject = (FinderObject) new FinderObject().parseFrom(blob);
                        }
                    } catch (IOException e2) {
                        Log.e(TAG, e2.getMessage());
                    }
                } else if (localFlag_HASHCODE == hashCode) {
                    this.field_localFlag = cursor.getInt(i2);
                } else if (postinfo_HASHCODE == hashCode) {
                    try {
                        byte[] blob2 = cursor.getBlob(i2);
                        if (blob2 != null && blob2.length > 0) {
                            this.field_postinfo = (cjm) new cjm().parseFrom(blob2);
                        }
                    } catch (IOException e3) {
                        Log.e(TAG, e3.getMessage());
                    }
                } else if (mediaExtList_HASHCODE == hashCode) {
                    try {
                        byte[] blob3 = cursor.getBlob(i2);
                        if (blob3 != null && blob3.length > 0) {
                            this.field_mediaExtList = (cjt) new cjt().parseFrom(blob3);
                        }
                    } catch (IOException e4) {
                        Log.e(TAG, e4.getMessage());
                    }
                } else if (reportObject_HASHCODE == hashCode) {
                    try {
                        byte[] blob4 = cursor.getBlob(i2);
                        if (blob4 != null && blob4.length > 0) {
                            this.field_reportObject = (FinderFeedReportObject) new FinderFeedReportObject().parseFrom(blob4);
                        }
                    } catch (IOException e5) {
                        Log.e(TAG, e5.getMessage());
                    }
                } else if (postExtraData_HASHCODE == hashCode) {
                    try {
                        byte[] blob5 = cursor.getBlob(i2);
                        if (blob5 != null && blob5.length > 0) {
                            this.field_postExtraData = (bal) new bal().parseFrom(blob5);
                        }
                    } catch (IOException e6) {
                        Log.e(TAG, e6.getMessage());
                    }
                } else if (customData_HASHCODE == hashCode) {
                    try {
                        byte[] blob6 = cursor.getBlob(i2);
                        if (blob6 != null && blob6.length > 0) {
                            this.field_customData = (aqg) new aqg().parseFrom(blob6);
                        }
                    } catch (IOException e7) {
                        Log.e(TAG, e7.getMessage());
                    }
                } else if (longVideoMediaExtList_HASHCODE == hashCode) {
                    try {
                        byte[] blob7 = cursor.getBlob(i2);
                        if (blob7 != null && blob7.length > 0) {
                            this.field_longVideoMediaExtList = (cjt) new cjt().parseFrom(blob7);
                        }
                    } catch (IOException e8) {
                        Log.e(TAG, e8.getMessage());
                    }
                } else if (halfMediaExtList_HASHCODE == hashCode) {
                    try {
                        byte[] blob8 = cursor.getBlob(i2);
                        if (blob8 != null && blob8.length > 0) {
                            this.field_halfMediaExtList = (cjt) new cjt().parseFrom(blob8);
                        }
                    } catch (IOException e9) {
                        Log.e(TAG, e9.getMessage());
                    }
                } else if (clipList_HASHCODE == hashCode) {
                    try {
                        byte[] blob9 = cursor.getBlob(i2);
                        if (blob9 != null && blob9.length > 0) {
                            this.field_clipList = (cjh) new cjh().parseFrom(blob9);
                        }
                    } catch (IOException e10) {
                        Log.e(TAG, e10.getMessage());
                    }
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        buildBuff();
        ContentValues contentValues = new ContentValues();
        if (this.__hadSetlocalId) {
            contentValues.put(COL_LOCALID, Long.valueOf(this.field_localId));
        }
        if (this.__hadSetid) {
            contentValues.put("id", Long.valueOf(this.field_id));
        }
        if (this.__hadSetcreateTime) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.__hadSetusername) {
            contentValues.put(COL_USERNAME, this.field_username);
        }
        if (this.__hadSetsourceFlag) {
            contentValues.put(COL_SOURCEFLAG, Integer.valueOf(this.field_sourceFlag));
        }
        if (this.__hadSetupdateTime) {
            contentValues.put(COL_UPDATETIME, Long.valueOf(this.field_updateTime));
        }
        if (this.__hadSetfinderObject && this.field_finderObject != null) {
            try {
                contentValues.put(COL_FINDEROBJECT, this.field_finderObject.toByteArray());
            } catch (IOException e2) {
                Log.e(TAG, e2.getMessage());
            }
        }
        if (this.__hadSetlocalFlag) {
            contentValues.put("localFlag", Integer.valueOf(this.field_localFlag));
        }
        if (this.__hadSetpostinfo && this.field_postinfo != null) {
            try {
                contentValues.put(COL_POSTINFO, this.field_postinfo.toByteArray());
            } catch (IOException e3) {
                Log.e(TAG, e3.getMessage());
            }
        }
        if (this.__hadSetmediaExtList && this.field_mediaExtList != null) {
            try {
                contentValues.put(COL_MEDIAEXTLIST, this.field_mediaExtList.toByteArray());
            } catch (IOException e4) {
                Log.e(TAG, e4.getMessage());
            }
        }
        if (this.__hadSetreportObject && this.field_reportObject != null) {
            try {
                contentValues.put(COL_REPORTOBJECT, this.field_reportObject.toByteArray());
            } catch (IOException e5) {
                Log.e(TAG, e5.getMessage());
            }
        }
        if (this.__hadSetpostExtraData && this.field_postExtraData != null) {
            try {
                contentValues.put(COL_POSTEXTRADATA, this.field_postExtraData.toByteArray());
            } catch (IOException e6) {
                Log.e(TAG, e6.getMessage());
            }
        }
        if (this.__hadSetcustomData && this.field_customData != null) {
            try {
                contentValues.put(COL_CUSTOMDATA, this.field_customData.toByteArray());
            } catch (IOException e7) {
                Log.e(TAG, e7.getMessage());
            }
        }
        if (this.__hadSetlongVideoMediaExtList && this.field_longVideoMediaExtList != null) {
            try {
                contentValues.put(COL_LONGVIDEOMEDIAEXTLIST, this.field_longVideoMediaExtList.toByteArray());
            } catch (IOException e8) {
                Log.e(TAG, e8.getMessage());
            }
        }
        if (this.__hadSethalfMediaExtList && this.field_halfMediaExtList != null) {
            try {
                contentValues.put(COL_HALFMEDIAEXTLIST, this.field_halfMediaExtList.toByteArray());
            } catch (IOException e9) {
                Log.e(TAG, e9.getMessage());
            }
        }
        if (this.__hadSetclipList && this.field_clipList != null) {
            try {
                contentValues.put(COL_CLIPLIST, this.field_clipList.toByteArray());
            } catch (IOException e10) {
                Log.e(TAG, e10.getMessage());
            }
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }

    public void reset() {
    }

    private final void parseBuff() {
    }

    private final void buildBuff() {
    }
}
