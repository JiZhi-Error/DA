package com.tencent.mm.plugin.card.sharecard.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.gd;
import com.tencent.mm.protocal.protobuf.dxh;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public final class n extends gd {
    protected static IAutoDBItem.MAutoDBInfo info;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof n) && this.field_card_id == ((n) obj).field_card_id) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        AppMethodBeat.i(113023);
        if (this.field_card_id == null) {
            AppMethodBeat.o(113023);
            return 0;
        }
        int hashCode = this.field_card_id.hashCode();
        AppMethodBeat.o(113023);
        return hashCode;
    }

    public static n c(dxh dxh) {
        AppMethodBeat.i(113024);
        n nVar = new n();
        nVar.field_card_id = dxh.eaO;
        nVar.field_update_time = (long) dxh.KWR;
        nVar.field_state_flag = dxh.pVR;
        nVar.field_seq = dxh.seq;
        nVar.field_retryCount = 10;
        AppMethodBeat.o(113024);
        return nVar;
    }

    static {
        AppMethodBeat.i(113025);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[5];
        mAutoDBInfo.columns = new String[6];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "card_id";
        mAutoDBInfo.colsMap.put("card_id", "TEXT PRIMARY KEY ");
        sb.append(" card_id TEXT PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "card_id";
        mAutoDBInfo.columns[1] = "state_flag";
        mAutoDBInfo.colsMap.put("state_flag", "INTEGER");
        sb.append(" state_flag INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "update_time";
        mAutoDBInfo.colsMap.put("update_time", "LONG");
        sb.append(" update_time LONG");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "seq";
        mAutoDBInfo.colsMap.put("seq", "LONG");
        sb.append(" seq LONG");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "retryCount";
        mAutoDBInfo.colsMap.put("retryCount", "INTEGER");
        sb.append(" retryCount INTEGER");
        mAutoDBInfo.columns[5] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(113025);
    }
}
