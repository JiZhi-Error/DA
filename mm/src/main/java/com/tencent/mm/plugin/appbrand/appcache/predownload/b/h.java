package com.tencent.mm.plugin.appbrand.appcache.predownload.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.at;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.launching.ao;
import com.tencent.mm.plugin.appbrand.launching.d.d;
import com.tencent.mm.protocal.protobuf.chd;
import com.tencent.mm.protocal.protobuf.che;
import com.tencent.mm.protocal.protobuf.fcc;
import com.tencent.mm.protocal.protobuf.fdb;
import com.tencent.mm.protocal.protobuf.fem;
import com.tencent.mm.protocal.protobuf.feu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.smtt.sdk.TbsListener;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00132\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0004J%\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0003H\u0014¢\u0006\u0002\u0010\nJ \u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\u0003H\u0014J\b\u0010\u0010\u001a\u00020\u0007H\u0016J\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/cmd/CmdPreLaunch;", "Lcom/tencent/mm/plugin/appbrand/appcache/predownload/cmd/AbstractCmd;", "", "Lcom/tencent/mm/protocal/protobuf/WxaSyncPreLaunchCmd;", "()V", "call", ch.COL_USERNAME, "", "appId", "wxaSyncPreLaunchCmd", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/WxaSyncPreLaunchCmd;)Ljava/lang/Boolean;", "callInner", "reportID", "", "getCmdBase", "Lcom/tencent/mm/protocal/protobuf/WxaSyncBaseCmd;", "getCmdName", "testBackdoor", "", "Companion", "plugin-appbrand-integration_release"})
public final class h extends a<Boolean, feu> {
    public static final a kPP = new a((byte) 0);

    static {
        AppMethodBeat.i(50201);
        AppMethodBeat.o(50201);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "cgiBack", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/LaunchWxaAppResponse;", "kotlin.jvm.PlatformType", "call"})
    public static final class b<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ String hLl;
        final /* synthetic */ String kPQ;
        final /* synthetic */ int kPR;

        b(String str, String str2, int i2) {
            this.hLl = str;
            this.kPQ = str2;
            this.kPR = i2;
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            che che;
            boolean z;
            String str;
            String str2;
            boolean z2;
            String str3;
            AppMethodBeat.i(228040);
            c.a aVar = (c.a) obj;
            Log.i("MicroMsg.AppBrand.Predownload.CmdPreLaunch", "getContact(%s %s) back, errType %d, errCode %d, errMsg %s", this.hLl, this.kPQ, Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode), aVar.errMsg);
            if (aVar != null) {
                che = (che) aVar.iLC;
            } else {
                che = null;
            }
            if (che != null && aVar.errCode == 0 && aVar.errType == 0) {
                che che2 = (che) aVar.iLC;
                if (che2 == null || (str3 = che2.dNI) == null || (str = str3.toString()) == null) {
                    str = "";
                }
                if (Util.isNullOrNil(str)) {
                    str2 = this.kPQ;
                } else {
                    str2 = str;
                }
                ao buD = n.buD();
                String str4 = "appId = [" + str2 + "], storage = null? [%b]";
                Object[] objArr = new Object[1];
                if (buD == null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                objArr[0] = Boolean.valueOf(z2);
                Log.i("MicroMsg.AppBrand.Predownload.CmdPreLaunch", str4, objArr);
                if (buD != null) {
                    buD.gC(str2);
                    if (buD.a(str2, (che) aVar.iLC) != null) {
                        z = true;
                    } else {
                        z = false;
                    }
                } else {
                    z = false;
                }
            } else {
                z = false;
            }
            if (z) {
                com.tencent.mm.plugin.appbrand.appcache.predownload.c.a aVar2 = com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.INSTANCE;
                com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.dN(this.kPR, 169);
            } else {
                com.tencent.mm.plugin.appbrand.appcache.predownload.c.a aVar3 = com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.INSTANCE;
                com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.dN(this.kPR, TbsListener.ErrorCode.NEEDDOWNLOAD_TRUE);
            }
            Log.i("MicroMsg.AppBrand.Predownload.CmdPreLaunch", "callInner: preLaunch res = [%b]", Boolean.valueOf(z));
            x xVar = x.SXb;
            AppMethodBeat.o(228040);
            return xVar;
        }
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.String, java.lang.String, java.lang.Object] */
    @Override // com.tencent.mm.plugin.appbrand.appcache.predownload.b.a
    public final /* synthetic */ Boolean c(String str, String str2, feu feu) {
        AppMethodBeat.i(50198);
        Boolean a2 = a(str, str2, feu);
        AppMethodBeat.o(50198);
        return a2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.tencent.mm.plugin.appbrand.appcache.predownload.b.a
    public final /* synthetic */ fem cs(feu feu) {
        AppMethodBeat.i(50200);
        feu feu2 = feu;
        p.h(feu2, "wxaSyncPreLaunchCmd");
        fem fem = feu2.NzO;
        p.g(fem, "wxaSyncPreLaunchCmd.Base");
        AppMethodBeat.o(50200);
        return fem;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/cmd/CmdPreLaunch$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    private static Boolean a(String str, String str2, feu feu) {
        AppMethodBeat.i(50197);
        p.h(str, ch.COL_USERNAME);
        p.h(str2, "appId");
        p.h(feu, "wxaSyncPreLaunchCmd");
        if (!Util.isNullOrNil(str) || !Util.isNullOrNil(str2)) {
            try {
                int i2 = feu.NzO.NzL;
                d.a aVar = d.mYC;
                chd chd = new chd();
                fcc fcc = new fcc();
                fcc.MjZ = 0;
                fcc.KSa = 0;
                fcc.Scene = 0;
                fcc.MqD = 1;
                fcc.MqE = "";
                fcc.MqC = 0;
                chd.Mmn = fcc;
                chd.Mbn = 3;
                chd.jfi = str2;
                chd.Mmv = str;
                chd.Mem = true;
                fdb fdb = new fdb();
                ICommLibReader bvT = at.bvT();
                fdb.MqF = bvT != null ? bvT.bvd() : -1;
                chd.Mmp = fdb;
                new d(chd, false).aYI().j(new b(str, str2, i2));
                Boolean bool = Boolean.TRUE;
                AppMethodBeat.o(50197);
                return bool;
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.AppBrand.Predownload.CmdPreLaunch", e2, "", new Object[0]);
                Boolean bool2 = Boolean.FALSE;
                AppMethodBeat.o(50197);
                return bool2;
            }
        } else {
            Log.e("MicroMsg.AppBrand.Predownload.CmdPreLaunch", "invalid username & appId");
            Boolean bool3 = Boolean.FALSE;
            p.g(bool3, "java.lang.Boolean.FALSE");
            AppMethodBeat.o(50197);
            return bool3;
        }
    }

    public static void cx(String str, String str2) {
        AppMethodBeat.i(50199);
        p.h(str, ch.COL_USERNAME);
        p.h(str2, "appId");
        AppMethodBeat.o(50199);
    }

    @Override // com.tencent.mm.plugin.appbrand.appcache.predownload.b.a
    public final String bwQ() {
        return "CmdPreLaunch";
    }
}
