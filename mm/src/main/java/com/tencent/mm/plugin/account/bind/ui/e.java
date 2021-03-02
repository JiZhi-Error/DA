package com.tencent.mm.plugin.account.bind.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.nb;
import com.tencent.mm.plugin.account.bind.ui.f;
import com.tencent.mm.sdk.event.IListener;

public final class e extends IListener<nb> implements f.a {
    private nb kdl;

    public e() {
        AppMethodBeat.i(161741);
        this.__eventId = nb.class.getName().hashCode();
        AppMethodBeat.o(161741);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
    @Override // com.tencent.mm.sdk.event.IListener
    public final /* synthetic */ boolean callback(nb nbVar) {
        AppMethodBeat.i(110174);
        nb nbVar2 = nbVar;
        if (!(nbVar2 instanceof nb)) {
            AppMethodBeat.o(110174);
        } else {
            this.kdl = nbVar2;
            new f(this.kdl.dSL.dKq, this).bnG();
            AppMethodBeat.o(110174);
        }
        return false;
    }

    @Override // com.tencent.mm.plugin.account.bind.ui.f.a
    public final boolean dI(int i2, int i3) {
        AppMethodBeat.i(110172);
        if (this.kdl == null) {
            AppMethodBeat.o(110172);
            return false;
        } else if (this.kdl.dSL.dSN == null) {
            this.kdl = null;
            AppMethodBeat.o(110172);
            return false;
        } else if (i2 == 0 && i3 == 0) {
            this.kdl.dSM.dFE = true;
            this.kdl.dSL.dSN.run();
            this.kdl = null;
            AppMethodBeat.o(110172);
            return true;
        } else {
            this.kdl.dSM.dFE = false;
            this.kdl.dSL.dSN.run();
            this.kdl = null;
            AppMethodBeat.o(110172);
            return false;
        }
    }

    @Override // com.tencent.mm.plugin.account.bind.ui.f.a
    public final void bnF() {
        AppMethodBeat.i(110173);
        if (!(this.kdl == null || this.kdl.dSL.dSN == null)) {
            this.kdl.dSM.dFE = false;
            this.kdl.dSL.dSN.run();
            this.kdl = null;
        }
        AppMethodBeat.o(110173);
    }
}
