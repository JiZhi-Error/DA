package com.tencent.mm.plugin.shake.b;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.g.c.ga;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dwv;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.thumbplayer.core.common.TPMediaCodecProfileLevel;
import java.lang.reflect.Field;

public final class d extends ga {
    protected static IAutoDBItem.MAutoDBInfo info;
    private SKBuiltinBuffer_t DgQ;
    public int cSx = -1;
    public int scene;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    public d() {
        this.field_insertBatch = 2;
    }

    public d(dwv dwv) {
        AppMethodBeat.i(28103);
        this.field_username = dwv.UserName;
        this.field_nickname = dwv.oUJ;
        this.field_signature = dwv.keb;
        this.field_distance = dwv.MmJ;
        this.field_reserved4 = String.valueOf(dwv.MWR);
        this.field_sex = dwv.kdY;
        this.field_imgstatus = dwv.KHo;
        this.field_hasHDImg = dwv.MWP;
        this.field_reserved1 = dwv.MmK;
        this.field_reserved3 = dwv.MmL;
        this.field_insertBatch = 2;
        if (dwv.MmQ != null) {
            this.field_snsFlag = dwv.MmQ.kej;
            this.field_sns_bgurl = dwv.MmQ.kek;
        }
        this.DgQ = dwv.MWQ;
        this.field_province = dwv.kdZ;
        this.field_city = dwv.kea;
        this.field_regionCode = RegionCodeDecoder.bq(dwv.keh, this.field_province, this.field_city);
        AppMethodBeat.o(28103);
    }

    public final String getProvince() {
        AppMethodBeat.i(28104);
        if (!Util.isNullOrNil(this.field_regionCode)) {
            String[] split = this.field_regionCode.split("_");
            if (split.length > 0) {
                if (split.length <= 2 || !split[0].equalsIgnoreCase("cn")) {
                    RegionCodeDecoder.gEm();
                    this.field_province = RegionCodeDecoder.bkP(split[0]);
                } else {
                    RegionCodeDecoder.gEm();
                    this.field_province = RegionCodeDecoder.mW(split[0], split[1]);
                }
            }
        }
        String str = this.field_province;
        AppMethodBeat.o(28104);
        return str;
    }

    public final String getCity() {
        AppMethodBeat.i(28105);
        if (!Util.isNullOrNil(this.field_regionCode)) {
            String[] split = this.field_regionCode.split("_");
            if (split.length > 0) {
                if (split.length > 2) {
                    RegionCodeDecoder.gEm();
                    this.field_city = RegionCodeDecoder.bs(split[0], split[1], split[2]);
                } else if (split.length == 2) {
                    RegionCodeDecoder.gEm();
                    this.field_city = RegionCodeDecoder.mW(split[0], split[1]);
                } else {
                    this.field_city = "";
                }
            }
        }
        String str = this.field_city;
        AppMethodBeat.o(28105);
        return str;
    }

