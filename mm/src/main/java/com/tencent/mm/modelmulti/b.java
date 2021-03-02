package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.network.af;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.protocal.protobuf.ctr;
import com.tencent.mm.protocal.v;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;

public final class b extends q implements m {
    protected static int dML = 7;
    private i callback;
    private int errCode;
    private String errMsg;
    private int errType;
    private f.a hvh;
    private MTimerHandler iKj;
    private int jce;
    private StringBuilder jcf;
    private long jcg;
    private boolean jch;

    public b() {
        AppMethodBeat.i(132542);
        this.errType = 0;
        this.errCode = 0;
        this.errMsg = "";
        this.jce = 0;
        this.jcf = new StringBuilder();
        this.jcg = -1;
        this.jch = false;
        Log.d("MicroMsg.NetPushSync", "dksord NetSceneSync hash:%d stack:%s", Integer.valueOf(hashCode()), Util.getStack());
        this.hvh = new f.a();
        this.jcf.append("stack:" + Util.getStack() + " time:" + Util.nowSecond());
        AppMethodBeat.o(132542);
    }

    public b(final v.b bVar, int i2, long j2) {
        this();
        AppMethodBeat.i(132543);
        this.jce = i2;
        this.jcg = j2;
        Log.d("MicroMsg.NetPushSync", "dkpush do scene resp SCENE_SYNC_WAIT");
        this.iKj = new MTimerHandler(com.tencent.f.j.a.bqt("MMPushCore"), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
            /* class com.tencent.mm.modelmulti.b.AnonymousClass1 */

            @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
            public final boolean onTimerExpired() {
                AppMethodBeat.i(132537);
                b.this.jch = true;
                b.this.onGYNetEnd(-1, 0, 0, "", new a(bVar), null);
                AppMethodBeat.o(132537);
                return false;
            }
        }, false);
        AppMethodBeat.o(132543);
    }

    @Override // com.tencent.mm.ak.q
    public final String getInfo() {
        AppMethodBeat.i(132544);
        String sb = this.jcf.toString();
        AppMethodBeat.o(132544);
        return sb;
    }

    @Override // com.tencent.mm.ak.q
    public final int securityLimitCount() {
        return 500;
    }

    @Override // com.tencent.mm.ak.q
    public final q.b securityVerificationChecked(s sVar) {
        return q.b.EOk;
    }

    @Override // com.tencent.mm.ak.q
    public final boolean securityLimitCountReach() {
        AppMethodBeat.i(132545);
        boolean securityLimitCountReach = super.securityLimitCountReach();
        AppMethodBeat.o(132545);
        return securityLimitCountReach;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 138;
    }

    @Override // com.tencent.mm.ak.q
    public final void cancel() {
        AppMethodBeat.i(132546);
        super.cancel();
        AppMethodBeat.o(132546);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        boolean z = false;
        AppMethodBeat.i(132547);
        this.callback = iVar;
        this.jcf.append(" lastd:" + this.lastdispatch + " dotime:" + Util.nowSecond() + " net:" + NetStatusUtil.getNetType(MMApplicationContext.getContext()));
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(hashCode());
        objArr[1] = Integer.valueOf(dML);
        if (this.iKj != null) {
            z = true;
        }
        objArr[2] = Boolean.valueOf(z);
        Log.i("MicroMsg.NetPushSync", "doScene[%d] selector:%d pusher:%b ", objArr);
        if (this.iKj != null) {
            prepareDispatcher(gVar);
            this.iKj.startTimer(0);
            this.iKj = null;
            AppMethodBeat.o(132547);
            return -1;
        }
        a aVar = new a();
        aVar.uin = af.bkl().jEj.getUin();
        ctr ctr = ((v.a) aVar.getReqObj()).KAg;
        ctr.Leu = dML;
        ctr.Lev = z.aC(Util.decodeHexString(MMApplicationContext.getContext().getSharedPreferences("notify_sync_pref", com.tencent.mm.compatible.util.g.aps()).getString("notify_sync_key_keybuf", "")));
        ctr.Scene = 1;
        ctr.MyZ = new abo();
        ctr.KLO = d.ics;
        int dispatch = dispatch(gVar, aVar, this);
        AppMethodBeat.o(132547);
        return dispatch;
    }

    /* JADX WARNING: Removed duplicated region for block: B:119:0x0506  */
    @Override // com.tencent.mm.network.m
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onGYNetEnd(int r20, int r21, int r22, java.lang.String r23, com.tencent.mm.network.s r24, byte[] r25) {
        /*
        // Method dump skipped, instructions count: 1489
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelmulti.b.onGYNetEnd(int, int, int, java.lang.String, com.tencent.mm.network.s, byte[]):void");
    }

    public static class a implements s {
        private final v.a jck;
        private final v.b jcl;
        private final boolean jcm;
        int uin;

        public a() {
            AppMethodBeat.i(132539);
            this.jck = new v.a();
            this.jcl = new v.b();
            this.jcm = false;
            AppMethodBeat.o(132539);
        }

        public a(v.b bVar) {
            AppMethodBeat.i(132540);
            this.jck = new v.a();
            this.jcl = bVar;
            this.jcm = true;
            AppMethodBeat.o(132540);
        }

        @Override // com.tencent.mm.network.s
        public final l.e getRespObj() {
            return this.jcl;
        }

        @Override // com.tencent.mm.network.s
        public final int getType() {
            return 138;
        }

        @Override // com.tencent.mm.network.s
        public final String getUri() {
            return "/cgi-bin/micromsg-bin/newsync";
        }

        @Override // com.tencent.mm.network.s
        public final l.d getReqObj() {
            AppMethodBeat.i(132541);
            this.jck.setDeviceID(com.tencent.mm.compatible.deviceinfo.q.aoG());
            this.jck.setDeviceType(d.ics);
            this.jck.setClientVersion(d.KyO);
            this.jck.setUin(this.uin);
            v.a aVar = this.jck;
            AppMethodBeat.o(132541);
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
        public final int getNewExtFlags() {
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
    }
}
