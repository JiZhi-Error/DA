package com.tencent.mm.plugin.qqmail;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.pluginsdk.b.c;

public final class d implements c {
    @Override // com.tencent.mm.pluginsdk.b.c
    public final a ak(Context context, String str) {
        AppMethodBeat.i(122636);
        com.tencent.mm.plugin.qqmail.ui.a aVar = new com.tencent.mm.plugin.qqmail.ui.a(context);
        AppMethodBeat.o(122636);
        return aVar;
    }
}
