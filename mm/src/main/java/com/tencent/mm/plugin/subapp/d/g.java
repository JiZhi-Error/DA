package com.tencent.mm.plugin.subapp.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.hb;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public final class g extends hb {
    protected static IAutoDBItem.MAutoDBInfo info;
    int cSx = -1;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    public final boolean big() {
        if ((this.field_status <= 1 || this.field_status > 3) && this.field_status != 8) {
            return false;
        }
        return true;
    }

    static {
        AppMethodBeat.i(28963);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[17];
        mAutoDBInfo.columns = new String[18];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "filename";
        mAutoDBInfo.colsMap.put("filename", "TEXT");
        sb.append(" filename TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[1] = "user";
        mAutoDBInfo.colsMap.put("user", "TEXT");
        sb.append(" user TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "msgid";
        mAutoDBInfo.colsMap.put("msgid", "LONG");
        sb.append(" msgid LONG");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "offset";
        mAutoDBInfo.colsMap.put("offset", "INTEGER");
        sb.append(" offset INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "filenowsize";
        mAutoDBInfo.colsMap.put("filenowsize", "INTEGER");
        sb.append(" filenowsize INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "totallen";
        mAutoDBInfo.colsMap.put("totallen", "INTEGER");
        sb.append(" totallen INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[6] = "status";
        mAutoDBInfo.colsMap.put("status", "INTEGER");
        sb.append(" status INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[7] = "createtime";
        mAutoDBInfo.colsMap.put("createtime", "LONG");
        sb.append(" createtime LONG");
        sb.append(", ");
        mAutoDBInfo.columns[8] = "lastmodifytime";
        mAutoDBInfo.colsMap.put("lastmodifytime", "LONG");
        sb.append(" lastmodifytime LONG");
        sb.append(", ");
        mAutoDBInfo.columns[9] = "clientid";
        mAutoDBInfo.colsMap.put("clientid", "TEXT");
        sb.append(" clientid TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[10] = "voicelenght";
        mAutoDBInfo.colsMap.put("voicelenght", "INTEGER");
        sb.append(" voicelenght INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[11] = "msglocalid";
        mAutoDBInfo.colsMap.put("msglocalid", "INTEGER");
        sb.append(" msglocalid INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[12] = "human";
        mAutoDBInfo.colsMap.put("human", "TEXT");
        sb.append(" human TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[13] = "voiceformat";
        mAutoDBInfo.colsMap.put("voiceformat", "INTEGER");
        sb.append(" voiceformat INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[14] = "nettimes";
        mAutoDBInfo.colsMap.put("nettimes", "INTEGER");
        sb.append(" nettimes INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[15] = "reserved1";
        mAutoDBInfo.colsMap.put("reserved1", "INTEGER");
        sb.append(" reserved1 INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[16] = "reserved2";
        mAutoDBInfo.colsMap.put("reserved2", "TEXT");
        sb.append(" reserved2 TEXT");
        mAutoDBInfo.columns[17] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(28963);
    }
}
