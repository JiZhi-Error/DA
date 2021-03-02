package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.ehx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import java.io.IOException;

public abstract class eu extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fTj = "tipId".hashCode();
    private static final int fTk = "tipVersion".hashCode();
    private static final int fTl = "tipkey".hashCode();
    private static final int fTm = "tipType".hashCode();
    private static final int fTn = "isExit".hashCode();
    private static final int fTo = "hadRead".hashCode();
    private static final int fTp = "isReject".hashCode();
    private static final int fTq = "beginShowTime".hashCode();
    private static final int fTr = "disappearTime".hashCode();
    private static final int fTs = "overdueTime".hashCode();
    private static final int fTt = "tipsShowInfo".hashCode();
    private static final int fTu = "pagestaytime".hashCode();
    private static final int fpP = IssueStorage.COLUMN_EXT_INFO.hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private boolean fSX = true;
    private boolean fSY = true;
    private boolean fSZ = true;
    private boolean fTa = true;
    private boolean fTb = true;
    private boolean fTc = true;
    private boolean fTd = true;
    private boolean fTe = true;
    private boolean fTf = true;
    private boolean fTg = true;
    private boolean fTh = true;
    private boolean fTi = true;
    public long field_beginShowTime;
    public long field_disappearTime;
    public String field_extInfo;
    public boolean field_hadRead;
    public boolean field_isExit;
    public boolean field_isReject;
    public long field_overdueTime;
    public long field_pagestaytime;
    public int field_tipId;
    public int field_tipType;
    public int field_tipVersion;
    public String field_tipkey;
    public ehx field_tipsShowInfo;
    private boolean fpB = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fTj == hashCode) {
                    this.field_tipId = cursor.getInt(i2);
                    this.fSX = true;
                } else if (fTk == hashCode) {
                    this.field_tipVersion = cursor.getInt(i2);
                } else if (fTl == hashCode) {
                    this.field_tipkey = cursor.getString(i2);
                } else if (fTm == hashCode) {
                    this.field_tipType = cursor.getInt(i2);
                } else if (fTn == hashCode) {
                    this.field_isExit = cursor.getInt(i2) != 0;
                } else if (fTo == hashCode) {
                    this.field_hadRead = cursor.getInt(i2) != 0;
                } else if (fTp == hashCode) {
                    this.field_isReject = cursor.getInt(i2) != 0;
                } else if (fTq == hashCode) {
                    this.field_beginShowTime = cursor.getLong(i2);
                } else if (fTr == hashCode) {
                    this.field_disappearTime = cursor.getLong(i2);
                } else if (fTs == hashCode) {
                    this.field_overdueTime = cursor.getLong(i2);
                } else if (fTt == hashCode) {
                    try {
                        byte[] blob = cursor.getBlob(i2);
                        if (blob != null && blob.length > 0) {
                            this.field_tipsShowInfo = (ehx) new ehx().parseFrom(blob);
                        }
                    } catch (IOException e2) {
                        Log.e("MicroMsg.SDK.BaseNewTipsInfo", e2.getMessage());
                    }
                } else if (fpP == hashCode) {
                    this.field_extInfo = cursor.getString(i2);
                } else if (fTu == hashCode) {
                    this.field_pagestaytime = cursor.getLong(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.fSX) {
            contentValues.put("tipId", Integer.valueOf(this.field_tipId));
        }
        if (this.fSY) {
            contentValues.put("tipVersion", Integer.valueOf(this.field_tipVersion));
        }
        if (this.fSZ) {
            contentValues.put("tipkey", this.field_tipkey);
        }
        if (this.fTa) {
            contentValues.put("tipType", Integer.valueOf(this.field_tipType));
        }
        if (this.fTb) {
            contentValues.put("isExit", Boolean.valueOf(this.field_isExit));
        }
        if (this.fTc) {
            contentValues.put("hadRead", Boolean.valueOf(this.field_hadRead));
        }
        if (this.fTd) {
            contentValues.put("isReject", Boolean.valueOf(this.field_isReject));
        }
        if (this.fTe) {
            contentValues.put("beginShowTime", Long.valueOf(this.field_beginShowTime));
        }
        if (this.fTf) {
            contentValues.put("disappearTime", Long.valueOf(this.field_disappearTime));
        }
        if (this.fTg) {
            contentValues.put("overdueTime", Long.valueOf(this.field_overdueTime));
        }
        if (this.fTh && this.field_tipsShowInfo != null) {
            try {
                contentValues.put("tipsShowInfo", this.field_tipsShowInfo.toByteArray());
            } catch (IOException e2) {
                Log.e("MicroMsg.SDK.BaseNewTipsInfo", e2.getMessage());
            }
        }
        if (this.fpB) {
            contentValues.put(IssueStorage.COLUMN_EXT_INFO, this.field_extInfo);
        }
        if (this.fTi) {
            contentValues.put("pagestaytime", Long.valueOf(this.field_pagestaytime));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
