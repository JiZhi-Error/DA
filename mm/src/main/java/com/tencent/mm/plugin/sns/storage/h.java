package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.gh;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.tmassistantsdk.storage.table.ClientInfoTable;
import java.lang.reflect.Field;

public final class h extends gh implements Cloneable {
    protected static IAutoDBItem.MAutoDBInfo info;
    public int Emk;

    @Override // java.lang.Object
    public final /* synthetic */ Object clone() {
        AppMethodBeat.i(97452);
        h feE = feE();
        AppMethodBeat.o(97452);
        return feE;
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    @Override // com.tencent.mm.g.c.gh, com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public final void convertFrom(Cursor cursor) {
        AppMethodBeat.i(97450);
        try {
            super.convertFrom(cursor);
            this.Emk = (int) this.systemRowid;
            AppMethodBeat.o(97450);
        } catch (Exception e2) {
            String message = e2.getMessage();
            Log.e("MicroMsg.SnsComment", "error ".concat(String.valueOf(message)));
            if (message != null && message.contains("Unable to convert")) {
                aj.faT().eIQ();
            }
            AppMethodBeat.o(97450);
            throw e2;
        } catch (Exception e3) {
            Log.printErrStackTrace("MicroMsg.SnsComment", e3, "", new Object[0]);
            AppMethodBeat.o(97450);
        }
    }

    public final void feD() {
        this.field_commentflag |= 1;
    }

    public final h feE() {
        h hVar;
        AppMethodBeat.i(97451);
        try {
            hVar = (h) super.clone();
        } catch (CloneNotSupportedException e2) {
            Log.e("MicroMsg.SnsComment", "snscomment clone error");
            hVar = null;
        }
        AppMethodBeat.o(97451);
        return hVar;
    }

    static {
        AppMethodBeat.i(97453);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[13];
        mAutoDBInfo.columns = new String[14];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "snsID";
        mAutoDBInfo.colsMap.put("snsID", "LONG");
        sb.append(" snsID LONG");
        sb.append(", ");
        mAutoDBInfo.columns[1] = "parentID";
        mAutoDBInfo.colsMap.put("parentID", "LONG");
        sb.append(" parentID LONG");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "isRead";
        mAutoDBInfo.colsMap.put("isRead", "SHORT default '0' ");
        sb.append(" isRead SHORT default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "createTime";
        mAutoDBInfo.colsMap.put("createTime", "INTEGER");
        sb.append(" createTime INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "talker";
        mAutoDBInfo.colsMap.put("talker", "TEXT");
        sb.append(" talker TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "type";
        mAutoDBInfo.colsMap.put("type", "INTEGER");
        sb.append(" type INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[6] = "isSend";
        mAutoDBInfo.colsMap.put("isSend", "INTEGER default 'false' ");
        sb.append(" isSend INTEGER default 'false' ");
        sb.append(", ");
        mAutoDBInfo.columns[7] = "curActionBuf";
        mAutoDBInfo.colsMap.put("curActionBuf", "BLOB");
        sb.append(" curActionBuf BLOB");
        sb.append(", ");
        mAutoDBInfo.columns[8] = "refActionBuf";
        mAutoDBInfo.colsMap.put("refActionBuf", "BLOB");
        sb.append(" refActionBuf BLOB");
        sb.append(", ");
        mAutoDBInfo.columns[9] = "commentSvrID";
        mAutoDBInfo.colsMap.put("commentSvrID", "LONG");
        sb.append(" commentSvrID LONG");
        sb.append(", ");
        mAutoDBInfo.columns[10] = ClientInfoTable.Columns.CLIENTID;
        mAutoDBInfo.colsMap.put(ClientInfoTable.Columns.CLIENTID, "TEXT");
        sb.append(" clientId TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[11] = "commentflag";
        mAutoDBInfo.colsMap.put("commentflag", "INTEGER");
        sb.append(" commentflag INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[12] = "isSilence";
        mAutoDBInfo.colsMap.put("isSilence", "INTEGER default '0' ");
        sb.append(" isSilence INTEGER default '0' ");
        mAutoDBInfo.columns[13] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(97453);
    }
}
