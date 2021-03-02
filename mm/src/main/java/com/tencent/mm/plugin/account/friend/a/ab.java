package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.o;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bh;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.account.friend.a.s;
import com.tencent.mm.plugin.appbrand.jsapi.audio.n;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.protobuf.air;
import com.tencent.mm.protocal.protobuf.dyh;
import com.tencent.mm.protocal.protobuf.eer;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;

public final class ab extends q implements m {
    private i callback;
    public s iMO;
    private int iMt;

    private ab(int i2, String str, String str2, String str3) {
        AppMethodBeat.i(131098);
        this.iMt = 2;
        this.iMO = new a();
        s.a aVar = (s.a) this.iMO.getReqObj();
        aVar.keR.KMz = i2;
        aVar.keR.KPz = str;
        aVar.keR.rBI = LocaleUtil.getApplicationLanguage();
        aVar.keR.KQi = Util.getCutPasswordMD5(str2);
        aVar.keR.Lsi = str3;
        air air = aVar.keR;
        g.aAf();
        air.KLN = com.tencent.mm.kernel.a.azt();
        aVar.keR.Lsj = com.tencent.mm.compatible.deviceinfo.q.getSimCountryIso();
        aVar.keR.Lsk = 1;
        AppMethodBeat.o(131098);
    }

    public ab(String str, String str2, String str3) {
        this(2, str, str2, str3);
    }

    public ab(String str, String str2) {
        this(1, str, str2, "");
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(131099);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.iMO, this);
        AppMethodBeat.o(131099);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, com.tencent.mm.network.s sVar, byte[] bArr) {
        AppMethodBeat.i(131100);
        Log.i("MicroMsg.NetSceneEmailReg", "onGYNetEnd  errType:%d errCode:%d", Integer.valueOf(i3), Integer.valueOf(i4));
        s.b bVar = (s.b) sVar.getRespObj();
        if (i3 == 4 && i4 == -301) {
            bh.a(true, bVar.keS.KQk, bVar.keS.KQl, bVar.keS.KQj);
            this.iMt--;
            if (this.iMt <= 0) {
                this.callback.onSceneEnd(3, -1, "", this);
                AppMethodBeat.o(131100);
                return;
            }
            doScene(dispatcher(), this.callback);
            AppMethodBeat.o(131100);
        } else if (i3 == 0 && i4 == 0) {
            bh.a(false, bVar.keS.KQk, bVar.keS.KQl, bVar.keS.KQj);
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(131100);
        } else {
            Log.e("MicroMsg.NetSceneEmailReg", "onGYNetEnd  errType:" + i3 + " errCode:" + i4);
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(131100);
        }
    }

    @Override // com.tencent.mm.ak.q
    public final int securityLimitCount() {
        return 5;
    }

    @Override // com.tencent.mm.ak.q
    public final q.b securityVerificationChecked(com.tencent.mm.network.s sVar) {
        return q.b.EOk;
    }

    public final int bfw() {
        int i2;
        AppMethodBeat.i(131101);
        dyh dyh = ((s.b) this.iMO.getRespObj()).keS.KLj;
        if (dyh != null && dyh.MXV != null && dyh.MXV.size() > 0) {
            Iterator<eer> it = dyh.MXV.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                eer next = it.next();
                if (next.Cya == 1) {
                    i2 = Util.getInt(next.NeO, 0);
                    break;
                }
            }
        }
        i2 = 0;
        AppMethodBeat.o(131101);
        return i2;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return n.CTRL_INDEX;
    }

    public static class a extends o {
        private s.a kfl = new s.a();
        private s.b kfm = new s.b();

        public a() {
            AppMethodBeat.i(131097);
            AppMethodBeat.o(131097);
        }

        @Override // com.tencent.mm.network.s
        public final int getType() {
            return n.CTRL_INDEX;
        }

        @Override // com.tencent.mm.network.s
        public final String getUri() {
            return "/cgi-bin/micromsg-bin/emailreg";
        }

        @Override // com.tencent.mm.network.s
        public final l.e getRespObj() {
            return this.kfm;
        }

        @Override // com.tencent.mm.ak.o
        public final l.d getReqObjImp() {
            return this.kfl;
        }

        @Override // com.tencent.mm.network.s, com.tencent.mm.ak.o
        public final int getOptions() {
            return 1;
        }
    }
}
