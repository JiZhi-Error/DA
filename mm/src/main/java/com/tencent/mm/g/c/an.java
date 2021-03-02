package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.gf;
import com.tencent.mm.sdk.platformtools.LVBuffer;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.io.IOException;

public abstract class an extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int content_HASHCODE = "content".hashCode();
    private static final int createTime_HASHCODE = "createTime".hashCode();
    private static final int fjf = "msgId".hashCode();
    private static final int fjl = "status".hashCode();
    private static final int foC = "bitFlag".hashCode();
    private static final int fqA = "isExpand".hashCode();
    private static final int fqB = "orderFlag".hashCode();
    private static final int fqC = "hasShow".hashCode();
    private static final int fqD = "placeTop".hashCode();
    private static final int fqE = "appMsgStatInfoProto".hashCode();
    private static final int fqF = "isRead".hashCode();
    private static final int fqG = "bizClientMsgId".hashCode();
    private static final int fqH = "rankSessionId".hashCode();
    private static final int fqI = "recommendCardId".hashCode();
    private static final int fqv = "msgSvrId".hashCode();
    private static final int fqw = "talker".hashCode();
    private static final int fqx = "imgPath".hashCode();
    private static final int fqy = "lvbuffer".hashCode();
    private static final int fqz = "talkerId".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private static final int type_HASHCODE = "type".hashCode();
    private boolean __hadSetcontent = true;
    private boolean __hadSetcreateTime = true;
    private boolean __hadSettype = true;
    public gf field_appMsgStatInfoProto;
    public int field_bitFlag;
    public String field_bizClientMsgId;
    public String field_content;
    public long field_createTime;
    public int field_hasShow;
    public String field_imgPath;
    public boolean field_isExpand;
    public int field_isRead;
    public byte[] field_lvbuffer;
    public long field_msgId;
    public long field_msgSvrId;
    public long field_orderFlag;
    public int field_placeTop;
    public String field_rankSessionId;
    public String field_recommendCardId;
    public int field_status;
    public String field_talker;
    public int field_talkerId;
    public int field_type;
    private boolean fjb = true;
    private boolean fji = true;
    private boolean fop = true;
    private int fqJ;
    public String fqK;
    protected byte[] fqL;
    public long fqM;
    private boolean fqh = true;
    private boolean fqi = true;
    private boolean fqj = true;
    protected boolean fqk = true;
    private boolean fql = true;
    private boolean fqm = true;
    private boolean fqn = true;
    private boolean fqo = true;
    private boolean fqp = true;
    private boolean fqq = true;
    private boolean fqr = true;
    private boolean fqs = true;
    private boolean fqt = true;
    private boolean fqu = true;

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
                } else if (createTime_HASHCODE == hashCode) {
                    this.field_createTime = cursor.getLong(i2);
                } else if (fqw == hashCode) {
                    this.field_talker = cursor.getString(i2);
                } else if (content_HASHCODE == hashCode) {
                    this.field_content = cursor.getString(i2);
                } else if (fqx == hashCode) {
                    this.field_imgPath = cursor.getString(i2);
                } else if (fqy == hashCode) {
                    this.field_lvbuffer = cursor.getBlob(i2);
                } else if (fqz == hashCode) {
                    this.field_talkerId = cursor.getInt(i2);
                } else if (fqA == hashCode) {
                    this.field_isExpand = cursor.getInt(i2) != 0;
                } else if (fqB == hashCode) {
                    this.field_orderFlag = cursor.getLong(i2);
                } else if (fqC == hashCode) {
                    this.field_hasShow = cursor.getInt(i2);
                } else if (fqD == hashCode) {
                    this.field_placeTop = cursor.getInt(i2);
                } else if (fqE == hashCode) {
                    try {
                        byte[] blob = cursor.getBlob(i2);
                        if (blob != null && blob.length > 0) {
                            this.field_appMsgStatInfoProto = (gf) new gf().parseFrom(blob);
                        }
                    } catch (IOException e2) {
                        Log.e("MicroMsg.SDK.BaseBizTimeLineInfo", e2.getMessage());
                    }
                } else if (fqF == hashCode) {
                    this.field_isRead = cursor.getInt(i2);
                } else if (foC == hashCode) {
                    this.field_bitFlag = cursor.getInt(i2);
                } else if (fqG == hashCode) {
                    this.field_bizClientMsgId = cursor.getString(i2);
                } else if (fqH == hashCode) {
                    this.field_rankSessionId = cursor.getString(i2);
                } else if (fqI == hashCode) {
                    this.field_recommendCardId = cursor.getString(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
            try {
                if (!(this.field_lvbuffer == null || this.field_lvbuffer.length == 0)) {
                    LVBuffer lVBuffer = new LVBuffer();
                    int initParse = lVBuffer.initParse(this.field_lvbuffer);
                    if (initParse != 0) {
                        Log.e("MicroMsg.SDK.BaseBizTimeLineInfo", "parse LVBuffer error:".concat(String.valueOf(initParse)));
                        return;
                    }
                    if (!lVBuffer.checkGetFinish()) {
                        this.fqJ = lVBuffer.getInt();
                    }
                    if (!lVBuffer.checkGetFinish()) {
                        this.fqK = lVBuffer.getString();
                    }
                    if (!lVBuffer.checkGetFinish()) {
                        this.fqL = lVBuffer.getBuffer();
                    }
                    if (!lVBuffer.checkGetFinish()) {
                        this.fqM = lVBuffer.getLong();
                    }
                }
            } catch (Exception e3) {
                Log.e("MicroMsg.SDK.BaseBizTimeLineInfo", "get value failed");
            }
        }
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

    public final void yw(long j2) {
        this.fqM = j2;
        this.fqk = true;
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        try {
            if (this.fqk) {
                LVBuffer lVBuffer = new LVBuffer();
                lVBuffer.initBuild();
                lVBuffer.putInt(this.fqJ);
                lVBuffer.putString(this.fqK);
                lVBuffer.putBuffer(this.fqL);
                lVBuffer.putLong(this.fqM);
                this.field_lvbuffer = lVBuffer.buildFinish();
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.SDK.BaseBizTimeLineInfo", "get value failed, %s", e2.getMessage());
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
        if (this.fqk) {
            contentValues.put("lvbuffer", this.field_lvbuffer);
        }
        if (this.fql) {
            contentValues.put("talkerId", Integer.valueOf(this.field_talkerId));
        }
        if (this.fqm) {
            contentValues.put("isExpand", Boolean.valueOf(this.field_isExpand));
        }
        if (this.fqn) {
            contentValues.put("orderFlag", Long.valueOf(this.field_orderFlag));
        }
        if (this.fqo) {
            contentValues.put("hasShow", Integer.valueOf(this.field_hasShow));
        }
        if (this.fqp) {
            contentValues.put("placeTop", Integer.valueOf(this.field_placeTop));
        }
        if (this.fqq && this.field_appMsgStatInfoProto != null) {
            try {
                contentValues.put("appMsgStatInfoProto", this.field_appMsgStatInfoProto.toByteArray());
            } catch (IOException e3) {
                Log.e("MicroMsg.SDK.BaseBizTimeLineInfo", e3.getMessage());
            }
        }
        if (this.fqr) {
            contentValues.put("isRead", Integer.valueOf(this.field_isRead));
        }
        if (this.fop) {
            contentValues.put("bitFlag", Integer.valueOf(this.field_bitFlag));
        }
        if (this.field_bizClientMsgId == null) {
            this.field_bizClientMsgId = "";
        }
        if (this.fqs) {
            contentValues.put("bizClientMsgId", this.field_bizClientMsgId);
        }
        if (this.field_rankSessionId == null) {
            this.field_rankSessionId = "";
        }
        if (this.fqt) {
            contentValues.put("rankSessionId", this.field_rankSessionId);
        }
        if (this.field_recommendCardId == null) {
            this.field_recommendCardId = "";
        }
        if (this.fqu) {
            contentValues.put("recommendCardId", this.field_recommendCardId);
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
