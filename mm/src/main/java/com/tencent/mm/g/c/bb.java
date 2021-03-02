package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class bb extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int content_HASHCODE = "content".hashCode();
    private static final int fjl = "status".hashCode();
    private static final int fnV = "unReadCount".hashCode();
    private static final int fnZ = "digest".hashCode();
    private static final int fni = "flag".hashCode();
    private static final int foa = "digestUser".hashCode();
    private static final int fob = "atCount".hashCode();
    private static final int foc = "editingMsg".hashCode();
    private static final int foe = "isSend".hashCode();
    private static final int fof = "msgType".hashCode();
    private static final int fog = "msgCount".hashCode();
    private static final int fvL = "chatmode".hashCode();
    private static final int fvM = "conversationTime".hashCode();
    private static final int fvN = "customNotify".hashCode();
    private static final int fvO = "showTips".hashCode();
    private static final int fvP = "hasTrunc".hashCode();
    private static final int fvQ = "parentRef".hashCode();
    private static final int fvR = "attrflag".hashCode();
    private static final int fvS = "sightTime".hashCode();
    private static final int fvT = "unReadMuteCount".hashCode();
    private static final int fvU = "lastSeq".hashCode();
    private static final int fvV = "UnDeliverCount".hashCode();
    private static final int fvW = "UnReadInvite".hashCode();
    private static final int fvX = "firstUnDeliverSeq".hashCode();
    private static final int fvY = "editingQuoteMsgId".hashCode();
    private static final int fvZ = "hasTodo".hashCode();
    private static final int fwa = "hbMarkRed".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private static final int username_HASHCODE = ch.COL_USERNAME.hashCode();
    private boolean __hadSetcontent = false;
    private boolean __hadSetusername = false;
    public int field_UnDeliverCount;
    public int field_UnReadInvite;
    public int field_atCount;
    public int field_attrflag;
    public int field_chatmode;
    public String field_content;
    public long field_conversationTime;
    private String field_customNotify;
    public String field_digest;
    public String field_digestUser;
    public String field_editingMsg;
    public long field_editingQuoteMsgId;
    public long field_firstUnDeliverSeq;
    public long field_flag;
    public int field_hasTodo;
    private int field_hasTrunc;
    public int field_hbMarkRed;
    public int field_isSend;
    public long field_lastSeq;
    public int field_msgCount;
    public String field_msgType;
    public String field_parentRef;
    public int field_showTips;
    public long field_sightTime;
    public int field_status;
    public int field_unReadCount;
    public int field_unReadMuteCount;
    public String field_username;
    private boolean fji = false;
    private boolean fnG = false;
    private boolean fnK = false;
    private boolean fnL = false;
    private boolean fnM = false;
    private boolean fnN = false;
    private boolean fnP = false;
    private boolean fnQ = false;
    private boolean fnR = false;
    private boolean fng = false;
    private boolean fvA = false;
    private boolean fvB = false;
    public boolean fvC = false;
    private boolean fvD = false;
    private boolean fvE = false;
    private boolean fvF = false;
    private boolean fvG = false;
    private boolean fvH = false;
    public boolean fvI = false;
    private boolean fvJ = false;
    private boolean fvK = false;
    private boolean fvv = false;
    private boolean fvw = false;
    private boolean fvx = false;
    public boolean fvy = false;
    private boolean fvz = false;

    public final void ns(int i2) {
        this.field_msgCount = i2;
        this.fnR = true;
    }

    public final void setUsername(String str) {
        this.field_username = str;
        this.__hadSetusername = true;
    }

    public final String getUsername() {
        return this.field_username;
    }

    public final void nt(int i2) {
        this.field_unReadCount = i2;
        this.fnG = true;
    }

    public final int ajG() {
        return this.field_unReadCount;
    }

    public final void nu(int i2) {
        this.field_chatmode = i2;
        this.fvv = true;
    }

    public final void setStatus(int i2) {
        this.field_status = i2;
        this.fji = true;
    }

    public final void nv(int i2) {
        this.field_isSend = i2;
        this.fnP = true;
    }

    public final void yA(long j2) {
        this.field_conversationTime = j2;
        this.fvw = true;
    }

    public final void setContent(String str) {
        this.field_content = str;
        this.__hadSetcontent = true;
    }

    public final void Cl(String str) {
        this.field_msgType = str;
        this.fnQ = true;
    }

    public void yB(long j2) {
        this.field_flag = j2;
        this.fng = true;
    }

    public final void Cm(String str) {
        this.field_digest = str;
        this.fnK = true;
    }

    public final String getDigest() {
        return this.field_digest;
    }

    public final void Cn(String str) {
        this.field_digestUser = str;
        this.fnL = true;
    }

    public final void nw(int i2) {
        this.field_hasTrunc = i2;
        this.fvz = true;
    }

    public final void Co(String str) {
        this.field_parentRef = str;
        this.fvA = true;
    }

    public final void nx(int i2) {
        this.field_attrflag = i2;
        this.fvB = true;
    }

    public final void Cp(String str) {
        this.field_editingMsg = str;
        this.fnN = true;
    }

    public final void ny(int i2) {
        this.field_atCount = i2;
        this.fnM = true;
    }

    public final void nz(int i2) {
        this.field_unReadMuteCount = i2;
        this.fvD = true;
    }

    public final int ajH() {
        return this.field_unReadMuteCount;
    }

    public final void yC(long j2) {
        this.field_lastSeq = j2;
        this.fvE = true;
    }

    public final long ajI() {
        return this.field_lastSeq;
    }

    public final void nA(int i2) {
        this.field_UnDeliverCount = i2;
        this.fvF = true;
    }

    public final int ajJ() {
        return this.field_UnDeliverCount;
    }

    public final void nB(int i2) {
        this.field_UnReadInvite = i2;
        this.fvG = true;
    }

    public final void yD(long j2) {
        this.field_firstUnDeliverSeq = j2;
        this.fvH = true;
    }

    public final long ajK() {
        return this.field_firstUnDeliverSeq;
    }

    public final void nC(int i2) {
        this.field_hasTodo = i2;
        this.fvJ = true;
    }

    public final void nD(int i2) {
        this.field_hbMarkRed = i2;
        this.fvK = true;
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fog == hashCode) {
                    this.field_msgCount = cursor.getInt(i2);
                } else if (username_HASHCODE == hashCode) {
                    this.field_username = cursor.getString(i2);
                    this.__hadSetusername = true;
                } else if (fnV == hashCode) {
                    this.field_unReadCount = cursor.getInt(i2);
                } else if (fvL == hashCode) {
                    this.field_chatmode = cursor.getInt(i2);
                } else if (fjl == hashCode) {
                    this.field_status = cursor.getInt(i2);
                } else if (foe == hashCode) {
                    this.field_isSend = cursor.getInt(i2);
                } else if (fvM == hashCode) {
                    this.field_conversationTime = cursor.getLong(i2);
                } else if (content_HASHCODE == hashCode) {
                    this.field_content = cursor.getString(i2);
                } else if (fof == hashCode) {
                    this.field_msgType = cursor.getString(i2);
                } else if (fvN == hashCode) {
                    this.field_customNotify = cursor.getString(i2);
                } else if (fvO == hashCode) {
                    this.field_showTips = cursor.getInt(i2);
                } else if (fni == hashCode) {
                    this.field_flag = cursor.getLong(i2);
                } else if (fnZ == hashCode) {
                    this.field_digest = cursor.getString(i2);
                } else if (foa == hashCode) {
                    this.field_digestUser = cursor.getString(i2);
                } else if (fvP == hashCode) {
                    this.field_hasTrunc = cursor.getInt(i2);
                } else if (fvQ == hashCode) {
                    this.field_parentRef = cursor.getString(i2);
                } else if (fvR == hashCode) {
                    this.field_attrflag = cursor.getInt(i2);
                } else if (foc == hashCode) {
                    this.field_editingMsg = cursor.getString(i2);
                } else if (fob == hashCode) {
                    this.field_atCount = cursor.getInt(i2);
                } else if (fvS == hashCode) {
                    this.field_sightTime = cursor.getLong(i2);
                } else if (fvT == hashCode) {
                    this.field_unReadMuteCount = cursor.getInt(i2);
                } else if (fvU == hashCode) {
                    this.field_lastSeq = cursor.getLong(i2);
                } else if (fvV == hashCode) {
                    this.field_UnDeliverCount = cursor.getInt(i2);
                } else if (fvW == hashCode) {
                    this.field_UnReadInvite = cursor.getInt(i2);
                } else if (fvX == hashCode) {
                    this.field_firstUnDeliverSeq = cursor.getLong(i2);
                } else if (fvY == hashCode) {
                    this.field_editingQuoteMsgId = cursor.getLong(i2);
                } else if (fvZ == hashCode) {
                    this.field_hasTodo = cursor.getInt(i2);
                } else if (fwa == hashCode) {
                    this.field_hbMarkRed = cursor.getInt(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.fnR) {
            contentValues.put("msgCount", Integer.valueOf(this.field_msgCount));
        }
        if (this.field_username == null) {
            this.field_username = "";
        }
        if (this.__hadSetusername) {
            contentValues.put(ch.COL_USERNAME, this.field_username);
        }
        if (this.fnG) {
            contentValues.put("unReadCount", Integer.valueOf(this.field_unReadCount));
        }
        if (this.fvv) {
            contentValues.put("chatmode", Integer.valueOf(this.field_chatmode));
        }
        if (this.fji) {
            contentValues.put("status", Integer.valueOf(this.field_status));
        }
        if (this.fnP) {
            contentValues.put("isSend", Integer.valueOf(this.field_isSend));
        }
        if (this.fvw) {
            contentValues.put("conversationTime", Long.valueOf(this.field_conversationTime));
        }
        if (this.field_content == null) {
            this.field_content = "";
        }
        if (this.__hadSetcontent) {
            contentValues.put("content", this.field_content);
        }
        if (this.field_msgType == null) {
            this.field_msgType = "";
        }
        if (this.fnQ) {
            contentValues.put("msgType", this.field_msgType);
        }
        if (this.field_customNotify == null) {
            this.field_customNotify = "";
        }
        if (this.fvx) {
            contentValues.put("customNotify", this.field_customNotify);
        }
        if (this.fvy) {
            contentValues.put("showTips", Integer.valueOf(this.field_showTips));
        }
        if (this.fng) {
            contentValues.put("flag", Long.valueOf(this.field_flag));
        }
        if (this.field_digest == null) {
            this.field_digest = "";
        }
        if (this.fnK) {
            contentValues.put("digest", this.field_digest);
        }
        if (this.field_digestUser == null) {
            this.field_digestUser = "";
        }
        if (this.fnL) {
            contentValues.put("digestUser", this.field_digestUser);
        }
        if (this.fvz) {
            contentValues.put("hasTrunc", Integer.valueOf(this.field_hasTrunc));
        }
        if (this.fvA) {
            contentValues.put("parentRef", this.field_parentRef);
        }
        if (this.fvB) {
            contentValues.put("attrflag", Integer.valueOf(this.field_attrflag));
        }
        if (this.field_editingMsg == null) {
            this.field_editingMsg = "";
        }
        if (this.fnN) {
            contentValues.put("editingMsg", this.field_editingMsg);
        }
        if (this.fnM) {
            contentValues.put("atCount", Integer.valueOf(this.field_atCount));
        }
        if (this.fvC) {
            contentValues.put("sightTime", Long.valueOf(this.field_sightTime));
        }
        if (this.fvD) {
            contentValues.put("unReadMuteCount", Integer.valueOf(this.field_unReadMuteCount));
        }
        if (this.fvE) {
            contentValues.put("lastSeq", Long.valueOf(this.field_lastSeq));
        }
        if (this.fvF) {
            contentValues.put("UnDeliverCount", Integer.valueOf(this.field_UnDeliverCount));
        }
        if (this.fvG) {
            contentValues.put("UnReadInvite", Integer.valueOf(this.field_UnReadInvite));
        }
        if (this.fvH) {
            contentValues.put("firstUnDeliverSeq", Long.valueOf(this.field_firstUnDeliverSeq));
        }
        if (this.fvI) {
            contentValues.put("editingQuoteMsgId", Long.valueOf(this.field_editingQuoteMsgId));
        }
        if (this.fvJ) {
            contentValues.put("hasTodo", Integer.valueOf(this.field_hasTodo));
        }
        if (this.fvK) {
            contentValues.put("hbMarkRed", Integer.valueOf(this.field_hbMarkRed));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
