package com.tencent.mm.plugin.game.luggage.e.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.protocal.protobuf.coq;

public final class i extends a {
    public i() {
        super(7);
    }

    @Override // com.tencent.mm.plugin.game.luggage.e.a.a
    public final void a(Context context, g gVar, coq coq) {
        AppMethodBeat.i(83114);
        if (gVar.ITd != null) {
            gVar.ITd.reload();
        }
        AppMethodBeat.o(83114);
    }
}
