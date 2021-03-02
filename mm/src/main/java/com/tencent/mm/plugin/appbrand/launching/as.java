package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ib;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public final class as extends ib {
    static final IAutoDBItem.MAutoDBInfo kLR;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return kLR;
    }

    static {
        AppMethodBeat.i(227091);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[2];
        mAutoDBInfo.columns = new String[3];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "appId";
        mAutoDBInfo.colsMap.put("appId", "TEXT PRIMARY KEY ");
        sb.append(" appId TEXT PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "appId";
        mAutoDBInfo.columns[1] = "permissionProtoBlob";
        mAutoDBInfo.colsMap.put("permissionProtoBlob", "BLOB");
        sb.append(" permissionProtoBlob BLOB");
        mAutoDBInfo.columns[2] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        kLR = mAutoDBInfo;
        AppMethodBeat.o(227091);
    }
}
