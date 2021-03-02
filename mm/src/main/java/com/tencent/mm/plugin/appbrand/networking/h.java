package com.tencent.mm.plugin.appbrand.networking;

import android.util.SparseIntArray;
import com.tencent.liteav.TXLiteAVCode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.co.f;
import com.tencent.mm.co.g;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.plugin.appbrand.jsapi.at;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.vending.g.c;
import com.tencent.soter.core.biometric.FaceManager;
import java.util.Locale;
import junit.framework.Assert;

public final class h implements c {
    protected static final boolean kAU = WeChatEnvironment.hasDebugger();
    public static final h njF = new h();
    protected static final com.tencent.mm.cd.a njG = new com.tencent.mm.cd.a("MicroMsg.WxaCgiServiceWC");
    protected static final a njH;

    @Override // com.tencent.mm.plugin.appbrand.networking.c
    public final /* synthetic */ c a(String str, com.tencent.mm.bw.a aVar, Class cls) {
        AppMethodBeat.i(47762);
        f b2 = b(str, aVar, cls);
        AppMethodBeat.o(47762);
        return b2;
    }

    static {
        AppMethodBeat.i(47763);
        a aVar = new a((byte) 0);
        njH = aVar;
        aVar.put("/cgi-bin/mmbiz-bin/wxaapp/verifyplugin", 1714);
        njH.put(at.lyN, 1192);
        njH.put("/cgi-bin/mmbiz-bin/wxabusiness/reportwxaappexpose", 1345);
        njH.put("/cgi-bin/mmbiz-bin/wxaapp_getauthinfo", FaceManager.FACE_ACQUIRED_UP);
        njH.put("/cgi-bin/mmbiz-bin/wxabusiness/getremotedebugticket", 1862);
        njH.put("/cgi-bin/mmbiz-bin/wxaapp/autofill/deleteinfo", 1194);
        njH.put("/cgi-bin/mmbiz-bin/wxaapp/autofill/getinfo", 1191);
        njH.put("/cgi-bin/mmbiz-bin/wxaapp/autofill/saveinfo", 1180);
        njH.put("/cgi-bin/mmbiz-bin/wxaapp/autofill/authinfo", 1183);
        njH.put("/cgi-bin/mmbiz-bin/js-authorize", 1157);
        njH.put("/cgi-bin/mmbiz-bin/js-authorize-confirm", 1158);
        njH.put("/cgi-bin/mmbiz-bin/wxaapp/customphone/updateuserphone", 2932);
        njH.put("/cgi-bin/mmbiz-bin/wxaapp/customphone/sendverifycode", 2695);
        njH.put("/cgi-bin/mmbiz-bin/wxaapp/sendverifycode", 1024);
        njH.put("/cgi-bin/mmbiz-bin/wxaapp/customphone/checkverifycode", 2775);
        njH.put("/cgi-bin/mmbiz-bin/wxaapp/checkverifycode", 1010);
        njH.put("/cgi-bin/mmbiz-bin/wxaapp/customphone/getallphone", 2536);
        njH.put("/cgi-bin/mmbiz-bin/wxaapp/customphone/updateuserphone", 2932);
        njH.put("/cgi-bin/mmbiz-bin/wxaapp/customphone/sendverifycode", 2695);
        njH.put("/cgi-bin/mmbiz-bin/wxaapp/sendverifycode", 1024);
        njH.put("/cgi-bin/mmbiz-bin/wxaapp/customphone/checkverifycode", 2775);
        njH.put("/cgi-bin/mmbiz-bin/wxaapp/checkverifycode", 1010);
        njH.put("/cgi-bin/mmbiz-bin/wxaapp/customphone/getallphone", 2536);
        njH.put("/cgi-bin/mmbiz-bin/js-operatewxdata", 1133);
        njH.put("/cgi-bin/mmbiz-bin/js-authorize", 1157);
        njH.put("/cgi-bin/mmbiz-bin/js-authorize-confirm", 1158);
        njH.put("/cgi-bin/mmbiz-bin/js-login", TXLiteAVCode.EVT_LOCAL_RECORD_RESULT);
        njH.put("/cgi-bin/mmbiz-bin/js-login-confirm", FaceManager.FACE_WITH_EYES_CLOSED);
        njH.put("/cgi-bin/mmbiz-bin/bizattr/subscribemsg", 2920);
        njH.put("/cgi-bin/mmbiz-bin/wxaapp/wxaapp_checkshortlink", 4428);
        njH.put("/cgi-bin/mmbiz-bin/wxausrevent/wxaappidkeybatchreport", 1009);
        AppMethodBeat.o(47763);
    }

