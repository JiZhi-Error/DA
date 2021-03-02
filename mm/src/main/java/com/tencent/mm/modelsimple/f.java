package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.o;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.bg;
import com.tencent.mm.n.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.m;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public final class f extends q implements m {
    private i callback;
    private s iMO = new a();

    public static void fJ(boolean z) {
        AppMethodBeat.i(20599);
        Log.i("MicroMsg.NetSceneBgFg", "summerbgfg setBgFgForMuteRoom isFg[%s], accHasReady[%s] stack[%s]", Boolean.valueOf(z), Boolean.valueOf(bg.aAc()), Util.getStack());
        if (!bg.aAc()) {
            AppMethodBeat.o(20599);
        } else if (bg.azz() == null || bg.azz().iMw == null || bg.azz().iMw.aZh() == null) {
            Log.i("MicroMsg.NetSceneBgFg", "summerbgfg setBgFgForMuteRoom push not rready");
            AppMethodBeat.o(20599);
        } else {
            bg.azz().iMw.aZh().setForeground(z);
            if (z) {
                bg.azz().a(new f(true), 0);
                AppMethodBeat.o(20599);
                return;
            }
            bg.azz().a(new f(beP()), 0);
            AppMethodBeat.o(20599);
        }
    }

    private static boolean beP() {
        int i2;
        boolean z;
        AppMethodBeat.i(20600);
        if (ac.jPk != -1) {
            i2 = ac.jPk;
        } else {
            try {
                i2 = Util.getInt(h.aqJ().getValue("MuteRoomDisable"), 0);
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.NetSceneBgFg", e2, "", new Object[0]);
                i2 = 0;
            }
        }
        boolean z2 = CrashReportFactory.foreground;
        Log.i("MicroMsg.NetSceneBgFg", "somr DynamicConfig checkBit:%d TestMuteRoomEnable:%d muteRoomDisable:%d fg:%b", 1, Integer.valueOf(ac.jPk), Integer.valueOf(i2), Boolean.valueOf(z2));
        if ((i2 & 1) != 0) {
            z = true;
        } else {
            z = z2;
        }
        AppMethodBeat.o(20600);
        return z;
    }

    private f(boolean z) {
        int i2;
        AppMethodBeat.i(20601);
        m.a aVar = (m.a) this.iMO.getReqObj();
        aVar.netType = com.tencent.mm.protocal.m.getNetType(MMApplicationContext.getContext());
        if (z) {
            i2 = 1;
        } else {
            i2 = 2;
        }
        aVar.KzG = i2;
        AppMethodBeat.o(20601);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(20602);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.iMO, this);
        AppMethodBeat.o(20602);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 0;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(20603);
        Log.d("MicroMsg.NetSceneBgFg", " ret[%d]", Integer.valueOf(((m.b) sVar.getRespObj()).KzH.dDN));
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(20603);
    }

    public static class a extends o {
        private final m.a jja = new m.a();
        private final m.b jjb = new m.b();

        public a() {
            AppMethodBeat.i(20598);
            AppMethodBeat.o(20598);
        }

        @Override // com.tencent.mm.ak.o
        public final l.d getReqObjImp() {
            return this.jja;
        }

        @Override // com.tencent.mm.network.s
        public final l.e getRespObj() {
            return this.jjb;
        }

        @Override // com.tencent.mm.network.s
        public final int getType() {
            return 0;
        }

        @Override // com.tencent.mm.network.s
        public final String getUri() {
            return null;
        }
    }
}
