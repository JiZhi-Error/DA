package com.tencent.mm.plugin.appbrand.launching;

import android.util.Pair;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgIntegrityChecker;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaPluginPkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.a.b;
import com.tencent.mm.plugin.appbrand.appcache.ad;
import com.tencent.mm.plugin.appbrand.appcache.ba;
import com.tencent.mm.plugin.appbrand.appcache.bd;
import com.tencent.mm.plugin.appbrand.appcache.bh;
import com.tencent.mm.plugin.appbrand.appcache.bj;
import com.tencent.mm.plugin.appbrand.appcache.bk;
import com.tencent.mm.plugin.appbrand.appcache.bl;
import com.tencent.mm.plugin.appbrand.appcache.bt;
import com.tencent.mm.plugin.appbrand.appcache.j;
import com.tencent.mm.plugin.appbrand.launching.x;
import com.tencent.mm.plugin.appbrand.launching.y;
import com.tencent.mm.protocal.protobuf.acc;
import com.tencent.mm.protocal.protobuf.bmm;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001d2\u00020\u0001:\u0003\u001d\u001e\u001fBo\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u001a\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\u00070\t\u0012\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010\u0014J\u0006\u0010\u0019\u001a\u00020\u0007J\b\u0010\u001a\u001a\u00020\u0007H\u0002J\f\u0010\u001b\u001a\u00020\n*\u00020\u001cH\u0002R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\"\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\u00070\tX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00070\u0005X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X.¢\u0006\u0002\n\u0000¨\u0006 "}, hxF = {"Lcom/tencent/mm/plugin/appbrand/launching/CommonPkgFetcher;", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher;", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Request;", "onSuccess", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Response;", "", "onError", "Lkotlin/Function2;", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$ERROR;", "", "onProgress", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgLoadProgress;", "cgiExecutor", "Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor;", "cgiCommRequestSource", "Lcom/tencent/mm/protocal/protobuf/CommRequestSource;", "reporter", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$IReporter;", "(Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Request;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor;Lcom/tencent/mm/protocal/protobuf/CommRequestSource;Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$IReporter;)V", "queryKey", "Lcom/tencent/mm/plugin/appbrand/appcache/PkgQueryKey;", "storage", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgStorage;", "start", "waitForDownload", "toERROR", "Lcom/tencent/mm/plugin/appbrand/appcache/base/IWxaPkgDownloader$IWxaPkgUpdateCallback$RetCode;", "Companion", "Downloader", "ResponseAssembler", "plugin-appbrand-integration_release"})
public final class n implements x {
    private static final WxaPkgLoadProgress mTf = new WxaPkgLoadProgress(0, 0, 0);
    @Deprecated
    public static final a mTg = new a((byte) 0);
    private final acc mSK;
    private final kotlin.g.a.b<WxaPkgLoadProgress, x> mSN;
    private final kotlin.g.a.b<x.e, kotlin.x> mSY;
    private final ad mSZ = this.mTb.bNz();
    private bh mTa;
    private final x.d mTb;
    private final m<x.a, String, kotlin.x> mTc;
    private final y mTd;
    private final x.c mTe;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Response;", "invoke"})
    static final class d extends q implements kotlin.g.a.b<x.e, kotlin.x> {
        final /* synthetic */ kotlin.g.a.b lza;
        final /* synthetic */ n mTh;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(n nVar, kotlin.g.a.b bVar) {
            super(1);
            this.mTh = nVar;
            this.lza = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.x invoke(x.e eVar) {
            AppMethodBeat.i(180507);
            x.e eVar2 = eVar;
            p.h(eVar2, LocaleUtil.ITALIAN);
            this.lza.invoke(eVar2);
            if (eVar2.mUp == x.f.CACHED) {
                x.c cVar = this.mTh.mTe;
                if (cVar != null) {
                    cVar.b(this.mTh.mTb, eVar2);
                }
            } else {
                x.c cVar2 = this.mTh.mTe;
                if (cVar2 != null) {
                    cVar2.c(this.mTh.mTb, eVar2);
                }
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(180507);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003j\u0002`\u0005H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, hxF = {"<anonymous>", "", "urls", "", "Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlRespItem;", "Lcom/tencent/mm/plugin/appbrand/launching/LocalUnifiedGetDownloadUrlResp;", "invoke", "([Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlRespItem;)V"})
    public static final class f extends q implements kotlin.g.a.b<bmm[], kotlin.x> {
        final /* synthetic */ n mTh;
        final /* synthetic */ y.b mTt;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(n nVar, y.b bVar) {
            super(1);
            this.mTh = nVar;
            this.mTt = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.x invoke(bmm[] bmmArr) {
            bd bdVar;
            AppMethodBeat.i(180510);
            bmm[] bmmArr2 = bmmArr;
            p.h(bmmArr2, "urls");
            bmm bmm = bmmArr2[0];
            if (bmm == null) {
                new a(this).invoke();
            } else {
                if (this.mTt.mUx) {
                    bl blVar = (bl) com.tencent.mm.plugin.appbrand.app.n.W(bl.class);
                    String str = bmm.LVf.dNI;
                    p.g(str, "resp.req_package_info.appid");
                    int i2 = bmm.KXD;
                    String str2 = bmm.LVn;
                    p.h(str, "id");
                    if (str2 == null) {
                        Log.e("Luggage.WxaPluginCodeVersionInfoStorage", "setPluginStringVersion with id:" + str + ", version:" + i2 + ", invalid stringVersion");
                    } else {
                        bk bkVar = new bk();
                        bkVar.field_pluginAppID = str;
                        bkVar.field_pluginAppVersion = i2;
                        bkVar.field_pluginStringVersion = str2;
                        Log.i("Luggage.WxaPluginCodeVersionInfoStorage", "setPluginStringVersion id:" + str + " version:" + i2 + " stringVersion:" + str2 + " updated:" + ((Boolean) blVar.s(new bl.b(blVar, bkVar))).booleanValue());
                    }
                }
                bd a2 = n.f(this.mTh).a(this.mTh.mSZ.toString(), bmm.KXD, this.mTh.mTb.iOo, new String[0]);
                if (a2 == null) {
                    bd bdVar2 = new bd();
                    bdVar2.field_appId = this.mTh.mSZ.toString();
                    bdVar2.field_version = 0;
                    bdVar2.field_debugType = this.mTh.mTb.iOo;
                    bdVar = bdVar2;
                } else {
                    bdVar = a2;
                }
                p.g(bdVar, "storage.getManifest(quer…ype\n                    }");
                String str3 = bdVar.field_versionMd5;
                String str4 = bdVar.field_NewMd5;
                String str5 = bdVar.field_versionMd5;
                if (str5 == null || str5.length() == 0) {
                    bdVar.field_versionMd5 = bmm.md5;
                }
                bdVar.field_NewMd5 = bmm.md5;
                bdVar.field_version = bmm.KXD;
                bdVar.field_downloadURL = bmm.url;
                bdVar.field_createTime = Util.nowSecond();
                boolean b2 = n.f(this.mTh).b(bdVar);
                a unused = n.mTg;
                Log.i("MicroMsg.AppBrand.CommonPkgFetcher", "cgiExecutor.onSuccess, updated(" + b2 + ") md5(" + str3 + '|' + str4 + ")->(" + bdVar.field_versionMd5 + '|' + bdVar.field_NewMd5 + ") with key(" + bdVar.field_appId + "), versionType(" + bdVar.field_debugType + "), version(" + bdVar.field_version + ')');
                if (this.mTt.mUx) {
                    Pair<WxaPkgIntegrityChecker.a, WxaPkgWrappingInfo> D = WxaPkgIntegrityChecker.D(bdVar.field_appId, bdVar.field_debugType, bdVar.field_version);
                    p.h(D, "$this$component1");
                    WxaPkgIntegrityChecker.a aVar = (WxaPkgIntegrityChecker.a) D.first;
                    p.h(D, "$this$component2");
                    WxaPkgWrappingInfo wxaPkgWrappingInfo = (WxaPkgWrappingInfo) D.second;
                    if (wxaPkgWrappingInfo != null) {
                        a unused2 = n.mTg;
                        Log.i("MicroMsg.AppBrand.CommonPkgFetcher", "cgiExecutor.onSuccess, latest request already cached, request=" + this.mTh.mTb + ", version:" + wxaPkgWrappingInfo.pkgVersion() + " md5:" + wxaPkgWrappingInfo.checksumMd5() + " path:" + wxaPkgWrappingInfo.pkgPath());
                        kotlin.g.a.b bVar = this.mTh.mSY;
                        c cVar = c.mTs;
                        x.d dVar = this.mTh.mTb;
                        String str6 = wxaPkgWrappingInfo.pkgPath;
                        p.g(str6, "pkg.pkgPath");
                        bVar.invoke(c.a(dVar, str6, wxaPkgWrappingInfo.md5, bdVar.field_version, x.f.CACHED));
                    } else {
                        a unused3 = n.mTg;
                        Log.i("MicroMsg.AppBrand.CommonPkgFetcher", "cgiExecutor.onSuccess, latest request find cached pkg with error:" + aVar + " request:" + this.mTh.mTb);
                        if (aVar == WxaPkgIntegrityChecker.a.ENV_ERR || aVar == WxaPkgIntegrityChecker.a.APP_MANIFEST_NULL) {
                            this.mTh.mTc.invoke(x.a.ENV_ERR, "find cached pkg failed");
                        }
                    }
                }
                c cVar2 = c.mTs;
                x.e a3 = c.a(this.mTh.mTb, bdVar);
                if (a3 != null) {
                    this.mTh.mSY.invoke(a3);
                } else {
                    new b().a(this.mTt, bmmArr2);
                }
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(180510);
            return xVar;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class a extends q implements kotlin.g.a.a<kotlin.x> {
            final /* synthetic */ f mTu;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(f fVar) {
                super(0);
                this.mTu = fVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ kotlin.x invoke() {
                AppMethodBeat.i(180509);
                a unused = n.mTg;
                Log.e("MicroMsg.AppBrand.CommonPkgFetcher", "cgiExecutor.onSuccess get NULL normal item with " + this.mTu.mTh.mTb);
                this.mTu.mTh.mTc.invoke(x.a.FAILED, "get invalid url");
                kotlin.x xVar = kotlin.x.SXb;
                AppMethodBeat.o(180509);
                return xVar;
            }
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "invoke"})
    public static final class g extends q implements kotlin.g.a.q<Integer, Integer, String, kotlin.x> {
        final /* synthetic */ n mTh;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(n nVar) {
            super(3);
            this.mTh = nVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.q
        public final /* synthetic */ kotlin.x d(Integer num, Integer num2, String str) {
            AppMethodBeat.i(180511);
            int intValue = num.intValue();
            this.mTh.mTc.invoke(x.a.CGI_GET_URL_FAILED, "(" + intValue + ',' + num2.intValue() + ") " + Util.nullAsNil(str));
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(180511);
            return xVar;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlin.g.a.m<? super com.tencent.mm.plugin.appbrand.launching.x$a, ? super java.lang.String, kotlin.x> */
    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: kotlin.g.a.b<? super com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress, kotlin.x> */
    /* JADX WARN: Multi-variable type inference failed */
    public n(x.d dVar, kotlin.g.a.b<? super x.e, kotlin.x> bVar, m<? super x.a, ? super String, kotlin.x> mVar, kotlin.g.a.b<? super WxaPkgLoadProgress, kotlin.x> bVar2, y yVar, acc acc, x.c cVar) {
        p.h(dVar, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        p.h(bVar, "onSuccess");
        p.h(mVar, "onError");
        p.h(bVar2, "onProgress");
        p.h(yVar, "cgiExecutor");
        p.h(acc, "cgiCommRequestSource");
        AppMethodBeat.i(228646);
        this.mTb = dVar;
        this.mTc = mVar;
        this.mSN = bVar2;
        this.mTd = yVar;
        this.mSK = acc;
        this.mTe = cVar;
        this.mSY = new d(this, bVar);
        AppMethodBeat.o(228646);
    }

    public static final /* synthetic */ bh f(n nVar) {
        AppMethodBeat.i(180521);
        bh bhVar = nVar.mTa;
        if (bhVar == null) {
            p.btv("storage");
        }
        AppMethodBeat.o(180521);
        return bhVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0053, code lost:
        if (r0 == null) goto L_0x0055;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00aa, code lost:
        if (r0 != null) goto L_0x00ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00ac, code lost:
        r4 = r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void start() {
        /*
        // Method dump skipped, instructions count: 825
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.launching.n.start():void");
    }

    private final void bNu() {
        WxaPkgWrappingInfo abZ;
        int i2;
        String str = null;
        int i3 = 0;
        AppMethodBeat.i(180513);
        x.c cVar = this.mTe;
        if (cVar != null) {
            cVar.b(this.mTb);
        }
        y.b bVar = new y.b();
        bVar.setAppId(this.mTb.appId);
        int i4 = this.mTb.packageType;
        int[] iArr = com.tencent.mm.cp.a.Rxb;
        p.g(iArr, "ConstantsWxaPackageProto…_INTEGRATED_PACKAGE_TYPES");
        if (!kotlin.a.e.contains(iArr, i4)) {
            int[] iArr2 = com.tencent.mm.cp.a.Rxa;
            p.g(iArr2, "ConstantsWxaPackageProto….PLUGINCODE_PACKAGE_TYPES");
            if (!kotlin.a.e.contains(iArr2, i4)) {
                str = this.mTb.cBp;
            }
        }
        bVar.cBp = str;
        bVar.packageType = this.mTb.packageType;
        bVar.iOo = this.mTb.iOo;
        if (j.a.vP(this.mTb.iOo)) {
            int[] iArr3 = com.tencent.mm.cp.a.Rxa;
            p.g(iArr3, "ConstantsWxaPackageProto….PLUGINCODE_PACKAGE_TYPES");
            if (!kotlin.a.e.contains(iArr3, this.mTb.packageType)) {
                abZ = m.abZ(this.mSZ.toString());
            } else if (bVar.mUx) {
                abZ = m.bS(this.mSZ.toString(), 0);
            } else {
                if (this.mTb.mUl instanceof x.g.b) {
                    i2 = ((x.g.b) this.mTb.mUl).version;
                } else {
                    i2 = 0;
                }
                abZ = m.bT(this.mSZ.toString(), i2);
            }
            if (abZ != null) {
                bVar.mUv = abZ.pkgVersion;
                bVar.mUu = WxaPkg.Vg(abZ.pkgPath());
            }
        }
        if (!this.mTb.mUm) {
            i3 = 1;
        }
        bVar.mUu = i3;
        x.g gVar = this.mTb.mUl;
        if (gVar instanceof x.g.b) {
            bVar.appVersion = ((x.g.b) gVar).version;
        } else if (gVar instanceof x.g.a) {
            bVar.appVersion = ((x.g.a) gVar).version;
            bVar.mUx = true;
        }
        y.a.a(this.mTd, bVar, new f(this, bVar), new g(this), this.mSK);
        AppMethodBeat.o(180513);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/launching/CommonPkgFetcher$ResponseAssembler;", "", "()V", "makeResponse", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Response;", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Request;", "wxaPkgFilePath", "", "wxaPkgFileMd5", "appVersion", "", "source", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$SOURCE;", "makeResponseByReusableLocalPkg", "record", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgManifestRecord;", "plugin-appbrand-integration_release"})
    public static final class c {
        public static final c mTs = new c();

        static {
            AppMethodBeat.i(228645);
            AppMethodBeat.o(228645);
        }

        private c() {
        }

        public static x.e a(x.d dVar, bd bdVar) {
            AppMethodBeat.i(228643);
            p.h(dVar, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
            p.h(bdVar, "record");
            ad bNz = dVar.bNz();
            bh buL = com.tencent.mm.plugin.appbrand.app.n.buL();
            if ((dVar.mUl instanceof x.g.b) && j.a.vP(dVar.iOo)) {
                String str = bdVar.field_versionMd5;
                if (str == null || str.length() == 0) {
                    a unused = n.mTg;
                    Log.e("MicroMsg.AppBrand.CommonPkgFetcher", "makeResponseByReusableLocalPkg record.md5 is EMPTY, request=".concat(String.valueOf(dVar)));
                    AppMethodBeat.o(228643);
                    return null;
                }
                bd a2 = m.a(bNz, dVar.iOo, ((x.g.b) dVar.mUl).version, new String[]{bdVar.field_versionMd5, bdVar.field_NewMd5});
                if (a2 != null) {
                    String aT = ba.aT(bNz.toString(), ((x.g.b) dVar.mUl).version);
                    s.nw(a2.field_pkgPath, aT);
                    buL.e(bNz.toString(), dVar.iOo, ((x.g.b) dVar.mUl).version, aT);
                    p.g(aT, "targetPkgPath");
                    x.e a3 = a(dVar, aT, null, ((x.g.b) dVar.mUl).version, x.f.CACHED);
                    AppMethodBeat.o(228643);
                    return a3;
                }
            }
            AppMethodBeat.o(228643);
            return null;
        }

        public static x.e a(x.d dVar, String str, String str2, int i2, x.f fVar) {
            boolean z;
            ModulePkgInfo modulePkgInfo;
            boolean z2 = false;
            AppMethodBeat.i(228644);
            p.h(dVar, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
            p.h(str, "wxaPkgFilePath");
            p.h(fVar, "source");
            int[] iArr = com.tencent.mm.cp.a.Rxa;
            p.g(iArr, "ConstantsWxaPackageProto….PLUGINCODE_PACKAGE_TYPES");
            if (kotlin.a.e.contains(iArr, dVar.packageType)) {
                WxaPluginPkgInfo wxaPluginPkgInfo = new WxaPluginPkgInfo();
                wxaPluginPkgInfo.pkgPath = str;
                wxaPluginPkgInfo.provider = dVar.appId;
                wxaPluginPkgInfo.version = i2;
                String str3 = str2;
                if (str3 == null || str3.length() == 0) {
                    z2 = true;
                }
                if (z2) {
                    str2 = WxaPkgIntegrityChecker.Vn(str);
                }
                wxaPluginPkgInfo.md5 = str2;
                String str4 = wxaPluginPkgInfo.provider;
                p.g(str4, "provider");
                wxaPluginPkgInfo.stringVersion = ((bl) com.tencent.mm.plugin.appbrand.app.n.W(bl.class)).ba(str4, wxaPluginPkgInfo.version);
                modulePkgInfo = wxaPluginPkgInfo;
            } else {
                ModulePkgInfo modulePkgInfo2 = new ModulePkgInfo();
                modulePkgInfo2.pkgPath = str;
                modulePkgInfo2.name = dVar.cBp;
                String str5 = str2;
                if (str5 == null || str5.length() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    str2 = WxaPkgIntegrityChecker.Vn(str);
                }
                modulePkgInfo2.md5 = str2;
                modulePkgInfo2.pkgVersion = i2;
                modulePkgInfo = modulePkgInfo2;
            }
            x.e eVar = new x.e(modulePkgInfo, fVar);
            AppMethodBeat.o(228644);
            return eVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J*\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J#\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00122\u000e\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u0014¢\u0006\u0002\u0010\u0015¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/launching/CommonPkgFetcher$Downloader;", "", "(Lcom/tencent/mm/plugin/appbrand/launching/CommonPkgFetcher;)V", "onPkgUpdateProgress", "", "progressInfo", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgLoadProgress;", "onPkgUpdateResult", "appId", "", "errCode", "Lcom/tencent/mm/plugin/appbrand/appcache/base/IWxaPkgDownloader$IWxaPkgUpdateCallback$RetCode;", "response", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgUpdater$Response;", "urlInfo", "Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlRespItem;", "start", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor$LocalUnifiedGetDownloadUrlRequest;", "urls", "", "(Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor$LocalUnifiedGetDownloadUrlRequest;[Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlRespItem;)V", "plugin-appbrand-integration_release"})
    final class b {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public b() {
        }

        public final void a(y.b bVar, bmm[] bmmArr) {
            String str;
            AppMethodBeat.i(228640);
            p.h(bVar, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
            p.h(bmmArr, "urls");
            a unused = n.mTg;
            Log.i("MicroMsg.AppBrand.CommonPkgFetcher", "Downloader.start, print urls --START--");
            int length = bmmArr.length;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                bmm bmm = bmmArr[i2];
                int i4 = i3 + 1;
                a unused2 = n.mTg;
                StringBuilder append = new StringBuilder("Downloader.start, print url, index:").append(i3).append(", item:{url:");
                if (bmm != null) {
                    str = bmm.url;
                } else {
                    str = null;
                }
                Log.i("MicroMsg.AppBrand.CommonPkgFetcher", append.append(str).append(", md5:").append(bmm != null ? bmm.md5 : null).append(", app_version:").append(bmm != null ? Integer.valueOf(bmm.KXD) : null).append(", is_patch:").append(bmm != null ? bmm.LVl : false).append(", is_zstd:").append(bmm != null ? bmm.LVm : false).append('}').toString());
                i2++;
                i3 = i4;
            }
            a unused3 = n.mTg;
            Log.i("MicroMsg.AppBrand.CommonPkgFetcher", "Downloader.start, print urls --END--");
            kotlin.g.a.b bVar2 = n.this.mSN;
            a unused4 = n.mTg;
            bVar2.invoke(n.mTf);
            com.tencent.mm.vending.h.d.LOGIC.arrange(new a(this, bVar, bmmArr));
            AppMethodBeat.o(228640);
        }

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        public static final class a implements Runnable {
            final /* synthetic */ b mTi;
            final /* synthetic */ y.b mTj;
            final /* synthetic */ bmm[] mTk;

            a(b bVar, y.b bVar2, bmm[] bmmArr) {
                this.mTi = bVar;
                this.mTj = bVar2;
                this.mTk = bmmArr;
            }

            public final /* synthetic */ void run() {
                final int i2;
                AppMethodBeat.i(228639);
                if (this.mTj.mUx) {
                    bmm bmm = (bmm) kotlin.a.e.f(this.mTk, 0);
                    if (bmm != null) {
                        i2 = bmm.KXD;
                    } else {
                        new C0741a(this).invoke();
                        AppMethodBeat.o(228639);
                        return;
                    }
                } else {
                    i2 = this.mTj.appVersion;
                }
                final b.a.EnumC0543a[] aVarArr = {b.a.EnumC0543a.OK, b.a.EnumC0543a.ENV_ERR, b.a.EnumC0543a.DISK_FULL};
                com.tencent.mm.vending.g.g.hdG().c(new com.tencent.mm.vending.c.a<_Ret, _Var>(this) {
                    /* class com.tencent.mm.plugin.appbrand.launching.n.b.a.AnonymousClass1 */
                    final /* synthetic */ a mTl;

                    {
                        this.mTl = r1;
                    }

                    @Override // com.tencent.mm.vending.c.a
                    public final /* synthetic */ Object call(Object obj) {
                        AppMethodBeat.i(228630);
                        if (this.mTl.mTk[2] != null) {
                            bmm bmm = this.mTl.mTk[2];
                            if (bmm == null) {
                                p.hyc();
                            }
                            String str = bmm.url;
                            if (!(str == null || str.length() == 0)) {
                                final com.tencent.mm.vending.g.b hdH = com.tencent.mm.vending.g.g.hdH();
                                a unused = n.mTg;
                                Log.i("MicroMsg.AppBrand.CommonPkgFetcher", "Downloader.tryPatch with " + this.mTl.mTj);
                                String adVar = n.this.mSZ.toString();
                                int i2 = this.mTl.mTj.mUv;
                                int i3 = i2;
                                bmm bmm2 = this.mTl.mTk[2];
                                if (bmm2 == null) {
                                    p.hyc();
                                }
                                com.tencent.mm.plugin.appbrand.appcache.s.a(adVar, i2, i3, bmm2.url, new bj.a(this) {
                                    /* class com.tencent.mm.plugin.appbrand.launching.n.b.a.AnonymousClass1.AnonymousClass1 */
                                    final /* synthetic */ AnonymousClass1 mTo;

                                    {
                                        this.mTo = r1;
                                    }

                                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.String, com.tencent.mm.plugin.appbrand.appcache.a.b$a$a, java.lang.Object] */
                                    @Override // com.tencent.mm.plugin.appbrand.appcache.a.b.a
                                    public final /* synthetic */ void a(String str, b.a.EnumC0543a aVar, bj.b bVar) {
                                        AppMethodBeat.i(228629);
                                        bj.b bVar2 = bVar;
                                        p.h(str, "appId");
                                        p.h(aVar, "errCode");
                                        if (kotlin.a.e.contains(aVarArr, aVar)) {
                                            b bVar3 = this.mTo.mTl.mTi;
                                            bmm bmm = this.mTo.mTl.mTk[2];
                                            if (bmm == null) {
                                                p.hyc();
                                            }
                                            b.a(bVar3, aVar, bVar2, bmm);
                                            hdH.ej(null);
                                            AppMethodBeat.o(228629);
                                            return;
                                        }
                                        hdH.resume();
                                        AppMethodBeat.o(228629);
                                    }

                                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                                    @Override // com.tencent.mm.plugin.appbrand.appcache.a.b.a
                                    public final /* synthetic */ void cr(WxaPkgLoadProgress wxaPkgLoadProgress) {
                                        AppMethodBeat.i(228628);
                                        WxaPkgLoadProgress wxaPkgLoadProgress2 = wxaPkgLoadProgress;
                                        p.h(wxaPkgLoadProgress2, "progressInfo");
                                        b.a(this.mTo.mTl.mTi, wxaPkgLoadProgress2);
                                        AppMethodBeat.o(228628);
                                    }
                                });
                            }
                        }
                        kotlin.x xVar = kotlin.x.SXb;
                        AppMethodBeat.o(228630);
                        return xVar;
                    }
                }).c(new com.tencent.mm.vending.c.a<_Ret, _Var>(this) {
                    /* class com.tencent.mm.plugin.appbrand.launching.n.b.a.AnonymousClass2 */
                    final /* synthetic */ a mTl;

                    {
                        this.mTl = r1;
                    }

                    @Override // com.tencent.mm.vending.c.a
                    public final /* synthetic */ Object call(Object obj) {
                        AppMethodBeat.i(228633);
                        if (this.mTl.mTk[1] != null) {
                            bmm bmm = this.mTl.mTk[1];
                            if (bmm == null) {
                                p.hyc();
                            }
                            String str = bmm.url;
                            if (!(str == null || str.length() == 0)) {
                                final com.tencent.mm.vending.g.b hdH = com.tencent.mm.vending.g.g.hdH();
                                a unused = n.mTg;
                                Log.i("MicroMsg.AppBrand.CommonPkgFetcher", "Downloader.tryZstd with " + this.mTl.mTj);
                                bmm bmm2 = this.mTl.mTk[1];
                                if (bmm2 == null) {
                                    p.hyc();
                                }
                                bt.a(bmm2.url, n.this.mSZ.toString(), i2, this.mTl.mTj.iOo, new bj.a(this) {
                                    /* class com.tencent.mm.plugin.appbrand.launching.n.b.a.AnonymousClass2.AnonymousClass1 */
                                    final /* synthetic */ AnonymousClass2 mTp;

                                    {
                                        this.mTp = r1;
                                    }

                                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.String, com.tencent.mm.plugin.appbrand.appcache.a.b$a$a, java.lang.Object] */
                                    @Override // com.tencent.mm.plugin.appbrand.appcache.a.b.a
                                    public final /* synthetic */ void a(String str, b.a.EnumC0543a aVar, bj.b bVar) {
                                        AppMethodBeat.i(228632);
                                        bj.b bVar2 = bVar;
                                        p.h(str, "appId");
                                        p.h(aVar, "errCode");
                                        if (kotlin.a.e.contains(aVarArr, aVar)) {
                                            b bVar3 = this.mTp.mTl.mTi;
                                            bmm bmm = this.mTp.mTl.mTk[1];
                                            if (bmm == null) {
                                                p.hyc();
                                            }
                                            b.a(bVar3, aVar, bVar2, bmm);
                                            hdH.ej(null);
                                            AppMethodBeat.o(228632);
                                            return;
                                        }
                                        hdH.resume();
                                        AppMethodBeat.o(228632);
                                    }

                                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                                    @Override // com.tencent.mm.plugin.appbrand.appcache.a.b.a
                                    public final /* synthetic */ void cr(WxaPkgLoadProgress wxaPkgLoadProgress) {
                                        AppMethodBeat.i(228631);
                                        WxaPkgLoadProgress wxaPkgLoadProgress2 = wxaPkgLoadProgress;
                                        p.h(wxaPkgLoadProgress2, "progressInfo");
                                        b.a(this.mTp.mTl.mTi, wxaPkgLoadProgress2);
                                        AppMethodBeat.o(228631);
                                    }
                                });
                            }
                        }
                        kotlin.x xVar = kotlin.x.SXb;
                        AppMethodBeat.o(228633);
                        return xVar;
                    }
                }).c(new com.tencent.mm.vending.c.a<_Ret, _Var>(this) {
                    /* class com.tencent.mm.plugin.appbrand.launching.n.b.a.AnonymousClass3 */
                    final /* synthetic */ a mTl;

                    {
                        this.mTl = r1;
                    }

                    @Override // com.tencent.mm.vending.c.a
                    public final /* synthetic */ Object call(Object obj) {
                        boolean z;
                        AppMethodBeat.i(228636);
                        bmm bmm = this.mTl.mTk[0];
                        if (bmm == null) {
                            p.hyc();
                        }
                        String str = bmm.url;
                        if (str == null || str.length() == 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z) {
                            Object invoke = n.this.mTc.invoke(x.a.FAILED, "invalid url");
                            AppMethodBeat.o(228636);
                            return invoke;
                        }
                        a unused = n.mTg;
                        Log.i("MicroMsg.AppBrand.CommonPkgFetcher", "Downloader.fallbackLegacy with " + this.mTl.mTj);
                        String adVar = n.this.mSZ.toString();
                        int i2 = this.mTl.mTj.iOo;
                        int i3 = i2;
                        bmm bmm2 = this.mTl.mTk[0];
                        if (bmm2 == null) {
                            p.hyc();
                        }
                        Boolean valueOf = Boolean.valueOf(bj.c(adVar, i2, i3, bmm2.url, new bj.a(this) {
                            /* class com.tencent.mm.plugin.appbrand.launching.n.b.a.AnonymousClass3.AnonymousClass1 */
                            final /* synthetic */ AnonymousClass3 mTq;

                            /* JADX WARN: Incorrect args count in method signature: ()V */
                            {
                                this.mTq = r1;
                            }

                            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.String, com.tencent.mm.plugin.appbrand.appcache.a.b$a$a, java.lang.Object] */
                            @Override // com.tencent.mm.plugin.appbrand.appcache.a.b.a
                            public final /* synthetic */ void a(String str, b.a.EnumC0543a aVar, bj.b bVar) {
                                AppMethodBeat.i(228635);
                                bj.b bVar2 = bVar;
                                p.h(str, "appId");
                                p.h(aVar, "errCode");
                                b bVar3 = this.mTq.mTl.mTi;
                                bmm bmm = this.mTq.mTl.mTk[0];
                                if (bmm == null) {
                                    p.hyc();
                                }
                                b.a(bVar3, aVar, bVar2, bmm);
                                AppMethodBeat.o(228635);
                            }

                            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                            @Override // com.tencent.mm.plugin.appbrand.appcache.a.b.a
                            public final /* synthetic */ void cr(WxaPkgLoadProgress wxaPkgLoadProgress) {
                                AppMethodBeat.i(228634);
                                WxaPkgLoadProgress wxaPkgLoadProgress2 = wxaPkgLoadProgress;
                                p.h(wxaPkgLoadProgress2, "progressInfo");
                                b.a(this.mTq.mTl.mTi, wxaPkgLoadProgress2);
                                AppMethodBeat.o(228634);
                            }
                        }));
                        AppMethodBeat.o(228636);
                        return valueOf;
                    }
                }).a(AnonymousClass4.mTr);
                AppMethodBeat.o(228639);
            }

            @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
            /* renamed from: com.tencent.mm.plugin.appbrand.launching.n$b$a$a  reason: collision with other inner class name */
            static final class C0741a extends q implements kotlin.g.a.a<kotlin.x> {
                final /* synthetic */ a mTl;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                C0741a(a aVar) {
                    super(0);
                    this.mTl = aVar;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ kotlin.x invoke() {
                    AppMethodBeat.i(228638);
                    a unused = n.mTg;
                    Log.e("MicroMsg.AppBrand.CommonPkgFetcher", "Downloader.start, get invalid app_version using needLatestVersion, request=" + this.mTl.mTj);
                    n.this.mTc.invoke(x.a.FAILED, "invalid cgi response");
                    kotlin.x xVar = kotlin.x.SXb;
                    AppMethodBeat.o(228638);
                    return xVar;
                }
            }
        }

        public static final /* synthetic */ void a(b bVar, WxaPkgLoadProgress wxaPkgLoadProgress) {
            AppMethodBeat.i(228641);
            n.this.mSN.invoke(wxaPkgLoadProgress);
            AppMethodBeat.o(228641);
        }

        public static final /* synthetic */ void a(b bVar, b.a.EnumC0543a aVar, bj.b bVar2, bmm bmm) {
            AppMethodBeat.i(228642);
            if (b.a.EnumC0543a.OK == aVar) {
                kotlin.g.a.b bVar3 = n.this.mSY;
                c cVar = c.mTs;
                x.d dVar = n.this.mTb;
                if (bVar2 == null) {
                    p.hyc();
                }
                String str = bVar2.filePath;
                p.g(str, "response!!.filePath");
                bVar3.invoke(c.a(dVar, str, bmm.md5, bmm.KXD, x.f.REMOTE));
                AppMethodBeat.o(228642);
                return;
            }
            n.this.mTc.invoke(n.a(aVar), null);
            AppMethodBeat.o(228642);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/launching/CommonPkgFetcher$Companion;", "", "()V", "DOWNLOAD_START", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgLoadProgress;", "TAG", "", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(180517);
        AppMethodBeat.o(180517);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class e extends q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ n mTh;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(n nVar) {
            super(0);
            this.mTh = nVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(180508);
            this.mTh.mTc.invoke(x.a.ENV_ERR, "get NULL storage");
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(180508);
            return xVar;
        }
    }

    public static final /* synthetic */ x.a a(b.a.EnumC0543a aVar) {
        AppMethodBeat.i(180519);
        x.a[] values = x.a.values();
        for (x.a aVar2 : values) {
            if (aVar2.code == aVar.bwv()) {
                AppMethodBeat.o(180519);
                return aVar2;
            }
        }
        x.a aVar3 = x.a.FAILED;
        AppMethodBeat.o(180519);
        return aVar3;
    }
}
