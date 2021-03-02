package com.tencent.mm.al;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.am;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.storage.ca;
import java.lang.reflect.Field;

public final class h extends am {
    protected static IAutoDBItem.MAutoDBInfo info;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    public h() {
    }

    public h(String str, String str2, String str3, String str4, int i2, long j2) {
        this.field_openId = str;
        this.field_brandUsername = str2;
        this.field_headImgUrl = str3;
        this.field_nickname = str4;
        this.field_kfType = i2;
        this.field_updateTime = j2;
    }

    public static boolean R(ca caVar) {
        h Nm;
        AppMethodBeat.i(176137);
        if (caVar == null || Util.isNullOrNil(caVar.field_talker)) {
            AppMethodBeat.o(176137);
            return false;
        } else if (caVar.fRf == 2) {
            AppMethodBeat.o(176137);
            return true;
        } else if (Util.isNullOrNil(caVar.fQZ) || !g.Nb(caVar.field_talker) || (Nm = ag.bag().Nm(caVar.fQZ)) == null || Nm.field_kfType != 2) {
            AppMethodBeat.o(176137);
            return false;
        } else {
            AppMethodBeat.o(176137);
            return true;
        }
    }

    static {
        AppMethodBeat.i(124069);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[6];
        mAutoDBInfo.columns = new String[7];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "openId";
        mAutoDBInfo.colsMap.put("openId", "TEXT PRIMARY KEY ");
        sb.append(" openId TEXT PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "openId";
        mAutoDBInfo.columns[1] = "brandUsername";
        mAutoDBInfo.colsMap.put("brandUsername", "TEXT default '' ");
        sb.append(" brandUsername TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "headImgUrl";
        mAutoDBInfo.colsMap.put("headImgUrl", "TEXT");
        sb.append(" headImgUrl TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "nickname";
        mAutoDBInfo.colsMap.put("nickname", "TEXT");
        sb.append(" nickname TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "kfType";
        mAutoDBInfo.colsMap.put("kfType", "INTEGER");
        sb.append(" kfType INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[5] = ch.COL_UPDATETIME;
        mAutoDBInfo.colsMap.put(ch.COL_UPDATETIME, "LONG");
        sb.append(" updateTime LONG");
        mAutoDBInfo.columns[6] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(124069);
    }
}
