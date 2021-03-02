package com.tencent.mm.modelmulti;

import com.tencent.mars.comm.WakerLock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.o;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.zero.b.b;
import com.tencent.mm.protocal.aa;
import com.tencent.mm.protocal.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public final class j extends q implements m {
    private i callback;
    private WakerLock gll = new WakerLock(MMApplicationContext.getContext(), "MicroMsg.NetSceneSynCheck");
    private final s iMO;

    public j() {
        AppMethodBeat.i(132566);
        this.gll.lock(3000, "NetSceneSynCheck");
        this.iMO = new a();
        g.aAi();
        if (g.aAh() != null) {
            g.aAi();
            if (g.aAh().azQ() != null) {
                g.aAi();
                ((aa.a) this.iMO.getReqObj()).jcK = Util.decodeHexString((String) g.aAh().azQ().get(8195, (Object) null));
                g.aAi();
                g.aAf();
                ((aa.a) this.iMO.getReqObj()).setUin(com.tencent.mm.kernel.a.getUin());
                ((aa.a) this.iMO.getReqObj()).netType = com.tencent.mm.protocal.a.getNetType(MMApplicationContext.getContext());
                ((aa.a) this.iMO.getReqObj()).KzG = com.tencent.mm.protocal.a.gtq();
                Log.d("MicroMsg.MMSyncCheck", "NetSceneSynCheck");
                AppMethodBeat.o(132566);
                return;
            }
        }
        Log.e("MicroMsg.NetSceneSynCheck", "[arthurdan.NetSceneSynCheckCrash] Notice!!! MMCore.getAccStg() is null");
        AppMethodBeat.o(132566);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(132567);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.iMO, this);
        if (dispatch == -1 && this.gll.isLocking()) {
            this.gll.unLock();
        }
        AppMethodBeat.o(132567);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final boolean uniqueInNetsceneQueue() {
        return true;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 39;
    }

    @Override // com.tencent.mm.ak.q
    public final long getReturnTimeout() {
        return 240000;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(132568);
        aa.b bVar = (aa.b) sVar.getRespObj();
        Log.i("MicroMsg.NetSceneSynCheck", "new syncCheck complete, selector=" + bVar.KAs);
        if (g.aAc() && !com.tencent.mm.kernel.a.azj()) {
            byte[] bArr2 = ((aa.a) sVar.getReqObj()).hqn;
            if (Util.isNullOrNil(bArr2)) {
                Log.e("MicroMsg.NetSceneSynCheck", "onGYNetEnd md5 is null");
            }
            bVar.hqn = bArr2;
            ((b) g.af(b.class)).bdS().a(bVar.KAs, 2, bVar.gtP());
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        this.gll.unLock();
        AppMethodBeat.o(132568);
    }

    public static class a extends o {
        private final aa.a jcY = new aa.a();
        private final aa.b jcZ = new aa.b();

        public a() {
            AppMethodBeat.i(132565);
            AppMethodBeat.o(132565);
        }

        @Override // com.tencent.mm.ak.o
        public final l.d getReqObjImp() {
            return this.jcY;
        }

        @Override // com.tencent.mm.network.s
        public final l.e getRespObj() {
            return this.jcZ;
        }

        @Override // com.tencent.mm.network.s
        public final int getType() {
            return 39;
        }

        @Override // com.tencent.mm.network.s
        public final String getUri() {
            return null;
        }

        @Override // com.tencent.mm.network.s, com.tencent.mm.ak.o
        public final int getOptions() {
            return 1;
        }
    }
}
