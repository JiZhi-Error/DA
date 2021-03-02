package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.facebook.internal.AnalyticsEvents;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class au extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int foH = "roomflag".hashCode();
    private static final int fsZ = "chatroomname".hashCode();
    private static final int fta = "addtime".hashCode();
    private static final int ftb = "memberlist".hashCode();
    private static final int ftc = "displayname".hashCode();
    private static final int ftd = "chatroomnick".hashCode();
    private static final int fte = "roomowner".hashCode();
    private static final int ftf = "roomdata".hashCode();
    private static final int ftg = "isShowname".hashCode();
    private static final int fth = "selfDisplayName".hashCode();
    private static final int fti = AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE.hashCode();
    private static final int ftj = "chatroomdataflag".hashCode();
    private static final int ftk = "modifytime".hashCode();
    private static final int ftl = "chatroomnotice".hashCode();
    private static final int ftm = "chatroomVersion".hashCode();
    private static final int ftn = "chatroomnoticeEditor".hashCode();
    private static final int fto = "chatroomnoticePublishTime".hashCode();
    private static final int ftp = "chatroomLocalVersion".hashCode();
    private static final int ftq = "chatroomStatus".hashCode();
    private static final int ftr = "memberCount".hashCode();
    private static final int fts = "chatroomfamilystatusmodifytime".hashCode();
    private static final int ftt = "associateOpenIMRoomName".hashCode();
    private static final int ftu = "openIMRoomMigrateStatus".hashCode();
    private static final int ftv = "saveByteVersion".hashCode();
    private static final int ftw = "handleByteVersion".hashCode();
    private static final int ftx = "roomInfoDetailResByte".hashCode();
    private static final int fty = "oldChatroomVersion".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    public long field_addtime;
    public String field_associateOpenIMRoomName;
    public long field_chatroomLocalVersion;
    public int field_chatroomStatus;
    public int field_chatroomVersion;
    public int field_chatroomdataflag;
    public long field_chatroomfamilystatusmodifytime;
    public String field_chatroomname;
    public String field_chatroomnick;
    public String field_chatroomnotice;
    public String field_chatroomnoticeEditor;
    public long field_chatroomnoticePublishTime;
    public String field_displayname;
    public String field_handleByteVersion;
    public int field_isShowname;
    public int field_memberCount;
    public String field_memberlist;
    public long field_modifytime;
    public int field_oldChatroomVersion;
    public int field_openIMRoomMigrateStatus;
    public byte[] field_roomInfoDetailResByte;
    public byte[] field_roomdata;
    public int field_roomflag;
    public String field_roomowner;
    public String field_saveByteVersion;
    public String field_selfDisplayName;
    public int field_style;
    private boolean fou = true;
    private boolean fsA = true;
    private boolean fsB = true;
    private boolean fsC = true;
    private boolean fsD = true;
    private boolean fsE = true;
    private boolean fsF = true;
    private boolean fsG = true;
    private boolean fsH = true;
    private boolean fsI = true;
    private boolean fsJ = true;
    private boolean fsK = true;
    private boolean fsL = true;
    private boolean fsM = true;
    private boolean fsN = true;
    private boolean fsO = true;
    private boolean fsP = true;
    private boolean fsQ = true;
    private boolean fsR = true;
    private boolean fsS = true;
    private boolean fsT = true;
    private boolean fsU = true;
    private boolean fsV = true;
    private boolean fsW = true;
    private boolean fsX = true;
    private boolean fsY = true;
    private boolean fsz = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fsZ == hashCode) {
                    this.field_chatroomname = cursor.getString(i2);
                    this.fsz = true;
                } else if (fta == hashCode) {
                    this.field_addtime = cursor.getLong(i2);
                } else if (ftb == hashCode) {
                    this.field_memberlist = cursor.getString(i2);
                } else if (ftc == hashCode) {
                    this.field_displayname = cursor.getString(i2);
                } else if (ftd == hashCode) {
                    this.field_chatroomnick = cursor.getString(i2);
                } else if (foH == hashCode) {
                    this.field_roomflag = cursor.getInt(i2);
                } else if (fte == hashCode) {
                    this.field_roomowner = cursor.getString(i2);
                } else if (ftf == hashCode) {
                    this.field_roomdata = cursor.getBlob(i2);
                } else if (ftg == hashCode) {
                    this.field_isShowname = cursor.getInt(i2);
                } else if (fth == hashCode) {
                    this.field_selfDisplayName = cursor.getString(i2);
                } else if (fti == hashCode) {
                    this.field_style = cursor.getInt(i2);
                } else if (ftj == hashCode) {
                    this.field_chatroomdataflag = cursor.getInt(i2);
                } else if (ftk == hashCode) {
                    this.field_modifytime = cursor.getLong(i2);
                } else if (ftl == hashCode) {
                    this.field_chatroomnotice = cursor.getString(i2);
                } else if (ftm == hashCode) {
                    this.field_chatroomVersion = cursor.getInt(i2);
                } else if (ftn == hashCode) {
                    this.field_chatroomnoticeEditor = cursor.getString(i2);
                } else if (fto == hashCode) {
                    this.field_chatroomnoticePublishTime = cursor.getLong(i2);
                } else if (ftp == hashCode) {
                    this.field_chatroomLocalVersion = cursor.getLong(i2);
                } else if (ftq == hashCode) {
                    this.field_chatroomStatus = cursor.getInt(i2);
                } else if (ftr == hashCode) {
                    this.field_memberCount = cursor.getInt(i2);
                } else if (fts == hashCode) {
                    this.field_chatroomfamilystatusmodifytime = cursor.getLong(i2);
                } else if (ftt == hashCode) {
                    this.field_associateOpenIMRoomName = cursor.getString(i2);
                } else if (ftu == hashCode) {
                    this.field_openIMRoomMigrateStatus = cursor.getInt(i2);
                } else if (ftv == hashCode) {
                    this.field_saveByteVersion = cursor.getString(i2);
                } else if (ftw == hashCode) {
                    this.field_handleByteVersion = cursor.getString(i2);
                } else if (ftx == hashCode) {
                    this.field_roomInfoDetailResByte = cursor.getBlob(i2);
                } else if (fty == hashCode) {
                    this.field_oldChatroomVersion = cursor.getInt(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.field_chatroomname == null) {
            this.field_chatroomname = "";
        }
        if (this.fsz) {
            contentValues.put("chatroomname", this.field_chatroomname);
        }
        if (this.fsA) {
            contentValues.put("addtime", Long.valueOf(this.field_addtime));
        }
        if (this.fsB) {
            contentValues.put("memberlist", this.field_memberlist);
        }
        if (this.fsC) {
            contentValues.put("displayname", this.field_displayname);
        }
        if (this.fsD) {
            contentValues.put("chatroomnick", this.field_chatroomnick);
        }
        if (this.fou) {
            contentValues.put("roomflag", Integer.valueOf(this.field_roomflag));
        }
        if (this.fsE) {
            contentValues.put("roomowner", this.field_roomowner);
        }
        if (this.fsF) {
            contentValues.put("roomdata", this.field_roomdata);
        }
        if (this.fsG) {
            contentValues.put("isShowname", Integer.valueOf(this.field_isShowname));
        }
        if (this.fsH) {
            contentValues.put("selfDisplayName", this.field_selfDisplayName);
        }
        if (this.fsI) {
            contentValues.put(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, Integer.valueOf(this.field_style));
        }
        if (this.fsJ) {
            contentValues.put("chatroomdataflag", Integer.valueOf(this.field_chatroomdataflag));
        }
        if (this.fsK) {
            contentValues.put("modifytime", Long.valueOf(this.field_modifytime));
        }
        if (this.fsL) {
            contentValues.put("chatroomnotice", this.field_chatroomnotice);
        }
        if (this.fsM) {
            contentValues.put("chatroomVersion", Integer.valueOf(this.field_chatroomVersion));
        }
        if (this.fsN) {
            contentValues.put("chatroomnoticeEditor", this.field_chatroomnoticeEditor);
        }
        if (this.fsO) {
            contentValues.put("chatroomnoticePublishTime", Long.valueOf(this.field_chatroomnoticePublishTime));
        }
        if (this.fsP) {
            contentValues.put("chatroomLocalVersion", Long.valueOf(this.field_chatroomLocalVersion));
        }
        if (this.fsQ) {
            contentValues.put("chatroomStatus", Integer.valueOf(this.field_chatroomStatus));
        }
        if (this.fsR) {
            contentValues.put("memberCount", Integer.valueOf(this.field_memberCount));
        }
        if (this.fsS) {
            contentValues.put("chatroomfamilystatusmodifytime", Long.valueOf(this.field_chatroomfamilystatusmodifytime));
        }
        if (this.fsT) {
            contentValues.put("associateOpenIMRoomName", this.field_associateOpenIMRoomName);
        }
        if (this.fsU) {
            contentValues.put("openIMRoomMigrateStatus", Integer.valueOf(this.field_openIMRoomMigrateStatus));
        }
        if (this.fsV) {
            contentValues.put("saveByteVersion", this.field_saveByteVersion);
        }
        if (this.fsW) {
            contentValues.put("handleByteVersion", this.field_handleByteVersion);
        }
        if (this.fsX) {
            contentValues.put("roomInfoDetailResByte", this.field_roomInfoDetailResByte);
        }
        if (this.fsY) {
            contentValues.put("oldChatroomVersion", Integer.valueOf(this.field_oldChatroomVersion));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
