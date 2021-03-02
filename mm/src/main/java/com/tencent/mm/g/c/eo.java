package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.cjv;
import com.tencent.mm.sdk.platformtools.LVBuffer;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.io.IOException;

public abstract class eo extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int content_HASHCODE = "content".hashCode();
    private static final int createTime_HASHCODE = "createTime".hashCode();
    private static final int fQP = "solitaireFoldInfo".hashCode();
    private static final int fQQ = "historyId".hashCode();
    private static final int fjf = "msgId".hashCode();
    private static final int fjl = "status".hashCode();
    private static final int fnT = "bizChatId".hashCode();
    private static final int fni = "flag".hashCode();
    private static final int foe = "isSend".hashCode();
    private static final int fqG = "bizClientMsgId".hashCode();
    private static final int fqV = "isShowTimer".hashCode();
    private static final int fqW = "reserved".hashCode();
    private static final int fqX = "transContent".hashCode();
    private static final int fqY = "transBrandWording".hashCode();
    private static final int fqZ = "bizChatUserId".hashCode();
    private static final int fqv = "msgSvrId".hashCode();
    private static final int fqw = "talker".hashCode();
    private static final int fqx = "imgPath".hashCode();
    private static final int fqy = "lvbuffer".hashCode();
    private static final int fqz = "talkerId".hashCode();
    private static final int fra = "msgSeq".hashCode();
    private static final int frb = "fromUsername".hashCode();
    private static final int frc = "toUsername".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private static final int type_HASHCODE = "type".hashCode();
    private boolean __hadSetcontent = false;
    private boolean __hadSetcreateTime = false;
    private boolean __hadSettype = false;
    public String ean;
    public boolean fQN = false;
    private boolean fQO = false;
    public String fQR;
    public int fQS;
    public int fQT;
    protected int fQU;
    public int fQV;
    public int fQW;
    public int fQX;
    public String fQY;
    public String fQZ;
    public String fRa;
    public int fRb;
    public byte[] fRc;
    public String fRd;
    public String fRe;
    public int fRf;
    public int fRg;
    public long field_bizChatId;
    public String field_bizChatUserId;
    public String field_bizClientMsgId;
    public String field_content;
    public long field_createTime;
    public int field_flag;
    private String field_fromUsername;
    public String field_historyId;
    public String field_imgPath;
    public int field_isSend;
    public int field_isShowTimer;
    public byte[] field_lvbuffer;
    public long field_msgId;
    public long field_msgSeq;
    public long field_msgSvrId;
    public String field_reserved;
    public cjv field_solitaireFoldInfo;
    public int field_status;
    public String field_talker;
    public int field_talkerId;
    private String field_toUsername;
    public String field_transBrandWording;
    public String field_transContent;
    private int field_type;
    private boolean fjb = false;
    private boolean fji = false;
    private boolean fnE = false;
    private boolean fnP = false;
    private boolean fng = false;
    public int fqJ;
    public String fqK;
    public boolean fqN = false;
    private boolean fqO = false;
    private boolean fqP = false;
    public boolean fqQ = false;
    public boolean fqR = false;
    private boolean fqS = false;
    private boolean fqT = false;
    private boolean fqU = false;
    private boolean fqh = false;
    private boolean fqi = false;
    private boolean fqj = false;
    public boolean fqk = false;
    public boolean fql = false;
    private boolean fqs = false;

    public final void setMsgId(long j2) {
        this.field_msgId = j2;
        this.fjb = true;
    }

    public final long ajL() {
        return this.field_msgId;
    }

    public final void yF(long j2) {
        this.field_msgSvrId = j2;
        this.fqh = true;
    }

    public final long ajM() {
        return this.field_msgSvrId;
    }

    public final void setType(int i2) {
        this.field_type = i2;
        this.__hadSettype = true;
    }

    public int getType() {
        return this.field_type;
    }

    public void setStatus(int i2) {
        this.field_status = i2;
        this.fji = true;
    }

    public final int getStatus() {
        return this.field_status;
    }

    public final void nv(int i2) {
        this.field_isSend = i2;
        this.fnP = true;
    }

    public final int ajN() {
        return this.field_isSend;
    }

    public final void setCreateTime(long j2) {
        this.field_createTime = j2;
        this.__hadSetcreateTime = true;
    }

    public final long getCreateTime() {
        return this.field_createTime;
    }

    public final void Cy(String str) {
        this.field_talker = str;
        this.fqi = true;
    }

    public final String ajO() {
        return this.field_talker;
    }

    public final void setContent(String str) {
        this.field_content = str;
        this.__hadSetcontent = true;
    }

    public final String getContent() {
        return this.field_content;
    }

    public final void Cz(String str) {
        this.field_imgPath = str;
        this.fqj = true;
    }

    public final String ajP() {
        return this.field_imgPath;
    }

    public final void CA(String str) {
        this.field_reserved = str;
        this.fqO = true;
    }

    public final String ajQ() {
        return this.field_reserved;
    }

    public final void aa(byte[] bArr) {
        this.field_lvbuffer = bArr;
        this.fqk = true;
    }

    public final void CB(String str) {
        this.field_transContent = str;
        this.fqP = true;
    }

    public final void CC(String str) {
        this.field_bizClientMsgId = str;
        this.fqs = true;
    }

    public final String ajR() {
        return this.field_bizClientMsgId;
    }

    public final void yG(long j2) {
        this.field_bizChatId = j2;
        this.fnE = true;
    }

    public final void yH(long j2) {
        this.field_msgSeq = j2;
        this.fqS = true;
    }

    public final void setFlag(int i2) {
        this.field_flag = i2;
        this.fng = true;
    }

    public final void CD(String str) {
        this.field_fromUsername = str;
        this.fqT = true;
    }

    public final void CE(String str) {
        this.field_toUsername = str;
        this.fqU = true;
    }

    public final void CF(String str) {
        this.field_historyId = str;
        this.fQO = true;
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fjf == hashCode) {
                    this.field_msgId = cursor.getLong(i2);
                    this.fjb = true;
                } else if (fqv == hashCode) {
                    this.field_msgSvrId = cursor.getLong(i2);
                } else if (type_HASHCODE == hashCode) {
                    this.field_type = cursor.getInt(i2);
                } else if (fjl == hashCode) {
                    this.field_status = cursor.getInt(i2);
                } else if (foe == hashCode) {
                    this.field_isSend = cursor.getInt(i2);
                } else if (fqV == hashCode) {
                    this.field_isShowTimer = cursor.getInt(i2);
                } else if (createTime_HASHCODE == hashCode) {
                    this.field_createTime = cursor.getLong(i2);
                } else if (fqw == hashCode) {
                    this.field_talker = cursor.getString(i2);
                } else if (content_HASHCODE == hashCode) {
                    this.field_content = cursor.getString(i2);
                } else if (fqx == hashCode) {
                    this.field_imgPath = cursor.getString(i2);
                } else if (fqW == hashCode) {
                    this.field_reserved = cursor.getString(i2);
                } else if (fqy == hashCode) {
                    this.field_lvbuffer = cursor.getBlob(i2);
                } else if (fqz == hashCode) {
                    this.field_talkerId = cursor.getInt(i2);
                } else if (fqX == hashCode) {
                    this.field_transContent = cursor.getString(i2);
                } else if (fqY == hashCode) {
                    this.field_transBrandWording = cursor.getString(i2);
                } else if (fqG == hashCode) {
                    this.field_bizClientMsgId = cursor.getString(i2);
                } else if (fnT == hashCode) {
                    this.field_bizChatId = cursor.getLong(i2);
                } else if (fqZ == hashCode) {
                    this.field_bizChatUserId = cursor.getString(i2);
                } else if (fra == hashCode) {
                    this.field_msgSeq = cursor.getLong(i2);
                } else if (fni == hashCode) {
                    this.field_flag = cursor.getInt(i2);
                } else if (fQP == hashCode) {
                    try {
                        byte[] blob = cursor.getBlob(i2);
                        if (blob != null && blob.length > 0) {
                            this.field_solitaireFoldInfo = (cjv) new cjv().parseFrom(blob);
                        }
                    } catch (IOException e2) {
                        Log.e("MicroMsg.SDK.BaseMsgInfo", e2.getMessage());
                    }
                } else if (frb == hashCode) {
                    this.field_fromUsername = cursor.getString(i2);
                } else if (frc == hashCode) {
                    this.field_toUsername = cursor.getString(i2);
                } else if (fQQ == hashCode) {
                    this.field_historyId = cursor.getString(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
            try {
                if (!(this.field_lvbuffer == null || this.field_lvbuffer.length == 0)) {
                    LVBuffer lVBuffer = new LVBuffer();
                    int initParse = lVBuffer.initParse(this.field_lvbuffer);
                    if (initParse != 0) {
                        Log.e("MicroMsg.SDK.BaseMsgInfo", "parse LVBuffer error:".concat(String.valueOf(initParse)));
                        return;
                    }
                    if (!lVBuffer.checkGetFinish()) {
                        this.fQR = lVBuffer.getString();
                    }
                    if (!lVBuffer.checkGetFinish()) {
                        this.fqJ = lVBuffer.getInt();
                    }
                    if (!lVBuffer.checkGetFinish()) {
                        this.fqK = lVBuffer.getString();
                    }
                    if (!lVBuffer.checkGetFinish()) {
                        this.fQS = lVBuffer.getInt();
                    }
                    if (!lVBuffer.checkGetFinish()) {
                        this.fQT = lVBuffer.getInt();
                    }
                    if (!lVBuffer.checkGetFinish()) {
                        this.fQU = lVBuffer.getInt();
                    }
                    if (!lVBuffer.checkGetFinish()) {
                        this.fQV = lVBuffer.getInt();
                    }
                    if (!lVBuffer.checkGetFinish()) {
                        this.fQW = lVBuffer.getInt();
                    }
                    if (!lVBuffer.checkGetFinish()) {
                        this.fQX = lVBuffer.getInt();
                    }
                    if (!lVBuffer.checkGetFinish()) {
                        this.fQY = lVBuffer.getString();
                    }
                    if (!lVBuffer.checkGetFinish()) {
                        this.fQZ = lVBuffer.getString();
                    }
                    if (!lVBuffer.checkGetFinish()) {
                        this.fRa = lVBuffer.getString();
                    }
                    if (!lVBuffer.checkGetFinish()) {
                        this.fRb = lVBuffer.getInt();
                    }
                    if (!lVBuffer.checkGetFinish()) {
                        this.ean = lVBuffer.getString();
                    }
                    if (!lVBuffer.checkGetFinish()) {
                        this.fRc = lVBuffer.getBuffer();
                    }
                    if (!lVBuffer.checkGetFinish()) {
                        this.fRd = lVBuffer.getString();
                    }
                    if (!lVBuffer.checkGetFinish()) {
                        this.fRe = lVBuffer.getString();
                    }
                    if (!lVBuffer.checkGetFinish()) {
                        this.fRf = lVBuffer.getInt();
                    }
                    if (!lVBuffer.checkGetFinish()) {
                        this.fRg = lVBuffer.getInt();
                    }
                }
            } catch (Exception e3) {
                Log.e("MicroMsg.SDK.BaseMsgInfo", "get value failed");
            }
        }
    }

    public final void CG(String str) {
        this.fQR = str;
        this.fqk = true;
    }

    public final void nc(int i2) {
        this.fqJ = i2;
        this.fqk = true;
    }

    public final String ajw() {
        return this.fqK;
    }

    public final void BB(String str) {
        this.fqK = str;
        this.fqk = true;
    }

    public final void nG(int i2) {
        this.fQS = i2;
        this.fqk = true;
    }

    public final void nH(int i2) {
        this.fQT = i2;
        this.fqk = true;
    }

    public final void nI(int i2) {
        this.fQU = i2;
        this.fqk = true;
    }

    public final int ajS() {
        return this.fQV;
    }

    public final void nJ(int i2) {
        this.fQW = i2;
        this.fqk = true;
    }

    public final void nK(int i2) {
        this.fQX = i2;
        this.fqk = true;
    }

    public final String ajT() {
        return this.fQZ;
    }

    public final void CH(String str) {
        this.fQZ = str;
        this.fqk = true;
    }

    public final void CI(String str) {
        this.fRa = str;
        this.fqk = true;
    }

    public final void nL(int i2) {
        this.fRb = i2;
        this.fqk = true;
    }

    public final void CJ(String str) {
        this.fRd = str;
        this.fqk = true;
    }

    public final String ajU() {
        return this.fRe;
    }

    public final void CK(String str) {
        this.fRe = str;
        this.fqk = true;
    }

    public final int ajV() {
        return this.fRf;
    }

    public final void nM(int i2) {
        this.fRf = i2;
        this.fqk = true;
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        try {
            if (this.fqk) {
                LVBuffer lVBuffer = new LVBuffer();
                lVBuffer.initBuild();
                lVBuffer.putString(this.fQR);
                lVBuffer.putInt(this.fqJ);
                lVBuffer.putString(this.fqK);
                lVBuffer.putInt(this.fQS);
                lVBuffer.putInt(this.fQT);
                lVBuffer.putInt(this.fQU);
                lVBuffer.putInt(this.fQV);
                lVBuffer.putInt(this.fQW);
                lVBuffer.putInt(this.fQX);
                lVBuffer.putString(this.fQY);
                lVBuffer.putString(this.fQZ);
                lVBuffer.putString(this.fRa);
                lVBuffer.putInt(this.fRb);
                lVBuffer.putString(this.ean);
                lVBuffer.putBuffer(this.fRc);
                lVBuffer.putString(this.fRd);
                lVBuffer.putString(this.fRe);
                lVBuffer.putInt(this.fRf);
                lVBuffer.putInt(this.fRg);
                this.field_lvbuffer = lVBuffer.buildFinish();
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.SDK.BaseMsgInfo", "get value failed, %s", e2.getMessage());
        }
        ContentValues contentValues = new ContentValues();
        if (this.fjb) {
            contentValues.put("msgId", Long.valueOf(this.field_msgId));
        }
        if (this.fqh) {
            contentValues.put("msgSvrId", Long.valueOf(this.field_msgSvrId));
        }
        if (this.__hadSettype) {
            contentValues.put("type", Integer.valueOf(this.field_type));
        }
        if (this.fji) {
            contentValues.put("status", Integer.valueOf(this.field_status));
        }
        if (this.fnP) {
            contentValues.put("isSend", Integer.valueOf(this.field_isSend));
        }
        if (this.fqN) {
            contentValues.put("isShowTimer", Integer.valueOf(this.field_isShowTimer));
        }
        if (this.__hadSetcreateTime) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.fqi) {
            contentValues.put("talker", this.field_talker);
        }
        if (this.field_content == null) {
            this.field_content = "";
        }
        if (this.__hadSetcontent) {
            contentValues.put("content", this.field_content);
        }
        if (this.fqj) {
            contentValues.put("imgPath", this.field_imgPath);
        }
        if (this.fqO) {
            contentValues.put("reserved", this.field_reserved);
        }
        if (this.fqk) {
            contentValues.put("lvbuffer", this.field_lvbuffer);
        }
        if (this.fql) {
            contentValues.put("talkerId", Integer.valueOf(this.field_talkerId));
        }
        if (this.field_transContent == null) {
            this.field_transContent = "";
        }
        if (this.fqP) {
            contentValues.put("transContent", this.field_transContent);
        }
        if (this.field_transBrandWording == null) {
            this.field_transBrandWording = "";
        }
        if (this.fqQ) {
            contentValues.put("transBrandWording", this.field_transBrandWording);
        }
        if (this.field_bizClientMsgId == null) {
            this.field_bizClientMsgId = "";
        }
        if (this.fqs) {
            contentValues.put("bizClientMsgId", this.field_bizClientMsgId);
        }
        if (this.fnE) {
            contentValues.put("bizChatId", Long.valueOf(this.field_bizChatId));
        }
        if (this.field_bizChatUserId == null) {
            this.field_bizChatUserId = "";
        }
        if (this.fqR) {
            contentValues.put("bizChatUserId", this.field_bizChatUserId);
        }
        if (this.fqS) {
            contentValues.put("msgSeq", Long.valueOf(this.field_msgSeq));
        }
        if (this.fng) {
            contentValues.put("flag", Integer.valueOf(this.field_flag));
        }
        if (this.fQN && this.field_solitaireFoldInfo != null) {
            try {
                contentValues.put("solitaireFoldInfo", this.field_solitaireFoldInfo.toByteArray());
            } catch (IOException e3) {
                Log.e("MicroMsg.SDK.BaseMsgInfo", e3.getMessage());
            }
        }
        if (this.fqT) {
            contentValues.put("fromUsername", this.field_fromUsername);
        }
        if (this.fqU) {
            contentValues.put("toUsername", this.field_toUsername);
        }
        if (this.fQO) {
            contentValues.put("historyId", this.field_historyId);
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
