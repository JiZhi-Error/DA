package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ff;
import com.tencent.mm.protocal.protobuf.vb;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public final class ak extends ff {
    protected static IAutoDBItem.MAutoDBInfo info;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof ak) && this.field_cardUserId == ((ak) obj).field_cardUserId) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        AppMethodBeat.i(112867);
        if (this.field_cardUserId == null) {
            AppMethodBeat.o(112867);
            return 0;
        }
        int hashCode = this.field_cardUserId.hashCode();
        AppMethodBeat.o(112867);
        return hashCode;
    }

    public static ak b(vb vbVar) {
        AppMethodBeat.i(112868);
        ak akVar = new ak();
        akVar.field_cardUserId = vbVar.KUk;
        AppMethodBeat.o(112868);
        return akVar;
    }

    static {
        AppMethodBeat.i(112869);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[2];
        mAutoDBInfo.columns = new String[3];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "cardUserId";
        mAutoDBInfo.colsMap.put("cardUserId", "TEXT PRIMARY KEY ");
        sb.append(" cardUserId TEXT PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "cardUserId";
        mAutoDBInfo.columns[1] = "retryCount";
        mAutoDBInfo.colsMap.put("retryCount", "INTEGER");
        sb.append(" retryCount INTEGER");
        mAutoDBInfo.columns[2] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(112869);
    }
}
