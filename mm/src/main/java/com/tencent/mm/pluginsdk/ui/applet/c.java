package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.a;
import com.tencent.mm.pluginsdk.i;

public final class c implements i {
    @Override // com.tencent.mm.pluginsdk.i
    public final w a(Context context, String str, v vVar) {
        AppMethodBeat.i(31339);
        b bVar = new b(context, str, 0, vVar);
        AppMethodBeat.o(31339);
        return bVar;
    }

    @Override // com.tencent.mm.pluginsdk.i
    public final w a(Context context, String str, int i2, v vVar, a aVar) {
        AppMethodBeat.i(232191);
        b bVar = new b(context, str, i2, vVar, aVar);
        AppMethodBeat.o(232191);
        return bVar;
    }
}