    private int eTR() {
        AppMethodBeat.i(28106);
        try {
            int intValue = Integer.valueOf(this.field_reserved4).intValue();
            AppMethodBeat.o(28106);
            return intValue;
        } catch (Throwable th) {
            AppMethodBeat.o(28106);
            return 0;
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem, com.tencent.mm.g.c.ga
    public final ContentValues convertTo() {
        AppMethodBeat.i(28107);
        ContentValues contentValues = new ContentValues();
        if ((this.cSx & 2) != 0) {
            contentValues.put(ch.COL_USERNAME, this.field_username);
        }
        if ((this.cSx & 4) != 0) {
            contentValues.put("nickname", this.field_nickname);
        }
        if ((this.cSx & 8) != 0) {
            contentValues.put("province", getProvince());
        }
        if ((this.cSx & 16) != 0) {
            contentValues.put("city", getCity());
        }
        if ((this.cSx & 32) != 0) {
            contentValues.put("signature", this.field_signature);
        }
        if ((this.cSx & 64) != 0) {
            contentValues.put("distance", this.field_distance);
        }
        if ((this.cSx & 128) != 0) {
            contentValues.put("sex", Integer.valueOf(this.field_sex));
        }
        if ((this.cSx & 256) != 0) {
            contentValues.put("imgstatus", Integer.valueOf(this.field_imgstatus));
        }
        if ((this.cSx & 512) != 0) {
            contentValues.put("hasHDImg", Integer.valueOf(this.field_hasHDImg));
        }
        if ((this.cSx & 1024) != 0) {
            contentValues.put("insertBatch", Integer.valueOf(this.field_insertBatch));
        }
        if ((this.cSx & 2048) != 0) {
            contentValues.put("reserved1", Integer.valueOf(this.field_reserved1));
        }
        if ((this.cSx & 4096) != 0) {
            contentValues.put("reserved2", Integer.valueOf(this.field_reserved2));
        }
        if ((this.cSx & 8192) != 0) {
            contentValues.put("reserved3", this.field_reserved3);
        }
        if ((this.cSx & 16384) != 0) {
            contentValues.put("reserved4", Integer.valueOf(eTR()));
        }
        if ((this.cSx & 32768) != 0) {
            contentValues.put("type", Integer.valueOf(this.field_type));
        }
        if ((this.cSx & 65536) != 0) {
            contentValues.put("lvbuffer", this.field_lvbuffer);
        }
        if ((this.cSx & 131072) != 0) {
            contentValues.put("regionCode", this.field_regionCode);
        }
        if ((this.cSx & TPMediaCodecProfileLevel.HEVCMainTierLevel52) != 0) {
            contentValues.put("snsFlag", Integer.valueOf(this.field_snsFlag));
        }
        if ((this.cSx & 524288) != 0) {
            contentValues.put("sns_bgurl", this.field_sns_bgurl);
        }
        AppMethodBeat.o(28107);
        return contentValues;
    }

    static {
        AppMethodBeat.i(28108);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[20];
        mAutoDBInfo.columns = new String[21];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "shakeItemID";
        mAutoDBInfo.colsMap.put("shakeItemID", "INTEGER default '0'  PRIMARY KEY ");
        sb.append(" shakeItemID INTEGER default '0'  PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "shakeItemID";
        mAutoDBInfo.columns[1] = ch.COL_USERNAME;
        mAutoDBInfo.colsMap.put(ch.COL_USERNAME, "TEXT");
        sb.append(" username TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "nickname";
        mAutoDBInfo.colsMap.put("nickname", "TEXT");
        sb.append(" nickname TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "province";
        mAutoDBInfo.colsMap.put("province", "TEXT");
        sb.append(" province TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "city";
        mAutoDBInfo.colsMap.put("city", "TEXT");
        sb.append(" city TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "signature";
        mAutoDBInfo.colsMap.put("signature", "TEXT");
        sb.append(" signature TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[6] = "distance";
        mAutoDBInfo.colsMap.put("distance", "TEXT");
        sb.append(" distance TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[7] = "sex";
        mAutoDBInfo.colsMap.put("sex", "INTEGER");
        sb.append(" sex INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[8] = "imgstatus";
        mAutoDBInfo.colsMap.put("imgstatus", "INTEGER");
        sb.append(" imgstatus INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[9] = "hasHDImg";
        mAutoDBInfo.colsMap.put("hasHDImg", "INTEGER");
        sb.append(" hasHDImg INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[10] = "insertBatch";
        mAutoDBInfo.colsMap.put("insertBatch", "INTEGER");
        sb.append(" insertBatch INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[11] = "reserved1";
        mAutoDBInfo.colsMap.put("reserved1", "INTEGER");
        sb.append(" reserved1 INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[12] = "reserved2";
        mAutoDBInfo.colsMap.put("reserved2", "INTEGER");
        sb.append(" reserved2 INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[13] = "reserved3";
        mAutoDBInfo.colsMap.put("reserved3", "TEXT");
        sb.append(" reserved3 TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[14] = "reserved4";
        mAutoDBInfo.colsMap.put("reserved4", "TEXT");
        sb.append(" reserved4 TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[15] = "type";
        mAutoDBInfo.colsMap.put("type", "INTEGER");
        sb.append(" type INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[16] = "lvbuffer";
        mAutoDBInfo.colsMap.put("lvbuffer", "BLOB");
        sb.append(" lvbuffer BLOB");
        sb.append(", ");
        mAutoDBInfo.columns[17] = "regionCode";
        mAutoDBInfo.colsMap.put("regionCode", "TEXT");
        sb.append(" regionCode TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[18] = "snsFlag";
        mAutoDBInfo.colsMap.put("snsFlag", "INTEGER");
        sb.append(" snsFlag INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[19] = "sns_bgurl";
        mAutoDBInfo.colsMap.put("sns_bgurl", "TEXT");
        sb.append(" sns_bgurl TEXT");
        mAutoDBInfo.columns[20] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(28108);
    }
}
