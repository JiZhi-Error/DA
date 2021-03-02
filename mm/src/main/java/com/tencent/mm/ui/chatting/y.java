package com.tencent.mm.ui.chatting;

import android.os.Bundle;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ba;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.d.b.aa;
import com.tencent.mm.ui.chatting.e.a;
import java.util.List;

public final class y implements ba {
    private a dom;

    public y(a aVar) {
        AppMethodBeat.i(34778);
        this.dom = aVar;
        AppMethodBeat.o(34778);
    }

    @Override // com.tencent.mm.model.ba
    public final void a(ca caVar) {
        AppMethodBeat.i(34779);
        if (this.dom.bh(aa.class) == null) {
            Log.w("MicroMsg.ChattingUIKeywordChecker", "chatting ui maybe has exit!");
            AppMethodBeat.o(34779);
            return;
        }
        ((aa) this.dom.bh(aa.class)).gPx();
        AppMethodBeat.o(34779);
    }

    @Override // com.tencent.mm.model.ba
    public final void S(List<ca> list) {
        AppMethodBeat.i(34780);
        AppMethodBeat.o(34780);
    }

    @Override // com.tencent.mm.model.ba
    public final Looper getLooper() {
        AppMethodBeat.i(34784);
        Looper mainLooper = Looper.getMainLooper();
        AppMethodBeat.o(34784);
        return mainLooper;
    }

    @Override // com.tencent.mm.model.ba
    public final void a(int i2, String str, String str2, String str3, String str4, Bundle bundle) {
    }
}
