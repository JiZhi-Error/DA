package com.tencent.mm.plugin.qqmail.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.type.IPCLong;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;

public class a implements b<IPCLong, IPCString> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
    @Override // com.tencent.mm.ipcinvoker.b
    public /* synthetic */ void invoke(IPCLong iPCLong, d<IPCString> dVar) {
        AppMethodBeat.i(198578);
        IPCLong iPCLong2 = iPCLong;
        Log.i("MicroMsg.DelMailMsgTask", "delete mail msg %d", Long.valueOf(iPCLong2.value));
        if (iPCLong2.value != 0) {
            ((l) g.af(l.class)).eiy().Hc(iPCLong2.value);
        }
        AppMethodBeat.o(198578);
    }
}
