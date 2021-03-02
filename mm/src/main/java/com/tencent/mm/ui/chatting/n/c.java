package com.tencent.mm.ui.chatting.n;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.h.d;
import java.util.List;

public final class c implements f<ca> {
    private Cursor To;
    private int cSs;
    private String gAn;
    private int mCount;

    public c(String str, int i2, int i3) {
        this.gAn = str;
        this.mCount = i2;
        this.cSs = i3;
    }

    @Override // com.tencent.mm.ui.chatting.n.f
    public final void a(d.b bVar) {
        AppMethodBeat.i(36647);
        long aEk = ((l) g.af(l.class)).aTq().aEk(this.gAn);
        Log.d("MicroMsg.ChattingLoader.ChattingNormalDataSource", "[ChattingNormalDataSource] talker:%s count:%d mTotalCount:%d createTime:%d", this.gAn, Integer.valueOf(this.mCount), Integer.valueOf(this.cSs), Long.valueOf(aEk));
        bg.aVF();
        this.To = com.tencent.mm.model.c.aSQ().H(this.gAn, this.mCount, aEk);
        bVar.next();
        AppMethodBeat.o(36647);
    }

    @Override // com.tencent.mm.ui.chatting.n.f
    public final int cZm() {
        return this.cSs;
    }

    @Override // com.tencent.mm.ui.chatting.n.f
    public final void jA(List<ca> list) {
        AppMethodBeat.i(36648);
        try {
            this.To.moveToFirst();
            while (!this.To.isAfterLast()) {
                ca caVar = new ca();
                caVar.convertFrom(this.To);
                list.add(caVar);
                this.To.moveToNext();
            }
            AppMethodBeat.o(36648);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.ChattingLoader.ChattingNormalDataSource", e2, "", new Object[0]);
            AppMethodBeat.o(36648);
        }
    }

    @Override // com.tencent.mm.ui.chatting.n.f
    public final void close() {
        AppMethodBeat.i(36649);
        this.To.close();
        AppMethodBeat.o(36649);
    }
}
