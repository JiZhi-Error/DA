package com.tencent.mm.ui.chatting.h;

import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.chatting.d.b.u;
import com.tencent.mm.ui.chatting.d.b.w;
import com.tencent.mm.ui.chatting.h.d;
import com.tencent.mm.ui.chatting.view.MMChattingListView;

public final class b implements f<ca> {
    private MMChattingListView PDB;
    public a PDC;
    private com.tencent.mm.ui.chatting.e.a dom;

    public interface a {
        void a(MMChattingListView mMChattingListView, d.C2097d<ca> dVar);
    }

    public b(com.tencent.mm.ui.chatting.e.a aVar, MMChattingListView mMChattingListView) {
        this.PDB = mMChattingListView;
        this.dom = aVar;
    }

    @Override // com.tencent.mm.ui.chatting.h.f
    public final boolean b(d.a aVar) {
        AppMethodBeat.i(233462);
        if (!this.dom.cQp) {
            Log.e("MicroMsg.ChattingLoader.ChattingViewCallback", "[onViewUpdate] this ChattingUI has been in background!");
            AppMethodBeat.o(233462);
            return false;
        } else if (!this.dom.Pwi) {
            Log.e("MicroMsg.ChattingLoader.ChattingViewCallback", "current ChattingUI lose focus! action=%s", aVar);
            com.tencent.mm.ui.chatting.e.a aVar2 = this.dom;
            Log.i("MicroMsg.ChattingContext", "trace setNeedUpdateUI, needUpdateUI %s, trace %s", Boolean.TRUE, Util.getStack());
            aVar2.Pwj = true;
            aVar2.Pwm.add(aVar);
            AppMethodBeat.o(233462);
            return false;
        } else {
            AppMethodBeat.o(233462);
            return true;
        }
    }

    @Override // com.tencent.mm.ui.chatting.h.f
    public final void a(d.C2097d dVar) {
        AppMethodBeat.i(36420);
        this.dom.Pwj = false;
        Log.i("MicroMsg.ChattingLoader.ChattingViewCallback", "[onViewUpdate] result:%s", dVar.toString());
        u uVar = (u) this.dom.bh(u.class);
        if (!(uVar == null || uVar.gPO() == null || !uVar.gPO().xfU)) {
            Log.i("MicroMsg.ChattingLoader.ChattingViewCallback", "keyboard is shown! scroll to last");
            this.dom.BN(true);
        }
        if (dVar.PDL != d.a.ACTION_UPDATE) {
            MMChattingListView mMChattingListView = this.PDB;
            MMPullDownView.n((ViewGroup) mMChattingListView.OSi, 4);
            MMPullDownView.n((ViewGroup) mMChattingListView.GEr, 4);
        }
        ((w) this.dom.bh(w.class)).startTimer();
        if (this.PDC != null) {
            this.PDC.a(this.PDB, dVar);
        }
        AppMethodBeat.o(36420);
    }
}
