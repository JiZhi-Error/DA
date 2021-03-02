package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.o;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.w;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class g extends q implements m {
    private i callback;
    private s iMO;
    private byte[] jcK;
    public long jcg = -1;
    private int uin = 0;

    public g(long j2, byte[] bArr) {
        this.jcg = j2;
        this.jcK = bArr;
    }

    public g(long j2, byte[] bArr, int i2) {
        this.jcg = j2;
        this.jcK = bArr;
        this.uin = i2;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(132563);
        if (Util.isNullOrNil(this.jcK)) {
            Log.e("MicroMsg.NetSceneNotifyData", "dkpush %s", "get keyBuf failed");
            AppMethodBeat.o(132563);
            return -1;
        }
        if (this.uin == 0) {
            this.iMO = new a();
        } else {
            this.iMO = new b();
            ((b) this.iMO).uin = this.uin;
        }
        Log.i("MicroMsg.NetSceneNotifyData", "doScene now:%d buf:%s", Long.valueOf(this.jcg), Util.dumpHexBuf(this.jcK));
        ((w.a) this.iMO.getReqObj()).iUm = this.jcg;
        ((w.a) this.iMO.getReqObj()).dLi = this.jcK;
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.iMO, this);
        AppMethodBeat.o(132563);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 268369922;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(132564);
        Log.i("MicroMsg.NetSceneNotifyData", "onGYNetEnd [%d,%d] %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(132564);
    }

    public static class a extends o {
        private final w.a jcL = new w.a();
        private final w.b jcM = new w.b();

        public a() {
            AppMethodBeat.i(132560);
            AppMethodBeat.o(132560);
        }

        @Override // com.tencent.mm.network.s
        public final int getType() {
            return 268369922;
        }

        @Override // com.tencent.mm.network.s
        public final String getUri() {
            return null;
        }

        @Override // com.tencent.mm.network.s, com.tencent.mm.ak.o
        public final int getTimeOut() {
            return 0;
        }

        @Override // com.tencent.mm.ak.o
        public final /* bridge */ /* synthetic */ l.d getReqObjImp() {
            return this.jcL;
        }

        @Override // com.tencent.mm.network.s
        public final /* bridge */ /* synthetic */ l.e getRespObj() {
            return this.jcM;
        }
    }

    public static class b implements s {
        private final w.a jcL = new w.a();
        private final w.b jcM = new w.b();
        int uin;

        public b() {
            AppMethodBeat.i(132561);
            AppMethodBeat.o(132561);
        }

        @Override // com.tencent.mm.network.s
        public final int getType() {
            return 268369922;
        }

        @Override // com.tencent.mm.network.s
        public final String getUri() {
            return null;
        }

        @Override // com.tencent.mm.network.s
        public final l.d getReqObj() {
            AppMethodBeat.i(132562);
            this.jcL.setDeviceID(com.tencent.mm.compatible.deviceinfo.q.aoG());
            this.jcL.setDeviceType(d.ics);
            this.jcL.setClientVersion(d.KyO);
            this.jcL.setUin(this.uin);
            w.a aVar = this.jcL;
            AppMethodBeat.o(132562);
            return aVar;
        }

        @Override // com.tencent.mm.network.s
        public final boolean getIsUserCmd() {
            return false;
        }

        @Override // com.tencent.mm.network.s
        public final int getOptions() {
            return 0;
        }

        @Override // com.tencent.mm.network.s
        public final void setConnectionInfo(String str) {
        }

        @Override // com.tencent.mm.network.s
        public final int getTimeOut() {
            return 0;
        }

        @Override // com.tencent.mm.network.s
        public final boolean isSingleSession() {
            return true;
        }

        @Override // com.tencent.mm.network.s
        public final boolean getIsLongPolling() {
            return false;
        }

        @Override // com.tencent.mm.network.s
        public final int getLongPollingTimeout() {
            return 0;
        }

        @Override // com.tencent.mm.network.s
        public final byte[] getTransHeader() {
            return null;
        }

        @Override // com.tencent.mm.network.s
        public final boolean keepAlive() {
            return false;
        }

        @Override // com.tencent.mm.network.s
        public final int getNewExtFlags() {
            return 0;
        }

        @Override // com.tencent.mm.network.s
        public final /* bridge */ /* synthetic */ l.e getRespObj() {
            return this.jcM;
        }
    }
}
