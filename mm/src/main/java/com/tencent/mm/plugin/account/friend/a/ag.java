package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.o;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.account.friend.a.u;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.protobuf.bvt;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.wxmm.v2helper;

public final class ag extends q implements m {
    i callback = null;
    public final s iMO = new a();

    public ag(String str, String str2, int i2, String str3, String str4, String str5, String str6) {
        AppMethodBeat.i(131118);
        u.a aVar = (u.a) this.iMO.getReqObj();
        aVar.keU.MbG = str;
        aVar.keU.MbH = str2;
        aVar.keU.oUJ = str3;
        aVar.keU.MbI = str4;
        aVar.keU.MbJ = str5;
        aVar.keU.MbK = str6;
        aVar.keU.LtW = i2;
        aVar.keU.rBI = LocaleUtil.getApplicationLanguage();
        bvt bvt = aVar.keU;
        g.aAf();
        bvt.KLN = com.tencent.mm.kernel.a.azt();
        AppMethodBeat.o(131118);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(131119);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.iMO, this);
        AppMethodBeat.o(131119);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return v2helper.EMethodSetIosMicAbCheckOff;
    }

    @Override // com.tencent.mm.ak.q
    public final int securityLimitCount() {
        return 3;
    }

    @Override // com.tencent.mm.ak.q
    public final q.b securityVerificationChecked(s sVar) {
        return q.b.EOk;
    }

    @Override // com.tencent.mm.ak.q
    public final void setSecurityCheckError(q.a aVar) {
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(131120);
        if (i3 == 4 && i4 == -102) {
            final int i5 = sVar.getReqObj().getRsaInfo().ver;
            Log.d("MicroMsg.NetSceneGetSuggestAlias", "summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", Integer.valueOf(i5));
            g.aAk().postToWorker(new Runnable() {
                /* class com.tencent.mm.plugin.account.friend.a.ag.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(131116);
                    new com.tencent.mm.modelsimple.m().doScene(ag.this.dispatcher(), new i() {
                        /* class com.tencent.mm.plugin.account.friend.a.ag.AnonymousClass1.AnonymousClass1 */

                        @Override // com.tencent.mm.ak.i
                        public final void onSceneEnd(int i2, int i3, String str, q qVar) {
                            AppMethodBeat.i(131115);
                            Log.d("MicroMsg.NetSceneGetSuggestAlias", "summerauth dkcert getcert type:%d ret [%d,%d]", Integer.valueOf(qVar.getType()), Integer.valueOf(i2), Integer.valueOf(i3));
                            if (i2 == 0 && i3 == 0) {
                                ag.this.doScene(ag.this.dispatcher(), ag.this.callback);
                                AppMethodBeat.o(131115);
                                return;
                            }
                            ag.this.callback.onSceneEnd(i2, i3, "", ag.this);
                            AppMethodBeat.o(131115);
                        }
                    });
                    AppMethodBeat.o(131116);
                }
            });
            AppMethodBeat.o(131120);
            return;
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(131120);
    }

    public static class a extends o {
        private final u.a kfr = new u.a();
        private final u.b kfs = new u.b();

        public a() {
            AppMethodBeat.i(131117);
            AppMethodBeat.o(131117);
        }

        @Override // com.tencent.mm.ak.o
        public final l.d getReqObjImp() {
            return this.kfr;
        }

        @Override // com.tencent.mm.network.s
        public final l.e getRespObj() {
            return this.kfs;
        }

        @Override // com.tencent.mm.network.s
        public final int getType() {
            return v2helper.EMethodSetIosMicAbCheckOff;
        }

        @Override // com.tencent.mm.network.s
        public final String getUri() {
            return "/cgi-bin/micromsg-bin/getsuggestalias";
        }

        @Override // com.tencent.mm.network.s, com.tencent.mm.ak.o
        public final int getOptions() {
            return 1;
        }
    }

    public final byte[] bfm() {
        AppMethodBeat.i(131121);
        byte[] a2 = z.a(((u.b) this.iMO.getRespObj()).keV.MbL, new byte[0]);
        AppMethodBeat.o(131121);
        return a2;
    }

    public final String bfl() {
        AppMethodBeat.i(131122);
        String str = ((u.b) this.iMO.getRespObj()).keV.MbJ;
        AppMethodBeat.o(131122);
        return str;
    }
}
