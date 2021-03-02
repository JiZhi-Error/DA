package com.tencent.mm.plugin.qqmail.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.type.IPCLong;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;

public class f implements b<IPCLong, IPCString> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
    @Override // com.tencent.mm.ipcinvoker.b
    public /* synthetic */ void invoke(IPCLong iPCLong, d<IPCString> dVar) {
        AppMethodBeat.i(198583);
        IPCLong iPCLong2 = iPCLong;
        Log.i("MicroMsg.GetMailMsgTask", "get mail msg %d", Long.valueOf(iPCLong2.value));
        String str = "";
        if (iPCLong2.value != 0) {
            str = ((l) g.af(l.class)).eiy().Hb(iPCLong2.value).field_content;
        }
        dVar.bn(new IPCString(str));
        AppMethodBeat.o(198583);
    }
}
