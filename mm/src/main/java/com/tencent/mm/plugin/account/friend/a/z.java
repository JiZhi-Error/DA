package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.yo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ch;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.mh;
import com.tencent.mm.protocal.protobuf.mi;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.recovery.wx.util.WXUtil;

public final class z extends q implements m {
    private i callback;
    private String dOX;
    private String dOZ;
    private int iMt;
    public final d rr;

    public z(String str, int i2, String str2, String str3, String str4, String str5) {
        this(str, i2, str2, 0, str3);
        AppMethodBeat.i(131089);
        this.dOX = str4;
        this.dOZ = str5;
        mh mhVar = (mh) this.rr.iLK.iLR;
        mhVar.KPU = str4;
        mhVar.KPV = str5;
        AppMethodBeat.o(131089);
    }

    public z(String str, int i2, String str2, int i3, String str3) {
        AppMethodBeat.i(131090);
        this.callback = null;
        this.iMt = 2;
        this.dOX = null;
        this.dOZ = null;
        d.a aVar = new d.a();
        aVar.iLN = new mh();
        aVar.iLO = new mi();
        aVar.uri = "/cgi-bin/micromsg-bin/bindopmobile";
        aVar.funcId = 132;
        aVar.iLP = 45;
        aVar.respCmdId = 1000000045;
        this.rr = aVar.aXF();
        mh mhVar = (mh) this.rr.iLK.iLR;
        mhVar.KMz = i2;
        mhVar.KPR = i3;
        mhVar.KPS = str3;
        if (Util.isNullOrNil(this.dOX) && Util.isNullOrNil(this.dOZ)) {
            mhVar.KPU = ChannelUtil.isNokiaAol ? MMApplicationContext.getContext().getString(R.string.g_v) : MMApplicationContext.getContext().getString(R.string.g_u);
            mhVar.KPV = com.tencent.mm.protocal.d.DEVICE_NAME;
        }
        if (str != null && str.length() > 0 && (i2 == 1 || i2 == 4 || i2 == 18)) {
            g.aAh().azQ().set(4097, str);
        } else if (i2 == 2 || i2 == 19) {
            str = (String) g.aAh().azQ().get(4097, (Object) null);
        } else if (i2 == 3) {
            str = (String) g.aAh().azQ().get(6, (Object) null);
        }
        Log.d("MicroMsg.NetSceneBindOpMobile", "Get mobile:" + str + " opcode:" + i2 + " verifyCode:" + str2);
        mhVar.KPP = str;
        mhVar.KPQ = str2;
        mhVar.rBI = LocaleUtil.getApplicationLanguage();
        AppMethodBeat.o(131090);
    }

    public final int Vj() {
        return ((mh) this.rr.iLK.iLR).KMz;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(131091);
        this.callback = iVar;
        mh mhVar = (mh) this.rr.iLK.iLR;
        if (mhVar.KPP == null || mhVar.KPP.length() <= 0) {
            Log.e("MicroMsg.NetSceneBindOpMobile", "doScene getMobile Error: " + mhVar.KPP);
            AppMethodBeat.o(131091);
            return -1;
        } else if ((mhVar.KMz == 2 || mhVar.KMz == 19) && (mhVar.KPQ == null || mhVar.KPQ.length() <= 0)) {
            Log.e("MicroMsg.NetSceneBindOpMobile", "doScene getVerifyCode Error: " + mhVar.KPP);
            AppMethodBeat.o(131091);
            return -1;
        } else {
            int dispatch = dispatch(gVar, this.rr, this);
            AppMethodBeat.o(131091);
            return dispatch;
        }
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 132;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(131092);
        mh mhVar = (mh) this.rr.iLK.iLR;
        mi miVar = (mi) this.rr.iLL.iLR;
        if (miVar != null) {
            int i5 = miVar.KLo;
            Log.i("MicroMsg.NetSceneBindOpMobile", "summerauth mmtls bindop:%s", Integer.valueOf(i5));
            g.aAi();
            g.aAh().hqB.set(47, Integer.valueOf(i5));
            com.tencent.mm.network.g gVar = g.aAg().hqi.iMw;
            if (gVar != null) {
                gVar.fB((i5 & 1) == 0);
            }
        } else {
            Log.i("MicroMsg.NetSceneBindOpMobile", "summerauth mmtls bindop not set as ret:%s", miVar);
        }
        if (i3 == 0 && i4 == 0) {
            if (miVar != null) {
                Log.d("MicroMsg.NetSceneBindOpMobile", "onGYNetEnd  errType:" + i3 + " errCode:" + i4 + " sms:" + miVar.KQg + "safedevice status = " + miVar.KEf);
            }
            if (mhVar.KMz == 2 || mhVar.KMz == 4 || mhVar.KMz == 11 || mhVar.KMz == 19) {
                g.aAh().azQ().set(4097, "");
                String str2 = (String) g.aAh().azQ().get(6, "");
                g.aAh().azQ().set(6, mhVar.KPP);
                if (!Util.isNullOrNil(str2)) {
                    if (g.aAh().azQ().get(ar.a.USERINFO_LAST_LOGIN_USERNAME_STRING, "").equals(str2)) {
                        g.aAh().azQ().set(ar.a.USERINFO_LAST_LOGIN_USERNAME_STRING, com.tencent.mm.model.z.aTY());
                    }
                    for (String str3 : ch.iFO.aWo()) {
                        if (str2.equals(ch.iFO.getString(str3, WXUtil.LAST_LOGIN_USERNAME))) {
                            ch.iFO.l(str3, WXUtil.LAST_LOGIN_USERNAME, str3);
                        }
                    }
                }
                if (Util.isNullOrNil(this.dOX) || Util.isNullOrNil(this.dOZ)) {
                    l.gl(true);
                }
                if (mhVar.KMz == 19) {
                    g.aAh().azQ().set(12322, (Object) null);
                }
                Log.d("MicroMsg.NetSceneBindOpMobile", "onGYNetEnd  mobile binded");
            } else if (mhVar.KMz == 3) {
                g.aAh().azQ().set(4097, "");
                g.aAh().azQ().set(6, "");
                g.aAh().azQ().set(12322, (Object) null);
                g.aAh().azQ().set(64, Integer.valueOf(miVar.KEf));
                yo yoVar = new yo();
                yoVar.eeN.eeO = false;
                yoVar.eeN.eeP = true;
                EventCenter.instance.publish(yoVar);
                l.bof();
                l.bog();
                Log.d("MicroMsg.NetSceneBindOpMobile", "onGYNetEnd  mobile unbinded");
            }
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(131092);
            return;
        }
        Log.e("MicroMsg.NetSceneBindOpMobile", "onGYNetEnd  errType:" + i3 + " errCode:" + i4);
        if (i3 == 4 && i4 == -240) {
            Log.i("MicroMsg.NetSceneBindOpMobile", "summerauth bindop MM_ERR_AUTO_RETRY_REQUEST redirectCount:%s", Integer.valueOf(this.iMt));
            this.iMt--;
            if (this.iMt <= 0) {
                this.callback.onSceneEnd(3, -1, "", this);
                AppMethodBeat.o(131092);
                return;
            }
            doScene(dispatcher(), this.callback);
            AppMethodBeat.o(131092);
            return;
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(131092);
    }

    public final String bbG() {
        return ((mi) this.rr.iLL.iLR).dHx;
    }
}
