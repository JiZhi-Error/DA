package com.tencent.mm.plugin.appbrand.appcache.predownload.export;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.bd;
import com.tencent.mm.plugin.appbrand.launching.be;
import com.tencent.mm.plugin.appbrand.launching.x;
import com.tencent.mm.plugin.appbrand.service.u;
import com.tencent.mm.protocal.protobuf.acc;
import com.tencent.mm.protocal.protobuf.fcd;
import com.tencent.mm.protocal.protobuf.yi;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.g.d;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\tH\u0016J.\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/export/WxaPkgDownloaderExportServiceImpl;", "Lcom/tencent/mm/plugin/appbrand/service/IWxaPkgDownloaderExportService;", "()V", "registerPkgSpecs", "", "appUsername", "", "appId", "visitScene", "", "startDownloadPkg", "versionType", "onSuccess", "Lcom/tencent/mm/plugin/appbrand/service/IWxaPkgDownloaderExportService$OnDownloadSuccessListener;", "onError", "Lcom/tencent/mm/plugin/appbrand/service/IWxaPkgDownloaderExportService$OnDownloadErrorListener;", "Companion", "plugin-appbrand-integration_release"})
public final class b implements u {
    public static final a kQg = new a((byte) 0);

    static {
        AppMethodBeat.i(228083);
        AppMethodBeat.o(228083);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0003*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "kotlin.jvm.PlatformType", "onTerminate", "(Lkotlin/Unit;)V"})
    public static final class d<T> implements d.b<x> {
        public static final d kQm = new d();

        static {
            AppMethodBeat.i(228080);
            AppMethodBeat.o(228080);
        }

        d() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.vending.g.d.b
        public final /* bridge */ /* synthetic */ void bz(x xVar) {
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/export/WxaPkgDownloaderExportServiceImpl$Companion;", "", "()V", "TAG", "", "INSTANCE", "Lcom/tencent/mm/plugin/appbrand/appcache/predownload/export/WxaPkgDownloaderExportServiceImpl;", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static b bwT() {
            AppMethodBeat.i(228074);
            u uVar = (u) g.af(u.class);
            if (uVar == null) {
                com.tencent.mm.kernel.a aAf = g.aAf();
                p.g(aAf, "MMKernel.account()");
                if (!aAf.azq()) {
                    com.tencent.mm.model.b bVar = new com.tencent.mm.model.b();
                    AppMethodBeat.o(228074);
                    throw bVar;
                }
                NullPointerException nullPointerException = new NullPointerException();
                AppMethodBeat.o(228074);
                throw nullPointerException;
            } else if (uVar == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.appcache.predownload.export.WxaPkgDownloaderExportServiceImpl");
                AppMethodBeat.o(228074);
                throw tVar;
            } else {
                b bVar2 = (b) uVar;
                AppMethodBeat.o(228074);
                return bVar2;
            }
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.service.u
    public final void a(String str, int i2, u.b bVar, u.a aVar) {
        AppMethodBeat.i(228081);
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            aVar.onError(-1, "invalid appId");
            AppMethodBeat.o(228081);
            return;
        }
        com.tencent.mm.co.g.hio().h(new C0553b(i2, str, aVar)).h(new c(str, i2, bVar, aVar)).a(d.kQm);
        AppMethodBeat.o(228081);
    }

    @Override // com.tencent.mm.plugin.appbrand.service.u
    public final void r(String str, String str2, int i2) {
        boolean z;
        AppMethodBeat.i(228082);
        String str3 = str;
        if (str3 == null || str3.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            String str4 = str2;
            if (!(str4 == null || str4.length() == 0)) {
                com.tencent.mm.plugin.appbrand.config.t tVar = com.tencent.mm.plugin.appbrand.config.t.lfL;
                com.tencent.mm.plugin.appbrand.config.t.x(str, str2, i2);
                AppMethodBeat.o(228082);
                return;
            }
        }
        AppMethodBeat.o(228082);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u000e\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00040\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, hxF = {"<anonymous>", "", "kotlin.jvm.PlatformType", LocaleUtil.ITALIAN, "Ljava/lang/Void;", "invoke", "(Ljava/lang/Void;)Ljava/lang/Boolean;"})
    /* renamed from: com.tencent.mm.plugin.appbrand.appcache.predownload.export.b$b  reason: collision with other inner class name */
    public static final class C0553b<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ String kPQ;
        final /* synthetic */ u.a kQf;
        final /* synthetic */ int kQh;

        C0553b(int i2, String str, u.a aVar) {
            this.kQh = i2;
            this.kPQ = str;
            this.kQf = aVar;
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(228076);
            switch (this.kQh) {
                case 2:
                    final com.tencent.mm.vending.g.b hdH = com.tencent.mm.vending.g.g.hdH();
                    aa.a(be.J(this.kPQ, null, null), new aa.a(this) {
                        /* class com.tencent.mm.plugin.appbrand.appcache.predownload.export.b.C0553b.AnonymousClass1 */
                        final /* synthetic */ C0553b kQi;

                        {
                            this.kQi = r1;
                        }

                        @Override // com.tencent.mm.ak.aa.a
                        public final /* synthetic */ int a(int i2, int i3, String str, com.tencent.mm.ak.d dVar, q qVar) {
                            fcd fcd;
                            fcd fcd2;
                            fcd fcd3;
                            AppMethodBeat.i(228075);
                            p.g(dVar, "rr");
                            com.tencent.mm.bw.a aYK = dVar.aYK();
                            if (!(aYK instanceof yi)) {
                                aYK = null;
                            }
                            yi yiVar = (yi) aYK;
                            if (i2 == 0 && i3 == 0 && yiVar != null && (fcd3 = yiVar.Ljo) != null && fcd3.rBL == 0) {
                                if (yiVar.Ljp) {
                                    String str2 = yiVar.Ljr;
                                    if (!(str2 == null || str2.length() == 0)) {
                                        if (!p.j(yiVar.Ljr, ((com.tencent.mm.plugin.appbrand.appcache.d) n.W(com.tencent.mm.plugin.appbrand.appcache.d.class)).aO(this.kQi.kPQ, this.kQi.kQh))) {
                                            String str3 = yiVar.Ljq;
                                            if (!(str3 == null || str3.length() == 0)) {
                                                n.buL().a(this.kQi.kPQ, this.kQi.kQh, yiVar.Ljq, yiVar.Ljr, 0, 0);
                                            }
                                            ((com.tencent.mm.plugin.appbrand.launching.t) n.W(com.tencent.mm.plugin.appbrand.launching.t.class)).a(this.kQi.kPQ, this.kQi.kQh, yiVar.Ljv, true);
                                            String str4 = this.kQi.kPQ;
                                            int i4 = this.kQi.kQh;
                                            String str5 = yiVar.Ljr;
                                            p.g(str5, "resp.new_demo_md5");
                                            ((com.tencent.mm.plugin.appbrand.appcache.d) n.W(com.tencent.mm.plugin.appbrand.appcache.d.class)).n(str4, i4, str5);
                                        }
                                    }
                                }
                                hdH.G(Boolean.TRUE);
                            } else {
                                Log.e("MicroMsg.WxaPkgDownloaderExportServiceImpl", "startDownloadPkg, waitFor demo info failed, errType:" + i2 + ", errCode:" + i3 + ", errMsg:" + str + ", wxaapp_baseresponse:{ErrCode:" + ((yiVar == null || (fcd2 = yiVar.Ljo) == null) ? null : Integer.valueOf(fcd2.rBL)) + ", ErrMsg:" + ((yiVar == null || (fcd = yiVar.Ljo) == null) ? null : fcd.rBM) + '}');
                                u.a aVar = this.kQi.kQf;
                                if (aVar != null) {
                                    aVar.onError(i3, str);
                                }
                                hdH.ej(new Exception());
                            }
                            AppMethodBeat.o(228075);
                            return 0;
                        }
                    }, true);
                    Boolean bool = Boolean.FALSE;
                    AppMethodBeat.o(228076);
                    return bool;
                default:
                    Boolean bool2 = Boolean.TRUE;
                    AppMethodBeat.o(228076);
                    return bool2;
            }
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "kotlin.jvm.PlatformType", "call", "(Ljava/lang/Boolean;)V"})
    public static final class c<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ String kPQ;
        final /* synthetic */ u.b kQe;
        final /* synthetic */ u.a kQf;
        final /* synthetic */ int kQh;

        c(String str, int i2, u.b bVar, u.a aVar) {
            this.kPQ = str;
            this.kQh = i2;
            this.kQe = bVar;
            this.kQf = aVar;
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(228079);
            final x.d dVar = new x.d(this.kPQ, "", 0, this.kQh, new x.g.a(0, true, 1), false);
            x.b bVar = com.tencent.mm.plugin.appbrand.launching.x.mTR;
            acc acc = new acc();
            acc.LmG = 1;
            x.b.a(dVar, new kotlin.g.a.b<x.e, kotlin.x>(this) {
                /* class com.tencent.mm.plugin.appbrand.appcache.predownload.export.b.c.AnonymousClass1 */
                final /* synthetic */ c kQk;

                {
                    this.kQk = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // kotlin.g.a.b
                public final /* synthetic */ kotlin.x invoke(x.e eVar) {
                    AppMethodBeat.i(228077);
                    x.e eVar2 = eVar;
                    p.h(eVar2, "response");
                    bd a2 = n.buL().a(this.kQk.kPQ, eVar2.mUo.pkgVersion(), this.kQk.kQh, new String[0]);
                    Log.i("MicroMsg.WxaPkgDownloaderExportServiceImpl", "startDownloadPkg, onSuccess, request:" + dVar + ", respsonse:" + eVar2);
                    u.b bVar = this.kQk.kQe;
                    if (bVar != null) {
                        if (a2 == null) {
                            p.hyc();
                        }
                        bVar.a(a2, eVar2.mUo.pkgPath());
                    }
                    kotlin.x xVar = kotlin.x.SXb;
                    AppMethodBeat.o(228077);
                    return xVar;
                }
            }, new m<x.a, String, kotlin.x>(this) {
                /* class com.tencent.mm.plugin.appbrand.appcache.predownload.export.b.c.AnonymousClass2 */
                final /* synthetic */ c kQk;

                {
                    this.kQk = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                @Override // kotlin.g.a.m
                public final /* synthetic */ kotlin.x invoke(x.a aVar, String str) {
                    AppMethodBeat.i(228078);
                    x.a aVar2 = aVar;
                    String str2 = str;
                    p.h(aVar2, "err");
                    Log.e("MicroMsg.WxaPkgDownloaderExportServiceImpl", "startDownloadPkg, onError, request:" + dVar + ", errCode:" + aVar2.code + ", errMsg:" + str2);
                    u.a aVar3 = this.kQk.kQf;
                    if (aVar3 != null) {
                        aVar3.onError(aVar2.code, str2);
                    }
                    kotlin.x xVar = kotlin.x.SXb;
                    AppMethodBeat.o(228078);
                    return xVar;
                }
            }, null, null, acc, null, 184);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(228079);
            return xVar;
        }
    }
}
