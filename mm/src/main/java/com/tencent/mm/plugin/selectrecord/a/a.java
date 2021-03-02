package com.tencent.mm.plugin.selectrecord.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.plugin.selectrecord.PluginSelectRecord;
import com.tencent.mm.plugin.selectrecord.b.c;
import com.tencent.mm.plugin.selectrecord.e.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public final class a implements v {
    @Override // com.tencent.mm.plugin.messenger.foundation.a.v
    public final void a(long j2, Map<String, String> map, String str) {
        AppMethodBeat.i(187907);
        b.a(j2, map, str, null);
        AppMethodBeat.o(187907);
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.v
    public final void Qm(int i2) {
        AppMethodBeat.i(187908);
        com.tencent.mm.plugin.selectrecord.b.a.eSu().CWX = i2;
        com.tencent.mm.plugin.selectrecord.b.a eSu = com.tencent.mm.plugin.selectrecord.b.a.eSu();
        eSu.CWO.eNb = (long) eSu.CWP;
        eSu.CWO.eNc = (long) eSu.CWQ;
        eSu.CWO.eNd = (long) eSu.CWR;
        eSu.CWO.eNe = (long) eSu.CWS;
        eSu.CWO.eNf = (long) eSu.CWT;
        eSu.CWO.eNg = (long) eSu.CWU;
        eSu.CWO.eNh = (long) eSu.CWV;
        eSu.CWO.eNk = (long) eSu.CWX;
        eSu.CWO.eNl = (long) eSu.CWY;
        eSu.CWO.eNn = eSu.CXc;
        eSu.CWO.eNo = eSu.CXd;
        eSu.CWO.eNq = (long) eSu.CWZ;
        eSu.CWO.eNr = (long) eSu.CXa;
        eSu.CWO.eNs = (long) eSu.CXb;
        Log.d("MicroMsg.selectrecord.SelectRecordReportManager", "%s", eSu.CWO.abW());
        eSu.CWO.bfK();
        AppMethodBeat.o(187908);
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.v
    public final void a(String str, int i2, int i3, int i4, int i5, int i6, long j2, String str2) {
        AppMethodBeat.i(187909);
        c.a(str, i2, i3, i4, i5, i6, j2, str2);
        AppMethodBeat.o(187909);
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.v
    public final void aA(String str, long j2) {
        AppMethodBeat.i(187910);
        com.tencent.mm.plugin.selectrecord.d.a aVar = new com.tencent.mm.plugin.selectrecord.d.a();
        aVar.field_historyId = str;
        aVar.field_msgId = j2;
        Log.i("MicroMsg.recordSelect.SelectRecordService", "saveHistoryIdToMsgIf msgId:%s historyId:%s result:%s", Long.valueOf(j2), Util.nullAs(str, ""), Boolean.valueOf(((PluginSelectRecord) g.ah(PluginSelectRecord.class)).getSelectRecordStorage().a(aVar)));
        AppMethodBeat.o(187910);
    }
}
