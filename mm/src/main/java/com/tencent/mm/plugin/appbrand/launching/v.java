package com.tencent.mm.plugin.appbrand.launching;

import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg;
import com.tencent.mm.plugin.appbrand.appcache.ad;
import com.tencent.mm.plugin.appbrand.appcache.bd;
import com.tencent.mm.plugin.appbrand.launching.y;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.protocal.protobuf.acc;
import com.tencent.mm.protocal.protobuf.bml;
import com.tencent.mm.protocal.protobuf.bmm;
import com.tencent.mm.protocal.protobuf.bwb;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.protocal.protobuf.byy;
import com.tencent.mm.protocal.protobuf.byz;
import com.tencent.mm.protocal.protobuf.cju;
import com.tencent.mm.protocal.protobuf.doo;
import com.tencent.mm.protocal.protobuf.km;
import com.tencent.mm.protocal.protobuf.kn;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.vfs.s;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001+B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u000b\u001a\u00020\f2\u001e\u0010\r\u001a\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0010\u0012\u000e\u0012\u0006\u0012\u0004\u0018\u00010\t0\bj\u0002`\n0\u000eJ\u000e\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0007J\\\u0010\u0011\u001a\u00020\f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u00132\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\f0\u00152 \u0010\u0017\u001a\u001c\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\f0\u00182\b\b\u0002\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001cJ^\u0010\u001d\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00072\u001a\u0010\u0014\u001a\u0016\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b\u0012\u0004\u0012\u00020\f0\u00152 \u0010\u0017\u001a\u001c\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\f0\u00182\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J \u0010\u001e\u001a\u0012\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010!0 \u0018\u00010\u001f2\u0006\u0010\"\u001a\u00020#H\u0007J \u0010$\u001a\u0012\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010%0 \u0018\u00010\u001f2\u0006\u0010\"\u001a\u00020&H\u0007J\u0012\u0010'\u001a\b\u0012\u0004\u0012\u00020(0\u0013*\u00020\u0007H\u0002J\f\u0010)\u001a\u00020**\u00020\u0007H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R&\u0010\u0005\u001a\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0010\u0012\u000e\u0012\u0006\u0012\u0004\u0018\u00010\t0\bj\u0002`\n0\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/launching/GetPkgDownloadUrlUnifiedCgiRouter;", "Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor;", "()V", "TAG", "", "mPreGetDownloadUrlResults", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor$LocalUnifiedGetDownloadUrlRequest;", "", "Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlRespItem;", "Lcom/tencent/mm/plugin/appbrand/launching/LocalUnifiedGetDownloadUrlResp;", "addPreGetDownloadUrlResult", "", "map", "", "removePreGetDownloadUrlResult", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "waitForBatchGetDownloadUrl", "inRequestList", "", "onSuccess", "Lkotlin/Function1;", "Lcom/tencent/mm/protocal/protobuf/BatchGetDownloadUrlResponse;", "onError", "Lkotlin/Function3;", "", "scene", "cgiCommRequestSource", "Lcom/tencent/mm/protocal/protobuf/CommRequestSource;", "waitForDownloadUrl", "wormholeForLegacyReleaseCode", "Lcom/tencent/mm/wx/WxPipeline;", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetWxaAppCDNDownloadUrlResponse;", "cgi", "Lcom/tencent/mm/plugin/appbrand/appcache/CgiGetPkgDownloadInfo;", "wormholeForLegacyTestCode", "Lcom/tencent/mm/protocal/protobuf/GetTestCodeDownloadInfoResponse;", "Lcom/tencent/mm/plugin/appbrand/appcache/CgiGetTestCodeDownloadInfo;", "createNewProtocolReqItemList", "Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlReqItem;", "createRequestPackageInfo", "Lcom/tencent/mm/protocal/protobuf/RequestPackageInfo;", "RouterController", "plugin-appbrand-integration_release"})
public final class v implements y {
    private static final ConcurrentHashMap<y.b, bmm[]> mTF = new ConcurrentHashMap<>();
    public static final v mTG = new v();

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"buildBasicItem", "Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlReqItem;", "invoke"})
    public static final class b extends q implements kotlin.g.a.a<bml> {
        final /* synthetic */ y.b mTK;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(y.b bVar) {
            super(0);
            this.mTK = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ bml invoke() {
            AppMethodBeat.i(180532);
            bml bNy = bNy();
            AppMethodBeat.o(180532);
            return bNy;
        }

        public final bml bNy() {
            AppMethodBeat.i(180533);
            bml bml = new bml();
            v vVar = v.mTG;
            bml.LVf = v.c(this.mTK);
            bml.LVh = this.mTK.mUu;
            if (this.mTK.mUx) {
                bml.LVi = true;
            }
            bml.KXD = this.mTK.appVersion;
            o.a(bml);
            AppMethodBeat.o(180533);
            return bml;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, hxF = {"<anonymous>", "", "items", "", "Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlRespItem;", "invoke", "([Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlRespItem;)V"})
    static final class c extends q implements kotlin.g.a.b<bmm[], x> {
        final /* synthetic */ kotlin.g.a.b lza;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(kotlin.g.a.b bVar) {
            super(1);
            this.lza = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(bmm[] bmmArr) {
            AppMethodBeat.i(180534);
            bmm[] bmmArr2 = bmmArr;
            p.h(bmmArr2, "items");
            kotlin.g.a.b bVar = this.lza;
            kn knVar = new kn();
            for (bmm bmm : bmmArr2) {
                if (bmm != null) {
                    knVar.KOG.add(bmm);
                }
            }
            bVar.invoke(knVar);
            x xVar = x.SXb;
            AppMethodBeat.o(180534);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/BatchGetDownloadUrlResponse;", "kotlin.jvm.PlatformType", "call"})
    static final class d<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ kotlin.g.a.b lza;
        final /* synthetic */ LinkedList mTL;
        final /* synthetic */ kotlin.g.a.q mTM;

        d(LinkedList linkedList, kotlin.g.a.b bVar, kotlin.g.a.q qVar) {
            this.mTL = linkedList;
            this.lza = bVar;
            this.mTM = qVar;
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            int i2 = -1;
            AppMethodBeat.i(228652);
            c.a aVar = (c.a) obj;
            if (com.tencent.mm.plugin.appbrand.r.a.d(aVar)) {
                ((kn) aVar.iLC).KOG.addAll(this.mTL);
                kotlin.g.a.b bVar = this.lza;
                T t = aVar.iLC;
                p.g(t, "it.resp");
                bVar.invoke(t);
            } else {
                kotlin.g.a.q qVar = this.mTM;
                Integer valueOf = Integer.valueOf(aVar != null ? aVar.errType : -1);
                if (aVar != null) {
                    i2 = aVar.errCode;
                }
                qVar.d(valueOf, Integer.valueOf(i2), aVar != null ? aVar.errMsg : null);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(228652);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/BatchGetDownloadUrlResponse;", "kotlin.jvm.PlatformType", "call"})
    public static final class e<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ kotlin.g.a.b lza;
        final /* synthetic */ kotlin.g.a.q mTM;
        final /* synthetic */ y.b mTj;

        e(kotlin.g.a.b bVar, y.b bVar2, kotlin.g.a.q qVar) {
            this.lza = bVar;
            this.mTj = bVar2;
            this.mTM = qVar;
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            int i2 = -1;
            AppMethodBeat.i(180536);
            c.a aVar = (c.a) obj;
            if (com.tencent.mm.plugin.appbrand.r.a.d(aVar)) {
                kotlin.g.a.b bVar = this.lza;
                bmm[] a2 = o.a((kn) aVar.iLC, this.mTj);
                if (a2 == null) {
                    p.hyc();
                }
                bVar.invoke(a2);
            } else {
                kotlin.g.a.q qVar = this.mTM;
                Integer valueOf = Integer.valueOf(aVar != null ? aVar.errType : -1);
                if (aVar != null) {
                    i2 = aVar.errCode;
                }
                qVar.d(valueOf, Integer.valueOf(i2), aVar != null ? aVar.errMsg : null);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(180536);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, hxF = {"info", "", "Lcom/tencent/mm/protocal/protobuf/GetWxaAppCDNDownloadUrlRequest;", "invoke"})
    static final class f extends q implements kotlin.g.a.b<byy, String> {
        public static final f mTN = new f();

        static {
            AppMethodBeat.i(180541);
            AppMethodBeat.o(180541);
        }

        f() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ String invoke(byy byy) {
            AppMethodBeat.i(180539);
            String a2 = a(byy);
            AppMethodBeat.o(180539);
            return a2;
        }

        public static String a(byy byy) {
            AppMethodBeat.i(180540);
            p.h(byy, "$this$info");
            String str = "GetWxaAppCDNDownloadUrlRequest(appId:" + byy.dNI + " version:" + byy.KXD + " moduleName:" + byy.MbW + " pacakgeType:" + byy.MbZ + " scene:" + byy.scene + ')';
            AppMethodBeat.o(180540);
            return str;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"makeReqItem", "Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlReqItem;", "invoke"})
    static final class g extends q implements kotlin.g.a.a<bml> {
        final /* synthetic */ com.tencent.mm.plugin.appbrand.appcache.h mTO;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(com.tencent.mm.plugin.appbrand.appcache.h hVar) {
            super(0);
            this.mTO = hVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ bml invoke() {
            AppMethodBeat.i(228653);
            bml bNy = bNy();
            AppMethodBeat.o(228653);
            return bNy;
        }

        public final bml bNy() {
            AppMethodBeat.i(228654);
            bml bml = new bml();
            bml.LVf = new doo();
            bml.LVf.dNI = this.mTO.bvg().dNI;
            bml.KXD = this.mTO.bvg().KXD;
            bml.LVf.MbZ = this.mTO.bvg().MbZ;
            bml.LVf.MbW = this.mTO.bvg().MbW;
            bml.LVh = 0;
            AppMethodBeat.o(228654);
            return bml;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0002 \u0003*\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u00010\u00012*\u0010\u0004\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00050\u0005 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00050\u0005\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetWxaAppCDNDownloadUrlResponse;", "kotlin.jvm.PlatformType", LocaleUtil.ITALIAN, "Lcom/tencent/mm/protocal/protobuf/BatchGetDownloadUrlResponse;", "invoke"})
    static final class h<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ com.tencent.mm.plugin.appbrand.appcache.h mTO;

        h(com.tencent.mm.plugin.appbrand.appcache.h hVar) {
            this.mTO = hVar;
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            int i2 = -1;
            AppMethodBeat.i(228655);
            c.a aVar = (c.a) obj;
            if (!com.tencent.mm.plugin.appbrand.r.a.d(aVar)) {
                int i3 = aVar != null ? aVar.errType : -1;
                if (aVar != null) {
                    i2 = aVar.errCode;
                }
                c.a a2 = c.a.a(i3, i2, aVar != null ? aVar.errMsg : null, null, null, aVar != null ? aVar.iLD : null);
                AppMethodBeat.o(228655);
                return a2;
            }
            LinkedList<bmm> linkedList = ((kn) aVar.iLC).KOG;
            p.g(linkedList, "it.resp.resp_list");
            if (((bmm) kotlin.a.j.kt(linkedList)) == null) {
                StringBuilder sb = new StringBuilder("wormholeForLegacyReleaseCode with ");
                f fVar = f.mTN;
                byy bvg = this.mTO.bvg();
                p.g(bvg, "cgi.request");
                Log.e("MicroMsg.AppBrand.GetPkgDownloadUrlUnifiedCgiRouter", sb.append(f.a(bvg)).append(" useNewCgi=TRUE, get NULL respItem").toString());
                c.a a3 = c.a.a(-1, -1, null, null, null, this.mTO);
                AppMethodBeat.o(228655);
                return a3;
            }
            byz byz = new byz();
            StringBuilder sb2 = new StringBuilder("wormholeForLegacyReleaseCode with ");
            f fVar2 = f.mTN;
            byy bvg2 = this.mTO.bvg();
            p.g(bvg2, "cgi.request");
            Log.i("MicroMsg.AppBrand.GetPkgDownloadUrlUnifiedCgiRouter", sb2.append(f.a(bvg2)).append(", get resp_list.size:").append(((kn) aVar.iLC).KOG.size()).toString());
            LinkedList<bmm> linkedList2 = ((kn) aVar.iLC).KOG;
            p.g(linkedList2, "it.resp.resp_list");
            for (T t : linkedList2) {
                StringBuilder sb3 = new StringBuilder("wormholeForLegacyReleaseCode with ");
                f fVar3 = f.mTN;
                byy bvg3 = this.mTO.bvg();
                p.g(bvg3, "cgi.request");
                Log.i("MicroMsg.AppBrand.GetPkgDownloadUrlUnifiedCgiRouter", sb3.append(f.a(bvg3)).append(", get item[ errcode:").append(t.dIZ).append(", md5:").append(t.md5).append(", is_patch:").append(t.LVl).append(", is_zstd:").append(t.LVm).append(", url:").append(t.url).append(" ]").toString());
                byz.LUr = t.LUr;
                if (t.LVm) {
                    byz.Mep = t.url;
                } else if (t.LVl) {
                    byz.dPS = t.url;
                } else {
                    byz.url = t.url;
                }
            }
            c.a a4 = c.a.a(aVar.errType, aVar.errCode, aVar.errMsg, byz, null, this.mTO);
            AppMethodBeat.o(228655);
            return a4;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, hxF = {"info", "", "Lcom/tencent/mm/protocal/protobuf/GetTestCodeDownloadInfoRequest;", "invoke"})
    public static final class i extends q implements kotlin.g.a.b<bwb, String> {
        public static final i mTP = new i();

        static {
            AppMethodBeat.i(180545);
            AppMethodBeat.o(180545);
        }

        i() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ String invoke(bwb bwb) {
            AppMethodBeat.i(180543);
            String a2 = a(bwb);
            AppMethodBeat.o(180543);
            return a2;
        }

        public static String a(bwb bwb) {
            AppMethodBeat.i(180544);
            p.h(bwb, "$this$info");
            String str = "GetTestCodeDownloadInfoRequest(appId:" + bwb.dNI + " versionType:" + bwb.Lcr + " moduleName:" + bwb.MbW + " packageType:" + bwb.MbZ + ')';
            AppMethodBeat.o(180544);
            return str;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0002 \u0003*\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u00010\u00012*\u0010\u0004\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00050\u0005 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00050\u0005\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetTestCodeDownloadInfoResponse;", "kotlin.jvm.PlatformType", LocaleUtil.ITALIAN, "Lcom/tencent/mm/protocal/protobuf/BatchGetDownloadUrlResponse;", "invoke"})
    public static final class j<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ com.tencent.mm.plugin.appbrand.appcache.i mTQ;

        j(com.tencent.mm.plugin.appbrand.appcache.i iVar) {
            this.mTQ = iVar;
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            int i2 = -1;
            AppMethodBeat.i(180546);
            c.a aVar = (c.a) obj;
            if (!com.tencent.mm.plugin.appbrand.r.a.d(aVar)) {
                int i3 = aVar != null ? aVar.errType : -1;
                if (aVar != null) {
                    i2 = aVar.errCode;
                }
                c.a a2 = c.a.a(i3, i2, aVar != null ? aVar.errMsg : null, null, null, aVar != null ? aVar.iLD : null);
                AppMethodBeat.o(180546);
                return a2;
            }
            LinkedList<bmm> linkedList = ((kn) aVar.iLC).KOG;
            p.g(linkedList, "it.resp.resp_list");
            bmm bmm = (bmm) kotlin.a.j.kt(linkedList);
            if (bmm == null) {
                StringBuilder sb = new StringBuilder("wormholeForLegacyTestCode with ");
                i iVar = i.mTP;
                bwb bvi = this.mTQ.bvi();
                p.g(bvi, "cgi.request");
                Log.e("MicroMsg.AppBrand.GetPkgDownloadUrlUnifiedCgiRouter", sb.append(i.a(bvi)).append(" useNewCgi=TRUE, get NULL respItem").toString());
                c.a a3 = c.a.a(-1, -1, null, null, null, this.mTQ);
                AppMethodBeat.o(180546);
                return a3;
            }
            bwc bwc = new bwc();
            bwc.gqB = bmm.url;
            bwc.error_code = bmm.dIZ;
            c.a a4 = c.a.a(aVar.errType, aVar.errCode, null, bwc, null, this.mTQ);
            AppMethodBeat.o(180546);
            return a4;
        }
    }

    static {
        AppMethodBeat.i(180554);
        AppMethodBeat.o(180554);
    }

    private v() {
    }

    public static void W(Map<y.b, bmm[]> map) {
        AppMethodBeat.i(180547);
        p.h(map, "map");
        mTF.putAll(map);
        AppMethodBeat.o(180547);
    }

    public static void a(y.b bVar) {
        AppMethodBeat.i(180548);
        p.h(bVar, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        mTF.remove(bVar);
        AppMethodBeat.o(180548);
    }

    public static final com.tencent.mm.co.f<c.a<bwc>> a(com.tencent.mm.plugin.appbrand.appcache.i iVar) {
        AppMethodBeat.i(180549);
        p.h(iVar, "cgi");
        a.C0742a aVar = a.mTH;
        i iVar2 = i.mTP;
        StringBuilder sb = new StringBuilder("wormholeForLegacyTestCode with ");
        bwb bvi = iVar.bvi();
        p.g(bvi, "cgi.request");
        Log.i("MicroMsg.AppBrand.GetPkgDownloadUrlUnifiedCgiRouter", sb.append(i.a(bvi)).append(" intercepted").toString());
        bml bml = new bml();
        bml.LVf = new doo();
        bml.LVf.dNI = iVar.bvi().dNI;
        bml.LVf.MbW = iVar.bvi().MbW;
        bml.LVf.MbZ = iVar.bvi().MbZ;
        bml.LVf.KXC = iVar.bvi().Lcr;
        bml.LVh = 0;
        bml.LVk = iVar.bvi().MbY;
        km kmVar = new km();
        kmVar.KOE.add(bml);
        acc acc = new acc();
        acc.LmG = 1;
        kmVar.KOF = acc;
        com.tencent.mm.co.f<_Ret> b2 = new com.tencent.mm.plugin.appbrand.appcache.g(kmVar).aYI().b(new j(iVar));
        AppMethodBeat.o(180549);
        return b2;
    }

    public static final com.tencent.mm.co.f<c.a<byz>> b(com.tencent.mm.plugin.appbrand.appcache.h hVar) {
        AppMethodBeat.i(180550);
        p.h(hVar, "cgi");
        a.C0742a aVar = a.mTH;
        f fVar = f.mTN;
        StringBuilder sb = new StringBuilder("wormholeForLegacyReleaseCode with ");
        byy bvg = hVar.bvg();
        p.g(bvg, "cgi.request");
        Log.i("MicroMsg.AppBrand.GetPkgDownloadUrlUnifiedCgiRouter", sb.append(f.a(bvg)).append(" intercepted").toString());
        g gVar = new g(hVar);
        km kmVar = new km();
        kmVar.KOE.add(gVar.bNy());
        LinkedList<bml> linkedList = kmVar.KOE;
        bml bNy = gVar.bNy();
        bNy.LVj = true;
        linkedList.add(bNy);
        kmVar.scene = hVar.bvg().scene;
        Log.i("MicroMsg.AppBrand.GetPkgDownloadUrlUnifiedCgiRouter", "CgiBatchGetPkgDownloadInfo scene:%d", Integer.valueOf(kmVar.scene));
        if (hVar.bvg().Meg > 0) {
            bd a2 = n.buL().a(new ad(hVar.bvg().dNI, hVar.bvg().MbW, hVar.bvg().MbZ).toString(), hVar.bvg().Meg, 0, "pkgPath");
            String str = a2 != null ? a2.field_pkgPath : null;
            int Vg = s.YS(str) ? WxaPkg.Vg(str) : -1;
            StringBuilder sb2 = new StringBuilder("wormholeForLegacyReleaseCode with ");
            f fVar2 = f.mTN;
            byy bvg2 = hVar.bvg();
            p.g(bvg2, "cgi.request");
            Log.i("MicroMsg.AppBrand.GetPkgDownloadUrlUnifiedCgiRouter", sb2.append(f.a(bvg2)).append(", intercepted, oldPkg.innerVersion=").append(Vg).toString());
            if (Vg == 0) {
                LinkedList<bml> linkedList2 = kmVar.KOE;
                bml bNy2 = gVar.bNy();
                bNy2.LVg = new cju();
                bNy2.LVg.KXD = hVar.bvg().Meg;
                linkedList2.add(bNy2);
            } else {
                com.tencent.mm.plugin.report.service.h.INSTANCE.dN(697, 20);
            }
        }
        acc acc = new acc();
        acc.LmG = 1;
        kmVar.KOF = acc;
        com.tencent.mm.co.f<_Ret> b2 = new com.tencent.mm.plugin.appbrand.appcache.g(kmVar).aYI().b(new h(hVar));
        AppMethodBeat.o(180550);
        return b2;
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [com.tencent.mm.protocal.protobuf.bmm[], java.lang.Object, java.lang.Object[]] */
    @Override // com.tencent.mm.plugin.appbrand.launching.y
    public final void a(y.b bVar, kotlin.g.a.b<? super bmm[], x> bVar2, kotlin.g.a.q<? super Integer, ? super Integer, ? super String, x> qVar, int i2, acc acc) {
        AppMethodBeat.i(228656);
        p.h(bVar, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        p.h(bVar2, "onSuccess");
        p.h(qVar, "onError");
        p.h(acc, "cgiCommRequestSource");
        bmm[] remove = mTF.remove(bVar);
        if (remove != 0) {
            Log.i("MicroMsg.AppBrand.GetPkgDownloadUrlUnifiedCgiRouter", "waitForDownloadUrl, intercepted by PreGet with ".concat(String.valueOf(bVar)));
            p.g(remove, "preGetResp");
            if (kotlin.a.e.f(remove, 0) != null) {
                bVar2.invoke(remove);
                AppMethodBeat.o(228656);
                return;
            }
        }
        if (!bVar.mUx) {
            int[] iArr = com.tencent.mm.cp.a.RwZ;
            p.g(iArr, "ConstantsWxaPackageProto…CGI_SUPPORT_PACKAGE_TYPES");
            if (kotlin.a.e.contains(iArr, bVar.packageType)) {
                a.C0742a aVar = a.mTH;
            }
        }
        Log.i("MicroMsg.AppBrand.GetPkgDownloadUrlUnifiedCgiRouter", "goNewCgi: %b,appId: %s", Boolean.TRUE, bVar.appId);
        km kmVar = new km();
        kmVar.KOE.addAll(b(bVar));
        kmVar.scene = i2;
        kmVar.KOF = acc;
        new com.tencent.mm.plugin.appbrand.appcache.g(kmVar).aYI().j(new e(bVar2, bVar, qVar));
        AppMethodBeat.o(228656);
    }

    public final void a(List<y.b> list, kotlin.g.a.b<? super kn, x> bVar, kotlin.g.a.q<? super Integer, ? super Integer, ? super String, x> qVar, int i2, acc acc) {
        AppMethodBeat.i(228657);
        p.h(list, "inRequestList");
        p.h(bVar, "onSuccess");
        p.h(qVar, "onError");
        p.h(acc, "cgiCommRequestSource");
        if (list.size() == 1) {
            Log.i("MicroMsg.AppBrand.GetPkgDownloadUrlUnifiedCgiRouter", "waitForBatchGetDownloadUrl, use single routine instead, with " + ((y.b) kotlin.a.j.ks(list)));
            a(list.get(0), new c(bVar), qVar, i2, acc);
            AppMethodBeat.o(228657);
            return;
        }
        LinkedList linkedList = new LinkedList();
        LinkedList<y.b> linkedList2 = new LinkedList(list);
        Iterator it = linkedList2.iterator();
        p.g(it, "realRequestList.iterator()");
        while (it.hasNext()) {
            Object next = it.next();
            p.g(next, "iterator.next()");
            y.b bVar2 = (y.b) next;
            bmm[] remove = mTF.remove(bVar2);
            if (remove != null) {
                p.g(remove, "preGetResp");
                if (kotlin.a.e.f(remove, 0) != null) {
                    Log.i("MicroMsg.AppBrand.GetPkgDownloadUrlUnifiedCgiRouter", "waitForBatchGetDownloadUrl, intercepted by PreGet with ".concat(String.valueOf(bVar2)));
                    it.remove();
                    for (bmm bmm : remove) {
                        if (bmm != null) {
                            linkedList.add(bmm);
                        }
                    }
                }
            }
        }
        Log.i("MicroMsg.AppBrand.GetPkgDownloadUrlUnifiedCgiRouter", "waitForBatchGetDownloadUrl, inRequestList.size=" + list.size() + ", realRequestList.size=" + linkedList2.size() + ", preGetRespItemList.size=" + linkedList.size());
        if (linkedList2.size() <= 0) {
            kn knVar = new kn();
            knVar.KOG.addAll(linkedList);
            bVar.invoke(knVar);
            AppMethodBeat.o(228657);
            return;
        }
        km kmVar = new km();
        for (y.b bVar3 : linkedList2) {
            kmVar.KOE.addAll(b(bVar3));
            kmVar.scene = i2;
            kmVar.KOF = acc;
        }
        new com.tencent.mm.plugin.appbrand.appcache.g(kmVar).aYI().j(new d(linkedList, bVar, qVar));
        AppMethodBeat.o(228657);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\bf\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H&¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/launching/GetPkgDownloadUrlUnifiedCgiRouter$RouterController;", "", "useEncryptPkg", "", "isGame", "useNewCgi", "useNewSeparatedPluginCompatibleLogic", "Factory", "plugin-appbrand-integration_release"})
    public interface a {
        public static final C0742a mTH = C0742a.mTJ;

        @l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\b\u0010\u0010\u001a\u00020\u000bH\u0016J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0017R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/launching/GetPkgDownloadUrlUnifiedCgiRouter$RouterController$Factory;", "Lcom/tencent/mm/plugin/appbrand/launching/GetPkgDownloadUrlUnifiedCgiRouter$RouterController;", "()V", "SUPPORTED_PKG_ENCRYPT_VERSION_MAX", "", "TAG", "", "TEST_SWITCH_MMKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "resetTestSwitch", "", "key", "Lcom/tencent/mm/plugin/expt/api/IExptService$ExptEnum;", "useEncryptPkg", "isGame", "useNewCgi", "useNewSeparatedPluginCompatibleLogic", "plugin-appbrand-integration_release"})
        /* renamed from: com.tencent.mm.plugin.appbrand.launching.v$a$a  reason: collision with other inner class name */
        public static final class C0742a implements a {
            private static final MultiProcessMMKV mTI = MultiProcessMMKV.getMMKV("MicroMsg.GetPkgDownloadUrlUnifiedCgiRouter.WECHAT_INSTANCE.TEST_SWITCH_MMKV", 2);
            static final /* synthetic */ C0742a mTJ = new C0742a();

            static {
                AppMethodBeat.i(180531);
                AppMethodBeat.o(180531);
            }

            private C0742a() {
            }

            private static boolean a(b.a aVar) {
                AppMethodBeat.i(228651);
                if (BuildInfo.IS_FLAVOR_RED || BuildInfo.IS_FLAVOR_PURPLE) {
                    Log.i("MicroMsg.GetPkgDownloadUrlUnifiedCgiRouter.WECHAT_INSTANCE", "resetTestSwitch key:" + aVar.name() + ", INTERNAL BUILD, defBool:true");
                    AppMethodBeat.o(228651);
                    return true;
                }
                AppMethodBeat.o(228651);
                return false;
            }

            public static boolean hW(boolean z) {
                boolean a2;
                boolean a3;
                AppMethodBeat.i(180529);
                if (z) {
                    a2 = a(b.a.clicfg_android_wagame_encrypt_wxapkg);
                    a3 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_android_wagame_encrypt_wxapkg, a2);
                } else {
                    a2 = a(b.a.clicfg_android_appbrand_encrypt_wxapkg);
                    a3 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_android_appbrand_encrypt_wxapkg, a2);
                }
                Log.i("MicroMsg.GetPkgDownloadUrlUnifiedCgiRouter.WECHAT_INSTANCE", "useEncryptPkg isGame[" + z + "] exptVal[" + a3 + "] defVal[" + a2 + ']');
                AppMethodBeat.o(180529);
                return a3;
            }
        }
    }

    private static List<bml> b(y.b bVar) {
        AppMethodBeat.i(180553);
        LinkedList linkedList = new LinkedList();
        b bVar2 = new b(bVar);
        bml bNy = bVar2.bNy();
        bNy.LVg = null;
        bNy.LVj = false;
        linkedList.add(bNy);
        bml bNy2 = bVar2.bNy();
        bNy2.LVg = null;
        bNy2.LVj = true;
        linkedList.add(bNy2);
        if (bVar.mUv > 0) {
            bml bNy3 = bVar2.bNy();
            bNy3.LVg = new cju();
            bNy3.LVg.KXD = bVar.mUv;
            bNy3.LVg.Mel = bVar.mUw;
            bNy3.LVj = false;
            linkedList.add(bNy3);
        }
        LinkedList linkedList2 = linkedList;
        AppMethodBeat.o(180553);
        return linkedList2;
    }

    public static final /* synthetic */ doo c(y.b bVar) {
        AppMethodBeat.i(180555);
        doo doo = new doo();
        doo.dNI = bVar.appId;
        int i2 = bVar.packageType;
        int[] iArr = com.tencent.mm.cp.a.Rxb;
        p.g(iArr, "ConstantsWxaPackageProto…_INTEGRATED_PACKAGE_TYPES");
        if (kotlin.a.e.contains(iArr, i2)) {
            doo.MbW = null;
        } else {
            int[] iArr2 = com.tencent.mm.cp.a.Rxa;
            p.g(iArr2, "ConstantsWxaPackageProto….PLUGINCODE_PACKAGE_TYPES");
            if (kotlin.a.e.contains(iArr2, i2)) {
                doo.MbW = null;
            } else {
                doo.MbW = bVar.cBp;
            }
        }
        doo.MbZ = bVar.packageType;
        doo.KXC = bVar.iOo;
        AppMethodBeat.o(180555);
        return doo;
    }
}
