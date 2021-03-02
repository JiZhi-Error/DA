package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.gl;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public final class o extends gl {
    protected static IAutoDBItem.MAutoDBInfo info;
    public int localid;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    @Override // com.tencent.mm.g.c.gl, com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public final void convertFrom(Cursor cursor) {
        AppMethodBeat.i(97589);
        try {
            super.convertFrom(cursor);
            this.localid = (int) this.systemRowid;
            AppMethodBeat.o(97589);
        } catch (Exception e2) {
            String message = e2.getMessage();
            Log.e("MicroMsg.SnsKvReport", "error ".concat(String.valueOf(message)));
            if (message != null && message.contains("Unable to convert")) {
                aj.faT().eIQ();
            }
            AppMethodBeat.o(97589);
            throw e2;
        } catch (Exception e3) {
            Log.printErrStackTrace("MicroMsg.SnsKvReport", e3, "", new Object[0]);
            AppMethodBeat.o(97589);
        }
    }

    static {
        AppMethodBeat.i(97590);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[5];
        mAutoDBInfo.columns = new String[6];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "logtime";
        mAutoDBInfo.colsMap.put("logtime", "LONG");
        sb.append(" logtime LONG");
        sb.append(", ");
        mAutoDBInfo.columns[1] = "offset";
        mAutoDBInfo.colsMap.put("offset", "INTEGER default '0' ");
        sb.append(" offset INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "logsize";
        mAutoDBInfo.colsMap.put("logsize", "INTEGER");
        sb.append(" logsize INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "errorcount";
        mAutoDBInfo.colsMap.put("errorcount", "INTEGER");
        sb.append(" errorcount INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "value";
        mAutoDBInfo.colsMap.put("value", "BLOB");
        sb.append(" value BLOB");
        mAutoDBInfo.columns[5] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(97590);
    }
}
