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

public final class e implements f<ca> {
    private Cursor To;
    private int cSs;
    private String gAn;
    private int mCount;

    public e(String str, int i2, int i3) {
        this.gAn = str;
        this.mCount = i2;
        this.cSs = i3;
    }

    @Override // com.tencent.mm.ui.chatting.n.f
    public final void a(d.b bVar) {
        AppMethodBeat.i(233507);
        long aEk = ((l) g.af(l.class)).aTq().aEk(this.gAn);
        Log.d("MicroMsg.ChattingLoader.ChattingSingleNotifyMsgDataSource", "[ChattingSingleNotifyMsgDataSource] talker:%s count:%d mTotalCount:%d createTime:%d", this.gAn, Integer.valueOf(this.mCount), Integer.valueOf(this.cSs), Long.valueOf(aEk));
        bg.aVF();
        this.To = c.getNotifyMessageRecordStorage().J(this.gAn, this.mCount, aEk);
        bVar.next();
        AppMethodBeat.o(233507);
    }

    @Override // com.tencent.mm.ui.chatting.n.f
    public final int cZm() {
        return this.cSs;
    }

    @Override // com.tencent.mm.ui.chatting.n.f
    public final void jA(List<ca> list) {
        AppMethodBeat.i(233508);
        try {
            this.To.moveToFirst();
            while (!this.To.isAfterLast()) {
                ca caVar = new ca();
                caVar.convertFrom(this.To);
                list.add(caVar);
                this.To.moveToNext();
            }
            AppMethodBeat.o(233508);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.ChattingLoader.ChattingSingleNotifyMsgDataSource", e2, "", new Object[0]);
            AppMethodBeat.o(233508);
        }
    }

    @Override // com.tencent.mm.ui.chatting.n.f
    public final void close() {
        AppMethodBeat.i(233509);
        this.To.close();
        AppMethodBeat.o(233509);
    }
}
