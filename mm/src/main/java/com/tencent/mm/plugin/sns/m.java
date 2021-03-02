package com.tencent.mm.plugin.sns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.wf;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.plugin.sns.model.v;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class m extends IListener<wf> {
    public m() {
        AppMethodBeat.i(160639);
        this.__eventId = wf.class.getName().hashCode();
        AppMethodBeat.o(160639);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
    @Override // com.tencent.mm.sdk.event.IListener
    public final /* synthetic */ boolean callback(wf wfVar) {
        AppMethodBeat.i(94911);
        wf wfVar2 = wfVar;
        if (!(wfVar2 instanceof wf)) {
            Log.f("MicroMsg.SnsSyncListener", "mismatched event");
            AppMethodBeat.o(94911);
            return false;
        }
        if (wfVar2.ecp.sourceType == 2) {
            boolean z = Util.isNullOrNil((String) g.aAh().azQ().get(68377, null)) && o.DCO.ctM() == 0;
            Log.i("MicroMsg.SnsSyncListener", "Strategy 3 isNotExistSnsNew %b", Boolean.valueOf(z));
            if (z) {
                g.aAi();
                g.aAg().hqi.a(new v(), 0);
            }
        } else {
            g.aAi();
            g.aAg().hqi.a(new v(), 0);
        }
        AppMethodBeat.o(94911);
        return true;
    }
}
