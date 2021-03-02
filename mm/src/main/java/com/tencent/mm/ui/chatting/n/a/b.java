package com.tencent.mm.ui.chatting.n.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.tools.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.d.b.aa;
import com.tencent.mm.ui.chatting.d.b.d;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.e.a;
import com.tencent.mm.ui.chatting.h.d;
import com.tencent.mm.ui.chatting.h.e;
import com.tencent.mm.ui.chatting.n.f;
import com.tencent.mm.ui.chatting.view.MMChattingListView;

public final class b extends a {
    private int PFD;
    private long PlX = ((d) grq().bh(d.class)).gPc();

    public b(a aVar, e eVar) {
        super(aVar, eVar);
        AppMethodBeat.i(36658);
        AppMethodBeat.o(36658);
    }

    @Override // com.tencent.mm.ui.chatting.h.b.a, com.tencent.mm.ui.chatting.n.a.a
    public final void a(MMChattingListView mMChattingListView, d.C2097d<ca> dVar) {
        boolean z;
        AppMethodBeat.i(36659);
        super.a(mMChattingListView, dVar);
        d.a aVar = dVar.PDL;
        int size = dVar.PDM.size();
        int i2 = dVar.gAZ;
        switch (aVar) {
            case ACTION_ENTER:
                grq().BN(false);
                break;
            case ACTION_TOP:
                mMChattingListView.Bx(false);
                p.a(mMChattingListView.getListView(), (mMChattingListView.getCurCount() - mMChattingListView.getPreCount()) + 1, gTR() + mMChattingListView.getTopHeight(), false);
                int curCount = mMChattingListView.getCurCount() - mMChattingListView.getPreCount();
                if (curCount > 0) {
                    ((k) grq().bh(k.class)).amv(curCount);
                    break;
                }
                break;
            case ACTION_BOTTOM:
                mMChattingListView.By(false);
                p.a(mMChattingListView.getListView(), mMChattingListView.getPreCount() + 1, mMChattingListView.getListView().getHeight() - gTR(), false);
                break;
        }
        Log.i("MicroMsg.ChattingLoader.ChattingBizDataPresenter", "[onViewUpdate] result:%s", dVar.toString());
        String talkerUserName = grq().getTalkerUserName();
        long aEk = ((l) g.af(l.class)).aTq().aEk(talkerUserName);
        bg.aVF();
        int E = c.aSQ().E(talkerUserName, 0, aEk);
        Log.i("MicroMsg.ChattingLoader.ChattingBizDataPresenter", "[isShowTopAll] talker:%s createTime:%s expiredCount:%s", talkerUserName, Long.valueOf(aEk), Integer.valueOf(E));
        if (i2 - E <= size) {
            z = true;
        } else {
            z = false;
        }
        mMChattingListView.setIsTopShowAll(z);
        mMChattingListView.setIsBottomShowAll(true);
        AppMethodBeat.o(36659);
    }

    private int gTR() {
        AppMethodBeat.i(36660);
        int gQy = ((aa) grq().bh(aa.class)).gQy();
        AppMethodBeat.o(36660);
        return gQy;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.chatting.n.a.a
    public final /* synthetic */ f a(d.a aVar, Bundle bundle, d.C2097d dVar) {
        AppMethodBeat.i(36661);
        com.tencent.mm.ui.chatting.n.a aVar2 = null;
        bg.aVF();
        int cb = c.aSR().cb(grq().getTalkerUserName(), this.PlX);
        switch (aVar) {
            case ACTION_ENTER:
                aVar2 = new com.tencent.mm.ui.chatting.n.a(grq().getTalkerUserName(), this.PlX, 48, cb);
                break;
            case ACTION_TOP:
                aVar2 = new com.tencent.mm.ui.chatting.n.a(grq().getTalkerUserName(), this.PlX, this.PFx + 48, cb);
                break;
            case ACTION_UPDATE:
                int i2 = cb - this.PFD;
                String talkerUserName = grq().getTalkerUserName();
                long j2 = this.PlX;
                int i3 = this.PFx;
                if (i2 <= 0) {
                    i2 = 0;
                }
                aVar2 = new com.tencent.mm.ui.chatting.n.a(talkerUserName, j2, i2 + i3, cb);
                break;
        }
        this.PFD = cb;
        AppMethodBeat.o(36661);
        return aVar2;
    }
}
