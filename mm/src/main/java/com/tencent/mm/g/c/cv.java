package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.protocal.protobuf.rx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.io.IOException;

public abstract class cv extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fDK = "retryCount".hashCode();
    private static final int fDd = "actionTime".hashCode();
    private static final int fHA = "functionmsgid".hashCode();
    private static final int fHB = "preVersion".hashCode();
    private static final int fHC = "retryinterval".hashCode();
    private static final int fHD = "reportid".hashCode();
    private static final int fHE = "successkey".hashCode();
    private static final int fHF = "failkey".hashCode();
    private static final int fHG = "finalfailkey".hashCode();
    private static final int fHH = "custombuff".hashCode();
    private static final int fHI = "addMsg".hashCode();
    private static final int fHJ = "needShow".hashCode();
    private static final int fHK = "defaultContent".hashCode();
    private static final int fHL = "delayTime".hashCode();
    private static final int fHM = "retryCountLimit".hashCode();
    private static final int fHN = "businessInfo".hashCode();
    private static final int fHO = "opCode".hashCode();
    private static final int fHy = "cgi".hashCode();
    private static final int fHz = "cmdid".hashCode();
    private static final int fjl = "status".hashCode();
    private static final int flv = "version".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private boolean fCT = true;
    private boolean fDu = true;
    private boolean fHh = true;
    private boolean fHi = true;
    private boolean fHj = true;
    private boolean fHk = true;
    private boolean fHl = true;
    private boolean fHm = true;
    private boolean fHn = true;
    private boolean fHo = true;
    private boolean fHp = true;
    private boolean fHq = true;
    private boolean fHr = true;
    private boolean fHs = true;
    private boolean fHt = true;
    private boolean fHu = true;
    private boolean fHv = true;
    private boolean fHw = true;
    private boolean fHx = true;
    public long field_actionTime;
    public de field_addMsg;
    public rx field_businessInfo;
    public String field_cgi;
    public int field_cmdid;
    public String field_custombuff;
    public String field_defaultContent;
    public long field_delayTime;
    public int field_failkey;
    public int field_finalfailkey;
    public String field_functionmsgid;
    public boolean field_needShow;
    public int field_opCode;
    public long field_preVersion;
    public int field_reportid;
    public int field_retryCount;
    public int field_retryCountLimit;
    public int field_retryinterval;
    public int field_status;
    public int field_successkey;
    public long field_version;
    private boolean fji = true;
    private boolean flq = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fHy == hashCode) {
                    this.field_cgi = cursor.getString(i2);
                } else if (fHz == hashCode) {
                    this.field_cmdid = cursor.getInt(i2);
                } else if (fHA == hashCode) {
                    this.field_functionmsgid = cursor.getString(i2);
                    this.fHj = true;
                } else if (flv == hashCode) {
                    this.field_version = cursor.getLong(i2);
                } else if (fHB == hashCode) {
                    this.field_preVersion = cursor.getLong(i2);
                } else if (fHC == hashCode) {
                    this.field_retryinterval = cursor.getInt(i2);
                } else if (fHD == hashCode) {
                    this.field_reportid = cursor.getInt(i2);
                } else if (fHE == hashCode) {
                    this.field_successkey = cursor.getInt(i2);
                } else if (fHF == hashCode) {
                    this.field_failkey = cursor.getInt(i2);
                } else if (fHG == hashCode) {
                    this.field_finalfailkey = cursor.getInt(i2);
                } else if (fHH == hashCode) {
                    this.field_custombuff = cursor.getString(i2);
                } else if (fHI == hashCode) {
                    try {
                        byte[] blob = cursor.getBlob(i2);
                        if (blob != null && blob.length > 0) {
                            this.field_addMsg = (de) new de().parseFrom(blob);
                        }
                    } catch (IOException e2) {
                        Log.e("MicroMsg.SDK.BaseFunctionMsgItem", e2.getMessage());
                    }
                } else if (fjl == hashCode) {
                    this.field_status = cursor.getInt(i2);
                } else if (fHJ == hashCode) {
                    this.field_needShow = cursor.getInt(i2) != 0;
                } else if (fHK == hashCode) {
                    this.field_defaultContent = cursor.getString(i2);
                } else if (fDd == hashCode) {
                    this.field_actionTime = cursor.getLong(i2);
                } else if (fHL == hashCode) {
                    this.field_delayTime = cursor.getLong(i2);
                } else if (fDK == hashCode) {
                    this.field_retryCount = cursor.getInt(i2);
                } else if (fHM == hashCode) {
                    this.field_retryCountLimit = cursor.getInt(i2);
                } else if (fHN == hashCode) {
                    try {
                        byte[] blob2 = cursor.getBlob(i2);
                        if (blob2 != null && blob2.length > 0) {
                            this.field_businessInfo = (rx) new rx().parseFrom(blob2);
                        }
                    } catch (IOException e3) {
                        Log.e("MicroMsg.SDK.BaseFunctionMsgItem", e3.getMessage());
                    }
                } else if (fHO == hashCode) {
                    this.field_opCode = cursor.getInt(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.fHh) {
            contentValues.put("cgi", this.field_cgi);
        }
        if (this.fHi) {
            contentValues.put("cmdid", Integer.valueOf(this.field_cmdid));
        }
        if (this.fHj) {
            contentValues.put("functionmsgid", this.field_functionmsgid);
        }
        if (this.flq) {
            contentValues.put("version", Long.valueOf(this.field_version));
        }
        if (this.fHk) {
            contentValues.put("preVersion", Long.valueOf(this.field_preVersion));
        }
        if (this.fHl) {
            contentValues.put("retryinterval", Integer.valueOf(this.field_retryinterval));
        }
        if (this.fHm) {
            contentValues.put("reportid", Integer.valueOf(this.field_reportid));
        }
        if (this.fHn) {
            contentValues.put("successkey", Integer.valueOf(this.field_successkey));
        }
        if (this.fHo) {
            contentValues.put("failkey", Integer.valueOf(this.field_failkey));
        }
        if (this.fHp) {
            contentValues.put("finalfailkey", Integer.valueOf(this.field_finalfailkey));
        }
        if (this.fHq) {
            contentValues.put("custombuff", this.field_custombuff);
        }
        if (this.fHr && this.field_addMsg != null) {
            try {
                contentValues.put("addMsg", this.field_addMsg.toByteArray());
            } catch (IOException e2) {
                Log.e("MicroMsg.SDK.BaseFunctionMsgItem", e2.getMessage());
            }
        }
        if (this.fji) {
            contentValues.put("status", Integer.valueOf(this.field_status));
        }
        if (this.fHs) {
            contentValues.put("needShow", Boolean.valueOf(this.field_needShow));
        }
        if (this.fHt) {
            contentValues.put("defaultContent", this.field_defaultContent);
        }
        if (this.fCT) {
            contentValues.put("actionTime", Long.valueOf(this.field_actionTime));
        }
        if (this.fHu) {
            contentValues.put("delayTime", Long.valueOf(this.field_delayTime));
        }
        if (this.fDu) {
            contentValues.put("retryCount", Integer.valueOf(this.field_retryCount));
        }
        if (this.fHv) {
            contentValues.put("retryCountLimit", Integer.valueOf(this.field_retryCountLimit));
        }
        if (this.fHw && this.field_businessInfo != null) {
            try {
                contentValues.put("businessInfo", this.field_businessInfo.toByteArray());
            } catch (IOException e3) {
                Log.e("MicroMsg.SDK.BaseFunctionMsgItem", e3.getMessage());
            }
        }
        if (this.fHx) {
            contentValues.put("opCode", Integer.valueOf(this.field_opCode));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
