package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.av;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.k.a.a.c;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class aj extends av {
    protected static IAutoDBItem.MAutoDBInfo info;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    public final List<c> Nf(long j2) {
        AppMethodBeat.i(43164);
        LinkedList linkedList = new LinkedList();
        if (this.field_seqBlockInfo == null) {
            AppMethodBeat.o(43164);
            return linkedList;
        }
        Iterator<c> it = this.field_seqBlockInfo.gCC.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next.gCB <= j2) {
                linkedList.add(next);
            }
        }
        AppMethodBeat.o(43164);
        return linkedList;
    }

    public final List<c> Ng(long j2) {
        AppMethodBeat.i(43165);
        LinkedList linkedList = new LinkedList();
        if (this.field_seqBlockInfo == null) {
            AppMethodBeat.o(43165);
            return linkedList;
        }
        Iterator<c> it = this.field_seqBlockInfo.gCC.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next.gCy > j2) {
                linkedList.add(next);
            }
        }
        AppMethodBeat.o(43165);
        return linkedList;
    }

    public final String toString() {
        AppMethodBeat.i(43166);
        StringBuilder sb = new StringBuilder();
        sb.append("username:").append(this.field_username).append(" ");
        sb.append("lastLocalSeq:").append(this.field_lastLocalSeq).append(" ");
        sb.append("lastPushSeq:").append(this.field_lastPushSeq).append(" ");
        if (this.field_seqBlockInfo != null) {
            sb.append("block:");
            Iterator<c> it = this.field_seqBlockInfo.gCC.iterator();
            while (it.hasNext()) {
                c next = it.next();
                sb.append("[").append(next.gCy).append(":").append(next.gCz).append("][").append(next.gCA).append(":").append(next.gCB).append("] | ");
            }
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(43166);
        return sb2;
    }

    static {
        AppMethodBeat.i(43167);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[6];
        mAutoDBInfo.columns = new String[7];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = ch.COL_USERNAME;
        mAutoDBInfo.colsMap.put(ch.COL_USERNAME, "TEXT default ''  PRIMARY KEY ");
        sb.append(" username TEXT default ''  PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = ch.COL_USERNAME;
        mAutoDBInfo.columns[1] = "lastPushSeq";
        mAutoDBInfo.colsMap.put("lastPushSeq", "LONG");
        sb.append(" lastPushSeq LONG");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "lastLocalSeq";
        mAutoDBInfo.colsMap.put("lastLocalSeq", "LONG");
        sb.append(" lastLocalSeq LONG");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "lastPushCreateTime";
        mAutoDBInfo.colsMap.put("lastPushCreateTime", "LONG");
        sb.append(" lastPushCreateTime LONG");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "lastLocalCreateTime";
        mAutoDBInfo.colsMap.put("lastLocalCreateTime", "LONG");
        sb.append(" lastLocalCreateTime LONG");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "seqBlockInfo";
        mAutoDBInfo.colsMap.put("seqBlockInfo", "BLOB");
        sb.append(" seqBlockInfo BLOB");
        mAutoDBInfo.columns[6] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(43167);
    }
}
