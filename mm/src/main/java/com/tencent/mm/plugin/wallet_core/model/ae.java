package com.tencent.mm.plugin.wallet_core.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.hi;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public final class ae extends hi {
    public static IAutoDBItem.MAutoDBInfo info;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    @Override // com.tencent.mm.g.c.hi, com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public final void convertFrom(Cursor cursor) {
        AppMethodBeat.i(70431);
        super.convertFrom(cursor);
        AppMethodBeat.o(70431);
    }

    static {
        AppMethodBeat.i(70432);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[11];
        mAutoDBInfo.columns = new String[12];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "mNativeUrl";
        mAutoDBInfo.colsMap.put("mNativeUrl", "TEXT PRIMARY KEY ");
        sb.append(" mNativeUrl TEXT PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "mNativeUrl";
        mAutoDBInfo.columns[1] = "hbType";
        mAutoDBInfo.colsMap.put("hbType", "INTEGER");
        sb.append(" hbType INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "receiveAmount";
        mAutoDBInfo.colsMap.put("receiveAmount", "LONG");
        sb.append(" receiveAmount LONG");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "receiveTime";
        mAutoDBInfo.colsMap.put("receiveTime", "LONG");
        sb.append(" receiveTime LONG");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "receiveStatus";
        mAutoDBInfo.colsMap.put("receiveStatus", "INTEGER");
        sb.append(" receiveStatus INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "hbStatus";
        mAutoDBInfo.colsMap.put("hbStatus", "INTEGER");
        sb.append(" hbStatus INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[6] = "sender";
        mAutoDBInfo.colsMap.put("sender", "TEXT");
        sb.append(" sender TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[7] = "exclusiveUsername";
        mAutoDBInfo.colsMap.put("exclusiveUsername", "TEXT");
        sb.append(" exclusiveUsername TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[8] = "sendId";
        mAutoDBInfo.colsMap.put("sendId", "TEXT");
        sb.append(" sendId TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[9] = "invalidtime";
        mAutoDBInfo.colsMap.put("invalidtime", "INTEGER");
        sb.append(" invalidtime INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[10] = "msgSvrId";
        mAutoDBInfo.colsMap.put("msgSvrId", "LONG");
        sb.append(" msgSvrId LONG");
        mAutoDBInfo.columns[11] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(70432);
    }
}
