package com.tencent.mm.ui.chatting.n;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.h.d;
import java.util.List;

public final class d implements f<ca> {
    private long PFt;
    private long PFu;
    private Cursor To;
    private String gAn;

    public d(String str, long j2, long j3) {
        this.gAn = str;
        this.PFt = j2;
        this.PFu = j3;
    }

    @Override // com.tencent.mm.ui.chatting.n.f
    public final void a(d.b bVar) {
        AppMethodBeat.i(36650);
        long aEk = ((l) g.af(l.class)).aTq().aEk(this.gAn);
        bg.aVF();
        this.To = c.aSQ().F(this.gAn, Math.max(aEk, this.PFt), this.PFu);
        bVar.next();
        AppMethodBeat.o(36650);
    }

    @Override // com.tencent.mm.ui.chatting.n.f
    public final int cZm() {
        AppMethodBeat.i(36651);
        bg.aVF();
        int aEM = c.aSQ().aEM(this.gAn);
        AppMethodBeat.o(36651);
        return aEM;
    }

    @Override // com.tencent.mm.ui.chatting.n.f
    public final void jA(List<ca> list) {
        AppMethodBeat.i(36652);
        try {
            this.To.moveToFirst();
            while (!this.To.isAfterLast()) {
                ca caVar = new ca();
                caVar.convertFrom(this.To);
                list.add(caVar);
                this.To.moveToNext();
            }
            AppMethodBeat.o(36652);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.ChattingLoader.ChattingSearchDataSource", e2, "", new Object[0]);
            AppMethodBeat.o(36652);
        }
    }

    @Override // com.tencent.mm.ui.chatting.n.f
    public final void close() {
        AppMethodBeat.i(36653);
        this.To.close();
        AppMethodBeat.o(36653);
    }
}
