package com.tencent.mm.modelsimple;

import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.f;
import com.tencent.mm.plugin.appbrand.jsapi.o.e;
import com.tencent.mm.plugin.appbrand.jsapi.p.w;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bhi;
import com.tencent.mm.protocal.protobuf.bhj;
import com.tencent.mm.protocal.protobuf.ccc;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.px;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.smtt.sdk.TbsListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class l extends q implements m {
    private i callback;
    private final long jjh;
    private final long jji;
    public final Bundle jjj;
    public final d rr;
    public Object tag;

    private l() {
        AppMethodBeat.i(150923);
        this.jjh = SystemClock.elapsedRealtime();
        this.jji = System.currentTimeMillis();
        this.jjj = new Bundle();
        this.rr = a.f(a.a(a.EnumC0454a.GetA8Key));
        AppMethodBeat.o(150923);
    }

    private l(String str, int i2) {
        AppMethodBeat.i(150924);
        this.jjh = SystemClock.elapsedRealtime();
        this.jji = System.currentTimeMillis();
        this.jjj = new Bundle();
        this.rr = a.at(str, i2);
        AppMethodBeat.o(150924);
    }

    private l(a.EnumC0454a aVar) {
        AppMethodBeat.i(150925);
        this.jjh = SystemClock.elapsedRealtime();
        this.jji = System.currentTimeMillis();
        this.jjj = new Bundle();
        this.rr = a.a(aVar);
        AppMethodBeat.o(150925);
    }

    public l(String str, String str2, String str3, int i2) {
        this(a.EnumC0454a.MpGetA8Key);
        AppMethodBeat.i(150926);
        bhi bhi = (bhi) this.rr.iLK.iLR;
        bhi.OpCode = 1;
        bhi.LRu = new dqi().bhy(str);
        bhi.LRv = new dqi().bhy(str2);
        bhi.LRw = new dqi().bhy(str3);
        bhi.LRB = i2;
        Log.d("MicroMsg.NetSceneGetA8Key", "get a8key appid=%s requestId=%d", str, Integer.valueOf(i2));
        AppMethodBeat.o(150926);
    }

    public l(String str, String str2, int i2, int i3, int i4, byte[] bArr) {
        this(str, i3);
        AppMethodBeat.i(150927);
        bhi bhi = (bhi) this.rr.iLK.iLR;
        bhi.OpCode = 2;
        bhi.LRx = new dqi().bhy(str);
        bhi.Scene = i2;
        bhi.UserName = str2;
        bhi.KMd = i3;
        bhi.LRB = i4;
        bhi.LRE = new SKBuiltinBuffer_t().setBuffer(bArr);
        Log.d("MicroMsg.NetSceneGetA8Key", "get a8key reqUrl = " + str + ", username = " + str2 + ", scene = " + i2 + ", reason = " + i3 + ", requestId = " + i4);
        Log.d("MicroMsg.NetSceneGetA8Key", "a8KeyCookie = %s", Util.encodeHexString(bArr));
        AppMethodBeat.o(150927);
    }

    public l(String str, int i2, int i3, int i4, int i5, byte[] bArr) {
        this(str, 0);
        AppMethodBeat.i(223638);
        bhi bhi = (bhi) this.rr.iLK.iLR;
        bhi.OpCode = 2;
        bhi.LRx = new dqi().bhy(str);
        bhi.Scene = i2;
        bhi.UserName = null;
        bhi.KMd = 0;
        bhi.Ljb = i3;
        bhi.Ljc = i4;
        bhi.LRB = i5;
        bhi.LRu = new dqi().bhy(null);
        bhi.LRE = new SKBuiltinBuffer_t().setBuffer(bArr);
        Log.d("MicroMsg.NetSceneGetA8Key", "get a8key reqUrl = " + str + ", username = " + ((String) null) + ", scene = " + i2 + ", reason = 0, codeType = " + i3 + ", codeVersion = " + i4 + ", requestId = " + i5);
        Log.d("MicroMsg.NetSceneGetA8Key", "a8KeyCookie = %s", Util.encodeHexString(bArr));
        AppMethodBeat.o(223638);
    }

    public l(String str, String str2, int i2, int i3, int i4, String str3, int i5, byte[] bArr, String str4, String str5) {
        this(str, 0);
        AppMethodBeat.i(223639);
        bhi bhi = (bhi) this.rr.iLK.iLR;
        bhi.OpCode = 2;
        bhi.LRx = new dqi().bhy(str);
        bhi.Scene = i2;
        bhi.UserName = str2;
        bhi.LRF = str4;
        bhi.LRG = str5;
        bhi.KMd = 0;
        bhi.Ljb = i3;
        bhi.Ljc = i4;
        bhi.LRB = i5;
        bhi.LRu = new dqi().bhy(str3);
        bhi.LRE = new SKBuiltinBuffer_t().setBuffer(bArr);
        Log.d("MicroMsg.NetSceneGetA8Key", "get a8key reqUrl = " + str + ", username = " + str2 + ", scene = " + i2 + ", reason = 0, codeType = " + i3 + ", codeVersion = " + i4 + ", requestId = " + i5 + ",msgUsername = " + str4 + ", svrMsgId = " + str5);
        Log.d("MicroMsg.NetSceneGetA8Key", "a8KeyCookie = %s", Util.encodeHexString(bArr));
        AppMethodBeat.o(223639);
    }

    public l(String str, String str2, int i2, int i3, int i4, String str3, int i5, String str4, String str5, int i6, byte[] bArr) {
        this(str, i3);
        AppMethodBeat.i(150929);
        bhi bhi = (bhi) this.rr.iLK.iLR;
        bhi.OpCode = 2;
        bhi.LRx = new dqi().bhy(str);
        bhi.Scene = i2;
        bhi.UserName = str2;
        bhi.KMd = i3;
        bhi.KHa = i4;
        bhi.pLm = str3;
        bhi.LRB = i5;
        bhi.LRC = str5;
        bhi.LRD = i6;
        bhi.LRu = new dqi().bhy(str4);
        bhi.LRE = new SKBuiltinBuffer_t().setBuffer(bArr);
        Log.i("MicroMsg.NetSceneGetA8Key", "get a8key reqUrl = %s, username = %s, scene = %d, reason = %d, flag = %d, netType = %s, requestId = %d, appId = %s, functionId = %s, wallentRegion = %d, a8KeyCookie = %s", str, str2, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str3, Integer.valueOf(i5), str4, str5, Integer.valueOf(i6), Util.encodeHexString(bArr));
        AppMethodBeat.o(150929);
    }

    public l(int i2, int i3) {
        this();
        AppMethodBeat.i(150930);
        bhi bhi = (bhi) this.rr.iLK.iLR;
        bhi.OpCode = 3;
        bhi.Scene = 5;
        bhi.LRz = i2;
        bhi.LRB = i3;
        Log.d("MicroMsg.NetSceneGetA8Key", "dkwt geta8key friendQQNum:%d  a2key-len:%d requestId", Integer.valueOf(i2), Integer.valueOf(bhi.KLh.getILen()), Integer.valueOf(i3));
        AppMethodBeat.o(150930);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return TbsListener.ErrorCode.DECOUPLE_INSTLL_SUCCESS;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(150931);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(150931);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(150932);
        Log.d("MicroMsg.NetSceneGetA8Key", "dkwt geta8key onGYNetEnd:[%d,%d] url:[%s]  a8key:[%s]", Integer.valueOf(i3), Integer.valueOf(i4), beQ(), ((bhj) this.rr.iLL.iLR).LRI);
        Log.d("MicroMsg.NetSceneGetA8Key", "a8KeyCookie:%s", Util.encodeHexString(bfa()));
        this.jjj.putLong("CgiSpeedOutSideStructStartTimeStamp", this.jji);
        this.jjj.putLong("CgiSpeedOutSideStructEndTimeStamp", System.currentTimeMillis());
        this.jjj.putLong("CgiSpeedOutSideStructCostTime", SystemClock.elapsedRealtime() - this.jjh);
        this.jjj.putInt("CgiSpeedOutSideStructCgiNo", TbsListener.ErrorCode.DECOUPLE_INSTLL_SUCCESS);
        this.jjj.putInt("CgiSpeedOutSideStructRet", i4);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(150932);
    }

    public final String beQ() {
        return ((bhj) this.rr.iLL.iLR).LRH;
    }

    public final String beR() {
        dqi dqi = ((bhi) this.rr.iLK.iLR).LRx;
        if (dqi != null) {
            return dqi.MTo;
        }
        return null;
    }

    public final String getTitle() {
        return ((bhj) this.rr.iLL.iLR).Title;
    }

    public final String getContent() {
        return ((bhj) this.rr.iLL.iLR).iAc;
    }

    public final int beS() {
        return ((bhj) this.rr.iLL.iLR).KCD;
    }

    public final byte[] beT() {
        AppMethodBeat.i(150933);
        bhj bhj = (bhj) this.rr.iLL.iLR;
        if (bhj.LRQ == null) {
            AppMethodBeat.o(150933);
            return null;
        }
        try {
            byte[] a2 = z.a(bhj.LRQ);
            AppMethodBeat.o(150933);
            return a2;
        } catch (Exception e2) {
            AppMethodBeat.o(150933);
            return null;
        }
    }

    public final String beU() {
        return ((bhj) this.rr.iLL.iLR).LRL;
    }

    public final ArrayList<byte[]> beV() {
        AppMethodBeat.i(150934);
        bhj bhj = (bhj) this.rr.iLL.iLR;
        ArrayList<byte[]> arrayList = new ArrayList<>();
        if (bhj == null || bhj.LRN == null) {
            AppMethodBeat.o(150934);
            return arrayList;
        }
        Iterator<px> it = bhj.LRN.iterator();
        while (it.hasNext()) {
            try {
                arrayList.add(it.next().toByteArray());
            } catch (IOException e2) {
                Log.e("MicroMsg.NetSceneGetA8Key", "exception:%s", Util.stackTraceToString(e2));
            }
        }
        Log.d("MicroMsg.NetSceneGetA8Key", "ScopeList size = %s", Integer.valueOf(arrayList.size()));
        AppMethodBeat.o(150934);
        return arrayList;
    }

    public final long beW() {
        bhj bhj = (bhj) this.rr.iLL.iLR;
        if (bhj.LRP != null) {
            return bhj.LRP.Lqi;
        }
        return -1;
    }

    public final List<ccc> beX() {
        return ((bhj) this.rr.iLL.iLR).LRq;
    }

    public final int beY() {
        return ((bhi) this.rr.iLK.iLR).LRB;
    }

    public static final int beZ() {
        AppMethodBeat.i(150935);
        int currentTimeMillis = (int) System.currentTimeMillis();
        AppMethodBeat.o(150935);
        return currentTimeMillis;
    }

    public final byte[] bfa() {
        AppMethodBeat.i(150936);
        bhj bhj = (bhj) this.rr.iLL.iLR;
        if (bhj.LRE == null) {
            byte[] bArr = new byte[0];
            AppMethodBeat.o(150936);
            return bArr;
        }
        try {
            byte[] a2 = z.a(bhj.LRE);
            AppMethodBeat.o(150936);
            return a2;
        } catch (Exception e2) {
            byte[] bArr2 = new byte[0];
            AppMethodBeat.o(150936);
            return bArr2;
        }
    }

    public static class a {

        /* renamed from: com.tencent.mm.modelsimple.l$a$a  reason: collision with other inner class name */
        public enum EnumC0454a {
            AutoRoute,
            GetA8Key,
            MpGetA8Key,
            PayGetA8Key,
            MinorGetA8Key,
            ThridGetA8Key;

            public static EnumC0454a valueOf(String str) {
                AppMethodBeat.i(150918);
                EnumC0454a aVar = (EnumC0454a) Enum.valueOf(EnumC0454a.class, str);
                AppMethodBeat.o(150918);
                return aVar;
            }

            static {
                AppMethodBeat.i(150919);
                AppMethodBeat.o(150919);
            }
        }

        private static d a(EnumC0454a aVar, String str, int i2) {
            AppMethodBeat.i(223636);
            if (aVar == EnumC0454a.AutoRoute) {
                aVar = au(str, i2);
            }
            Log.i("MicroMsg.NetSceneGetA8Key", "getCommReqRespFromReqUrl reqUrl=%s, type=%s, reason=%d", str, aVar, Integer.valueOf(i2));
            d f2 = f(a(aVar));
            AppMethodBeat.o(223636);
            return f2;
        }

        public static d at(String str, int i2) {
            AppMethodBeat.i(223637);
            d a2 = a(EnumC0454a.AutoRoute, str, i2);
            AppMethodBeat.o(223637);
            return a2;
        }

        static d a(EnumC0454a aVar) {
            AppMethodBeat.i(150920);
            d.a aVar2 = new d.a();
            aVar2.iLN = new bhi();
            aVar2.iLO = new bhj();
            switch (aVar) {
                case GetA8Key:
                    aVar2.uri = "/cgi-bin/micromsg-bin/geta8key";
                    aVar2.funcId = TbsListener.ErrorCode.DECOUPLE_INSTLL_SUCCESS;
                    aVar2.iLP = 155;
                    aVar2.respCmdId = 1000000155;
                    break;
                case MpGetA8Key:
                    aVar2.uri = "/cgi-bin/micromsg-bin/mp-geta8key";
                    aVar2.funcId = TbsListener.ErrorCode.TPATCH_FAIL;
                    aVar2.iLP = 345;
                    aVar2.respCmdId = 1000000345;
                    break;
                case PayGetA8Key:
                    aVar2.uri = "/cgi-bin/micromsg-bin/pay-geta8key";
                    aVar2.funcId = 835;
                    aVar2.iLP = e.CTRL_INDEX;
                    aVar2.respCmdId = 1000000346;
                    break;
                case MinorGetA8Key:
                    aVar2.uri = "/cgi-bin/micromsg-bin/minor-geta8key";
                    aVar2.funcId = f.CTRL_INDEX;
                    aVar2.iLP = 387;
                    aVar2.respCmdId = 1000000387;
                    break;
                case ThridGetA8Key:
                    aVar2.uri = "/cgi-bin/micromsg-bin/3rd-geta8key";
                    aVar2.funcId = 226;
                    aVar2.iLP = w.CTRL_INDEX;
                    aVar2.respCmdId = 1000000388;
                    break;
                default:
                    aVar2.uri = "/cgi-bin/micromsg-bin/3rd-geta8key";
                    aVar2.funcId = 226;
                    aVar2.iLP = w.CTRL_INDEX;
                    aVar2.respCmdId = 1000000388;
                    break;
            }
            d aXF = aVar2.aXF();
            AppMethodBeat.o(150920);
            return aXF;
        }

        private static EnumC0454a au(String str, int i2) {
            AppMethodBeat.i(150921);
            if (i2 == 5) {
                EnumC0454a aVar = EnumC0454a.MinorGetA8Key;
                AppMethodBeat.o(150921);
                return aVar;
            } else if (Util.isNullOrNil(str)) {
                Log.i("MicroMsg.NetSceneGetA8Key", "getTypeFromUrl reqUrl is null, getA8Key");
                EnumC0454a aVar2 = EnumC0454a.GetA8Key;
                AppMethodBeat.o(150921);
                return aVar2;
            } else {
                try {
                    Uri parse = Uri.parse(str);
                    if (parse == null) {
                        EnumC0454a aVar3 = EnumC0454a.ThridGetA8Key;
                        AppMethodBeat.o(150921);
                        return aVar3;
                    }
                    String lowerCase = Util.nullAsNil(parse.getHost()).toLowerCase();
                    String str2 = Util.isNullOrNil(parse.getFragment()) ? "" : "#" + parse.getFragment();
                    Log.d("MicroMsg.NetSceneGetA8Key", "get TypeFromUrl domain:%s, fragment:%s", lowerCase, str2);
                    if (lowerCase.equals(WeChatHosts.domainString(R.string.e22)) || lowerCase.equals(WeChatHosts.domainString(R.string.e20)) || lowerCase.equals("mp.weixinbridge.com")) {
                        EnumC0454a aVar4 = EnumC0454a.MpGetA8Key;
                        AppMethodBeat.o(150921);
                        return aVar4;
                    } else if (str2.contains("wechat_pay")) {
                        EnumC0454a aVar5 = EnumC0454a.PayGetA8Key;
                        AppMethodBeat.o(150921);
                        return aVar5;
                    } else if (lowerCase.contains(".qq.com") || lowerCase.equals("qq.com") || lowerCase.contains(".wechat.com") || lowerCase.equals("wechat.com") || lowerCase.contains(".tenpay.com") || lowerCase.equals("tenpay.com") || lowerCase.contains(".url.cn") || lowerCase.equals("url.com") || (!str.startsWith(HttpWrapperBase.PROTOCAL_HTTP) && !str.startsWith(HttpWrapperBase.PROTOCAL_HTTPS))) {
                        EnumC0454a aVar6 = EnumC0454a.GetA8Key;
                        AppMethodBeat.o(150921);
                        return aVar6;
                    } else {
                        EnumC0454a aVar7 = EnumC0454a.ThridGetA8Key;
                        AppMethodBeat.o(150921);
                        return aVar7;
                    }
                } catch (Exception e2) {
                    Log.e("MicroMsg.NetSceneGetA8Key", "getTypeFromUrl parse uri fail %s", e2.getMessage());
                    EnumC0454a aVar8 = EnumC0454a.GetA8Key;
                    AppMethodBeat.o(150921);
                    return aVar8;
                }
            }
        }

        public static d f(d dVar) {
            AppMethodBeat.i(150922);
            if (MMApplicationContext.isMainProcess() && com.tencent.mm.kernel.g.aAc()) {
                bhi bhi = (bhi) dVar.iLK.iLR;
                com.tencent.mm.kernel.g.aAi();
                String nullAsNil = Util.nullAsNil((String) com.tencent.mm.kernel.g.aAh().azQ().get(46, (Object) null));
                bhi.KLh = new SKBuiltinBuffer_t().setBuffer(Util.decodeHexString(nullAsNil));
                com.tencent.mm.kernel.g.aAi();
                String nullAsNil2 = Util.nullAsNil((String) com.tencent.mm.kernel.g.aAh().azQ().get(72, (Object) null));
                bhi.LRA = new SKBuiltinBuffer_t().setBuffer(Util.decodeHexString(nullAsNil2));
                Log.d("MicroMsg.NetSceneGetA8Key", "dkwt get a2=" + nullAsNil + " newa2=" + nullAsNil2);
            }
            AppMethodBeat.o(150922);
            return dVar;
        }
    }

    public final void Pz(String str) {
        ((bhi) this.rr.iLK.iLR).LRe = str;
    }

    public final void setSubScene(int i2) {
        ((bhi) this.rr.iLK.iLR).KJS = i2;
    }
}
