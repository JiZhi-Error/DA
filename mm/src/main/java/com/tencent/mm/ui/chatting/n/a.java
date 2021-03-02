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

public final class a implements f<ca> {
    private long PlX;
    private Cursor To;
    private int cSs;
    private String gAn;
    private int mCount;

    public a(String str, long j2, int i2, int i3) {
        this.gAn = str;
        this.PlX = j2;
        this.cSs = i3;
        this.mCount = i2;
    }

    @Override // com.tencent.mm.ui.chatting.n.f
    public final void a(d.b bVar) {
        AppMethodBeat.i(36624);
        Log.i("MicroMsg.ChattingLoader.ChattingBizDataSource", "[ChattingBizDataSource] talker:%s bizChatId:%s,count:%s totalCount:%s createTime:%s", this.gAn, Long.valueOf(this.PlX), Integer.valueOf(this.mCount), Integer.valueOf(this.cSs), Long.valueOf(((l) g.af(l.class)).aTq().aEk(this.gAn)));
        bg.aVF();
        this.To = c.aSR().t(this.gAn, this.PlX, this.mCount);
        bVar.next();
        AppMethodBeat.o(36624);
    }

    @Override // com.tencent.mm.ui.chatting.n.f
    public final int cZm() {
        return this.cSs;
    }

    @Override // com.tencent.mm.ui.chatting.n.f
    public final void jA(List<ca> list) {
        AppMethodBeat.i(36625);
        this.To.moveToFirst();
        while (!this.To.isAfterLast()) {
            ca caVar = new ca();
            caVar.convertFrom(this.To);
            list.add(caVar);
            Log.i("MicroMsg.ChattingLoader.ChattingBizDataSource", "ChattingBizDataSource fillItem: %s %s %s %s", caVar.field_talker, caVar.fqK, Integer.valueOf(caVar.field_isSend), Integer.valueOf(caVar.getType()));
            this.To.moveToNext();
        }
        AppMethodBeat.o(36625);
    }

    @Override // com.tencent.mm.ui.chatting.n.f
    public final void close() {
        AppMethodBeat.i(36626);
        this.To.close();
        AppMethodBeat.o(36626);
    }
}
