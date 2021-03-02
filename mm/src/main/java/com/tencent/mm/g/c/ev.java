package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.ehy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.io.IOException;

public abstract class ev extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int exposureTime_HASHCODE = f.COL_EXPOSURETIME.hashCode();
    private static final int fJh = "showType".hashCode();
    private static final int fTD = "uniqueId".hashCode();
    private static final int fTE = "icon_url".hashCode();
    private static final int fTF = "parents".hashCode();
    private static final int fTG = DownloadInfo.PRIORITY.hashCode();
    private static final int fTH = "exposureDisappearTime".hashCode();
    private static final int fTI = "minClientVersion".hashCode();
    private static final int fTJ = "maxClientVersion".hashCode();
    private static final int fTK = "dynamicPath".hashCode();
    private static final int fTj = "tipId".hashCode();
    private static final int fTm = "tipType".hashCode();
    private static final int fTq = "beginShowTime".hashCode();
    private static final int fTr = "disappearTime".hashCode();
    private static final int fTs = "overdueTime".hashCode();
    private static final int fkH = "path".hashCode();
    private static final int fne = "title".hashCode();
    private static final int fpP = IssueStorage.COLUMN_EXT_INFO.hashCode();
    private static final int fyj = "state".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private boolean __hadSetexposureTime = true;
    private boolean fIV = true;
    private boolean fSX = true;
    private boolean fTA = true;
    private boolean fTB = true;
    private boolean fTC = true;
    private boolean fTa = true;
    private boolean fTe = true;
    private boolean fTf = true;
    private boolean fTg = true;
    private boolean fTv = true;
    private boolean fTw = true;
    private boolean fTx = true;
    private boolean fTy = true;
    private boolean fTz = true;
    public long field_beginShowTime;
    public long field_disappearTime;
    public String field_dynamicPath;
    public long field_exposureDisappearTime;
    public long field_exposureTime;
    public String field_extInfo;
    public String field_icon_url;
    public int field_maxClientVersion;
    public int field_minClientVersion;
    public long field_overdueTime;
    public ehy field_parents;
    public int field_path;
    public int field_priority;
    public int field_showType;
    public int field_state;
    public int field_tipId;
    public int field_tipType;
    public String field_title;
    public String field_uniqueId;
    private boolean fkD = true;
    private boolean fnb = true;
    private boolean fpB = true;
    private boolean fxx = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fTD == hashCode) {
                    this.field_uniqueId = cursor.getString(i2);
                } else if (fkH == hashCode) {
                    this.field_path = cursor.getInt(i2);
                } else if (fJh == hashCode) {
                    this.field_showType = cursor.getInt(i2);
                } else if (fne == hashCode) {
                    this.field_title = cursor.getString(i2);
                } else if (fTE == hashCode) {
                    this.field_icon_url = cursor.getString(i2);
                } else if (fTF == hashCode) {
                    try {
                        byte[] blob = cursor.getBlob(i2);
                        if (blob != null && blob.length > 0) {
                            this.field_parents = (ehy) new ehy().parseFrom(blob);
                        }
                    } catch (IOException e2) {
                        Log.e("MicroMsg.SDK.BaseNewTipsInfo2", e2.getMessage());
                    }
                } else if (fTj == hashCode) {
                    this.field_tipId = cursor.getInt(i2);
                } else if (fTG == hashCode) {
                    this.field_priority = cursor.getInt(i2);
                } else if (fTm == hashCode) {
                    this.field_tipType = cursor.getInt(i2);
                } else if (fTq == hashCode) {
                    this.field_beginShowTime = cursor.getLong(i2);
                } else if (exposureTime_HASHCODE == hashCode) {
                    this.field_exposureTime = cursor.getLong(i2);
                } else if (fTs == hashCode) {
                    this.field_overdueTime = cursor.getLong(i2);
                } else if (fTr == hashCode) {
                    this.field_disappearTime = cursor.getLong(i2);
                } else if (fTH == hashCode) {
                    this.field_exposureDisappearTime = cursor.getLong(i2);
                } else if (fTI == hashCode) {
                    this.field_minClientVersion = cursor.getInt(i2);
                } else if (fTJ == hashCode) {
                    this.field_maxClientVersion = cursor.getInt(i2);
                } else if (fpP == hashCode) {
                    this.field_extInfo = cursor.getString(i2);
                } else if (fyj == hashCode) {
                    this.field_state = cursor.getInt(i2);
                } else if (fTK == hashCode) {
                    this.field_dynamicPath = cursor.getString(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.fTv) {
            contentValues.put("uniqueId", this.field_uniqueId);
        }
        if (this.fkD) {
            contentValues.put("path", Integer.valueOf(this.field_path));
        }
        if (this.fIV) {
            contentValues.put("showType", Integer.valueOf(this.field_showType));
        }
        if (this.fnb) {
            contentValues.put("title", this.field_title);
        }
        if (this.fTw) {
            contentValues.put("icon_url", this.field_icon_url);
        }
        if (this.fTx && this.field_parents != null) {
            try {
                contentValues.put("parents", this.field_parents.toByteArray());
            } catch (IOException e2) {
                Log.e("MicroMsg.SDK.BaseNewTipsInfo2", e2.getMessage());
            }
        }
        if (this.fSX) {
            contentValues.put("tipId", Integer.valueOf(this.field_tipId));
        }
        if (this.fTy) {
            contentValues.put(DownloadInfo.PRIORITY, Integer.valueOf(this.field_priority));
        }
        if (this.fTa) {
            contentValues.put("tipType", Integer.valueOf(this.field_tipType));
        }
        if (this.fTe) {
            contentValues.put("beginShowTime", Long.valueOf(this.field_beginShowTime));
        }
        if (this.__hadSetexposureTime) {
            contentValues.put(f.COL_EXPOSURETIME, Long.valueOf(this.field_exposureTime));
        }
        if (this.fTg) {
            contentValues.put("overdueTime", Long.valueOf(this.field_overdueTime));
        }
        if (this.fTf) {
            contentValues.put("disappearTime", Long.valueOf(this.field_disappearTime));
        }
        if (this.fTz) {
            contentValues.put("exposureDisappearTime", Long.valueOf(this.field_exposureDisappearTime));
        }
        if (this.fTA) {
            contentValues.put("minClientVersion", Integer.valueOf(this.field_minClientVersion));
        }
        if (this.fTB) {
            contentValues.put("maxClientVersion", Integer.valueOf(this.field_maxClientVersion));
        }
        if (this.fpB) {
            contentValues.put(IssueStorage.COLUMN_EXT_INFO, this.field_extInfo);
        }
        if (this.fxx) {
            contentValues.put("state", Integer.valueOf(this.field_state));
        }
        if (this.fTC) {
            contentValues.put("dynamicPath", this.field_dynamicPath);
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
