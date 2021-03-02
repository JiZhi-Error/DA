package com.tencent.mm.plugin.wallet.wecoin.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.api.APMidasPayAPI;
import com.tencent.midas.api.request.APMidasGameRequest;
import com.tencent.mm.ak.c;
import com.tencent.mm.plugin.wallet.wecoin.a.e;
import com.tencent.mm.protocal.protobuf.bqm;
import com.tencent.mm.protocal.protobuf.cov;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u000e2\u00020\u0001:\u0002\u000e\u000fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J \u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0010\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/wallet/wecoin/model/WeCoinMidasInitializer;", "", "()V", "isMidasAlreadyInit", "", "sdkInfo", "Lcom/tencent/mm/protocal/protobuf/MidasSdkInfo;", "initMidasSDK", "", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/content/Context;", "initSDK", "callback", "Lcom/tencent/mm/plugin/wallet/wecoin/api/WeCoinCommonCallback;", "Companion", "SingletonHolder", "plugin-wxpay_release"})
public final class h {
    private static final h HNK = b.fPH();
    public static final a HNL = new a((byte) 0);
    private cov HNI;
    private boolean HNJ;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "cgiBack", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetMidasSdkInfoResponse;", "kotlin.jvm.PlatformType", "call"})
    static final class d<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ h HNO;
        final /* synthetic */ e HNR;
        final /* synthetic */ Context vXP;

        d(h hVar, e eVar, Context context) {
            this.HNO = hVar;
            this.HNR = eVar;
            this.vXP = context;
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            cov cov;
            AppMethodBeat.i(212730);
            c.a aVar = (c.a) obj;
            Log.i("MicroMsg.WeCoinMidasInitializer", "CgiGetMidasSdkInfoRequest errorType: " + aVar.errType + ", errorCode: " + aVar.errCode + ", errorMsg: " + aVar.errMsg);
            p.g(aVar, "cgiBack");
            if (com.tencent.mm.plugin.wallet.wecoin.c.c.h(aVar)) {
                e eVar = this.HNR;
                if (eVar != null) {
                    eVar.p(aVar.errType, aVar.errCode, aVar.errMsg);
                }
            } else if (aVar.iLC == null) {
                e eVar2 = this.HNR;
                if (eVar2 != null) {
                    eVar2.p(3, -2, "");
                }
            } else {
                bqm bqm = (bqm) aVar.iLC;
                if (!(bqm == null || (cov = bqm.LYf) == null)) {
                    T t = aVar.iLC;
                    p.g(t, "cgiBack.resp");
                    com.tencent.mm.plugin.wallet.wecoin.c.c.d("MicroMsg.WeCoinMidasInitializer", t);
                    this.HNO.HNI = cov;
                    h.a(this.HNO, this.vXP, cov);
                    e eVar3 = this.HNR;
                    if (eVar3 != null) {
                        eVar3.onSuccess(Boolean.TRUE);
                    }
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(212730);
            return xVar;
        }
    }

    private h() {
    }

    public /* synthetic */ h(byte b2) {
        this();
    }

    public static final /* synthetic */ void a(h hVar, Context context, cov cov) {
        AppMethodBeat.i(212734);
        hVar.a(context, cov);
        AppMethodBeat.o(212734);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/wallet/wecoin/model/WeCoinMidasInitializer$Companion;", "", "()V", "TAG", "", "instance", "Lcom/tencent/mm/plugin/wallet/wecoin/model/WeCoinMidasInitializer;", "getInstance", "()Lcom/tencent/mm/plugin/wallet/wecoin/model/WeCoinMidasInitializer;", "plugin-wxpay_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(212733);
        b bVar = b.HNN;
        AppMethodBeat.o(212733);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/wallet/wecoin/model/WeCoinMidasInitializer$SingletonHolder;", "", "()V", "holder", "Lcom/tencent/mm/plugin/wallet/wecoin/model/WeCoinMidasInitializer;", "getHolder", "()Lcom/tencent/mm/plugin/wallet/wecoin/model/WeCoinMidasInitializer;", "plugin-wxpay_release"})
    static final class b {
        private static final h HNM = new h((byte) 0);
        public static final b HNN = new b();

        static {
            AppMethodBeat.i(212728);
            AppMethodBeat.o(212728);
        }

        private b() {
        }

        public static h fPH() {
            return HNM;
        }
    }

    public final void b(Context context, e<Boolean> eVar) {
        AppMethodBeat.i(212731);
        p.h(context, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        Log.i("MicroMsg.WeCoinMidasInitializer", "initSDK.");
        cov cov = this.HNI;
        if (cov != null) {
            Log.i("MicroMsg.WeCoinMidasInitializer", "initSDK already initialized.");
            a(context, cov);
            com.tencent.f.h.RTc.aV(new c(this, context, eVar));
            AppMethodBeat.o(212731);
            return;
        }
        new com.tencent.mm.plugin.wallet.wecoin.b.d().aYI().b(new d(this, eVar, context));
        AppMethodBeat.o(212731);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "run", "com/tencent/mm/plugin/wallet/wecoin/model/WeCoinMidasInitializer$initSDK$1$1"})
    static final class c implements Runnable {
        final /* synthetic */ h HNO;
        final /* synthetic */ Context HNP;
        final /* synthetic */ e HNQ;

        c(h hVar, Context context, e eVar) {
            this.HNO = hVar;
            this.HNP = context;
            this.HNQ = eVar;
        }

        public final void run() {
            AppMethodBeat.i(212729);
            e eVar = this.HNQ;
            if (eVar != null) {
                eVar.onSuccess(Boolean.TRUE);
                AppMethodBeat.o(212729);
                return;
            }
            AppMethodBeat.o(212729);
        }
    }

    private final void a(Context context, cov cov) {
        AppMethodBeat.i(212732);
        Log.i("MicroMsg.WeCoinMidasInitializer", "is midas sdk already initialized: " + this.HNJ);
        if (!com.tencent.mm.plugin.wallet.wecoin.c.c.fPK() || !this.HNJ) {
            APMidasGameRequest aPMidasGameRequest = new APMidasGameRequest();
            aPMidasGameRequest.offerId = cov.MuV;
            aPMidasGameRequest.openId = cov.MuW;
            aPMidasGameRequest.openKey = cov.MuX;
            aPMidasGameRequest.sessionId = cov.session_id;
            aPMidasGameRequest.sessionType = cov.MuY;
            aPMidasGameRequest.pf = cov.pf;
            aPMidasGameRequest.pfKey = cov.MuZ;
            APMidasPayAPI.setEnv("release");
            APMidasPayAPI.setLogEnable(false);
            APMidasPayAPI.init(context, aPMidasGameRequest);
            this.HNJ = true;
            AppMethodBeat.o(212732);
            return;
        }
        AppMethodBeat.o(212732);
    }
}
