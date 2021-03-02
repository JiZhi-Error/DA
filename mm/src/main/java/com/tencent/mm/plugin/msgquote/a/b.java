package com.tencent.mm.plugin.msgquote.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ep;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public final class b extends ep {
    protected static IAutoDBItem.MAutoDBInfo info;

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object clone() {
        AppMethodBeat.i(88812);
        b els = els();
        AppMethodBeat.o(88812);
        return els;
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    public final String toString() {
        AppMethodBeat.i(88810);
        String str = "MsgQute{field_msgId=" + this.field_msgId + ", field_msgSvrId=" + this.field_msgSvrId + ", field_quotedMsgId=" + this.field_quotedMsgId + ", field_quotedMsgSvrId=" + this.field_quotedMsgSvrId + ", field_status=" + this.field_status + ", systemRowid=" + this.systemRowid + '}';
        AppMethodBeat.o(88810);
        return str;
    }

    private b els() {
        AppMethodBeat.i(88811);
        b bVar = new b();
        try {
            bVar.systemRowid = this.systemRowid;
            bVar.field_msgId = this.field_msgId;
            bVar.field_msgSvrId = this.field_msgSvrId;
            bVar.field_quotedMsgId = this.field_quotedMsgId;
            bVar.field_quotedMsgSvrId = this.field_quotedMsgSvrId;
            bVar.field_status = this.field_status;
        } catch (Exception e2) {
            Log.i("MicroMsg.msgquote.MsgQute", "clone() Exception:%s %s", e2.getClass(), e2.getMessage());
        }
        AppMethodBeat.o(88811);
        return bVar;
    }

    static {
        AppMethodBeat.i(88813);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[5];
        mAutoDBInfo.columns = new String[6];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "msgId";
        mAutoDBInfo.colsMap.put("msgId", "LONG");
        sb.append(" msgId LONG");
        sb.append(", ");
        mAutoDBInfo.columns[1] = "msgSvrId";
        mAutoDBInfo.colsMap.put("msgSvrId", "LONG");
        sb.append(" msgSvrId LONG");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "quotedMsgId";
        mAutoDBInfo.colsMap.put("quotedMsgId", "LONG");
        sb.append(" quotedMsgId LONG");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "quotedMsgSvrId";
        mAutoDBInfo.colsMap.put("quotedMsgSvrId", "LONG");
        sb.append(" quotedMsgSvrId LONG");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "status";
        mAutoDBInfo.colsMap.put("status", "INTEGER");
        sb.append(" status INTEGER");
        mAutoDBInfo.columns[5] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(88813);
    }
}