    protected h() {
    }

    /* access modifiers changed from: package-private */
    public static final class a extends SparseIntArray {
        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        public final void put(String str, int i2) {
            AppMethodBeat.i(175021);
            super.put(str.hashCode(), i2);
            AppMethodBeat.o(175021);
        }

        public final int Xi(String str) {
            AppMethodBeat.i(175022);
            int i2 = super.get(str.hashCode(), -1);
            if (i2 == -1) {
                Assert.assertEquals(String.format(Locale.US, "Found invalid funcid, please register %s in this map.", str), false, h.kAU);
            }
            AppMethodBeat.o(175022);
            return i2;
        }
    }

    /* JADX DEBUG: Type inference failed for r0v5. Raw type applied. Possible types: com.tencent.mm.co.f<_Ret>, com.tencent.mm.co.f<Resp extends com.tencent.mm.protocal.protobuf.dpc> */
    private <Resp extends dpc> f<Resp> b(final String str, com.tencent.mm.bw.a aVar, Class<Resp> cls) {
        AppMethodBeat.i(47761);
        final d.a aVar2 = new d.a();
        aVar2.funcId = njH.Xi(str);
        aVar2.uri = str;
        aVar2.iLN = aVar;
        try {
            aVar2.iLO = cls.newInstance();
        } catch (IllegalAccessException | InstantiationException e2) {
            Log.e("MicroMsg.WxaCgiServiceWC", "new Response failed %s", cls.getName());
            if (kAU) {
                RuntimeException runtimeException = new RuntimeException(e2);
                AppMethodBeat.o(47761);
                throw runtimeException;
            }
        }
        f fVar = (f<_Ret>) g.hio().d(njG).g(new com.tencent.mm.vending.c.a<Resp, Void>() {
            /* class com.tencent.mm.plugin.appbrand.networking.h.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.vending.c.a
            public final /* synthetic */ Object call(Void r6) {
                AppMethodBeat.i(175020);
                final com.tencent.mm.vending.g.b hdH = com.tencent.mm.vending.g.g.hdH();
                IPCRunCgi.a(aVar2.aXF(), new b((byte) 0), new IPCRunCgi.a() {
                    /* class com.tencent.mm.plugin.appbrand.networking.h.AnonymousClass1.AnonymousClass1 */

                    @Override // com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a
                    public final void a(int i2, int i3, String str, d dVar) {
                        AppMethodBeat.i(175019);
                        Log.i("MicroMsg.WxaCgiServiceWC", "syncPipeline cgi[%s] errType[%d] errCode[%d] errMsg[%s]", str, Integer.valueOf(i2), Integer.valueOf(i3), str);
                        if (!(dVar.iLL.iLR instanceof dpc)) {
                            hdH.ej(new Exception("Invalid ResponseProtoBuf"));
                            AppMethodBeat.o(175019);
                        } else if (com.tencent.mm.plugin.appbrand.r.a.a(i2, i3, (dpc) dVar.iLL.iLR)) {
                            hdH.G(dVar.iLL.iLR);
                            AppMethodBeat.o(175019);
                        } else {
                            hdH.ej(new IllegalArgumentException(String.format(Locale.US, "Invalid response, %d %d %s", Integer.valueOf(i2), Integer.valueOf(i3), str)));
                            AppMethodBeat.o(175019);
                        }
                    }
                });
                AppMethodBeat.o(175020);
                return null;
            }
        });
        AppMethodBeat.o(47761);
        return fVar;
    }

    static final class b implements IPCRunCgi.b {
        private b() {
        }

        /* synthetic */ b(byte b2) {
            this();
        }

        @Override // com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.b
        public final d a(d dVar) {
            AppMethodBeat.i(227222);
            Log.i("MicroMsg.WxaCgiServiceWC.IPCRunCgiMainProcessMonitor", "before run cgi, rr.url=%s, rr.cmdid=%d", dVar.getUri(), Integer.valueOf(dVar.getType()));
            AppMethodBeat.o(227222);
            return dVar;
        }
    }
}
